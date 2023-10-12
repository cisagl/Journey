import java.util.Comparator;

public class MobilePhoneModelBrandComperator implements Comparator<MobilePhones> {
    @Override
    public int compare(MobilePhones o1, MobilePhones o2) {

        int brandComparison = o1.getBrand().getName().compareTo(o2.getBrand().getName());
        // Markalar aynı olduğunda ikinci ürün ekrana yazdırılmıyordu bunun için eğer marka adı farklı değilse, ID numaralarına göre sırala komutu eklendi
        if (brandComparison == 0){
            return o1.getId() - o2.getId();
        }
        return brandComparison;
    }
}
