package Hafta1;

import java.util.Scanner;

public class YildizlarlaElmas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir Sayı Giriniz :");
        int n = input.nextInt();

// Burada elmasın üst kısmını tıpkı yıldız ağaç gibi yapıyoruz

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < (n - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i + 1); k++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

// Burada elmasın alt kısmını tıpkı ters yıldız ağaç gibi yapıyoruz

        for (int a = 0; a < n; a++) {
            for (int b = 0; b <= a; b++) {
                System.out.print(" ");
            }
            for (int c = 2 * n - 1; c >= (2 * a + 1); c--) {
                System.out.print("*");

            }
            System.out.println();

        }
    }
}