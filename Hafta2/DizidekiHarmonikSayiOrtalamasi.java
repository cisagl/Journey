package Hafta2;

public class DizidekiHarmonikSayiOrtalamasi {
    public static void main(String[] args) {
        double harmonikOrt = 0;
        double[] numbers = {1, 2, 3, 4, 5};
        for (int i = 1; i <= numbers.length; i++) {
            harmonikOrt += 1.0 / i;
        }
        System.out.println(harmonikOrt);
    }
}
