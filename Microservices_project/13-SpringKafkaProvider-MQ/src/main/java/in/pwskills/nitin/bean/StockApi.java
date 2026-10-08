package in.pwskills.nitin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockApi {

	private Integer stkId;
	private String stkCode;
	private Double stkCost;

}
