import by.epam.jmp.classloader.CustomClassLoader;
import by.epam.jmp.classloader.Functionality;
import by.epam.jmp.classloader.MainFunctionality;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class ClassLoaderMain {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException,
            ClassNotFoundException, IllegalAccessException, InstantiationException {

        Functionality mainFunctionality = new MainFunctionality();
        mainFunctionality.execute();

        String fileName = "newFunctionality.jar";
        URL jarURL = ClassLoader.getSystemClassLoader().getResource(fileName).toURI().toURL();
        URL[] urls = new URL[] {jarURL};
        CustomClassLoader customClassLoader = new CustomClassLoader(urls);
        Class NewFunctionalityClass = customClassLoader.loadClass("by.epam.jmp.classloader.NewFunctionality");

        Functionality newFunctionality = (Functionality) NewFunctionalityClass.newInstance();
        newFunctionality.execute();

    }
}
