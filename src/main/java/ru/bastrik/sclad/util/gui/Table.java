package ru.bastrik.sclad.util.gui;

public class Table {
    String
            NAME_AUTHOR,
            TEXT,
            NAME_EXECUTOR,
            DATE_START,
            DATE_STOP;

    public Table(String NAME_AUTHOR, String TEXT, String NAME_EXECUTOR, String DATE_START, String DATE_STOP) {
        this.NAME_AUTHOR = NAME_AUTHOR;
        this.TEXT = TEXT;
        this.NAME_EXECUTOR = NAME_EXECUTOR;
        this.DATE_START = DATE_START;
        this.DATE_STOP = DATE_STOP;
    }

    public String getNAME_AUTHOR() {
        return NAME_AUTHOR;
    }

    public void setNAME_AUTHOR(String NAME_AUTHOR) {
        this.NAME_AUTHOR = NAME_AUTHOR;
    }

    public String getTEXT() {
        return TEXT;
    }

    public void setTEXT(String TEXT) {
        this.TEXT = TEXT;
    }

    public String getNAME_EXECUTOR() {
        return NAME_EXECUTOR;
    }

    public void setNAME_EXECUTOR(String NAME_EXECUTOR) {
        this.NAME_EXECUTOR = NAME_EXECUTOR;
    }

    public String getDATE_START() {
        return DATE_START;
    }

    public void setDATE_START(String DATE_START) {
        this.DATE_START = DATE_START;
    }

    public String getDATE_STOP() {
        return DATE_STOP;
    }

    public void setDATE_STOP(String DATE_STOP) {
        this.DATE_STOP = DATE_STOP;
    }
}
