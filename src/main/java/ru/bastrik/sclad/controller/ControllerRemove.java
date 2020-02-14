package ru.bastrik.sclad.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import ru.bastrik.sclad.data.Data;
import ru.bastrik.sclad.util.gui.Table;

import java.util.ArrayList;

import static ru.bastrik.sclad.controller.ControllerMain.*;

public class ControllerRemove {
    public ListView list;
    static ArrayList<HBox> listHBox = new ArrayList<>();
    static ArrayList<CheckBox> checkBoxes = new ArrayList<>();

    public void initialize() {
        updateList();
    }

    void loadData() {
        authors = Data.NAME_AUTHOR.getValuetAL();
        txts = Data.TEXT.getValuetAL();
        executors = Data.NAME_EXECUTOR.getValuetAL();
        dateStarts = Data.DATE_START.getValuetAL();
        dateStops = Data.DATE_STOP.getValuetAL();
    }

    void setDate() {
        Data.NAME_AUTHOR.setValue(authors);
        Data.TEXT.setValue(txts);
        Data.NAME_EXECUTOR.setValue(executors);
        Data.DATE_START.setValue(dateStarts);
        Data.DATE_STOP.setValue(dateStops);
        Data.save();
    }

    public void remove(ActionEvent actionEvent) {
        for (int i = checkBoxes.size() - 1; i >= 0; i--) {
            if (checkBoxes.get(i).isSelected()) {
                authors.remove(i);
                txts.remove(i);
                executors.remove(i);
                dateStarts.remove(i);
                dateStops.remove(i);
            }
        }
        upTable();
        updateList();
        setDate();
    }

    void updateList() {
        checkBoxes.clear();
        listHBox.clear();
        for (int i = 0; i < authors.size(); i++) {
            HBox hBox = new HBox(10);
            CheckBox checkBox = new CheckBox(
                    "автор:\" " + authors.get(i) + " \"\n"
                            + "заказ:\" " + txts.get(i) + " \"\n"
                            + "имя исполнителя:\" " + executors.get(i) + " \"\n"
                            + "дата заказа:\" " + dateStarts.get(i) + " \"\n"
                            + "дата окончания:\" " + dateStops.get(i) + " \"");
            checkBoxes.add(checkBox);
            hBox.getChildren().addAll(checkBox);
            listHBox.add(hBox);
        }
        ObservableList<HBox> list = FXCollections.observableArrayList();
        list.addAll(listHBox);
        this.list.setItems(list);
    }

    void upTable() {
        tables.clear();
        for (int i = 0; i < authors.size(); i++) {
            tables.add(new Table(authors.get(i), txts.get(i), executors.get(i), dateStarts.get(i), dateStops.get(i)));
        }
        ObservableList<Table> list = FXCollections.observableArrayList();
        list.addAll(tables);
        getMainItems.table.setItems(list);
    }

}
