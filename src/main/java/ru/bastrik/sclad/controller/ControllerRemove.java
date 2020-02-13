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
        date = Data.DATE.getValuetAL();
        name = Data.NAME.getValuetAL();
    }

    void setDate() {
        Data.NAME.setValue(name);
        Data.DATE.setValue(date);
        Data.save();
    }

    public void remove(ActionEvent actionEvent) {
        for (int i = checkBoxes.size() - 1; i >= 0; i--) {
            if (checkBoxes.get(i).isSelected()) {
                name.remove(i);
                date.remove(i);
            }
        }
        upTable();
        updateList();
        setDate();
    }

    void updateList() {
        checkBoxes.clear();
        listHBox.clear();
        for (int i = 0; i < name.size(); i++) {
            HBox hBox = new HBox(10);
            CheckBox checkBox = new CheckBox(name.get(i) + ":" + date.get(i));
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
        for (int i = 0; i < name.size(); i++) {
            tables.add(new Table(name.get(i), date.get(i)));
        }
        ObservableList<Table> list = FXCollections.observableArrayList();
        list.addAll(tables);
        getMainItems.table.setItems(list);
    }


}
