package Cummunityuni;
public class Bai3 {
    public static void main(String[] args) {
        Hinh hcn = new HinhChuNhat("Đỏ", 10, 5);
        Hinh hv = new HinhVuong("Xanh", 4);
        Hinh ht = new HinhTron("Vàng", 3);

        System.out.println(hcn.LayThongTin() + " | Diện tích: " + hcn.TinhDienTich() + " | Chu vi: " + hcn.TinhChuVi());
        System.out.println(hv.LayThongTin() + " | Diện tích: " + hv.TinhDienTich() + " | Chu vi: " + hv.TinhChuVi());
        System.out.println(ht.LayThongTin() + " | Diện tích: " + ht.TinhDienTich() + " | Chu vi: " + ht.TinhChuVi());
    }
}
class Hinh {
    protected String mau;

    public Hinh(String mau) {
        this.mau = mau;
    }

    public double TinhDienTich() {
        return 0;
    }

    public double TinhChuVi() {
        return 0;
    }

    public String LayThongTin() {
        return "Màu sắc: " + mau;
    }
}

class HinhChuNhat extends Hinh {
    protected double chieudai;
    protected double chieurong;

    public HinhChuNhat(String mau, double chieudai, double chieurong) {
        super(mau);
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }

    @Override
    public double TinhDienTich() {
        return chieudai * chieurong;
    }

    @Override
    public double TinhChuVi() {
        return (chieudai + chieurong) * 2;
    }

    @Override
    public String LayThongTin() {
        return super.LayThongTin() + ", Chiều dài: " + chieudai + ", Chiều rộng: " + chieurong;
    }
}

class HinhVuong extends HinhChuNhat {
    public HinhVuong(String mau, double canh) {
        super(mau, canh, canh);
    }

    @Override
    public String LayThongTin() {
        return "Hình Vuông - Màu sắc: " + mau + ", Cạnh: " + chieudai;
    }
}

class HinhTron extends Hinh {
    private double bankinh;

    public HinhTron(String mau, double bankinh) {
        super(mau);
        this.bankinh = bankinh;
    }

    @Override
    public double TinhDienTich() {
        return Math.PI * bankinh * bankinh;
    }

    @Override
    public double TinhChuVi() {
        return 2 * Math.PI * bankinh;
    }

    @Override
    public String LayThongTin() {
        return super.LayThongTin() + ", Bán kính: " + bankinh;
    }
}
