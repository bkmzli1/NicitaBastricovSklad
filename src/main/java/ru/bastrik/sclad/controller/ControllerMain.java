package ru.bastrik.sclad.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.bastrik.sclad.data.Data;
import ru.bastrik.sclad.util.gui.GetMainItems;
import ru.bastrik.sclad.util.gui.Table;
import ru.bastrik.sclad.util.gui.window.StageDialog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControllerMain {
    public TextField text;
    public DatePicker dateText;
    public TableView table;
    static ArrayList<String> name;
    static ArrayList<String> date;
    static ArrayList<Table> tables = new ArrayList<>();
    static TableColumn<Table, String> TCtype = new TableColumn<Table, String>("дата");
    static GetMainItems getMainItems;

    public static final Logger logger = LogManager.getLogger();

    public void initialize() {
        getMainItems = new GetMainItems(text, dateText, table);
        loadData();
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }

        };
        dateText.setPromptText("дд/мм/гггг");
        TableColumn<Table, String> TCorganization = new TableColumn<Table, String>("имя");

        TCtype.setMaxWidth(77);
        TCtype.setMinWidth(74);
        TCorganization.setCellValueFactory(new PropertyValueFactory<>("name"));
        TCtype.setCellValueFactory(new PropertyValueFactory<>("date"));

        table.getColumns().addAll(TCorganization, TCtype);
        upTable();

    }

    public void add(ActionEvent actionEvent) {
        name.add(text.getText());
        date.add(String.valueOf(dateText.getValue()));
        upTable();
        setDate();

    }

    public void remove(ActionEvent actionEvent) {
        new StageDialog("remove");
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

    void upTable() {
        tables.clear();
        for (int i = 0; i < name.size(); i++) {
            tables.add(new Table(name.get(i), date.get(i)));
        }
        ObservableList<Table> list = FXCollections.observableArrayList();
        list.addAll(tables);
        this.table.setItems(list);
    }

}
