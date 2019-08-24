package com.xiehui.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import com.xiehui.mapper.JinMapper;
import com.xiehui.mapper.KucunMapper;
import com.xiehui.mapper.MassageMapper;
import com.xiehui.mapper.XiaoMapper;
import com.xiehui.util.ABSearch;
import com.xiehui.util.JDBCTemplate;
import com.xiehui.util.RowMapper;

public class SelectFrame extends JFrame implements ActionListener{
	
	private Object password = UserMainFrame.password;
	private Object name = UserMainFrame.name;
	private int root = UserMainFrame.root;
//	private Object password="ying",name="qin";
//	private int root=1;

	
	private JPanel contentPane;
	private JTable table;
	private JTextField thingId;
	private JTextField thingName;
	private JDBCTemplate temp = new JDBCTemplate();
	private DefaultTableModel dtm = new DefaultTableModel();
	private Vector data = new Vector();
	private Vector colname = new Vector();
	private JTextField thingRen;
	private ABSearch ab;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectFrame frame = new SelectFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectFrame() {
		
		this.setTitle("用户："+(String) name+"    库存管理界面");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/3.JPG"));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 414, 90);
		contentPane.add(tabbedPane);
//--物品编号查询-------------------------------------------		
		JPanel panel = new JPanel();
		tabbedPane.addTab("物品编号查询", null, panel, null);
		panel.setLayout(null);
		
		JLabel label = new JLabel("物品编号：");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 22, 70, 15);
		panel.add(label);
		
		thingId = new JTextField();
		thingId.setHorizontalAlignment(SwingConstants.CENTER);
		thingId.setBounds(73, 19, 125, 21);
		panel.add(thingId);
		thingId.setColumns(10);
		
		JButton buttonId = new JButton("编号查询");
		buttonId.addActionListener(this);
		buttonId.setBounds(246, 18, 153, 23);
		panel.add(buttonId);
//---物品名字查询----------------------------------------------		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("物品名字查询", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("物品名称：");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 24, 77, 15);
		panel_1.add(label_1);
		
		thingName = new JTextField();
		thingName.setHorizontalAlignment(SwingConstants.CENTER);
		thingName.setBounds(77, 21, 105, 21);
		panel_1.add(thingName);
		thingName.setColumns(10);
		
		JButton buttonName = new JButton("物品名称查询");
		buttonName.addActionListener(this);
		buttonName.setBounds(265, 20, 134, 23);
		panel_1.add(buttonName);
//--按相关工作人员查询-------------------------------------------		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("按相关工作人员查询", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblid = new JLabel("工作人员Id：");
		lblid.setHorizontalAlignment(SwingConstants.CENTER);
		lblid.setBounds(10, 21, 80, 15);
		panel_3.add(lblid);
		
		thingRen = new JTextField();
		thingRen.setHorizontalAlignment(SwingConstants.CENTER);
		thingRen.setBounds(87, 18, 123, 21);
		panel_3.add(thingRen);
		thingRen.setColumns(10);
		
		JButton buttonRen = new JButton("相关人员查询");
		buttonRen.addActionListener(this);
		buttonRen.setBounds(263, 17, 136, 23);
		panel_3.add(buttonRen);
		
		
		
		colname = new Vector();
		colname.add("表序号");
		colname.add("物品编号");
		colname.add("物品名称");
		colname.add("进销数");
		colname.add("时间");
		colname.add("人员");
//		showAll();	
		
		table = new JTable(dtm);
		table.setSize(414, 232);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 98, 414, 232);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("清除");
		button.addActionListener(this);
		button.setBounds(10, 339, 190, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("根据权限值返回操作界面");
		button_1.addActionListener(this);
		button_1.setBounds(250, 340, 174, 23);
		contentPane.add(button_1);
	}
//--thingId----thingName-------------thingRen--------------------------------------------
//-----表序号---物品编号-----物品名称---------人员------库存--------------------------------------------
	
	
	
	
	public void showRen(Object a){
		Vector alldata = new Vector();
		alldata.add("进货单");
		Vector dataj =  showAlljin();
		for(int i = 0;i < dataj.size();i++){
			Vector data1 = (Vector)dataj.get(i);
			if(a.equals(data1.get(4))){
				System.out.println("data1="+data1);
				Vector data2 = new Vector();
				data2.add(data1.get(0));
				data2.add(data1.get(1));
				data2.add(showAllmassage(data1.get(1).toString()));
				data2.add(data1.get(2));
				data2.add(data1.get(3));
				data2.add(data1.get(4));
				alldata.add(data2);
			}
			if(i==(data1.size()-1)){
				alldata.add("销售单");
			}	
		}
		
		Vector datax =  showAllxiao();
		for(int i = 0;i < datax.size();i++){
			Vector data1 = (Vector)datax.get(i);
			if(a.equals(data1.get(4))){
				System.out.println("data1="+data1);
				Vector data2 = new Vector();
				data2.add(data1.get(0));
				data2.add(data1.get(1));
				data2.add(showAllmassage(data1.get(1).toString()));
				data2.add(data1.get(2));
				data2.add(data1.get(3));
				data2.add(data1.get(4));
				alldata.add(data2);
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("alldata="+alldata);
		System.out.println("---------------------------------------------------------------------------------------------------");
		data=alldata;
		dtm.setDataVector(data, colname);
	} 
	
	public void showAll(String a){
		Vector alldata = new Vector();
		alldata.add("进货单");
		Vector dataall  = new Vector();
		dataall =  showAlljin();
		for(int i = 0;i < dataall.size();i++){
			Vector data1 = (Vector)dataall.get(i);
			if(data1.get(1).toString().equals(a)){
				System.out.println("data1="+data1);
				Vector data2 = new Vector();
				data2.add(data1.get(0));
				data2.add(data1.get(1));
				data2.add(showAllmassage(data1.get(1).toString()));
				data2.add(data1.get(2));
				data2.add(data1.get(3));
				data2.add(data1.get(4));
				alldata.add(data2);
			}
			if(i==(data1.size()-1)){
				alldata.add("销售单");
			}
		}
		System.out.println("dataall3="+dataall);
		dataall =  showAllxiao();
		for(int i = 0;i < dataall.size();i++){
			Vector data1 = (Vector)dataall.get(i);
			if(data1.get(1).toString().equals(a)){
				System.out.println("data1="+data1);
				Vector data2 = new Vector();
				data2.add(data1.get(0));
				data2.add(data1.get(1));
				data2.add(showAllmassage(data1.get(1).toString()));
				data2.add(data1.get(2));
				data2.add(data1.get(3));
				data2.add(data1.get(4));
				alldata.add(data2);
			}
			if(i==(data1.size()-1)){
				alldata.add("库存");
				}
		}
		System.out.println("dataall2="+dataall);
		dataall =  showAllkucun();
		for(int i = 0;i < dataall.size();i++){
			Vector data1 = (Vector)dataall.get(i);
			if(data1.get(1).toString().equals(a)){
				System.out.println("data1="+data1);
				Vector data2 = new Vector();
				data2.add(data1.get(0));
				data2.add(data1.get(1));
				data2.add(showAllmassage(data1.get(1).toString()));
				data2.add(data1.get(2));
				data2.add("");
				data2.add("");
				alldata.add(data2);
			
			}	
		}
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("dataall3="+dataall);
		System.out.println("alldata="+alldata);
		System.out.println("---------------------------------------------------------------------------------------------------");
		data = alldata;
		dtm.setDataVector(data, colname);
	}
	
	private Vector showAllxiao() {
		String sql = "select * from xiaodan";
		RowMapper um = new XiaoMapper();
		Object[] array={};
		Vector xiaodata = temp.query(sql,um,array);
		return xiaodata;
	}
	
	private Vector showAlljin() {
		String sql = "select * from jindan";
		RowMapper um = new JinMapper();
		Object[] array={};
		Vector jindata = temp.query(sql,um,array);
		return jindata;
	}
//---thingId----->------thingName---------------------	
	private String showAllmassage(String a) {
		String sql = "select * from thingmassage";
		RowMapper um = new MassageMapper();
		Object[] array={};
		Vector massagedata = temp.query(sql,um,array);
		for(int i =0;i < massagedata.size();i++){
			Vector data1 = (Vector) massagedata.get(i);
			if(data1.get(1).toString().equals(a)){
				String b = data1.get(2).toString();
				return b;
			}
		}
		return null;
	}
//-----------------库存----------------	
	private Vector showAllkucun() {
		String sql = "select * from kucun";
		RowMapper um = new KucunMapper();
		Object[] array={};
		Vector kudata = temp.query(sql,um,array);
		return kudata;
	}
	
	public void qingchu(){
//		thingId.setText(null);
//		thingName.setText(null);
//		thingRen.setText(null);
		data = new Vector();
		dtm.setDataVector(data, colname);
	}
	
	public void actionPerformed(ActionEvent e) {
		if("根据权限值返回操作界面".equals(e.getActionCommand())){
			if(root==1){
				
			}else if(root==2){
				
			}else if(root==3){
				
			}else if(root==4){
				
			}else{
				
			}
			this.setVisible(false);
			UserMainFrame umf = new UserMainFrame(name,password);
		}else if("编号查询".equals(e.getActionCommand())){
			qingchu();
			showAll(thingId.getText());
		}else if("物品名称查询".equals(e.getActionCommand())){
			qingchu();
			String d =showAllmassage(thingName.getText());
			if(d !=null){
				showAll(d);
			}{
				JOptionPane.showMessageDialog(null, "条件不存在！！！");
			}
			
		}else if("相关人员查询".equals(e.getActionCommand())){
			qingchu();
			showRen(thingRen.getText());
		}else if("清除".equals(e.getActionCommand())){
			thingId.setText(null);
			thingName.setText(null);
			thingRen.setText(null);
			qingchu();
		}
		
	}
}
