import java.util.Scanner;
import java.util.TreeSet;

public class MobilePhones extends CommonFeatures {

    private String color;
    private int battery;

    public MobilePhones(int id, double price, int discountRate, int stock, String name, int memory, double screenSize, int ram, Brand brand, int battery, String color) {
        super(id, price, discountRate, stock, name, memory, screenSize, ram, brand);
        this.battery = battery;
        this.color = color;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}