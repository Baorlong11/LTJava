package Cummunityuni;

import java.util.Scanner;

public class PhuongThuc {

	public static boolean Panlindrome(String s) {
		int n = s.length();
		for (int i = 0; i < n / 2; i++) {
			if (s.charAt(i) != s.charAt(n - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhập vào một chuỗi để kiểm tra: ");
		String input = sc.nextLine();
		
		if (Panlindrome(input)) {
			System.out.println("=> '" + input + "' ĐÚNG là chuỗi Panlindrome!");
		} else {
			System.out.println("=> '" + input + "' KHÔNG PHẢI là chuỗi Panlindrome.");
		}
		
		sc.close();
	}

}