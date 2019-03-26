import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DarkSouls {
    public static void main(String[] args) {
        int nPiezas, pesoMax;
        String modo;
        Scanner scan = new Scanner(System.in);
        nPiezas = scan.nextInt();
        pesoMax = scan.nextInt();
        modo = scan.next();
        List<Objeto> inventario = new ArrayList<>(nPiezas);
        for (int i = 0; i < nPiezas; i++) {
            Objeto objeto = new Objeto(scan.next(), scan.nextInt(), scan.nextInt());
            inventario.add(objeto);
        }
        Collections.sort(inventario);
        getBestItems(inventario, modo, pesoMax);

    }

    public static void getBestItems(List<Objeto> lista, String modo, int pMax) {
        double pesoRelativoMin = 0, pesoRelativoMax = 0;
        switch (modo) {
            case "ligero":
                pesoRelativoMax = 0.50 * pMax;
                break;
            case "medio":
                pesoRelativoMin = 0.50 * pMax;
                pesoRelativoMax = 0.75 * pMax;
                break;
            case "pesado":
                pesoRelativoMin = 0.75 * pMax;
                pesoRelativoMax = pMax;
                break;
        }
        double armaduraTotal = 0, pesoAcumulado = 0;
        List<String> equipo = new ArrayList<>();
        for (Objeto o :
                lista) {
            if (pesoAcumulado < pesoRelativoMax) {
                if ((o.peso + pesoAcumulado) > pesoRelativoMax) {
                    equipo.add(o.nombre);
                    double nuevoValorRelativo = o.defensa * ((pesoRelativoMax - pesoAcumulado) / o.peso);
                    armaduraTotal+= nuevoValorRelativo;
                    pesoAcumulado+= o.peso;
                    break;
                } else {
                    equipo.add(o.nombre);
                    armaduraTotal+=o.defensa;
                    pesoAcumulado+= o.peso;
                }
            }
        }
        Collections.sort(equipo);
        System.out.printf("%.2f",armaduraTotal);
        System.out.println();
        for (String s:
             equipo) {
            System.out.println(s);
        }

    }

    private static class Objeto implements Comparable {
        int peso, defensa;
        float valor;
        String nombre;

        public Objeto(String n, int p, int d) {
            this.peso = p;
            this.defensa = d;
            this.nombre = n;
            this.valor = (float) d / (float) p;
        }

        @Override
        public int compareTo(Object o) {
            Objeto item = (Objeto) o;
            return Float.compare(item.valor, valor);
        }
    }
}
