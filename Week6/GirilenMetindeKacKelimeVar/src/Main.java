import java.util.*;
import java.io.*;

class Main {

    public static int WordCount(String str) {

        int count = 0;
        try {
            FileWriter fWriter = new FileWriter("text.txt");

            String[] words = str.split(" ");

            for (String word : words) {
                fWriter.write(word + "\n");
            }
            fWriter.close();

            FileReader fReader = new FileReader("text.txt");
            BufferedReader bReader = new BufferedReader(fReader);

            String line;

            while ((line = bReader.readLine()) != null) {
                count++;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(WordCount(s.nextLine()));
    }

}