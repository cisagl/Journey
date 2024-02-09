public class ArrayCheck extends Exception {
    public ArrayCheck(String message) {
        super(message);
        System.out.println("==============SİSTEM HATASI==============");
        System.out.println("Girilen değer dizinin boyutundan büyük ya da küçük");
    }
}
