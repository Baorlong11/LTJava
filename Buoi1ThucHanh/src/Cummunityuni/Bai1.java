package Cummunityuni;
import java.util.Scanner;
public class Bai1 {
    public static int timUCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập số nguyên dương a: ");
            int a = sc.nextInt();
            System.out.print("Nhập số nguyên dương b: ");
            int b = sc.nextInt();
            if (a <= 0 || b <= 0) {
                System.out.println("Vui lòng nhập các số nguyên lớn hơn 0.");
            } else {
                int ketQua = timUCLN(a, b);
                System.out.println("Ước số chung lớn nhất của " + a + " và " + b + " là: " + ketQua);
            }
            
        } catch (Exception e) {
            System.out.println("Lỗi: Vui lòng chỉ nhập số nguyên.");
        } finally {
            sc.close();
        }
    }
}