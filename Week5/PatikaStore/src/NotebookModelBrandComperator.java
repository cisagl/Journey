import java.util.Comparator;

public class NotebookModelBrandComperator implements Comparator<Notebooks> {
    @Override
    public int compare(Notebooks o1, Notebooks o2) {

        int brandComparison = o1.getBrand().getName().compareTo(o2.getBrand().getName());
        // Markalar aynı olduğunda ikinci ürün ekrana yazdırılmıyordu bunun için eğer marka adı farklı değilse, ID numaralarına göre sırala komutu eklendi
        if (brandComparison == 0){
            return o1.getId() - o2.getId();
        }
        return brandComparison;
    }
}
