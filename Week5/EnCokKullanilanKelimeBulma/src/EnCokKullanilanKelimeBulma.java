import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EnCokKullanilanKelimeBulma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Metni giriniz: ");
        String text = input.nextLine();

        // Yeni bir dizi oluşturup kullanıcının girdiği metni dizinin içine atıyoruz
        // Diziyi boşluklardan ayırıyoruz
        String[] words = text.split(" ");

        // Yeni bir HashMap kullanarak kelime ve kaç kere kullanıldığı bilgisini kayıt ediyoruz
        HashMap<String, Integer> hMap = new HashMap<>();

        //foreach döngüsü ile diziyi geziyoruz
        for (String str : words) {
            // Eğer HashMap kelimeyi içeriyorsa
            if (hMap.containsKey(str)) {
                // Kelimenin kaç kere kullanıldığını kayıt etmesi için değişken oluşturuyoruz
                int times = hMap.get(str);
                // Key = kelime, Value = kaç kere kullanıldığı
                hMap.put(str, times + 1);
                // Eğer HashMap kelimeyi içermiyorsa, kelime + 1
            } else {
                hMap.put(str, 1);
            }
        }

        String mostUsedWord = "";
        int mostUsedWordNumber = 0;


        // HashMap'ın kontrolü için yeni bir foreach oluşturuyoruz
        for (Map.Entry<String, Integer> entry : hMap.entrySet()) {
            // Eğer gelen yeni değer en çok kullanılan kelimenin sayısından büyükse artık en büyük değer odur
            if (entry.getValue() > mostUsedWordNumber) {
                mostUsedWord = entry.getKey();
                mostUsedWordNumber = entry.getValue();
            }
        }

        System.out.println("En çok kullanılan kelime: " + mostUsedWord);
        System.out.println("Bu kelime " + mostUsedWordNumber + " kere kullanılmıştır");
    }
}
