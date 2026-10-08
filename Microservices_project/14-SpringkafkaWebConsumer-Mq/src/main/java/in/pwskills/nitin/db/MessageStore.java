package in.pwskills.nitin.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.StockApi;
import in.pwskills.nitin.convertor.ObjectConvertor;
import in.pwskills.nitin.repository.IStockREpo;

@Component
public class MessageStore {

	@Autowired
	IStockREpo repo;
	
	public void addObj(String message) {
		StockApi sapi=ObjectConvertor.JsontoJava(message);
		repo.save(sapi);
		System.out.println("Object saved in database");
	}
	
	public List<StockApi> getAllObj() {
		List<StockApi> stock=repo.findAll();
		System.out.println(stock);
		return stock;
		
	}
}
