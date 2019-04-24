package Segundo_Parcial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Labyrinth {
    private static int pasosMin;

    public static void main(String[] args) {
        int sol = 655;
        Scanner scan = new Scanner(System.in);
        int N;
        N = scan.nextInt();
        List<Integer> matriz[] = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            matriz[i] = new ArrayList<>(N);
            for (int j = 0; j < N; j++) {
                matriz[i].add(scan.nextInt());
            }
        }
        pasosMin = N * N;
        backTracking(matriz, 0, 0, N, 1);
        if (pasosMin != N * N) {
            System.out.println(pasosMin);
        } else {
            System.out.println("SIN SOLUCION");
        }
    }

    public static void backTracking(List<Integer> matriz[], int x, int y, int N, int pasos) {
        // System.out.println("Estoy en : " + x + " , " + y);
        matriz[y].set(x, pasos);
        if (x == N - 1 && y == N - 1) {
            if (pasos < pasosMin) {
                pasosMin = pasos;
            }
        }
        if (x < N - 1) {
            if (matriz[y].get(x + 1) == 0) {
                backTracking(matriz, x + 1, y, N, pasos + 1);
                matriz[y].set(x + 1, 0);
            }
        }
        if (y < N - 1) {
            if (matriz[y + 1].get(x) == 0) {
                backTracking(matriz, x, y + 1, N, pasos + 1);
                matriz[y + 1].set(x, 0);
            }
        }
        if (y >= 1) {
            if (matriz[y - 1].get(x) == 0) {
                backTracking(matriz, x, y - 1, N, pasos + 1);
                matriz[y - 1].set(x, 0);
            }
        }
        if (x >= 1) {
            if (matriz[y].get(x - 1) == 0) {
                backTracking(matriz, x - 1, y, N, pasos + 1);
                matriz[y].set(x - 1, 0);
            }
        }
    }
}
