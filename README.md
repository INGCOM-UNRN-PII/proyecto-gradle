# proyecto-gradle

Plantilla de proyectos empleando Gradle y configurado con herramientas de verificación de calidad de código.

## Herramientas de Verificación

### Análisis Estático y Estilo
1. **[Checkstyle](https://checkstyle.sourceforge.io/)** - Verificación de estilo de código
2. **[PMD](https://pmd.github.io/)** - Análisis estático de código
3. **[SpotBugs](https://spotbugs.github.io/)** - Detección de bugs
4. **[Error Prone](https://errorprone.info/)** - Detección de errores en compilación
5. **[NullAway](https://github.com/uber/NullAway)** - Detección de errores de null

### Testing y Cobertura
6. **[JaCoCo](https://www.jacoco.org/jacoco/)** - Cobertura de código
7. **[PIT (Pitest)](https://pitest.org/)** - Mutation testing
8. **[ArchUnit](https://www.archunit.org/)** - Verificación de arquitectura (tests)

### Herramientas Implementadas

#### ✅ Error Prone
Detecta errores comunes durante la compilación:
- `0xE001` - Comparar objetos con `==` en lugar de `equals()`
- `0xE002` - No cerrar recursos
- `0xE003` - Modificar colección durante iteración
- `0xE004` - Ignorar valor de retorno
- `0x200F` - equals primero de Object
- `0x2010` - hashCode con librería

#### ✅ NullAway
Verificación de null-safety en tiempo de compilación:
- `0x200B` - Evitar retornos null
- `0x2011` - Constructores validan parámetros
- `0x3006` - Situaciones diferentes → excepciones diferentes
- `0x3007` - Largo cero ≠ null

#### ✅ ArchUnit
Tests que verifican reglas de arquitectura:
- `0x2001` - Atributos deben ser private
- `0x2003` - Paquetes deben comenzar con ar.unrn
- `0x2009` - Atributos estáticos justificados
- `0x200D` - Clases con única responsabilidad (SRP)

#### ✅ PIT Mutation Testing
Verifica calidad de tests mediante mutaciones:
- `0x4001` - Estructura AAA (indirecta)
- `0x4002` - Una llamada por test (indirecta)
- `0x4004` - Tests sin lógica condicional (tarea custom)
- `0x4005` - Tests independientes (indirecta)

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

## Comandos de Verificación

### Ejecutar todas las verificaciones

```bash
./gradlew clean build
```

### Verificaciones individuales

#### Calidad de Tests
```bash
./gradlew verifyTestQuality
```
Verifica que los tests no contengan lógica condicional (regla 0x4004)

#### Checkstyle (estilo de código)

```bash
./gradlew checkstyleMain checkstyleTest
```

Reportes generados en:

- `build/reports/checkstyle/main.html`
- `build/reports/checkstyle/test.html`

#### PMD (análisis estático)

```bash
./gradlew pmdMain pmdTest
```

Reportes generados en:

- `build/reports/pmd/main.html`
- `build/reports/pmd/test.html`

#### SpotBugs (detección de bugs)

```bash
./gradlew spotbugsMain spotbugsTest
```

Reportes generados en:

- `build/reports/spotbugs/main.html`
- `build/reports/spotbugs/test.html`

#### Tests con cobertura (JaCoCo)

```bash
./gradlew test jacocoTestReport
```

Reportes generados en:

- `build/reports/tests/test/index.html` - Resultados de tests
- `build/reports/jacoco/test/html/index.html` - Cobertura de código

#### Mutation Testing (PIT)

```bash
./gradlew pitest
```

Reportes generados en:

- `build/reports/pitest/index.html`

### Análisis Completo

Ejecuta todas las verificaciones y genera reporte consolidado:

```bash
./gradlew analyzeAll
```

Este comando ejecuta:
- Todas las verificaciones de código (Checkstyle, PMD, SpotBugs)
- Tests unitarios (incluyendo ArchUnit)
- Cobertura de código (JaCoCo)
- Verificación de calidad de tests
- Genera reporte consolidado (Dredd)

### Reporte Consolidado (Dredd)

Genera un reporte consolidado en Markdown con resultados de todas las herramientas:

```bash
./gradlew check analyzeAll dredd
```

Reporte generado en:

- `build/reports/dredd.md`

## Estructura del Proyecto

```
proyecto-gradle/
├── src/
│   ├── main/java/ar/unrn/          # Código fuente
│   └── test/java/ar/unrn/          # Tests
├── config/
│   ├── checkstyle/                 # Configuración Checkstyle
│   ├── pmd/                        # Configuración PMD
│   ├── stylesheets/                # XSL para reportes
│   ├── dredd/                      # Plantillas para reporte consolidado
│   └── reglas.md                   # Documentación de reglas
├── build.gradle                    # Configuración del proyecto
└── README.md                       # Este archivo
```

## Ejecución del Proyecto

### Compilar

```bash
./gradlew build
```

### Ejecutar aplicación principal

```bash
./gradlew run
```

### Limpiar build

```bash
./gradlew clean
```

## Notas

- Las reglas están en revisión continua para ajustarse a las necesidades de la cátedra (podemos conversarlas
  en [Discussions](https://github.com/orgs/INGCOM-UNRN-PII/discussions)
- Error Prone y NullAway se ejecutan automáticamente durante la compilación
- El proyecto requiere Java 25 o superior
- Se recomienda ejecutar `./gradlew clean build` antes de cada entrega 