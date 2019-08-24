import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.xiehui.mapper.UserMapper;
import com.xiehui.util.JDBCTemplate;
import com.xiehui.util.RowMapper;

public class Sqlyuju {
	private JDBCTemplate temp = new JDBCTemplate();
	private DefaultTableModel dtm = new DefaultTableModel();
	private String[] mysql= new String[5];
	private Vector data = new Vector();
	public Sqlyuju(){
		
		mysql[0]="insert into user(username,password,root) values(?,?,?)";
		mysql[1]="insert into thingmassage(thingId,thingName,jinjia,shangjia,shoujia) values(?,?,?,?,?)";
		mysql[2]="insert into kucun(thingId,number) values(?,?)";
		Vector data1 = new Vector();
		data1.add("user");
		data1.add("xie");
		data1.add("123");
		data1.add(2);
		data.add(data1);
		
		Vector data2 = new Vector();
		data2.add("user");
		data2.add("hui");
		data2.add("789");
		data2.add(4);
		data.add(data2);
	
		Vector data3 = new Vector();
		data3.add("user");
		data3.add("tian");
		data3.add("456");
		data3.add(3);
		data.add(data3);
		
		Vector data4 = new Vector();
		data4.add("user");
		data4.add("qin");
		data4.add("ying");
		data4.add(1);
		data.add(data4);
		
		Vector data5 = new Vector();
		data5.add("thingmassage");
		data5.add("1234");
		data5.add("辣条");
		data5.add("3");
		data5.add("浦江技校");
		data5.add("4");
		data.add(data5);

		Vector data6 = new Vector();
		data6.add("thingmassage");
		data6.add("1235");
		data6.add("面");
		data6.add("5");
		data6.add("浦江技校");
		data6.add("7");
		data.add(data6);

		Vector data7 = new Vector();
		data7.add("thingmassage");
		data7.add("1236");
		data7.add("粥");
		data7.add("6");
		data7.add("浦江技校");
		data7.add("10");
		data.add(data7);

		Vector data8 = new Vector();
		data8.add("kucun");
		data8.add("1234");
		data8.add("100");
		data.add(data8);

		Vector data9 = new Vector();
		data9.add("kucun");
		data9.add("1235");
		data9.add("100");
		data.add(data9);

		Vector data10= new Vector();
		data10.add("kucun");
		data10.add("1236");
		data10.add("50");
		data.add(data10);

		
		for(int j = 0;j<data.size();j++){
			Vector b = (Vector) data.get(j);
			
			
			
			
			if(b.get(0).equals("user")){
				Object[] arg={b.get(1),b.get(2),b.get(3)};
				temp.modify(mysql[0], arg);
				
			}else if(b.get(0).equals("thingmassage")){
				Object[] arg={b.get(1),b.get(2),b.get(3),b.get(4),b.get(5)};
				temp.modify(mysql[1], arg);
			}else if(b.get(0).equals("kucun")){
				Object[] arg={b.get(1),b.get(2)};
				temp.modify(mysql[2], arg);
			}else{
				System.out.println("语句出错！！！！！");
			}
		}
	// 
		System.out.println("data="+data);
		
		
	//	temp.modify(mysql[0], arg);
	}

}
