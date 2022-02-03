package com.example.demo.pruebas;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cosa {

    String ff;
    String nn;

    public String getFf() {
        return ff;
    }

    public void setFf(String ff) {
        this.ff = ff;
    }

    public String getNn() {
        return nn;
    }

    public void setNn(String nn) {
        this.nn = nn;
    }

    @Override
    public String toString() {
        return "asdasd{" +
                "ff='" + ff + '\'' +
                ", nn='" + nn + '\'' +
                '}';
    }

    public Cosa(String ff, String nn) {
        this.ff = ff;
        this.nn = nn;
    }

    public Cosa() {
    }
}
