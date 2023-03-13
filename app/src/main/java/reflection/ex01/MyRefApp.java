package reflection.ex01;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//어노테이션으로 깃발을 세우고 연결

public class MyRefApp {

    private static Set<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        Set<Class<?>> classes = new HashSet<>();
        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.getName().endsWith(".class")) {
                Class<?> cls = Class
                        .forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));

                if (cls.toString().contains("class")) { // interface를 제외함
                    classes.add(cls);
                }
            } else if (file.isDirectory()) {
                assert !file.getName().contains("."); // 파일 안에 있을 경우 재귀함수로 더 들어감
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            }
        }
        return classes;
    }

    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        // String enter = sc.nextLine();
        String enter = "/reply";

        String packageName = "reflection.ex01"; // 스캔할 최상위 패키지 이름

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        Set<Class<?>> classes = new HashSet<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }

        for (Class<?> cls : classes) {

            if (cls.isAnnotationPresent(Controller.class)) {
                Object currentClass = cls.getDeclaredConstructor().newInstance();
                Method[] motheds = currentClass.getClass().getDeclaredMethods();

                for (Method mt : motheds) {
                    Annotation anno = mt.getDeclaredAnnotation(RequestMapping.class);
                    if (anno == null) {
                        System.out.println("못찾음");
                    } else {
                        RequestMapping rm = (RequestMapping) anno;

                        if (rm.uri().equals(enter)) {
                            mt.invoke(currentClass);
                        }
                    }
                }
            }
        }
    }

}
