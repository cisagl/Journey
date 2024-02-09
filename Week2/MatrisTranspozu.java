package Hafta2;

public class MatrisTranspozu {
    public static void main(String[] args) {

        int[][] matris = {
                {9,8,2},
                {55,66,48},
        };

        int rowNum = matris.length;
        int colNum = matris[0].length;

        int [][] transpoze = new int [colNum][rowNum];

        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < colNum; j++){
                transpoze[j][i] = matris[i][j];
            }
        }

        for (int i = 0; i < colNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                System.out.print(transpoze[i][j] + " ");
            }
            System.out.println();
        }

    }
}