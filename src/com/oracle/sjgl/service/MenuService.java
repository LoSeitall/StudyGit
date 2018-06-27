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
	
	//��ѯһ���˵�����Ϣ
	public Menu selectOneMenu(String mid){
		Menu menu = md.selectMenuByID(Integer.parseInt(mid));
		return menu;
	} 
	
	//��ѯ���в˵�����Ϣ
	public List<Menu> selectALLMenu(){
		List<Menu> menulist = new ArrayList<>();
		menulist = md.selectAllMenu();
		return menulist;
	}
	
	//ͨ����ɫ��ѯ��Ӧ�Ĳ˵���Ϣ
	public List<MenuPower> selectMenuPowerByID(int rid){
		
		List<MenuPower> menupowerlist = new ArrayList<>();
		menupowerlist = mpd.selectMenuPowerByID(rid);
		return menupowerlist;
		
	}
	
	//��ѯ�����н�ɫ��Ӧ�Ĳ˵���Ϣ
	public List<MenuPower> selectAllMenuPower(){
		
		List<MenuPower> menupowerlist = new ArrayList<>();
		menupowerlist = mpd.selectAllMenuPower();
		return menupowerlist;
		
	}
	
	/**
	 * �����������޳��ظ��Ĳ˵�
	 * @param Menu
	 * @return
	 */
	public static List<Menu> removeDupliById(List<Menu> Menu) {
	    //����Set�����ظ� ��Listȥ�� �˴�ʹ��Lambda���ʽ
		Set<Menu> MenuSet = new TreeSet<>((o1, o2) -> String.valueOf(o1.getMid()).compareTo(String.valueOf(o2.getMid())));
		MenuSet.addAll(Menu);
	    return new ArrayList<>(MenuSet);
	}
	

}
