package Examen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KillRange {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> lista = new ArrayList<>(n);

        for(int i = 0;i<n;i++){
            lista.add(scan.nextInt());
        }
        int q = scan.nextInt();
        for (int i = 0;i<q;i++){
            int menor = scan.nextInt();
            int mayor = scan.nextInt();
            System.out.println(busquedaBin(lista,menor,0,lista.size()) + " " + busquedaBin(lista,mayor,0,lista.size()));
        }
    }

    private static int busquedaBin(List<Integer> lista, int valor,int inicio, int fin) {
        int medio = (inicio+fin)/2;
        int valorMedio = lista.get(medio);
        if (valorMedio==valor){
            return medio;
        }
        if (valorMedio<valor)
            return busquedaBin(lista,valor,medio,fin);
        else
            return busquedaBin(lista,valor,0,medio);
    }
}
