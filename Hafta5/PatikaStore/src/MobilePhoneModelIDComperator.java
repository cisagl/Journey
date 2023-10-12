import java.util.Comparator;

public class MobilePhoneModelIDComperator implements Comparator<MobilePhones> {
    @Override
    public int compare(MobilePhones o1, MobilePhones o2) {
        return o1.getId() - o2.getId();
    }
}
