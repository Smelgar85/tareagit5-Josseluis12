import java.util.Scanner;

public class TresEnRaya {
    public static void main(String[] args) {
        char[][] tablero = new char[3][3];
        Scanner scanner = new Scanner(System.in);

        // Inicializar el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }

        // Mostrar el tablero inicial
        mostrarTablero(tablero);

        // Inicializar el turno del jugador
        char jugador = 'X';

        // Solicitar al usuario ingresar números para colocar "X" o "O" en el tablero
        for (int turno = 1; turno <= 9; turno++) {
            int fila, columna;
            do {
                System.out.println("Turno del jugador " + jugador);
                System.out.print("Ingrese el número de fila (1, 2 o 3): ");
                fila = scanner.nextInt();
                System.out.print("Ingrese el número de columna (1, 2 o 3): ");
                columna = scanner.nextInt();
            } while (fila < 1 || fila > 3 || columna < 1 || columna > 3 || tablero[fila - 1][columna - 1] != ' ');

            // Colocar "X" o "O" en el tablero según el turno
            tablero[fila - 1][columna - 1] = jugador;

            // Mostrar el tablero actualizado
            mostrarTablero(tablero);

            // Comprobar si hay un ganador después de 5 turnos
            if (turno >= 5) {
                char ganador = verificarGanador(tablero);
                if (ganador != ' ') {
                    System.out.println("¡El jugador " + ganador + " ha ganado!");
                    break;
                }
            }

            // Si se llega al turno 9 sin ganador, es un empate
            if (turno == 9) {
                System.out.println("¡Es un empate!");
            }

            // Cambiar el turno del jugador
            jugador = (jugador == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    // Método para mostrar el tablero
    public static void mostrarTablero(char[][] tablero) {
        System.out.println("Tablero actual:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }
    
    // Método para verificar si hay un ganador
    public static char verificarGanador(char[][] tablero) {
        // Comprobar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != ' ') {
                return tablero[i][0];
            }
            if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != ' ') {
                return tablero[0][i];
            }
        }

        // Comprobar diagonales
        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != ' ') {
            return tablero[0][0];
        }
        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != ' ') {
            return tablero[0][2];
        }

        // Si no hay un ganador
        return ' ';
    }
    
    
}

        
