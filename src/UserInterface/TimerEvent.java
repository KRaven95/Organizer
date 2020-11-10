package UserInterface;

import java.util.Calendar;

public class TimerEvent extends Thread {
    
    @Override
    public void run() {
        FieldsHandler fieldsHandler = new FieldsHandler();
        fieldsHandler.refreshAndDisplayRefreshedList(1);
        Thread th1 = new Thread(new SaveToTxt());
        th1.start();
    }
    
    public int getSECONDS_OF_DAY() {
        return SECONDS_OF_DAY;
    }
    
    public int secondsLeft() {
        Calendar calendar = Calendar.getInstance();
        int left = (calendar.get(Calendar.HOUR_OF_DAY)*3600) + (calendar.get(Calendar.MINUTE)*60) + calendar.get(Calendar.SECOND);
        return SECONDS_OF_DAY - left;
    }
    
    private final int SECONDS_OF_DAY = 86400;
}
