


public static void main(String[] args) {
    Permisos permisos = new  Permisos();


    permisos.tiene_permiso("LEER");
    permisos.tiene_permiso("ACCEDER");
    permisos.imprimir_permisos();
    permisos.agregar_permiso("ACCEDER");
    permisos.tiene_permiso("ACCEDER");

}
