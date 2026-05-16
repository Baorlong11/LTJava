package Cummunityuni;

import java.util.ArrayList;
import java.util.Scanner;

class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double price;

    public Invoice(String partNumber, String partDescription, int quantity, double price) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = (quantity > 0) ? quantity : 0;
        this.price = (price > 0) ? price : 0.0;
    }

    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }

    public String getPartDescription() { return partDescription; }
    public void setPartDescription(String partDescription) { this.partDescription = partDescription; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        this.quantity = (quantity > 0) ? quantity : 0;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        this.price = (price > 0) ? price : 0.0;
    }

    public double getInvoiceAmount() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return String.format("Mã: %-8s | Mô tả: %-15s | SL: %-5d | Giá: %-12.2f | Tổng: %-12.2f", 
                partNumber, partDescription, quantity, price, getInvoiceAmount());
    }
}

public class InvoiceTest {
    private ArrayList<Invoice> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void mockData() {
        list.add(new Invoice("P005", "Ram 8GB", 2, 800000));
        list.add(new Invoice("P001", "SSD 256GB", 5, 1200000));
        list.add(new Invoice("P003", "Mouse", 10, 150000));
        list.add(new Invoice("P002", "Keyboard", 4, 1350000));
        list.add(new Invoice("P009", "Monitor", 1, 3000000));
        list.add(new Invoice("P004", "CPU i5", 2, 4500000));
        list.add(new Invoice("P008", "VGA 3060", 1, 8500000));
        list.add(new Invoice("P006", "Mainboard", 3, 2700000));
        list.add(new Invoice("P010", "Case", 5, 900000));
        list.add(new Invoice("P007", "PSU 650W", 2, 1200000));
        System.out.println("Đã nạp dữ liệu mẫu.");
    }

    public void inputInvoice() {
        System.out.print("Nhập mã mặt hàng: ");
        String id = sc.nextLine();
        for (Invoice inv : list) {
            if (inv.getPartNumber().equalsIgnoreCase(id)) {
                System.out.println("Lỗi: Mã này đã tồn tại!");
                return;
            }
        }
        System.out.print("Mô tả: ");
        String desc = sc.nextLine();
        System.out.print("Số lượng: ");
        int qty = Integer.parseInt(sc.nextLine());
        System.out.print("Đơn giá: ");
        double price = Double.parseDouble(sc.nextLine());
        list.add(new Invoice(id, desc, qty, price));
        System.out.println("Thêm thành công.");
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println("\n" + "=".repeat(70));
        for (Invoice inv : list) System.out.println(inv);
        System.out.println("=".repeat(70));
    }
    public void sortInvoices() {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                boolean swap = false;
                int res = list.get(i).getPartNumber().compareTo(list.get(j).getPartNumber());
                if (res > 0) {
                    swap = true;
                } else if (res == 0) {
                    if (list.get(i).getQuantity() > list.get(j).getQuantity()) {
                        swap = true;
                    }
                }
                if (swap) {
                    Invoice temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println("Đã sắp xếp theo Mã mặt hàng và Số lượng.");
    }
    public void findInvoice() {
        System.out.print("Nhập mã cần tìm: ");
        String id = sc.nextLine();
        for (Invoice inv : list) {
            if (inv.getPartNumber().equalsIgnoreCase(id)) {
                System.out.println("Tìm thấy: " + inv);
                return;
            }
        }
        System.out.println("Không tìm thấy mã hàng này.");
    }

    public void deleteInvoice() {
        System.out.print("Nhập mã cần xóa: ");
        String id = sc.nextLine();
        if (list.removeIf(inv -> inv.getPartNumber().equalsIgnoreCase(id))) {
            System.out.println("Đã xóa thành công.");
        } else {
            System.out.println("Không tìm thấy mã để xóa.");
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ HÓA ĐƠN ---");
            System.out.println("1. Nạp dữ liệu mẫu (10 mã)");
            System.out.println("2. Nhập hóa đơn mới (Check trùng mã)");
            System.out.println("3. Xuất danh sách hóa đơn");
            System.out.println("4. Sắp xếp (Mã hàng & Số lượng)");
            System.out.println("5. Tìm kiếm theo mã hàng");
            System.out.println("6. Xóa hóa đơn theo mã hàng");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> mockData();
                case "2" -> inputInvoice();
                case "3" -> display();
                case "4" -> sortInvoices();
                case "5" -> findInvoice();
                case "6" -> deleteInvoice();
                case "0" -> {
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void main(String[] args) {
        new InvoiceTest().menu();
    }
}