import java.util.Random;

public class Snake extends Obstacle {

    public Snake() {
        super(4, snakeDamage(), 12, "Yılan", 0);
    }
    // Yılanın hasarı 3 ila 6 arasında olacak şekilde randomize edildi
    public static int snakeDamage() {
        Random r = new Random();
        int random = r.nextInt((7 - 3) + 3);
        if (random < 3){
            random += 3;
        }
        return random;
    }
}