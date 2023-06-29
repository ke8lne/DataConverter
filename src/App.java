import java.lang.reflect.InvocationTargetException;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.border.LineBorder;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.text.*;
import KentHipos.Kensoft;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unchecked")
public class App extends JFrame {
    JPanel mainPanel = new JPanel(), menu = new JPanel(new GridLayout(5, 1)), resultsPane = new JPanel(new BorderLayout(3, 3));
    Types manager = new Types();
    Font font = new Font("Consolas", 1, 16);
    JComboBox<String> mainOpt = new JComboBox<String>(manager.namesList.toArray(new String[] {}));
    JComboBox<String> menu1 = new JComboBox<String>();
    JComboBox<String> menu2 = new JComboBox<String>();
    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    JLabel title = new JLabel("", SwingConstants.CENTER);
    JTextPane box = new JTextPane();
    JButton keypadBtn = new JButton(new ImageIcon(getClass().getResource("assets/numpad.png")));
    JButton switchBtn = new JButton();
    JButton menuButton = new JButton(new ImageIcon(getClass().getResource("assets/menu.png")));
    JButton expandBtn = new JButton();
    NumpadWindow keypadWindow = new NumpadWindow(e -> inputType(e.getActionCommand() == "Del" ? '\b' : e.getActionCommand().charAt(0)));
    int prevOpt1Index = 0, prevOpt2Index = 0;
    List<String> previousField = new ArrayList<String>(25);
    static int theme = 1; // 0 - Light | 1 - Dark

    App() {
        setIconImage(new ImageIcon(getClass().getResource("assets/icon.png")).getImage());
        setTitle("UnitConvert - Data Convertion Tool");
        title.setText("Select a Unit:");
        initEvents();
        setSize(400, 355);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setFocusTraversalKeysEnabled(false);
        menuAction();
        switchColor();
        setComponents();
        mainPanel.add(mainOpt);
        mainPanel.add(title, BorderLayout.CENTER);
        mainPanel.add(box);
        mainPanel.add(menu1);
        mainPanel.add(field1);
        mainPanel.add(menu2);
        mainPanel.add(field2);
        mainPanel.add(expandBtn);
        menu.add(keypadBtn);
        menu.add(switchBtn);
        add(menuButton);
        add(mainPanel);
        add(menu);
        add(resultsPane);
        renderLabel();
        setLayout(null);
        setVisible(true);
    }

    // Ignore the contents
    void initEvents() {
        mainOpt.addActionListener(event -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < manager.typesList.get(mainOpt.getSelectedIndex()).size(); i++) {
                String symbol = manager.symbolsList.get(mainOpt.getSelectedIndex()).get(i);
                list.add(manager.typesList.get(mainOpt.getSelectedIndex()).get(i) + (symbol != null ? " (" + symbol + ")" : ""));
            }
            menu1.setModel(new DefaultComboBoxModel<String>(list.toArray(new String[] {})));
            menu2.setModel(new DefaultComboBoxModel<String>(list.toArray(new String[] {})));
            menu2.setSelectedIndex(1);
            field1.setText(null);
            field2.setText(null);
            updateExpandedResults();
            field1.requestFocus();
            renderLabel();
        });
        menu1.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.DESELECTED)
                prevOpt1Index = manager.typesList.get(mainOpt.getSelectedIndex()).indexOf(event.getItem());
            else if (event.getStateChange() == ItemEvent.SELECTED)
                if (menu1.getSelectedIndex() == menu2.getSelectedIndex())
                    menu2.setSelectedIndex(prevOpt1Index == -1 ? 0 : prevOpt1Index);
            updateInteraction();
            field1.requestFocus();
            renderLabel();
        });
        menu2.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.DESELECTED)
                prevOpt2Index = manager.typesList.get(mainOpt.getSelectedIndex()).indexOf(event.getItem());
            else if (event.getStateChange() == ItemEvent.SELECTED)
                if (menu2.getSelectedIndex() == menu1.getSelectedIndex())
                    menu1.setSelectedIndex(prevOpt2Index == -1 ? 0 : prevOpt2Index);
            updateInteraction();
            field1.requestFocus();
            renderLabel();
        });
        field1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!inputType(e.getKeyChar()))
                    e.consume();
            }
        });
        addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                field1.requestFocus(true);
            }

            public void focusLost(FocusEvent e) {
                field1.requestFocus(true);
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                field1.requestFocus();
            }
        });
        keypadWindow.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!inputType(e.getKeyChar()))
                    e.consume();
            }
        });
        keypadBtn.addActionListener(event -> {
            keypadWindow.setVisible(!keypadWindow.isVisible());
            requestFocus(true);
        });
        switchBtn.addActionListener(event -> {
            theme = theme == 0 ? 1 : 0;
            switchColor();
        });
        menuButton.addActionListener(event -> menuAction());
        expandBtn.addActionListener(event -> expandResults());
    }

    // Ignore the contents
    public void setComponents() {
        DefaultListCellRenderer itemsRenderer = new DefaultListCellRenderer();
        SimpleAttributeSet att = new SimpleAttributeSet();
        StyleConstants.setAlignment(att, StyleConstants.ALIGN_CENTER);
        itemsRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        title.setFont(font);
        title.setBounds(40, 20, 300, 20);
        mainOpt.setSelectedIndex(0);
        mainOpt.setMaximumRowCount(8);
        mainOpt.setBounds(40, 40, 300, 30);
        mainOpt.setRenderer(itemsRenderer);
        box.setBounds(40, 90, 300, 30);
        box.setFont(font);
        box.setEditable(false);
        box.setFocusable(false);
        box.getStyledDocument().setParagraphAttributes(0, box.getStyledDocument().getLength(), att, false);
        menu1.setSelectedIndex(0);
        menu1.setMaximumRowCount(8);
        menu1.setBounds(55, 140, 270, 30);
        menu1.setRenderer(itemsRenderer);
        menu2.setSelectedIndex(1);
        menu2.setMaximumRowCount(8);
        menu2.setBounds(55, 230, 270, 30);
        menu2.setRenderer(itemsRenderer);
        field1.getActionMap().get(DefaultEditorKit.deletePrevCharAction).setEnabled(false);
        field1.setEditable(false);
        field1.setFocusable(true);
        field1.setHorizontalAlignment(JTextField.CENTER);
        field1.setFont(font);
        field1.setBounds(55, 173, 270, 40);
        field1.requestFocus();
        field2.setEditable(false);
        field2.setFocusable(false);
        field2.setHorizontalAlignment(JTextField.CENTER);
        field2.setFont(font);
        field2.setBounds(55, 263, 270, 40);
        keypadWindow.setLocation(getX() + getWidth(), getY());
        keypadBtn.setText("Numpad");
        keypadBtn.setToolTipText("Open a virtual numpad");
        keypadBtn.setBackground(null);
        keypadBtn.setFocusable(false);
        keypadBtn.setFocusPainted(false);
        switchBtn.setBackground(null);
        switchBtn.setFocusable(false);
        switchBtn.setFocusPainted(false);
        menuButton.setBackground(null);
        menuButton.setBounds(3, 275, 40, 40);
        menuButton.setBorderPainted(false);
        menuButton.setFocusable(false);
        menuButton.setFocusPainted(false);
        expandBtn.setIcon(new ImageIcon(getClass().getResource("assets/" + (resultsPane.isVisible() ? "right" : "left") + " arrow.png")));
        expandBtn.setToolTipText((resultsPane.isVisible() ? "Expand" : "Close") + " Convertion Results");
        expandBtn.setBackground(null);
        expandBtn.setBounds(330, 225, 40, 40);
        expandBtn.setBorderPainted(false);
        expandBtn.setFocusable(false);
        expandBtn.setFocusPainted(false);
        mainPanel.setLayout(null);
        mainPanel.setBorder(null);
        mainPanel.setSize(getWidth(), getHeight());
        mainPanel.setVisible(true);
        resultsPane.setBounds(385, 0, getWidth() - 200, getHeight() - 38);
        resultsPane.setFocusable(false);
        resultsPane.setBackground(getContentPane().getBackground());
        mainPanel.setSize(getWidth() - 15, getHeight());
        menu.setSize(getWidth() - 15, getHeight());
        menu.setVisible(false);
        mainPanel.setVisible(true);
        resultsPane.setVisible(false);
        prevOpt1Index = menu1.getSelectedIndex();
        prevOpt2Index = menu2.getSelectedIndex();
    }

    void renderLabel() {
        box.setText(null);
        StyledDocument doc = box.getStyledDocument();
        List<String> typeList = manager.typesList.get(mainOpt.getSelectedIndex());
        try {
            String iconPath = "assets/" + manager.namesList.get(mainOpt.getSelectedIndex()).toLowerCase() + ".png";
            box.insertIcon(new ImageIcon(getClass().getResource(iconPath)));
            String type1 = typeList.get(menu1.getSelectedIndex());
            String type2 = typeList.get(menu2.getSelectedIndex());
            String symbol1 = manager.symbolsList.get(mainOpt.getSelectedIndex()).get(menu1.getSelectedIndex());
            String symbol2 = manager.symbolsList.get(mainOpt.getSelectedIndex()).get(menu2.getSelectedIndex());
            doc.insertString(doc.getLength(), " = " + (symbol1 != null ? symbol1 : type1.length() > 7 ? "\"Unit_1\"" : type1) + " \u2192 " + (symbol2 != null ? symbol2 : type2.length() > 7 ? "\"Unit_2\"" : type2), null);
        }
        catch (BadLocationException | IndexOutOfBoundsException e) {
        }
    }

    void updateExpandedResults() {
        if (!resultsPane.isVisible()) return;
        resultsPane.removeAll();
        List<String> items = new ArrayList<>();
        Double value = (field1.getText().length() > 0) ? Double.valueOf(field1.getText().trim().replaceAll(",", "")) : 0;
        for (int i = 0; i < manager.typesList.get(mainOpt.getSelectedIndex()).size(); i++) {
            Double result = convert(manager.converters[mainOpt.getSelectedIndex()], mainOpt.getSelectedIndex(), menu1.getSelectedIndex(), i, value);
            String symbol = manager.symbolsList.get(mainOpt.getSelectedIndex()).get(i);
            String item = "<html><b>" + (symbol != null ? "(" + symbol + ") " : "") + manager.typesList.get(mainOpt.getSelectedIndex()).get(i) + "</b><br>" + new DecimalFormat("#,###.###################").format(result)
                    + "</html>";
            items.add(item);
        }
        JList<String> list = new JList<String>(items.toArray(new String[] {}));
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setFocusable(false);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(menu2.getSelectedIndex());
        list.setFont(new Font("Consolas", Font.BOLD, 10));
        list.addListSelectionListener(e -> {
            JList<String> obj = (JList<String>) e.getSource();
            menu2.setSelectedIndex(obj.getSelectedIndex());
            list.ensureIndexIsVisible(obj.getSelectedIndex());
        });
        list.ensureIndexIsVisible(menu2.getSelectedIndex());
        resultsPane.add(pane);
        SwingUtilities.updateComponentTreeUI(resultsPane);
    }

    void expandResults() {
        if (resultsPane.isVisible()) {
            resultsPane.setVisible(false);
            int oldWidth = getWidth() - 200;
            for (int i = getWidth(); i >= oldWidth; i -= 50) {
                setSize(i, getHeight());
                update(getGraphics());
            }
        }
        else {
            resultsPane.setVisible(true);
            int doubledWidth = getWidth() + 250;
            for (int i = getWidth(); i < doubledWidth; i += 50) {
                setSize(i, getHeight());
                update(getGraphics());
            }
            updateExpandedResults();
        }
        expandBtn.setIcon(new ImageIcon(getClass().getResource("assets/" + (resultsPane.isVisible() ? "left" : "right") + " arrow.png")));
        expandBtn.setToolTipText((resultsPane.isVisible() ? "Close" : "Expand") + " Convertion Results");
    }

    public void menuAction() {
        // Visible
        if (menu.isVisible()) {
            mainPanel.setBounds(mainPanel.getX(), -getHeight(), mainPanel.getWidth(), mainPanel.getHeight());
            new Kensoft().jPanelYDown(mainPanel.getY(), 0, 3, 5, mainPanel);
            menuButton.setToolTipText("Menu");
            menuButton.setIcon(new ImageIcon(getClass().getResource("assets/menu.png")));
            menu.setVisible(false);
            mainPanel.setVisible(true);
        }
        else {
            menu.setBounds(menu.getX(), getHeight(), menu.getWidth(), menu.getHeight());
            new Kensoft().jPanelYUp(menu.getY(), 0, 3, 5, menu);
            menuButton.setToolTipText("Back");
            menuButton.setIcon(new ImageIcon(getClass().getResource("assets/cancel.png")));
            menu.setVisible(true);
            mainPanel.setVisible(false);
        }
        field1.requestFocus();
    }

    public void switchColor() {
        menu.setBounds(-getWidth(), menu.getY(), menu.getWidth(), menu.getHeight());
        new Kensoft().jPanelXRight(menu.getX(), 0, 1, 6, menu);
        // Light
        if (theme == 0) {
            switchBtn.setText("Dark Mode");
            switchBtn.setToolTipText("Switch to Dark Mode Theme");
            switchBtn.setIcon(new ImageIcon(getClass().getResource("assets/dark.png")));
            FlatMacLightLaf.setup();
            getContentPane().setBackground(Color.LIGHT_GRAY);
            title.setForeground(Color.BLACK);
            mainOpt.setBorder(new LineBorder(Color.DARK_GRAY));
            mainOpt.setBackground(new Color(200, 200, 200));
            mainOpt.setForeground(Color.BLACK);
            field1.setBackground(new Color(230, 230, 230));
            menu.setBackground(new Color(200, 200, 200));
        }
        // Dark
        else if (theme == 1) {
            switchBtn.setText("Light Mode");
            switchBtn.setToolTipText("Switch to Light Mode Theme");
            switchBtn.setIcon(new ImageIcon(getClass().getResource("assets/light.png")));
            FlatMacDarkLaf.setup();
            getContentPane().setBackground(new Color(66, 66, 66));
            title.setForeground(Color.WHITE);
            mainOpt.setBorder(new LineBorder(Color.BLACK));
            mainOpt.setBackground(Color.DARK_GRAY);
            mainOpt.setForeground(Color.WHITE);
            field1.setBackground(mainOpt.getBackground());
            menu.setBackground(new Color(66, 66, 66));
        }
        keypadWindow.switchTheme(theme);
        box.setBackground(getContentPane().getBackground());
        mainPanel.setBackground(getContentPane().getBackground());
        resultsPane.setBackground(getContentPane().getBackground());
        menu.setBorder(mainOpt.getBorder());
        menu1.setBorder(mainOpt.getBorder());
        menu2.setBorder(mainOpt.getBorder());
        menu1.setBackground(mainOpt.getBackground());
        menu2.setBackground(mainOpt.getBackground());
        menu1.setForeground(mainOpt.getForeground());
        menu2.setForeground(mainOpt.getForeground());
        field1.setForeground(mainOpt.getForeground());
        field2.setForeground(mainOpt.getForeground());
        field2.setBackground(field1.getBackground());
        keypadBtn.setForeground(mainOpt.getForeground());
        switchBtn.setForeground(mainOpt.getForeground());
        SwingUtilities.updateComponentTreeUI(this);
    }

    boolean inputType(char input) {
        if (field1.getText().length() >= 25 && !(input == KeyEvent.VK_BACK_SPACE || input == 'C' || input == 'U'))
            return false;
        switch (input) {
        case KeyEvent.VK_ENTER:
            updateInteraction();
            return false;
        case KeyEvent.VK_BACK_SPACE:
            field1.setText(field1.getText().length() == 0 ? null : field1.getText().substring(0, (field1.getText().length() - 1)));
            if (field1.getText().length() > 0)
                updateInteraction();
            else if (field1.getText().length() == 0) {
                field2.setText(null);
                updateExpandedResults();
            }
            break;
        case 'U': // Undo
            if (previousField.size() > 0) {
                String prevFIeld = previousField.remove(previousField.size() == 1 ? 0 : previousField.size() - 1);
                field1.setText(prevFIeld);
            }
            if (field1.getText().length() == 0)
                field2.setText(null);
            updateExpandedResults();
            updateInteraction();
            return true;
        case 'C': // Clear
            previousField.add("");
            previousField.add(field1.getText());
            field1.setText(null);
            field2.setText(null);
            updateExpandedResults();
            return true;
        case '.':
            if (field1.getText().contains("."))
                return false;
            break;
        case '-':
            if (field1.getText().contains("-") || field1.getText().length() > 0)
                return false;
            break;
        case '0':
            if (field1.getText().length() == 0)
                return false;
            break;
        }
        previousField.add(field1.getText());
        if ((input >= '0' && input <= '9') || input == '.' || input == '-') {
            field1.setText(field1.getText().length() == 0 && (input == '.') ? "0." : field1.getText() + input);
            updateInteraction();
        }
        else
            return false;
        return true;
    }

    public void updateInteraction() {
        double value = 0, result = 0;
        int mainOptIndex = mainOpt.getSelectedIndex();
        int opt1 = menu1.getSelectedIndex(), opt2 = menu2.getSelectedIndex();
        try {
            value = Double.valueOf(field1.getText().trim().replaceAll(",", ""));
        }
        catch (NumberFormatException err) {
            return;
        }
        if (opt1 == opt2)
            result = value;
        else
            result = convert(manager.converters[mainOptIndex], mainOptIndex, opt1, opt2, value);
        String resultString = new DecimalFormat("#,###.###").format(result);
        field2.setText((resultString.replaceAll("E0", "")));
        updateExpandedResults();
        renderLabel();
    }

    public double convert(Object converter, int converterIndex, int fromIndex, int toIndex, double value) {
        double result = 0;
        try {
            Method base = converter.getClass().getMethod("from" + manager.typesList.get(converterIndex).get(fromIndex), double.class);
            Object resolve = base.invoke(converter, value);
            result = (double) resolve.getClass().getMethod("to" + manager.typesList.get(converterIndex).get(toIndex)).invoke(resolve);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        } ;
        return result;
    }

    public static void main(String... args) {
        if (theme == 0)
            FlatMacLightLaf.setup();
        else if (theme == 1)
            FlatMacDarkLaf.setup();
        UIManager.put("ScrollBar.width", 25);
        SwingUtilities.invokeLater(() -> new App());
    }
}