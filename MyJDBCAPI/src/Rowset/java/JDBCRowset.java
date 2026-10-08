package Rowset.java;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JDBCRowset {
public static void main(String[] args) {
	//Resultset is conquer Read only and type scrollable
	//RowSet is conquer updatable and type scroll sensitive
	JdbcRowSet jdbcRowSet=null;
	try {
		RowSetFactory factory=RowSetProvider.newFactory();
		jdbcRowSet = factory.createJdbcRowSet();
		jdbcRowSet.setUrl("jdbc:mysql:///pwskills_octbatch");
		jdbcRowSet.setUsername("root");
		jdbcRowSet.setPassword("mysql#123");
		jdbcRowSet.setCommand("select * from employee");
		jdbcRowSet.execute();
		System.out.println("In forward order");
		System.out.println("eid\tename\teaddress\tresume");
		while(jdbcRowSet.next()) {
			System.out.println(jdbcRowSet.getInt(1)+"\t"+jdbcRowSet.getString(2)+"\t"+jdbcRowSet.getString(3)+"t"+jdbcRowSet.getString(4));
			
		}
		System.out.println("In forward order");
		System.out.println("eid\tename\teaddress\tresume");
		while(jdbcRowSet.previous()) {
			System.out.println(jdbcRowSet.getInt(1)+"\t"+jdbcRowSet.getString(2)+"\t"+jdbcRowSet.getString(3)+"\t"+jdbcRowSet.getString(4));
		}
		jdbcRowSet.first();
		while(jdbcRowSet.next()) {
			String Resume=jdbcRowSet.getString(4);
			if(Resume==null) {
				jdbcRowSet.deleteRow();
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
