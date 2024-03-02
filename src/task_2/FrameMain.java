package task_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static task_2.logic.fib1;
import static task_2.logic.listToString;

public class FrameMain extends JFrame{
    private JPanel panelMain;
    private JTextField textFieldValue;
    private JButton CreateListAndPrint;
    private JTextField textFieldResult;

    public FrameMain(){
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


        CreateListAndPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(textFieldValue.getText());
                String str;
                try {
                    str = String.valueOf(listToString(fib1(n)));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                textFieldResult.setText(" " + str);
            }
        });
    }
}
