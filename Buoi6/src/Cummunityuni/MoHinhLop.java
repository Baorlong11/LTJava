package Cummunityuni;

import java.util.ArrayList;

public class MoHinhLop{
    public static void main(String[] args) {
        ManageStaff st = new ManageStaff();
        Executive boss = new Executive("Nguyễn Văn A", "Quận 1, TP.HCM", "0901", "SSN1", 50000000);
        boss.awardBonus(10000000);
        
        Hourly worker = new Hourly("Trần Thị B", "Quận 7, TP.HCM", "0902", "SSN2", 200000);
        worker.addHours(40); 
        
        st.addMember(boss);
        st.addMember(worker);
        st.addMember(new Volunteer("Lê Văn C", "Thủ Đức, TP.HCM", "0903"));
        st.payday();
    }
}
class ManageStaff {
    private ArrayList<StaffMember> staffList = new ArrayList<>();
    public void addMember(StaffMember member) { staffList.add(member); }
    public void payday()
    {
        double tong = 0;
        System.out.println("--- BẢNG LƯƠNG NHÂN VIÊN ---");
        for (StaffMember m : staffList)
        {
            System.out.println(m);
            double luong = m.pay();
            System.out.printf("  => Lương thực nhận: %,.0f VND%n", luong);
            tong += luong;
        }
        System.out.println("----------------------------");
        System.out.printf("TỔNG CHI TRẢ: %,.0f VND%n", tong);
    }
}
abstract class StaffMember
{
    protected String name, address, phone;
    public StaffMember(String name, String address, String phone)
    {
        this.name = name; this.address = address; this.phone = phone;
    }
    public abstract double pay();
    public String toString() 
    {
        return "Tên: " + name + " | ĐC: " + address + " | SĐT: " + phone;
    }
}

class Volunteer extends StaffMember 
{
    public Volunteer(String name, String address, String phone) 
    { super(name, address, phone); }
    public double pay() { return 0.0; }
}

class Employee extends StaffMember 
{
    protected String socialSecurityNumber;
    protected double payRate;
    public Employee(String name, String address, String phone, String ssn, double payRate) 
    {
        super(name, address, phone);
        this.socialSecurityNumber = ssn; this.payRate = payRate;
    }
    public double pay() 
    { return payRate; }
}

class Executive extends Employee 
{
    private double bonus;
    public Executive(String name, String address, String phone, String ssn, double payRate)
    {
        super(name, address, phone, ssn, payRate);
    }
    public void awardBonus(double execBonus)
    { this.bonus = execBonus; }
    public double pay() 
    {
        double total = super.pay() + bonus;
        bonus = 0;
        return total;
    }
}

class Hourly extends Employee
{
    private int hoursWorked;
    public Hourly(String name, String address, String phone, String ssn, double payRate) 
    {
        super(name, address, phone, ssn, payRate);
    }
    public void addHours(int hours) 
    { this.hoursWorked += hours; }
    public double pay() {
        double total = payRate * hoursWorked;
        hoursWorked = 0;
        return total;
    }
}