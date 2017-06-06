package index;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

import com.sun.org.apache.bcel.internal.generic.JsrInstruction;

import sun.security.util.Debug;

import custom.*;
import entity.*;

public class Frame extends JFrame{
	/**
	 * @param args
	 */
	private int xOld;
	private int yOld;
	Scenic[] scenics = {new Scenic("00000001","泰山","img/scenicindex/taishan.jpg"),
			new Scenic("00000001","黄山","img/scenicindex/huangshan.jpg"),
			new Scenic("00000001","欢乐谷","img/scenicindex/huanlegu.jpg"),
			new Scenic("00000001","泰山","img/scenicindex/taishan.jpg"),
			new Scenic("00000001","黄山","img/scenicindex/huangshan.jpg"),
			new Scenic("00000001","欢乐谷","img/scenicindex/huanlegu.jpg")};
	Scenic[] inter_scenics = {new Scenic("00000001","泰山","img/scenicindex/taishan.jpg"),
			new Scenic("00000001","黄山","img/scenicindex/huangshan.jpg"),
			new Scenic("00000001","欢乐谷","img/scenicindex/huanlegu.jpg"),
			new Scenic("00000001","泰山","img/scenicindex/taishan.jpg"),
			new Scenic("00000001","黄山","img/scenicindex/huangshan.jpg"),
			new Scenic("00000001","欢乐谷","img/scenicindex/huanlegu.jpg"),
			new Scenic("00000001","欢乐谷","img/scenicindex/huanlegu.jpg"),
			new Scenic("00000001","欢乐谷","img/scenicindex/huanlegu.jpg")};
	Scenic[] scenic_videos = {new Scenic("00000001","泰山","img/scenicindex/taishan.jpg"),
			new Scenic("00000001","黄山","img/scenicindex/huangshan.jpg"),
			new Scenic("00000001","欢乐谷","img/scenicindex/huanlegu.jpg"),
			new Scenic("00000001","泰山","img/scenicindex/taishan.jpg"),
			new Scenic("00000001","黄山","img/scenicindex/huangshan.jpg"),
			new Scenic("00000001","欢乐谷","img/scenicindex/huanlegu.jpg"),
			new Scenic("00000001","欢乐谷","img/scenicindex/huanlegu.jpg"),
			new Scenic("00000001","欢乐谷","img/scenicindex/huanlegu.jpg")};
	String[] news = {"美国五大湖发生洪涝","美国五大湖发生洪涝","美国五大湖发生洪涝","美国五大湖发生洪涝","美国五大湖发生洪涝","美国五大湖发生洪涝","美国五大湖发生洪涝","美国五大湖发生洪涝"};
	String[] order_item = {"00000000","00000000","","",""};
	String[] save_item = {"00000000","00000000",""};
	Ticket[] tickets = {new Ticket(save_item),new Ticket()};
	Order[] orders = {new Order(order_item),new Order()};
	public Frame(){
		super();
		init();
	}
//	初始化
	public void init(){
		this.setBounds(100,100,1030, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tourplace-去自己想去的地方");
		this.setCont();
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
	}
//	添加元素
	public void setCont(){
		Color white = Color.white;
		Color font_Color = new Color(140, 140, 140);
		final JPanel phead = new JPanel(),
				pside = new JPanel(),
				pcont = new JPanel();
		String logoPath = "img/lvyou.png";
		ImageIcon logoImg = new ImageIcon(logoPath);
		logoImg=new ImageIcon(logoImg.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)); 
		SpringLayout sp = new SpringLayout();
		SpringLayout spHead = new SpringLayout();
		Container contentPane = getContentPane();
		final CardLayout card = new CardLayout();
//		窗口头部布局
		sp.putConstraint(SpringLayout.WEST,phead , 0, SpringLayout.WEST, contentPane);
		sp.putConstraint(SpringLayout.EAST,phead , 0, SpringLayout.EAST, contentPane);
		sp.putConstraint(SpringLayout.NORTH,phead , 0, SpringLayout.NORTH, contentPane);
		sp.putConstraint(SpringLayout.SOUTH,phead , 50, SpringLayout.NORTH, contentPane);
		phead.setBackground(new Color(207, 35, 35));
		phead.setForeground(Color.white);
//		头部内容
		phead.setLayout(spHead);
		phead.addMouseListener(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
               xOld = e.getX();
               yOld = e.getY();
           }
		});
		phead.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e){
              int xOnScreen = e.getXOnScreen();
              int yOnScreen = e.getYOnScreen();
              int xx = xOnScreen - xOld;
              int yy = yOnScreen - yOld;
              setLocation(xx, yy);
          }
		});
		JPanel plogo = new JPanel();
		JPanel psearch =new JPanel();
		JPanel puser = new JPanel();
		JPanel psetting = new JPanel();
		JPanel pmin_close = new JPanel();
//		logo和title
		JLabel logo = new  JLabel(logoImg);
		JLabel title = new JLabel("Tourplace");
		spHead.putConstraint(SpringLayout.WEST,plogo , 10, SpringLayout.WEST, phead);
		spHead.putConstraint(SpringLayout.EAST,plogo , 160, SpringLayout.WEST, phead);
		spHead.putConstraint(SpringLayout.NORTH,plogo , 0, SpringLayout.NORTH, phead);
		spHead.putConstraint(SpringLayout.SOUTH,plogo , 0, SpringLayout.SOUTH, phead);
		logo.setBounds(10, 0, 40, 40);
		title.setBounds(52, 10,100, 30);
		title.setFont(new Font("微软雅黑", 1, 20));
		title.setForeground(Color.white);
		plogo.setBackground(new Color(207, 35, 35));
		plogo.setLayout(null);
		plogo.add(logo);
		plogo.add(title);
		phead.add(plogo);
//		搜索框
		spHead.putConstraint(SpringLayout.WEST,psearch , 100, SpringLayout.EAST, plogo);
		spHead.putConstraint(SpringLayout.EAST,psearch , 340, SpringLayout.EAST, plogo);
		spHead.putConstraint(SpringLayout.NORTH,psearch , 0, SpringLayout.NORTH, phead);
		spHead.putConstraint(SpringLayout.SOUTH,psearch , 0, SpringLayout.SOUTH, phead);
		MyTextField tsearch = new MyTextField();
		MyLabel lsearch = new MyLabel("",20,20);
		
		tsearch.setBounds(10,17,215,20);
		tsearch.setBorder(null);
		tsearch.setForeground(Color.white);
		tsearch.setBackground(new Color(148,30,30));
		
		lsearch.setIcon(new ImageIcon("img/search.png"));
		lsearch.setBounds(205,17,20,20);
		
		psearch.setLayout(null);
		psearch.setBackground(new Color(207, 35, 35));
		psearch.add(tsearch);
		psearch.add(lsearch);
		phead.add(psearch);
		
		
//		显示用户信息
		spHead.putConstraint(SpringLayout.WEST,puser , 150, SpringLayout.EAST, psearch);
		spHead.putConstraint(SpringLayout.EAST,puser , 290, SpringLayout.EAST, psearch);
		spHead.putConstraint(SpringLayout.NORTH,puser , 0, SpringLayout.NORTH, phead);
		spHead.putConstraint(SpringLayout.SOUTH,puser , 0, SpringLayout.SOUTH, phead);
		MyLabel luserAvatar = new MyLabel("asdasd", 40, 40);
		JLabel luserName = new JLabel("请登入");
		
		luserAvatar.setBounds(0,5,40,40);
		ImageIcon icon = new ImageIcon("img/00.jpg");
        icon=new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)); 
		luserAvatar.setIcon(icon);
		luserAvatar.setBackground(Color.white);
		
		luserName.setBounds(45, 15, 100, 20 );
		luserName.setForeground(Color.white);
		luserName.setFont(new Font("微软雅黑", 1, 12));
		
		puser.setLayout(null);
		puser.add(luserAvatar);
		puser.add(luserName);
		puser.setForeground(Color.white);
		puser.setBackground(new Color(207, 35, 35));
		phead.add(puser);
		
		

//		设置菜单
		spHead.putConstraint(SpringLayout.WEST,psetting , 80, SpringLayout.EAST, puser);
		spHead.putConstraint(SpringLayout.EAST,psetting , 120, SpringLayout.EAST, puser);
		spHead.putConstraint(SpringLayout.NORTH,psetting , 0, SpringLayout.NORTH, phead);
		spHead.putConstraint(SpringLayout.SOUTH,psetting , 0, SpringLayout.SOUTH, phead);
		
		JLabel lsetting = new JLabel();
		ImageIcon icon_setting = new ImageIcon("img/setting.png");
		icon_setting = new ImageIcon(icon_setting.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		lsetting.setIcon(icon_setting);
		lsetting.setBounds(5,10,30,30);
		psetting.setBackground(new Color(207, 35, 35));
		psetting.setLayout(null);
		psetting.add(lsetting);
		phead.add(psetting);
		
//		最小化/最大化/关闭
		spHead.putConstraint(SpringLayout.WEST,pmin_close , 0, SpringLayout.EAST, psetting);
		spHead.putConstraint(SpringLayout.EAST,pmin_close , 120, SpringLayout.EAST, psetting);
		spHead.putConstraint(SpringLayout.NORTH,pmin_close , 0, SpringLayout.NORTH, phead);
		spHead.putConstraint(SpringLayout.SOUTH,pmin_close , 0, SpringLayout.SOUTH, phead);
		pmin_close.setLayout(null);
		JLabel l_ = new JLabel("|");
		JLabel l_min = new JLabel();
		JLabel l_max = new JLabel();
		JLabel l_close = new JLabel();
		JLabel l_link = new JLabel();
		ImageIcon icon_min = new ImageIcon(new ImageIcon("img/min.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)),
				icon_max = new ImageIcon(new ImageIcon("img/max.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)),
				icon_close = new ImageIcon(new ImageIcon("img/close.png").getImage().getScaledInstance(13, 13, Image.SCALE_DEFAULT)),
				icon_link = new ImageIcon(new ImageIcon("img/link.png").getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT));
		l_min.setIcon(icon_min);
		l_max.setIcon(icon_max);
		l_close.setIcon(icon_close);
		l_link.setIcon(icon_link);
		l_.setBounds(0,7,20,40);
		l_.setFont(new Font("微软雅黑", 1, 20));
		l_.setForeground(Color.white);
		l_link.setBounds(20, 15, 20, 20);
		l_min.setBounds(42, 15, 20, 20);
		l_max.setBounds(64, 15, 20, 20);
		l_close.setBounds(86, 15, 20, 20);
		
		l_close.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		l_min.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		pmin_close.add(l_);
		pmin_close.add(l_link);
		pmin_close.add(l_min);
		pmin_close.add(l_max);
		pmin_close.add(l_close);
		pmin_close.setBackground(new Color(207,35,35));
		phead.add(pmin_close);
//		窗口侧边布局
		sp.putConstraint(SpringLayout.WEST,pside , 0, SpringLayout.WEST, contentPane);
		sp.putConstraint(SpringLayout.EAST,pside , 200, SpringLayout.WEST, contentPane);
		sp.putConstraint(SpringLayout.NORTH,pside ,50, SpringLayout.NORTH, contentPane);
		sp.putConstraint(SpringLayout.SOUTH,pside , 0, SpringLayout.SOUTH, contentPane);
		pside.setBackground(new Color(247, 247, 247));
		pside.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(219, 219, 219)));
//		侧边信息
		JPanel ptitle1 = new JPanel(),
			p_scenic1 = new JPanel(),
			p_scenic2 = new JPanel(),
			p_scenic3 = new JPanel(),
			ptitle2 = new JPanel(),
			p_user1 = new JPanel(),
			p_user2 = new JPanel(),
			p_user3 = new JPanel(),
			p_user4 = new JPanel();
		final JPanel[] parray = {p_scenic1,p_scenic2,p_scenic3,p_user1,p_user2,p_user3,p_user4};
//		景点
		ptitle1.setBounds(0,10,200,30);
		ptitle1.setBackground(new Color(247, 247, 247));
		JLabel ltitle1 = new JLabel("景点");
		ptitle1.setLayout(null);
		ltitle1.setBounds(10,5,100,15);
		ltitle1.setForeground(new Color(140, 140, 140));
		ptitle1.add(ltitle1);
		

		final JLabel lscenic_recommend = new JLabel("景区推荐");
		JLabel icon1 = new JLabel();
		ImageIcon icon_recommend = new ImageIcon(new ImageIcon("img/推荐.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		icon1.setIcon(icon_recommend);
		p_scenic1.setBounds(0,30,200,30);
		p_scenic1.setBackground(new Color(247, 247, 247));
		p_scenic1.setLayout(null);
		lscenic_recommend.setBounds(50,8,100,15);
		lscenic_recommend.setForeground(new Color(140, 140, 140));
		icon1.setBounds(30,0,30,30);
		p_scenic1.add(lscenic_recommend);
		p_scenic1.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lscenic_recommend.setForeground(new Color(140, 140, 140));
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lscenic_recommend.setForeground(new Color(0, 0, 0));
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				changeCard(parray,0);
				card.show(pcont,"景点推荐");
			}
		});
		p_scenic1.add(icon1);

		final JLabel lscenic_internation = new JLabel("旅游国际");
		JLabel icon2 = new JLabel();
		ImageIcon icon_internation = new ImageIcon(new ImageIcon("img/国际.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		icon2.setIcon(icon_internation);
		p_scenic2.setBounds(0,60,200,30);
		p_scenic2.setBackground(new Color(247, 247, 247));
		p_scenic2.setLayout(null);
		lscenic_internation.setBounds(50,8,100,15);
		lscenic_internation.setForeground(new Color(140, 140, 140));
		icon2.setBounds(30,0,30,30);
		p_scenic2.add(lscenic_internation);
		p_scenic2.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

				lscenic_internation.setForeground(new Color(140, 140, 140));
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lscenic_internation.setForeground(new Color(0, 0, 0));
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				changeCard(parray,1);
				card.show(pcont,"旅游国际");
			}
		});
		p_scenic2.add(icon2);

		final JLabel lscenic_video = new JLabel("宣传视频");
		JLabel icon3 = new JLabel();
		ImageIcon icon_video = new ImageIcon(new ImageIcon("img/视频.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		icon3.setIcon(icon_video);
		p_scenic3.setBounds(0,90,200,30);
		p_scenic3.setBackground(new Color(247, 247, 247));
		p_scenic3.setLayout(null);
		lscenic_video.setBounds(50,8,100,15);
		lscenic_video.setForeground(new Color(140, 140, 140));
		icon3.setBounds(30,0,30,30);
		p_scenic3.add(lscenic_video);
		p_scenic3.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lscenic_video.setForeground(new Color(140, 140, 140));
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lscenic_video.setForeground(new Color(0, 0, 0));
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				changeCard(parray,2);
				card.show(pcont,"宣传视频");
			}
		});
		p_scenic3.add(icon3);
		
//		用户
		ptitle2.setBounds(0,130,200,30);
		ptitle2.setBackground(new Color(247, 247, 247));
		JLabel ltitle2 = new JLabel("用户");
		ptitle2.setLayout(null);
		ltitle2.setBounds(10,5,100,15);
		ltitle2.setForeground(new Color(140, 140, 140));
		ptitle2.add(ltitle2);
		

		final JLabel luser_infor = new JLabel("个人信息");
		JLabel icon4 = new JLabel();
		ImageIcon icon_infor = new ImageIcon(new ImageIcon("img/个人信息.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		icon4.setIcon(icon_infor);
		p_user1.setBounds(0,150,200,30);
		p_user1.setBackground(new Color(247, 247, 247));
		p_user1.setLayout(null);
		luser_infor.setBounds(50,8,100,15);
		luser_infor.setForeground(new Color(140, 140, 140));
		icon4.setBounds(30,0,30,30);
		p_user1.add(luser_infor);
		p_user1.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				luser_infor.setForeground(new Color(140, 140, 140));
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				luser_infor.setForeground(new Color(0, 0, 0));
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				changeCard(parray,3);
				card.show(pcont,"个人信息");
			}
		});
		p_user1.add(icon4);

		final JLabel luser_order = new JLabel("我的订单");
		JLabel icon5 = new JLabel();
		ImageIcon icon_order = new ImageIcon(new ImageIcon("img/订单.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		icon5.setIcon(icon_order);
		p_user2.setBounds(0,180,200,30);
		p_user2.setBackground(new Color(247, 247, 247));
		p_user2.setLayout(null);
		luser_order.setBounds(50,8,100,15);
		luser_order.setForeground(new Color(140, 140, 140));
		icon5.setBounds(30,0,30,30);
		p_user2.add(luser_order);
		p_user2.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				luser_order.setForeground(new Color(140, 140, 140));
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				luser_order.setForeground(new Color(0, 0, 0));
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				changeCard(parray,4);
				card.show(pcont,"我的订单");
			}
		});
		p_user2.add(icon5);

		final JLabel luser_save = new JLabel("我的仓库");
		JLabel icon6 = new JLabel();
		ImageIcon icon_save = new ImageIcon(new ImageIcon("img/仓库.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		icon6.setIcon(icon_save);
		p_user3.setBounds(0,210,200,30);
		p_user3.setBackground(new Color(247, 247, 247));
		p_user3.setLayout(null);
		luser_save.setBounds(50,8,100,15);
		luser_save.setForeground(new Color(140, 140, 140));
		icon6.setBounds(30,0,30,30);
		p_user3.add(luser_save);
		p_user3.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				luser_save.setForeground(new Color(140, 140, 140));
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				luser_save.setForeground(new Color(0, 0, 0));
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				changeCard(parray,5);
				card.show(pcont,"我的仓库");
			}
		});
		p_user3.add(icon6);
		
		final JLabel luser_home = new JLabel("我的收藏");
		JLabel icon7 = new JLabel();
		ImageIcon icon_home = new ImageIcon(new ImageIcon("img/收藏.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		icon7.setIcon(icon_home);
		p_user4.setBounds(0,240,200,30);
		p_user4.setBackground(new Color(247, 247, 247));
		p_user4.setLayout(null);
		luser_home.setBounds(50,8,100,15);
		luser_home.setForeground(new Color(140, 140, 140));
		icon7.setBounds(30,0,30,30);
		p_user4.add(luser_home);
		p_user4.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				luser_home.setForeground(new Color(140, 140, 140));
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				luser_home.setForeground(new Color(0, 0, 0));
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				changeCard(parray,6);
				card.show(pcont,"我的收藏");
			}
		});
		p_user4.add(icon7);
		
		pside.setLayout(null);
		pside.add(ptitle1);
		pside.add(p_scenic1);
		pside.add(p_scenic2);
		pside.add(p_scenic3);
		pside.add(ptitle2);
		pside.add(p_user1);
		pside.add(p_user2);
		pside.add(p_user3);
		pside.add(p_user4);
		
//		窗口主体布局
		sp.putConstraint(SpringLayout.WEST,pcont , 200, SpringLayout.WEST, contentPane);
		sp.putConstraint(SpringLayout.EAST,pcont , 0, SpringLayout.EAST, contentPane);
		sp.putConstraint(SpringLayout.NORTH,pcont ,50, SpringLayout.NORTH, contentPane);
		sp.putConstraint(SpringLayout.SOUTH,pcont , 0, SpringLayout.SOUTH, contentPane);
		pcont.setLayout(card);
		JPanel pcont_scenic = new JPanel(),
			pcont_inter = new JPanel(),
			pcont_video = new JPanel(),
			pcont_user = new JPanel(),
			pcont_order = new JPanel(),
			pcont_save = new JPanel(),
			pcont_home = new JPanel();
		JScrollPane jsp1 = new JScrollPane(pcont_scenic,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
				jsp2 = new JScrollPane(pcont_inter,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
				jsp3 = new JScrollPane(pcont_video,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
				jsp4 = new JScrollPane(pcont_user,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
				jsp5 = new JScrollPane(pcont_order,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
				jsp6 = new JScrollPane(pcont_save,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
				jsp7 = new JScrollPane(pcont_home,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		final JScrollPane[] pcont_cont = {jsp1, jsp2, jsp3, jsp4, jsp5, jsp6, jsp7};
		String[] cardName = {"景点推荐","旅游国际","宣传视频","个人信息","我的订单","我的仓库","我的收藏"};
		for(int i = 0; i <7; i++){
			pcont.add(pcont_cont[i],cardName[i]);
		}
//		景区推荐界面
		pcont_scenic.setLayout(new FlowLayout());
		pcont_scenic.setBackground(new Color(255,255,255));
		pcont_scenic.setPreferredSize(new Dimension(800,1000));
		
//			头部
		JPanel p_scenic_head = new JPanel();
		p_scenic_head.setPreferredSize(new Dimension(800,50));
		pcont_scenic.add(p_scenic_head);
		p_scenic_head.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(219, 219, 219)));
		p_scenic_head.setBackground(new Color(255, 255, 255));
		final JLabel l_scenic_all = new JLabel("全部"),
				l_scenic_mount = new JLabel("登山"),
				l_scenic_sea = new JLabel("观海"),
				l_scenic_park = new JLabel("游乐园"),
				l_scenic_sight = new JLabel("名胜古迹"),
				l_scenic_scene = new JLabel("秀丽风光"),
				l_scenic_other = new JLabel("其他");
		final JLabel[] scenic_type_array = {l_scenic_all,l_scenic_mount,l_scenic_sea,l_scenic_park,l_scenic_sight,l_scenic_scene,l_scenic_other};
		p_scenic_head.setLayout(new FlowLayout(1,15,17));
		l_scenic_all.setForeground(new Color(0, 0, 0));
		p_scenic_head.add(l_scenic_all);
		l_scenic_mount.setForeground(new Color(140, 140, 140));
		p_scenic_head.add(l_scenic_mount);
		l_scenic_sea.setForeground(new Color(140, 140, 140));
		p_scenic_head.add(l_scenic_sea);
		l_scenic_park.setForeground(new Color(140, 140, 140));
		p_scenic_head.add(l_scenic_park);
		l_scenic_sight.setForeground(new Color(140, 140, 140));
		p_scenic_head.add(l_scenic_sight);
		l_scenic_scene.setForeground(new Color(140, 140, 140));
		p_scenic_head.add(l_scenic_scene);
		l_scenic_other.setForeground(new Color(140, 140, 140));
		p_scenic_head.add(l_scenic_other);
//			主体body
		JPanel p_scenic_body = new JPanel();
		p_scenic_body.setPreferredSize(new Dimension(800,1000));
		pcont_scenic.add(p_scenic_body);
		p_scenic_body.setBackground(new Color(255, 255, 255));
		p_scenic_body.setBorder(null);
//		p_scenic_body.setLayout(sp_scenic_body);
		p_scenic_body.setLayout(new FlowLayout(1));
//			主体轮播图
		JPanel p_scenic_body_turn = new JPanel();
		p_scenic_body_turn.setPreferredSize(new Dimension(800,190));
		p_scenic_body_turn.setBackground(Color.white);
		p_scenic_body_turn.setLayout(new FlowLayout(1,0,0));
		p_scenic_body.add(p_scenic_body_turn);
		final JPanel p_turn_picture = new JPanel();
		String[] turnImgUrl = {"img/scenic/00.jpg","img/scenic/01.jpg","img/scenic/02.jpg","img/scenic/03.jpg","img/scenic/04.jpg","img/scenic/05.jpg"};
		final CardLayout turn_card = new CardLayout();
		p_turn_picture.setLayout(turn_card);
		for(int j = 0; j < 6; j++){
			JLabel l_turn_picture = new JLabel();
			ImageIcon icon_turn = new ImageIcon(new ImageIcon(turnImgUrl[j]).getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT));
			l_turn_picture.setIcon(icon_turn);
			p_turn_picture.add(l_turn_picture);
		}
		Thread turn = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					turn_card.next(p_turn_picture);
					try{
						Thread.sleep(6000);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		turn.start();
		p_scenic_body_turn.add(p_turn_picture);
		
//		主体景区图片展示
		JPanel p_scenic_body_main = new JPanel();
		p_scenic_body_main.setPreferredSize(new Dimension(800,600));
		p_scenic_body_main.setBackground(Color.white);
		p_scenic_body_main.setLayout(new FlowLayout(1));
		//题目
		JPanel p_scenic_body_main_title = new JPanel();
		p_scenic_body_main.add(p_scenic_body_main_title);
		p_scenic_body_main_title.setBackground(Color.white);
		JLabel s_scenic_main_title = new JLabel("全部景区                                                                                            ");
		p_scenic_body_main_title.setPreferredSize(new Dimension(700,30));
		p_scenic_body_main_title.add(s_scenic_main_title);
		s_scenic_main_title.setForeground(new Color(140,140,140));
		p_scenic_body_main_title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(219, 219, 219)));
		
		//内容
		JPanel p_scenic_body_main_cont = new JPanel();
		p_scenic_body_main_cont.setPreferredSize(new Dimension(700,500));
		p_scenic_body_main_cont.setBackground(Color.white);
		p_scenic_body_main_cont.setLayout(new FlowLayout(0,15,10));
		p_scenic_body_main.add(p_scenic_body_main_cont);
		
		showScenic(p_scenic_body_main_cont,scenics,"    购     票");
		p_scenic_body.add(p_scenic_body_main);
		
//		旅游国际
		pcont_inter.setLayout(new FlowLayout(1,10,0));
		pcont_inter.setBackground(Color.white);
		JPanel p_inter_news = new JPanel();
		JPanel p_inter_scenic = new JPanel();
		
//			旅游资讯
		String icon_news_url = "img/scenicindex/huanlegu.jpg";
		JPanel p_inter_news_title = new JPanel();
		JLabel l_inter_news_title = new JLabel("旅游快讯");
		JPanel p_inter_news_cont = new JPanel();
		JLabel l_inter_news_cont = new JLabel();
		ImageIcon icon_news = new ImageIcon(new ImageIcon(icon_news_url).getImage().getScaledInstance(120, 160, Image.SCALE_DEFAULT));
		
		p_inter_news.setLayout(null);
		p_inter_news.setPreferredSize(new Dimension(700,200));
		p_inter_news.setBackground(Color.white);
		
		p_inter_news_title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(219, 219, 219)));
		p_inter_news_title.setBounds(0,20,700,30);
		p_inter_news_title.setLayout(new FlowLayout(0));
		p_inter_news_title.setBackground(white);
		l_inter_news_title.setForeground(font_Color);
		
		p_inter_news_cont.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(219, 219, 219)));
		p_inter_news_cont.setBounds(0, 50, 700,160);
		p_inter_news_cont.setLayout(null);
		p_inter_news_cont.setBackground(white);
		l_inter_news_cont.setBounds(0, 0, 120, 160);
		l_inter_news_cont.setIcon(icon_news);
		for(int news_num = 0; news_num < 8; news_num++){
			int x = news_num/4;
			int y = news_num%4;
			JLabel label_news = new JLabel(news[news_num]);
			label_news.setBounds(130+x*290,y*40,280,30);
			label_news.setForeground(font_Color);
			p_inter_news_cont.add(label_news);
		}
		p_inter_news_title.add(l_inter_news_title);
		p_inter_news_cont.add(l_inter_news_cont);
		p_inter_news.add(p_inter_news_title);
		p_inter_news.add(p_inter_news_cont);

//			国际景点
		JPanel p_inter_scenic_title = new JPanel();
		JPanel p_inter_scenic_cont = new JPanel();
		JLabel l_inter_scenic_title = new JLabel("国际景区");
		//标题
		l_inter_scenic_title.setForeground(font_Color);
		p_inter_scenic_title.setBounds(0, 20, 700, 30);
		p_inter_scenic_title.setLayout(new FlowLayout(0));
		p_inter_scenic_title.setBackground(white);
		p_inter_scenic_title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(219, 219, 219)));
		
		//内容
		showScenic(p_inter_scenic_cont,inter_scenics,"    购     票");
		p_inter_scenic_cont.setLayout(new FlowLayout(0,18,20));
		p_inter_scenic_cont.setBounds(0,50,700,500);
		p_inter_scenic_cont.setBackground(white);
		
		p_inter_scenic.setLayout(null);
		p_inter_scenic.setPreferredSize(new Dimension(700,600));
		p_inter_scenic.setBackground(Color.white);
		
		p_inter_scenic_title.add(l_inter_scenic_title);
		p_inter_scenic.add(p_inter_scenic_title);
		p_inter_scenic.add(p_inter_scenic_cont);
		
		
		pcont_inter.setPreferredSize(new Dimension(700,1000));
		pcont_inter.add(p_inter_news);
		pcont_inter.add(p_inter_scenic);
		
//		宣传视频
		pcont_video.setLayout(new FlowLayout(1,10,0));
		pcont_video.setBackground(Color.white);
		JPanel p_video_head = new JPanel();
		JPanel p_video_cont = new JPanel();
		JPanel p_video_cont_title = new JPanel();
		JPanel p_video_cont_body = new JPanel();
		JLabel l_video_cont_title = new JLabel("宣传视频");
		
			//顶部视频框
		p_video_head.setPreferredSize(new Dimension(800,200));
		p_video_head.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(219, 219, 219)));
			//宣传视频展示
		p_video_cont.setPreferredSize(new Dimension(700,600));
		p_video_cont.setBackground(white);
		p_video_cont.setLayout(null);
		p_video_cont_title.setBounds(0, 10, 700, 30);
		p_video_cont_title.setBackground(white);
		p_video_cont_title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(219, 219, 219)));
		p_video_cont_title.setLayout(new FlowLayout(0));
		l_video_cont_title.setForeground(font_Color);
		p_video_cont_body.setLayout(new FlowLayout(0,18,20));
		p_video_cont_body.setBounds(0,40,700,600);
		p_video_cont_body.setBackground(white);
		showScenic(p_video_cont_body,scenic_videos,"    观     看");
		
		p_video_cont_title.add(l_video_cont_title);
		p_video_cont.add(p_video_cont_title);
		p_video_cont.add(p_video_cont_body);
		pcont_video.add(p_video_head);
		pcont_video.add(p_video_cont);
		pcont_video.setPreferredSize(new Dimension(800,1000));
		
//		用户信息
		pcont_user.setLayout(new FlowLayout(1,10,0));
		pcont_user.setBackground(Color.white);
		pcont_user.setPreferredSize(new Dimension(750,800));
		JPanel p_user_head = new JPanel();
		JPanel p_user_cont = new JPanel();
		JPanel p_user_cont_infor = new JPanel();
		JPanel p_user_cont_avatar = new JPanel();
		JLabel l_user_head = new JLabel("编辑个人信息>>"),
				l_user_cont_name = new JLabel("昵称: "),
				l_user_cont_sex = new JLabel("性别: "),
				l_user_cont_birthday = new JLabel("生日: "),
				l_user_cont_place = new JLabel("省市: "),
				l_user_cont_intro = new JLabel("介绍: ");
		JLabel[] label_infor = {l_user_cont_name, l_user_cont_sex, l_user_cont_birthday, l_user_cont_place, l_user_cont_intro};
		JTextField t_user_name = new JTextField();
		JRadioButton secret = new JRadioButton("2"),
				sex_man = new JRadioButton("0"),
				sex_woman = new JRadioButton("1");
		JLabel l_secret = new JLabel("保密");
		JLabel l_sex_man = new JLabel("男");
		JLabel l_sex_woman = new JLabel("女");
		ButtonGroup b_user_sex = new ButtonGroup();
		JComboBox birth_y = new JComboBox(),
				birth_m = new JComboBox(),
				province = new JComboBox(),
				city = new JComboBox();
		JLabel l_birth_y = new JLabel("年");
		JLabel l_birth_m = new JLabel("月");
		JLabel l_province = new JLabel("省");
		JLabel l_city = new JLabel("市");
		JTextArea t_intro = new JTextArea();
		JLabel l_user_avatar = new JLabel();
		JButton b_avatar = new JButton("修改");
		//顶部标题
		p_user_head.setPreferredSize(new Dimension(750,50));
		p_user_head.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(219, 219, 219)));
		p_user_head.setLayout(null);
		p_user_head.setBackground(white);
		l_user_head.setBounds(0, 20, 750,20);
		l_user_head.setFont(new Font("微软雅黑",1,20));
		l_user_head.setForeground(font_Color);
		//个人信息
		p_user_cont.setPreferredSize(new Dimension(750,1000));
		p_user_cont.setLayout(null);
		p_user_cont.setBackground(white);
		p_user_cont_infor.setBounds(0,20,500,500);
		p_user_cont_infor.setBackground(white);
		p_user_cont_infor.setLayout(null);
		for(int i = 0; i < 5; i ++){
			label_infor[i].setForeground(font_Color);
			label_infor[i].setBounds(0, i*50+10, 50, 50);
			p_user_cont_infor.add(label_infor[i]);
		}
		t_user_name.setBounds(50, 22, 400, 25);
		secret.setBounds(50, 75, 20, 20);
		secret.setBackground(white);
		l_secret.setBounds(70, 75, 30, 20);
		l_secret.setForeground(font_Color);
		sex_man.setBounds(100, 75,20,20);
		sex_man.setBackground(white);
		l_sex_man.setBounds(120, 75, 30,20);
		l_sex_man.setForeground(font_Color);
		sex_woman.setBounds(140, 75,20,20);
		sex_woman.setBackground(white);
		l_sex_woman.setBounds(160, 75, 30, 20);
		l_sex_woman.setForeground(font_Color);
		birth_y.setBounds(50, 125, 100,20);
		birth_y.setBackground(white);
		l_birth_y.setBounds(160,125,30,20);
		birth_m.setBounds(210, 125, 100,20);
		birth_m.setBackground(white);
		l_birth_m.setBounds(320, 125, 30, 20);
		province.setBounds(50, 175, 100,20);
		province.setBackground(white);
		l_province.setBounds(160,175,30,20);
		city.setBounds(210, 175, 100,20);
		city.setBackground(white);
		l_city.setBounds(320, 175, 30, 20);
		t_intro.setBounds(50, 230, 400,200);
		t_intro.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(219, 219, 219)));
		
		p_user_cont_avatar.setBounds(500,20,250,400);
		p_user_cont_avatar.setBackground(white);
		p_user_cont_avatar.setLayout(null);
		ImageIcon icon_avator = new ImageIcon(new ImageIcon("img/00.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		l_user_avatar.setIcon(icon_avator);
		l_user_avatar.setBounds(20,30,150,150);
		b_avatar.setBounds(65, 200, 60, 25);
		
		b_user_sex.add(secret);
		b_user_sex.add(sex_man);
		b_user_sex.add(sex_woman);
		p_user_cont_avatar.add(l_user_avatar);
		p_user_cont_avatar.add(b_avatar);
		p_user_cont_infor.add(t_intro);
		p_user_cont_infor.add(l_province);
		p_user_cont_infor.add(l_city);
		p_user_cont_infor.add(province);
		p_user_cont_infor.add(city);
		p_user_cont_infor.add(l_birth_y);
		p_user_cont_infor.add(l_birth_m);
		p_user_cont_infor.add(birth_y);
		p_user_cont_infor.add(birth_m);
		p_user_cont_infor.add(secret);
		p_user_cont_infor.add(sex_man);
		p_user_cont_infor.add(sex_woman);
		p_user_cont_infor.add(t_user_name);
		p_user_cont_infor.add(l_secret);
		p_user_cont_infor.add(l_sex_man);
		p_user_cont_infor.add(l_sex_woman);
		p_user_cont.add(p_user_cont_avatar);
		p_user_cont.add(p_user_cont_infor);
		p_user_head.add(l_user_head);
		pcont_user.add(p_user_head);
		pcont_user.add(p_user_cont);
		
//		我的订单
		JPanel p_order_head = new JPanel(),
				p_order_cont = new JPanel(),
				p_order_cont_container = new JPanel();
		JLabel l_order_title = new JLabel("我的订单>>");
		
		//顶部标题
		pcont_order.setLayout(new FlowLayout(1,10,0));
		pcont_order.setPreferredSize(new Dimension(750,800));
		pcont_order.setBackground(Color.white);
		p_order_head.setPreferredSize(new Dimension(750,50));
		p_order_head.setLayout(null);
		p_order_head.setBackground(white);
		p_order_head.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(219, 219, 219)));
		l_order_title.setBounds(0,15,700,30);
		l_order_title.setFont(new Font("微软雅黑",1,20));
		l_order_title.setForeground(font_Color);
		
		//订单内容
		p_order_cont.setPreferredSize(new Dimension(700,800));
		p_order_cont.setLayout(null);
		p_order_cont.setBackground(white);
		p_order_cont_container.setBounds(0,20,700,600);
		p_order_cont_container.setLayout(new FlowLayout(0,20,20));
		p_order_cont_container.setBackground(white);
		for(int i = 0; i < orders.length; i++){
			JPanel p_order_cont_body = new JPanel();
			JLabel l_order_ID = new JLabel("订单号："),
					l_ticket_ID = new JLabel("门票号："),
					l_order_Time = new JLabel("下单时间："),
					l_order_Count = new JLabel("订单数量："),
					l_order_Price = new JLabel("门票单价："),
					orderID = new JLabel(orders[i].getOrderID()),
					ticketID = new JLabel(orders[i].getTicketID()),
					orderTime = new JLabel(orders[i].getOrderTime()),
					orderCount = new JLabel(orders[i].getOrderCount()),
					orderPrice = new JLabel(orders[i].getOrderPrice());
			JLabel[] l = {l_order_ID, l_ticket_ID, l_order_Time, l_order_Count, l_order_Price};
			JLabel[] item = {orderID, ticketID, orderTime, orderCount, orderPrice};
			for(int j = 0; j < 5; j++){
				l[j].setForeground(white);
				l[j].setBounds(5,j*30+10,70,30);
				item[j].setForeground(white);
				item[j].setBounds(75,j*30+10,100,30);
				p_order_cont_body.add(l[j]);
				p_order_cont_body.add(item[j]);
			}
			
			p_order_cont_body.setPreferredSize(new Dimension(180,250));
			p_order_cont_body.setBackground(new Color(255,51,51));
			p_order_cont_body.setLayout(null);
			
			p_order_cont_container.add(p_order_cont_body);
		}

		p_order_head.add(l_order_title);
		p_order_cont.add(p_order_cont_container);
		pcont_order.add(p_order_head);
		pcont_order.add(p_order_cont);
//		我的仓库
		JPanel p_save_head = new JPanel(),
				p_save_cont = new JPanel(),
				p_save_cont_container = new JPanel();
		JLabel l_save_title = new JLabel("我的门票>>");
		
		//顶部标题
		pcont_save.setLayout(new FlowLayout(1,10,0));
		pcont_save.setPreferredSize(new Dimension(750,800));
		pcont_save.setBackground(Color.white);
		p_save_head.setPreferredSize(new Dimension(750,50));
		p_save_head.setLayout(null);
		p_save_head.setBackground(white);
		p_save_head.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(219, 219, 219)));
		l_save_title.setBounds(0,15,700,30);
		l_save_title.setFont(new Font("微软雅黑",1,20));
		l_save_title.setForeground(font_Color);
		
		//仓库内容
		p_save_cont.setPreferredSize(new Dimension(700,800));
		p_save_cont.setLayout(null);
		p_save_cont.setBackground(white);
		p_save_cont_container.setBounds(0,20,700,600);
		p_save_cont_container.setLayout(new FlowLayout(0,20,20));
		p_save_cont_container.setBackground(white);
		for(int i = 0; i < orders.length; i++){
			JPanel p_save_cont_body = new JPanel();
			JLabel 	l_ticket_ID = new JLabel("门票号："),
					l_scenic_ID = new JLabel("景区号："),
					l_save_Time = new JLabel("门票时间："),
					ticketID = new JLabel(tickets[i].getTicketID()),
					scenicID = new JLabel(tickets[i].getScenicID()),
					ticketTime = new JLabel(tickets[i].getTicketTime());
			JLabel[] l = {l_ticket_ID, l_scenic_ID, l_save_Time};
			JLabel[] item = {ticketID, scenicID, ticketTime};
			for(int j = 0; j < 3; j++){
				l[j].setForeground(white);
				l[j].setBounds(5,j*30+10,70,30);
				item[j].setForeground(white);
				item[j].setBounds(75,j*30+10,100,30);
				p_save_cont_body.add(l[j]);
				p_save_cont_body.add(item[j]);
			}
			
			p_save_cont_body.setPreferredSize(new Dimension(180,120));
			p_save_cont_body.setBackground(new Color(255,51,51));
			p_save_cont_body.setLayout(null);
			
			p_save_cont_container.add(p_save_cont_body);
		}

		p_save_head.add(l_save_title);
		p_save_cont.add(p_save_cont_container);
		pcont_save.add(p_save_head);
		pcont_save.add(p_save_cont);
		
		contentPane.setLayout(sp);
		contentPane.add(phead);
		contentPane.add(pside);
		contentPane.add(pcont);
	}
	private void changeCard(JPanel[] p, int index){
		int i;
		for(i=0;i<p.length;i++){
			if(i == index){
				p[i].setBackground(new Color(196, 196, 196));
			}else{
				p[i].setBackground(new Color(247, 247, 247));
			}
		}
	}
	private void showScenic(JPanel p,Scenic[] scenics,String str){
		for(int k = 0;k < scenics.length;k++){
			final JPanel p_scenic_content = new JPanel();
			JPanel p_scenic_name = new JPanel();
			JLabel scenic_cont = new JLabel(),
					scenic_name = new JLabel(scenics[k].getName());
			final JLabel button_buy = new JLabel(str);
			scenic_name.setForeground(Color.white);
			p_scenic_name.add(scenic_name);
			p_scenic_name.setOpaque(false);
			p_scenic_name.setBounds(0,120,117,25);
			button_buy.setFont(new Font("微软雅黑",1,13));
			button_buy.setForeground(new Color(61, 61, 61));
			button_buy.addMouseListener(new MouseListener() {
				
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					button_buy.setForeground(new Color(61, 61, 61));
					p_scenic_content.setBackground(new Color(235, 235, 235));
				}
				
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					button_buy.setForeground(Color.white);
					p_scenic_content.setBackground(new Color(255, 0, 0));
				}
				
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			ImageIcon icon_scenic = new ImageIcon(new ImageIcon(scenics[k].getPicture()).getImage().getScaledInstance(117, 150, Image.SCALE_DEFAULT));
			scenic_cont.setIcon(icon_scenic);
			scenic_cont.setBounds(0,0,117,150);
			button_buy.setBounds(0,150,117,24);
			p_scenic_content.setLayout(null);
			p_scenic_content.setPreferredSize(new Dimension(117,175));
			p_scenic_content.add(p_scenic_name);
			p_scenic_content.add(scenic_cont);
			p_scenic_content.add(button_buy);
			p.add(p_scenic_content);
		}
	}
	public void getScenics(){
		
	}
}