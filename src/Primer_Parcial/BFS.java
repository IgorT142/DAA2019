package Primer_Parcial;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nNodos, nAristas, nodoInicial;
        //System.out.println("Numero de nodos");
        nNodos = scan.nextInt();
        //System.out.println("Numero de aristas");
        nAristas = scan.nextInt();
       // System.out.println("Nodo inicial");
        nodoInicial = scan.nextInt();

        ArrayList<Integer> list[] = new ArrayList[nNodos+1];
        for (int i = 0; i <= nNodos; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < nAristas; i++) {
            int v = scan.nextInt();
            int u = scan.nextInt();
            list[v].add(u);
            list[u].add(v);
        }
        bfs(list,nodoInicial,nNodos);
    }

    public static void bfs(ArrayList<Integer> lista[], int nInicial, int nNodos) {
        List<Integer> traversal = new ArrayList<>(lista.length);
        Queue<Integer> cola = new LinkedList<>();
        boolean[] visitados = new boolean[lista.length];
        visitados[nInicial] = true;
        traversal.add(nInicial);
        cola.add(nInicial);
        while (!cola.isEmpty()) {
            int aux = cola.remove();
            for (int adj : lista[aux]) {
                if (!visitados[adj]) {
                    visitados[adj] = true;
                    traversal.add(adj);
                    cola.add(adj);
                }
            }
        }
        for(int i = 0;i<traversal.size();i++) {
            System.out.print(traversal.get(i) + " ");
        }
    }
}
