package ch08;

import javax.swing.JLabel;

public class CountDownTask implements Runnable{
	// 카운트 다운 구현 클래스 
	
	// 필드
	private int count;
	private JLabel label;
	
	// 생성자
	CountDownTask(int count, JLabel label){
		this.count = count;
		this.label = label;
	}
	
	// 메서드
	@Override
	public void run() {
		label.setText(count+"");
		do {
			try {
				Thread.sleep(1000);
				label.setText(--count + "");
			} catch(InterruptedException e){
				label.setText("");
				break;
			}
			
		} while(count > 0);
	}
}
