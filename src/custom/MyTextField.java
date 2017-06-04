package custom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JTextField;

import sun.java2d.pipe.DrawImage;

//自定义TextField标签

public class MyTextField extends JTextField{
	public MyTextField(){
		super();
		setEditable(true);
	}
	public MyTextField(String s){
		super(s);
	}
	public MyTextField(int type){
		super();
		init(type);
	}
	public void init(int type){
	}
	protected void paintComponent(Graphics G){
		Graphics2D g = (Graphics2D)G;
		int x = getBounds().x;
		int y = getBounds().y;
		int width = getBounds().width;
		int height = getBounds().height;
		Color c = getBackground();
		g.setColor(c);
		g.fillRoundRect(0, 0, width, height, 20, 20);
	}
//    public void paintBorder(Graphics g){
////      super.paintBorder(g);
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setColor(Color.gray);
//        g.drawOval(0, 0, super.getWidth() , super.getHeight());
//    }
}

