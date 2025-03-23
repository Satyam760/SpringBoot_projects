package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;
import com.nt.repository.offers.IOffersRepository;
import com.nt.repository.prod.IProductRepository;

@Service("productService")
public class ProductMgmtServiceImpl implements IProductMgmtService {
	
	@Autowired
	private IOffersRepository offersReop;
	@Autowired
	private IProductRepository productRepo;
	
	@Override
	public String registerProducts(List<Product> list) {
		productRepo.saveAll(list);
		return list.size()+" products are saved";
	}

	@Override
	public String registerOffers(List<Offers> list) {
		offersReop.saveAll(list);
		return list.size()+" offers are saved";
	}

	@Override
	public List<Product> showAllProducts() {
		
		return productRepo.findAll();
	}

	@Override
	public List<Offers> showAllOffers() {
		
		return offersReop.findAll();
	}

}
