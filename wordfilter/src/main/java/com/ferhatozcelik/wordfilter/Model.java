package com.ferhatozcelik.wordfilter;

public class Model {

    private String id;
    private String word;

    public Model(String id, String word) {
        super();
        this.id = id;
        this.word = word;
    }
    public Model() {
        super();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
