package Cummunityuni;

import java.util.Scanner;

public class MangSoTuNhien 
{
    public static boolean isPrime(int n) 
    {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) 
        {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu: ");
        int n = sc.nextInt();
        int[] M = new int[n];
        for (int i = 0; i < n; i++)
        {
            System.out.print("M[" + i + "]=");
            M[i] = sc.nextInt();
        }
        System.out.print("Dong 1: ");
        int oddCount = 0;
        boolean[] checkedOdd = new boolean[n];
        for (int i = 0; i < n; i++)
        {
            if (M[i] % 2 != 0 && !checkedOdd[i])
            {
                int count = 0;
                for (int j = 0; j < n; j++)
                {
                    if (M[j] == M[i])
                    {
                        count++;
                        checkedOdd[j] = true;
                    }
                }
                if (count > 1) System.out.print(M[i] + "(" + count + ") ");
                else System.out.print(M[i] + " ");
            }
            if (M[i] % 2 != 0) oddCount++;
        }
        System.out.println("-> " + oddCount + " so le");
        System.out.print("Dong 2: ");
        int evenCount = 0;
        boolean[] checkedEven = new boolean[n];
        for (int i = 0; i < n; i++)
        {
            if (M[i] % 2 == 0 && !checkedEven[i])
            {
                int count = 0;
                for (int j = 0; j < n; j++) 
                {
                    if (M[j] == M[i]) 
                    {
                        count++;
                        checkedEven[j] = true;
                    }
                }
                if (count > 1) System.out.print(M[i] + "(" + count + ") ");
                else System.out.print(M[i] + " ");
            }
            if (M[i] % 2 == 0) evenCount++;
        }
        System.out.println("-> " + evenCount + " so chan");
        System.out.print("Dong 3: ");
        for (int x : M) 
        {
            if (isPrime(x)) System.out.print(x + " ");
        }
        System.out.println();

        System.out.print("Dong 4: ");
        for (int x : M) 
        {
            if (!isPrime(x)) System.out.print(x + " ");
        }
        System.out.println();    
        sc.close();
    }
}