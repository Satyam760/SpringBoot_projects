package com.nt.service;

import java.util.List;

import com.nt.document.StockDetails;

public interface IStockMgmtService {
	public String registerStockDetails(StockDetails details);
	public String registerStockDetailBatch(List<StockDetails> list);
	
	public List<StockDetails> fetchStockDetailsByPriceRange(Double start,Double end);
	public List<StockDetails> fetchStockDetailsByExchange(String exchange);
	public String fetchAndUpdateStockByStockId(int stockId,double newPrice,String newExchangeName);
	
	
	
}
