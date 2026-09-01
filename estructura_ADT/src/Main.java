
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String archivo = "junio.dat";

        int totalEmpleados = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine();
            while (br.readLine() != null) {
                totalEmpleados++;
            }
        } catch (IOException e) {
            System.out.println("Error al encontrar el archivo: " + e.getMessage());
            return;
        }
        ArrayADT<Empleado> nomina = new ArrayADT<>(totalEmpleados);

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine();
            String linea;
            int indice = 0;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.trim().split(",");

                int num = Integer.parseInt(datos[0].trim());
                String nom = datos[1].trim();
                String pat = datos[2].trim();
                String mat = datos[3].trim();
                int extra = Integer.parseInt(datos[4].trim());
                double base = Double.parseDouble(datos[5].trim());
                int anio = Integer.parseInt(datos[6].trim());

                Empleado trabajador = new Empleado(num, nom, pat, mat, extra, base, anio);
                nomina.insertarElemento(indice, trabajador);
                indice++;
            }
        } catch (IOException e) {
            System.out.println("Error procesando los datos: " + e.getMessage());
        }

        Empleado masAntiguo = nomina.obtenerElemento(0);
        Empleado menosAntiguo = nomina.obtenerElemento(0);
        int anioActual = 2026;

        System.out.println("================ REPORTE DE NÓMINA ================");

        for (int i = 0; i < nomina.longitud(); i++) {
            Empleado emp = nomina.obtenerElemento(i);

            double pagoHorasExtra = emp.getHorasExtra() * 276.5;
            int aniosAntiguedad = anioActual - emp.getAnioIngreso();
            double bonoAntiguedad = aniosAntiguedad * (emp.getSueldoBase() * 0.03);

            double sueldoFinal = emp.getSueldoBase() + pagoHorasExtra + bonoAntiguedad;

            System.out.printf("Trabajador: %-40s | Sueldo a pagar: $%.2f\n", emp.toString(), sueldoFinal);

            if (emp.getAnioIngreso() < masAntiguo.getAnioIngreso()) {
                masAntiguo = emp;
            }

            if (emp.getAnioIngreso() > menosAntiguo.getAnioIngreso()) {
                menosAntiguo = emp;
            }
        }

        System.out.println("\n================ ESTADÍSTICAS ================");
        System.out.println("Empleado con MAYOR antigüedad: " + masAntiguo.toString() + " (Ingresó en " + masAntiguo.getAnioIngreso() + ")");
        System.out.println("Empleado con MENOR antigüedad: " + menosAntiguo.toString() + " (Ingresó en " + menosAntiguo.getAnioIngreso() + ")");
    }
}