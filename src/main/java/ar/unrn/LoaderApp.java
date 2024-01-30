package ar.unrn;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Esta clase se encarga de ejecutar todos los main en esta ubicación.
 * No es necesaria (o recomendada) su modificación.
 */
@SuppressWarnings("unchecked")
public class LoaderApp {

    /**
     * Esta configuración no debiera de ser necesario cambiar.
     * La organización de los proyectos debe ser la misma para todo.
     * _you've got a package to run_
     */
    private static final String PACKAGE_TO_RUN = "ar.unrn";

    /**
     * Punto de entrada del trabajo práctico, este método se encarga de ejecutar
     * todos los contenidos en esta ubicación.
     *
     * @param args son los argumentos de invocación que serán pasados a los
     *             otros main.
     */
    public static void main(String[] args) {
        Class[] clases;
        try {
            clases = getClasses(PACKAGE_TO_RUN);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("El paquete no existe", e);
        } catch (IOException e) {
            throw new RuntimeException("Error de acceso al recurso", e);
        }
        for (Class klass : clases) {
            String actual = klass.getName();
            if (!klass.equals(LoaderApp.class)) {
                System.out.printf("-Start: %s-----------\n", actual);
                try {
                    Method principal = klass.getMethod("main", String[].class);
                    try {
                        principal.invoke(null, (Object) args);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Fallo de permisos", e);
                    } catch (InvocationTargetException e) {
                        System.out.println("Excepción al llamar el main");
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    System.out.printf("La clase '%s': no posee un main\n", actual);
                }
            }
            System.out.println("-End.-----");
        }
    }

    // Métodos extraídos de:
    // https://web.archive.org/web/20090227113602/http://snippets.dzone.com:80/posts/show/4831

    /**
     * Scans all classes accessible from the context class loader which belong
     * to the given package and subpackages.
     *
     * @param packageName The base package to fetch
     * @return The classes in packageName
     * @throws ClassNotFoundException when a file looks like a class but isn't
     * @throws IOException when a file has access problems
     */
    private static Class[] getClasses(String packageName) throws
            ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * Recursive method used to find all classes in a given directory
     *      and subdirectories.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base
     *                    directory
     * @return The classes in the specified directory
     * @throws ClassNotFoundException when a file looks like a class but isn't
     */
    private static List<Class> findClasses(File directory, String packageName)
            throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file,
                        packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(
                        packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
