//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    ADT_2D <String> ajederez = new ADT_2D<>(8,8);

    ajederez.rellenar(" ");

    String[] piezasNegras = {"♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"};
    for (int col = 0; col < 8; col++) {
        ajederez.insertarElemento(0, col, piezasNegras[col]);
        ajederez.insertarElemento(1, col, "♟");
    }

    String[] piezasBlancas = {"♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"};
    for (int col = 0; col < 8; col++) {
        ajederez.insertarElemento(6, col, "♙");
        ajederez.insertarElemento(7, col, piezasBlancas[col]);
    }

    ajederez.imprimir();

}
