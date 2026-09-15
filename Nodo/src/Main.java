public static void main(String[] args) {
    //Construye manualmente una lista enlazada equivalente a la mostrada en la imagen anexa.
    Nodo <String> head = new Nodo<>("Al",new Nodo<>("B" , new Nodo<>("C",new Nodo<>("De",new Nodo<>("Mc",new Nodo<>("Zi"))))));

    //Imprime el estado inicial completo de la lista.
    Nodo <String> cursor = head;

    while(cursor.getDato() != null){

        System.out.println(cursor.getDato());
        if (cursor.getSiguiente() == null ){
            break;
        }
        else {cursor = cursor.getSiguiente();}

    }

    //Imprime únicamente el dato almacenado en el primer nodo de la lista.
    cursor = head;
    System.out.println("Dato del primer nodo -> " + cursor.getDato());

    //Imprime el estado completo del nodo ubicado en la última posición de la lista.
    while(cursor.getDato() != null){
        if (cursor.getSiguiente() == null){

            System.out.println("Ultimo dato -> " + cursor.getDato());
            System.out.println("Direccion ultimo nodo -> " + cursor.getSiguiente());
            cursor = head;
            break;
        }
        cursor = cursor.getSiguiente();
    }

    //Inserta un nuevo nodo con el valor "Fe" entre los nodos que contienen "De" y "Mc".
    while(cursor.getDato() != null){
        if (cursor.getDato() == "De"){
            cursor.setSiguiente (new Nodo<>("Fe" , cursor.getSiguiente() ));

            System.out.println("-------Fe insertado-------");
            cursor = head;
            break;
        }
        cursor = cursor.getSiguiente();
    }

    // Imprime el nuevo estado de la lista.

    while(cursor.getDato() != null) {

        System.out.println(cursor.getDato());
        if (cursor.getSiguiente() == null) {
            break;
        } else {
            cursor = cursor.getSiguiente();
        }
    }

        //Inserta un nuevo nodo con el valor "Zz" al final de la lista.
    while(cursor.getDato() != null){
        if (cursor.getSiguiente() == null){
            cursor.setSiguiente(new Nodo<>("Zz"));
            System.out.println("-------Zz insertado-------");
            cursor = head;
            break;
        }
        cursor = cursor.getSiguiente();
    }
    //Imprime el nuevo estado de la lista.
    while(cursor.getDato() != null) {

        System.out.println(cursor.getDato());
        if (cursor.getSiguiente() == null) {
            break;
        } else {
            cursor = cursor.getSiguiente();
        }
    }
    //Inserta un nuevo nodo con el valor "Aa" al inicio de la lista, de modo que se convierta en el primer nodo.
    cursor = head;
    cursor = new Nodo<>("Aa" , cursor ) ;
    System.out.println("-------Aa insertado-------");


    //Imprime el estado final de la lista.
    while(cursor.getDato() != null) {

        System.out.println(cursor.getDato());
        if (cursor.getSiguiente() == null) {
            break;
        } else {
            cursor = cursor.getSiguiente();
        }
    }
}