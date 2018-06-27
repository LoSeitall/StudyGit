package com.oracle.sjgl.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.oracle.sjgl.po.MenuPower;
import com.oracle.sjgl.util.getSession;

public class MenuPowerDAO extends getSession{
	
	private SqlSession session = null;
	
	public List<MenuPower> selectMenuPowerByID(int rid){
		
		List<MenuPower> menupower = new ArrayList<>();
		
		try {
			session = getSession();
			menupower = session.selectList("selectMenuPowerById",rid);
		}finally{
			closeSession();
		}
		
		return menupower;
		
	}
	
	public List<MenuPower> selectAllMenuPower(){
		
		List<MenuPower> menupower = new ArrayList<>();
		
		try {
			session = getSession();
			menupower = session.selectList("selectAllMenuPower");
		}finally{
			closeSession();
		}
		
		return menupower;
		
	}
	
}
