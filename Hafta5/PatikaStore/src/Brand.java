import java.util.TreeSet;

public class Brand {
    private int id;
    private String name;
    private static TreeSet<Brand> sortedBrandNames = new TreeSet<>(new BrandNamesComparator());
    static Brand samsung = new Brand(1, "Samsung");
    static Brand lenovo = new Brand(2, "Lenovo");
    static Brand apple = new Brand(3, "Apple");
    static Brand huawei = new Brand(4, "Huawei");
    static Brand casper = new Brand(5, "Casper");
    static Brand asus = new Brand(6, "Asus");
    static Brand hp = new Brand(7, "HP");
    static Brand xiaomi = new Brand(8, "Xiaomi");
    static Brand monster = new Brand(9, "Monster");

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void brands() {
        sortedBrandNames.add(samsung);
        sortedBrandNames.add(lenovo);
        sortedBrandNames.add(apple);
        sortedBrandNames.add(huawei);
        sortedBrandNames.add(casper);
        sortedBrandNames.add(asus);
        sortedBrandNames.add(hp);
        sortedBrandNames.add(xiaomi);
        sortedBrandNames.add(monster);
    }

    public static void printBrand() {
        System.out.println();
        System.out.println("###########Markalarımız###########");
        System.out.println();
        for (Brand bran : sortedBrandNames) {
            System.out.println("\t\t\t   "+bran.getName());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
