package UserInterface;

import static UserInterface.MainFrame.*;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddNewTaskWindow extends JFrame {

    public AddNewTaskWindow() 
    {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        taskField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        taskNameLabel = new javax.swing.JLabel();
        dateFormatLabel = new javax.swing.JLabel();
        passButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        datePanel = new javax.swing.JPanel();
        comboBoxYear = new javax.swing.JComboBox<>();
        comboBoxDay = new javax.swing.JComboBox<>();
        comboBoxMonth = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Wpisz zadanie");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        taskNameLabel.setText("Treść zadania");

        dateFormatLabel.setText("DD/MM/YYYY");

        passButton.setText("Przekaż");
        passButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passButtonActionPerformed(evt);
            }
        });

        returnButton.setText("<<Wróć");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datePanelLayout = new javax.swing.GroupLayout(datePanel);
        datePanel.setLayout(datePanelLayout);
        datePanelLayout.setHorizontalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        datePanelLayout.setVerticalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        comboBoxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100", " " }));
        comboBoxYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboBoxYearFocusGained(evt);
            }
        });
        comboBoxYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comboBoxYearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comboBoxYearMouseExited(evt);
            }
        });

        comboBoxDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        comboBoxDay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboBoxDayFocusGained(evt);
            }
        });
        comboBoxDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comboBoxDayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comboBoxDayMouseExited(evt);
            }
        });
        comboBoxDay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboBoxDayKeyPressed(evt);
            }
        });

        comboBoxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Styczeń (1)", "Luty (2)", "Marzec (3)", "Kwiecień (4)", "Maj (5)", "Czerwiec (6)", "Lipiec (7)", "Sierpień (8)", "Wrzesień (9)", "Październik (10)", "Listopad (11)", "Grudzień (12)" }));
        comboBoxMonth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboBoxMonthFocusGained(evt);
            }
        });
        comboBoxMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comboBoxMonthMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comboBoxMonthMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(taskField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(dateFormatLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(datePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(returnButton)))
                .addGap(4, 4, 4))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(taskNameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(taskNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taskField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateFormatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        enableToDisplayAddTaskWindow();
    }//GEN-LAST:event_formWindowClosing

    private void enableToDisplayAddTaskWindow() {
        addTaskButtonHighlightOn();
        anotherAddTaskButtonHighlightOn();
        closeAddTaskWindow();
    }

    private void closeAddTaskWindow() {
        this.dispose();
    }

    private void anotherAddTaskButtonHighlightOn() {
        mainFrame.newTask.setEnabled(true);
    }

    private void addTaskButtonHighlightOn() {
        mainFrame.addTaskAbstAct.setEnabled(true);
    }

    private void passButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passButtonActionPerformed
        saveDate();
        if(calculateLeftDays() < 0)
            wrongDateMessage();
        else if(fieldText().isBlank())
            textLackMessage();
        else if(february() && equals29Days() && yearIsntLeap() || february() && moreThan29Days() || april() && moreThan30Days() || june() && moreThan30Days() || september() && moreThan30Days() || november() && moreThan30Days())
            dateDoesntExistsMessage();
        else {
            putDataIntoList();
            sortList();
            cleanTaskField();
            displayData();
            mainFrame.appendAsteriskToTitle();
        }
    }//GEN-LAST:event_passButtonActionPerformed

    private void dateDoesntExistsMessage() throws HeadlessException {
        JOptionPane.showMessageDialog(rootPane, "Taka data nie istnieje");
    }

    private boolean november() {
        return getMonth() == 11;
    }

    private boolean september() {
        return getMonth() == 9;
    }

    private boolean june() {
        return getMonth() == 6;
    }

    private boolean moreThan30Days() {
        return getDay() > 30;
    }

    private boolean april() {
        return getMonth() == 4;
    }

    private boolean yearIsntLeap() {
        return !FieldsHandler.isLeap(getYear());
    }

    private boolean moreThan29Days() {
        return getDay() > 29;
    }

    private boolean equals29Days() {
        return getDay() == 29;
    }

    private boolean february() {
        return getMonth() == 2;
    }

    private void textLackMessage() throws HeadlessException {
        JOptionPane.showMessageDialog(rootPane, "Prosze wpisac tekst");
    }

    private void wrongDateMessage() throws HeadlessException {
        JOptionPane.showMessageDialog(rootPane, "Wprowadzono date wstecz!");
    }
    
    private void sortList() {
        FieldsHandler.listSort();
    }
    
    public void displayData() {
        mainFrame.setElements();
    }
    private void putDataIntoList() {
        FieldsHandler.addToList(fieldText(), formatDate(day, month, year), calculateLeftDays());
    }
    private void cleanTaskField() {
        taskField.setText("");
    }
    private int calculateLeftDays() {
        return FieldsHandler.selectedDays(day, month, year, numOfDays) - FieldsHandler.actualDay();
    }
    private String fieldText() 
    {
        return taskField.getText();
    }
    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
       
    }//GEN-LAST:event_formAncestorResized

    private void comboBoxDayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboBoxDayKeyPressed

    }//GEN-LAST:event_comboBoxDayKeyPressed

    private void comboBoxDayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboBoxDayFocusGained
        comboBoxDay.showPopup();
    }//GEN-LAST:event_comboBoxDayFocusGained

    private void comboBoxDayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxDayMouseEntered
        comboBoxDay.showPopup();
    }//GEN-LAST:event_comboBoxDayMouseEntered

    private void comboBoxDayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxDayMouseExited
        if(isMouseClicked == true){
            comboBoxDay.hidePopup();
            isMouseClicked = false;
        }
    }//GEN-LAST:event_comboBoxDayMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        isMouseClicked = true;
    }//GEN-LAST:event_formMouseClicked

    private void comboBoxMonthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxMonthMouseEntered
        comboBoxMonth.showPopup();
    }//GEN-LAST:event_comboBoxMonthMouseEntered

    private void comboBoxMonthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxMonthMouseExited
        if(isMouseClicked == true){
            comboBoxMonth.hidePopup();
            isMouseClicked = false;
        }
    }//GEN-LAST:event_comboBoxMonthMouseExited

    private void comboBoxMonthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboBoxMonthFocusGained
        comboBoxMonth.showPopup();
    }//GEN-LAST:event_comboBoxMonthFocusGained

    private void comboBoxYearFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboBoxYearFocusGained
        comboBoxYear.showPopup();
    }//GEN-LAST:event_comboBoxYearFocusGained

    private void comboBoxYearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxYearMouseEntered
        comboBoxYear.showPopup();
    }//GEN-LAST:event_comboBoxYearMouseEntered

    private void comboBoxYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxYearMouseExited
        if(isMouseClicked == true){
            comboBoxYear.hidePopup();
            isMouseClicked = false;
        }        
    }//GEN-LAST:event_comboBoxYearMouseExited

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        enableToDisplayAddTaskWindow();
    }//GEN-LAST:event_returnButtonActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE)
            enableToDisplayAddTaskWindow();
    }//GEN-LAST:event_formKeyPressed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        
    }//GEN-LAST:event_formPropertyChange
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewTaskWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewTaskWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewTaskWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewTaskWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddNewTaskWindow().setVisible(true);
        });
    }
    private void saveDate()
    {
        changeDayToInts(comboBoxDay.getSelectedItem());
        changeMonthToInts(comboBoxMonth.getSelectedItem());
        changeYearToInts(comboBoxYear.getSelectedItem());
    }
    private void changeDayToInts(Object day)
    {
        String dzień = (String)day;
        this.day = Integer.parseInt(dzień);
    }
    private void changeMonthToInts(Object month)
    {
        String miesiąc = (String)month;
        switch (miesiąc){
            case "Styczeń (1)": this.month = 1; this.numOfDays = 0; break;
            case "Luty (2)": this.month = 2; this.numOfDays = 31; break;
            case "Marzec (3)": this.month = 3; this.numOfDays = 59; break;
            case "Kwiecień (4)": this.month = 4; this.numOfDays = 90; break;
            case "Maj (5)": this.month = 5; this.numOfDays = 120; break;
            case "Czerwiec (6)": this.month = 6; this.numOfDays = 151; break;
            case "Lipiec (7)": this.month = 7; this.numOfDays = 181; break;
            case "Sierpień (8)": this.month = 8; this.numOfDays = 212; break;
            case "Wrzesień (9)": this.month = 9; this.numOfDays = 243; break;
            case "Październik (10)": this.month = 10; this.numOfDays = 273; break;
            case "Listopad (11)": this.month = 11; this.numOfDays = 304; break;
            case "Grudzień (12)": this.month = 12; this.numOfDays = 334; break;
        }
    }
    private String formatDate(int day, int month, int year)
    {
        String preDay = String.valueOf(day);
        String preMonth = String.valueOf(month);
        preDay = day < 10 ? "0" + preDay: preDay;
        preMonth = month < 10 ? "0" + preMonth: preMonth;
        return preDay+"/"+preMonth+"/"+year;
    }
    private void changeYearToInts(Object year)
    {
        String rok = year.toString();
        this.year = Integer.parseInt(rok);
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    
    private boolean isMouseClicked;
    private int day;
    private int month;
    private int year;
    private int numOfDays;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxDay;
    private javax.swing.JComboBox<String> comboBoxMonth;
    private javax.swing.JComboBox<String> comboBoxYear;
    private javax.swing.JLabel dateFormatLabel;
    private javax.swing.JPanel datePanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton passButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField taskField;
    private javax.swing.JLabel taskNameLabel;
    // End of variables declaration//GEN-END:variables
}
