package ar.unrn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * El nombre tiene que ser el mismo que la clase que testea
 * terminando con `Test` para funcionar.
 */
@DisplayName("Para 'Plantilla' en src")
class PlantillaAppTest {

    /**
     * Este test es una plantilla.
     */
    @Test
    @DisplayName("Dos mas cuatro")
    void sumaPositiva() {
        int resultado = PlantillaApp.suma(2, 4);
        int esperado = 6;
        Assertions.assertEquals(esperado, resultado, "La suma positiva no dio bien");
    }

    @Test
    @Disabled // Esto lo desactiva
    @DisplayName("Este falla a proposito")
    void falla() {
        Assertions.fail("Esto tiene sus usos!");
    }
}
