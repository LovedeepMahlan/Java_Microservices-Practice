package in.pwskills.nitin.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorReponse {

	private Date date;
	private String status;
	private int code;
	private String message;
}
