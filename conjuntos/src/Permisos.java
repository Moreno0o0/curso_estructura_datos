import java.util.HashSet;
import java.util.Set;
import java.util.Set;
public class Permisos {

    private Set<String> permisos = new HashSet<>(Set.of(
            "LEER", "ESCRIBIR", "IMPRIMIR"
    ));

    public boolean tiene_permiso(String permiso) {
        if (permisos.contains(permiso)) {
            System.out.println("acceso_autorizado");
            return true;
        }
        else {
            System.out.println("acceso_no_autorizado");
        }
        return false;
    }

    public void agregar_permiso(String permiso) {
        System.out.println("Permiso '" +  permiso + "' agregado");
        this.permisos.add(permiso);
    }
    public void setPermisos(Set<String> permiso) {
        this.permisos = permiso;
        System.out.println("acceso_agregado");
    }
    public void imprimir_permisos() {
        System.out.println("Permisos actuales: " + permisos);
    }
    public Set<String> getPermisos() {
        return this.permisos;
    }
}
