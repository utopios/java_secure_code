package com.example.demo_jour_2.tools;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;

public class WhitelistClassLoader extends URLClassLoader {
    private Set<String> allowedClasses;

    public WhitelistClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
        this.allowedClasses = new HashSet<>();
    }

    public void addAllowedClass(String className) {
        allowedClasses.add(className);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (!allowedClasses.contains(name)) {
            throw new ClassNotFoundException("Access denied for class: " + name);
        }
        return super.loadClass(name, resolve);
    }

    public static void run() throws MalformedURLException, ClassNotFoundException {
        URL[] urls = {new URL("file:///path/to/classes/")};
        WhitelistClassLoader loader = new WhitelistClassLoader(urls, WhitelistClassLoader.class.getClassLoader());
        loader.addAllowedClass("com.example.SafeClass");
        loader.addAllowedClass("com.example.AnotherSafeClass");

        Class<?> safeClass = loader.loadClass("com.example.SafeClass");
        System.out.println("Classe chargée : " + safeClass.getName());

        Class<?> unsafeClass = loader.loadClass("com.example.UnsafeClass");
    }
}
