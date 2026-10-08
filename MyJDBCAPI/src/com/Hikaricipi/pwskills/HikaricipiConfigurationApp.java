package com.Hikaricipi.pwskills;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikaricipiConfigurationApp {
	public static void main(String[] args) {
		
		
		String info="D:\\octoberbatch\\src\\com\\Hikaricipi\\pwskills\\Hikaricipi.properties";
		HikariConfig hiscog=new HikariConfig(info);
		try(HikariDataSource hds=new HikariDataSource(hiscog)){
			try(Connection con=hds.getConnection()){
				try(Statement stmt=con.createStatement()){
					try(ResultSet rs=stmt.executeQuery("select * from employee")){
						System.out.println("eid  ename    eadress     resume");
						while(rs.next()) {
							System.out.println(rs.getInt(1) + "    "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
