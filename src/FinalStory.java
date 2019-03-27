import java.util.*;

public class FinalStory {
    public static void main(String[] args) {
        int combates, atkJugador, nEnemigos;
        Scanner scan = new Scanner(System.in);
        combates = scan.nextInt();

        for (int i = 0; i < combates; i++) {
            List<Enemigo> enemigos = new ArrayList<>();
            atkJugador = scan.nextInt();
            nEnemigos = scan.nextInt();
            for (int j = 0; j < nEnemigos; j++) {
                Enemigo e = new Enemigo();
                e.setAtk(scan.nextInt());
                enemigos.add(e);
            }
            for (Enemigo e:
                 enemigos) {
                e.setHp(scan.nextInt());
                e.setPrioridad(atkJugador);
            }
            Collections.sort(enemigos);
            Queue<Enemigo> prioridadAtaque = new LinkedList<>();
            for (Enemigo e:
                    enemigos) {
                prioridadAtaque.add(e);
            }
            System.out.println(batalla(prioridadAtaque,atkJugador));
        }


    }
    public static Integer batalla(Queue<Enemigo> enemigos, int atkJugador){
        int dmgRecibido =0;
        while(!enemigos.isEmpty()){
            for (Enemigo e:
                 enemigos) {
                dmgRecibido += e.getAtk();
            }
            if(enemigos.peek().recibeDmg(atkJugador)<=0)
                enemigos.remove();
        }
        return dmgRecibido;
    }


    public static class Enemigo implements Comparable{
        int atk,hp;
        double prioridad;

        public Enemigo() {

        }

        public int getAtk() {
            return atk;
        }

        public void setAtk(int atk) {
            this.atk = atk;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public double getPrioridad() {
            return prioridad;
        }

        public void setPrioridad(int dmgPj) {
            int ataquesNecesarios= hp/dmgPj;
            if (ataquesNecesarios==0) ataquesNecesarios=1;
            this.prioridad = (double)atk/ataquesNecesarios;
        }

        public Enemigo(int a, int h){
            this.atk = a;
            this.hp = h;
            this.prioridad = (double)a/(double)h;
        }
        public int recibeDmg(int dmg){
            this.hp -= dmg;
            return this.hp;
        }

        @Override
        public int compareTo(Object o) {
            Enemigo e = (Enemigo)o;
            if(Double.compare(e.prioridad,prioridad)==0){
                if(Double.compare(e.atk,atk) == 0){
                    return Double.compare(hp,e.hp);
                } else
                return Double.compare(e.atk,atk);
            } else
            return Double.compare(e.prioridad,prioridad);
        }
    }

}
