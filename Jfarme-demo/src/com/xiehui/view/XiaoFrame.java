package com.xiehui.view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import java.lang.Integer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.xiehui.mapper.KucunMapper;
import com.xiehui.mapper.UserMapper;
import com.xiehui.util.ABSearch;
import com.xiehui.util.JDBCTemplate;
import com.xiehui.util.MyThread;
import com.xiehui.util.RowMapper;

public class XiaoFrame extends JFrame implements ActionListener{
	private JPanel acontentPane;
	private JTextField oldpassword;
	private JTextField newpassword;

	private Object password = UserMainFrame.password;
	private Object name = UserMainFrame.name;
	private int root = UserMainFrame.root;
//	private Object password="ying",name="qin";
//	private int root=1;
	
	private JDBCTemplate atemp = new JDBCTemplate();
	private DefaultTableModel adtm = new DefaultTableModel();
	private JPanel bcontentPane;
	private JTextField thingId;
	private JTextField thingNum;
	private Vector bdata = new Vector();
	private Vector bcolname = new Vector();
	
	private JTable table;
	private DefaultTableModel bdtm;
	private JTable selfmessage;
	private Vector acolname;
	private Vector adata = new Vector();
	
	private JTable tableJilu;
	private JPanel contentPaneJilu;
	private Vector colnameJilu = new Vector();
	private DefaultTableModel dtmJilu = new DefaultTableModel();
	private Vector dataJilu = new Vector();
	private JDBCTemplate tempJilu = new JDBCTemplate();
	
	private JLabel jl;
	
	public XiaoFrame() {
		
		this.setTitle("用户："+(String) name+"    销售界面");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/3.JPG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 417);
		acontentPane = new JPanel();
		acontentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(acontentPane);
		acontentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 35, 424, 344);
		acontentPane.add(tabbedPane);
//---管理-----------------------------------------------
		JPanel jp1 = new JPanel();
		tabbedPane.addTab("管理", null, jp1, null);
		jp1.setLayout(null);
		
		JLabel label = new JLabel("旧密码：");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(31, 21, 54, 15);
		jp1.add(label);
		
		oldpassword = new JTextField();
		oldpassword.setBounds(114, 18, 66, 21);
		jp1.add(oldpassword);
		oldpassword.setColumns(10);
		
		JLabel label_1 = new JLabel("新密码：");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(31, 59, 54, 15);
		jp1.add(label_1);
		
		newpassword = new JTextField();
		newpassword.setBounds(114, 56, 66, 21);
		jp1.add(newpassword);
		newpassword.setColumns(10);
		
		JButton button = new JButton("sure");
		button.addActionListener(this);
		button.setBounds(236, 17, 139, 23);
		jp1.add(button);
		
		JLabel label_2 = new JLabel("个人信息：");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(27, 108, 84, 15);
		jp1.add(label_2);
		
		acolname = new Vector();
		acolname.add("id");
		acolname.add("username");
		acolname.add("password");
		acolname.add("root");
		fanSelf();
		selfmessage = new JTable(adtm);
		selfmessage.setSize(399, 71);
		JScrollPane scrollPane = new JScrollPane(selfmessage);
		scrollPane.setBounds(10, 140, 399, 71);
		jp1.add(scrollPane);
		
		if(root == 1){
			JButton btnboss = new JButton("返回boss界面");
			btnboss.addActionListener(this);
			btnboss.setBounds(236, 55, 139, 23);
			jp1.add(btnboss);
		}
//----工作------------------------------------------------------------------------------------
		JPanel jp2 = new JPanel();
		tabbedPane.addTab("工作", null, jp2, null);
		jp2.setLayout(null);
		

		JLabel lblId = new JLabel("商品编码：");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(10, 23, 76, 15);
		jp2.add(lblId);

		thingId = new JTextField();
		thingId.setBounds(79, 20, 66, 21);
		jp2.add(thingId);
		thingId.setColumns(10);

		JLabel label1 = new JLabel("数量：");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(164, 23, 65, 15);
		jp2.add(label1);

		thingNum = new JTextField();
		thingNum.setBounds(222, 20, 66, 21);
		jp2.add(thingNum);
		thingNum.setColumns(10);
		
		bcolname.add("id");
		bcolname.add("商品名称");
		bcolname.add("数量");
		bcolname.add("进货单价");

		bdtm = new DefaultTableModel(bdata, bcolname);

		table = new JTable(bdtm);
		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(10, 49, 399, 224);
		jp2.add(scrollPane1);
		
		JButton btnAdd = new JButton("添加");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(322, 19, 76, 23);
		jp2.add(btnAdd);

		JButton btnIn = new JButton("销售");
		btnIn.addActionListener(this);
		btnIn.setBounds(281, 282, 93, 23);
		jp2.add(btnIn);
		
		JButton buttonChu = new JButton("清除");
		buttonChu.addActionListener(this);
		buttonChu.setBounds(90, 282, 93, 23);
		jp2.add(buttonChu);
//----库存记录-----------------------------------------------------		
		JPanel panelJilu = new JPanel();
		tabbedPane.addTab("库存记录", null, panelJilu, null);
		panelJilu.setLayout(null);
		
		colnameJilu = new Vector();
		colnameJilu.add("id");
		colnameJilu.add("商品编号");
		colnameJilu.add("数量");
		colnameJilu.add("名称");
		showAllku();
		tableJilu = new JTable(dtmJilu);
		tableJilu.setSize(376, 275);
		JScrollPane scrollPaneJiu = new JScrollPane(tableJilu);
		scrollPaneJiu.setBounds(10, 10, 376, 275);
		panelJilu.add(scrollPaneJiu);
		
		
		scrollPaneJiu.setViewportView(tableJilu);
		
		
		JButton buttonShua = new JButton("Refresh");
		buttonShua.addActionListener(this);
		buttonShua.setBounds(153, 292, 93, 23);
		panelJilu.add(buttonShua);
//--时间--------------------------------------------------------------------------------------
		jl = new JLabel("New label");
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setBounds(109, 10, 182, 15);
		acontentPane.add(jl);
		
		MyThread mt = new MyThread(jl);
		mt.start();
	}
	
	private void showAllku() {
		ABSearch ab;
		String sql = "select * from kucun";
		RowMapper um = new KucunMapper();
		Object[] array={};
		dataJilu = tempJilu.query(sql,um,array);
		for(int i = 0;i < dataJilu.size();i++){
			Vector d = (Vector) dataJilu.get(i);
			Object v = d.get(1);
			ab = new ABSearch(v);
			d.add(ab.ABSearchName());
		}
		dtmJilu.setDataVector(dataJilu, colnameJilu);
	}

	public void fanSelf(){
		
		adata = fanSelfAll(name,password);
		adtm.setDataVector( adata, acolname);
	}
	
	public Vector fanSelfAll(Object name,Object password){
		String sql = "select * from user where username=? and password=?";
		RowMapper um = new UserMapper();
		Object[] array={name,password};
		adata = atemp.query(sql, um,array);
		return  adata;
		
	}
	
	public String fanId(Object name,Object password){
		String id=null;
		if(oldpassword.getText().equals(password)){
			adata = fanSelfAll(name,password);
			Object data1 = adata.get(0);
			Object v =((Vector) data1).get(0);
			System.out.println("v----"+v);
			String a = v.toString();
			id=a;
		}
		return id;
	}
	
	public boolean pan(Object a,Object b){
		boolean xi = false;
		int h=Integer.parseInt(String.valueOf(b));
		for (int i = 0; i < dataJilu.size(); i++) {
			Vector d = (Vector) dataJilu.get(i);
			if (a.equals(String.valueOf(d.get(1)))) {
				if(h>Integer.parseInt(String.valueOf(d.get(2)))){
					xi = true;
					break;
				}	
			}
		}
		return xi;
	}
	
	private void XiaoJilu(Object a,Object b){
		System.out.println("=====+++++++-----dataJilu:"+dataJilu);
		int ji=0;
		String sql = null;
		int h=Integer.parseInt(String.valueOf(b));
		for (int i = 0; i < dataJilu.size(); i++) {
			Vector d = (Vector) dataJilu.get(i);
			System.out.println("0---d.get(1):"+d.get(1));
			System.out.println("1---a:"+a);
			if (a.equals(String.valueOf(d.get(1)))) {
				// 找到相同的
				h =Integer.parseInt(String.valueOf(d.get(2))) - h;
				System.out.println("3---h:"+h);
				sql = "update kucun set number=? where thingId=?";
				break;
			}else{
				ji++;
			}
		}
		if(ji==dataJilu.size()){
			sql = "insert into kucun(number,thingId) values(?,?)";
		}
		Object[] arg={String.valueOf(h),a};
		atemp.modify(sql, arg);
	}
	
	public void actionPerformed(ActionEvent e) {
		if("sure".equals(e.getActionCommand())){
			if(oldpassword.getText().equals(password)){
				System.out.println("=======sure========");
				String id = fanId(name,password);
				System.out.println("id----"+id);
				String sql="update user set password=? where id=?";
				Object[] arg={newpassword.getText(),id};
				atemp.modify(sql, arg);
				UserMainFrame.password = newpassword.getText();
				password = newpassword.getText();
				fanSelf();
				JOptionPane.showMessageDialog(null, "修改成功，重新登录！！！！");
				this.setVisible(false);
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "密码错误!!");
			}
		}else if ("添加".equals(e.getActionCommand())) {
			// 当浏览区域没有该商品时，将新建一个Vector
			int jishu = 0;
			for(int i=0;i<bdata.size();i++){
				Vector d = (Vector) bdata.get(i);
				if (thingId.getText().equals(d.get(0))) {
					jishu++;
				}
			}
			if(jishu < 1){
				ABSearch ab = new ABSearch(thingId.getText());
				Vector data1 = new Vector();
				data1.add(thingId.getText());
				data1.add(ab.ABSearchName());//
				data1.add(thingNum.getText());
				data1.add(ab.ABSearchMoney());//
				System.out.println("data1=========="+data1);
				bdata.add(data1);
			}else{
				for (int i = 0; i < bdata.size(); i++) {
					Vector d = (Vector) bdata.get(i);
					if (thingId.getText().equals(d.get(0))) {
						// 找到相同的
						int s=Integer.parseInt(String.valueOf(d.get(2)))+ Integer.parseInt(String.valueOf(thingNum.getText()));
						System.out.println("s=========="+s);
						Object o =String.valueOf(s);
						d.set(2, o);
					}
				}
			}
			bdtm.setDataVector(bdata, bcolname);
		} else if ("销售".equals(e.getActionCommand())) {//thingId number time zhiyuan
			JDBCTemplate temp = new JDBCTemplate();
			String sql = "insert into xiaodan(thingId,number,time,zhiyuan) values(?,?,?,?)";
			String stime = jl.getText();
			Object[] arg = new Object[4];
			System.out.println("bdata======"+bdata);
			for (int i = 0; i < bdata.size(); i++) {
				Vector data1 = (Vector) bdata.get(i);
				arg[0] = data1.get(0);
				arg[1] = data1.get(2);
				arg[2] = stime;
				arg[3] = name;
				if(pan(arg[0],arg[1])==true){
					JOptionPane.showMessageDialog(null, "库存不足！！！！");
				}else{
					System.out.println("物品编号："+arg[0]+"     数量："+arg[1]+"    时间："+arg[2]+"     相关职员："+arg[3]);
					XiaoJilu(arg[0],arg[1]);
					temp.modify(sql, arg);
				}
			}
		} else if("清除".equals(e.getActionCommand())){
			thingNum.setText(null);
			thingId.setText(null);
			bdata = new Vector();
			bdtm.setDataVector(bdata, colnameJilu);	
		}else if("Refresh".equals(e.getActionCommand())){
			showAllku();
		}else if("返回boss界面".equals(e.getActionCommand())){
			this.setVisible(false);
			UserMainFrame umf = new UserMainFrame(name,password);
		}
	}
}
