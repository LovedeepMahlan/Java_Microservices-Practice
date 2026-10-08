package Rowset.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import jdbconnection.MakeConnection_1;

public class CachedRowSetApp {

	public static void main(String[] args) {
		Connection connection=null;
		Statement stmt=null;
		ResultSet Res=null;
		CachedRowSet Cachedrow=null;
		try {
			connection=MakeConnection_1.dbConnection();
			stmt=connection.createStatement();
			Res=stmt.executeQuery("select * from employee");
			RowSetFactory factory=RowSetProvider.newFactory();
			Cachedrow=factory.createCachedRowSet();
			Cachedrow.populate(Res);
			connection.close();
			/*this gives compile error because connection has been closed and ResultSet 
			  is not working without connection but CatchedRow will work without connection
			while(Res.next()) {
				System.out.println(Res.getInt(1)+"\t"+Res.getString(2)+"\t"+Res.getString(3)+"t"+Res.getString(4));
			}
			*/
			System.out.println("eid\tename\teaddress\tresume");

			while(Cachedrow.next()) {
				System.out.println(Cachedrow.getInt(1)+"\t"+Cachedrow.getString(2)+"\t"+Cachedrow.getString(3)+"t"+Cachedrow.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
