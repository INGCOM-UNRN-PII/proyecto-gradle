package ar.unrn;

/**
 * Esta es una plantilla de main.
 * Usen Shift+F6 sobre el nombre para cambiarlo al que necesiten.
 */
public class PlantillaApp {

    /**
     * Una ejemplo de valor constante.
     */
    public static final int MAXIMO = 10;

    /**
     * Punto de entrada del ejercicio.
     *
     * @param args son los argumentos de invocación.
     */
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the
        // highlighted text to see how IntelliJ IDEA
        // suggests fixing it.
        System.out.printf("Hello and welcome! %s%n", "Estudiante");

        // Press Mayús+F10 or click the green arrow button
        // in the gutter to run the code.
        for (int i = 0; i <= MAXIMO; i++) {

            // Press Mayús+F9 to start debugging your code.
            // We have set one breakpoint for you, but you
            // can always add more by pressing Ctrl+F8.
            System.out.println("i = " + suma(i, MAXIMO));
        }
    }

    /**
     * Suma dos valores.
     *
     * @param primer  termino a sumar
     * @param segundo termino a sumar
     * @return la suma de ambos terminos
     */
    public static int suma(int primer, int segundo) {
        return primer + segundo;
    }
}
