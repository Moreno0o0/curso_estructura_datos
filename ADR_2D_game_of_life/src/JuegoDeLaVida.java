import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JuegoDeLaVida {
    private ADT_2D<Integer> actual;
    private ADT_2D<Integer> siguiente;
    private final int filas;
    private final int columnas;

    public JuegoDeLaVida(String rutaArchivo , int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        cargarDesdeCSV(rutaArchivo);
    }

    private void cargarDesdeCSV(String rutaArchivo) {

        this.actual = new ADT_2D<>(filas, columnas);
        this.siguiente = new ADT_2D<>(filas, columnas);

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int fila = 0;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    String[] datos = linea.split(",");
                    for (int col = 0; col < columnas; col++) {
                        int estado = Integer.parseInt(datos[col].trim());
                        actual.insertarElemento(fila, col, estado);
                    }
                    fila++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error procesando los datos: " + e.getMessage());
        }
    }

    private int contarVecinosVivos(int fila, int col) {
        int vivos = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int vf = fila + i;
                int vc = col + j;

                if (vf >= 0 && vf < filas && vc >= 0 && vc < columnas) {
                    if (actual.obtenerElemento(vf, vc) == 1) {
                        vivos++;
                    }
                }
            }
        }
        return vivos;
    }

    public void siguienteGeneracion() {
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                int estado = actual.obtenerElemento(f, c);
                int vecinos = contarVecinosVivos(f, c);

                if (estado == 1) {
                    siguiente.insertarElemento(f, c, (vecinos == 2 || vecinos == 3) ? 1 : 0);
                } else {
                    siguiente.insertarElemento(f, c, (vecinos == 3) ? 1 : 0);
                }
            }
        }

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                actual.insertarElemento(f, c, siguiente.obtenerElemento(f, c));
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int estado = actual.obtenerElemento(i, j); //[cite: 2]
                sb.append(estado == 1 ? "⬛ " : "⬜ ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}