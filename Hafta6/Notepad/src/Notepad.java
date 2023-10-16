import java.io.*;
import java.util.Scanner;

public class Notepad {

    public static void write() {

        Scanner input = new Scanner(System.in);
        System.out.print("Bir metin giriniz: ");
        String text = input.nextLine();

        FileWriter fWriter = null;
        try {
            fWriter = new FileWriter("user.text");
            PrintWriter pWriter = new PrintWriter(fWriter);
            pWriter.print(text);

            fWriter.close();
            pWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void read(){

        FileReader fReader = null;
        try {
            fReader = new FileReader("user.text");
            BufferedReader bReader = new BufferedReader(fReader);
            String readText = bReader.readLine();
            fReader.close();
            bReader.close();

            System.out.println(readText);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}