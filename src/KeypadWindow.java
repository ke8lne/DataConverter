import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeypadWindow extends JFrame {
	public ActionListener parentListener;

	public void startWindow() {
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
			"7", "8", "9",
			"4", "5", "6",
			"1", "2", "3",
			"0", ".", "Del"
		};

		JPanel btns = new JPanel(new GridLayout(4, 3));
		for (int i = 0; i < 12; i++) {
			JButton btn = new JButton(keys[i]);
			btn.setFocusable(false);
			btn.addActionListener(parentListener);
			btns.add(btn);
		}
		add(btns, BorderLayout.CENTER);
	}

	KeypadWindow(ActionListener listener) {
		parentListener = listener;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				startWindow();
			}
		});
	}
}
