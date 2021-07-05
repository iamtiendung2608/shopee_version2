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
    JButton Buy;
    static int Num=0;
    public static void main(String[] args) {
        Shopee_Interface gui=new Shopee_Interface();
        gui.go();
    }
    void go(){
        frame=new JFrame("Shopee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel=new JPanel();
        Enter=new JButton("Click here");
        OutLabel=new JLabel("Enter your name: ");
        Enter.addActionListener(new NameListener());

        name=new JTextField(5);
        name.setText("");
        name.requestFocus();
        Male=new JCheckBox("Male");
        Female=new JCheckBox("Female");
        MyDrawImage image=new MyDrawImage();

        mainPanel.add(name);
        mainPanel.add(Male);
        mainPanel.add(Female);
        mainPanel.add(Enter);
        mainPanel.add(OutLabel);
        frame.getContentPane().add(BorderLayout.NORTH,mainPanel);
        frame.getContentPane().add(image);
        frame.setSize(800,800);
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
            name.setVisible(false);
            Male.setVisible(false);
            Female.setVisible(false);
            Enter.setVisible(false);
            Buy=new JButton("Start Shopping");
            mainPanel.add(Buy);
            Buy.addActionListener(new BuyingListener());
        }
    }
    public class BuyingListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            Buy.setVisible(false);
            JButton BBuy=new JButton("Buy");
            JButton NBuy=new JButton("Don't Buy");
            mainPanel.add(BBuy);
            mainPanel.add(NBuy);
        }
    }

    class MyDrawImage extends JPanel{
        public void paintComponent(Graphics  g){
            Image image;
            if(Num==0){
                image=new ImageIcon("Shopee.jpg").getImage();
                g.drawImage(image, 0, 100, this);
            }
            if(Num==1){
                image=new ImageIcon("cherry.jpg").getImage();
                    g.drawImage(image, 3, 4, this);
            }
            if(Num==2){
                image=new ImageIcon("cherry.jpg").getImage();
                    g.drawImage(image, 3, 4, this);
            }
            if(Num==3){
                image=new ImageIcon("cherry.jpg").getImage();
                    g.drawImage(image, 3,4, this);
            }
            if(Num==4){
                image=new ImageIcon("cherry.jpg").getImage();
                    g.drawImage(image, 3,4, this);
            }
        }
    }
}
