import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import KentHipos.Kensoft;
import java.awt.Color;
import java.awt.Font;

public class NumpadWindow extends JFrame {
	JPanel btns = new JPanel(new GridLayout(5, 3));

	public void startWindow(ActionListener listener) {
		setTitle(null);
		setIconImage(new ImageIcon(getClass().getResource("assets/numpad.png")).getImage());
		setResizable(true);
		setDefaultLookAndFeelDecorated(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(250, 355);
		setMinimumSize(getSize());
		setMaximumSize(new Dimension(500, 600)); // - Buggy Method
		setLayout(new BorderLayout());
		String keys[] = {
				"Undo", "Clear", "-", "7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "\u232B"
		};
		for (int i = 0; i < keys.length; i++) {
			JButton btn = new JButton(keys[i]);
			if (keys[i].length() == 0) btn.setEnabled(false);
			btn.setFocusable(false);
			btn.addActionListener(listener);
			btn.setFont(new Font("Comic Sans", 1, 15));
			btns.add(btn);
		}
		add(btns, BorderLayout.CENTER);
	}

	public void switchTheme(int theme) {
		btns.setBounds(-400, btns.getY(), btns.getWidth(), btns.getHeight());
		btns.update(btns.getGraphics());
		new Kensoft().jPanelXRight(btns.getX(), 0, 1, 4, btns);
		if (theme == 0) {
			for (Component btn : btns.getComponents()) {
				btn.setBackground(new Color(200, 200, 200));
				btn.setForeground(Color.BLACK);
				btn.update(btn.getGraphics());
			}
			SwingUtilities.updateComponentTreeUI(this);
		}
		else if (theme == 1) {
			for (Component btn : btns.getComponents()) {
				btn.setBackground(new Color(66, 66, 66));
				btn.update(btn.getGraphics());
				btn.setForeground(Color.WHITE);
			}
			SwingUtilities.updateComponentTreeUI(this);
		}
	}

	NumpadWindow(ActionListener listener) {
		SwingUtilities.invokeLater(() -> startWindow(listener));
	}
}
