import java.util.Scanner;

public class Run {
    public static void run() {
        Scanner input = new Scanner(System.in);
        System.out.print("PatikaStore'a Hoşgeldin!");

        while (true) {
            System.out.println("\n1 - Notebook işlemleri\n2 - Cep Telefonu işlemleri\n3 - Markaları listele\n0 - Çıkış yap");
            System.out.print("Seçmek istediğin menüyü tuşla: ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    Notebooks.whatToDo();
                    break;
                case 2:
                    MobilePhones.whatToDo();
                    break;
                case 3:
                    Brand.brands();
                    Brand.printBrand();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçerli bir tuşlama yapınız");
            }
        }
    }
}