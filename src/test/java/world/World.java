package world;

import cucumber.api.java.en.Given;
import src.world.WorldObject;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Drareeg on 4/15/2016.
 */
public class World {



    public World() {
    }

    @Given("^We are in the world$")
    public void registerOnScope() {

    }

    private HashMap<Object, Object> items = new HashMap();

    public Object getOrNew(Object key, Class clazz) {
        if (!items.containsKey(key)) {
            try {
                items.put(key, clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return items.get(key);
    }


    @PostConstruct
    public void worldObjectScan() {
        Class[] classes = new Class[0];
        try {
            classes = getClasses("world");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        for (Class clazz : classes) {
            for (Field field : clazz.getDeclaredFields()) {
                WorldObject annotation = field.getAnnotation(WorldObject.class);
                if (annotation != null) {
                    try {
                        String objectName = WorldObject.DEFAULTVALUE.equals(annotation.value() ) ? field.getType().getName() : annotation.value();
                        field.set(null, this.getOrNew(objectName, field.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    }

    //from stackoverflow copy pasta
    private static Class[] getClasses(String packageName)
            throws ClassNotFoundException, IOException {
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
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
