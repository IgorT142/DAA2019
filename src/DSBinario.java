import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSBinario {
    public static void main(String[] args) {
        int nEnemigos, nCasos, nivelCaballero;
        Scanner scan = new Scanner(System.in);

        nEnemigos = scan.nextInt();
        List<Integer> nivelesEnemigos = new ArrayList<>(nEnemigos);
        for(int i= 0;i < nEnemigos; i++){
            nivelesEnemigos.add(i,scan.nextInt());
        }
        nCasos = scan.nextInt();
        for(int i= 0;i < nCasos; i++){
            nivelCaballero = scan.nextInt();
            batalla(nivelCaballero,nivelesEnemigos);
        }
    }

    public static void batalla(int nivel, List<Integer> lista){
        if(nivel>lista.get(lista.size()-1)){
            printearResultado(lista.size()-1,lista);
        } else if (nivel<lista.get(0)){
            System.out.println("0 0");
        } else {
            int medio = busquedaBinaria(nivel, lista, 0, lista.size()-1);
            printearResultado(medio,lista);
        }

    }
    public static int busquedaBinaria(int nivel, List<Integer> lista, int inicio, int fin){
        int medio = (inicio+fin)/2;
        if(nivel == lista.get(medio))
            return medio;
        if(inicio == medio){
            return inicio;
        }
        if (fin == medio){
            return fin;
        }
        if(lista.get(medio)>nivel)
            return busquedaBinaria(nivel,lista,inicio,medio);
        else if(lista.get(medio)<nivel)
            return busquedaBinaria(nivel,lista,medio,fin);
        return -1;
    }
    public static void printearResultado(int medio, List<Integer> lista){
        int sumaNiveles = 0;
        for (int i = 0;i<=medio;i++) {
            sumaNiveles += lista.get(i);
        }
        System.out.println(medio+1 + " " + sumaNiveles);
    }

}
