package ar.unrn;

/**
 * Esta es una plantilla de main.
 * Usen Shift+F6 sobre el nombre para cambiarlo al que necesiten.
 * ¡Esto lo pueden utilizar en cualquier identificador!
 */
public class PlantillaApp {

    /**
     * Un ejemplo de valor constante.
     */
    public static final int MAXIMO = 10;

    /**
     * Punto de entrada del ejercicio.
     *
     * @param args son los argumentos de invocación.
     */
    public static void main(String[] args) {
        // Con Alt+Enter IntelliJ IDEA nos mostrará sugerencias
        // para modificar el bloque en el que estamos ubicados.
        System.out.printf("Hola y bienvenido! %s%n", "Estudiante");

        // Con Shift+F10 o la flecha verde del margen,
        // podemos ejecutar este main
        for (int i = 0; i <= MAXIMO; i++) {
            // Con Shift+F9 comenzaremos a debuggear el código.
            // Y podemos agregar breakpoints con Ctrl+F8.
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
