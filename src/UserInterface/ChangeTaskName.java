package UserInterface;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import static UserInterface.MainFrame.*;

public final class ChangeTaskName extends JFrame {
    
    public ChangeTaskName() {
        initComponents();
    }
    void initComponents() {
        this.setTitle("Zmień nazwę zadania");
        this.setBounds(new Rectangle(300, 300, 350, 100));
        this.setLayout(gLayout);
        this.getContentPane().add(tField);
        this.getContentPane().add(bChange);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.chNAbstAct.setEnabled(true);
                dispose();
            }
            
            @Override
            public void windowOpened(WindowEvent e) {
                mainFrame.chNAbstAct.setEnabled(false);
            }
        });
        
        tField.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(tField.getText().isBlank())
                        JOptionPane.showMessageDialog(rootPane, "Prosze wpisac tekst");
                    else 
                        bChange.doClick();
                }
            }    
        });
        
        bChange.addActionListener((ActionEvent arg0) -> {
            if(mainFrame.recentlyClicked%2 == 0) {
                FieldsHandler.getData(mainFrame.recentlyClicked/2).setTask(tField.getText());
                tField.setText("");
            }
            else if(tField.getText().isBlank()) {
                JOptionPane.showMessageDialog(rootPane, "Prosze wpisac tekst");
            }
            else if(mainFrame.recentlyClicked%2 != 0) {
                FieldsHandler.getData((mainFrame.recentlyClicked-1)/2).setTask(tField.getText());
                tField.setText("");
            }
            mainFrame.setElements();
            mainFrame.appendAsteriskToTitle();
        });
    }
    private final GridLayout gLayout = new GridLayout(2, 1);
    private final JTextField tField = new JTextField();
    private final JButton bChange = new JButton("Ok");
}
