package ch08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);  // ��ĳ�� Ŭ���� ����
		System.out.println("���� �̸���? ");
		
		// ������ �̸��� ������ ��ü���� ����
		String filename = input.nextLine().trim();  // ������ �̸��� �Է¹ޱ�
		Scanner fileInput = null;
		
		// ����ó����
		try {
			fileInput = new Scanner(new File(filename));  // �Է¹��� �����̸��� �˸´� ���� ����
			
		} catch(FileNotFoundException e){  // ���� ������ ã�� ���ߴٸ� 
			System.out.println(filename + " ������ ���� ���߽��ϴ�.");
			System.exit(0);
		}
		while(fileInput.hasNext()) {  // ���Ͼȿ� �����͸� �б�
			System.out.println(fileInput.nextLine());
		}
		fileInput.close();  // ����� ���� �ݾ��ֱ�
	}

}
