package ch08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintWriterDemo {
	/* ������ ����� ���α׷�
	   Scanner(), System.read()  -->
	   FileReader���� �ؽ�Ʈ ������ �Է¿����� nextLine �Ǵ� nextInt �� �޼����� ����� �����ϴ�.
	   Scanner Ŭ������ �̿��Ͽ� File ��ü�� ����ϸ�
	   Scanner fileInput = new Scanner(new File("input.txt"));
	      �� �ڵ� ó�� ���ϰ� �ڵ带 �ۼ��� �� �ִ�. 
	   But ����ó���� �ʿ� (FileNotFoundException ó���ʿ�)
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);  // ��ĳ�� Ŭ���� ����
		System.out.println("���� �̸���?");  //��� ���� �������� ��������⿡ .txt�� �ٿ��شٸ� �޸������� ���������.
		
		String filename =input.nextLine().trim();  // trim�� ���� ��ĭ �����
		
		PrintWriter outWriter = null;
		
		// ���� ó����
		try {
			outWriter = new PrintWriter(filename);  // �Է¹��� �̸��� ���� ����
			
		} catch(FileNotFoundException e){  // ���� ������ ���� ���ߴٸ�
			System.out.println(filename + "�� ���� ���߽��ϴ�.");
			System.exit(0);
		}
		
		System.out.println("�ؽ�Ʈ�� �Է��ϼ���(���� ���� �Է¾��� enterŰ �Է�)");
		String line = input.nextLine();
		while(line.length() > 0) {  // ���� text�� �Է��ϰ� �ִٸ�
			outWriter.println(line); 
			line = input.nextLine();  
		}
		
		outWriter.close();  // ���� ���� �ݱ�
		System.out.println(filename + "������ �����Ǿ����ϴ�.");
	}

}
