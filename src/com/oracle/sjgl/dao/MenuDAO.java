package com.oracle.sjgl.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oracle.sjgl.po.Menu;
import com.oracle.sjgl.util.getSession;

public class MenuDAO extends getSession{
	
	private SqlSession session = null;
	
	public Menu selectMenuByID(int mid){
		
		Menu menu = null;
		
		try {
			session = getSession();
			menu = session.selectOne("selectMenuById",mid);
		}finally{
			closeSession();
		}
		
		return menu;
		
	}
	
	public List<Menu> selectAllMenu(){
		
		List<Menu> menulist = new ArrayList<>();
		
		try {
			session = getSession();
			menulist = session.selectList("selectAllMenu");
		}finally{
			closeSession();
		}
		
		return menulist;
	}
	
}
