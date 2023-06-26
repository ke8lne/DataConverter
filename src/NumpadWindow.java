import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import KentHipos.Kensoft;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class NumpadWindow extends JFrame {
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
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				startWindow(listener);
			}
		});
	}
}
