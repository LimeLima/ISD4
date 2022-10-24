package com.lime.DB;

/*
 * by Alima Amantay
 * on 09.04.2021, 22:25
 */
public class AudioBook {
    private int id;
    private String title;
    private String author;
    private int book_year;
    private int language_id;
    private int voice_id;

    public AudioBook(int id, String title, String author, int book_year, int language_id, int voice_id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.book_year = book_year;
        this.language_id = language_id;
        this.voice_id = voice_id;
    }

    public AudioBook(String title, String author, int book_year, int language_id, int voice_id) {
        this.title = title;
        this.author = author;
        this.book_year = book_year;
        this.language_id = language_id;
        this.voice_id = voice_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBook_year() {
        return book_year;
    }

    public void setBook_year(int book_year) {
        this.book_year = book_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getVoice_id() {
        return voice_id;
    }

    public void setVoice_id(int voice_id) {
        this.voice_id = voice_id;
    }
}
