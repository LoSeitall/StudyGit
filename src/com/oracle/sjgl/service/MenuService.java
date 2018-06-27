package com.oracle.sjgl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.oracle.sjgl.dao.MenuDAO;
import com.oracle.sjgl.dao.MenuPowerDAO;
import com.oracle.sjgl.po.Menu;
import com.oracle.sjgl.po.MenuPower;

public class MenuService {
	
	private MenuDAO md = new MenuDAO();
	private MenuPowerDAO mpd = new MenuPowerDAO();
	
	//查询一个菜单的信息
	public Menu selectOneMenu(String mid){
		Menu menu = md.selectMenuByID(Integer.parseInt(mid));
		return menu;
	} 
	
	//查询所有菜单的信息
	public List<Menu> selectALLMenu(){
		List<Menu> menulist = new ArrayList<>();
		menulist = md.selectAllMenu();
		return menulist;
	}
	
	//通过角色查询对应的菜单信息
	public List<MenuPower> selectMenuPowerByID(int rid){
		
		List<MenuPower> menupowerlist = new ArrayList<>();
		menupowerlist = mpd.selectMenuPowerByID(rid);
		return menupowerlist;
		
	}
	
	//查询出所有角色对应的菜单信息
	public List<MenuPower> selectAllMenuPower(){
		
		List<MenuPower> menupowerlist = new ArrayList<>();
		menupowerlist = mpd.selectAllMenuPower();
		return menupowerlist;
		
	}
	
	/**
	 * 本方法用于剔除重复的菜单
	 * @param Menu
	 * @return
	 */
	public static List<Menu> removeDupliById(List<Menu> Menu) {
	    //利用Set不能重复 将List去重 此处使用Lambda表达式
		Set<Menu> MenuSet = new TreeSet<>((o1, o2) -> String.valueOf(o1.getMid()).compareTo(String.valueOf(o2.getMid())));
		MenuSet.addAll(Menu);
	    return new ArrayList<>(MenuSet);
	}
	

}
