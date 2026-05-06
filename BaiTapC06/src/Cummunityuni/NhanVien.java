package Cummunityuni;
import java.util.Scanner;

public class NhanVien
{
    private String ho;
    private String ten;
    private int soSP;
    public NhanVien(String ho, String ten, int soSP) 
    {
        this.ho = ho;
        this.ten = ten;
        this.soSP = (soSP < 0) ? 0 : soSP;
    }
    public String getHo()
    { return ho; }
    public void setHo(String ho)
    { this.ho = ho; }
    public String getTen()
    { return ten; }
    public void setTen(String ten) 
    { this.ten = ten; }
    public int getSoSP()
    { return soSP; }
    public void setSoSP(int soSP)
    {
        this.soSP = (soSP < 0) ? 0 : soSP;
    }
    public double getLuong() 
    {
        double donGia = 0;
        if (soSP >= 1 && soSP <= 199) donGia = 0.5;
        else if (soSP <= 399) donGia = 0.55;
        else if (soSP <= 599) donGia = 0.6;
        else if (soSP >= 600) donGia = 0.65;
        return soSP * donGia;
    }
    public boolean LonHon(NhanVien nv2)
    {
        return this.soSP > nv2.soSP;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        NhanVien[] nv = new NhanVien[2];
        for (int i = 0; i < 2; i++) 
        {
            System.out.println("Nhập nhân viên " + (i + 1) + ":");
            System.out.print("Họ: "); String ho = sc.nextLine();
            System.out.print("Tên: "); String ten = sc.nextLine();
            System.out.print("Số SP: "); int sp = sc.nextInt();
            sc.nextLine();
            nv[i] = new NhanVien(ho, ten, sp);
        }
        System.out.println("\nLương NV1: " + nv[0].getLuong());
        System.out.println("Lương NV2: " + nv[1].getLuong());
        if (nv[0].LonHon(nv[1]))
        {
            System.out.println(nv[0].getTen() + " nhiều hơn " + (nv[0].getSoSP() - nv[1].getSoSP()) + " SP");
        } else if (nv[1].LonHon(nv[0])) {
            System.out.println(nv[1].getTen() + " nhiều hơn " + (nv[1].getSoSP() - nv[0].getSoSP()) + " SP");
        } else 
        {
            System.out.println("Hai nhân viên bằng sản phẩm nhau");
        }
        if (nv[0].getSoSP() != nv[1].getSoSP())
        {
            NhanVien max = (nv[0].getSoSP() > nv[1].getSoSP()) ? nv[0] : nv[1];
            NhanVien min = (max == nv[0]) ? nv[1] : nv[0];
            System.out.println(max.getTen() + " nhiều hơn " + (max.getSoSP() - min.getSoSP()) + " SP");
        }
    }
}