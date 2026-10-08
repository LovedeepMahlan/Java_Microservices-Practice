package Rowset.java;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.mysql.cj.xdevapi.RowFactory;

import jdbconnection.MakeConnection_1;

public class JoinrowSetApp {
public static void main(String[] args) {
	Connection connection=null;
	CachedRowSet cached1=null;
	CachedRowSet cached2=null;
	JoinRowSet joinroset=null;
	try {
		connection=MakeConnection_1.dbConnection();
		RowSetFactory factory=RowSetProvider.newFactory();
		cached1=factory.createCachedRowSet();
		cached1.setCommand("select * from Learner");
		cached2=factory.createCachedRowSet();
		cached1.setCommand("select * from Course");
		cached1.execute();
		cached2.execute();
		joinroset=factory.createJoinRowSet();
		joinroset.addRowSet(cached1,2);
		joinroset.addRowSet(cached2,3);
		while(joinroset.next()) {
			System.out.println();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
