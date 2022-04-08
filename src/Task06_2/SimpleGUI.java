package Task06_2;

// import java.awt.BorderLayout;
// import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.awt.Image;
// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JLayeredPane;
// import javax.swing.JPanel;
// import javax.swing.JTextArea;
// import javax.swing.JTextField;
// import javax.swing.JTextPane;

import java.awt.*;
import javax.swing.*;

public class SimpleGUI implements ActionListener {

    private JFrame frame;
    private JPanel southFlowPanel,northFlowPanel;
    private JLayeredPane jLayers;
    private int width, height;

    //North
    private JLabel fontInputLabel, sizeInputLabel;
    private String[] fonts = {"Arial","Bank Gothic","Bell MT","Courier New","Impact","Times New Roman"};
    private String[] sizes = {"5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","25","30","35","40"};
    private JComboBox fontInput, sizeInput;
    
    //Center
    private ImageIcon image;
    private JLabel imageLabel;
    private JLabel outputText;

    //South
    private JButton button, closeButton;
    private JTextField uInput;
    

    public SimpleGUI(int w, int h) {
        frame = new JFrame();
        width = w;
        height = h;
    }

    public void setUpGUI() {
        frame.setSize(width, height);
        frame.setTitle("Simple GUI");

        //=== LAYOUT SETUP ==========================================
        frame.setLayout(new BorderLayout(5,0));
        southFlowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10 ,5));
        northFlowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        jLayers = new JLayeredPane();
        frame.add(northFlowPanel, BorderLayout.NORTH);
        frame.add(southFlowPanel, BorderLayout.SOUTH);
        frame.add(jLayers, BorderLayout.CENTER);

        //=== NORTH =================================================
        fontInputLabel = new JLabel("Font:", SwingConstants.CENTER);
        northFlowPanel.add(fontInputLabel);
        
        fontInput = new JComboBox<>(fonts);
        northFlowPanel.add(fontInput);
        fontInput.addActionListener(this);

        sizeInputLabel = new JLabel("Font Size:", SwingConstants.CENTER);
        northFlowPanel.add(sizeInputLabel);

        sizeInput = new JComboBox<>(sizes);
        sizeInput.setSelectedIndex(6);
        northFlowPanel.add(sizeInput);
        sizeInput.addActionListener(this);

        //=== CENTER ================================================
        image = new ImageIcon("./resources/T06_bg.jpg");
        imageLabel = new JLabel(image);
        Dimension imageSize =  imageLabel.getPreferredSize();
        imageLabel.setBounds(0, 0, imageSize.width, imageSize.height);;
        jLayers.add(imageLabel, Integer.valueOf(0));

        outputText = new JLabel("Press Enter or Update button up update text :)", SwingConstants.CENTER);
        Dimension outputTextSize = outputText.getPreferredSize();
        outputText.setBounds(0, 0, width, outputTextSize.height);
        outputText.setFont(new Font("Arial", Font.BOLD, 11));
        jLayers.add(outputText, Integer.valueOf(1));

        //=== SOUTH =================================================
        uInput = new JTextField(20);
        southFlowPanel.add(uInput);
        uInput.addActionListener(this);

        button = new JButton("Update");
        southFlowPanel.add(button);
        button.addActionListener(this);

        closeButton = new JButton("Exit");
        southFlowPanel.add(closeButton);
        closeButton.addActionListener(this);

        //=== WINDOW ================================================
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() == button) || (e.getSource() == uInput)) {
            outputText.setText(uInput.getText());
            uInput.setText("");
        } else if (e.getSource() == closeButton) {
            System.exit(0);
        } else if ((e.getSource() == fontInput) || (e.getSource() == sizeInput)) {
            System.out.println(fontInput.getSelectedItem());
            System.out.println(sizeInput.getSelectedItem());
            String font = fontInput.getSelectedItem().toString();
            String size = sizeInput.getSelectedItem().toString();
            outputText.setFont(new Font(font, Font.BOLD, Integer.parseInt(size)));
            Dimension outputTextSize = outputText.getPreferredSize();
            outputText.setBounds(0, 0, width, outputTextSize.height);
            
        }
    }

}
