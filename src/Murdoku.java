import java.util.Arrays;
import java.util.Scanner;

public class Murdoku {

    static final int TAM = 7;

    // Identificadores de las zonas
    static final int PICNIC = 1;
    static final int JARDIN = 2;
    static final int ESTANQUE = 3;
    static final int CENADOR = 4;

    // Identificadores de los elementos
    static final int VACIO = 0;
    static final int SILLA = 1;
    static final int ALFOMBRA = 2;
    static final int ARBOL = 3;
    static final int FLORES = 4;
    static final int PIEDRA = 5;
    static final int MESA = 6;
    static final int OCUPADO = 7;

    static Scanner teclado = new Scanner(System.in);

    // Tablero donde se colocan los personajes
    static char[][] tablero = new char[TAM][TAM];

    // Elementos fijos del escenario
    static int[][] elementos = {
            { 0, 1, 1, 0, 4, 0, 4 },
            { 3, 2, 2, 0, 0, 0, 4 },
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 5, 0, 0, 3 },
            { 1, 0, 0, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 0, 0, 1 },
            { 2, 2, 1, 0, 1, 6, 0 }
    };

    // Zona a la que pertenece cada casilla
    static int[][] zonas = {
            { 1, 1, 1, 1, 2, 2, 2 },
            { 1, 1, 1, 1, 2, 2, 2 },
            { 1, 1, 3, 3, 2, 2, 2 },
            { 1, 1, 3, 3, 3, 2, 2 },
            { 1, 1, 3, 3, 4, 4, 4 },
            { 1, 1, 1, 3, 4, 4, 4 },
            { 1, 1, 1, 1, 4, 4, 4 }
    };

    // Datos de los personajes
    static String[] nombres = {
            "Avery", "Bruno", "Christian",
            "Daphne", "Ethan", "Fabian", "Vicky"
    };

    static char[] letras = {
            'A', 'B', 'C', 'D', 'E', 'F', 'V'
    };

    // Indica qué personajes ya están colocados
    static boolean[] colocados = new boolean[7];
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrartablero(elementos, tablero);
        colocar(tablero, letras, colocados, false);
        mostrartablero(elementos, tablero);
    }

    // Devuelve el símbolo correspondiente a un elemento
    public static char simboloElemento(int elemento) {

        switch (elemento) {

            case SILLA:
                return 'S';

            case ALFOMBRA:
                return '=';

            case ARBOL:
                return 'T';

            case FLORES:
                return '*';

            case PIEDRA:
                return 'P';

            case MESA:
                return 'M';
             case OCUPADO:
                return 'x';

            default:
                return '.';

        }

    }

    // Comprueba si una casilla puede ser ocupada
    public static boolean esTransitable(int fila, int columna, char simboloElemento) {

        int elemento = elementos[fila][columna];

        return elemento == VACIO
                || elemento == SILLA
                || elemento == ALFOMBRA;

    }

    public static void mostrartablero(int[][] elementos, char[][] tablero) {
        for (int i = 0; i < colocados.length; i++) {
            for (int j = 0; j < colocados.length; j++) {
                if (tablero[i][j]!='x') {
                    if (elementos[i][j] == 1) {
                    tablero[i][j] = simboloElemento(1);
                }
                if (elementos[i][j] == 2) {
                    tablero[i][j] = simboloElemento(2);
                }
                if (elementos[i][j] == 3) {
                    tablero[i][j] = simboloElemento(3);
                }
                if (elementos[i][j] == 4) {
                    tablero[i][j] = simboloElemento(4);
                }
                if (elementos[i][j] == 5) {
                    tablero[i][j] = simboloElemento(5);
                }
                if (elementos[i][j] == 6) {
                    tablero[i][j] = simboloElemento(6);
                }
                if (elementos[i][j] == 0) {
                    tablero[i][j] = simboloElemento(9);
                }
                }
               
            }

        }
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print((tablero[i][j]) + " ");
            }
            System.out.println();
        }
        ;

    }

    public static void colocar(char[][] tablero, char[] letras, boolean[] colocados,boolean esTransitable) {
        int nombre = 0;
        
        int x = 0;
        int y = 0;
        do {
            System.out.println("ELIGE NOMBRE  0 AVERY,1");
            nombre = sc.nextInt();
            System.out.println("elige posicion x");
            x = sc.nextInt();
            System.out.println("elige posicion y");
            y = sc.nextInt();
            if (x < tablero.length && x >= 0 && y < tablero.length && y >= 0) {
                if (colocados[nombre] == false && esTransitable==false) {
                    if(tablero[x][y]!='x'){
                        colocados[nombre]=true;
                    }
                } else {
                    System.out.println("El personaje ya esta colocado o sitio no transitable  ");
                }

            } else {
                System.out.println("No se puede colocar aqui el personaje por que te has salido del tablero ");
            }
        } while (colocados[nombre]=false);
         colocarX(tablero, x, y);
    }
    public static void colocarX (char [][] Tablero,int x,int y){

        for (int i = 0; i < Tablero.length; i++) {
            tablero[x][i]=simboloElemento(7);
        }
        for (int i = 0; i < Tablero.length; i++) {
              tablero[i][y]=simboloElemento(7);
        }
        
    }
    
}