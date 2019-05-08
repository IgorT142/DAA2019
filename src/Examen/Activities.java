package Examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Activities {
    public static int actividadesTotales=1;
    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int tCasos = scan.nextInt();
    int nCasos;
    List<Actividad> listaActividades;

    for(int i = 0; i<tCasos;i++){
        nCasos = scan.nextInt();
        listaActividades = new ArrayList<>();
        for (int j = 0;j<nCasos;j++){
            Actividad actividad = new Actividad(scan.nextInt(),scan.nextInt(),scan.nextInt());
            listaActividades.add(actividad);
        }
        Collections.sort(listaActividades);
        actividadesTotales(listaActividades);
        System.out.println(actividadesTotales);
        actividadesTotales=1;
    }

    }

    private static void actividadesTotales(List<Actividad> lista) {
        Actividad ultimaActividadRealizada = lista.get(0);
        for(int i=1;i<lista.size();i++){
            if(ultimaActividadRealizada.fin<=lista.get(i).inicio){
                actividadesTotales++;
                ultimaActividadRealizada = lista.get(i);
            }
        }
    }

    private static class Actividad implements Comparable {
        int inicio;
        int fin;

        public Actividad(int inicio, int fin, int descanso) {
            this.inicio=inicio;
            this.fin=fin+descanso;
        }

        @Override
        public int compareTo(Object o) {
            Actividad a =(Actividad)o;
            return Integer.compare(this.fin,a.fin);
        }
    }
}
