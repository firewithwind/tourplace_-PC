package index;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import custom.*;
import entity.*;

public class Frame extends JFrame{
	/**
	 * @param args
	 */
	public Frame(){
		super();
		init();
	}
//	初始化
	private void init(){
		this.setBounds(100,100,1030, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tourplace-去自己想去的地方");
		this.setCont();
		setUndecorated(true);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Frame().init();
	}
//	添加元素
	public void setCont(){
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
		final JPanel[] pcont_cont = {pcont_scenic, pcont_inter,pcont_video,pcont_user,pcont_order,pcont_save,pcont_home};
		String[] cardName = {"景点推荐","旅游国际","宣传视频","个人信息","我的订单","我的仓库","我的收藏"};
		for(int i = 0; i <7; i++){
			pcont.add(pcont_cont[i],cardName[i]);
		}
		SpringLayout sp1 = new SpringLayout(),
				sp2 = new SpringLayout(),
				sp3 = new SpringLayout(),
				sp4 = new SpringLayout(),
				sp5 = new SpringLayout(),
				sp6 = new SpringLayout(),
				sp7 = new SpringLayout();
//		景区推荐界面
		pcont_scenic.setLayout(sp1);
		pcont_scenic.setBackground(new Color(255,255,255));
//			头部
		JPanel p_scenic_head = new JPanel();
		sp1.putConstraint(SpringLayout.WEST,p_scenic_head , 0, SpringLayout.WEST, pcont_scenic);
		sp1.putConstraint(SpringLayout.EAST,p_scenic_head  , 0, SpringLayout.EAST, pcont_scenic);
		sp1.putConstraint(SpringLayout.NORTH,p_scenic_head  ,0, SpringLayout.NORTH, pcont_scenic);
		sp1.putConstraint(SpringLayout.SOUTH,p_scenic_head  , 50, SpringLayout.NORTH, pcont_scenic);
		pcont_scenic.add(p_scenic_head);
		p_scenic_head.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(219, 219, 219)));
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
		SpringLayout sp_scenic_body = new SpringLayout();
//		p_scenic_body.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp1.putConstraint(SpringLayout.WEST, p_scenic_body, 0, SpringLayout.WEST, pcont_scenic);
		sp1.putConstraint(SpringLayout.EAST, p_scenic_body, 0, SpringLayout.EAST, pcont_scenic);
		sp1.putConstraint(SpringLayout.NORTH, p_scenic_body, 50, SpringLayout.NORTH, pcont_scenic);
		sp1.putConstraint(SpringLayout.SOUTH, p_scenic_body, 0, SpringLayout.SOUTH, pcont_scenic);
		pcont_scenic.add(p_scenic_body);
		p_scenic_body.setBackground(new Color(255, 255, 255));
		p_scenic_body.setBorder(null);
		p_scenic_body.setLayout(sp_scenic_body);
//			主体轮播图
		JPanel p_scenic_body_turn = new JPanel();
		sp_scenic_body.putConstraint(SpringLayout.WEST, p_scenic_body_turn, 0, SpringLayout.WEST, p_scenic_body);
		sp_scenic_body.putConstraint(SpringLayout.EAST, p_scenic_body_turn, 0, SpringLayout.EAST, p_scenic_body);
		sp_scenic_body.putConstraint(SpringLayout.NORTH, p_scenic_body_turn, 10, SpringLayout.NORTH, p_scenic_body);
		sp_scenic_body.putConstraint(SpringLayout.SOUTH, p_scenic_body_turn, 200, SpringLayout.NORTH, p_scenic_body);
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
			l_turn_picture.setSize(160,44);
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
//		SpringLayout sp_scenic_body_main = new SpringLayout();
		sp_scenic_body.putConstraint(SpringLayout.WEST, p_scenic_body_main, 0, SpringLayout.WEST, p_scenic_body);
		sp_scenic_body.putConstraint(SpringLayout.EAST, p_scenic_body_main, 0, SpringLayout.EAST, p_scenic_body);
		sp_scenic_body.putConstraint(SpringLayout.NORTH, p_scenic_body_main, 210, SpringLayout.NORTH, p_scenic_body);
		sp_scenic_body.putConstraint(SpringLayout.SOUTH, p_scenic_body_main, 0, SpringLayout.SOUTH, p_scenic_body);
		p_scenic_body_main.setBackground(Color.white);
		
		p_scenic_body_main.setLayout(new FlowLayout(1));
		JPanel p_scenic_body_main_title = new JPanel();
		p_scenic_body_main.add(p_scenic_body_main_title);
		p_scenic_body_main_title.setBackground(Color.white);
		JLabel s_scenic_main_title = new JLabel("全部景区                                                                             ");
		p_scenic_body_main_title.setPreferredSize(new Dimension(600,30));
		p_scenic_body_main_title.add(s_scenic_main_title);
		s_scenic_main_title.setForeground(new Color(140,140,140));
		p_scenic_body_main_title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(219, 219, 219)));
		Scenic[] scenics = {new Scenic("00000001","泰山","img/scenicindex/taishan.jpg"),new Scenic("00000001","泰山","img/scenicindex/taishan.jpg"),
				new Scenic("00000001","泰山","img/scenicindex/taishan.jpg"),
				new Scenic("00000001","泰山","img/scenicindex/taishan.jpg")};
		for(int k = 0;k < scenics.length;k++){
			
		}
		
		
		
		
		
		
		
		
		
		p_scenic_body.add(p_scenic_body_main);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
}