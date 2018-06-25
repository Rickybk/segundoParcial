import java.util.Scanner;

/**
 * Migrado de Bluej a IntelliJ 24062018
 * @author Dorian Flores Lopez
 * @version 25062018
 */
public class Principal {
    static int[] coordUno,coordDos;
    static int columnas;
    static int filas;
    static int inicio,destino;
    static Tablero tab;

    Principal(int columnas,int filas) {
        this.columnas = columnas;
        this.filas    = filas;
        tab = new Tablero(columnas, filas);
    }
    public static void trazadoPosible(int inicio,int destino){
        coordUno = tab.detectorCoordenadas(inicio);
        coordDos = tab.detectorCoordenadas(destino);
        //De momento todas las flechas funcionan solamente de izquierda
        //a derecha, de arriba hacia abajo.
        if ((coordUno[0] == coordDos[0]) || (coordUno[0] + 1 == coordDos[0])) {
            //en este caso las filas son paralelas
            //flecha hacia la derecha
            tab.filasParalelas(coordUno, coordDos);
            System.out.println("Las filas son paralelas");
        } else if (coordUno[1] == coordDos[1] || (coordUno[1] + 1 == coordDos[1])) {
            //en este caso las columnas son paralelas
            //flecha hacia abajo
            tab.columnasParalelas(coordUno, coordDos);
            System.out.println("Las columnas son paralelas");
        } else {
            //Diagonal
            tab.trazarDiagonal(coordUno, coordDos);
            System.out.println("Es diagonal");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de las columnas");
        columnas = sc.nextInt();
        System.out.println("Ingrese el valor de las filas");
        filas = sc.nextInt();
        Principal principal = new Principal(columnas,filas);
        System.out.println("Ingrese el numero de inicio");
        inicio = sc.nextInt();
        System.out.println("Ingrese el numero de destino");
        destino = sc.nextInt();
        principal.trazadoPosible(inicio,destino);
    }
}
