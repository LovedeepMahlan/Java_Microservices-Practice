package in.compney.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import in.compney.dataObjects.StudentBO;
import in.compney.utility.MakeConnection;

public class StudenrRepositoryIclass implements StudentRepository {
	private static final String Insert_Query = "insert into student(`sid`,`sname`,`sage`,`saddress`)values(?,?,?,?)";
	private static final String Read_Query = "select * from student where `sid`=?";
	private static final String delete_Query="delete from student where `sid`=?";
	private static final String Update_Query="update student set `sname`=? ,`sage`=? ,`saddress`=? where sid=?";
	private static Connection connection=null;
	
	private static PreparedStatement insertstmt=null;
	private static PreparedStatement readstmt=null;
	private static PreparedStatement deletestmt=null;
	private static PreparedStatement updatestmt=null;
	static {
		try {
			connection=MakeConnection.getConnection();
			if(connection!=null) {
				insertstmt=connection.prepareStatement(Insert_Query);
				readstmt=connection.prepareStatement(Read_Query);
				updatestmt=connection.prepareStatement(Update_Query);
				deletestmt=connection.prepareStatement(delete_Query);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String InsertRecord(StudentBO stdbo) {
		String status=null;
		if(insertstmt!=null) {
			try {
				insertstmt.setInt(1, stdbo.getSid());
				insertstmt.setString(2,stdbo.getSname());
				insertstmt.setInt(3, stdbo.getSage());
				insertstmt.setString(4,stdbo.getSaddress());
				int rowcount=insertstmt.executeUpdate();
				if(rowcount!=0) {
					status="success";
				}else {
					status="Some error has been occured";
				}
			} catch (SQLException se) {
				int errorCode = se.getErrorCode();
				if (errorCode == 1064) {
					status = "some error in db operation";
				} else if (errorCode == 2006) {
					status = "connection lost at dbside";
				} else if (errorCode == 1045) {
					status = "acess denied for the user wrong credentialsm";
				} else if (errorCode == 1044) {
					status = "access denied for the user to database";
				} else {
					status = "Some Error at database side";
				}
				System.out.println(se);
			} catch (Exception e) {
				status = "Some Unknown Exception ";
				return status;
			}
		}
			return status;
		}

	@Override
	public StudentBO readRecord(Integer sid) {
		StudentBO stdbo=null;
		try {
			if(readstmt!=null) {
				readstmt.setInt(1, sid);
				ResultSet rs=readstmt.executeQuery();
				if(rs.next()) {
					stdbo=new StudentBO();
					stdbo.setSid(rs.getInt(1));
					stdbo.setSname(rs.getString(2));
					stdbo.setSage(rs.getInt(3));
					stdbo.setSaddress(rs.getString(4));
					System.out.println(stdbo);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return stdbo;
	}

	@Override
	public String deleteRecord(Integer sid) {
		String str=null;
		StudentBO stdbo=readRecord(sid);
		if(stdbo!=null) {
			if(deletestmt!=null) {
				try {
					deletestmt.setInt(1, sid);
					Integer a=deletestmt.executeUpdate();
					if(a!=0) {
						str="success";
					}else {
						str="Sorry some error has been occured";
					}
				} catch (SQLException e) {
					str="you are facing an SQLException";
					e.printStackTrace();
				}
			}
		}
		return str;
	}

	@Override
	public String updateRecord(StudentBO stdbo) {
		String status=null;
		if(updatestmt!=null) {
			try {
				updatestmt.setString(1,stdbo.getSname());
				updatestmt.setString(3, stdbo.getSaddress());
				updatestmt.setInt(2, stdbo.getSage());
				updatestmt.setInt(4,stdbo.getSid());
				int a=updatestmt.executeUpdate();
				if(a!=0) {
					status="success";
				}else {
					status="data not found for given id";
				}
			} catch (SQLException e) {
				status="you are facing an SQlException";
				e.printStackTrace();
			}
		}
		return status;
	}
}
