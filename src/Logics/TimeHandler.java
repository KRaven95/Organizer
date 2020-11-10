package Logics;

public class TimeHandler {
    
    public int getToday() {
        return today;
    }

    public int getYesterday() {
        return yesterday;
    }

    public int getActualYear() {
        return actualYear;
    }

    public int getPastYear() {
        return pastYear;
    }
    
    public void setToday(int today) {
        this.today = today;
    }

    public void setYesterday(Integer yesterday) {
        this.yesterday = yesterday;
    }

    public void setActualYear(Integer actualYear) {
        this.actualYear = actualYear;
    }

    public void setPastYear(int pastYear) {
        this.pastYear = pastYear;
    }
    
    public boolean isDifferentDay() {
        return getToday() != getYesterday() ? true : false;
    }
    
    public boolean isDifferentYear() {
        return getActualYear()!= getPastYear()? true : false;
    }
    
    public int calculateDifferenceBetweenDays() {
        return getToday() - getYesterday();
    }
    public static TimeHandler timeHandler = new TimeHandler();
    private int today;
    private int yesterday;
    private int actualYear;
    private int pastYear;
}
