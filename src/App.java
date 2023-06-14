import java.lang.reflect.InvocationTargetException;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.text.DefaultEditorKit;
import javax.swing.border.LineBorder;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    static Types manager = new Types();
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
    JButton switchBtn = new JButton();
    public KeypadWindow keypadWindow = new KeypadWindow(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            keypadEvent(e);
        }
    });
    int prevOpt1Index = 0, prevOpt2Index = 0;
    int theme = 0; // 0 - Light | 1 - Dark

    App() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        setTitle("DataConverter - Unit Convertion Tool");
        title.setText("Select a Unit:");
        setSize(400, 355);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(false);
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
        switchColor();
        setComponents();
        add(mainOpt);
        add(title, BorderLayout.CENTER);
        add(menu1);
        add(field1);
        add(menu2);
        add(field2);
        add(keypadBtn);
        add(switchBtn);
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
        keypadBtn.setBackground(null);
        keypadBtn.setBounds(330, 270, 40, 40);
        keypadBtn.setBorderPainted(false);
        keypadBtn.setFocusable(false);
        keypadBtn.setFocusPainted(false);
        switchBtn.setBackground(null);
        switchBtn.setBounds(10, 270, 40, 40);
        switchBtn.setBorderPainted(false);
        switchBtn.setFocusable(false);
        switchBtn.setFocusPainted(false);
        prevOpt1Index = menu1.getSelectedIndex();
        prevOpt2Index = menu2.getSelectedIndex();
    }

    public void switchColor() {
        try {
            // Light
            if (theme == 0) {
                switchBtn.setIcon(new ImageIcon(getClass().getResource("dark.png")));
                UIManager.setLookAndFeel(new FlatMacLightLaf());
                getContentPane().setBackground(Color.LIGHT_GRAY);
                title.setForeground(Color.BLACK);
                mainOpt.setBorder(new LineBorder(Color.DARK_GRAY));
                mainOpt.setBackground(new Color(200, 200, 200));
                mainOpt.setForeground(Color.BLACK);
            }
            // Dark
            else if (theme == 1) {
                switchBtn.setIcon(new ImageIcon(getClass().getResource("light.png")));
                UIManager.setLookAndFeel(new FlatMacDarkLaf());
                getContentPane().setBackground(new Color(66, 69, 73));
                title.setForeground(Color.WHITE);
                mainOpt.setBorder(new LineBorder(Color.BLACK));
                mainOpt.setBackground(Color.DARK_GRAY);
                mainOpt.setForeground(Color.WHITE);
            }
            keypadWindow.switchTheme(theme);
            menu1.setBorder(mainOpt.getBorder());
            menu2.setBorder(mainOpt.getBorder());
            menu1.setBackground(mainOpt.getBackground());
            menu2.setBackground(mainOpt.getBackground());
            menu1.setForeground(mainOpt.getForeground());
            menu2.setForeground(mainOpt.getForeground());
            field1.setForeground(mainOpt.getForeground());
            field2.setForeground(mainOpt.getForeground());
            field1.setBackground(mainOpt.getBackground());
            field2.setBackground(mainOpt.getBackground());
        }
        catch (UnsupportedLookAndFeelException e) {
            return;
        }
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
        else if ((in >= '0' && in <= '9') || in == '.' || in == 'e') {
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
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}