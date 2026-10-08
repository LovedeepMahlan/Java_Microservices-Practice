package in.pwskills.nitin.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

	private Integer cartId;
	private String cartCode;
	private Double cartCost;
}
