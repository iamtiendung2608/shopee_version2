import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.jar.JarFile;

public class Shopee_Interface {
    JFrame frame;
    JTextField name;
    JCheckBox Male;
    JCheckBox Female;
    JButton Enter;
    JPanel mainPanel;
    JLabel OutLabel;
    public static void main(String[] args) {
        Shopee_Interface gui=new Shopee_Interface();
        gui.go();
    }
    void go(){
        frame=new JFrame("Shopee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel Label=new JLabel("Enter your name: ");
        mainPanel=new JPanel();
        Font bigFont=new Font("serif",Font.BOLD,24);
        Enter=new JButton("Click here");
        OutLabel=new JLabel("");
        Enter.addActionListener(new NameListener());

        name=new JTextField(10);
        name.setText("");
        name.requestFocus();
        // add listener
       
        Male=new JCheckBox("Male");
        Female=new JCheckBox("Female");
        // add listener
        mainPanel.add(Label);
        mainPanel.add(name);
        mainPanel.add(Male);
        mainPanel.add(Female);
        mainPanel.add(Enter);
        mainPanel.add(OutLabel);
        frame.getContentPane().add(mainPanel);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
    public class NameListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            if(Male.isSelected()){
                Male.setSelected(false);
                OutLabel.setText("Hello Mr."+name.getText()+" Welcome to shopee");
            }
            if(Female.isSelected()){
                Female.setSelected(false);  
                OutLabel.setText("Hello Mrs."+name.getText()+" Welcome to shopee");
            }              
        }
    }
}
