import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("Dizinin içeriği: ");
        int selected = input.nextInt();

        try {
            ArrayChecker(selected);
            int write = arr[selected];
            System.out.println("Seçtiğiniz değerin dizi içerisindeki karşılığı: " + write);
        } catch (ArrayCheck a) {
            System.out.println(a.getMessage());
        }
    }

    public static void ArrayChecker(int selected) throws ArrayCheck {
        if (selected >= 10) {
            throw new ArrayCheck("Hatanız: " + "GİRDİĞİNİZ DEĞER 9'DAN BÜYÜK");
        } else if (selected < 0) {
            throw new ArrayCheck("GİRDİĞİNİZ DEĞER NEGATİF BİR SAYI");
        }
    }
}

