import java.util.Scanner;

class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {

        System.out.println("\t\t\tMacera oyunu!");
        // System.out.print("Lütfen bir isim giriniz: ");
        // String playerName = input.nextLine();
        Player player = new Player("CCCC");
        System.out.println(player.getName() + " Hoşgeldiniz!");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("==============Bölgeler==============");
            System.out.println();
            System.out.println("1- Güvenli Ev");
            System.out.println("2- Eşya Dükkanı");
            System.out.println("3- Mağara || SAVAŞ ALANI!");
            System.out.println("4- Orman || SAVAŞ ALANI!");
            System.out.println("5- Nehir || SAVAŞ ALANI!");
            System.out.println("6- Maden || SAVAŞ ALANI!");
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
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                case 0:
                    location = null;
                    break;
                default:
                    System.out.println("Geçerli bir tuşlama yapınız");
            }
            if (location == null){
                System.out.println("Oyun sonlandırıldı");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game over!");
                break;
            }
        }
    }
}