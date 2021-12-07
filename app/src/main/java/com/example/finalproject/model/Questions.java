package com.example.finalproject.model;

public class Questions {

    private String text;
    private String rightanswer;

    public Questions(String text, String rightanswer){
        this.text=text;
        this.rightanswer=rightanswer;
    }
    public String getText(){return text;}
    public String getRightanswer(){return rightanswer;}
}
