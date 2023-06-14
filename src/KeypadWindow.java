import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeypadWindow extends JFrame {
	JPanel btns = new JPanel(new GridLayout(4, 3));

	public void startWindow(ActionListener listener) {
		setTitle(null);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(false);
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(226, 300);
		setMinimumSize(getSize());
		setMaximumSize(new Dimension(500, 600)); // - Buggy Method
		setLayout(new BorderLayout());
		String keys[] = {
				"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "Del"
		};
		for (int i = 0; i < 12; i++) {
			JButton btn = new JButton(keys[i]);
			btn.setFocusable(false);
			btn.addActionListener(listener);
			btn.setFont(new Font("Calibri", 1, 15));
			btns.add(btn);
		}
		add(btns, BorderLayout.CENTER);
	}

	public void switchTheme(int theme) {
		if (theme == 0) {
			for (Component btn : btns.getComponents()) {
				btn.setForeground(Color.BLACK);
				btn.setBackground(new Color(200, 200, 200));
			}
			SwingUtilities.updateComponentTreeUI(this);
		}
		else if (theme == 1) {
			for (Component btn : btns.getComponents()) {
				btn.setForeground(Color.WHITE);
				btn.setBackground(Color.DARK_GRAY);
			}
			SwingUtilities.updateComponentTreeUI(this);
		}
	}

	KeypadWindow(ActionListener listener) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				startWindow(listener);
			}
		});
	}
}
