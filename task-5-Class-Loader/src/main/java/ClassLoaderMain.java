import by.epam.jmp.classloader.CustomClassLoader;
import by.epam.jmp.classloader.MainFunctionality;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ClassLoaderMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException,
            URISyntaxException, MalformedURLException {

        MainFunctionality mainFunctionality = new MainFunctionality();
        mainFunctionality.execute();

        String fileName = "newFunctionality.jar";
        URL jarURL = ClassLoader.getSystemClassLoader().getResource(fileName).toURI().toURL();
        URL[] urls = new URL[] {jarURL};
        CustomClassLoader customClassLoader = new CustomClassLoader(urls);
        Class NewFunctionalityClass = customClassLoader.loadClass("by.epam.jmp.classloader.NewFunctionality");

        Method method = NewFunctionalityClass.getDeclaredMethod("execute");
        Object newFunctionality = NewFunctionalityClass.newInstance();
        method.invoke(newFunctionality);

    }
}
