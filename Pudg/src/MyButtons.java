

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;      

public class MyButtons{    
MyButtons(){    
JFrame f=new JFrame("Home Work 1");
JButton en,fr,ge,save,load;
JTextField Txt;
en=new JButton(new ImageIcon("images\\en.png"));
en.setBounds(220,50,60,40);
f.add(en);

fr=new JButton(new ImageIcon("images\\fr.png"));  
fr.setBounds(300,50,60,40);
f.add(fr);   

ge=new JButton(new ImageIcon("images\\ge.png"));
ge.setBounds(380,50,60,40);
f.add(ge);

save=new JButton("SAVE");
save.setBounds(200,300,100,40);
f.add(save);
load=new JButton("LOAD");
load.setBounds(350,300,100,40);
f.add(load);
JLabel pudge = new JLabel(new ImageIcon("images\\pudge.png"));
pudge.setBounds(10,80, 200,200);   
f.add(pudge);

Txt= new JTextField();
Txt.setBounds(220,120,220,150); 
f.add(Txt);
en.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
            Txt.setText("Text English");  
        }  
    });  

f.setSize(500,400);    
f.setLayout(null);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }         
public static void main(String[] args) {    
    new MyButtons();    
}
}