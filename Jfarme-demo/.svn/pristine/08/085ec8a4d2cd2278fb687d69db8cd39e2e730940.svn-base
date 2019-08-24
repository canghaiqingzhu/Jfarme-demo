package com.xiehui.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.xiehui.mapper.UserMapper;
import com.xiehui.util.RowMapper;
import com.xiehui.util.JDBCTemplate;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class UserMainFrame{
	public static Object name,password;
	int id;
	public static int root;

	public UserMainFrame(Object name,Object password){
		this.name = name;
		this.password = password;
		System.out.println(name+"------5-----"+password);
		UserFrame um = new UserFrame();
		Vector data = um.fanRoot(name,password);
		Object data1 = data.get(0);
		
		Object c =((Vector) data1).get(0);
		String b = c.toString();
		id = Integer.parseInt(b);
		System.out.println("id="+id);
		
		Object v =((Vector) data1).get(3);
		String a = v.toString();
		root = Integer.parseInt(a);
		System.out.println("root="+root);
		if(root==1){
			UserFrame frame = new UserFrame();
			frame.setVisible(true);
		}else if(root == 2){
			JinFrame abf = new JinFrame();
			abf.setVisible(true);
		}else if(root == 3){
			XiaoFrame abcf = new XiaoFrame();
			abcf.setVisible(true);
		}else if(root == 4){
			KuFrame kf = new KuFrame();
			kf.setVisible(true);
		}else{
			System.out.println("数据有误！！！");
		}
		
	}


	
	
}
