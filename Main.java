/**
 * 
 *
 * @author Dorian Flores Lopez, Andrea Cosme Cruz
 * @version 14062018
 */
public class Main
{
    int [] coordUno;
    int [] coordDos;
    Tablero tab;
    public Main(int columnas,int filas){
        tab = new Tablero(columnas,filas);     
    }
    
    public void trazadoPosible(int inicio,int destino){
        coordUno = tab.detectorCoordenadas(inicio);
        coordDos = tab.detectorCoordenadas(destino);
        //De momento todas las flechas funcionan solamente de izquierda 
        //a derecha, de arriba hacia abajo.
        if((coordUno[0]==coordDos[0])||(coordUno[0]+1==coordDos[0])){
            //en este caso las filas son paralelas
            //flecha hacia la derecha
            tab.filasParalelas(coordUno,coordDos);
            System.out.println("Las filas son paralelas");
        } else if(coordUno[1]==coordDos[1]||(coordUno[1]+1==coordDos[1])){
            //en este caso las columnas son paralelas
            //flecha hacia abajo
            tab.columnasParalelas(coordUno,coordDos);
            System.out.println("Las columnas son paralelas");
            } else {
            //Diagonal 
            tab.trazarDiagonal(coordUno,coordDos);
            System.out.println("Es diagonal");
            }
    }
}
