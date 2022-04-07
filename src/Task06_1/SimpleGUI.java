package Task06_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGUI implements ActionListener {

    private JFrame frame;
    private int width, height;
    private JButton button;
    

    public SimpleGUI(int w, int h) {
        frame = new JFrame();
        width = w;
        height = h;
    }

    public void setUpGUI() {
        frame.setSize(width, height);
        frame.setTitle("Simple GUI");
        button = new JButton("Update");
        frame.add(button);
        button.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button Clicked");
        
    }



}
