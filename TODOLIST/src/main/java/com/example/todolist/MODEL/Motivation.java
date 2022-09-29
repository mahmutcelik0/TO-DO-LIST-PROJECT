package com.example.todolist.MODEL;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedHashMap;
import java.util.Map;

public class Motivation {
    private final Map<String,String> personAndSentence;
    private StringProperty person ;
    private StringProperty sentence;

    public Motivation(){
        personAndSentence = new LinkedHashMap<>();
        personAndSentence.put("ELON MUSK","I think that's the single best piece of advice:\nconstantly think about how you could be doing things better and questioning yourself.");
        personAndSentence.put("MARK ZUCKERBERG","The biggest risk is not taking any risk... In a world that changing really quickly, the only strategy that is guaranteed to fail is not takink risks.");
        personAndSentence.put("BILL GATES","It's fine to celebrate success but it is more important to heed the lessons of failure");
    }

    public int lengthOfMap(){
        return personAndSentence.size();
    }

    public void setPane(int number){
        String personName = personAndSentence.keySet().stream().toList().get(number);
        person = new SimpleStringProperty(personName);
        sentence = new SimpleStringProperty(personAndSentence.get(personName));
    }

    public String getPerson() {
        return person.get();
    }

    public StringProperty personProperty() {
        return person;
    }

    public String getSentence() {
        return sentence.get();
    }

    public StringProperty sentenceProperty() {
        return sentence;
    }
}
