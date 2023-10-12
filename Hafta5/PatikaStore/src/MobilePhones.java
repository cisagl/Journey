import java.util.Scanner;
import java.util.TreeSet;

public class MobilePhones extends CommonFeatures {
    private String color;
    private int battery;
    // Ürünler setin içerisine gönderildi
    private static TreeSet<MobilePhones> modelSet = new TreeSet<>(new MobilePhoneModelIDComperator());
    // Ürünlerin markalara göre sıralanması için yeni bir set oluşturuldu
    private static TreeSet<MobilePhones> modelSetByBrands = new TreeSet<>(new MobilePhoneModelBrandComperator());


    public MobilePhones(int id, double price, int discountRate, int stock, String name, int memory, double screenSize, int ram, Brand brand, int battery, String color) {
        super(id, price, discountRate, stock, name, memory, screenSize, ram, brand);
        this.color = color;
        this.battery = battery;

    }

    // Varsayılan nesneler oluşturuldu
    public static void modelsOfMobilePhones() {
        MobilePhones galaxya51 = new MobilePhones(1, 3199.0, 20, 15, "Galaxy A51", 128, 6.5, 6, Brand.samsung, 4000, "Siyah");
        modelSet.add(galaxya51);
        MobilePhones iphone11 = new MobilePhones(2, 7379.0, 15, 25, "iPhone 11", 64, 6.1, 6, Brand.apple, 3046, "Mavi");
        modelSet.add(iphone11);
        MobilePhones redmiNote10 = new MobilePhones(3, 4012.0, 30, 55, "Redmi Note 10 Pro", 128, 6.5, 12, Brand.xiaomi, 4000, "Beyaz");
        modelSet.add(redmiNote10);
    }

    // Cep telefonu işlemleri seçeneği seçildiğinde ne yapılacağı sorgusu kullanıcıya iletildi
    public static void whatToDo() {
        Scanner input = new Scanner(System.in);
        modelsOfMobilePhones();
        while (true) {
            System.out.println("\n1 - Ürünleri listele\n2 - Ürün ekle\n3 - Ürün sil\n0 - Önceki menüye dön");
            System.out.print("Cep telefonu kategorisinden yapmak istediğiniz işlemi tuşlayınız:");
            int select = input.nextInt();
            System.out.println("--------------------------------------------------------------");
            switch (select) {
                case 1:
                    filter();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 0:
                    return;
                default:
                    return;
            }
        }
    }

    // Ürünleri neye göre sıralayacağını seçmesi için kullanıcıya sorgu iletildi
    public static void filter() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n1 - Ürünleri ID numaralarına göre sırala\n2 - Ürünleri markalarına göre sırala\n0 - Önceki menüye dön");
            System.out.println("Sıralamak istediğiniz seçeneği tuşlayınız: ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    printMPModels();
                    break;
                case 2:
                    printMPModelsSortByBrands();
                    break;
                case 0:
                    return;
                default:
                    return;
            }
        }
    }

    public static void printMPModels() {
        // ID no'ya göre modelleri sıralama
        if (modelSet.isEmpty()) {
            System.out.println("#######################################");
            System.out.println("Listenecek herhangi bir ürün bulunamadı");
            System.out.println("#######################################");
        } else {
            for (MobilePhones print : modelSet) {
                System.out.println("\uD83C\uDD94 Telefon ID: " + print.getId() + "\n\uD83D\uDCF1 Markası: " + print.getBrand().getName() + "\n\uD83D\uDDB4 Depolama Alanı: " + print.getMemory() + " GB" + "\n\uD83D\uDDB5 Ekran Boyutu: " + print.getScreenSize() + " inch" + "\n\uD83E\uDEAB Pil Kapasitesi: " + print.getBattery() + " MHZ" + "\n\uD83D\uDCDF RAM: " + print.getRam() + " GB" + "\n\uD83C\uDF08 Renk Seçeneği: " + print.getColor() + "\n\uD83D\uDCE6 Stok durumu: " + print.getStock() + "\n\uD83D\uDCB5 Fiyatı: " + print.getTotal() + "₺");
                System.out.println("###########################");
                System.out.println();
            }
        }
    }

    public static void printMPModelsSortByBrands() {
        // Markasına göre modelleri sıralama
        // Önce ilk oluşturulan set'in içerisindeki bütün nesneler yeni set'e aktarıldı
        modelSetByBrands.addAll(modelSet);
        if (modelSetByBrands.isEmpty()) {
            System.out.println("#######################################");
            System.out.println("Listenecek herhangi bir ürün bulunamadı");
            System.out.println("#######################################");
        } else {
            for (MobilePhones print : modelSetByBrands) {
                System.out.println("\uD83C\uDD94 Telefon ID: " + print.getId() + "\n\uD83D\uDCF1 Markası: " + print.getBrand().getName() + "\n\uD83D\uDDB4 Depolama Alanı: " + print.getMemory() + " GB" + "\n\uD83D\uDDB5 Ekran Boyutu: " + print.getScreenSize() + " inch" + "\n\uD83E\uDEAB Pil Kapasitesi: " + print.getBattery() + " MHZ" + "\n\uD83D\uDCDF RAM: " + print.getRam() + " GB" + "\n\uD83C\uDF08 Renk Seçeneği: " + print.getColor() + "\n\uD83D\uDCE6 Stok durumu: " + print.getStock() + "\n\uD83D\uDCB5 Fiyatı: " + print.getTotal() + "₺");
                System.out.println("###########################");
                System.out.println();
            }
        }
    }

    public static void removeItem() {
        // Nesne silme işlemi
        Scanner input = new Scanner(System.in);
        System.out.print("Silinecek ürünün ID numarası: ");
        int rm = input.nextInt();
        deleteModelById(rm);
    }

    public static void deleteModelById(int id) {
        // Silinecek olan nesne setin niçerisinde kontrol ediliyor
        MobilePhones modelToDelete = null;
        for (MobilePhones model : modelSet) {
            if (model.getId() == id) {
                modelToDelete = model;
                break;
            }
        }
        // Silinecek olan nesne setin niçerisinde kontrol ediliyor
        for (MobilePhones model2 : modelSetByBrands) {
            if (model2.getId() == id) {
                modelToDelete = model2;
                break;
            }
        }
        // Setlerin içerisinden ilgili id'nin nesnesi kaldırıldı
        if (modelToDelete != null) {
            modelSet.remove(modelToDelete);
            modelSetByBrands.remove(modelToDelete);
            System.out.println("ID numarası " + id + " olan model silindi.");
            System.out.println();
        } else {
            System.out.println("ID numarası " + id + " olan model bulunamadı.");
            System.out.println();
        }
    }

    public static void addItem() {

        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Girilecek yeni ürünün ID numarası(ID numarası benzersiz olmalıdır): ");
            int id = input.nextInt();
            for (MobilePhones phone : modelSet) {
                if (phone.getId() == id) {
                    System.out.println("Bu ID zaten mevcut. ID numaraları benzersiz olmalıdır. Tekrar deneyiniz.");
                    return;
                }
            }
            System.out.println("Markası: ");
            Brand selectedBrand = pickBrand();
            System.out.println(selectedBrand.getName() + " seçildi");
            System.out.println("Modelinin adı: ");
            String name = input.next();
            System.out.println("Stok durumu: ");
            int stock = input.nextInt();
            System.out.println("Depolama alanı: ");
            int memory = input.nextInt();
            System.out.println("RAM boyutu: ");
            int ram = input.nextInt();
            System.out.println("Ekran büyüklüğü: ");
            double screenSize = input.nextDouble();
            System.out.println("Batarya gücü: ");
            int battery = input.nextInt();
            System.out.println("Rengi: ");
            String color = input.next();
            System.out.println("Fiyatı: ");
            double price = input.nextDouble();
            System.out.println("İndirim oranı: ");
            int discountRate = input.nextInt();

            MobilePhones newPhone = new MobilePhones(id, price, discountRate, stock, name, memory, screenSize, ram, selectedBrand, battery, color);

            modelSet.add(newPhone);
            System.out.println("Ürünü sisteme eklediniz");
        } catch (Exception e) {
            System.out.println("Hatalı tuşlama yapıldı. Tekrar deneyiniz.");
        }
    }

    public static Brand pickBrand() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n1 - Samsung\n2 - Lenovo\n3 - Apple\n4 - Huawei\n5 - Casper\n6 - Asus\n7 - HP\n8 - Xiaomi\n9 - Monster");
        int select = input.nextInt();
        Brand selectedBrand = null;
        switch (select) {
            case 1:
                selectedBrand = Brand.samsung;
                break;
            case 2:
                selectedBrand = Brand.lenovo;
                break;
            case 3:
                selectedBrand = Brand.apple;
                break;
            case 4:
                selectedBrand = Brand.huawei;
                break;
            case 5:
                selectedBrand = Brand.casper;
                break;
            case 6:
                selectedBrand = Brand.asus;
                break;
            case 7:
                selectedBrand = Brand.hp;
                break;
            case 8:
                selectedBrand = Brand.xiaomi;
                break;
            case 9:
                selectedBrand = Brand.monster;
                break;
            default:
                System.out.println("Geçersiz bir tuşlama yaptınız, önceki menüye döndürüldü");
                break;
        }
        return selectedBrand;
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