package Cummunityuni;

import java.util.Random;
import java.util.Scanner;

public class GameDoanSo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String TiepTuc;

        do {
            int SoCuaMay = random.nextInt(101); 
            int SoLanDoan = 0;
            int PhepThuToiDa = 7;
            boolean daThang = false;

            System.out.println("\n--- GAME DOAN SO ---");
            System.out.println("May da chon 1 so [0..100]. Ban co 7 luot doan!");

            while (SoLanDoan < PhepThuToiDa) {
                SoLanDoan++;
                System.out.print("Luot " + SoLanDoan + " - Nhap so doan: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Vui long nhap mot so nguyen!");
                    scanner.next(); 
                    SoLanDoan--; 
                    continue;
                }
                
                int soNguoiDoan = scanner.nextInt();

                if (soNguoiDoan == SoCuaMay) {
                    System.out.println("Chuc mung! Ban da thang!");
                    daThang = true;
                    break; 
                } else if (soNguoiDoan < SoCuaMay) {
                    System.out.println("So ban doan NHO hon so cua may.");
                } else {
                    System.out.println("So ban doan LON hon so cua may.");
                }
            }

            if (!daThang) {
                System.out.println("\nGame Over nha thim! Thua roi.");
                System.out.println("So dung la: " + SoCuaMay);
            }

            System.out.print("\nBan co muon choi tiep khong? (c/k): ");
            TiepTuc = scanner.next();

        } while (TiepTuc.equalsIgnoreCase("c"));

        System.out.println("Tam biet!");
        scanner.close();
    }
}