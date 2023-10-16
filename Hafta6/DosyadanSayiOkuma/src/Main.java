
import java.io.*;


public class Main {
    public static void main(String[] args) {

        String fileName = "patika.txt";

        try {
            FileWriter newFile = new FileWriter(fileName);
            byte[] numbers = {5, 10, 20, 12, 33};
            for (byte number : numbers) {
                newFile.write(String.valueOf(number) + "\n");
            }
            newFile.close();

            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            int count = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int number = Integer.parseInt(line);
                count += number;
            }
            bufferedReader.close();
            System.out.println(count);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}