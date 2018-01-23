package models;

import java.util.Date;

public class Blogpost {
    private final String title;
    private final String comment;
    private final String autor;


    public Blogpost(String title, String comment, String autor) {
        this.title = title;
        this.comment = comment;
        this.autor = autor;

    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public String getAutor() {
        return autor;
    }


}
