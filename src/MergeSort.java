import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N;
        N = scan.nextInt();
        int[] lista = new int[N];
        for (int i = 0; i < N; i++) {
            lista[i] = scan.nextInt();
        }
        if (N >= 1) {
            mergeSort(lista,0,N-1);
        }
        for (Integer i:
             lista) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] lista, int inicio, int fin) {

            if(inicio<fin) {
                int mitad = (inicio + (fin-inicio) / 2);

                mergeSort(lista, inicio, mitad);
                mergeSort(lista, mitad + 1, fin);

                merge(lista, inicio, mitad , fin);
            }
    }

    public static void merge(int[] lista, int inicio, int mitad, int fin) {

        int n1 = mitad - inicio + 1;
        int n2 = fin - mitad;

        int izq[] = new int[n1];
        int der[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            izq[i] = lista[inicio + i];
        }
        for (int j = 0; j < n2; ++j) {
            der[j] = lista[mitad + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = inicio;

        while(i<n1 && j<n2){
            if(izq[i]<=der[j]){
                lista[k]=izq[i];
                i++;
            }
            else {
                lista[k] = der[j];
                j++;
            }
            k++;
        }
        while (i<n1){
            lista[k]=izq[i];
            i++;
            k++;
        }
        while (j<n2){
            lista[k] = der[j];
            j++;
            k++;
        }
    }
}
