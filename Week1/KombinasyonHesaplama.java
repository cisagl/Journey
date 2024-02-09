package Hafta1;

import java.util.Scanner;

public class KombinasyonHesaplama {

    public static long faktoriyel(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * faktoriyel(n - 1);
        }
    }

    public static long kombinasyon(int n, int r) {
        if (n < r) {
            return 0;
        }
        return faktoriyel(n) / (faktoriyel(r) * faktoriyel(n - r));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("n'i giriniz: ");
        int n = input.nextInt();

        System.out.print("r'yi giriniz: ");
        int r = input.nextInt();

        input.close();

        long sonuc = kombinasyon(n, r);
        System.out.println("C(" + n + ", " + r + ") = " + sonuc);
    }
}
