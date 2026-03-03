# proyecto-gradle

Plantilla de proyectos empleando Gradle y configurado con herramientas de verificación de calidad de código.

Las [reglas](config/reglas.md) están en revisión continua y las podemos conversar
en [Discussions](https://github.com/orgs/INGCOM-UNRN-PII/discussions).

## Comando de verificación completo

Ejecuta todas las verificaciones y genera reporte consolidado:

```bash
./gradlew analyzeAll
```

Este comando ejecuta en orden:

1. Limpieza del proyecto
2. **Compilación** (Error Prone + NullAway automático)
3. **Tests unitarios** (incluyendo ArchUnit para arquitectura)
4. **Cobertura de código** (JaCoCo)
5. **Análisis estático** (Checkstyle, PMD, SpotBugs)
6. **Verificación calidad de tests** (sin lógica condicional)
7. **Reporte consolidado** (Informe Dredd)

## Reglas de Programación

Las reglas empleadas están orientadas para su uso en una cátedra, por lo que se revisa una gran cantidad de detalles.

📖 **Ver todas las reglas en**: [`config/reglas.md`](config/reglas.md)

Las reglas están categorizadas con numeración hexadecimal:

- `0x0xxx`: Nomenclatura y formato general
- `0x1xxx`: Documentación y comentarios
- `0x2xxx`: Diseño de clases y POO
- `0x3xxx`: Manejo de excepciones
- `0x4xxx`: Testing
- `0x5xxx`: Estructuras de control
- `0x6xxx`: Restricciones de programación funcional
- `0xExxx`: Errores comunes (Error-Prone)

### Reglas integradas

#### [Checkstyle](https://checkstyle.sourceforge.io/)

Verificación de estilo de código

```bash
./gradlew checkstyleMain checkstyleTest
```

Reportes generados en:

- `build/reports/checkstyle/main.html`
- `build/reports/checkstyle/test.html`

#### [PMD](https://pmd.github.io/)

Análisis estático de código

```bash
./gradlew pmdMain pmdTest
```

Reportes generados en:

- `build/reports/pmd/main.html`
- `build/reports/pmd/test.html`

#### [SpotBugs](https://spotbugs.github.io/)

Detección de bugs

```bash
./gradlew spotbugsMain spotbugsTest
```

Reportes generados en:

- `build/reports/spotbugs/main.html`
- `build/reports/spotbugs/test.html`

#### [Error Prone](https://errorprone.info/)

Detecta errores comunes durante la compilación:

- `0xE001` - Comparar objetos con `==` en lugar de `equals()`
- `0xE002` - No cerrar recursos
- `0xE003` - Modificar colección durante iteración
- `0xE004` - Ignorar valor de retorno
- `0x200F` - equals primero de Object
- `0x2010` - hashCode con librería

#### [NullAway](https://github.com/uber/NullAway)

Verificación de errores provocables por `null` en tiempo de compilación:

- `0x200B` - Evitar retornos null
- `0x2011` - Constructores validan parámetros
- `0x3006` - Situaciones diferentes → excepciones diferentes
- `0x3007` - Largo cero ≠ null

#### [ArchUnit](https://www.archunit.org/)

Tests que verifican reglas de arquitectura:

- `0x2001` - Atributos deben ser private
- `0x2003` - Paquetes deben comenzar con ar.unrn
- `0x2009` - Atributos estáticos justificados
- `0x200D` - Clases con única responsabilidad (SRP)

```bash
./gradlew test --tests ReglasArquitecturaTest
```

### Analisis de tests

#### [JaCoCo](https://www.jacoco.org/jacoco/)

Cobertura de las pruebas

```bash
./gradlew test jacocoTestReport
```

Reportes generados en:

- `build/reports/tests/test/index.html` - Resultados de tests
- `build/reports/jacoco/test/html/index.html` - Cobertura de código

#### [PIT (Pitest)](https://pitest.org/)

Verifica calidad de tests mediante mutaciones, **no se ejecuta automáticamente** por tiempo de ejecución.
Útil para validar calidad de tests antes de entregas

- `0x4001` - Estructura AAA (indirecta)
- `0x4002` - Una llamada por test (indirecta)
- `0x4004` - Tests sin lógica condicional (tarea custom)
- `0x4005` - Tests independientes (indirecta)

Es necesario ejecutarlo explícitamente con:

```bash
./gradlew pitest
```

Reportes generados en:

- `build/reports/pitest/index.html`

## Reporte Consolidado (Dredd)

Genera un reporte consolidado en Markdown con resultados de todas las herramientas:

```bash
./gradlew check dredd
```

Reporte generado en:

- `build/reports/dredd.md`

## Estructura del proyecto

```
proyecto-gradle/
├── src/
│   ├── main/java/ar/unrn/                  # Código fuente
│   │   ├── LoaderApp.java                  # Cargador de aplicaciones
│   │   └── PlantillaApp.java               # Plantilla de aplicación de consola
│   └── test/java/ar/unrn/                  # Tests
│       ├── PlantillaAppTest.java           # Plantilla de tests de aplicaciones 
│       └── ReglasArquitecturaTest.java     # Tests ArchUnit (parte de las reglas de verificación)
├── config/
│   ├── checkstyle/                         # Configuración Checkstyle
│   │   ├── checkstyle.xml
│   │   └── suppressions.xml
│   ├── pmd/                                # Configuración PMD
│   │   └── programacion2.xml
│   ├── stylesheets/                        # XSL para reportes
│   ├── dredd/                              # Plantillas para reporte consolidado
│   └── reglas.md                           # Documentación básica de las reglas
├── build.gradle                            # Configuración del proyecto
├── settings.gradle                         # La configuración del proyecto
└── README.md                               # Este archivo
```
