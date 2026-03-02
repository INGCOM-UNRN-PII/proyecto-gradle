# Códigos de Reglas PMD - Programación 2

Este documento mapea las reglas estándar de PMD a códigos específicos del curso.

## Best Practices (category/java/bestpractices.xml)

| Código | Regla PMD | Descripción |
|--------|-----------|-------------|
| 0x0013 | AvoidReassigningParameters | No reasignar parámetros |
| 0xB001 | UnusedPrivateField | Campo privado no utilizado |
| 0xB002 | UnusedPrivateMethod | Método privado no utilizado |
| 0xB003 | UnusedLocalVariable | Variable local no utilizada |
| 0xB004 | UnusedFormalParameter | Parámetro formal no utilizado |
| 0xB005 | AvoidPrintStackTrace | Evitar printStackTrace() |
| 0xB006 | AvoidReassigningLoopVariables | No reasignar variables de bucle |
| 0xB007 | DefaultLabelNotLastInSwitchStmt | Etiqueta default debe ser la última en switch |
| 0xB008 | ForLoopVariableCount | Controlar cantidad de variables en for |
| 0xB009 | JUnitAssertionsShouldIncludeMessage | Aserciones JUnit deben incluir mensaje |
| 0xB010 | JUnitTestContainsTooManyAsserts | Test JUnit con demasiadas aserciones |
| 0xB011 | JUnitTestsShouldIncludeAssert | Tests JUnit deben incluir aserciones |
| 0xB012 | LooseCoupling | Evitar acoplamiento débil - usar interfaces |
| 0xB013 | MethodReturnsInternalArray | Método retorna array interno |
| 0xB014 | MissingOverride | Falta anotación @Override |
| 0xB015 | OneDeclarationPerLine | Una declaración por línea |
| 0xB016 | PreserveStackTrace | Preservar stack trace al relanzar excepciones |
| 0xB017 | ReplaceEnumerationWithIterator | Reemplazar Enumeration con Iterator |
| 0xB018 | ReplaceHashtableWithMap | Reemplazar Hashtable con Map |
| 0xB019 | ReplaceVectorWithList | Reemplazar Vector con List |
| 0xB020 | SwitchStmtsShouldHaveDefault | Switch debe tener case default |
| 0xB021 | UnusedAssignment | Asignación no utilizada |

## Code Style (category/java/codestyle.xml)

| Código | Regla PMD | Descripción |
|--------|-----------|-------------|
| 0x0001 | ClassNamingConventions | Clases en CamelloCase |
| 0x0002 | MethodNamingConventions | Métodos en dromedarioCase |
| 0x0004 | FieldNamingConventions | Atributos en dromedarioCase |
| 0x000D | ClassNamingConventions (test) | Tests con nombre Clase+Test |
| 0xC001 | ShortMethodName | Nombre de método muy corto |
| 0xC002 | ShortVariable | Nombre de variable muy corto |
| 0xC003 | LongVariable | Nombre de variable muy largo |
| 0xC004 | AvoidDollarSigns | Evitar $ en identificadores |
| 0xC005 | BooleanGetMethodName | Métodos boolean deben empezar con 'is' |
| 0xC006 | CallSuperInConstructor | Llamar a super() en constructor |
| 0xC007 | CommentDefaultAccessModifier | Comentar modificadores de acceso por defecto |
| 0xC008 | ConfusingTernary | Operador ternario confuso |
| 0xC009 | ControlStatementBraces | Llaves en estructuras de control |
| 0xC010 | EmptyMethodInAbstractClassShouldBeAbstract | Método vacío en clase abstracta debe ser abstracto |
| 0xC011 | ExtendsObject | No extender explícitamente Object |
| 0xC012 | FieldDeclarationsShouldBeAtStartOfClass | Declaraciones de campos al inicio |
| 0xC013 | ForLoopShouldBeWhileLoop | For debería ser while |
| 0xC014 | FormalParameterNamingConventions | Convención para parámetros formales |
| 0xC015 | GenericsNaming | Convención para genéricos |
| 0xC016 | IdenticalCatchBranches | Branches catch idénticos |
| 0xC017 | LinguisticNaming | Nomenclatura lingüística |
| 0xC018 | LocalVariableNamingConventions | Convención para variables locales |
| 0xC019 | NoPackage | Código debe estar en un paquete |
| 0xC020 | OnlyOneReturn | Solo un return por método |
| 0xC021 | PackageCase | Paquetes en minúsculas |
| 0xC022 | PrematureDeclaration | Declaración prematura de variable |
| 0xC023 | TooManyStaticImports | Demasiados imports estáticos |
| 0xC024 | UnnecessaryAnnotationValueElement | Elemento value innecesario en anotación |
| 0xC025 | UnnecessaryConstructor | Constructor innecesario |
| 0xC026 | UnnecessaryFullyQualifiedName | Nombre completamente calificado innecesario |
| 0xC027 | UnnecessaryLocalBeforeReturn | Variable local innecesaria antes de return |
| 0xC028 | UnnecessaryModifier | Modificador innecesario |
| 0xC029 | UnnecessaryReturn | Return innecesario |
| 0xC030 | UselessParentheses | Paréntesis inútiles |
| 0xC031 | UselessQualifiedThis | This calificado inútil |

## Design (category/java/design.xml)

| Código | Regla PMD | Descripción |
|--------|-----------|-------------|
| 0x002F | CyclomaticComplexity | Complejidad ciclomática alta |
| 0xD001 | AvoidCatchingGenericException | Evitar atajar Exception genérica |
| 0xD002 | AvoidDeeplyNestedIfStmts | Evitar if anidados profundos |
| 0xD003 | AvoidRethrowingException | Evitar relanzar excepción |
| 0xD004 | AvoidThrowingNewInstanceOfSameException | Evitar lanzar nueva instancia de misma excepción |
| 0xD005 | AvoidThrowingNullPointerException | Evitar lanzar NullPointerException |
| 0xD006 | AvoidThrowingRawExceptionTypes | Evitar lanzar tipos de excepción raw |
| 0xD007 | ClassWithOnlyPrivateConstructorsShouldBeFinal | Clase con solo constructores privados debe ser final |
| 0xD008 | CognitiveComplexity | Complejidad cognitiva alta |
| 0xD009 | CollapsibleIfStatements | Statements if colapsables |
| 0xD010 | CouplingBetweenObjects | Acoplamiento entre objetos |
| 0xD011 | DataClass | Clase de datos |
| 0xD012 | DoNotExtendJavaLangError | No extender java.lang.Error |
| 0xD013 | ExceptionAsFlowControl | Excepción como control de flujo |
| 0xD014 | ExcessiveClassLength | Clase demasiado larga |
| 0xD015 | ExcessiveImports | Demasiados imports |
| 0xD016 | ExcessiveMethodLength | Método demasiado largo |
| 0xD017 | ExcessiveParameterList | Lista de parámetros excesiva |
| 0xD018 | ExcessivePublicCount | Demasiados elementos públicos |
| 0xD019 | FinalFieldCouldBeStatic | Campo final podría ser estático |
| 0xD020 | GodClass | Clase Dios (demasiada responsabilidad) |
| 0xD021 | ImmutableField | Campo inmutable |
| 0xD022 | LogicInversion | Inversión de lógica |
| 0xD023 | NcssCount | NCSS (Non Commenting Source Statements) alto |
| 0xD024 | NPathComplexity | Complejidad NPath alta |
| 0xD025 | SignatureDeclareThrowsException | Firma declara lanzar Exception |
| 0xD026 | SimplifiedTernary | Ternario simplificable |
| 0xD027 | SimplifyBooleanAssertion | Simplificar aserción booleana |
| 0xD028 | SimplifyBooleanExpressions | Simplificar expresiones booleanas |
| 0xD029 | SimplifyBooleanReturns | Simplificar retornos booleanos |
| 0xD030 | SimplifyConditional | Simplificar condicional |
| 0xD031 | SingularField | Campo singular (usado en un solo método) |
| 0xD032 | SwitchDensity | Densidad de switch |
| 0xD033 | TooManyFields | Demasiados campos |
| 0xD034 | TooManyMethods | Demasiados métodos |
| 0xD035 | UselessOverridingMethod | Método de sobreescritura inútil |
| 0xD036 | UseObjectForClearerAPI | Usar Object para API más clara |

## Documentation (category/java/documentation.xml)

| Código | Regla PMD | Descripción |
|--------|-----------|-------------|
| 0x0007 | CommentRequired | Comentario requerido |
| 0x0030 | CommentSize | Tamaño de comentario |
| 0xDC01 | UncommentedEmptyConstructor | Constructor vacío sin comentar |
| 0xDC02 | UncommentedEmptyMethodBody | Cuerpo de método vacío sin comentar |

## Error Prone (category/java/errorprone.xml)

| Código | Regla PMD | Descripción |
|--------|-----------|-------------|
| 0xE000 | EmptyCatchBlock | Bloque catch vacío |
| 0xE001 | AvoidBranchingStatementAsLastInLoop | Evitar statement de ramificación al final de bucle |
| 0xE002 | AvoidCallingFinalize | Evitar llamar finalize() |
| 0xE003 | AvoidDecimalLiteralsInBigDecimalConstructor | Evitar literales decimales en constructor BigDecimal |
| 0xE004 | AvoidDuplicateLiterals | Evitar literales duplicados |
| 0xE005 | AvoidFieldNameMatchingMethodName | Evitar nombre de campo igual a método |
| 0xE006 | AvoidFieldNameMatchingTypeName | Evitar nombre de campo igual a tipo |
| 0xE007 | AvoidInstanceofChecksInCatchClause | Evitar checks instanceof en catch |
| 0xE008 | AvoidLiteralsInIfCondition | Evitar literales en condiciones if |
| 0xE009 | AvoidLosingExceptionInformation | Evitar perder información de excepción |
| 0xE010 | AvoidMultipleUnaryOperators | Evitar múltiples operadores unarios |
| 0xE011 | BrokenNullCheck | Verificación null rota |
| 0xE012 | CheckSkipResult | Verificar resultado de skip() |
| 0xE013 | ClassCastExceptionWithToArray | ClassCastException con toArray |
| 0xE014 | CloneMethodMustBePublic | Método clone debe ser público |
| 0xE015 | CloneMethodMustImplementCloneable | Método clone debe implementar Cloneable |
| 0xE016 | CloneMethodReturnTypeMustMatchClassName | Tipo de retorno clone debe coincidir con clase |
| 0xE017 | CloneThrowsCloneNotSupportedException | clone lanza CloneNotSupportedException |
| 0xE018 | CloseResource | Cerrar recurso |
| 0xE019 | CompareObjectsWithEquals | Comparar objetos con equals |
| 0xE020 | ConstructorCallsOverridableMethod | Constructor llama método sobreescribible |
| 0xE021 | DetachedTestCase | Test case separado |
| 0xE022 | DoNotCallGarbageCollectionExplicitly | No llamar garbage collection explícitamente |
| 0xE023 | DoNotExtendJavaLangThrowable | No extender java.lang.Throwable |
| 0xE024 | DoNotHardCodeSDCard | No hardcodear SD card |
| 0xE025 | DoNotThrowExceptionInFinally | No lanzar excepción en finally |
| 0xE026 | DontImportSun | No importar paquetes sun.* |
| 0xE027 | DontUseFloatTypeForLoopIndices | No usar float para índices de bucle |
| 0xE028 | EmptyFinalizer | Finalizador vacío |
| 0xE029 | EmptyFinallyBlock | Bloque finally vacío |
| 0xE030 | EmptyIfStmt | Statement if vacío |
| 0xE031 | EmptyInitializer | Inicializador vacío |
| 0xE032 | EmptyStatementBlock | Bloque de statement vacío |
| 0xE033 | EmptyStatementNotInLoop | Statement vacío no en bucle |
| 0xE034 | EmptySwitchStatements | Statements switch vacíos |
| 0xE035 | EmptySynchronizedBlock | Bloque synchronized vacío |
| 0xE036 | EmptyTryBlock | Bloque try vacío |
| 0xE037 | EmptyWhileStmt | Statement while vacío |

## Multithreading (category/java/multithreading.xml)

| Código | Regla PMD | Descripción |
|--------|-----------|-------------|
| 0xM001 | AvoidSynchronizedAtMethodLevel | Evitar synchronized a nivel de método |
| 0xM002 | AvoidThreadGroup | Evitar ThreadGroup |
| 0xM003 | AvoidUsingVolatile | Evitar usar volatile |
| 0xM004 | DoNotUseThreads | No usar Threads |
| 0xM005 | DontCallThreadRun | No llamar Thread.run() |
| 0xM006 | DoubleCheckedLocking | Double-checked locking |
| 0xM007 | NonThreadSafeSingleton | Singleton no thread-safe |
| 0xM008 | UnsynchronizedStaticFormatter | Formatter estático no sincronizado |
| 0xM009 | UseNotifyAllInsteadOfNotify | Usar notifyAll() en lugar de notify() |

## Performance (category/java/performance.xml)

| Código | Regla PMD | Descripción |
|--------|-----------|-------------|
| 0xP001 | AddEmptyString | Agregar String vacío |
| 0xP002 | AppendCharacterWithChar | Append carácter con char |
| 0xP003 | AvoidArrayLoops | Evitar bucles de arrays |
| 0xP004 | AvoidCalendarDateCreation | Evitar creación de Calendar para fechas |
| 0xP005 | AvoidFileStream | Evitar FileStream |
| 0xP006 | AvoidInstantiatingObjectsInLoops | Evitar instanciar objetos en bucles |
| 0xP007 | AvoidUsingShortType | Evitar usar tipo short |
| 0xP008 | BigIntegerInstantiation | Instanciación de BigInteger |
| 0xP009 | BooleanInstantiation | Instanciación de Boolean |
| 0xP010 | ByteInstantiation | Instanciación de Byte |
| 0xP011 | ConsecutiveAppendsShouldReuse | Appends consecutivos deben reutilizar |
| 0xP012 | ConsecutiveLiteralAppends | Appends literales consecutivos |
| 0xP013 | InefficientEmptyStringCheck | Verificación ineficiente de String vacío |
| 0xP014 | InefficientStringBuffering | String buffering ineficiente |
| 0xP015 | InsufficientStringBufferDeclaration | Declaración insuficiente de StringBuffer |
| 0xP016 | IntegerInstantiation | Instanciación de Integer |
| 0xP017 | LongInstantiation | Instanciación de Long |
| 0xP018 | OptimizableToArrayCall | Llamada toArray() optimizable |
| 0xP019 | RedundantFieldInitializer | Inicializador de campo redundante |
| 0xP020 | ShortInstantiation | Instanciación de Short |
| 0xP021 | SimplifyStartsWith | Simplificar startsWith |
| 0xP022 | StringInstantiation | Instanciación de String |
| 0xP023 | StringToString | String.toString() |
| 0xP024 | TooFewBranchesForASwitchStatement | Muy pocas ramas para switch |
| 0xP025 | UnnecessaryWrapperObjectCreation | Creación innecesaria de wrapper |
| 0xP026 | UseArrayListInsteadOfVector | Usar ArrayList en lugar de Vector |
| 0xP027 | UseArraysAsList | Usar Arrays.asList() |
| 0xP028 | UseIndexOfChar | Usar indexOf(char) |
| 0xP029 | UseIOStreamsWithApacheCommonsFileItem | Usar IOStreams con Apache Commons FileItem |
| 0xP030 | UseStringBufferForStringAppends | Usar StringBuffer para appends |
| 0xP031 | UseStringBufferLength | Usar StringBuffer.length() |

## Security (category/java/security.xml)

| Código | Regla PMD | Descripción |
|--------|-----------|-------------|
| 0xS001 | HardCodedCryptoKey | Clave criptográfica hardcodeada |
| 0xS002 | InsecureCryptoIv | Vector de inicialización criptográfico inseguro |

## Reglas Personalizadas

| Código | Regla | Descripción |
|--------|-------|-------------|
| 0xF000 | NoThrowsDeclarationForRuntimeException | No declarar throws de excepciones no controladas |
| 0xF001 | AvoidPrintStackTraceInCatch | Atajar para hacer print no es gestionar |
| 0xF002 | AvoidPrintStackTraceInCatch | No usar printStackTrace en catch |
| 0xF003 | (Ver IllegalThrows en Checkstyle) | No lanzar excepciones base |
| 0xE004 | HashCodeShouldUseLibrary | hashCode debe usar Objects.hash/Arrays.hashCode |
| 0xE005 | EqualsWithoutPatternMatching | equals debe usar pattern matching |
| 0x0031 | NoBusinessLogicInGettersSetters | Getters/setters no para lógica |
| 0xE003 | AvoidStringConcatenationInLoops | No concatenar String en bucles |
| 0xE00B | DifferentExceptionsForNullAndEmpty | Excepciones diferentes para null/vacío |
| 0xE008 | DifferentExceptionsForNullAndEmpty | Excepciones diferentes para null/vacío |
