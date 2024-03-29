 package Segundo_Parcial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class CasiSudoku {
        private static int contadorSoluciones=0;
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            List<Integer> sudoku[] = new ArrayList[9];
            for (int i = 0; i < 9; i++) {
                sudoku[i] = new ArrayList<>(9);
                for (int j = 0; j < 9; j++) {
                    sudoku[i].add(j, scan.nextInt());
                }
            }
            sudokuBackTracking(sudoku, 0, 0);
            if(contadorSoluciones==0){
                System.out.println("imposible");
            }
            if(contadorSoluciones==1){
                for(int l=0;l<9;l++) {
                    for (int m = 0; m < 9; m++) {
                        System.out.print(sudoku[l].get(m) + " ");
                    }
                    System.out.println();
                }
            }
            if (contadorSoluciones>=2){
                System.out.println("casi sudoku");
            }
        }

        public static void sudokuBackTracking(List<Integer> lista[], int posX, int posY) {
            if (lista[posY].get(posX) == 0) {
                for (int i = 1; i <= 9; i++) {
                    if (pruebaNumero(i, lista, posY, posX)) {
                        lista[posY].set(posX, i);
                        if(posX==8 && posY==8) {
                            contadorSoluciones++;
                        }else {
                            if (posX == 8) {
                                sudokuBackTracking(lista, 0, posY + 1);
                                lista[posY].set(posX, 0);
                            } else {
                                sudokuBackTracking(lista, posX + 1, posY);
                                lista[posY].set(posX, 0);
                            }
                        }
                    }
                }
            }
            if (posX==8 && posY==8) {
                contadorSoluciones++;
            } else {
                if (posX == 8 && lista[posY].get(posX) != 0) {
                    sudokuBackTracking(lista, 0, posY + 1);
                } else if (lista[posY].get(posX) != 0) {
                    sudokuBackTracking(lista, posX + 1, posY);
                }
            }
        }

        private static boolean pruebaNumero(int numeroInicial, List<Integer>[] lista, int posY, int posX) {
            for (int i = 0; i < 9; i++) {
                if (numeroInicial == lista[posY].get(i))
                    return false;
                if (numeroInicial == lista[i].get(posX))
                    return false;
            }
            //Comprobacion del cuadrante
            if (posY < 3) {
                if (posX < 3) {
                    //PrimerCuadrante
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (numeroInicial == lista[j].get(i))
                                return false;
                        }
                    }
                } else if (posX >= 3 && posX < 6) {
                    //SegundoCuadrante
                    for (int i = 3; i < 6; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (numeroInicial == lista[j].get(i))
                                return false;
                        }
                    }
                } else {
                    //TercerCuadrante
                    for (int i = 6; i < 9; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (numeroInicial == lista[j].get(i))
                                return false;
                        }
                    }
                }
            } else if (posY >= 3 && posY < 6) {
                if (posX < 3) {
                    //PrimerCuadrante
                    for (int i = 3; i < 6; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (numeroInicial == lista[i].get(j))
                                return false;
                        }
                    }
                } else if (posX >= 3 && posX < 6) {
                    //SegundoCuadrante
                    for (int i = 3; i < 6; i++) {
                        for (int j = 3; j < 6; j++) {
                            if (numeroInicial == lista[i].get(j))
                                return false;
                        }
                    }
                } else {
                    //TercerCuadrante
                    for (int i = 3; i < 6; i++) {
                        for (int j = 6; j < 9; j++) {
                            if (numeroInicial == lista[i].get(j))
                                return false;
                        }
                    }
                }
            } else {
                if (posX < 3) {
                    //PrimerCuadrante
                    for (int i = 6; i < 9; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (numeroInicial == lista[i].get(j))
                                return false;
                        }
                    }
                } else if (posX >= 3 && posX < 6) {
                    //SegundoCuadrante
                    for (int i = 6; i < 9; i++) {
                        for (int j = 3; j < 6; j++) {
                            if (numeroInicial == lista[i].get(j))
                                return false;
                        }
                    }
                } else {
                    //TercerCuadrante
                    for (int i = 6; i < 9; i++) {
                        for (int j = 6; j < 9; j++) {
                            if (numeroInicial == lista[i].get(j))
                                return false;
                        }
                    }
                }
            }
            return true;
        }
    }

