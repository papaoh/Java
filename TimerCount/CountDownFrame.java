package ch08;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/* ������ �Է¹޾� ī��Ʈ �ϴ� ���α׷� �ۼ�
 * - ����Ǵ� ���߿� "����" ��ư�� ������ ī��Ʈ �ٿ��� �����ǰ� ȭ���� �ٽ� 0���� �ʱ�ȭ �ȴ�.
 * - ȭ�� UI�� ���� Thread�� ���
 * - ī��Ʈ �ٿ� �۾��� �ٸ� Thread�� ���
 */

public class CountDownFrame extends JFrame implements ActionListener{
	// �ʵ�
	private JTextField input;
	JButton btnStart;
	JButton btnStop;
	JLabel outLabel;
	Thread thread;
	
	// ������
	public CountDownFrame() {
		setSize(250, 200);  // ũ�� ����(����, ����)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CountDown Frame");  // ����
		input = new JTextField(8);
		btnStart = new JButton("����");
		btnStop = new JButton("����");
		outLabel = new JLabel();
		outLabel.setFont(new Font("Serif", Font.BOLD, 100));  // ��Ʈ�� text ����
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		setLayout(new FlowLayout());
		add(input);
		add(btnStart);
		add(btnStop);
		add(outLabel);
	}
	
	// �޼���
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnStart) {
			int n = Integer.parseInt(input.getText());
			thread = new Thread(new CountDownTask(n, outLabel));
			thread.start();
		} else if(e.getSource() == btnStop) {
			if(thread != null && thread.isAlive()) {
				input.setText("");
				thread.interrupt();  // ����
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new CountDownFrame()).setVisible(true);
	}


	

}
