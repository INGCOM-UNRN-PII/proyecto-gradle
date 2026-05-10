package ar.unrn.excepciones;

/**
 * Excepción base no comprobada (unchecked exception) para la aplicación.
 * <p>
 * Con fines educativos y de diseño, todas las excepciones no comprobadas
 * que se creen en el proyecto deben heredar de esta clase en lugar de
 * heredar directamente de {@link RuntimeException}.
 * </p>
 * Esta clase es abstracta, para evitar el lanzamiento su lanzamiento directo.
 */
public abstract class UNRNRuntimeException extends RuntimeException {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    /**
     * Construye una nueva excepción con {@code null} como su mensaje de detalle.
     */
    public UNRNRuntimeException() {
        super();
    }

    /**
     * Construye una nueva excepción con el mensaje de detalle especificado.
     *
     * @param message el mensaje de detalle que explica la causa de la excepción.
     */
    public UNRNRuntimeException(String message) {
        super(message);
    }

    /**
     * Construye una nueva excepción con el mensaje de detalle y la causa especificados.
     *
     * @param message el mensaje de detalle que explica la causa de la excepción.
     * @param cause   la causa subyacente de la excepción (una referencia nula es permitida,
     *                e indica que la causa es inexistente o desconocida).
     */
    public UNRNRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construye una nueva excepción con la causa especificada y un mensaje de detalle de
     * {@code (cause==null ? null : cause.toString())}.
     *
     * @param cause la causa subyacente de la excepción (una referencia nula es permitida,
     *              e indica que la causa es inexistente o desconocida).
     */
    public UNRNRuntimeException(Throwable cause) {
        super(cause);
    }
}
