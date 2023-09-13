import java.util.Scanner;

public class DortveBesinKatlari {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k, v, i;
        System.out.print("Lütfen bir sayı giriniz: ");
        k = input.nextInt();

        for (i = 4; i <= k; i*=2){
            System.out.println(k + " sayısına kadarki 4'ün katları:" + i);
        } for (v = 5; v <= k; v*=2){
            System.out.println(k + " sayısına kadarki 5'ün katları:" + v);
        }
    }
}