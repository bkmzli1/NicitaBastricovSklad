package ru.bastrik.sclad.util.gui;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GetMainItems {
    public TextField author;
    public TextField txt;
    public TextField executor;
    public DatePicker dateStart;
    public DatePicker dateStop;
    public TableView table;

    public GetMainItems(TextField author, TextField txt, TextField executor, DatePicker dateStart, DatePicker dateStop, TableView table) {
        this.author = author;
        this.txt = txt;
        this.executor = executor;
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.table = table;
    }

    public TextField getAuthor() {
        return author;
    }

    public void setAuthor(TextField author) {
        this.author = author;
    }

    public TextField getTxt() {
        return txt;
    }

    public void setTxt(TextField txt) {
        this.txt = txt;
    }

    public TextField getExecutor() {
        return executor;
    }

    public void setExecutor(TextField executor) {
        this.executor = executor;
    }

    public DatePicker getDateStart() {
        return dateStart;
    }

    public void setDateStart(DatePicker dateStart) {
        this.dateStart = dateStart;
    }

    public DatePicker getDateStop() {
        return dateStop;
    }

    public void setDateStop(DatePicker dateStop) {
        this.dateStop = dateStop;
    }

    public TableView getTable() {
        return table;
    }

    public void setTable(TableView table) {
        this.table = table;
    }


}
