/*
 * Vaishnav Varma
 * Roll No : 2110110574
 * CSE '25
 */

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;
import javax.swing.*;

class Text_Editor extends JFrame implements ActionListener,AdjustmentListener {
    JTextArea t;
    JFrame f;
    JScrollPane scroll ;

    Text_Editor() {
        t=new JTextArea();
        f=new JFrame("Text Editor - Vaishnav Varma - 2110110574");
        

        //Menu bar
        JMenuBar mb=new JMenuBar();

        //File menu
        JMenu m1=new JMenu("File");

        JMenuItem m1a=new JMenuItem("New");
        JMenuItem m1b=new JMenuItem("Open");
        JMenuItem m1c=new JMenuItem("Save");
        JMenuItem m1d=new JMenuItem("Print");

        m1a.addActionListener(this);
        m1b.addActionListener(this);
        m1c.addActionListener(this);
        m1d.addActionListener(this);
        m1.add(m1a);
        m1.add(m1b);
        m1.add(m1c);
        m1.add(m1d);

        //Edit Menu
        JMenu m2=new JMenu("Edit");

        JMenuItem m2a=new JMenuItem("Cut");
        JMenuItem m2b=new JMenuItem("Copy");
        JMenuItem m2c=new JMenuItem("Paste");

        m2a.addActionListener(this);
        m2b.addActionListener(this);
        m2c.addActionListener(this);
        m2.add(m2a);
        m2.add(m2b);
        m2.add(m2c);

        //Font Menu
        JMenu m3=new JMenu("Fonts");

        JMenuItem m3a=new JMenuItem("Comic Sans MS");
        JMenuItem m3b=new JMenuItem("Agency FB");
        JMenuItem m3c=new JMenuItem("SansSerif");
        JMenuItem m3d=new JMenuItem("Arial");
        JMenuItem m3e=new JMenuItem("Georgia");
        JMenuItem m3f=new JMenuItem("Times New Roman");

        m3a.addActionListener(this);
        m3b.addActionListener(this);
        m3c.addActionListener(this);
        m3.add(m3a);
        m3.add(m3b);
        m3.add(m3c);
        m3.add(m3d);
        m3.add(m3e);
        m3.add(m3f);

        //Find and Replace Menu
        JMenu m4=new JMenu("Find & Replace");

        JMenuItem m4a=new JMenuItem("Find");
        JMenuItem m4b=new JMenuItem("Replace");
        
        m4a.addActionListener(this);
        m4b.addActionListener(this);
        m4.add(m4a);
        m4.add(m4b);
     
        //Count number of words and characters
        JMenu m5=new JMenu("Count");

        JMenuItem m5a=new JMenuItem("Words");
        JMenuItem m5b=new JMenuItem("Characters");

        m5a.addActionListener(this);
        m5b.addActionListener(this);
        m5.add(m5a);
        m5.add(m5b);

        //Close option
        JMenuItem mc=new JMenuItem("Close");

        mc.addActionListener(this);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        mb.add(m5);
        mb.add(mc);

        f.setJMenuBar(mb);

        f.add(t);

        f.setVisible(true);

        scroll = new JScrollPane(t);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        f.add(scroll);

        //Scroll bar size
        scroll.setSize(20,500);

        //Frame size
        f.setSize(500,500);

        //Text size
        t.setSize(400,500);
		
	//Close 
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void adjustmentValueChanged(AdjustmentEvent e) {}
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();

        //For Edit Menu functions
        if(s.equals("Copy"))
        {
            t.copy();
        }
        else if(s.equals("Cut"))
        {
            t.cut();
        }
        else if(s.equals("Paste"))
        {
            try
            {
                t.paste();
            }
            catch (Exception evt)
            {
                JOptionPane.showMessageDialog(f, evt.getMessage());
            }
        }
        //For File Menu functions
        else if(s.equals("Print"))
        {
            try
            {
                t.print();  
            }
            catch(Exception e) {}
        }
        else if(s.equals("Open"))
        {
            JFileChooser fileopener = new JFileChooser("f:");
            int r = fileopener.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION)
            {
                File fileo = new File(fileopener.getSelectedFile().getAbsolutePath());
                try
                {
                    String s1 = "",s2="";
                    FileReader fr = new FileReader(fileo);
                    BufferedReader br = new BufferedReader(fr);
                    s2=br.readLine();
                    while ((s1 = br.readLine()) != null)
                    {
                        s2 = s2 + "\n" + s1;
                    }
                    t.setText(s2);
                }
                catch (Exception evt)
                {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
        }
        else if(s.equals("Save"))
        {
            JFileChooser filesaver = new JFileChooser("f:");
            int r = filesaver.showSaveDialog(null); 
            if (r == JFileChooser.APPROVE_OPTION)
            {
                File files = new File(filesaver.getSelectedFile().getAbsolutePath());
                try
                {
                    FileWriter wr=new FileWriter(files, false);
                    BufferedWriter w=new BufferedWriter(wr);
                    w.write(t.getText());
                    w.flush();
                    w.close();
                }
                catch (Exception evt)
                {
                    JOptionPane.showMessageDialog(f,evt.getMessage());
                }
            }
        }
        else if (s.equals("Print"))
        {
            try
            {
                t.print();
            }
            catch (Exception evt)
            {
                JOptionPane.showMessageDialog(f,evt.getMessage());
            }
        }

        else if(s.equals("New"))
        {
            t.setText("");
        }
       
        //For Font Menu functions
        else if(s.equals("Comic Sans MS"))
        {
            Font fo = new Font("Comic Sans MS",Font.PLAIN,16);
            t.setFont(fo);
        }
        else if(s.equals("Agency FB"))
        {
            Font fo = new Font("Agency FB",Font.PLAIN,16);
            t.setFont(fo);
        }
        else if(s.equals("Arial"))
        {
            Font fo = new Font("Arial",Font.PLAIN,16);
            t.setFont(fo);
        }
        else if(s.equals("SansSerif"))
        {
            Font fo = new Font("SansSerif",Font.PLAIN,16);
            t.setFont(fo);
        }
        else if(s.equals("Georgia"))
        {
            Font fo = new Font("Georgia",Font.PLAIN,16);
            t.setFont(fo);
        }
        else if(s.equals("Times New Roman"))
        {
            Font fo = new Font("Times New Roman",Font.PLAIN,16);
            t.setFont(fo);
        }

         //For Close option
         else if(s.equals("Close"))
         {
             f.setVisible(false);
             System.exit(0);
         }

        //For Find and Replace Menu functions
            else if(s.equals("Find"))
            {
                String s1=JOptionPane.showInputDialog(f,"Find");
                String s2=t.getText();
                int i=0;
                if((i=s2.indexOf(s1,i))>=0)
                {
                    t.select(i,i+s1.length());
                }
            }
            else if(s.equals("Replace"))
            {
                String s1=JOptionPane.showInputDialog(f,"Find");
                String s2=JOptionPane.showInputDialog(f,"Replace");
                String s3=t.getText();
                int i=0;
                if((i=s3.indexOf(s1,i))>=0)
                {
                    t.replaceRange(s2,i,i+s1.length());
                }
            }

            //For Find and Replace Menu functions
            else if(s.equals("Find"))
            {
                String s1=JOptionPane.showInputDialog(f,"Find");
                String s2=t.getText();
                int i=0;
                if((i=s2.indexOf(s1,i))>=0)
                {
                    t.select(i,i+s1.length());
                }
            }
            else if(s.equals("Replace"))
            {
                String s1=JOptionPane.showInputDialog(f,"Find");
                String s2=JOptionPane.showInputDialog(f,"Replace");
                String s3=t.getText();
                int i=0;
                if((i=s3.indexOf(s1,i))>=0)
                {
                    t.replaceRange(s2,i,i+s1.length());
                }
            }  
            //For counting number of words
            else if(s.equals("Words"))
            {
                String s1=t.getText();
                String s2[]=s1.split(" ");
                JOptionPane.showMessageDialog(f,"No.of words="+s2.length);
            }
            //For counting number of characters
            else if(s.equals("Characters"))
            {
                String s1=t.getText();
                String s2[]=s1.split("");
                JOptionPane.showMessageDialog(f,"No.of Characters="+s2.length);
            }
    }

    //Main
    public static void main(String args[])
    {
        Text_Editor o=new Text_Editor();
    }
}
