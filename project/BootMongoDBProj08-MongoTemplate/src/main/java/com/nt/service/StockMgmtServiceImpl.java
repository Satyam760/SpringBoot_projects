package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.nt.document.StockDetails;

@Service("stockService")
public class StockMgmtServiceImpl implements IStockMgmtService {

	@Autowired
	private MongoTemplate template;
	
	@Override
	public String registerStockDetails(StockDetails details) {
		int idVal=template.save(details,"Stock").getStockId(); //given doc object data will saved by creating collection called 'Stock'
		//int idVal=template.save(details).getStockId(); //given doc object data will saved by creating collection with document class name
		//int idVal=template.insert(details).getStockId(); //given doc object data will saved by creating collection with document class name
		return "Document is saved with id Value :: "+idVal;
	}

	@Override
	public String registerStockDetailBatch(List<StockDetails> list) {
		int size=template.insertAll(list).size();
		return size +" no.of documents are saved";
	}

	@Override
	public List<StockDetails> fetchStockDetailsByPriceRange(Double start, Double end) {
		Query query=new Query();
		query.addCriteria(Criteria.where("price").gte(start).lte(end));
		List<StockDetails>list= template.find(query,StockDetails.class);
		return list;
	}

	@Override
	public List<StockDetails> fetchStockDetailsByExchange(String exchange) {
		Query query=new Query();
		query.addCriteria(Criteria.where("exchangeName").is(exchange));
		List<StockDetails>list= template.find(query,StockDetails.class);
		return list;
	}

	@Override
	public String fetchAndUpdateStockByStockId(int stockId, double newPrice, String newExchangeName) {
		Query query=new Query();
		query.addCriteria(Criteria.where("stockId").is(stockId));
		//update object for modification
		Update update=new Update();
		update.set("price",newPrice);
		update.set("exchangeName", newExchangeName);
		//call the method
		StockDetails details=template.findAndModify(query, update,StockDetails.class);
		return details==null?"stock is not found":"stock found and updated";
	}

}
