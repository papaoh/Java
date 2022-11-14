package ch08;

import javax.swing.JLabel;

public class CountDownTask implements Runnable{
	// ī��Ʈ �ٿ� ���� Ŭ����
	
	// �ʵ�
	private int count;
	private JLabel label;
	
	// ������
	CountDownTask(int count, JLabel label){
		this.count = count;
		this.label = label;
	}
	
	// �޼���
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
