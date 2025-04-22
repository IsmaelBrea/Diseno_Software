package e2;

import java.util.Arrays;

//creamos nuestra clase ImmutableMatrix
public class ImmutableMatrix {
    private final int[][] matriz; //creamos la matriz privada (inmutable) que almacenarán los valores

    //creamos el primer constructor que acepta un array bidimensional de valores enteros
    public ImmutableMatrix(int[][] arr) {
        //comprobamos si el array es regular
        if(!isRagged(arr)){ //si la matriz que se pasa como parámetro no es regular
            throw new IllegalArgumentException("La matriz es irregular"); //salta la excepción
        }
        int numFilas = arr.length;
        int numColumnas = arr[0].length;
        this.matriz = new int[numFilas][numColumnas];

        for (int i = 0; i < numFilas; i++) { //recorremos las filas de la matriz
            //recorremos la columnas de la matriz
            //copiamos los valores del array en la matriz
            System.arraycopy(arr[i], 0, this.matriz[i], 0, numColumnas);
        }
    }


    //definimos el método isRagged (fuera del constructor) para comprobar si la matriz es regular
    //un array es regular cuando todas las filas de la matriz tienen la misma longitud
    private static boolean isRagged (int[][] arr){
        if(arr == null || arr.length == 0 ){  //si la matriz es nula o de longitud 0
            return false;  //devuelve falso (No es regular)

        }

        int numColumnas = arr[0].length; //almacenamos en columnas la longitud
        for(int[] fila : arr){  //recorre la longitud de cada fila
            if( fila.length !=  numColumnas){ //si la longitud de cada fila no es igual a la longitud de la columna
                return false; //devuelve falso porque no será regular
            }
        }
        return true; //si se cumplió lo anterior, entonces la matriz es regular
    }



    //creamos el segundo constructor que acepta el número de filas y el número de columnas
    public ImmutableMatrix(int numFilas, int numColumnas){
        //los valores de las filas y las columnas tienen que ser enteros mayores que 0
        if(numFilas <= 0 || numColumnas <= 0){  //si los valores de las filas o las columnas es menor que 0
            throw new IllegalArgumentException("Las dimensiones de la matriz no son válidas"); //salta la excepción
        }
        //a partir de los valores que reciben filas y columnas, creamos una matriz con esas dimensiones y que se rellena con números a partir del 1
        this.matriz = new int[numFilas][numColumnas];

        int valor = 1; //creamos una variable con el valor inicial para rellenar la matriz
        for(int i = 0; i< numFilas ; i++){ //recorremos las filas
            for(int j = 0; j< numColumnas; j++){ //recorremos las columnas
                this.matriz[i][j]=valor; //rellena la celda con el valor actual
                valor ++;  //incrementa el valor para la siguiente celda
            }
        }
    }


    //además de los constructores definimos varios métodos
    public String toString() { // toString convierte la matriz a un String
        StringBuilder string = new StringBuilder(); //creamos una nueva instancia de la clase con StringBuilder
        for (int[] ints : matriz) { //itera a través de cada fila en la matriz
            string.append(Arrays.toString(ints)).append("\n"); //convierte una fila a cadena y la agrega a string. Se agrega un salto de línea al final de cada fila para separarlas en el resultado
        }
        return string.toString(); //devolvemos string convertido a String
    }

    public int at(int fila, int columna){ //at devuelve elemento en la posición indicada (fila y columna)
        //devolverá la excepción si no existen las coordenadas
        if(fila<0 || fila>= matriz.length || columna<0 || columna>= matriz[0].length ){
            throw new IllegalArgumentException("Los valores de fila y columna son incorrectos");
        }
        return matriz[fila][columna];
    }


    public int rowCount(){ //rowCount que devuelve el número de filas de la matriz
        return matriz.length;
    }

    public int columnCount(){ //columnCount devuelve el número de columnas
        return matriz[0].length; //sabiendo que es regular, el número de elementos e la primera fila es el número de columnas


    }
    public int[][] toArray2D(){ //toArray2D devuelve una representación de la matriz (una copia) como un array 2D
        int filas = matriz.length;
        int columnas = matriz[0].length;

        //creamos una nueva matriz con las mismas dimensiones, para no afectar a la inmutabilidad del objeto
        int [][] copiaMatriz = new int[filas][columnas];

        //copiamos el valor de la matriz en la copia
        for(int i=0; i< filas; i++){
            copiaMatriz[i]= Arrays.copyOf(matriz[i],columnas);
        }
        return copiaMatriz; //devolvemos la copia de la matriz
    }


    public ImmutableMatrix reverse() { //reverse devuelve la matriz con las filas en prden inverso
        int filas = matriz.length; 
        int columnas = matriz[0].length;

        int[][] matrizReversa = new int[filas][columnas]; //creamos una nueva instancia de la matriz para que devuelva la matriz reversa

        for (int i = 0; i < filas; i++) {  //recorremos las filas
            for (int j = 0; j < columnas; j++) { //recorremos las columnas
                matrizReversa[i][j] = matriz[i][columnas - 1 - j];
            }
        }

        return new ImmutableMatrix(matrizReversa); //devolvemos la matriz con las filas invertidas
    }


    public ImmutableMatrix transpose(){ //transpose devuelve la matriz transpuesta
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int[][] transpuestaMatriz = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {  //recorremos las filas de la matriz
            for (int j = 0; j < columnas; j++) {  //recorremos las columnas de la matriz
                transpuestaMatriz[j][i] = matriz[i][j]; //en el objeto creado cambiamos las filas por las columnas
            }
        }

        return new ImmutableMatrix(transpuestaMatriz); //devuelve la matrizTraspuesta

    }


    public ImmutableMatrix reshape (int columna){ //
        if (matriz.length * matriz[0].length % columna != 0) { //si el número de elementos no es divisible entre el número de columnas que se le pasa como parámetro
            throw new IllegalArgumentException("No se puede realizar el reshape con el número de columnas indicado"); //salta la excepción, porque no se puede crear la matriz si no se cumple la condición
        }

        int filas = matriz.length * matriz[0].length / columna; //el nuevo número de filas será el número total de elementos entre el número de columnas que se pasa como parámetro
        int[][] reshapedMatriz = new int[filas][columna]; //creamos una instancia de la clase con la condición de las filas y con las columnas que se pasan como parámetro

        int contador = 1;  //inicializamos un contador a 1 para rellenar las "celdas" de la matriz
        for (int i = 0; i < filas; i++) { //recorremos las filas 
            for (int j = 0; j < columna; j++) { //y las columnas de la matriz
                reshapedMatriz[i][j] = contador++;  //y rellenamos las "celdas" de la matriz desde 1 hasta el número total de elementos que haya ( que será número de filas * número de columnas)
            }
        }

        return new ImmutableMatrix(reshapedMatriz); //devolvemos la matriz reorganizada
    }
}
