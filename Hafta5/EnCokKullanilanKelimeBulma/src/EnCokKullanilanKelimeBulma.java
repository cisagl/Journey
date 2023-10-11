import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EnCokKullanilanKelimeBulma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Metni giriniz: ");
        String text = input.nextLine();

        String[] words = text.split(" ");

        HashMap<String, Integer> hMap = new HashMap<>();

        for (String str : words) {
            if (hMap.containsKey(str)) {
                int times = hMap.get(str);
                hMap.put(str, times + 1);
            } else {
                hMap.put(str, 1);
            }
        }

        String mostUsedWord = "";
        int mostUsedWordNumber = 0;

        for (
                Map.Entry<String, Integer> entry : hMap.entrySet()) {
            if (entry.getValue() > mostUsedWordNumber) {
                mostUsedWord = entry.getKey();
                mostUsedWordNumber = entry.getValue();
            }
        }

        System.out.println("En çok kullanılan kelime: " + mostUsedWord);
        System.out.println("Bu kelime " + mostUsedWordNumber + " kere kullanılmıştır");
    }
}
