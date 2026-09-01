
public class Empleado {
    private int numeroTrabajador;
    private String nombres;
    private String paterno;
    private String materno;
    private int horasExtra;
    private double sueldoBase;
    private int anioIngreso;


    public Empleado(int numeroTrabajador, String nombres, String paterno, String materno, int horasExtra, double sueldoBase, int anioIngreso) {
        this.numeroTrabajador = numeroTrabajador;
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.anioIngreso = anioIngreso;
    }
    public int getHorasExtra() {
        return horasExtra;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    @Override
    public String toString() {
        return numeroTrabajador + " - " + nombres + " " + paterno + " " + materno;
    }
}