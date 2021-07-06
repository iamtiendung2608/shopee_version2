import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.jar.JarFile;
import java.io.*;
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
    static Item a=new Item();
    Font bigFont=new Font("serif",Font.BOLD,28);
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
        OutLabel.setFont(bigFont);
        Enter.addActionListener(new NameListener());

        name=new JTextField(10);
        name.setText("");
        name.requestFocus();
        name.setFont(bigFont);
        Male=new JCheckBox("Male");
        Male.setFont(bigFont);
        Female=new JCheckBox("Female");
        Female.setFont(bigFont);
        MyDrawImage image=new MyDrawImage();

        mainPanel.add(OutLabel);
        mainPanel.add(name);
        mainPanel.add(Male);
        mainPanel.add(Female);
        mainPanel.add(Enter);

        JMenuBar menu=new JMenuBar();
        JMenu fileMenu=new JMenu("File");
        JMenuItem MenuNew=new JMenuItem("New");
        MenuNew.addActionListener(new MenuNewListener());
        JMenuItem SaveMenu=new JMenuItem("Save");
        SaveMenu.addActionListener(new SaveMenuListener());
        fileMenu.add(MenuNew);
        fileMenu.add(SaveMenu);
        menu.add(fileMenu);


        frame.setJMenuBar(menu);
        frame.getContentPane().add(BorderLayout.NORTH,mainPanel);
        frame.getContentPane().add(image);
        frame.setSize(800,810);
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
            BBuy.setFont(bigFont);
            NBuy.setFont(bigFont);
            mainPanel.add(BBuy);
            mainPanel.add(NBuy);
            NBuy.addActionListener(new DontBuyListener());
            BBuy.addActionListener(new BuyListener());
            Num++;
            frame.repaint();
        }
    }
    class MyDrawImage extends JPanel{
        public void paintComponent(Graphics  g){
            Image image;
            if(Num==0){
                image=new ImageIcon("Shopee.jpg").getImage();
                g.drawImage(image, 0, 70, this);
            }
            if(Num==1){
                image=new ImageIcon("Apple.jpg").getImage();
                    g.drawImage(image, 0,70, this);
            }
            if(Num==2){
                image=new ImageIcon("banana.jpg").getImage();
                    g.drawImage(image, 0, 70, this);
            }
            if(Num==3){
                image=new ImageIcon("cherry.jpg").getImage();
                    g.drawImage(image, 0,70, this);
            }
            if(Num==4){
                image=new ImageIcon("StrawBerry.jpg").getImage();
                    g.drawImage(image, 0,70, this);
            }
            if(Num==5){
                image=new ImageIcon("vocado.jpg").getImage();
                g.drawImage(image, 0, 70, this);
            }
            if(Num>5){
                image=new ImageIcon("Thank.jpg").getImage();
                g.drawImage(image, 0, 70, this);
            }
        }
    }
    public class DontBuyListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            Num++;
            frame.repaint();
        }
    }
    public class BuyListener implements ActionListener{

        public void actionPerformed(ActionEvent ev){
            if(Num==1)
                a.getApple();
            if(Num==2)
                a.getBanana();
            if(Num==3)
                a.getCherry();
            if(Num==4)
                a.getStrawBerry();
            if(Num==5)
                a.getVocado();
            Num++;
            System.out.println(a.getPrice());
            frame.repaint();
        }
    }
    public class MenuNewListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            a.reset();
            Num=1;
            frame.repaint();
        }
    }
    public class SaveMenuListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            JFileChooser fileSave=new JFileChooser();
            fileSave.showSaveDialog(frame);
            SaveFile(fileSave.getSelectedFile());
        }
    }
    private void SaveFile(File file){
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
            for(String h:a.getList()){
                writer.write(h);
                writer.newLine();
            }
            writer.write("Total:    "+a.getPrice()+"vnd");
            writer.close();
        }
        catch(IOException ex){
            System.out.println("Can't Save this list");
            ex.printStackTrace();
        }
    }
}
