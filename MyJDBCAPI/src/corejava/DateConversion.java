package corejava;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConversion {
public static void main(String[] args) throws ParseException {
	String indianUser="12-04-2023";
	SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
	java.util.Date jvd=sdf.parse(indianUser);
	long inputms=jvd.getTime();
	java.sql.Date jsq=new Date(inputms);
	System.out.println("Acc to indian user Date is ::"+jsq);
	String ChinaUser="2023-04-23";
	Date d=Date.valueOf(ChinaUser);
	System.out.println("Acc to china user Date is ::" +d);
}
}
