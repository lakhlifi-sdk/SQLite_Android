package com.lakhlifi.sqlite_project.Models;

public class Person {
    private int code;
    private String first_name;
    private String last_name;
    private double notes_average;

    public  Person(){}


    public Person(int code, String first_name, String last_name, double notes_average) {
        this.code = code;
        this.first_name = first_name;
        this.last_name = last_name;
        this.notes_average = notes_average;
    }

    public float getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getNotes_average() {
        return notes_average;
    }

    public void setNotes_average(int notes_average) {
        this.notes_average = notes_average;
    }

    @Override
    public String toString() {
        return "Person{" +
                "code=" + code +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", notes_average=" + notes_average +
                '}';
    }
}
