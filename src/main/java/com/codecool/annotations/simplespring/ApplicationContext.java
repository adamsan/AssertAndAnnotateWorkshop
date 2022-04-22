package com.codecool.annotations.simplespring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<Class<?>, Object> beans = new HashMap<>();

    public ApplicationContext(Object config) {
        if (!config.getClass().isAnnotationPresent(Configuration.class)) {
            throw new RuntimeException("Parameter class is not a configuration class");
        }

        System.out.println("Declared beans:");
        for (Method method : config.getClass().getMethods()) {
            if (method.isAnnotationPresent(Bean.class)) {
                System.out.println("\t - " + method);
                Class<?> type = method.getReturnType();
                try {
                    Object result = method.invoke(config);
                    beans.put(type, result);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public <T> T getBean(Class<T> clazz) {
        return (T) beans.get(clazz);
    }
}
