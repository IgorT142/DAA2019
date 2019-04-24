package Segundo_Parcial;

import java.util.Scanner;

public class Lab {
    private static int minPath;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int labSize = input.nextInt();
        int[][] lab = new int[labSize][labSize];

        for(int i = 0; i < labSize; i++) {
            for(int j = 0; j < labSize; j++) {
                lab[i][j] = input.nextInt();
            }
        }

        /* Find all solutions and take the minimum */
        minPath = labSize * labSize + 1;

        btLabAll(lab);

        if(minPath == labSize * labSize + 1) {
            System.out.println("SIN SOLUCION");
        }
        else {
            System.out.println(minPath);
        }

        /* Find one solution */
        /*boolean solved = btLab(lab);

        if(solved)
            System.out.println(lab[labSize - 1][labSize - 1]);
        else
            System.out.println("SIN SOLUCION");*/
    }

    /*private static boolean btLab(int[][] lab) {
        return btLab(lab, 0, 0, 1);
    }

    private static boolean btLab(int[][] lab, int row, int col, int step) {
        boolean success = false;
        lab[col][row] = step;

        if(col == lab.length - 1 && row == lab[0].length - 1)
            return true;
        else {
            if(isFeasible(lab, row + 1, col)) {
                success = btLab(lab, row + 1, col, step + 1);
            }
            else if(isFeasible(lab, row, col + 1)) {
                success = btLab(lab, row, col + 1, step + 1);
            }
            else if(isFeasible(lab, row - 1, col)) {
                success = btLab(lab, row - 1, col, step + 1);
            }
            else if(isFeasible(lab, row, col - 1)) {
                success = btLab(lab, row, col - 1, step + 1);
            }

            lab[col][row] = 0;

            return success;
        }
    }*/

    private static void btLabAll(int[][] lab) {
        btLabAll(lab, 0, 0, 1);
    }

    private static void btLabAll(int[][] lab, int row, int col, int step) {
        //boolean success = false;
        lab[col][row] = step;

        if(col == lab.length - 1 && row == lab[0].length - 1) {
            if(minPath > step)
                minPath = step;
            //return true;
        }
        else {
            if(isFeasible(lab, row + 1, col)) {
                //test(lab);
                btLabAll(lab, row + 1, col, step + 1);
                lab[col][row + 1] = 0;
                //success = btLab(lab, row + 1, col, step + 1);
            }
            // No else if
            if(isFeasible(lab, row, col + 1)) {
                //test(lab);
                btLabAll(lab, row, col + 1, step + 1);
                lab[col + 1][row] = 0;
                //success = btLab(lab, row, col + 1, step + 1);
            }
            if(isFeasible(lab, row - 1, col)) {
                //test(lab);
                btLabAll(lab, row - 1, col, step + 1);
                lab[col][row - 1] = 0;
                //success = btLab(lab, row - 1, col, step + 1);
            }
            if(isFeasible(lab, row, col - 1)) {
                //test(lab);
                btLabAll(lab, row, col - 1, step + 1);
                lab[col - 1][row] = 0;
                //success = btLab(lab, row, col - 1, step + 1);
            }

            //lab[col][row] = 0;

            //return success;
        }
    }

    private static boolean isFeasible(int[][] lab, int row, int col) {
        // Exception out of bounds control
        if(col < lab.length && col >= 0 && row < lab[0].length && row >= 0)
            return (lab[col][row] == 0);
        else
            return false;
    }

    /*private static void print(int[][] lab) {
        int labSize = lab.length;
        for(int i = 0; i < labSize; i++) {
            for(int j = 0; j < labSize; j++) {
                System.out.print("\t" + lab[i][j]);
            }
            System.out.println();
        }
    }

    private static void test(int[][] lab) {
        print(lab);
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }*/
}