package custom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel extends JLabel{
	private ImageIcon icon;
	private int pointWidth = 0,pointHeight = 0;
	public MyLabel(){
		super();
		icon = (ImageIcon) super.getIcon();
	}
	public MyLabel(String s){
		super(s);
	}
	public MyLabel(String s,int width,int height){
		super(s);
		pointWidth = width;
		pointHeight = height;
	}
	public void setIcon(ImageIcon i){
		super.setIcon(i);
	}
	protected void paintComponent(Graphics G){
		Graphics2D g = (Graphics2D)G;
		int x = getBounds().x;
		int y = getBounds().y;
		int width = getBounds().width;
		int height = getBounds().height;
		Color c = getBackground();
		g.setColor(c);
		g.fillRoundRect(0, 0, width, height, pointWidth, pointHeight);
		setIcon(icon);
	};
}