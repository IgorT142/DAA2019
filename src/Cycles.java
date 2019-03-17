import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Cycles {
    public static void main(String[] args) {
        boolean ciclo = false;
        Scanner scan = new Scanner(System.in);
        //System.out.println("Numero de nodos");
        int nNodos = scan.nextInt();
       // System.out.println("Numero de aristas");
        int nAristas = scan.nextInt();
       // System.out.println("Introduzca aristas");

        List<ArrayList<Integer>> listaAdyacencias = new ArrayList<>(nNodos);
        for (int i = 0; i < nNodos+1; i++) {
            listaAdyacencias.add(i, new ArrayList<>());
        }
        for (int i = 0; i < nAristas; i++) {
            int v = scan.nextInt();
            int b = scan.nextInt();
            listaAdyacencias.get(v).add(b);
        }

        Queue<Integer> cola = new LinkedList<>();
        boolean[] visitados = new boolean[nNodos+1];
            for (int i = 0; i < listaAdyacencias.size(); i++) {
                visitados[i] = true;
                if(!listaAdyacencias.get(i).isEmpty()) {
                    for (int j = 0; j < listaAdyacencias.get(i).size(); j++) {
                        if(visitados[i] && visitados[listaAdyacencias.get(i).get(j)]){
                            System.out.println("true");
                            System.exit(1);
                        }
                        if (visitados[listaAdyacencias.get(i).get(j)]) {
                            System.out.println("true");
                            System.exit(1);
                        } else {
                            visitados[listaAdyacencias.get(i).get(j)] = true;
                            //cola.add(listaAdyacencias.get(i).get(j));
                        }
                    }
                }
            }
        System.out.println("false");
    }
}