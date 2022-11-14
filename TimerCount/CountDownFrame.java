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

/* 정수를 입력받아 카운트 하는 프로그램 작성
 * - 진행되는 도중에 "중지" 버튼을 누르면 카운트 다운이 중지되고 화면이 다시 0으로 초기화 된다.
 * - 화면 UI는 메인 Thread가 담당
 * - 카운트 다운 작업은 다른 Thread가 담당 (다른 java 소스파일)
 */

public class CountDownFrame extends JFrame implements ActionListener{
	// 필드
	private JTextField input;
	JButton btnStart;
	JButton btnStop;
	JLabel outLabel;
	Thread thread;
	
	// 생성자
	public CountDownFrame() {
		setSize(250, 200);  // 크기 지정(가로, 세로)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CountDown Frame");  // 제목
		input = new JTextField(8);
		btnStart = new JButton("시작");
		btnStop = new JButton("중지");
		outLabel = new JLabel();
		outLabel.setFont(new Font("Serif", Font.BOLD, 100));  // 폰트와 text 지정
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		setLayout(new FlowLayout());
		add(input);
		add(btnStart);
		add(btnStop);
		add(outLabel);
	}
	
	// 메서드
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
				thread.interrupt();  // 중지
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new CountDownFrame()).setVisible(true);
	}


	

}
