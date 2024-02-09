package Hafta2.DovusSimulasyonu;

public class Main {
    public static void main(String[] args) {
        Fighter marc = new Fighter("Marc" , 15 , 100, 90, 0);
        Fighter alex = new Fighter("Alex" , 10 , 95, 100, 0);
        Ring r = new Ring(marc,alex , 90 , 100);

        // Rakibe ilk kimin vuracağının şansı (şu an yüzde 50)
        boolean firstHitByMarc = Math.random() < 0.5;


        // Eğer firstHitByMarc 0-50 arasındaysa, önce Marc vuracaktır
        if (firstHitByMarc){
            System.out.println("İlk vuruşu " + marc.name + " yapıyor " + marc.damage +" hasar verdi.");
            System.out.println("Ardından " + alex.name + " vuruyor " + alex.damage +" hasar verdi.");
            r.runMarcFirst();
        // Eğer firstHitByMarc 0-50 arasında değilse, önce Alex vuracaktır
        } else {
            System.out.println("İlk vuruşu " + alex.name + " yapıyor " + alex.damage +" hasar verdi.");
            System.out.println("Ardından " + marc.name + " vuruyor " + marc.damage +" hasar verdi.");
            r.runAlexFirst();
        }
        r.run();
    }
}