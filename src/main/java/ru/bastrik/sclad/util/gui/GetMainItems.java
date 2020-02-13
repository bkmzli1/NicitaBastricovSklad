package ru.bastrik.sclad.util.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ru.bastrik.sclad.controller.ControllerMain;

public class GetMainItems {
    public TextField text;
    public DatePicker dateText;
    public TableView table;

    public GetMainItems(TextField text, DatePicker dateText, TableView table) {
        this.text = text;
        this.dateText = dateText;
        this.table = table;
    }

    public TextField getText() {
        return text;
    }

    public void setText(TextField text) {
        this.text = text;
    }

    public DatePicker getDateText() {
        return dateText;
    }

    public void setDateText(DatePicker dateText) {
        this.dateText = dateText;
    }

    public TableView getTable() {
        return table;
    }

    public void setTable(TableView table) {
        this.table = table;
    }

}
