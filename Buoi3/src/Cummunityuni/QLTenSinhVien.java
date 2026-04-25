package Cummunityuni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QLTenSinhVien 
{

    public static void main(String[] args)
    {
        ArrayList<String> dsSV = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        while (true)
        {       
            System.out.println("a) Them Sinh vien");
            System.out.println("b) Xuat danh sach sinh vien");
            System.out.println("c) Sua Sinh Vien");
            System.out.println("d) Xoa Sinh vien chua ten bat ky");
            System.out.println("e) Tim Sinh vien ma ten co chu An");
            System.out.println("f) Sap xep Sinh Vien");
            System.out.println("g) Xuat ra so luong sinh vien");
            System.out.println("h) Thoat");
            System.out.print("Chon chuc nang: ");
            String chon = sc.nextLine();

            switch (chon) 
            {
                case "a":
                    System.out.print("Nhap Ho va Ten sinh vien: ");
                    dsSV.add(sc.nextLine());
                    break;

                case "b":
                    System.out.println("Danh sach sinh vien: " + dsSV);
                    break;

                case "c":
                    System.out.print("Nhap vi tri muon sua (0 den " + (dsSV.size() - 1) + "): ");
                    int indexSua = Integer.parseInt(sc.nextLine());
                    if (indexSua >= 0 && indexSua < dsSV.size()) 
                    {
                        System.out.print("Nhap Ho va Ten moi: ");
                        dsSV.set(indexSua, sc.nextLine());
                    }
                    break;

                case "d":
                    System.out.print("Nhap Ho va Ten muon xoa: ");
                    String tenXoa = sc.nextLine();
                    dsSV.removeIf(name -> name.equalsIgnoreCase(tenXoa));
                    break;

                case "e":
                    System.out.println("Cac sinh vien co chu 'An':");
                    for (String sv : dsSV)
                    {
                        if (sv.toLowerCase().contains("an"))
                        {
                            System.out.println(sv);
                        }
                    }
                    break;

                case "f":
                    Collections.sort(dsSV);
                    System.out.println("Da sap xep xong.");
                    break;

                case "g":
                    System.out.println("So luong sinh vien: " + dsSV.size());
                    break;

                case "h":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Chon sai, vui long chon lai!");
            }
        }
    }
}