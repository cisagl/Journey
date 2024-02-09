package Hafta2;

public class DiziIcerisindekiTekrarEdenCiftSayilariBulma {
    public static void main(String[] args) {

        int[] liste = {4, 4, 8, 8, 16, 16, 3, 7, 5};

        for (int i = 0; i < liste.length; i++) {
            for (int j = 0; j < liste.length; j++) {
                if ((i != j) && (liste[i] == liste[j])) {
                    if ((liste[i] % 2) == 0) {
                        System.out.print(liste[i] + " ");
                    }
                }
            }
        }
    }
}