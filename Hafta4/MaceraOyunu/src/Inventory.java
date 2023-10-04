public class Inventory {
    private Weapon weapon;
    private Armor armor;

    private boolean obje = false;
    private boolean caveObje = false;
    private boolean forestObje = false;
    private boolean riverObje = false;
    private boolean mineObje = false;

    public Inventory() {
        this.weapon = new Weapon("Yumruk", -1, 0, 0);
        this.armor = new Armor("Yok", -1,0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isCaveObje() {
        return caveObje;
    }

    public boolean isObje() {
        return obje;
    }

    public void setObje(boolean obje) {
        this.obje = obje;
    }

    public void setCaveObje(boolean caveObje) {
        this.caveObje = caveObje;
    }

    public boolean isForestObje() {
        return forestObje;
    }

    public void setForestObje(boolean forestObje) {
        this.forestObje = forestObje;
    }

    public boolean isRiverObje() {
        return riverObje;
    }

    public void setRiverObje(boolean riverObje) {
        this.riverObje = riverObje;
    }

    public boolean isMineObje() {
        return mineObje;
    }

    public void setMineObje(boolean mineObje) {
        this.mineObje = mineObje;
    }
}
