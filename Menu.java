import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;


public class Menu extends JPanel
{
	public JFrame menu;
	public ImageIcon picture;
	public JLabel pictureholder;
	public JButton start;
	
	public Menu (JFrame frame)
	{
		menu = frame;
		pictureholder= new JLabel(picture);
		picture = new ImageIcon("Title.png");
		
		menu.setVisible(true);
	}
}	
