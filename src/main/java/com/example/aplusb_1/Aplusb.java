package com.example.aplusb_1; //定义一个包，可以理解为java中的文件夹，和该文件里的类名一起唯一的确定一个类

public class Aplusb {
    private int a;
    private int b;

    public Aplusb(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getAPlusB() {
        return a+b;
    }
}
