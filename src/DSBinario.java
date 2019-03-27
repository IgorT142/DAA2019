import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSBinario {
    public static void main(String[] args) {
        int nEnemigos, nCasos;
        long nivelCaballero;
        Scanner scan = new Scanner(System.in);
        nEnemigos = scan.nextInt();
        List<Long> listaDaños = new ArrayList<>(nEnemigos);
        List<Long> nivelesEnemigos = new ArrayList<>(nEnemigos);
        long nivelAcumulado =0;
        for(int i= 0;i < nEnemigos; i++){
            nivelesEnemigos.add(i,scan.nextLong());
            nivelAcumulado += nivelesEnemigos.get(i);
            listaDaños.add(i, nivelAcumulado);
        }
        nCasos = scan.nextInt();
        for(int i= 0;i < nCasos; i++){
            nivelCaballero = scan.nextLong();
            batalla(nivelCaballero,nivelesEnemigos,listaDaños);
        }
    }

    public static void batalla(long nivel, List<Long> lista, List<Long> listaDmg){
        if(nivel>lista.get(lista.size()-1)){
            printearResultado(lista.size()-1,listaDmg);
        } else if (nivel<lista.get(0)){
            System.out.println("0 0");
        } else {
            int medio = busquedaBinaria(nivel, lista, 0, lista.size()-1);
            printearResultado(medio,listaDmg);
        }

    }
    public static int busquedaBinaria(long nivel, List<Long> lista, int inicio, int fin){
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
    public static void printearResultado(int medio, List<Long> lista){
        System.out.println(medio+1 + " " + lista.get(medio));
    }

}
