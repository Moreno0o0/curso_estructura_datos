public class ADT_2D <T>{
    private int FILA;
    private int COLUMNA;
    private Object[][] tablero;


    public ADT_2D(int filas, int columnas){
        this.FILA = filas;
        this.COLUMNA = columnas;
        this.tablero = new Object[filas][columnas];
    }

    public T obtenerElemento(int fila, int columna){
        if((fila >= 0 && fila < FILA) && (columna >= 0 && columna < COLUMNA) ) {
            return (T) tablero[fila][columna];
        }else{
            throw new ArrayIndexOutOfBoundsException("indice fuera de rango: " +" fila: " + fila + " columna: " + columna);
        }
    }

    public void insertarElemento(int fila , int columna, T elemento){
        if((fila >= 0 && fila < FILA) && (columna >= 0 && columna < COLUMNA) ) {
            tablero[fila][columna] = elemento;
        }else{
            throw new ArrayIndexOutOfBoundsException("indice fuera de rango:"+" fila: " + fila + " columna: " + columna);

        }
    }

    public int[] tamanio(){
        return new int[]{FILA, COLUMNA};
    }

    public void rellenar(T elemento){
        for(int i = 0; i < FILA; i++){
            for(int j = 0; j < COLUMNA; j++){
                tablero[i][j]=elemento;
            }
        }
    }

    public void imprimir(){
        for(int i = 0; i < FILA; i++){
            System.out.printf("\n");
            System.out.printf(String.valueOf(8-i) + " " ) ;
            for(int j = 0; j < COLUMNA; j++){
                System.out.print(tablero[i][j]+" ");
            }
        }
        System.out.println("\n");
    }
}