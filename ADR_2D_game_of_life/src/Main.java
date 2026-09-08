
//juego de la vida 10 x 10 celdas


    public class Main {
        public static void main(String[] args) throws InterruptedException {
            String archivo = "src/celulas_iniciales.csv";
            int totalGeneraciones = 10;

            JuegoDeLaVida juego = new JuegoDeLaVida(archivo,10,10);

            System.out.println("============== ESTADO INICIAL ==============");
            System.out.println(juego);

            for (int gen = 1; gen <= totalGeneraciones; gen++) {

                juego.siguienteGeneracion();

                System.out.println("=========== GENERACIÓN " + gen + " ===========");
                System.out.println(juego);
            }
        }
    }

