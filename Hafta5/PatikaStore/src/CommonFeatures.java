public abstract class CommonFeatures {
    private int id;
    private double price;
    private int discountRate;
    private int stock;
    private String name;
    private int memory;
    private double screenSize;
    private int ram;
    private Brand brand;
    private double total;

    public CommonFeatures(int id, double price, int discountRate, int stock, String name, int memory, double screenSize, int ram, Brand brand) {
        this.id = id;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.memory = memory;
        this.screenSize = screenSize;
        this.ram = ram;
        this.brand = brand;
    }

    private double totalPrice(double price, int discountRate) {
        double i = price * discountRate;
        double j = i / 100;
        return price - j;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getTotal() {
        total = (int) totalPrice(price, discountRate);
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}