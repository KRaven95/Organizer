package Logics;

import static UserInterface.LeadingFrame.mainFrame;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FieldsHandler {
    
    public FieldsHandler(String task, String date, int index) {
        this.task = task;
        this.date = date;
        this.index = index;
    }
    
    public FieldsHandler() {
        
    }
    
    public static FieldsHandler getData(int index) {
        fHandler = new FieldsHandler();
        ListIterator<FieldsHandler> iteratorFH = indexedList.listIterator(index);
        fHandler = iteratorFH.next();
        return fHandler;
    }
    
    public void refreshAndDisplayRefreshedList(int i) {
        FieldsHandler.indexedList.stream()
                .map(x -> x.decreaseIndex(i))
                .collect(Collectors.toList());
        mainFrame.setElements();
    }
    
    public void setTask(String task) {
        this.task = task;
    }
    public String getTask() {
        return task;
    }
    public String getDate() {
        return date;
    }
    public int getIndex() {
        return index;
    }

    public static int getCurrentYear() {
        return currentYear;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public int decreaseIndex(int i) {
        for (int j = 1; j <= i ; j++) {
            index--;
        }
        return index;
    }
    
    public static void addToList(String task, String date, int index) {
        indexedList.addLast(new FieldsHandler(task, date, index));
    }
    
    public static void listSort() {
        if(indexedList.size() >= 2) {
            indexedList.sort((FieldsHandler o1, FieldsHandler o2) -> Integer.compare(o1.getIndex(), o2.getIndex()));
        }
    }
    
    public static int actualDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_YEAR);
    }
    
    public static int selectedDays(int day, int month, int year, int numOfDays) {
        int sumOfSelectedDays = (numOfDays + day);
        for(int i = getCurrentYear() ; i < year ; i++){
            sumOfSelectedDays += isLeap(i) ? 366 : 365;
        }
        return sumOfSelectedDays = month >= 3 && isLeap(year) ? sumOfSelectedDays + 1 : sumOfSelectedDays;
    }
    
    public static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? true : false;
    }

    @Override
    public String toString() {
        return getTask()+" "+getDate()+" "+getIndex();
    }
    
    private static int currentYear = LocalDate.now().getYear();
    static FieldsHandler fHandler;
    public static LinkedList<FieldsHandler> indexedList = new LinkedList<>();    //regular list of items
    private String task;
    private String date;
    private int index;
}
