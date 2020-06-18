package com.worlds.myteaching.json;

public class Item {

    private int imag;
    private String name;
    private String desc;

    public Item(int imag, String name, String desc) {
        this.imag = imag;
        this.name = name;
        this.desc = desc;
    }

    public int getImag() {
        return imag;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

