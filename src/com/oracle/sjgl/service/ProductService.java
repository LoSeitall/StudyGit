package com.oracle.sjgl.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import com.google.gson.Gson;
import com.oracle.sjgl.dao.EmpMapper;
import com.oracle.sjgl.dao.ProductMapper;
import com.oracle.sjgl.dao.SellOrderMapper;
import com.oracle.sjgl.dao.SkuMapper;
import com.oracle.sjgl.dao.StockMapper;
import com.oracle.sjgl.po.CaiGouTable;
import com.oracle.sjgl.po.KuCunTable;
import com.oracle.sjgl.po.Product;
import com.oracle.sjgl.po.SellOrder;
import com.oracle.sjgl.po.SellOrderTable;
import com.oracle.sjgl.po.Sku;
import com.oracle.sjgl.po.Stock;
import com.oracle.sjgl.util.DateFormat;
import com.oracle.sjgl.util.LimitNum;
import com.oracle.sjgl.util.PageUtil;
import com.oracle.sjgl.util.getSession;

public class ProductService {
	
	private static getSession gs = new getSession();

	//查询采购订单的数量(在指定条件下)
	public int StockCountcondition(Stock stock){
		
		List<Stock> sl = gs.getSession().getMapper(StockMapper.class).StockConditionCount(stock);
		
		gs.closeSession();
		
		return sl.size();
		
	}

	//查询采购订单的数量
	public int StockCount(){
		
		List<Stock> sl = gs.getSession().getMapper(StockMapper.class).stockCount();
		
		gs.closeSession();
		
		return sl.size();
		
	} 

	//通过主键查询指定库存信息
    public Sku selectSkuByPid(String pid,String shop){
    	
    	int id = Integer.parseInt(pid);
    	
    	Sku temp = new Sku();
    	
    	temp.setPid(id);
    	
    	temp.setShop(shop);
    	
    	Sku s = gs.getSession().getMapper(SkuMapper.class).selectByPid(temp);
    	
    	gs.closeSession();
    	
    	return s;
    }

    //通过主键查询指定销售订单信息
	public Stock selectStockByPrimaryKey(String stid){
		
		int id = Integer.parseInt(stid);
		
		Stock stock = gs.getSession().getMapper(StockMapper.class).selectByPrimaryKey(id);
		
		stock.setStime(DateFormat.changeDate(stock.getTime()));
		
		gs.closeSession();
		
		return stock;
	}

	//删除销售订单信息(软删除)
	public void deleteByPrimaryKey(Stock stock){
		
		gs.getSession().getMapper(StockMapper.class).updateByPrimaryKeySelective(stock);
		
		gs.closeSession();
		
	}	
	
	//查询销售订单信息列表(条件查询)
	public PageUtil selectAllStockByCondition(int pageno,int size,Stock stock){
		
		PageUtil pu = new PageUtil();
		
		stock.setSize(size);
		
		stock.setLimitnum((pageno-1)*size);
		
		List<Stock> sl = gs.getSession().getMapper(StockMapper.class).selectAllBycondition(stock);
		
		for (Stock s : sl) {
			s.setStime(DateFormat.changeDate(s.getTime()));
		}
		
		
		pu.setList(sl);
		
		pu.init(pageno, StockCount() , size,"SelectStockListByConditionServlet");
		
		gs.closeSession();
		
		return pu;
	}

    //查询销售订单信息列表
	public PageUtil selectAllStock(int pageno,int size){
		
		PageUtil pu = new PageUtil();
		
		LimitNum ln = new LimitNum();
		
		ln.setSize(size);
		
		ln.setLimitnum((pageno-1)*size);
		
		List<Stock> sl = gs.getSession().getMapper(StockMapper.class).selectAll(ln);
		
		for (Stock stock : sl) {
			stock.setStime(DateFormat.changeDate(stock.getTime()));
		}
		
		pu.setList(sl);
		
		pu.init(pageno, StockCount() , size,"SelectStockListServlet");
		
		gs.closeSession();
		
		return pu;
	}
	
	//更新销售订单信息
	public void updateByPrimaryKey(Stock stock){
		
		gs.getSession().getMapper(StockMapper.class).updateByPrimaryKey(stock);
		
		gs.closeSession();
		
	}

	//新增一条销售订单信息(可缺省属性)
	public void insertSelective(Stock stock){
		
		gs.getSession().getMapper(StockMapper.class).insertSelective(stock);
		
		gs.closeSession();
		
	}

	//返回商品信息总数量
	public static int ProductCount(){
		
		List<Product> pl = gs.getSession().getMapper(ProductMapper.class).ProductCount();
		
		gs.closeSession();
		
		return pl.size();
	}

	//更新商品信息
	public void updateProduct(Product product){
		
		gs.getSession().getMapper(ProductMapper.class).updateByPrimaryKeySelective(product);
		
		gs.closeSession();
		
	}

	//删除指定的商品信息(软删除)
	public void deleteProductById(Product product){
		
		gs.getSession().getMapper(ProductMapper.class).updateByPrimaryKey(product);
		
		gs.closeSession();
		
	}

	//返回商品信息总数量(条件查询)
	public int ProductCountCondition(Product product){
		
		return gs.getSession().getMapper(ProductMapper.class).ProductCountCondition(product).size();
	
	}

	//查询商品信息列表(条件查询)
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

    //查询商品信息列表
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
	
	//通过主键查询一条商品信息
	public Product selectProductByPrimaryKey(int pid){
		
		Product product = gs.getSession().getMapper(ProductMapper.class).selectByPrimaryKey(pid);
		
		product.setStime(DateFormat.changeDate(product.getTime()));
		
		gs.closeSession();
		
		return product;
		
	}

	//返回库存信息总条数
	public int selectAllCount(){
		
		List<Sku> sl = gs.getSession().getMapper(SkuMapper.class).selectAllCount();
		
		return sl.size();
		
	}

	//查询库存信息列表
	public PageUtil selectAllSku(int pageno,int size){
		
		PageUtil pu = new PageUtil();
		
		LimitNum ln = new LimitNum(size, (pageno-1)*size);
		
		List<Sku> sl = gs.getSession().getMapper(SkuMapper.class).selectAll(ln);
		
		pu.setList(sl);
		
		pu.init(pageno, selectAllCount() , size,"SelectAllSkuServlet");
		
		gs.closeSession();
		
		return pu;
		
	}

    //通过主键查询一条库存信息
	public Sku selectByPrimaryKey(String skuid){
		
		int id = Integer.parseInt(skuid);
		
		Sku sku = gs.getSession().getMapper(SkuMapper.class).selectByPrimaryKey(id);

		gs.closeSession();
		
		return sku;
		
	}
	
	//删除一条库存信息(条件查询)
	public void deleteByPrimaryKey(Sku sku){
		
		gs.getSession().getMapper(SkuMapper.class).updateByPrimaryKeySelective(sku);
		
		gs.closeSession();
		
	}
	
	//更新一条库存信息
	public void updateByPrimaryKey(Sku sku){
		
		gs.getSession().getMapper(SkuMapper.class).updateByPrimaryKeySelective(sku);
		
		gs.closeSession();
		
	}
	
	//通过商品PID更新库存信息
	public void updateByPid(Sku sku){

		gs.getSession().getMapper(SkuMapper.class).updateByPidSelective(sku);
		
		gs.closeSession();
		
	}
	
	//新增一条库存信息(可缺省属性)
	public void insertSelective(Sku sku){
		
		Sku s = selectSkuByPid(sku.getPid().toString(),sku.getShop());
		
		if(s==null){
			
			gs.getSession().getMapper(SkuMapper.class).insertSelective(sku);
			
			gs.closeSession();
			
			return;
			
		}
		
		if(s.getPid()==sku.getPid()){
			
			int sum = s.getSkuNum()+sku.getSkuNum();
			
			sku.setSkuNum(sum);
			
			sku.setSkuid(s.getSkuid());
			
			updateByPrimaryKey(sku);
			
		}else{
		
			gs.getSession().getMapper(SkuMapper.class).insertSelective(sku);
		
			gs.closeSession();
			
		}
	}

    //新增一条库存信息
	public void insert(Sku sku){
		
		gs.getSession().getMapper(SkuMapper.class).insert(sku);
		
		gs.closeSession();
		
	}

    //新增一条商品信息(可缺省属性)
	public void insertProductSelective(Product p) {
		
		gs.getSession().getMapper(ProductService.class).insertProductSelective(p);
		
		gs.closeSession();
		
	}
	
	//查询销售订单信息列表
	public int selectAllOrderCount(){
		
		return gs.getSession().getMapper(SellOrderMapper.class).selectAllCount().size();
		
	}

	//通过主键查询一条销售订单信息
	public SellOrder selectOneOrder(int oid){
		
		SellOrder so = gs.getSession().getMapper(SellOrderMapper.class).selectByPrimaryKey(oid);
		
		so.setStime(DateFormat.changeDate(so.getTime()));
		
		return so;
		
	}

	//查询销售订单信息总条数
	public int selectByConditionCount(SellOrder so){
		
		return gs.getSession().getMapper(SellOrderMapper.class).selectAllByConditionCount(so).size();
		
	}

    //查询销售订单信息列表(条件查询)
	public PageUtil selectAllOrderByCondition(int pageno,int size,SellOrder so){
		
		PageUtil pu = new PageUtil();
		
		so.setLimitnum(size*(pageno-1));
		
		so.setSize(size);
		
		List<SellOrder> list = gs.getSession().getMapper(SellOrderMapper.class).selectAllByCondition(so);
		
		for (SellOrder sellOrder : list) {
			sellOrder.setStime(DateFormat.changeDate(sellOrder.getTime()));
		}
		
		pu.setList(list);
		
		pu.init(pageno, selectAllOrderCount(), size, "SelectSellOrderByConditionServlet");
		
		return pu;
		
	}

    //查询销售订单信息列表
	public PageUtil selectAllOrder(int pageno,int size){
		
		PageUtil pu = new PageUtil();
		
		LimitNum ln = new LimitNum(size, (pageno-1)*size);
		
		List<SellOrder> list = gs.getSession().getMapper(SellOrderMapper.class).selectAll(ln);
		
		for (SellOrder sellOrder : list) {
			sellOrder.setStime(DateFormat.changeDate(sellOrder.getTime()));
		}
		
		pu.setList(list);
		
		pu.init(pageno, selectAllOrderCount(), size, "SelectSellOrderServlet");
		
		return pu;
	
	}

	//通过PID更新销售订单信息
	public void updateOrderByPid(SellOrder so){
		
		gs.getSession().getMapper(SellOrderMapper.class).updateByPrimaryKeySelective(so);
		
		gs.closeSession();
		
	}

	//更新销售订单信息
	public void updateOrder(SellOrder so){
			
		gs.getSession().getMapper(SellOrderMapper.class).updateByPrimaryKeySelective(so);
		
		gs.closeSession();
		
	}

	//删除销售订单信息(软删除)
	public void deleteOrder(SellOrder so){
	
		gs.getSession().getMapper(SellOrderMapper.class).updateByPrimaryKeySelective(so);
		
		gs.closeSession();
		
	}

	//新增一条销售订单信息(可缺省属性)
	public void insertOrder(SellOrder so){
		
		Sku sku = selectSkuByPid(so.getPid().toString(),so.getShop());
			
		if(sku.getSkuNum()>0&&sku.getSkuNum()!=null){
			
			sku.setSkuNum(sku.getSkuNum()-so.getCount());
			
			updateByPrimaryKey(sku);
			
			gs.getSession().getMapper(SellOrderMapper.class).insertSelective(so);
			
			gs.closeSession();
			
		}

		
	}

	//采购统计表报的排序去重并返回json至前台页面
	@SuppressWarnings("deprecation")
	public String CaiGouJson(){
		
		List<CaiGouTable> cgl = new ArrayList<>();
		List<Stock> sl = gs.getSession().getMapper(StockMapper.class).stockCount();
		Collections.sort(sl, (o1,o2)->o1.getTime().compareTo(o2.getTime()));
		List<Integer> il = new ArrayList<>();
		Gson gson = new Gson();
		
		for (Stock stock : sl) {
			for (int i=0;i<12;i++) {
				il.add(0);
			}
			int pid = stock.getPid();
			String name = selectProductByPrimaryKey(pid).getSupplier();
			for (int i=0;i<sl.size();i++) {
				if(sl.get(i).getPid()==stock.getPid()){
					il.set(sl.get(i).getTime().getMonth(),sl.get(i).getCount());
				}
			}
			if(il.size()>12){
				il.remove(0);
			}
			List<Integer> templist = new ArrayList<>();
			templist.addAll(il);
			il.clear();
			cgl.add(new CaiGouTable(name,templist));
		}
		
		Set<CaiGouTable> caiset = new TreeSet<>((o1,o2)->o1.getName().compareTo(o2.getName()));
		caiset.addAll(cgl);
		List<CaiGouTable> templist = new ArrayList<CaiGouTable>(caiset);
		String json = gson.toJson(templist);
		System.out.println(json);
		return json;
		
	}

    //库存统计表报的去重并返回json至前台页面
	public String kuCunTuJson(){
		
		List<KuCunTable> kucunlist = new ArrayList<>();
		int sum = 0;
		List<Sku> skulist = gs.getSession().getMapper(SkuMapper.class).selectAllCount();
		
		for (Sku sku : skulist) {
			sum += sku.getSkuNum();	
		}
		
		for (Sku sku2 : skulist) {
			int pid = sku2.getPid();
			double si = 0;
			String name = selectProductByPrimaryKey(pid).getSupplier();
			for (Sku temp : skulist) {
				if(temp.getPid()==sku2.getPid()){
					si += temp.getSkuNum();
				}
			}
			kucunlist.add(new KuCunTable(name, si/sum, true, true));			
		}
		
		Set<KuCunTable> skct = new TreeSet<>((o1,o2)->o1.getName().compareTo(o2.getName()));
		skct.addAll(kucunlist);
		List<KuCunTable> templist = new ArrayList<>(skct);
		Gson gson = new Gson();
		String json = gson.toJson(templist);
		System.out.println(json);
		return json;
		
	}

    //销售统计表报的排序去重并返回json至前台页面
	@SuppressWarnings("deprecation")
	public String SellOrderTableJson(){
		
		List<SellOrder> sol = gs.getSession().getMapper(SellOrderMapper.class).selectAllCount();
		List<SellOrderTable> sot = new ArrayList<>();
		Collections.sort(sol, (o1,o2)->o1.getTime().compareTo(o2.getTime()));
		Gson gson = new Gson();
		List<Integer> il = new ArrayList<>();
		
		for (SellOrder so : sol) {
			for (int i=0;i<12;i++) {
				il.add(0);
			}
			int pid = so.getPid();
			String name = selectProductByPrimaryKey(pid).getSupplier();
			for (int i=0;i<sol.size();i++) {
				if(sol.get(i).getPid()==so.getPid()){
					il.set(sol.get(i).getTime().getMonth(),sol.get(i).getCount());
				}
			}
			if(il.size()>12){
				il.remove(0);
			}
			List<Integer> templist = new ArrayList<>();
			templist.addAll(il);
			il.clear();
			sot.add(new SellOrderTable(name, templist));
			
		}
		
		Set<SellOrderTable> caiset = new TreeSet<>((o1,o2)->o1.getName().compareTo(o2.getName()));
		caiset.addAll(sot);
		List<SellOrderTable> templist = new ArrayList<>(caiset);
		String json = gson.toJson(templist);
		System.out.println(json);
		return json;
		
	}

    //统计表报的排序去重并返回json至前台页面
	@SuppressWarnings("deprecation")
	public String XiaoShouJson(){
		
		List<SellOrder> sol = gs.getSession().getMapper(SellOrderMapper.class).selectAllCount();
		List<SellOrderTable> sot = new ArrayList<>();
		Collections.sort(sol, (o1,o2)->o1.getTime().compareTo(o2.getTime()));
		Gson gson = new Gson();
		List<Integer> il = new ArrayList<>();
		
		for (SellOrder so : sol) {
			for (int i=0;i<12;i++) {
				il.add(0);
			}
			//int pid = so.getPid();
			String name = gs.getSession().getMapper(EmpMapper.class).selectByPrimaryKey(so.getEid()).getEname();
			for (int i=0;i<sol.size();i++) {
				if(sol.get(i).getPid()==so.getPid()){
					il.set(sol.get(i).getTime().getMonth(),sol.get(i).getCount());
				}
			}
			if(il.size()>12){
				il.remove(0);
			}
			List<Integer> templist = new ArrayList<>();
			templist.addAll(il);
			il.clear();
			sot.add(new SellOrderTable(name, templist));
			
		}
		
		Set<SellOrderTable> caiset = new TreeSet<>((o1,o2)->o1.getName().compareTo(o2.getName()));
		caiset.addAll(sot);
		List<SellOrderTable> templist = new ArrayList<>(caiset);
		String json = gson.toJson(templist);
		System.out.println(json);
		return json;
		
		
	}
}
