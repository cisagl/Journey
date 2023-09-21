package Hafta2;

public class DizilerIleBCiktisiAlmak {
    public static void main(String[] args) {

        String[][] yildiz = new String[5][3];

        for (int i = 0; i < yildiz.length; i++) {
            for (int j = 0; j < yildiz[i].length; j++) {
                if (i == 0 || i == 2 || i == 4) {
                    yildiz[i][j] = " *";
                } else if (i == 1 && j == 0 || i == 1 && j == 2) {
                    yildiz[i][j] = " *";
                } else if (i == 3 && j == 0 || i == 3 && j == 2) {
                    yildiz[i][j] = " *";
                } else {
                    yildiz[i][j] = " ";
                }
            }
        }

        for (String[] row : yildiz) {
            for (String column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
}
