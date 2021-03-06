package DataAccess;

import Logics.FieldsHandler;
import static UserInterface.LeadingFrame.mainFrame;
import java.io.*;
import static Logics.TimeHandler.timeHandler;

public class SaveToTxt implements Runnable{

    @Override
    public synchronized void run() {
        try {
            PrintWriter pWriter = new PrintWriter(new FileWriter(new File(System.getProperty("user.home"), mainFrame.whereAmI)));
            pWriter.println(listSize());
            for(int i = 0; i < listSize(); i++) {
                pWriter.println(getCurrentTask(i)+"|"+getCurrentDate(i)+"|"+getCurrentIndex(i));
            }
            pWriter.close();
            PrintWriter timeWriter = new PrintWriter(new FileWriter(new File(System.getProperty("user.home"), "Time.txt")));
            timeWriter.println(timeHandler.getToday());
            timeWriter.println(timeHandler.getActualYear());
            timeWriter.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.gc();
    }

    private static int listSize() {
        return FieldsHandler.indexedList.size();
    }

    private static int getCurrentIndex(int i) {
        return FieldsHandler.getData(i).getIndex();
    }

    private static String getCurrentDate(int i) {
        return FieldsHandler.getData(i).getDate();
    }

    private static String getCurrentTask(int i) {
        return FieldsHandler.getData(i).getTask();
    }
}
