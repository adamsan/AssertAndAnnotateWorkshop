package com.codecool.annotations;

import com.codecool.annotations.simplespring.ApplicationContext;

public class Annotations {

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext(new MyConfig());
        MyObject o = (MyObject) context.getBean(MyObject.class);
        System.out.println(o.foo());
        String stringBean = (String) context.getBean(String.class);
        System.out.println(stringBean);
    }
}

class MyObject {
    public String foo() {
        return "I'm " + this.getClass().getName() + "!";
    }
}