# Cuestiones de estilo y correcciones generales

# Categorización de Reglas (Numeración Hexadecimal)

- **`0x0xxx`**: Nomenclatura y formato general
- **`0x1xxx`**: Documentación y comentarios
- **`0x2xxx`**: Diseño de clases y POO
- **`0x3xxx`**: Manejo de excepciones
- **`0x4xxx`**: Testing
- **`0x5xxx`**: Estructuras de control
- **`0x6xxx`**: Restricciones de programación funcional
- **`0xExxx`**: Errores comunes (Error-Prone)
- **`0xFxxx`**: Excepciones avanzadas

# Serie 0x0 - Nomenclatura y Formato

## `0x0000` - Sin errores de ortografía y apliquen formato markdown donde sea posible

Usen el [apunte markdown](https://github.com/INGCOM-UNRN-PII/cursada-2025/blob/main/biblio-secundaria/markdown.pdf)
para las cuestiones de formato.

Pero lo más importante...

No hay excusas, el IDE tiene corrector de ortografía por lo que typos en los identificadores
y documentación no serán aceptados.

## `0x0001` - Los nombres de las clases van en `CamelloCase`

Ejemplo: `CalculadoraAvanzada`, `GestorDeUsuarios`

## `0x0002` - Los identificadores válidos son solo con alfabéticos `[a-zA-Z]`

No usar números, guiones bajos ni caracteres especiales en identificadores, incluyendo
acentos y ñ.

## `0x0003` - Variables, parámetros y variables locales van en `dromedarioCase`

Ejemplo: `numeroDeCuenta`, `nombreCompleto`, `indiceActual`

## `0x0004` - Los nombres de los métodos van en `dromedarioCase`

Ejemplo: `calcularPromedio()`, `obtenerNombre()`, `validarDatos()`

**Nota**: En Java, las funciones son en realidad, métodos. Tomamos esta distinción para suavizar la
transición desde C.

## `0x0005` - Las constantes van en mayúsculas con `SNAKE_CASE`

Ejemplo: `PI`, `MAX_INTENTOS`, `VALOR_POR_DEFECTO`

## `0x0006` - Los identificadores DEBEN ser descriptivos

Los identificadores deben ser:
- Palabras completas y significativas en español o inglés, O
- Letras de contexto matemático estándar (i, j, k, n para índices; x, y para coordenadas)

**Incorrecto**: `calc`, `num`, `dat`, `tmp`  
**Correcto**: `calculadora`, `numero`, `datos`, `temporal`  
**Aceptable**: `i`, `j`, `k` (en bucles), `x`, `y` (coordenadas)

## `0x0007` - Los identificadores booleanos deben usar prefijos interrogativos

Los nombres de variables y métodos booleanos deben usar prefijos que indiquen una pregunta:
- `es` / `is` - estado o característica
- `tiene` / `has` - posesión
- `puede` / `can` - capacidad
- `esta` / `should` - recomendación
- `necesita` / `needs` - requerimiento

**Incorrecto**: `activo`, `valido`, `encontrado`, `disponible`  
**Correcto**: `esActivo`, `esValido`, `estaEncontrado`, `estaDisponible`

**Ejemplos**:
```java
boolean esVacio = lista.isEmpty();
boolean tienePermisos = usuario.tienePermisos();
boolean puedeEditar = documento.puedeEditar();
boolean estaBloqueado = cuenta.estaBloqueada();
```

## `0x0008` - Los identificadores no deben llevar el tipo de lo que procesan

No usar notación húngara ni prefijos de tipo.

**Incorrecto**: `sumaArreglo`, `stringNombre`, `intContador`  
**Correcto**: `suma`, `nombre`, `contador`

El tipo ya está declarado, no repetirlo en el nombre.

## `0x0009` - Un espacio antes y después de los operadores

Esta regla existe casi exclusivamente para exigirles el uso de autoformato, y aunque
el cambio en la prolijidad es realmente bajo, ayuda mucho a no perder de vista código
más complejo.

**Incorrecto**: `a+b*c`  
**Correcto**: `a + b * c`

## `0x000A` - No apilen líneas

Todos los bloques llevan sus llaves, y no encadenar más de ~dos llamadas a métodos en una línea.

**Incorrecto**:
```java
if (x > 0) return x;
String resultado = objeto.getParte1().getParte2().getParte3().getValor();
```

**Correcto**:
```java
if (x > 0) {
    return x;
}

String parte2 = objeto.getParte1().getParte2();
String resultado = parte2.getParte3().getValor();
```

## `0x000B` - No hacer `import paquete.*`, solo traer lo que se necesita

**Incorrecto**: `import java.util.*;`  
**Correcto**: `import java.util.ArrayList;`  
                `import java.util.HashMap;`

Mejora legibilidad y evita conflictos de nombres.

## `0x000C` - Los números mágicos deben convertirse en constantes nombradas

No usar valores literales numéricos directamente en el código (excepto 0, 1, -1 en contextos obvios).

**Incorrecto**:
```java
if (edad >= 18) {
    // lógica
}
double area = radio * radio * 3.14159;
for (int i = 0; i < 100; i++) {
    // procesamiento
}
```

**Correcto**:
```java
private static final int EDAD_MINIMA_LEGAL = 18;
private static final double PI = 3.14159;
private static final int MAX_ITERACIONES = 100;

if (edad >= EDAD_MINIMA_LEGAL) {
    // lógica
}
double area = radio * radio * PI;
for (int i = 0; i < MAX_ITERACIONES; i++) {
    // procesamiento
}
```

## `0x000D` - Los comentarios deben explicar el "por qué", no el "qué"

El código debe ser autoexplicativo. Los comentarios solo cuando la intención no es clara.

**Incorrecto**:
```java
// Incrementa i en 1
i = i + 1;

// Verifica si el nombre es nulo
if (nombre == null) {
    // lanza excepción
    throw new IllegalArgumentException();
}
```

**Correcto**:
```java
i = i + 1;  // No necesita comentario, es obvio

// Validación temprana para evitar NullPointerException en comparaciones posteriores
if (nombre == null) {
    throw new IllegalArgumentException("El nombre no puede ser nulo");
}

// Usamos búsqueda binaria porque la lista está ordenada (O(log n) vs O(n))
int posicion = busquedaBinaria(lista, elemento);
```

---

# Serie 0x1 - Documentación y Comentarios

## `0x1000` - La documentación debe seguir el formato Javadoc estándar

Solo porque el método termina con dos puntos de salida diferentes: el `return` explícito
y el `return` implícito al finalizar el método (solo para métodos `void`).

Para métodos no-void, debe haber exactamente un `return` al final.

```java
/**
 * Devuelve el valor absoluto de un número.
 * @param numero el número al que eliminar su signo
 * @return el número sin signo
 */
private static long valorAbsoluto(long numero) {
    // implementación
}
```

Versión extendida (opcional con postcondiciones):

```java
/**
 * Devuelve el valor absoluto de un número.
 * @param numero el número al que eliminar su signo
 * @return el número sin signo
 *      POST: se devuelve un valor con el mismo valor
 *            de numero sin signo.
 */
private static long valorAbsoluto(long numero) {
    // implementación
}
```

**Importante**: Usar `@return` (sin s), no `@returns`.

## `0x1001` - Las clases, atributos y métodos llevan documentación Javadoc

Toda clase, método y atributo debe tener un comentario de documentación Javadoc.

Esto incluye los miembros privados, por una cuestión de registrar y entender el razonamiento detrás de cada parte.

**Importante para clases abstractas** (TP7 - Calculadora): La documentación de clases abstractas es crítica. 
Debe establecer qué se debe hacer y qué NO en los métodos que deben ser implementados por las subclases. 
No solo describir lo obvio del código.

## `0x1002` - Todas las excepciones que lancemos deben estar documentadas con `@throws`

Si la misma excepción se lanza en dos contextos diferentes, explicar cada uno de ellos.

Si es posible, incluir casos que están fuera de nuestro control, como por ejemplo, los que
provengan de la librería.

Esta regla incluye tanto a las excepciones controladas como a las que no lo están.

```java
/**
 * Lee un archivo de configuración.
 * @param ruta ruta al archivo
 * @return configuración leída
 * @throws ArchivoNoEncontradoException si el archivo no existe
 * @throws ConfiguracionInvalidaException si el formato es incorrecto
 * @throws IOException si hay errores de lectura del sistema de archivos
 */
```

## `0x1003` - Las excepciones de tiempo de ejecución deben documentar cómo evitar su lanzamiento

```java
/**
 * Divide dos números.
 * @param a dividendo
 * @param b divisor
 * @return resultado de a/b
 * @throws IllegalArgumentException si b es 0.
 *         Para evitar esta excepción, verificar que b != 0 antes de llamar.
 */
```

## `0x1004` - Documenten el lanzamiento indirecto de excepciones propias

En especial, cuando se utilizan métodos internos de verificación.

```java
/**
 * Procesa un pedido.
 * @param pedido el pedido a procesar
 * @throws PedidoInvalidoException si el pedido no pasa validación (lanzada por validarPedido())
 */
public void procesar(Pedido pedido) throws PedidoInvalidoException {
    validarPedido(pedido);  // Este método lanza PedidoInvalidoException
    // procesamiento
}
```

## `0x1005` - Al documentar, no se indica el tipo de los parámetros o retorno

Solo se indica cuál es su rol o propósito. Redactar de forma que la explicación fluya
del mismo; para esto es necesario que el identificador sea apropiado.

**Incorrecto**:
```java
/**
 * @param nombre String - el nombre de la persona
 * @return int - la edad
 */
```

**Correcto**:
```java
/**
 * @param nombre el nombre de la persona a buscar
 * @return la edad de la persona encontrada
 */
```

El tipo ya está en la firma del método.

## `0x1006` - Las precondiciones deben documentarse con `@param` o comentarios

Documentar las condiciones que deben cumplirse antes de llamar al método.

```java
/**
 * Calcula el promedio de un arreglo.
 * @param numeros el arreglo de números a promediar (no puede ser null ni vacío)
 * @return el promedio de los valores
 * @throws IllegalArgumentException si el arreglo está vacío
 * @throws NullPointerException si el arreglo es null
 */
public double calcularPromedio(int[] numeros) {
    // implementación
}
```

## `0x1007` - Los comentarios TODO deben incluir contexto

Si dejas un TODO, incluye: quién, qué falta, y por qué está pendiente.

**Incorrecto**:
```java
// TODO: arreglar esto
```

**Correcto**:
```java
// TODO (Martin, 2025-02-18): Implementar validación de RUT chileno
// Pendiente porque necesitamos confirmar el algoritmo con el cliente
```

---

# Serie 0x2 - Diseño de Clases y POO

## `0x2000` - Las clases van en `CamelloCase`

Ejemplo: `CalculadoraAvanzada`, `GestorDeUsuarios`

## `0x2001` - Los atributos van en `dromedarioCase` y deben ser `private`

Los atributos deben ser `private` (o `protected` con justificación) y nunca `public`.

Principio de **encapsulamiento**. El acceso a atributos debe ser a través de métodos.

**Incorrecto**:
```java
class Persona {
    public String nombre;  // Rompe encapsulamiento
}
```

**Correcto**:
```java
class Persona {
    private String nombre;
    
    public String getNombre() {
        return nombre;
    }
}
```

## `0x2002` - La inicialización de los atributos va en el constructor

Los métodos deben enfocarse en lógica de negocio. La entrada/salida debe manejarse en capas separadas
(principio de Separación de Responsabilidades).

**Incorrecto**:
```java
class Persona {
    private String nombre = "";  // Inicialización en declaración
    private int edad = 0;
}
```

**Correcto**:
```java
class Persona {
    private String nombre;
    private int edad;
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
```

**Excepción**: Constantes y valores por defecto estáticos pueden inicializarse en la declaración.

## `0x2003` - Los paquetes deben comenzar en `ar.unrn` e ir en minúsculas

Seguir convención Java: paquetes en minúsculas, sin guiones bajos ni caracteres especiales.

Ejemplo: `ar.unrn.dominio`, `ar.unrn.persistencia`, `ar.unrn.util`

## `0x2004` - Implementar `equals` requiere implementar `hashCode`

Este es el **contrato de Object**: si dos objetos son iguales según `equals()`, deben tener el mismo `hashCode()`.

Ver:
- [Object.hashCode()](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html#hashCode())
- [Object.equals()](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object))

## `0x2005` - `equals` y `hashCode` deben ser implementados juntos o no estar

Es importante respetar el contrato de estos métodos: la implementación de uno implica
la implementación del otro.

- [`Object.hashCode()`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html#hashCode())
- [`Object.equals(Object)`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object))

## `0x2006` - Al extender, sobreescribir solo para llamar a super no es correcto

**Excepción**: Los constructores.

**Incorrecto**:
```java
@Override
public void metodo() {
    super.metodo();  // Solo llama a super, no agrega valor
}
```

Si el método no hace nada más que llamar a `super`, no sobreescribirlo.

## `0x2007` - Minimizar el código duplicado

Si hay código repetido en múltiples lugares, extraerlo a un método privado o clase utilitaria.

Principio **DRY** (Don't Repeat Yourself).

**Ejemplo importante** (TP7 - Calculadora): Revisar `toString()` en jerarquías de herencia para que
se resuelva de manera general en la clase base, sin duplicar código en las clases específicas.

**Separación de responsabilidades** (TP7 - Calculadora):
- `toString()` NO debe calcular, solo mostrar la estructura de la operación
- `calcular()` realiza el cálculo numérico
- Llamar a `toString()` es redundante al concatenar (el compilador lo hace automático)
- Calcular subexpresiones una vez y guardar el resultado evita recalcular operaciones potencialmente costosas

## `0x2008` - Los métodos get/set no pueden ser usados para la lógica del problema

Los getters/setters deben ser simples accesores. La lógica de negocio va en métodos específicos.

**Incorrecto**:
```java
public void setEdad(int edad) {
    if (edad < 0 || edad > 150) {
        throw new IllegalArgumentException();
    }
    this.edad = edad;
    calcularCategoria();  // Lógica adicional
    notificarObservadores();  // Más lógica
}
```

**Correcto**:
```java
public void setEdad(int edad) {
    this.edad = edad;
}

public void actualizarEdad(int nuevaEdad) {
    validarEdad(nuevaEdad);
    setEdad(nuevaEdad);
    calcularCategoria();
    notificarObservadores();
}
```

## `0x2009` - La utilización de atributos estáticos debe estar justificada

Los atributos estáticos son compartidos por todas las instancias. Usar solo cuando sea
semánticamente correcto (constantes, contadores globales, patrones singleton, etc.)

## `0x200A` - Los métodos deben tener máximo 20-30 líneas de código

Si un método es muy largo, extraer submétodos privados con responsabilidades específicas.

**Problemático**:
```java
public void procesarPedido(Pedido pedido) {
    // 100 líneas de validaciones, cálculos, transformaciones...
}
```

**Correcto**:
```java
public void procesarPedido(Pedido pedido) {
    validarPedido(pedido);
    calcularTotales(pedido);
    aplicarDescuentos(pedido);
    registrarPedido(pedido);
    notificarCliente(pedido);
}

private void validarPedido(Pedido pedido) {
    // lógica de validación
}
// ... otros métodos privados
```

## `0x200B` - Evitar retornos `null` cuando sea posible

Preferir `Optional`, colecciones vacías, o el patrón Null Object.

**Problemático**:
```java
public String buscarNombre(int id) {
    if (id < 0) {
        return null;  // Obliga a verificaciones null
    }
    return nombres.get(id);
}
```

**Mejor**:
```java
public Optional<String> buscarNombre(int id) {
    if (id < 0) {
        return Optional.empty();
    }
    return Optional.ofNullable(nombres.get(id));
}
```

**O para colecciones**:
```java
public List<String> buscarNombres(String patron) {
    if (patron == null) {
        return Collections.emptyList();  // No null
    }
    // búsqueda
}
```

## `0x200C` - No usar métodos getter/setter si violan encapsulamiento

Si solo necesitas exponer un dato sin lógica, considerar si realmente necesitas getters/setters
o si el diseño puede mejorar.

En algunos casos, métodos específicos del dominio son mejores que getters genéricos.

## `0x200D` - Las clases deben tener una única responsabilidad (SRP)

Principio de Responsabilidad Única: cada clase debe tener una sola razón para cambiar.

**Incorrecto** (clase con múltiples responsabilidades):
```java
class Usuario {
    private String nombre;
    private String email;
    
    // Responsabilidad 1: Gestión de datos
    public void setNombre(String nombre) { }
    
    // Responsabilidad 2: Validación
    public boolean validarEmail() { }
    
    // Responsabilidad 3: Persistencia
    public void guardarEnBaseDeDatos() { }
    
    // Responsabilidad 4: Notificaciones
    public void enviarEmailBienvenida() { }
}
```

**Correcto** (responsabilidades separadas):
```java
class Usuario {
    private String nombre;
    private String email;
    
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
}

class ValidadorUsuario {
    public boolean validarEmail(String email) { }
}

class RepositorioUsuario {
    public void guardar(Usuario usuario) { }
}

class NotificadorUsuario {
    public void enviarBienvenida(Usuario usuario) { }
}
```

## `0x200E` - La implementación de `equals` debe usar Pattern Matching para el cast

Esto simplifica el código y utiliza la forma correcta de downcast seguro (Java 16+).

**Tradicional**:
```java
@Override
public boolean equals(Object obj) {
    if (!(obj instanceof Persona)) {
        return false;
    }
    Persona otro = (Persona) obj;
    return this.nombre.equals(otro.nombre);
}
```

**Con Pattern Matching** (Java 16+):
```java
@Override
public boolean equals(Object obj) {
    if (!(obj instanceof Persona otro)) {
        return false;
    }
    return this.nombre.equals(otro.nombre);
}
```

## `0x200F` - La implementación de `equals` debe ser primero la de `Object`

No sobrecargar con el tipo específico primero.

**Incorrecto**:
```java
public boolean equals(Persona otro) {  // Sobrecarga, no override
    return this.nombre.equals(otro.nombre);
}
```

**Correcto**:
```java
@Override
public boolean equals(Object obj) {  // Override correcto
    if (!(obj instanceof Persona otro)) {
        return false;
    }
    return this.nombre.equals(otro.nombre);
}
```

**Importante** (TP9 - Agenda): NO comparar usando `hashCode()`. Los valores de `hashCode()` no tienen garantías de ausencia de colisiones.

## `0x2010` - La implementación de `hashCode` debe emplear la librería

Presente en `Arrays` y `Objects`.

**Incorrecto**:
```java
@Override
public int hashCode() {
    return nombre.hashCode() + edad * 31;  // Manual, propenso a errores
}
```

**Correcto**:
```java
@Override
public int hashCode() {
    return Objects.hash(nombre, edad);
}
```

## `0x2011` - No exponer detalles internos mediante getters (TP9 - Agenda)

Las búsquedas que toman valores mediante getters y hacen comparaciones fuera de la clase rompen el encapsulamiento.

**Incorrecto**:
```java
// En clase Agenda
for (Contacto c : contactos) {
    if (c.getNombre().equals(nombre)) {  // Rompe encapsulamiento
        return c;
    }
}
```

**Correcto**:
```java
// En clase Contacto
public boolean tieneNombre(String nombre) {
    return this.nombre.equals(nombre);
}

// En clase Agenda
for (Contacto c : contactos) {
    if (c.tieneNombre(nombre)) {
        return c;
    }
}
```

## `0x2012` - Usar Factory Methods para construcción compleja (TP9 - Agenda)

Si el constructor tiene muchos parámetros o múltiples formas de construcción, considerar usar factory methods.

```java
public static Contacto crearContactoCompleto(String nombre, String telefono, 
                                             String email, String direccion) {
    return new Contacto(nombre, telefono, email, direccion);
}

public static Contacto crearContactoBasico(String nombre, String telefono) {
    return new Contacto(nombre, telefono, null, null);
}
```





# Serie 0x5 - Estructuras de Control y Flujo

## `0x5000` - Un solo `return` por método

Solo porque el método termina con dos puntos de salida diferentes: el `return` explícito
y el `return` implícito al finalizar el método (solo para métodos `void`).

Para métodos no-void, debe haber exactamente UN `return` al final.

## `0x5001` - Sin usar la asignación compuesta (`+=`, `-=`, `*=`, etc)

Esta regla pedagógica ayuda a pensar explícitamente sobre las operaciones.

**Incorrecto**: `contador += 1;`  
**Correcto**: `contador = contador + 1;`

## `0x5002` - Sin `break` y `continue`, en su lugar usen banderas

Usar variables booleanas para controlar flujo de bucles en lugar de `break`/`continue`.

**Incorrecto**:
```java
for (int i = 0; i < n; i++) {
    if (condicion) break;
}
```

**Correcto**:
```java
boolean encontrado = false;
for (int i = 0; i < n && !encontrado; i++) {
    if (condicion) {
        encontrado = true;
    }
}
```

## `0x5003` - Usar parámetros como variables solo si no cambia su significado

**Incorrecto** (cambia significado):
```java
void procesar(int numero) {
    numero = numero + 1;  // ahora 'numero' no es el parámetro original
    numero = numero * 2;
}
```

**Correcto**:
```java
void procesar(int numero) {
    int resultado = numero + 1;
    resultado = resultado * 2;
}
```

## `0x5004` - Los métodos no deben usar `printf` o `Scanner` a no ser que sea explícitamente su propósito

Los métodos deben enfocarse en lógica de negocio. La entrada/salida debe manejarse en capas separadas.

## `0x5005` - Evitar anidamiento profundo de condicionales (máximo 3 niveles)

La anidación excesiva dificulta la lectura. Usar retorno temprano o extraer métodos.

**Incorrecto**:
```java
public void procesar(Pedido pedido) {
    if (pedido != null) {
        if (pedido.esValido()) {
            if (pedido.tieneStock()) {
                if (pedido.clienteTieneSaldo()) {
                    // lógica profundamente anidada
                }
            }
        }
    }
}
```

**Correcto** (retorno temprano):
```java
public void procesar(Pedido pedido) {
    if (pedido == null) {
        return;
    }
    if (!pedido.esValido()) {
        return;
    }
    if (!pedido.tieneStock()) {
        return;
    }
    if (!pedido.clienteTieneSaldo()) {
        return;
    }
    // lógica a nivel superior
}
```

## `0x5006` - Los bucles deben tener condiciones de terminación claras

Evitar bucles que dependan de múltiples condiciones complejas o flags poco claros.

**Problemático**:
```java
boolean flag1 = false;
boolean flag2 = true;
int contador = 0;
while (flag2 && !flag1 && contador < MAX && otraCondicion()) {
    // difícil de entender cuándo termina
}
```

**Correcto**:
```java
boolean encontrado = false;
int indice = 0;
while (!encontrado && indice < elementos.size()) {
    if (elementos.get(indice).cumpleCondicion()) {
        encontrado = true;
    }
    indice = indice + 1;
}
```

---

# Serie 0x4 - Testing

## `0x4000` - El test debe tener el mismo nombre que la clase con `Test` al final

**Incorrecto**: `PruebasCalculadora`, `CalculadoraTests`  
**Correcto**: `CalculadoraTest`

## `0x4001` - El test debe seguir la estructura AAA (Arrange-Act-Assert)

1. **Arrange** (Preparar): Configurar datos y objetos necesarios
2. **Act** (Ejecutar): Llamar al método bajo prueba
3. **Assert** (Comprobar): Verificar resultados con assertions y mensajes descriptivos
4. **Cleanup** (Limpiar): Opcional, liberar recursos si es necesario

```java
@Test
void testSumarDosNumeros() {
    // Arrange
    Calculadora calc = new Calculadora();
    
    // Act
    int resultado = calc.sumar(2, 3);
    
    // Assert
    assertEquals(5, resultado, "2 + 3 debe ser 5");
}
```

## `0x4002` - Una llamada a método en cada caso de prueba

Salvo que estén fuertemente conectadas como en casos de setup complejo.
Cada test debe verificar UNA funcionalidad específica.

## `0x4003` - Los nombres de tests deben ser descriptivos y usar convención `test<Accion><Condicion><ResultadoEsperado>`

**Incorrecto**:
```java
@Test
void test1() { }

@Test
void testCalcular() { }
```

**Correcto**:
```java
@Test
void testDividir_CuandoDivisorEsCero_LanzaArithmeticException() { }

@Test
void testCalcularPromedio_ConArregloVacio_LanzaIllegalArgumentException() { }

@Test
void testBuscarElemento_CuandoExiste_RetornaIndice() { }

@Test
void testBuscarElemento_CuandoNoExiste_RetornaMenosUno() { }
```

## `0x4004` - Los tests no deben tener lógica condicional

Un test con `if`, `for`, o `while` probablemente debería ser múltiples tests.

**Incorrecto**:
```java
@Test
void testCalcular() {
    for (int i = 0; i < 10; i++) {
        if (i % 2 == 0) {
            // test para pares
        } else {
            // test para impares
        }
    }
}
```

**Correcto**:
```java
@Test
void testCalcular_ConNumeroPar_RetornaResultadoEsperado() {
    assertEquals(4, calcular(2));
}

@Test
void testCalcular_ConNumeroImpar_RetornaResultadoEsperado() {
    assertEquals(9, calcular(3));
}
```

## `0x4005` - Cada test debe ser independiente y poder ejecutarse en cualquier orden

No depender del estado de otros tests. Usar `@BeforeEach` para setup común.

**Incorrecto**:
```java
private static int contador;  // Estado compartido entre tests

@Test
void test1() {
    contador = 5;  // Afecta a otros tests
}

@Test
void test2() {
    assertEquals(5, contador);  // Depende de test1
}
```

**Correcto**:
```java
private Calculadora calc;

@BeforeEach
void setUp() {
    calc = new Calculadora();  // Nuevo estado para cada test
}

@Test
void testSumar() {
    assertEquals(5, calc.sumar(2, 3));
}

@Test
void testRestar() {
    assertEquals(1, calc.restar(3, 2));
}
```

---

# Serie 0x3 - Manejo de Excepciones

## `0x3000` - No atajar la excepción si no es posible tomar una decisión

Si solo vas a loggear o relanzar sin agregar valor, deja que la excepción se propague.

## `0x3001` - El main de un programa no debe dejar pasar excepciones checked

El `main` debe manejar todas las excepciones checked y proporcionar mensajes de error
apropiados al usuario final.

## `0x3002` - Qué familia de excepciones se eligió debe estar documentada

Documentar en el paquete o clase base por qué se usa checked vs unchecked.

## `0x3003` - No atajar una excepción lanzada en el mismo bloque

**Incorrecto**:
```java
try {
    if (invalido) {
        throw new IllegalArgumentException();
    }
} catch (IllegalArgumentException e) {
    // manejar
}
```

**Correcto**: Usar `if-else` sin excepciones para lógica predecible.

## `0x3004` - No convertir excepciones checked a unchecked sin justificación

No es correcto atajar una excepción checked (IOException, SQLException) y relanzar una excepción
unchecked genérica (RuntimeException) perdiendo información del tipo original.

**Incorrecto**:
```java
try {
    leerArchivo();
} catch (IOException e) {
    throw new RuntimeException("Error"); // Pérdida de información
}
```

**Correcto**:
```java
try {
    leerArchivo();
} catch (IOException e) {
    throw new ArchivoNoDisponibleException("No se pudo leer: " + archivo, e);
}
```

## `0x3005` - Sean específicos con lo que atajan, no está permitido atajar `Exception` o `RuntimeException`

**Incorrecto**:
```java
try {
    // código
} catch (Exception e) {  // Demasiado genérico
    // manejar
}
```

**Correcto**:
```java
try {
    // código
} catch (IOException e) {
    // manejar IO
} catch (SQLException e) {
    // manejar BD
}
```

## `0x3006` - Situaciones diferentes requieren excepciones diferentes

Situaciones como "arreglo vacío" y "arreglo null" son casos diferentes que ameritan
mensajes y tipos de excepciones distintos para que se puedan atajar por separado.

**Incorrecto**:
```java
if (arreglo == null || arreglo.length == 0) {
    throw new IllegalArgumentException("Arreglo inválido");
}
```

**Correcto**:
```java
if (arreglo == null) {
    throw new NullPointerException("El arreglo no puede ser null");
}
if (arreglo.length == 0) {
    throw new IllegalArgumentException("El arreglo no puede estar vacío");
}
```

**Ejemplo de validación reutilizable** (TP3 - Arreglos y Excepciones):
```java
/**
 * Verifica que un arreglo no sea null ni esté vacío.
 * @param arreglo el arreglo a verificar
 * @throws NullPointerException si el arreglo es null
 * @throws IllegalArgumentException si el arreglo está vacío
 */
private static void validarArreglo(int[] arreglo) {
    if (arreglo == null) {
        throw new NullPointerException("El arreglo no puede ser null");
    }
    if (arreglo.length == 0) {
        throw new IllegalArgumentException("El arreglo no puede estar vacío");
    }
}
```

## `0x3007` - 'Largo cero' y `null` son dos situaciones bastante diferentes

Que requieren de excepciones distintas para que su tratamiento pueda ser más específico.

Ver `0x3006` para ejemplos.

## `0x3008` - Declarar el lanzamiento de una excepción no controlada es un error

No es correcto (ni necesario) declarar `throws` para RuntimeException y sus subclases.

**Incorrecto**:
```java
public void metodo() throws RuntimeException {  // Innecesario
    // código
}
```

**Correcto**:
```java
public void metodo() {  // RuntimeException no se declara
    // código
}
```

## `0x3009` - No está permitido lanzar excepciones base: `Exception` o `RuntimeException`

**Incorrecto**:
```java
throw new Exception("error");
throw new RuntimeException("error");
```

**Correcto**:
```java
throw new MiExcepcionEspecifica("error");
throw new IllegalArgumentException("parámetro inválido");
```

## `0x300A` - Mejor prevenir que atajar

Siempre que sea posible, prevenir la excepción en lugar de esperar a que falle.

**Menos óptimo**:
```java
try {
    int resultado = dividir(a, b);
} catch (ArithmeticException e) {
    // manejar división por cero
}
```

**Mejor**:
```java
if (b != 0) {
    int resultado = dividir(a, b);
} else {
    // manejar caso especial
}
```

## `0x300B` - Silenciar una excepción no es la forma de gestionarla

**Incorrecto**:
```java
try {
    operacionRiesgosa();
} catch (Exception e) {
    // Bloque vacío - se silencia el error
}
```

**Correcto**: Al menos loggear, o mejor aún, manejar adecuadamente.

## `0x300C` - No está permitido atajar para relanzar sin agregar información útil

Esto significa que la mayoría de las situaciones en las que se intenta hacer probablemente no sean correctas.

**Incorrecto**:
```java
try {
    leerArchivo();
} catch (IOException e) {
    throw new IOException(e);  // Solo envuelve, no agrega valor
}
```

**Correcto**:
```java
try {
    leerArchivo();
} catch (IOException e) {
    throw new ArchivoConfiguracionException(
        "No se pudo leer configuración de: " + archivo, e);  // Agrega contexto
}
```

## `0x300D` - Atajar para hacer algún tipo de `print` no es gestionar la excepción

**Incorrecto**:
```java
try {
    operacion();
} catch (Exception e) {
    e.printStackTrace();  // Solo imprime, no maneja
}
```

**Correcto**: Usar logging apropiado y tomar decisión sobre cómo continuar.

```java
try {
    operacion();
} catch (OperacionException e) {
    logger.error("Error en operación", e);
    // Reintentar, usar valor por defecto, o relanzar
}
```

---

# Serie 0xE - Errores Comunes (Error-Prone)

## `0xE000` - No es correcto concatenar String en un bucle

Ya que esto crea una gran cantidad de instancias de `String`.
Usar [`StringBuilder`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/StringBuilder.html)

**Incorrecto**:
```java
String resultado = "";
for (int i = 0; i < 1000; i++) {
    resultado = resultado + i;  // Crea 1000 objetos String
}
```

**Correcto**:
```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
String resultado = sb.toString();
```

## `0xE001` - Comparar objetos con `==` en lugar de `equals()`

Usar `==` compara referencias, no contenido. Usar `equals()` para comparar valores.

**Incorrecto**:
```java
String nombre1 = new String("Juan");
String nombre2 = new String("Juan");
if (nombre1 == nombre2) {  // false, son referencias diferentes
    // no se ejecuta
}
```

**Correcto**:
```java
if (nombre1.equals(nombre2)) {  // true, mismo contenido
    // se ejecuta
}
```

**Excepción**: Es correcto usar `==` para tipos primitivos y comparación con `null`.

```java
if (objeto == null) {  // Correcto
    // manejar caso null
}
```

## `0xE002` - No cerrar recursos (archivos, conexiones, etc.)

Usar try-with-resources para garantizar el cierre automático.

**Incorrecto**:
```java
FileReader reader = new FileReader("archivo.txt");
// usar reader
reader.close();  // Puede no ejecutarse si hay excepción
```

**Correcto**:
```java
try (FileReader reader = new FileReader("archivo.txt")) {
    // usar reader
}  // Se cierra automáticamente
```

## `0xE003` - Modificar una colección mientras se itera sobre ella

**Incorrecto**:
```java
for (String elemento : lista) {
    if (elemento.startsWith("A")) {
        lista.remove(elemento);  // ConcurrentModificationException
    }
}
```

**Correcto**:
```java
Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    if (it.next().startsWith("A")) {
        it.remove();  // Correcto usando Iterator
    }
}
```

## `0xE004` - Ignorar el valor de retorno de métodos inmutables

Métodos como `String.replace()` retornan un nuevo objeto, no modifican el original.

**Incorrecto**:
```java
String texto = "Hola Mundo";
texto.replace("Mundo", "Java");  // No hace nada, texto no cambia
System.out.println(texto);  // Imprime "Hola Mundo"
```

**Correcto**:
```java
String texto = "Hola Mundo";
texto = texto.replace("Mundo", "Java");  // Asignar el resultado
System.out.println(texto);  // Imprime "Hola Java"
```

## `0xE005` - Usar `float` para cálculos monetarios o precisos

Los `float` y `double` tienen errores de redondeo. Usar `BigDecimal` para dinero.

**Incorrecto**:
```java
double precio = 0.1 + 0.2;  // 0.30000000000000004
```

**Correcto**:
```java
BigDecimal precio = new BigDecimal("0.1").add(new BigDecimal("0.2"));  // 0.3 exacto
```

## `0xE006` - Usar comparaciones de strings para determinar comportamiento (TP7 - Calculadora)

Usar `operador.equals("-")` para determinar comportamiento es equivalente a verificar el tipo con `instanceof`, lo cual viola el principio Open/Closed. Usar polimorfismo.

**Incorrecto**:
```java
public String toString() {
    if (operador.equals("+")) {
        return "suma";
    } else if (operador.equals("-")) {
        return "resta";
    }
    // ...
}
```

**Correcto**:
```java
// Cada operación tiene su propia implementación polimórfica
@Override
public String toString() {
    return "suma";  // En clase Suma
}
```

## `0xE007` - Separadores de línea multiplataforma (TP7 - Calculadora)

Al procesar archivos, usar `System.lineSeparator()` para que pueda procesar archivos creados en cualquier plataforma.

```java
if (contenidoArchivo.charAt(i) == System.lineSeparator().charAt(0)) {
    // ...
}
```

Ver [System.lineSeparator()](https://docs.oracle.com/javase/21/docs/api/java.base/java/lang/System.html#lineSeparator())

---

# Serie 0x6 - Restricciones de Programación Funcional

**Nota pedagógica**: Estas reglas están diseñadas para el aprendizaje de POO imperativa clásica. 
La programación funcional es valiosa, pero se enseñará en contextos apropiados más adelante.

## `0x6000` - No usar expresiones lambda

Las expresiones lambda (`->`) no están permitidas en este curso.

**Incorrecto**:
```java
lista.forEach(elemento -> System.out.println(elemento));
numeros.stream().filter(n -> n > 10).collect(Collectors.toList());
```

**Correcto**:
```java
for (String elemento : lista) {
    System.out.println(elemento);
}

List<Integer> mayoresADiez = new ArrayList<>();
for (Integer n : numeros) {
    if (n > 10) {
        mayoresADiez.add(n);
    }
}
```

## `0x6001` - No usar referencias a métodos (method references)

Las referencias a métodos (`::`) no están permitidas.

**Incorrecto**:
```java
lista.forEach(System.out::println);
nombres.stream().map(String::toUpperCase).collect(Collectors.toList());
```

**Correcto**:
```java
for (String elemento : lista) {
    System.out.println(elemento);
}

List<String> nombresMayusculas = new ArrayList<>();
for (String nombre : nombres) {
    nombresMayusculas.add(nombre.toUpperCase());
}
```

## `0x6002` - No usar la API de Streams

La API `java.util.stream` no está permitida en este curso.

**Incorrecto**:
```java
int suma = numeros.stream()
    .filter(n -> n % 2 == 0)
    .mapToInt(Integer::intValue)
    .sum();

Optional<String> primero = lista.stream().findFirst();
```

**Correcto**:
```java
int suma = 0;
for (Integer numero : numeros) {
    if (numero % 2 == 0) {
        suma = suma + numero;
    }
}

String primero = null;
if (!lista.isEmpty()) {
    primero = lista.get(0);
}
```

## `0x6004` - No usar métodos funcionales de colecciones

Métodos como `forEach()`, `removeIf()`, `replaceAll()` de las colecciones no están permitidos.

**Incorrecto**:
```java
lista.forEach(elemento -> procesar(elemento));
nombres.removeIf(n -> n.startsWith("A"));
numeros.replaceAll(n -> n * 2);
```

**Correcto**:
```java
for (String elemento : lista) {
    procesar(elemento);
}

Iterator<String> it = nombres.iterator();
while (it.hasNext()) {
    if (it.next().startsWith("A")) {
        it.remove();
    }
}

for (int i = 0; i < numeros.size(); i++) {
    numeros.set(i, numeros.get(i) * 2);
}
```

## `0x6005` - No usar `Collectors` ni operaciones de reducción

Usar bucles explícitos para agregaciones y transformaciones.

**Incorrecto**:
```java
List<String> resultado = lista.stream()
    .collect(Collectors.toList());

Map<Integer, List<Persona>> porEdad = personas.stream()
    .collect(Collectors.groupingBy(Persona::getEdad));

String concatenado = palabras.stream()
    .collect(Collectors.joining(", "));
```

**Correcto**:
```java
List<String> resultado = new ArrayList<>();
for (String elemento : lista) {
    resultado.add(elemento);
}

Map<Integer, List<Persona>> porEdad = new HashMap<>();
for (Persona persona : personas) {
    int edad = persona.getEdad();
    if (!porEdad.containsKey(edad)) {
        porEdad.put(edad, new ArrayList<>());
    }
    porEdad.get(edad).add(persona);
}

StringBuilder sb = new StringBuilder();
for (int i = 0; i < palabras.size(); i++) {
    if (i > 0) {
        sb.append(", ");
    }
    sb.append(palabras.get(i));
}
String concatenado = sb.toString();
```

## `0x6006` - Preferir bucles `for` tradicionales o enhanced sobre operaciones funcionales

Los bucles son más explícitos y pedagógicos para entender el flujo de control.

**Incorrecto**:
```java
IntStream.range(0, 10).forEach(i -> procesar(i));
```

**Correcto**:
```java
for (int i = 0; i < 10; i++) {
    procesar(i);
}
```

## `0x6007` - No usar el patrón de composición funcional

Evitar encadenar operaciones funcionales o crear pipelines de transformación.

**Incorrecto**:
```java
Function<String, String> procesador = String::trim
    .andThen(String::toUpperCase)
    .andThen(s -> s + "!");
```

**Correcto**:
```java
public String procesar(String texto) {
    String resultado = texto.trim();
    resultado = resultado.toUpperCase();
    resultado = resultado + "!";
    return resultado;
}
```

---

# Serie 0xE - Errores Comunes

## `0xE000` - No es correcto concatenar String en un bucle

Ya que esto crea una gran cantidad de instancias de `String`.
Usar [`StringBuilder`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/StringBuilder.html)

**Incorrecto**:
```java
String resultado = "";
for (int i = 0; i < 1000; i++) {
    resultado = resultado + i;  // Crea 1000 objetos String
}
```

**Correcto**:
```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
String resultado = sb.toString();
```

---

## Resumen de Prioridades

### 🔴 Críticas (deben cumplirse siempre)
- 0x0001-0x0004: Nomenclatura básica (clases, variables, métodos)
- 0x2001: Atributos privados (encapsulamiento)
- 0x2004, 0x2005: Contrato equals + hashCode
- 0x1000: Documentación Javadoc
- 0x5000: Un solo return por método
- 0x6000-0x6002: Sin lambda, method references, ni streams

### 🟠 Importantes (muy recomendadas)
- 0x3005: Atajar excepciones específicas
- 0x3006-0x3007: Excepciones diferentes para situaciones diferentes
- 0x2007: Sin código duplicado (DRY)
- 0x5001: Sin operadores compuestos
- 0x5002: Sin break/continue
- 0x6003-0x6005: Sin interfaces funcionales ni métodos funcionales
- 0xE000: StringBuilder en bucles

### 🟡 Recomendadas (buenas prácticas)
- 0x0008: Espacios en operadores
- 0x0009: No apilar líneas
- 0x000A: Imports específicos
- 0x200A: Evitar retornos null (usar excepciones o null documentado)
- 0x0007: No indicar tipo en nombres
- 0x6004: Evitar Optional como retorno


---

**Última actualización**: 2026-03-02  
**Versión**: 4.0 - Reglas integradas con referencias a TPs originales (TP3, TP7, TP9)  
**Nota**: Las prácticas específicas de cada TP están integradas en las categorías generales con referencias al trabajo práctico de origen.
