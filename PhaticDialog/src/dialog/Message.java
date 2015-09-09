package dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Message {

	public static void main(String[] args) {

		Processing processing = new Processing();

		JFrame frame = new JFrame("Phatic Dialog");

		JPanel panel = new JPanel();

		panel.setLayout(null);

		JTextField tf1 = new JTextField();

		JLabel label = new JLabel(
				"Ви зайшли в службу підтримки бібліотеки НаУКМа.");

		JButton button = new JButton();

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(processing.answer(tf1.getText()));
				tf1.setText("");
			}

		});

		button.setText("Відправити");

		panel.add(label);
		label.setBounds(10, 10, 400, 50);
		panel.add(tf1);
		tf1.setBounds(10, 65, 300, 40);
		panel.add(button);
		button.setBounds(110, 120, 100, 30);

		frame.add(panel);
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}