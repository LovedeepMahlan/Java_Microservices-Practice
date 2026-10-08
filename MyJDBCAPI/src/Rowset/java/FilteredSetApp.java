package Rowset.java;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

class WorkerFilter implements Predicate{
	int low;
	int high;
	public WorkerFilter(int low, int high) {
		super();
		this.low = low;
		this.high = high;
	}
	@Override
	public boolean evaluate(RowSet rs) {
		FilteredRowSet fis=(FilteredRowSet)rs;
		boolean eval=false;
		try {
			int wsallary=rs.getInt(3);
			if(wsallary>low && wsallary<high) {
				eval=true;
			}else {
				eval=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eval;
	}
	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		return false;
	}
	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
public class FilteredSetApp {
	public static void main(String[] args) {
		FilteredRowSet fis=null;
		try {
			RowSetFactory factory=RowSetProvider.newFactory();
			fis=factory.createFilteredRowSet();
			fis.setUrl("jdbc:mysql:///pwskills_octbatch");
			fis.setUsername("root");
			fis.setPassword("mysql#123");
			fis.setCommand("Select * from worker");
			fis.execute();
			while(fis.next()) {
				System.out.println(fis.getInt(1)+"\t"+fis.getString(2)+"\t"+fis.getInt(3));
			}
			fis.beforeFirst();
			WorkerFilter filter=new WorkerFilter(12000, 17000);
			fis.setFilter(filter);
			System.out.println("Filtered by FilteredSet");
			while(fis.next()) {
				System.out.println(fis.getInt(1)+"\t"+fis.getString(2)+"\t"+fis.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
