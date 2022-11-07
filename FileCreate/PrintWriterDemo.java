package ch08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintWriterDemo {
	/* 파일을 만드는 프로그램
	   Scanner(), System.read()  -->
	   FileReader보다 텍스트 파일의 입력에서는 nextLine 또는 nextInt 등 메서드의 사용이 용이하다.
	   Scanner 클래스를 이용하여 File 객체를 사용하면
	   Scanner fileInput = new Scanner(new File("input.txt")); 
	   위 코드 처럼 편리하게 코드를 작성할 수 있다. 
	   But 예외처리문 필요 (FileNotFoundException 처리필요)
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);  // 스캐너 클래스 선언
		System.out.println("파일 이름은?");  //모든 파일 형식으로 만들어지기에 .txt를 붙여준다면 메모장으로 만들어진다.
		
		String filename =input.nextLine().trim();  // trim의 뜻은 빈칸 지우기
		
		PrintWriter outWriter = null;
		
		// 예외 처리문
		try {
			outWriter = new PrintWriter(filename);  // 입력받은 이름의 파일 생성
			
		} catch(FileNotFoundException e){  // 만약 파일을 열지 못했다면
			System.out.println(filename + "를 열지 못했습니다.");
			System.exit(0);
		}
		
		System.out.println("텍스트를 입력하세요(끝낼 때는 입력없이 enter키 입력)");
		String line = input.nextLine();
		while(line.length() > 0) {  // 만약 text를 입력하고 있다면
			outWriter.println(line); 
			line = input.nextLine();  
		}
		
		outWriter.close();  // 열린 파일 닫기
		System.out.println(filename + "파일이 생성되었습니다.");
	}

}
