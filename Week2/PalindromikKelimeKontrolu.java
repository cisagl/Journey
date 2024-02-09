package Hafta2;

import java.util.Scanner;

public class PalindromikKelimeKontrolu {

    static boolean palindrom(String pali) {
        int i = 0;
        int j = pali.length() - 1;
        while (i < j) {
            if (pali.charAt(i) != pali.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Palindromik kelime kontrolü için kelime giriniz: ");
        String kelime = input.nextLine();
        boolean isPalindrom = palindrom(kelime);

        if (isPalindrom) {
            System.out.println(kelime + " palindrom bir kelime.");
        } else {
            System.out.println(kelime + " palindrom bir kelime değil.");
        }

    }
}