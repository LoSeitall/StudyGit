package com.oracle.sjgl.service;

import java.util.List;

import com.oracle.sjgl.dao.ProductMapper;
import com.oracle.sjgl.dao.SkuMapper;
import com.oracle.sjgl.dao.StockMapper;
import com.oracle.sjgl.po.Product;
import com.oracle.sjgl.po.Sku;
import com.oracle.sjgl.po.Stock;
import com.oracle.sjgl.util.DateFormat;
import com.oracle.sjgl.util.LimitNum;
import com.oracle.sjgl.util.PageUtil;
import com.oracle.sjgl.util.getSession;

public class ProductService {
	
	private static getSession gs = new getSession();
	
	public int StockCount(){
		
		List<Stock> sl = gs.getSession().getMapper(StockMapper.class).stockCount();
		
		gs.closeSession();
		
		return sl.size();
		
	} 
	
    public Stock selectStockByPrimaryKey(String stid){
		
		int id = Integer.parseInt(stid);
		
		Stock stock = gs.getSession().getMapper(StockMapper.class).selectByPrimaryKey(id);
		
		gs.closeSession();
		
		return stock;
	}

	public void deleteByPrimaryKey(Stock stock){
		
		gs.getSession().getMapper(StockMapper.class).updateByPrimaryKey(stock);
		
		gs.closeSession();
		
	}	
	
	public PageUtil selectAllStock(int pageno,int size){
		
		PageUtil pu = new PageUtil();
		
		LimitNum ln = new LimitNum();
		
		ln.setSize(size);
		
		ln.setLimitnum((pageno-1)*size);
		
		List<Stock> sl = gs.getSession().getMapper(StockMapper.class).selectAll(ln);
		
		pu.setList(sl);
		
		pu.init(pageno, StockCount() , size,"SelectStockListServlet");
		
		gs.closeSession();
		
		return pu;
	}
	
	public void updateByPrimaryKey(Stock stock){
		
		gs.getSession().getMapper(StockMapper.class).updateByPrimaryKey(stock);
		
		gs.closeSession();
		
	}
	
	public void insertSelective(Stock stock){
		
		gs.getSession().getMapper(StockMapper.class).insertSelective(stock);
		
		gs.closeSession();
		
	}
	
	public static int ProductCount(){
		
		List<Product> pl = gs.getSession().getMapper(ProductMapper.class).ProductCount();
		
		gs.closeSession();
		
		return pl.size();
	}
	
	public void updateProduct(Product product){
		
		gs.getSession().getMapper(ProductMapper.class).updateByPrimaryKeySelective(product);
		
		gs.closeSession();
		
	}
	
	public void deleteProductById(Product product){
		
		gs.getSession().getMapper(ProductMapper.class).updateByPrimaryKey(product);
		
		gs.closeSession();
		
	}
	
	public int ProductCountCondition(Product product){
		
		return gs.getSession().getMapper(ProductMapper.class).ProductCountCondition(product).size();
	
	}
	
	public PageUtil selectProductByCondition(int pageno,int size,Product product){
	
		
		PageUtil pu = new PageUtil();
		
		product.setSize(size);
		
		product.setLimitnum((pageno-1)*size);
		
		List<Product> productlist = gs.getSession().getMapper(ProductMapper.class).selectProductByCondition(product);
		
		for (Product p : productlist) {
			p.setStime(DateFormat.changeDate(p.getTime()));
		}
		
		pu.setList(productlist);
		
		pu.init(pageno, ProductCountCondition(product) , size,"SelectProductListByConditionServlet");
		
		gs.closeSession();
		
		return pu;
	}
	
	public PageUtil selectAllProduct(int pageno,int size){
		
		PageUtil pu = new PageUtil();
		
		LimitNum ln = new LimitNum();
		
		ln.setSize(size);
		
		ln.setLimitnum((pageno-1)*size);
		
		List<Product> productlist = gs.getSession().getMapper(ProductMapper.class).selectAll(ln);
		
		for (Product product : productlist) {
			product.setStime(DateFormat.changeDate(product.getTime()));
		}
		
		pu.setList(productlist);
		
		pu.init(pageno, ProductCount() , size,"SelectProductListServlet");
		
		gs.closeSession();
		
		return pu;
	}
	
	public Product selectProductByPrimaryKey(int pid){
		
		Product product = gs.getSession().getMapper(ProductMapper.class).selectByPrimaryKey(pid);
		
		product.setStime(DateFormat.changeDate(product.getTime()));
		
		gs.closeSession();
		
		return product;
	}
	
	public List<Sku> selectAllSku(){
		
		List<Sku> skulist = gs.getSession().getMapper(SkuMapper.class).selectAll();
		
		gs.closeSession();
		
		return skulist;
	}
	
	public Sku selectByPrimaryKey(String skuid){
		
		int id = Integer.parseInt(skuid);
		
		Sku sku = gs.getSession().getMapper(SkuMapper.class).selectByPrimaryKey(id);
		
		gs.closeSession();
		
		return sku;
	}
	
	public void deleteByPrimaryKey(Sku sku){
		
		gs.getSession().getMapper(SkuMapper.class).updateByPrimaryKey(sku);
		
		gs.closeSession();
		
	}
	
	public void updateByPrimaryKey(Sku sku){
		
		gs.getSession().getMapper(SkuMapper.class).updateByPrimaryKey(sku);
		
		gs.closeSession();
		
	}
	
	public void insertSelective(Sku sku){
		
		gs.getSession().getMapper(SkuMapper.class).insertSelective(sku);
		
		gs.closeSession();
	}
	
	public void insert(Sku sku){
		
		gs.getSession().getMapper(SkuMapper.class).insert(sku);
		
		gs.closeSession();
		
	}

	public void insertProductSelective(Product p) {
		
		gs.getSession().getMapper(ProductService.class).insertProductSelective(p);
		
		gs.closeSession();
		
	}
	
	
}
