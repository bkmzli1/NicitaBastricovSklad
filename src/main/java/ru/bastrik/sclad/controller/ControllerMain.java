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
    public TextField author;
    public TextField txt;
    public TextField executor;
    public DatePicker dateStart;
    public DatePicker dateStop;
    public TableView table;

    static ArrayList<String> authors;
    static ArrayList<String> txts;
    static ArrayList<String> executors;
    static ArrayList<String> dateStarts;
    static ArrayList<String> dateStops;
    static ArrayList<Table> tables = new ArrayList<>();


    static GetMainItems getMainItems;

    public static final Logger logger = LogManager.getLogger();


    public void initialize() {
        dataSettings(dateStart);
        dataSettings(dateStop);
        getMainItems = new GetMainItems(author, txt, executor, dateStart, dateStop, table);
        loadData();


        TableColumn<Table, String> Tauthors = new TableColumn<Table, String>("имя заказчика");
        TableColumn<Table, String> Ttxts = new TableColumn<Table, String>("заказ");
        TableColumn<Table, String> Texecutors = new TableColumn<Table, String>("имя исполнителя");
        TableColumn<Table, String> TdateStarts = new TableColumn<Table, String>("дата заказа");
        TableColumn<Table, String> TdateStops = new TableColumn<Table, String>("дата окончания");

        Tauthors.setCellValueFactory(new PropertyValueFactory<>("NAME_AUTHOR"));
        Ttxts.setCellValueFactory(new PropertyValueFactory<>("TEXT"));
        Texecutors.setCellValueFactory(new PropertyValueFactory<>("NAME_EXECUTOR"));
        TdateStarts.setCellValueFactory(new PropertyValueFactory<>("DATE_START"));
        TdateStops.setCellValueFactory(new PropertyValueFactory<>("DATE_STOP"));


        table.getColumns().addAll(Tauthors, Ttxts, Texecutors, TdateStarts, TdateStops);
        upTable();

    }

    public void add(ActionEvent actionEvent) {
        if (!author.getText().equals("") & !txt.getText().equals("") & !executor.getText().equals("") & !dateStart.getValue().equals("") & !dateStop.getValue().equals("")) {
            authors.add(author.getText());
            txts.add(txt.getText());
            executors.add(executor.getText());
            dateStarts.add(dateStart.getValue().toString());
            dateStops.add(dateStart.getValue().toString());
            upTable();
            setDate();
        }

    }

    void dataSettings(DatePicker datePicker) {
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
        datePicker.setPromptText("дд/мм/гггг");
        datePicker.setConverter(converter);
    }

    public void remove(ActionEvent actionEvent) {
        new StageDialog("remove");
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

    void upTable() {
        tables.clear();
        for (int i = 0; i < authors.size(); i++) {
            tables.add(new Table(authors.get(i), txts.get(i), executors.get(i), dateStarts.get(i), dateStops.get(i)));
        }
        ObservableList<Table> list = FXCollections.observableArrayList();
        list.addAll(tables);
        this.table.setItems(list);
    }

}
