package task_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static task_3.LogicTask3.*;

public class FrameMain extends JFrame{
    private JTextField textFieldInQueue;
    private JButton OutQueueButton;
    private JTextField textFieldAnswer;
    private JPanel PanelMain;

    public FrameMain(){
        this.setTitle("FrameMain");
        this.setContentPane(PanelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


        OutQueueButton.addActionListener(e -> {
            String str = textFieldInQueue.getText();
           SimpleQueue<String> que;
            try {
                que = logic(str); //очередь почему-то остается пустой
                str = outQueueToString(que);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            textFieldAnswer.setText(str);
        });
    }
}
