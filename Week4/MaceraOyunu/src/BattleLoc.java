import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;

    }

    @Override
    boolean onLocation() {

        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şu an " + this.getName() + "'dasınız");
        System.out.println("Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor.");
        System.out.print("Savaşmak için S'ye, geri dönmek için herhangi bir tuşa basınız");
        String selectCase = input.nextLine().toUpperCase();

        if (selectCase.equals("S") && combat(obsNumber)) {
            if (this.award.equals("food")) {
                this.getPlayer().getInventory().setFood(true);
            }
            if (this.award.equals("wood")) {
                this.getPlayer().getInventory().setWood(true);
            }
            if (this.award.equals("water")) {
                this.getPlayer().getInventory().setWater(true);
            }
            if (this.award.equals("coal")) {
                this.getPlayer().getInventory().setCoal(true);
            }
            return true;
        }


        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz");
            return false;
        }

        return true;
    }


    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("Vurmak için V, kaçmak için K: ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    // Kimin önce rastgele bir şekilde tanımlandı
                    if (firstHit() > 50) {
                        System.out.println("Siz vurdunuz");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    } else {
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    }
                } else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {

                if (this.getObstacle().getAward() > 0) {
                    System.out.println(this.getObstacle().getAward() + " para kazandınız");
                }
                //Eğer savaşılan lokasyondaki canavarın ID'si 4(yılan)sa, snakeAward() metodu çağırıldı
                if (this.getObstacle().getId() == 4) {
                    snakeAward();
                }
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
                System.out.println(i + " tane " + this.getObstacle().getName() + "'nin hakkından geldiniz");
                System.out.println();
            }
        }
        System.out.println(this.award.toUpperCase() + " kazandınız");
        System.out.println();
        return true;
    }

    // İlk kimin vuracağı rastgele bir metot ile belirlendi
    public int firstHit() {
        Random r = new Random();
        int random = r.nextInt(101);
        return random;
    }

    // Yılandan düşen ödüllerin şans oranları burada
    public void snakeAward() {
        Random r = new Random();
        int random = r.nextInt(101);
        if (random >= 45) {
            int random2 = r.nextInt(56);
            if (random2 > 0 && random2 <= 15) {
                int random3 = r.nextInt(101);
                if (random3 < 50) {
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(1));
                    System.out.println("Bıçak kazandınız");
                } else if (random3 > 50 && random3 < 80) {
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(2));
                    System.out.println("Kılıç kazandınız");
                } else {
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(3));
                    System.out.println("Katana kazandınız");
                }
            } else if (random2 > 15 && random2 < 30) {
                int random3 = r.nextInt(101);
                if (random3 < 50) {
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(1));
                    System.out.println("Hafif zırh kazandınız");
                } else if (random3 > 50 && random3 < 80) {
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(2));
                    System.out.println("Orta zırh kazandınız");
                } else {
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(3));
                    System.out.println("Ağır zırh kazandınız");
                }
            } else {
                int random3 = r.nextInt(101);
                if (random3 < 50) {
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                    System.out.println("1 Para kazandınız");
                } else if (random3 > 50 && random3 < 80) {
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                    System.out.println("5 Para kazandınız");
                } else {
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                    System.out.println("10 Para kazandınız");
                }
            }

        } else {
            System.out.println("Herhangi bir ekipman kazanamadınız");
        }
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " canı: " + this.getObstacle().getHealth());
        System.out.println("-----------------------");
    }

    public void playerStats() {
        System.out.println("Oyuncu değerleri");
        System.out.println("Sağlık: " + this.getPlayer().getHealth() +
                "\tHasar: " + this.getPlayer().getTotalDamage() +
                "\tEkipmanınız: " + this.getPlayer().getInventory().getWeapon().getName() +
                "\tZırhınız: " + this.getPlayer().getInventory().getArmor().getName() +
                "\tBloklama: " + this.getPlayer().getInventory().getArmor().getBlock() +
                "\tPara: " + this.getPlayer().getMoney());
        System.out.println("----------------------------");
        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " değerleri");
        System.out.println("Sağlık: " + this.getObstacle().getHealth() +
                "\tHasar: " + this.getObstacle().getDamage() +
                "\tÖdül: " + this.getObstacle().getAward());
        System.out.println("----------------------------");
        System.out.println();
    }

    public void randomDamagePrint() {
        randomObstacleNumber();
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
