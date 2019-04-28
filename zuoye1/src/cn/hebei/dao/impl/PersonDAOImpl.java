package cn.hebei.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.swing.text.html.HTMLDocument.Iterator;

import cn.hebei.dao.PersonDAO;
import cn.hebei.dbc.DataBaseConnection;
import cn.hebei.domain.Person;
import cn.hebei.main.BiaoGe;
import cn.hebei.main.QianTai;

public class PersonDAOImpl  implements PersonDAO {

	PreparedStatement pstmt = null;	
	DataBaseConnection dbc = null;
	
	
	
	@Override
	public void insertPerson(Person p) throws Exception {
 
		String sql = "insert into  stu  values(?,?,?,?,?)";
		try {
			dbc = new DataBaseConnection();
			pstmt = dbc.getConn().prepareStatement(sql);
			pstmt.setString(1, p.getId());
			pstmt.setString(2, p.getName());
			pstmt.setString(3, p.getSex());
			pstmt.setString(4, p.getAge());
			pstmt.setString(5, p.getDept());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		
		
		
		
	}

	@Override
	public void deletePerson(String id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM stu WHERE id=?";
		
		
		try {
			dbc = new DataBaseConnection();
			pstmt = dbc.getConn().prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbc.close();
		}

	}

	@Override
	public void  updatePerson(String alter,String alternum,String idnum ) throws Exception {
	
		
		String sql1 = null;
		switch (alter) {
		case  "name":
			 sql1 = "update stu set name =? where id = ?";
			break;
		case  "age":
			 sql1 = "update stu set age =? where id = ?";
			break;
		case  "sex":
			 sql1 = "update stu set sex =? where id = ?";
			break;
		case  "dept":
			  sql1 = "update stu set dept =? where id = ?";
			break;
			
		default:
			break;
		}
		
		
		try {
			
			
			    dbc = new DataBaseConnection();
				pstmt = dbc.getConn().prepareStatement(sql1);
				
				pstmt.setString(1, alternum);
				pstmt.setString(2, idnum);
				pstmt.executeUpdate();
				
				
				pstmt.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		
		
		
		
		
		

	}

	@Override
	public Person selectById(String id) throws Exception {
		// TODO Auto-generated method stub
		Person p = null;
		dbc = new DataBaseConnection();
		String sql = "select * from stu where id =" + id;
		Statement st = dbc.getConn().createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
         
			p = new Person(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));
			
		}
		
		rs.close();
		st.close();
		return p;
	}

	@Override
	public void selectAll() throws Exception {
		// TODO Auto-generated method stub
		List li =new ArrayList<String>();
		String sql = "select * from stu";
		dbc = new DataBaseConnection();
		Statement st = dbc.getConn().createStatement();
		ResultSet rs = st.executeQuery(sql);
		 
		
		  
			
		  int count = 0;
		  while(rs.next())
		  {
			  count++;
		  }
		  String str [][]  = new String[count][5];
		  
           count=0;
           
           rs.beforeFirst();//注意之前rs已经指向底部，应该将其放到顶端
           
		  while(rs.next())
		  {
			  
			 
				str[count][0]= rs.getString("id");
				str[count][1]= rs.getString("name");
				str[count][2]= rs.getString("sex");
				str[count][3]= rs.getString("age");
				str[count][4]= rs.getString("dept"); 
			  
			  count++;
			  
		  }
		  
		  
			
			System.out.println(count);
				
				new BiaoGe(str);
				
				rs.close();
				st.close();
	
		
		
		
		
		
		
		
		
	}

}
