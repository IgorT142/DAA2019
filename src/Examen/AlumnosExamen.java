package Examen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlumnosExamen {
    public static void main(String[] args) {

        int numeroAlumnos;
        int numeroRelaciones;
        int numeroModelos;
        Scanner scan = new Scanner(System.in);
        numeroAlumnos = scan.nextInt();
        numeroRelaciones = scan.nextInt();
        numeroModelos = scan.nextInt();
        List<Nodo> lista = new ArrayList();
        for (int i = 0; i < numeroAlumnos; i++) {
            Nodo nodo = new Nodo();
            lista.add(nodo);
        }
        for (int i = 0; i < numeroRelaciones; i++) {
            int v = scan.nextInt();
            int u = scan.nextInt();
            lista.get(v).getRelaciones().add(lista.get(u));
            lista.get(u).getRelaciones().add(lista.get(v));
        }
        if (coloreadoGrafos(lista,lista.get(0),0,numeroModelos, numeroAlumnos)){
            System.out.println("OK");
        } else{
            System.out.println("NO HAY SUFICIENTE");
        }
    }

    private static boolean coloreadoGrafos(List<Nodo> alumnos, Nodo alumno,int nAlumno, int modelos, int numeroAlumnos){
    //caso base
        if (numeroAlumnos-1 == nAlumno){
            return true;
        }
        for(int i=0;i<modelos;i++) {
            alumno.examenAsignado=i;

            if(isFeasible(alumnos,alumno)){
                if (coloreadoGrafos(alumnos,alumnos.get(nAlumno+1),nAlumno+1,modelos,numeroAlumnos))
                return true;
            }
            alumno.examenAsignado=-1;
        }
        return false;
    }

    private static boolean isFeasible(List<Nodo> alumnos, Nodo alumno) {
        for(int i= 0;i <alumno.relaciones.size();i++){
            if(alumno.relaciones.get(i).examenAsignado==alumno.examenAsignado){
                return false;
            }
        }
        return true;
    }

    private static class Nodo {
        int examenAsignado;
        List<Nodo> relaciones = new ArrayList<>();

        public Nodo() {
            examenAsignado = -1;
        }

        public List<Nodo> getRelaciones() {
            return relaciones;
        }


    }
}

