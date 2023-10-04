import java.util.Random;

public class Snake extends Obstacle {

    private int maxDamage;
    private int minDamage;

    public Snake() {
        super(4, 6, 12, "Yılan", 0 );
    }

    public int snakeDamage() {
        Random r = new Random();
        return r.nextInt((getMaxDamage() - getMinDamage()) + getMinDamage());
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }
}