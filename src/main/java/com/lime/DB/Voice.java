package com.lime.DB;

/*
 * by Alima Amantay
 * on 09.04.2021, 23:10
 */
public class Voice {
    private int id;
    private String voice;

    public Voice(int id, String voice) {
        this.id = id;
        this.voice = voice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }
}
