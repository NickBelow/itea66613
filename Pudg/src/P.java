import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;   
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;


public class P{ 
	Setting setting;
P(){    

JFrame f=new JFrame("Home-1");            
JButton b=new JButton(new ImageIcon("image\\FLAG1.png"));    
b.setBounds(370,30,50, 40);    
f.add(b);    
 
JButton b2=new JButton(new ImageIcon("image\\FLAG2.png")); 
b2.setBounds(310,30,50, 40);    
f.add(b2);      

JButton b3=new JButton(new ImageIcon("image\\FLAG3.png")); 
b3.setBounds(250,30,50, 40);    
f.add(b3);    

JLabel pudg = new JLabel(new ImageIcon("image\\pudg.png"));
pudg.setBounds(10,80, 200,200);   
f.add(pudg);
f.setSize(500,400);    

JButton save=new JButton("SAVE");
save.setBounds(250,300,100,40);
f.add(save);
JButton load=new JButton("LOAD");
load.setBounds(360,300,100,40);
f.add(load);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

JTextField T1 = new JTextField();
T1.setBounds(230, 120, 200, 30);
f.add(T1);

JTextField T2 = new JTextField();
T2.setBounds(230, 150, 200, 30);
f.add(T2);


JTextField T3 = new JTextField();
T3.setBounds(230, 180, 200, 30);
f.add(T3);


b3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {

	Locale locale = new Locale("en", "GB");
	setting = new Setting("en", "GB");
	ResourceBundle bundle=
	ResourceBundle.getBundle("MessageBundle",locale);
	T3.setText(bundle.getString("name3"));	
	T2.setText(bundle.getString("name2"));		
	T1.setText(bundle.getString("name"));		
		}
	});


b2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {

	Locale locale = new Locale("ge", "GE");
	setting = new Setting("ge", "GE");
	ResourceBundle bundle=
	ResourceBundle.getBundle("MessageBundle",locale);
	T3.setText(bundle.getString("name3"));	
	T2.setText(bundle.getString("name2"));		
	T1.setText(bundle.getString("name"));		
		}
	});
	
b.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {

	Locale locale = new Locale("fr", "FR");
	setting = new Setting("fr", "FR");
	ResourceBundle bundle=
	ResourceBundle.getBundle("MessageBundle",locale);
	T3.setText(bundle.getString("name3"));	
	T2.setText(bundle.getString("name2"));		
	T1.setText(bundle.getString("name"));		
		}
	});



load.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e) 
  {
  try(DataInputStream dos=new DataInputStream(new FileInputStream("pudge.bin"));){
    Setting settingCopy=new Setting(dos.readUTF(), dos.readUTF());
    Locale locale = new Locale(settingCopy.getLanguage(), settingCopy.getCountry());
    ResourceBundle bundle=
    ResourceBundle.getBundle("MessageBundle",locale);
    T1.setText(bundle.getString("name"));
    T2.setText(bundle.getString("name2"));
    T3.setText(bundle.getString("name3"));
 
  }catch(Exception ex) {
    ex.printStackTrace();
  }
  }
});

save.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e) 
  {
  try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("pudge.bin"));){
    dos.writeUTF(setting.getLanguage());
    dos.writeUTF(setting.getCountry());
  }catch(Exception ex) {
    ex.printStackTrace();
  }
  }    
});


save.setBackground(Color.GREEN);
load.setBackground(Color.GREEN);

f.setSize(500,400);    
f.setLayout(null);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }         
public static void main(String[] args) {    
    new P();    
    
	
}    
}    