package Examen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Thanos {
    static int ciclos;

    public static void main(String[] args) {

        int numeroPlanetas;
        int numeroConexiones;
        Scanner scan = new Scanner(System.in);

        numeroPlanetas = scan.nextInt();
        numeroConexiones = scan.nextInt();
        List<Planeta> mapa = new ArrayList<>();
        for(int i = 0;i<numeroPlanetas;i++){
            mapa.add(new Planeta());
        }
        for (int i = 0; i < numeroConexiones; i++) {
            Planeta p1 = new Planeta(scan.nextInt());
            Planeta p2 = new Planeta(scan.nextInt());
            mapa.get(p1.planeta).adyacentes.add(p2);
            mapa.get(p2.planeta).adyacentes.add(p1);
        }
        boolean[] visitados = new boolean[numeroPlanetas];
        visitados[0] = true;
        numeroRecorridos(mapa, 0, numeroPlanetas, 1, visitados);
        System.out.println(ciclos);
    }

    private static boolean numeroRecorridos(List<Planeta> mapa, int pos, int numeroPlanetas, int planetasRecorridos, boolean[] visitados) {
        if (planetasRecorridos == numeroPlanetas ) {
            boolean cicloH = false;
            for(int i = 0;i<mapa.get(pos).adyacentes.size();i++) {
                if (mapa.get(pos).adyacentes.get(i).planeta == 0) {
                    cicloH=true;

                }
            }
            return cicloH;
        }
            for (int j = 0; j < mapa.get(pos).adyacentes.size(); j++) {
                int planetaVisitado = mapa.get(pos).adyacentes.get(j).planeta;
                if (isFeasible(mapa.get(pos).adyacentes.get(j), visitados)) {
                    visitados[planetaVisitado] = true;
                    if (numeroRecorridos(mapa, planetaVisitado, numeroPlanetas, planetasRecorridos + 1, visitados)) {
                        ciclos++;
                    }

                        visitados[planetaVisitado]= false;
                }
            }
            return false;
        }

    private static boolean isFeasible(Planeta planeta, boolean[] visitados) {
        if (!visitados[planeta.planeta]) {
            return true;
        } else {
            return false;
        }
    }

    private static class Planeta {
        int planeta;
        List<Planeta> adyacentes = new ArrayList<>();

        public Planeta(int planeta) {
            this.planeta = planeta;
        }
        public Planeta( ) {
        }
    }
}
/*
5 7
0 1
1 2 1 4 1 3 3 4 0 3
2 4
 */