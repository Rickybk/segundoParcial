/**
 * Generador y mostrador del tablero.
 *
 * @author Dorian Flores Lopez
 * @version 11062018
 */
public class Tablero 
{
    public int[][] matriz;
    public int[] coordUno;
    public int[] coordDos;
    public int contador,i,j,x,y;
    public boolean pivot;

    public Tablero(int columnas,int filas)
    {
        contador = 0;
        pivot    = true;
        matriz   = new int [filas][columnas];
        rellenarNumeros();
        reemplazarCeros();
        mostrar();
    }

    private void rellenarNumeros()
    {
        for(i = 0;i<matriz.length;i++){
            if(pivot){
                //primer rellenado
                for(j = 0;j<matriz[0].length;j+=2){
                    matriz[i][j] = contador;
                    contador++;

                }   
                pivot=false;
            }  else {
                //segundo rellenado
                for(j = 1;j<matriz[0].length;j+=2){
                    matriz[i][j] = contador;
                    contador++;

                }
                pivot = true;
            } 
        }
    }

    public void mostrar(){
        for(int[] fila : matriz) {
            imprimirFila(fila);
        }
    }

    private  void imprimirFila(int[] fila) {
        for (int i : fila) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    private void reemplazarCeros(){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                if(matriz[i][j]==0){
                    matriz[i][j]= -2;
                }
            }
        }
        matriz[0][0] = 0;
    }
    
    public int[] detectorCoordenadas(int valor){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                if(matriz[i][j]==valor){
                    x = i;
                    y = j;
                }
            }
        }
        return new int []{x,y};
    }
    
    public void numerosToCoordenadas(int inicio,int destino){
        coordUno=detectorCoordenadas(inicio);
        coordDos=detectorCoordenadas(destino);
    }
    
    public void trazarDiagonal(int[]coordUno,int[]coordDos){
        int i = coordUno[0];
        int j = coordUno[1];
        while(i<coordDos[0]){
            matriz[i][j+1] = -1;
            i++;
            j++;
        }
        System.out.print('\u000C');
        mostrar();
    }
    
    public void filasParalelas(int[]coordUno,int[]coordDos){
        for(i = coordUno[1]+1;i<=coordDos[1]-1;i++){
            for(j=coordUno[0];j<=coordUno[0]+1;j++){
                if(matriz[j][i]<0){
                    matriz[j][i] = -1;
                } else {
                    //nada que hacer
                }
            }
        }
        System.out.print('\u000C');
        mostrar();
    }
    
    public void columnasParalelas(int[]coordUno,int[]coordDos){
        for(int i=coordUno[0]+1;i<=coordDos[0]-1;i++){
            for(int j=coordUno[1];j<=coordUno[0]+1;j++){
                if(matriz[i][j]<0){
                    matriz[i][j] = -1;
                } else {
                    //nada que hacer
                }
            }
        }
        System.out.print('\u000C');
        mostrar();
    }    
}    