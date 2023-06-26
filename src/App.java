import java.lang.reflect.InvocationTargetException;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.text.DefaultEditorKit;
import javax.swing.border.LineBorder;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import KentHipos.Kensoft;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    JPanel mainPanel = new JPanel(), menu = new JPanel(new GridLayout(5, 1));
    Types manager = new Types();
    List<String> mainOptions = manager.namesList;
    List<List<String>> options = manager.typesList;
    Font font = new Font("Consolas", 1, 16);
    JComboBox<String> mainOpt = new JComboBox<String>(mainOptions.toArray(new String[] {}));
    JComboBox<String> menu1 = new JComboBox<String>();
    JComboBox<String> menu2 = new JComboBox<String>();
    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    JLabel title = new JLabel("", SwingConstants.CENTER);
    JButton keypadBtn = new JButton(new ImageIcon(getClass().getResource("numpad.png")));
    JButton switchBtn = new JButton(), menuButton = new JButton(new ImageIcon(getClass().getResource("menu.png")));
    KeypadWindow keypadWindow = new KeypadWindow(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            keypadEvent(e);
        }
    });
    int prevOpt1Index = 0, prevOpt2Index = 0;
    static int theme = 0; // 0 - Light | 1 - Dark

    App() {
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        setTitle("DataConverter - Unit Convertion Tool");
        title.setText("Select a Unit:");
        setSize(400, 355);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        mainOpt.addActionListener(event -> {
            menu1.setModel(new DefaultComboBoxModel<String>(options.get(mainOpt.getSelectedIndex()).toArray(new String[] {})));
            menu2.setModel(new DefaultComboBoxModel<String>(options.get(mainOpt.getSelectedIndex()).toArray(new String[] {})));
            menu2.setSelectedIndex(1);
            field1.setText(null);
            field2.setText(null);
            field1.requestFocus();
        });
        menu1.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.DESELECTED)
                prevOpt1Index = manager.typesList.get(mainOpt.getSelectedIndex()).indexOf(event.getItem());
            else if (event.getStateChange() == ItemEvent.SELECTED)
                if (menu1.getSelectedIndex() == menu2.getSelectedIndex())
                    menu2.setSelectedIndex(prevOpt1Index);
            updateInteraction();
            field1.requestFocus();
        });
        menu2.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.DESELECTED)
                prevOpt2Index = manager.typesList.get(mainOpt.getSelectedIndex()).indexOf(event.getItem());
            else if (event.getStateChange() == ItemEvent.SELECTED)
                if (menu2.getSelectedIndex() == menu1.getSelectedIndex())
                    menu1.setSelectedIndex(prevOpt2Index);
            updateInteraction();
            field1.requestFocus();
        });
        field1.getActionMap().get(DefaultEditorKit.deletePrevCharAction).setEnabled(false);
        field1.setEditable(false);
        field1.setFocusable(true);
        field1.requestFocus();
        field2.setEditable(false);
        field2.setFocusable(false);
        setFocusTraversalKeysEnabled(false);
        field1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                keyEvent(e);
            }
        });
        addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                field1.requestFocus(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                field1.requestFocus(true);
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                field1.requestFocus();
            }
        });
        keypadBtn.addActionListener(event -> {
            keypadWindow.setVisible(!keypadWindow.isVisible());
            keypadWindow.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    keyEvent(e);
                }
            });
            requestFocus(true);
        });
        switchBtn.addActionListener(event -> {
            theme = theme == 0 ? 1 : 0;
            switchColor();
        });
        menuButton.addActionListener(event -> menuAction());
        menuAction();
        switchColor();
        setComponents();
        mainPanel.add(mainOpt);
        mainPanel.add(title, BorderLayout.CENTER);
        mainPanel.add(menu1);
        mainPanel.add(field1);
        mainPanel.add(menu2);
        mainPanel.add(field2);
        menu.add(keypadBtn);
        menu.add(switchBtn);
        add(menuButton);
        add(mainPanel);
        add(menu);
        setLayout(null);
        setVisible(true);
    }

    public void setComponents() {
        DefaultListCellRenderer itemsRenderer = new DefaultListCellRenderer();
        itemsRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        title.setFont(font);
        title.setBounds(40, 20, 300, 20);
        mainOpt.setSelectedIndex(0);
        mainOpt.setMaximumRowCount(8);
        mainOpt.setBounds(40, 40, 300, 30);
        mainOpt.setRenderer(itemsRenderer);
        menu1.setSelectedIndex(0);
        menu1.setMaximumRowCount(8);
        menu1.setBounds(65, 100, 250, 30);
        menu1.setRenderer(itemsRenderer);
        field1.setHorizontalAlignment(JTextField.CENTER);
        field1.setFont(font);
        field1.setBounds(65, 133, 250, 40);
        menu2.setSelectedIndex(1);
        menu2.setMaximumRowCount(8);
        menu2.setBounds(65, 190, 250, 30);
        menu2.setRenderer(itemsRenderer);
        field2.setHorizontalAlignment(JTextField.CENTER);
        field2.setFont(font);
        field2.setBounds(65, 223, 250, 40);
        keypadBtn.setText("Numpad");
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
        mainPanel.setLayout(null);
        mainPanel.setSize(getWidth(), getHeight());
        mainPanel.setVisible(true);
        menu.setSize(getWidth() - 15, getHeight());
        menu.setVisible(false);
        prevOpt1Index = menu1.getSelectedIndex();
        prevOpt2Index = menu2.getSelectedIndex();
    }

    public void menuAction() {
        // Visible
        if (menu.isVisible()) {
            field1.setText(null);
            field2.setText(null);
            mainPanel.setBounds(mainPanel.getX(), -getHeight(), mainPanel.getWidth(), mainPanel.getHeight());
            new Kensoft().jPanelYDown(mainPanel.getY(), 0, 3, 5, mainPanel);
            menuButton.setIcon(new ImageIcon(getClass().getResource("menu.png")));
            menu.setVisible(false);
            mainPanel.setVisible(true);
        }
        else {
            menu.setBounds(menu.getX(), getHeight(), menu.getWidth(), menu.getHeight());
            new Kensoft().jPanelYUp(menu.getY(), 0, 3, 5, menu);
            menuButton.setIcon(new ImageIcon(getClass().getResource("cancel.png")));
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
            switchBtn.setIcon(new ImageIcon(getClass().getResource("dark.png")));
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
            switchBtn.setIcon(new ImageIcon(getClass().getResource("light.png")));
            FlatDarculaLaf.setup();
            getContentPane().setBackground(new Color(66, 66, 66));
            title.setForeground(Color.WHITE);
            mainOpt.setBorder(new LineBorder(Color.BLACK));
            mainOpt.setBackground(Color.DARK_GRAY);
            mainOpt.setForeground(Color.WHITE);
            field1.setBackground(mainOpt.getBackground());
            menu.setBackground(new Color(66, 66, 66));
        }
        keypadWindow.switchTheme(theme);
        mainPanel.setBackground(getContentPane().getBackground());
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

    public void keypadEvent(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        switch (btn.getText()) {
        case "Del":
            field1.setText(field1.getText().length() == 0 ? null : field1.getText().substring(0, (field1.getText().length() - 1)));
            break;
        case ".":
            if (field1.getText().contains("."))
                break;
            else
                field1.setText(field1.getText().length() == 0 ? "0." : field1.getText() + ".");
            break;
        default:
            if (btn.getText() == "0" && field1.getText().length() == 0)
                break;
            field1.setText(field1.getText() + btn.getText());
            break;
        }
        if (field1.getText().length() == 0)
            field2.setText(null);
        updateInteraction();
    }

    public void keyEvent(KeyEvent e) {
        char in = e.getKeyChar();
        if (in == KeyEvent.VK_ENTER) {
            updateInteraction();
            e.consume();
        }
        else if (in == KeyEvent.VK_BACK_SPACE) {
            field1.setText(field1.getText().length() == 0 ? null : field1.getText().substring(0, (field1.getText().length() - 1)));
            if (field1.getText().length() > 0)
                updateInteraction();
            else if (field1.getText().length() == 0)
                field2.setText(null);
        }
        else if (in == '.' && field1.getText().contains("."))
            e.consume();
        else if (in == '0' && field1.getText().length() == 0)
            e.consume();
        else if ((in >= '0' && in <= '9') || in == '.') {
            field1.setText(field1.getText().length() == 0 && (in == '.' || in == 'e') ? "0." : field1.getText() + in);
            updateInteraction();
        }
        else
            e.consume();
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
        field2.setText(new DecimalFormat("#,###.####################").format(result));
    }

    public double convert(Object converter, int converterIndex, int fromIndex, int toIndex, double value) {
        double result = 0;
        try {
            Method base = converter.getClass().getMethod("from" + options.get(converterIndex).get(fromIndex), double.class);
            Object resolve = base.invoke(converter, value);
            result = (double) resolve.getClass().getMethod("to" + options.get(converterIndex).get(toIndex)).invoke(resolve);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String... args) {
        if (theme == 0) FlatMacLightLaf.setup();
        else if (theme == 1) FlatDarculaLaf.setup();
        UIManager.put("ScrollBar.width", 25);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}