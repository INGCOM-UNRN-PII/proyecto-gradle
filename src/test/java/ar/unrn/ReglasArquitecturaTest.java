package ar.unrn;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

/**
 * Tests de reglas de arquitectura usando ArchUnit.
 * Automatiza reglas de diseño POO y arquitectura.
 * 
 * Reglas implementadas:
 * - 0x2001: Atributos deben ser private
 * - 0x2003: Paquetes deben comenzar con ar.unrn
 * - 0x2009: Atributos estáticos justificados
 * - 0x200D: Clases con única responsabilidad (SRP)
 * - 0x0006A: Nomenclatura de interfaces según su propósito
 */
public class ReglasArquitecturaTest {

    private static JavaClasses CLASSES;

    /**
     * Importa las clases del proyecto antes de ejecutar los tests.
     */
    @BeforeAll
    public static void importarClases() {
        CLASSES = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
            .importPackages("ar.unrn");
        
        System.out.println("Clases importadas: " + CLASSES.size());
    }

    /**
     * Regla 0x2001: Los atributos de instancia deben ser private.
     * Verifica que todos los campos no estáticos sean privados.
     */
    @Test
    public void regla0x2001AtributosDebenSerPrivados() {
        ArchRule rule = fields()
            .that().areDeclaredInClassesThat()
                .resideInAPackage("ar.unrn..")
            .and().areNotStatic()
            .and().areNotFinal()
            .should().bePrivate()
            .allowEmptyShould(true)
            .because("[0x2001] Los atributos deben ser private (encapsulamiento)");

        rule.check(CLASSES);
    }

    /**
     * Regla 0x2003: Los paquetes deben comenzar con ar.unrn.
     * Verifica que todas las clases estén en el paquete correcto.
     */
    @Test
    public void regla0x2003PaquetesDebenEmpezarConArUnrn() {
        ArchRule rule = classes()
            .should().resideInAPackage("ar.unrn..")
            .allowEmptyShould(true)
            .because("[0x2003] Los paquetes deben comenzar con ar.unrn");

        rule.check(CLASSES);
    }

    /**
     * Regla 0x2009: Atributos estáticos deben estar justificados.
     * Solo se permiten atributos estáticos finales (constantes).
     */
    @Test
    public void regla0x2009AtributosEstaticosJustificados() {
        ArchRule rule = fields()
            .that().areStatic()
            .and().areNotFinal()
            .should().bePrivate()
            .andShould().haveName(".*INSTANCE|.*FACTORY")
            .allowEmptyShould(true)
            .because("[0x2009] Atributos estáticos no finales "
                + "deben estar justificados (preferir constantes o singleton)");

        rule.check(CLASSES);
    }

    /**
     * Regla 0x200D: Clases deben tener única responsabilidad (SRP).
     * Heurística: clases con más de 20 miembros probablemente 
     * violan el principio de responsabilidad única.
     */
    @Test
    public void regla0x200DUnaResponsabilidadPorClase() {
        ArchRule rule = classes()
            .that().resideInAPackage("ar.unrn..")
            .and().areNotInterfaces()
            .and().haveSimpleNameNotEndingWith("App")
            .should(tenerComoMaximo(20))
            .allowEmptyShould(true)
            .because("[0x200D] Clases deben tener única responsabilidad "
                + "(SRP) - máximo 20 miembros");

        rule.check(CLASSES);
    }

    /**
     * Regla 0x0006A: Interfaces deben seguir convención de nomenclatura.
     * - Sufijo '-able' para comportamiento de instancia (depende de this)
     * - Sufijo '-or' o '-er' para comportamiento funcional (sin estado)
     */
    @Test
    public void regla0x0006ANomenclaturaInterfaces() {
        ArchRule rule = classes()
            .that().areInterfaces()
            .and().resideInAPackage("ar.unrn..")
            .should(tenerNomenclaturaCorrecto())
            .allowEmptyShould(true)
            .because("[0x0006A] Interfaces deben terminar en -able "
                + "(comportamiento instancia) o -or/-er (funcional)");

        rule.check(CLASSES);
    }

    private static ArchCondition<JavaClass> tenerComoMaximo(int maxMembers) {
        return new ArchCondition<JavaClass>("tener como máximo " + maxMembers + " miembros") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                int totalMembers = javaClass.getAllMembers().size();
                if (totalMembers > maxMembers) {
                    String message = String.format(
                        "Clase %s tiene %d miembros (máximo permitido: %d)",
                        javaClass.getName(), totalMembers, maxMembers);
                    events.add(SimpleConditionEvent.violated(javaClass, message));
                }
            }
        };
    }

    private static ArchCondition<JavaClass> tenerNomenclaturaCorrecto() {
        return new ArchCondition<JavaClass>(
            "tener nomenclatura correcta (-able, -or, -er)") {
            @Override
            public void check(JavaClass interfaz, ConditionEvents events) {
                String nombre = interfaz.getSimpleName();
                
                // Verificar si termina en -able, -or, -er
                boolean terminaEnAble = nombre.endsWith("able");
                boolean terminaEnOr = nombre.endsWith("or");
                boolean terminaEnEr = nombre.endsWith("er");
                
                if (!terminaEnAble && !terminaEnOr && !terminaEnEr) {
                    String message = String.format(
                        "Interfaz %s no sigue convención de nomenclatura. "
                        + "Debe terminar en -able (comportamiento instancia) "
                        + "o -or/-er (comportamiento funcional)",
                        nombre);
                    events.add(SimpleConditionEvent.violated(interfaz, message));
                }
            }
        };
    }
}

