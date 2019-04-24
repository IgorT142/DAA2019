package Primer_Parcial;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args){
        int n,m,s;
        Scanner scan = new Scanner(System.in);
        String datos = scan.nextLine();
        String[] datosSeparados = datos.split(" ");
        /*Asignacion de datos del string a variables*/
        n = Integer.parseInt(datosSeparados[0]);
        m = Integer.parseInt(datosSeparados[1]);
        s = Integer.parseInt(datosSeparados[2]);

        ArrayList[] lista3 = new ArrayList[n];
        for (int j=0;j<n;j++){
            lista3[j] = new ArrayList();
        }

        /*Listas de adyacencia*/
        for(int i=0;i<n;i++){
            String vertices = scan.nextLine();
            String[] verticesSeparados = vertices.split(" ");
            int v = Integer.parseInt(verticesSeparados[0]);
            int u = Integer.parseInt(verticesSeparados[1]);
            lista3[v].add(u);
            lista3[u].add(v);
            }
        ArrayList recorrido = bfs(lista3,s,n);
        for (int k = 0; k < n; k++){
            System.out.print(recorrido.get(k) + " ");
        }

    }
    public static ArrayList bfs(ArrayList[] lista, int vi, int n){
        boolean[] visitados = new boolean[n];
        Queue<Integer> cola = new LinkedList<>();
        ArrayList<Integer> recorrido = new ArrayList<>(n);
        recorrido.add(vi);
        recorrido.addAll(lista[vi]);
        cola.addAll(lista[vi]);
        visitados[vi] = true;
        while (!cola.isEmpty()){
            if (!visitados[cola.element()]){
                visitados[cola.element()]= true;
                cola.addAll(lista[cola.poll()]);
                recorrido.addAll(lista[cola.remove()]);
            }
            else
            {
                cola.remove();
            }
        }
        return recorrido;
    }
}
