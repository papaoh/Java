package ch08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);  // 스캐너 클래스 선언
		System.out.println("파일 이름은? ");
		
		// 파일의 이름을 저장할 객체변수 선언
		String filename = input.nextLine().trim();  // 파일의 이름을 입력받기
		Scanner fileInput = null;
		
		// 예외처리문
		try {
			fileInput = new Scanner(new File(filename));  // 입력받은 파일이름에 알맞는 파일 열기
			
		} catch(FileNotFoundException e){  // 만약 파일을 찾지 못했다면 
			System.out.println(filename + " 파일을 열지 못했습니다.");
			System.exit(0);
		}
		while(fileInput.hasNext()) {  // 파일안에 데이터를 읽기
			System.out.println(fileInput.nextLine());
		}
		fileInput.close();  // 열어둔 파일 닫아주기
	}

}
