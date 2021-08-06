package com.company.entity;

import java.util.Random;

public enum Mark {

    A(90),B(70),C(50),D(30),E(10);
    private Integer mark;

    Mark(Integer m) {

        mark = m;
    }

     public int getMark(){

        return mark;
     }

    public static Mark getRandom() {

        return Mark.values()[new Random().nextInt(Mark.values().length)];
    }

}
