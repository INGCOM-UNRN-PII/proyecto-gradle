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

Verificación de estilo de código (~25 reglas)

**Reglas principales verificadas**:

- **Nomenclatura**: `0x0001` (clases CamelloCase), `0x0003` (variables dromedarioCase), `0x0004` (métodos
  dromedarioCase), `0x0005` (constantes SNAKE_CASE)
- **Formato**: `0x0009` (espacios en operadores), `0x000A` (no apilar líneas), `0x000B` (llaves en bloques)
- **Documentación**: `0x1000` (formato Javadoc), `0x1001` (documentar clases/métodos/atributos)
- **Diseño**: `0x200A` (métodos máx 30 líneas), `0x2001` (atributos private), `0x2011` (máx 5 parámetros)

```bash
./gradlew checkstyleMain checkstyleTest
```

Reportes generados en:

- `build/reports/checkstyle/main.html`
- `build/reports/checkstyle/test.html`

📖 **Detalle completo**: [`config/reglas.md`](config/reglas.md) secciones 0x0, 0x1, 0x2

#### [PMD](https://pmd.github.io/)

Análisis estático de código (~15 reglas)

**Reglas principales verificadas**:

- **Nomenclatura**: `0x0003` (variables locales), `0x0005` (constantes)
- **Diseño**: `0x200A` (métodos cortos), `0x2007` (sin código duplicado), `0x200C` (getters/setters justificados)
- **Complejidad**: `0x2011` (parámetros), `0x200D` (responsabilidad única)
- **Buenas prácticas**: `0xA012` (sin números mágicos), `0x5006` (bucles con terminación clara)

```bash
./gradlew pmdMain pmdTest
```

Reportes generados en:

- `build/reports/pmd/main.html`
- `build/reports/pmd/test.html`

📖 **Detalle completo**: [`config/reglas.md`](config/reglas.md) secciones 0x0, 0x2, 0x5

#### [SpotBugs](https://spotbugs.github.io/)

Detección de bugs (~5 reglas)

**Categorías verificadas**:

- Problemas de concurrencia
- Comparaciones incorrectas (relacionado con `0xE001`)
- Uso incorrecto de APIs
- Errores de lógica comunes

```bash
./gradlew spotbugsMain spotbugsTest
```

Reportes generados en:

- `build/reports/spotbugs/main.html`
- `build/reports/spotbugs/test.html`

#### [Error Prone](https://errorprone.info/)

**Se ejecuta automáticamente durante la compilación** (6 reglas)

Detecta errores comunes durante la compilación:

- `0xE001` - Comparar objetos con `==` en lugar de `equals()` → check `StringEquality`
- `0xE002` - No cerrar recursos → check `MissingOverride`
- `0xE003` - Modificar colección durante iteración → check `ModifyCollectionInEnhancedForLoop`
- `0xE004` - Ignorar valor de retorno → checks `ReturnValueIgnored`, `CheckReturnValue`
- `0x200F` - equals primero de Object → check `EqualsIncompatibleType`
- `0x2010` - hashCode con librería → check `EqualsHashCode`

```bash
# Se ejecuta automáticamente con:
./gradlew compileJava
```

📖 **Detalle completo**: [`config/reglas.md`](config/reglas.md) sección 0xE (Errores comunes)

#### [NullAway](https://github.com/uber/NullAway)

**Se ejecuta automáticamente durante la compilación** (4 reglas)

Verificación de errores provocables por `null` en tiempo de compilación:

- `0x200B` - Evitar retornos null (usar @Nullable si es necesario)
- `0x2011` - Constructores validan parámetros (null checks)
- `0x3006` - Situaciones diferentes → excepciones diferentes
- `0x3007` - Largo cero ≠ null

```bash
# Se ejecuta automáticamente con:
./gradlew compileJava
```

📖 **Detalle completo**: [`config/reglas.md`](config/reglas.md) secciones 0x2 (Diseño POO), 0x3 (Excepciones)

#### [ArchUnit](https://www.archunit.org/)

**Se ejecuta automáticamente con los tests** (5 reglas)

Tests que verifican reglas de arquitectura POO:

- `0x2001` - Atributos deben ser private (encapsulamiento)
- `0x2003` - Paquetes deben comenzar con ar.unrn
- `0x2009` - Atributos estáticos justificados (solo constantes)
- `0x200D` - Clases con única responsabilidad (SRP, máx 20 miembros)
- `0x0006A` - Nomenclatura de interfaces (-able para instancia, -or/-er para funcional)

```bash
./gradlew test --tests ReglasArquitecturaTest
```

📖 **Detalle completo**: [`config/reglas.md`](config/reglas.md) secciones 0x0 (Nomenclatura), 0x2 (Diseño POO)

### Analisis de tests

#### [JaCoCo](https://www.jacoco.org/jacoco/)

Cobertura de las pruebas

Genera reportes de cobertura de líneas, ramas, métodos y clases. Ayuda a identificar código no testeado.

```bash
./gradlew test jacocoTestReport
```

Reportes generados en:

- `build/reports/tests/test/index.html` - Resultados de tests
- `build/reports/jacoco/test/html/index.html` - Cobertura de código

**Configuración**: Cobertura mínima 50%, excluye clases *App y métodos main

#### [PIT (Pitest)](https://pitest.org/)

**No se ejecuta automáticamente** (4 reglas indirectas)

Verifica calidad de tests mediante mutaciones del código. Útil para validar calidad de tests antes de entregas.

**Reglas verificadas indirectamente**:

- `0x4001` - Estructura AAA (tests débiles fallan con mutaciones)
- `0x4002` - Una llamada por test (baja cobertura indica problema)
- `0x4004` - Tests sin lógica condicional (verificar con `verifyTestQuality`)
- `0x4005` - Tests independientes (mutaciones revelan dependencias)

Es necesario ejecutarlo explícitamente con:

```bash
./gradlew pitest

# Verificar calidad de tests (sin lógica condicional):
./gradlew verifyTestQuality
```

Reportes generados en:

- `build/reports/pitest/index.html`

Configuración utilizada, umbrales 80% mutaciones, 54% cobertura. Excluye clases `*App`.
Detalles en [`config/reglas.md`](config/reglas.md) sección 0x4 (Testing)

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
