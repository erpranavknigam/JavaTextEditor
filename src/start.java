/**
 * @author Pranavkant Nigam
 * <h1>Text Editor</h1>
 * Date: 07/07/2021
 * **/

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.io.*;
import javax.swing.plaf.metal.*;



@SuppressWarnings("serial")
class start extends JFrame implements ActionListener {
	
	JTextArea t;
	JFrame f;
	
	@SuppressWarnings("deprecation")
	start(){
		f = new JFrame("Text Editor");
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
			
		} catch (Exception e) {}
			t = new JTextArea();
			
			JMenuBar mb = new JMenuBar();
			
			JMenu m1 = new JMenu("File");
			JMenuItem mi1 = new JMenuItem("New");
			JMenuItem mi2 = new JMenuItem("Open");
			JMenuItem mi3 = new JMenuItem("Save");
			JMenuItem mi4 = new JMenuItem("Close");
			
			mi1.addActionListener(this);
			mi2.addActionListener(this);
			mi3.addActionListener(this);
			mi4.addActionListener(this);
		
			m1.add(mi1);
			m1.add(mi2);
			m1.add(mi3);
			m1.add(mi4);
			
			JMenu m2 = new JMenu("Edit");
			JMenuItem mi6 = new JMenuItem("Cut");
			JMenuItem mi7 = new JMenuItem("Copy");
			JMenuItem mi8 = new JMenuItem("Paste");
			
			mi6.addActionListener(this);
			mi7.addActionListener(this);
			mi8.addActionListener(this);
			
			m2.add(mi6);
			m2.add(mi7);
			m2.add(mi8);
			
			JMenu m3 = new JMenu("About");
			JMenuItem mi9 = new JMenuItem("About Developer");
			JMenuItem mi10 = new JMenuItem("About Project");
			mi9.addActionListener(this);
			mi10.addActionListener(this);
			
			m3.add(mi9);
			m3.add(mi10);
			
			
			
			mb.add(m1);
			mb.add(m2);
			mb.add(m3);
			
			Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
			mb.setCursor(cursor);
			
			f.setJMenuBar(mb);
			f.add(t);
			f.setSize(1000,1000);
			f.show();
			
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Cut")) {
			t.cut();
		}
		else if(s.equals("Copy")) {
			t.copy();
		}
		else if(s.equals("Paste")) {
			t.paste();
		}
		else if(s.equals("Save")) {
			JFileChooser j = new JFileChooser("f: ");
			int r = j.showSaveDialog(null);
			
			if(r == JFileChooser.APPROVE_OPTION) {
				File fi = new File(j.getSelectedFile().getAbsolutePath());
				
				try {
					FileWriter wr = new FileWriter(fi, false);
					
					BufferedWriter w = new BufferedWriter(wr);
					
					w.write(t.getText());
					
					w.flush();
					w.close();
				} catch(Exception evt) {
					JOptionPane.showMessageDialog(f, evt.getMessage());
				}
			}
			else {
				JOptionPane.showMessageDialog(f, "User Cancelled the operation.");
			}
		}
		else if(s.equals("About Developer")) {
			JOptionPane.showMessageDialog(f, "Hi I am Pranavkant Nigam developer of this Text Editor. \n"
					+ "This is my First GUI based Java Project. \n"
					+ "For the source code please check out my github page (github id: erpranavknigam).");
		}
		else if(s.equals("About Project")) {
			JOptionPane.showMessageDialog(f, "This is a Java Based Project, \n"
					+ "developed for purpose of text editing. \n"
					+ "We will be adding new features soon.");
		} else if(s.equals("New")) {
			t.setText(" ");
		} else if(s.equals("Close")) {
			int str = JOptionPane.showConfirmDialog(t, "Do you want to exit.");
			if(str == 1) {
				f.setVisible(true);
			} 
			 else {
				f.setVisible(false);
			}
		}
		
	}
public static void main(String[] args) {
		start s = new start();

	}


}
