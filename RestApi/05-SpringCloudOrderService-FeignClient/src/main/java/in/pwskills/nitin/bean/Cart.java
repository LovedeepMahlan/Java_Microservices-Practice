package in.pwskills.nitin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cart {


	private Integer cartId;
	private String cartCode;
	private Double cartCost;
}
