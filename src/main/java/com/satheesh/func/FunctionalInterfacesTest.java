package com.satheesh.func;

interface Calculator{
    int add(int a, int b);
    default String defaultMethod(){
        return "this is default method";
    }
}


public class FunctionalInterfacesTest {

    public static void main(String[] args) {
        System.out.println("This is first intellij program");
    }

}
