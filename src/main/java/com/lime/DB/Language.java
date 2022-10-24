package com.lime.DB;

/*
 * by Alima Amantay
 * on 09.04.2021, 23:03
 */
public class Language {
    private int id;
    private String lan;

    public Language(int id, String lan) {
        this.id = id;
        this.lan = lan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }
}
