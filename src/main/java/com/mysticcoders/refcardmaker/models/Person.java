package com.mysticcoders.refcardmaker.models;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 294507227537343259L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
