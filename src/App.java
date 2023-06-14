import java.lang.reflect.InvocationTargetException;
import javax.swing.text.DefaultEditorKit;
import com.digidemic.unitof.S;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    static Types manager = new Types();
    static List<String> mainOptions = manager.namesList;
    static List<List<String>> options = manager.typesList;
    static Font font = new Font("Consolas", 1, 13);
    static JComboBox<String> mainOpt = new JComboBox<String>(mainOptions.toArray(new String[] {}));
    static JComboBox<String> menu1 = new JComboBox<String>();
    static JComboBox<String> menu2 = new JComboBox<String>();
    static JTextField field1 = new JTextField();
    static JTextField field2 = new JTextField();
    static JLabel title = new JLabel("", SwingConstants.CENTER);
    static JButton keypadBtn = new JButton("Keypad");
    public KeypadWindow keypadWindow = new KeypadWindow(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            keypadEvent(e);
        }
    });
    static int prevOpt1Index = 0, prevOpt2Index = 0;

    App() {
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
            keypadWindow.setVisible(true);
            keypadWindow.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    keyEvent(e);
                }
            });
            requestFocus(true);
        });
        setComponents();
        add(mainOpt);
        add(title, BorderLayout.CENTER);
        add(menu1);
        add(field1);
        add(menu2);
        add(field2);
        add(keypadBtn);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }

    public static void setComponents() {
        DefaultListCellRenderer itemsRenderer = new DefaultListCellRenderer();
        itemsRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        title.setFont(font);
        title.setBounds(40, 20, 300, 20);
        mainOpt.setSelectedIndex(0);
        mainOpt.setMaximumRowCount(8);
        mainOpt.setBounds(40, 40, 300, 20);
        mainOpt.setRenderer(itemsRenderer);
        menu1.setSelectedIndex(0);
        menu1.setMaximumRowCount(8);
        menu1.setBounds(65, 100, 250, 20);
        menu1.setRenderer(itemsRenderer);
        field1.setHorizontalAlignment(JTextField.CENTER);
        field1.setFont(font);
        field1.setBounds(65, 123, 250, 40);
        menu2.setSelectedIndex(1);
        menu2.setMaximumRowCount(8);
        menu2.setBounds(65, 190, 250, 20);
        menu2.setRenderer(itemsRenderer);
        field2.setHorizontalAlignment(JTextField.CENTER);
        field2.setFont(font);
        field2.setBounds(65, 213, 250, 40);
        keypadBtn.setFont(new Font("Calibri", 1, 11));
        keypadBtn.setBounds(300, 275, 68, 30);
        keypadBtn.setFocusable(false);
        prevOpt1Index = menu1.getSelectedIndex();
        prevOpt2Index = menu2.getSelectedIndex();
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
            field1.setText(field1.getText().length() == 0 && in == '.' ? "0." : field1.getText() + in);
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
        field2.setText(new DecimalFormat("#,###.###############").format(result));
    }

    static double convert(Object converter, int converterIndex, int fromIndex, int toIndex, double value) {
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