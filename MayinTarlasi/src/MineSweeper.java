import java.util.Scanner;

public class MineSweeper {

    int fieldRow;
    int fieldCol;
    int[][] dizi;
    int row;
    int col;

    // Kullanıcıdan tarlanın büyüklüğünün bilgisini alıyoruz
    public void beginning() {
        Scanner input = new Scanner(System.in);
        // boolean eklenerek sorun olması durumunda (2'den küçük sayı eklenmesi) başa dönülmesi sağlandı
        boolean isConditions = false;

        while (!isConditions) {
            System.out.print("Tarla satır sayısını belirtiniz (Minimum 2 yazmalısınız): ");
            int n = input.nextInt();
            System.out.print("Tarla sutun sayısını belirtiniz (Minimum 2 yazmalısınız): ");
            int k = input.nextInt();

            if (n >= 2 && k >= 2) {
                this.fieldRow = n;
                this.fieldCol = k;
                this.dizi = new int[fieldRow][fieldCol];
                isConditions = true;
            } else {
                System.out.println("Hatalı giriş yaptınız, lütfen tekrar deneyiniz.");
            }
        }
    }

    public void field() {
        dizi = new int[fieldRow][fieldCol];

        int totalMines = (fieldRow * fieldCol) / 4;

        for (int i = 0; i < totalMines; i++) {
            int randomRow = (int) (Math.random() * fieldRow);
            int randomCol = (int) (Math.random() * fieldCol);

            if (dizi[randomRow][randomCol] == 1) {
                i--;
            } else {
                dizi[randomRow][randomCol] = 1;
            }
        }

        for (int i = 0; i < fieldRow; i++) {
            for (int j = 0; j < fieldCol; j++) {
                if (dizi[i][j] == 0) {
                    System.out.print("- ");
                } else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void selection() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Satır sayısı: ");
            int row = input.nextInt();

            System.out.print("Sutun sayısı:  ");
            int column = input.nextInt();

            if ((row < fieldRow && row >= 0) && (column < fieldCol && column >= 0)) {
                this.row = row;
                this.col = column;
                break;
            } else {
                System.out.println("=========================================================================================================");
                System.out.println("Girdiğiniz sayı tarlanın boyutunda, boyutundan daha büyük ya da 0'dan küçük olamaz, lütfen tekrar giriniz");
                System.out.println("=========================================================================================================");
            }
        }
    }

    public int ustKontrol(int row, int col) {
        if (row - 1 >= 0 && col >= 0 && row - 1 < fieldRow && col < fieldCol) {
            if (dizi[row - 1][col] == 1) {
                return 1;
            }
        }
        return 0;
    }

    public int ustSagKontrol(int row, int col) {
        if (row - 1 >= 0 && col + 1 >= 0 && row - 1 < fieldRow && col + 1 < fieldCol) {
            if (dizi[row - 1][col + 1] == 1) {
                return 1;
            }
        }
        return 0;
    }

    public int ustSolKontrol(int row, int col) {
        if (row - 1 >= 0 && col - 1 >= 0 && row - 1 < fieldRow && col - 1 < fieldCol) {
            if (dizi[row - 1][col - 1] == 1) {
                return 1;
            }
        }
        return 0;
    }

    public int solKontrol(int row, int col) {
        if (col - 1 >= 0 && row >= 0 && col - 1 < fieldCol && row < fieldRow) {
            if (dizi[row][col - 1] == 1) {
                return 1;
            }
        }
        return 0;
    }

    public int sagKontrol(int row, int col) {
        if (col + 1 >= 0 && row >= 0 && col + 1 < fieldCol && row < fieldRow) {
            if (dizi[row][col + 1] == 1) {
                return 1;
            }
        }
        return 0;
    }

    public int altKontrol(int row, int col) {
        if (row + 1 >= 0 && col >= 0 && row + 1 < fieldRow && col < fieldCol) {
            if (dizi[row + 1][col] == 1) {
                return 1;
            }
        }
        return 0;
    }

    public int altSagKontrol(int row, int col) {
        if (row + 1 >= 0 && col + 1 >= 0 && row + 1 < fieldRow && col + 1 < fieldCol) {
            if (dizi[row + 1][col + 1] == 1) {
                return 1;
            }
        }
        return 0;
    }

    public int altSolKontrol(int row, int col) {
        if (row + 1 >= 0 && col - 1 >= 0 && row + 1 < fieldRow && col - 1 < fieldCol) {
            if (dizi[row + 1][col - 1] == 1) {
                return 1;
            }
        }
        return 0;
    }

    public void game() {
        // Boolean ile win'e yanlış verildi ki mayın seçilirse win'in doğruya dönüp oyunu sonlandırması sağlansın
        boolean win = false;
        while (!win) {
            // Eğer girilen satır ve sütun numarası 1'e eşitse (mayın seçildiyse) oyunu sonlandır
            if (dizi[row][col] == 1) {
                System.out.println("Mayına bastınız, oyun bitti");
                // Eğer koşul sağlanıyorsa win değerini true'ya çevir ki oyun sonlansın
                win = true;
                // Eğer girilen satır ve sütun numarası 1'e eşit değilse, (mayın seçilmediyse) döngüyü başlat
            } else if (dizi[row][col] != 1) {


                // Tahtayı ekrana yazdırma döngüsü
                for (int i = 0; i < fieldRow; i++) {
                    for (int j = 0; j < fieldCol; j++) {
                        // Seçilen hücrenin her tarafını kontrol etme mekanizması
                        int mineTracker = ustKontrol(row, col) + ustSagKontrol(row, col) + ustSolKontrol(row, col) + solKontrol(row, col) + sagKontrol(row, col) + altKontrol(row, col) + altSolKontrol(row, col) + altSagKontrol(row, col);
                        // Eğer satır numarası ilk döngüye eşitse ve sütun numarası ikinci döngüye eşitse
                        if (i == row && j == col) {
                            // Ekrana etraftaki mayınları bastır
                            System.out.print(mineTracker + " ");
                            // Eğer ilk ve ikinci döngü 0'a eşitse boş alan yerine "-" bastır
                        } else if (dizi[i][j] == 0) {
                            System.out.print("- ");
                            // Kalan mayınları gizlemek için - kullan
                        } else {
                            System.out.print("- ");
                        }
                    }
                    // Her satırdan sonra bir alt satıra in
                    System.out.println();
                }
            }
            // Mayına basılmadıysa devamı için uyarı mesajı
            System.out.println("Mayına basmadınız, devam edin");
            // Mayına basılmadıysa kullanıcıdan tekrar satır ve sütun bilgisi alınmalı
            selection();
        }
    }
}