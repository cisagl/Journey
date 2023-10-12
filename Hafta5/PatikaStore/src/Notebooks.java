import java.util.Scanner;
import java.util.TreeSet;

public class Notebooks extends CommonFeatures {
    private static TreeSet<Notebooks> modelSet = new TreeSet<>(new NotebookModelIDComperator());
    private static TreeSet<Notebooks> modelSetByBrands = new TreeSet<>(new NotebookModelBrandComperator());

    public Notebooks(int id, double price, int discountRate, int stock, String name, int memory, double screenSize, int ram, Brand brand) {
        super(id, price, discountRate, stock, name, memory, screenSize, ram, brand);
    }

    public static void modelsOfNoteBooks() {
        Notebooks matebook = new Notebooks(1, 7000, 20, 25, "Matebook 14", 512, 14, 16, Brand.huawei);
        modelSet.add(matebook);
        Notebooks v14IGL = new Notebooks(2, 3699, 30, 15, "V14 IGL", 1024, 14, 8, Brand.lenovo);
        modelSet.add(v14IGL);
        Notebooks tufgaming = new Notebooks(3, 8199, 15, 5, "Tuf Gaming", 2048, 15.6, 32, Brand.asus);
        modelSet.add(tufgaming);
    }

    // Notebook işlemleri seçeneği seçildiğinde ne yapılacağı sorgusu kullanıcıya iletildi
    public static void whatToDo() {
        Scanner input = new Scanner(System.in);
        modelsOfNoteBooks();
        while (true) {
            System.out.println("\n1 - Ürünleri listele\n2 - Ürün ekle\n3 - Ürün sil\n0 - Önceki menüye dön");
            System.out.print("Notebook kategorisinden yapmak istediğiniz işlemi tuşlayınız:");
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
                    printNotebooksModels();
                    break;
                case 2:
                    printNotebookModelsSortByBrands();
                    break;
                case 0:
                    return;
                default:
                    return;
            }
        }
    }

    public static void printNotebooksModels() {
        if (modelSet.isEmpty()) {
            System.out.println("#######################################");
            System.out.println("Listenecek herhangi bir ürün bulunamadı");
            System.out.println("#######################################");
        } else {
            for (Notebooks print : modelSet) {
                System.out.println("\uD83C\uDD94 Notebook ID: " + print.getId() + "\n\uD83D\uDCBB Markası: " + print.getBrand().getName() + "\n\uD83D\uDDB4 Depolama Alanı: " + print.getMemory() + " GB" + "\n\uD83D\uDDB5 Ekran Boyutu: " + print.getScreenSize() + " inch" + "\n\uD83D\uDCDF RAM: " + print.getRam() + " GB" + "\n\uD83D\uDCE6 Stok durumu: " + print.getStock() + "\n\uD83D\uDCB5 Fiyatı: " + print.getTotal() + "₺");
                System.out.println("###########################");
                System.out.println();
            }
        }
    }

    public static void printNotebookModelsSortByBrands() {
        // Markasına göre modelleri sıralama
        // Önce ilk oluşturulan set'in içerisindeki bütün nesneler yeni set'e aktarıldı
        modelSetByBrands.addAll(modelSet);
        if (modelSetByBrands.isEmpty()) {
            System.out.println("#######################################");
            System.out.println("Listenecek herhangi bir ürün bulunamadı");
            System.out.println("#######################################");
        } else {
            for (Notebooks print : modelSetByBrands) {
                System.out.println("\uD83C\uDD94 Notebook ID: " + print.getId() + "\n\uD83D\uDCBB Markası: " + print.getBrand().getName() + "\n\uD83D\uDDB4 Depolama Alanı: " + print.getMemory() + " GB" + "\n\uD83D\uDDB5 Ekran Boyutu: " + print.getScreenSize() + " inch" + "\n\uD83D\uDCDF RAM: " + print.getRam() + " GB" + "\n\uD83D\uDCE6 Stok durumu: " + print.getStock() + "\n\uD83D\uDCB5 Fiyatı: " + print.getTotal() + "₺");
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
        Notebooks modelToDelete = null;
        for (Notebooks model : modelSet) {
            if (model.getId() == id) {
                modelToDelete = model;
                break;
            }
        }
        // Silinecek olan nesne setin niçerisinde kontrol ediliyor
        for (Notebooks model2 : modelSetByBrands) {
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
        // Kullanıcı uyuşmayan bir tuşlama yaptığında try catch ile hata vermeden başa döndürülüyor
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Girilecek yeni ürünün ID numarası(ID numarası benzersiz olmalıdır): ");
            int id = input.nextInt();
            for (Notebooks notebook : modelSet) {
                if (notebook.getId() == id) {
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
            System.out.println("Fiyatı: ");
            double price = input.nextDouble();
            System.out.println("İndirim oranı: ");
            int discountRate = input.nextInt();

            Notebooks newNotebook = new Notebooks(id, price, discountRate, stock, name, memory, screenSize, ram, selectedBrand);

            modelSet.add(newNotebook);
            System.out.println("Ürünü sisteme eklediniz");
        } catch (Exception e) {
            System.out.println("Hatalı tuşlama yapıldı. Tekrar deneyiniz.");
        }
    }

    public static Brand pickBrand() {
        // Kullanıcı ürün eklerken marka seçimi yapması sağlanıyor
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
}
