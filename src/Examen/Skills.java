package Examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Skills {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numeroHabilidades= scan.nextInt();
        int numeroCaminos = scan.nextInt();
        List<Arista> habilidades = new ArrayList<>();
        for(int i=0;i<numeroCaminos;i++){
            Arista a = new Arista(scan.nextInt(),scan.nextInt(),scan.nextInt());
            habilidades.add(a);
        }

        Collections.sort(habilidades);
        System.out.println(costesMinimos(habilidades,numeroHabilidades));

    }
    public static int costesMinimos(List<Arista> lista, int nHab){
        int costeMinimo = 0;
        int nodosVisitados= 0;
        boolean[] visitados = new boolean[nHab+1];
        for(int i=0;i<nHab;i++){
            if ((visitados[lista.get(i).fin]==false) && (visitados[lista.get(i).inicio]==false)){
                visitados[lista.get(i).inicio]=true;
                costeMinimo += lista.get(i).coste;
                nodosVisitados++;
            }

        }
        return costeMinimo;
    }
    public static class Arista implements Comparable{
        int inicio;
        int fin;
        int coste;

        public Arista(int inicio, int fin, int coste) {
            this.inicio = inicio;
            this.fin = fin;
            this.coste = coste;
        }
        @Override
        public int compareTo(Object o) {
            Arista a = (Arista)o;
            return Integer.compare(this.coste,a.coste);
        }
    }
}
/*
Test de ejemplo

5 6
1 2 5
1 3 2
2 4 1
3 4 3
3 5 5
4 5 3

9

7 8
1 2 1
1 5 5
1 6 2
2 6 1
3 7 4
4 7 3
5 3 1
6 7 2

12
 */

