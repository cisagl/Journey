public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    boolean onLocation() {
        System.out.println("==============Mağazaya hoşgeldiniz!==============");
        boolean showMenu = true;
        while (showMenu) {

            System.out.println("1- Ekipman seçimi");
            System.out.println("2- Zırh seçimi");
            System.out.println("3- Çıkış yap");
            System.out.print("Seçiminiz: ");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Geçersiz değer girildi, yeni bir değer giriniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Yine bekleriz :)");
                    showMenu = false;
                    return true;

            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println();
        System.out.println("==============Ekipman==============");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println("Ekipman " + w.getId() + ": " + w.getName() + "\t Hasarı: " + w.getDamage() + "\t Fiyatı: " + w.getPrice());
        }
        System.out.println("Çıkış yapmak için 0'ı tuşlayınız");
    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Geçersiz değer girildi, yeni bir değer giriniz: ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0) {

            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {
                    // Satın almanın gerçekleştiği alan
                    System.out.println(selectedWeapon.getName() + " ekipmanını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan bakiye: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().getWeapon().getName();
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmor() {
        System.out.println();
        System.out.println("==============Zırhlar==============");
        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println("Zırh " + a.getId() + ": " + a.getName() + "\t Zırh değeri: " + a.getBlock() + "\t Fiyatı: " + a.getPrice());
        }
        System.out.println("Çıkış yapmak için 0'ı tuşlayınız");
    }

    public void buyArmor() {
        System.out.print("Bir zırh seçiniz: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.print("Geçersiz değer girildi, yeni bir değer giriniz: ");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan bakiye: " + this.getPlayer().getMoney());
                }
            }
        }
    }
}
