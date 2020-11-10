package DataAccess;

import Logics.FieldsHandler;
import static UserInterface.LeadingFrame.mainFrame;
import java.io.*;
import java.util.StringTokenizer;
import static Logics.TimeHandler.timeHandler;

public class LoadFromTxt implements Runnable{

    @Override
    public synchronized void run() {
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(new File(System.getProperty("user.home"), mainFrame.whereAmI)));
            int lines = Integer.parseInt(bReader.readLine());
            String line;
            StringTokenizer tokeny = null;
            for(int i = 0; i < lines; i++ ) {
                line = bReader.readLine();
                tokeny = new StringTokenizer(line, "|");
                String tmpTask = tokeny.nextToken();
                String tmpDate = tokeny.nextToken();
                int tmpIndex = Integer.parseInt(tokeny.nextToken());
                FieldsHandler.addToList(tmpTask, tmpDate, tmpIndex);  
            }
            
            bReader.close();
            BufferedReader timeReader = new BufferedReader(new FileReader(new File(System.getProperty("user.home"), "Time.txt")));
            timeHandler.setYesterday(Integer.parseInt(timeReader.readLine()));
            timeHandler.setPastYear(Integer.parseInt(timeReader.readLine()));
            timeReader.close();
            mainFrame.setElements();
            System.gc();
        } 
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
