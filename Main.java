import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

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
        String[] lista = new String[m];
        String[][] listaVertices = new String[n][];
        ArrayList[] lista3 = new ArrayList[n];
        for(int i=0;i<n;i++){
            String vertices = scan.nextLine();
            String[] verticesSeparados = vertices.split(" ");
            int v = Integer.parseInt(verticesSeparados[0]);
            int u = Integer.parseInt(verticesSeparados[1]);
            listaVertices[i] = verticesSeparados;
            lista3[v].add(u);
            lista3[u].add(v);
        }
        System.out.println(lista3[0]);
    }
}
