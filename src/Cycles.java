import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Cycles {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Numero de nodos");
        int nNodos = scan.nextInt();
        System.out.println("Numero de aristas");
        int nAristas = scan.nextInt();
        System.out.println("Introduzca aristas");

        List<ArrayList<Integer>> listaAdyacencias = new ArrayList<>(nNodos);
        for (int i = 0; i < nNodos; i++){
            listaAdyacencias.add(i, new ArrayList<>());
        }
        for (int i = 0; i < nAristas; i++) {
            int v = scan.nextInt();
            int b = scan.nextInt();
            listaAdyacencias.get(v).add(b);
        }

        Queue<Integer> cola = new LinkedList<>();
        boolean[] visitados = new boolean[nNodos];
        cola.add(listaAdyacencias.get(0).get(0));
        while(!cola.isEmpty()){
            
        }
    }
}
