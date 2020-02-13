package ru.bastrik.sclad.util.gui;

public class Table {
    String name, date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Table(String name, String date) {
        this.name = name;
        this.date = date;
    }
}
