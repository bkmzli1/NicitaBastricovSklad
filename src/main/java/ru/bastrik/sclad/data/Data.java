package ru.bastrik.sclad.data;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public enum Data implements Serializable {
    NAME_AUTHOR(new ArrayList<String>()),
    TEXT(new ArrayList<String>()),
    NAME_EXECUTOR(new ArrayList<String>()),
    DATE_START(new ArrayList<String>()),
    DATE_STOP(new ArrayList<String>());
    public static final Logger logger = LogManager.getLogger();
    private Object value;
    private static String fileAddress = System.getenv("APPDATA") + "\\.nikita";
    public static String fileSave = fileAddress + "\\data.data";

    Data(int value) {
        this.value = value;
    }

    Data(String values) {
        this.value = values;
    }

    Data(ArrayList<String> list) {
        this.value = list;
    }

    public int getValuetI() {
        return (int) value;
    }

    public String getValuetS() {
        return (String) value;
    }

    public ArrayList<String> getValuetAL() {
        List<?> list = new ArrayList<>();
        if (value.getClass().isArray()) {
            list = Arrays.asList((Object[]) value);
        } else if (value instanceof Collection) {
            list = new ArrayList<>((Collection<?>) value);
        }
        return (ArrayList<String>) list;
    }

    public void setValuetAL(ArrayList<String> arrayList) {
        this.value = arrayList;
    }


    public void setValue(Object value) {
        this.value = value;
    }

    public static void load() throws Exception {
        try {
            read();
        } catch (FileNotFoundException e) {
            try {
                writer();
            } catch (IOException ex) {
                logger.warn("writer error:", ex);
            }
        }
    }

    public static void save() {
        try {
            writer();
        } catch (IOException e) {
            logger.warn("writer error:", e);
        }
    }

    public static FileInputStream fiStream;
    public static ObjectInputStream oiStream;

    private static void read() throws Exception {
        fiStream = new FileInputStream(new File(fileSave));
        oiStream = new ObjectInputStream(fiStream);
        logger.info("read start");
        for (int i = 0; i < Data.values().length; i++) {
            Object reading = oiStream.readObject();
            logger.trace("read:" + Data.values()[i] + " = (" + reading + ")");
            Data.values()[i].value = reading;
        }
        logger.info("read stop");
        oiStream.close();
        fiStream.close();
    }

    private static void writer() throws IOException {
        File fileS = new File(fileAddress);

        if (!fileS.exists()) {
            fileS.mkdir();
        }

        FileOutputStream foStream = new FileOutputStream(new File(fileSave), false);
        ObjectOutputStream ooStream = new ObjectOutputStream(foStream);
        ooStream.reset();
        logger.info("writer start");
        for (int i = 0; i < Data.values().length; i++) {
            Object oWriter = Data.values()[i].value;
            logger.trace("writer:" + Data.values()[i] + " = (" + oWriter + ")");
            ooStream.writeObject(oWriter);
        }
        logger.info("writer stop");
        ooStream.close();
        foStream.close();
    }


}
