import java.util.Scanner;

class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {

        System.out.println("\t\t\tMacera oyunu!");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Hoşgeldiniz!");
        player.selectChar();

        Location location = null;


        while (true) {

            if (player.getInventory().isFood() && player.getInventory().isWood() && player.getInventory().isWater() && player.getInventory().isCoal()) {
                System.out.println("Bütün bileşenleri topladınız ve oyunu kazandınız. TEBRİKLER!");
                break;
            }

            player.printInfo();
            System.out.println();
            System.out.println("==============Bölgeler==============");
            System.out.println();
            System.out.println("1- Güvenli Ev");
            System.out.println("2- Eşya Dükkanı");
            if (!player.getInventory().isFood()) {
                System.out.println("3- Mağara || SAVAŞ ALANI!");
            } else {
                System.out.println("3- Mağara || TAMAMLANDI!");
            }
            if (!player.getInventory().isWood()) {
                System.out.println("4- Orman || SAVAŞ ALANI!");
            } else {
                System.out.println("4- Orman || TAMAMLANDI!");
            }
            if (!player.getInventory().isWater()) {
                System.out.println("5- Nehir || SAVAŞ ALANI!");
            } else {
                System.out.println("5- Nehir || TAMAMLANDI!");
            }
            if (!player.getInventory().isCoal()) {
                System.out.println("6- Maden || SAVAŞ ALANI!");
            } else {
                System.out.println("6- Maden || TAMAMLANDI!");
            }
            System.out.println("0- Oyunu sonlandır");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            System.out.println();
            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (player.getInventory().isFood()) {
                        System.out.println("Ödülü zaten aldınız, güvenli eve yönlendiriliyorsunuz");
                        System.out.println("======================================================");
                        location = new SafeHouse(player);
                    } else {
                        location = new Cave(player);
                    }
                    break;
                case 4:
                    if (player.getInventory().isWood()) {
                        System.out.println("Ödülü zaten aldınız, güvenli eve yönlendiriliyorsunuz");
                        System.out.println("======================================================");
                        location = new SafeHouse(player);
                    } else {
                        location = new Forest(player);
                    }
                    break;
                case 5:
                    if (player.getInventory().isWater()) {
                        System.out.println("Ödülü zaten aldınız, güvenli eve yönlendiriliyorsunuz");
                        System.out.println("======================================================");
                        location = new SafeHouse(player);
                    } else {
                        location = new River(player);
                    }
                    break;
                case 6:
                    if (player.getInventory().isCoal()) {
                        System.out.println("Ödülü zaten aldınız, güvenli eve yönlendiriliyorsunuz");
                        System.out.println("======================================================");
                        location = new SafeHouse(player);
                    } else {
                        location = new Mine(player);
                    }
                    break;
                case 0:
                    location = null;
                    break;
                default:
                    System.out.println("Geçerli bir tuşlama yapınız");
            }
            if (location == null) {
                System.out.println("Oyun sonlandırıldı");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game over!");
                break;
            }

        }
    }
}