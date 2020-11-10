package UserInterface;

import static UserInterface.FieldsHandler.*;
import static UserInterface.TimeHandler.th;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class MainFrame extends JFrame {
    
    public MainFrame() {
        initComponents();
    }
    
    private void initComponents() {
        this.setTitle(TITLE_NON_ASTERISK);
        this.getContentPane().add(mainPanel, "North");
        this.getContentPane().setBackground(DARKER_GREY);
        mainPanel.setLayout(GRID_LAYOUT);
        mainPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setDefaultCloseOperation(3);
        this.setSize(500, 600);
        this.setJMenuBar(menuBar);
        int screenWidth = getScreenWidth();
        int screenHeight = getScreenHeight();
        int frameWidth = this.getSize().width;
        int frameHeight = this.getSize().height;
        setCenterLocation(screenWidth, frameWidth, screenHeight, frameHeight); 
        this.setResizable(true);
        windowsLookAndFeel();
        
        JMenu operations = menuBar.add(new JMenu("Operacje"));
//        JMenu enviroment = menuBar.add(new JMenu("Srodowisko"));
        operations.add(newTask = new JMenuItem("Nowe zadanie"));
//        enviroment.add(work = new JMenuItem("Praca"));
//        enviroment.add(home = new JMenuItem("Prywatne"));
//        work.setEnabled(false);
////        
//        work.addActionListener((ActionEvent arg0) -> {
//            mainPanel.removeAll();
//            mainPanel.setLayout(GRID_LAYOUT);
//            Thread threadSave = new Thread(new SaveToTxt());
//            threadSave.run();
//            executorService.submit(new SaveToTxt());
//            home.setEnabled(true);
//            whereAmI = "Work.txt";
//            Thread threadLoad = new Thread(new LoadFromTxt());
//            threadLoad.start();
//            executorService.submit(new LoadFromTxt());
//            work.setEnabled(false);
//        });
//        
//        home.addActionListener((ActionEvent arg0) -> {
//            mainPanel.removeAll();
//            mainPanel.setLayout(GRID_LAYOUT);
//            Thread threadSave = new Thread(new SaveToTxt());
//            threadSave.run();
//            executorService.submit(new SaveToTxt());
//            work.setEnabled(true);
//            whereAmI = "Home.txt";
//            Thread threadLoad = new Thread(new LoadFromTxt());
//            threadLoad.start();
//             executorService.submit(new LoadFromTxt());
//            home.setEnabled(false);
//        });
        
        
        
        newTask.addActionListener((ActionEvent e) -> {
            createAddTaskWindowAndUnableToCreateAnother();
        });
        
        this.addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowOpened(WindowEvent e) {
                TimerEvent t1 = new TimerEvent();
                ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);
                doLoadFromTxt();
                th.setToday(FieldsHandler.actualDay());
                th.setActualYear(getCurrentYear());
                scheduler.scheduleAtFixedRate(t1, t1.secondsLeft(), t1.getSECONDS_OF_DAY(), TimeUnit.SECONDS);
                checkIfDayIsDifferent();
            }

            private void doLoadFromTxt() {
                LoadFromTxt t2 = new LoadFromTxt();
                t2.run();
            }

            private void checkIfDayIsDifferent() {
                if(th.isDifferentDay()) {
                    checkIfYearIsDifferent();
                }
            }

            private void checkIfYearIsDifferent() {
                if(th.isDifferentYear()) {
                    int difference = calculateDifferenceBetweenDays();
                    FIELDS_HANDLER.refreshAndDisplayRefreshedList(difference);
                }
                else
                    FIELDS_HANDLER.refreshAndDisplayRefreshedList(th.calculateDifferenceBetweenDays());
            }
            
            @Override
            public void windowClosing(WindowEvent e) {
                SaveToTxt sTT = new SaveToTxt();
                sTT.run();
            }
            
            @Override
            public void windowIconified(WindowEvent e) {
                if(auxReferenceExists())
                    iconifyAuxWindow();
                if (changeNameReferenceExists())
                    iconifyChangeTaskWindow();
            }
            
            @Override
            public void windowDeiconified(WindowEvent e) {
                if(auxReferenceExists())
                    deiconifyAuxWindow();
                if(changeNameReferenceExists())
                    deiconifyChWindow();
            }
        });
        
        this.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyPressed(KeyEvent e) {
                if(CTRL_S(e)) {
                    doSave();
                    makeTitleNonAsterisk();
                }
            }

            private void doSave() {
                Thread t1 = new Thread(new SaveToTxt());
                t1.start();
            }
        });
        
        this.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if(rightMouseButton(e))
                    showPopUpMenu(e); 
            }
        });
        
        menuInPanel.add(new JMenuItem(new AbstractAction("Usun") {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItemFromList();
                sortList();
                setElements();
                appendAsteriskToTitle();
                changeNameButtonsHighlightOn();
                if(changeNameReferenceExists())
                    closeChangeNameWindow();
            }
        }));
        
        menuInPanel.add(new JMenuItem(chNAbstAct = new AbstractAction("Zmien nazwe") {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                createChangeTaskWindow();
            }
        }));
        
        menuOutsidePanel.add(new JMenuItem(addTaskAbstAct = new AbstractAction("Dodaj zadanie") {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAddTaskWindowAndUnableToCreateAnother();
            }
        }));
    };

    private void windowsLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static int getScreenHeight() throws HeadlessException {
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    private static int getScreenWidth() throws HeadlessException {
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    private void createChangeTaskWindow() {
        chReference = new ChangeTaskName();
        chReference.setVisible(true);
    }

    private void closeChangeNameWindow() {
        chReference.dispose();
    }

    private void sortList() {
        FieldsHandler.listSort();
    }

    private void removeItemFromList() {
        indexedList.remove(getMainLabelIndex()/2);
    }

    private void changeNameButtonsHighlightOn() {
        chNAbstAct.setEnabled(true);
    }

    private void showPopUpMenu(MouseEvent e) {
        menuOutsidePanel.show(e.getComponent(), e.getX(), e.getY());
    }

    private static boolean rightMouseButton(MouseEvent e) {
        return e.getButton() == MouseEvent.BUTTON3;
    }

    private void makeTitleNonAsterisk() {
        mainFrame.setTitle(TITLE_NON_ASTERISK);
    }

    private static boolean CTRL_S(KeyEvent e) {
        return e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S;
    }

    private void deiconifyChWindow() {
        chReference.setState(NORMAL);
    }

    private void deiconifyAuxWindow() {
        addTaskReference.setState(NORMAL);
    }

    private void iconifyChangeTaskWindow() {
        chReference.setState(ICONIFIED);
    }

    private void iconifyAuxWindow() {
        addTaskReference.setState(ICONIFIED);
    }

    private boolean changeNameReferenceExists() {
        return chReference != null;
    }

    private boolean auxReferenceExists() {
        return addTaskReference != null;
    }

    private int calculateDifferenceBetweenDays() {
        return FieldsHandler.isLeap(th.getPastYear()) ? (366 - th.getYesterday()) + th.getToday() : (365 - th.getYesterday()) + th.getToday();
    }
    
    public void setElements() {   
        mainPanel.removeAll();
        mainPanel.setLayout(GRID_LAYOUT);
        arrangeElementsInTable();
        mainPanel.revalidate();
        mainPanel.repaint();
        System.gc();
    }

    private void arrangeElementsInTable() {
        for (int i = 0; i < listSize(); i++) {
            int j = i*2;
            int k = j + 1;
            changeFieldColorDependingOnDaysLeft(i);
            
            mainPanel.add(lbFactory[j] = new LabelFactory("<html><b>"+getCurrentTask(i)+"</b></html>", j), BorderLayout.CENTER);
            mainPanel.add(lbFactory[k] = new LabelFactory("<html>Deadline: <b>"+getCurrentDate(i)+"</b><br/>Pozostało dni: <b>"
                    +getCurrentIndex(i)+"</b><br/>Numer zadania: <b>"+(i+1)+"</b></html>", k), BorderLayout.CENTER);
        }
    }

    private void changeFieldColorDependingOnDaysLeft(int i) {
        if(lessThan2Days(i))
            color = RED;
        else if(between2And4Days(i))
            color = ORANGE;
        else if(leftMoreThan4Days(i))
            color = GREEN;
    }
    
    private void createAddTaskWindowAndUnableToCreateAnother() {
        addTaskReference = new AddNewTaskWindow();
        addTaskReference.setVisible(true);
        addNewTaskButtonsHighlightOff();
        newTask.setEnabled(false);
    }

    private static boolean leftMoreThan4Days(int i) {
        return getCurrentIndex(i) > 4;
    }

    private static boolean between2And4Days(int i) {
        return getCurrentIndex(i) > 2 && getCurrentIndex(i) <= 4;
    }

    private static boolean lessThan2Days(int i) {
        return getCurrentIndex(i) <= 2;
    }
    
    private void addNewTaskButtonsHighlightOff() {
        addTaskAbstAct.setEnabled(false);
    }
    
    private void setCenterLocation(int screenWidth, int frameWidth, int screenHeight, int frameHeight) {
        this.setLocation((screenWidth - frameWidth)/2, (screenHeight - frameHeight)/2);
    }
    
    void appendAsteriskToTitle() {
        this.setTitle(TITLE_NON_ASTERISK+"*");
    }
    
    static int listSize() {
        return FieldsHandler.indexedList.size();
    }
    
    private static int getCurrentIndex(int i) {
        return FieldsHandler.getData(i).getIndex();
    }
    
    private static String getCurrentDate(int i) {
        return FieldsHandler.getData(i).getDate();
    }
    
    static String getCurrentTask(int i) {
        return FieldsHandler.getData(i).getTask();
    }

    private void setMainLabelIndex(int mainLabelIndex) {
        this.mainLabelIndex = mainLabelIndex;
    }

    public int getMainLabelIndex() {
        return mainLabelIndex;
    }
    
    private class LabelFactory extends JLabel
    {
        public LabelFactory(String name, int index)
        {
            super(name);
            this.setOpaque(true);
            this.setBackground(color);
            this.labelIndex = index;
            this.name = name;
            this.addMouseListener(new MouseAdapter() 
            {
                boolean isEven;
                @Override
                public void mouseEntered(MouseEvent e) { 
                    setMainLabelIndex(labelIndex);
                    colorToRestore = lbFactory[getMainLabelIndex()].getBackground();
                    if(getMainLabelIndex() % 2 == 0)
                    {
                        isEven = true;
                        lbFactory[getMainLabelIndex()].setBackground(GREY);
                        lbFactory[getMainLabelIndex()+1].setBackground(GREY);
                    }
                    else
                    {
                        isEven = false;
                        lbFactory[getMainLabelIndex()].setBackground(GREY);
                        lbFactory[getMainLabelIndex()-1].setBackground(GREY);
                    }
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                    if(isEven == true)
                    {
                        lbFactory[getMainLabelIndex()].setBackground(colorToRestore);
                        lbFactory[getMainLabelIndex()+1].setBackground(colorToRestore);
                    }
                    else
                    {
                        lbFactory[getMainLabelIndex()].setBackground(colorToRestore);
                        lbFactory[getMainLabelIndex()-1].setBackground(colorToRestore);
                    }
                }
                
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    recentlyClicked = getMainLabelIndex();
                    if(rightMouseButton(e)){
                        menuInPanel.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            });
        }
        
        public String getName() {
            return name;
        }
        
        public int getLabelIndex() {
            return labelIndex;
        }
        
        private int labelIndex;
        private String name;
    }
    
    String whereAmI = "Work.txt";
    int recentlyClicked;
    private final JLabel[] lbFactory = new LabelFactory[39];
    AbstractAction addTaskAbstAct, chNAbstAct;
    JMenuItem newTask, work, home;
    private int mainLabelIndex;
    private Color colorToRestore, color;
    private final Color RED = new Color(255, 102, 102);
    private final Color ORANGE = new Color(255, 172, 90);
    private final Color GREEN = new Color(174, 253, 93);
    private final Color GREY = new Color(230, 230, 230);
    private final Color DARKER_GREY = new Color(240, 240, 240);
    private final String TITLE_NON_ASTERISK = "Organizer v2.0";
    private final GridLayout GRID_LAYOUT = new GridLayout(listSize(), 2, 0, 2);
    private final FieldsHandler FIELDS_HANDLER = new FieldsHandler();
    static MainFrame mainFrame = new MainFrame();
    private AddNewTaskWindow addTaskReference;
    public ChangeTaskName chReference;
    private final JMenuBar menuBar = new JMenuBar();
    private final JPanel mainPanel = new JPanel();
    private final JPopupMenu menuInPanel = new JPopupMenu();
    private final JPopupMenu menuOutsidePanel = new JPopupMenu();
    
    public static void main(String[] args) {
        mainFrame.setVisible(true);
        
    } 
}
