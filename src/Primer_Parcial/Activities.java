package Primer_Parcial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Activities {
    public static void main(String[] args) {
        int casos, actividades;
        Scanner scan = new Scanner(System.in);
        casos = scan.nextInt();
        List<Activity>[] listaActividades = new List[casos];
        for (int i = 0; i < casos; i++) {
            listaActividades[i] = new ArrayList<>();
        }
        for (int i = 0; i < casos; i++) {
            actividades = scan.nextInt();
            for (int j = 0; j < actividades; j++) {
                Activity actividad = new Activity(scan.nextInt(), scan.nextInt());
                listaActividades[i].add(j, actividad);
            }
        }
        for (int i = 0; i < casos; i++) {
            Collections.sort(listaActividades[i]);
        }

        for (int i = 0; i < casos; i++) {
            int numActividades = 1;
            int ultimaActividadEscogida = 0;
            for(int j=1; j< listaActividades[i].size(); j++){
                if(listaActividades[i].get(ultimaActividadEscogida).fin <=
                        listaActividades[i].get(j).inicio){
                    numActividades++;
                    ultimaActividadEscogida = j;
                }
            }
            System.out.println(numActividades);
        }
    }

    private static class Activity implements Comparable {
        public int inicio, fin;

        public Activity(int inicio, int fin) {
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        public int compareTo(Object o) {
            Activity a = (Activity) o;
            if (this.fin > a.fin) {
                return 1;
            } else if (this.fin < a.fin) {
                return -1;
            } else
                return 0;
        }
    }
}
