package com.company.entity;

public enum Mark {

    A(90),B(70),C(50),D(30),E(10);
    private Integer mark;

    Mark(Integer m) {

        mark = m;
    }

     public int getMark(){

        return mark;
     }

    public static Integer getRandom() {

        return values()[(int) (Math.random() * values().length)].mark;
    }
}
