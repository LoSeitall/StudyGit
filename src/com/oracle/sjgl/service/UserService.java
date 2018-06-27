package com.oracle.sjgl.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.sjgl.dao.UserDAO;
import com.oracle.sjgl.dao.UserPowerDAO;
import com.oracle.sjgl.po.User;
import com.oracle.sjgl.po.UserPower;

public class UserService {
	
	public static int UID;
	/**
	 * �����������ж��Ƿ��ܹ���½
	 * @param username
	 * @param password
	 * @return boolean
	 * @throws IOException
	 */
	public boolean loginUser(String username,String password) throws IOException{
		UserDAO ud = new UserDAO();
		List<User> users = ud.selectAll();
		for (User user : users) {
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
				UID = user.getUid();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ���������������ݿ�����û���ɫ
	 * @param uid
	 * @param rid
	 */
	public void addUserPower(String uid,String rid){
		UserPowerDAO upd = new UserPowerDAO();
		List<UserPower> userpowerlist = upd.selectOneByID(Integer.parseInt(uid));
		if(!"0".equals(rid) && rid != null && !"".equals(rid)){
			for (UserPower userpower : userpowerlist) {
				if(String.valueOf(userpower.getRid()).equals(rid)){
					return;
				}
			}
			upd.insertUP(new UserPower(Integer.parseInt(uid),Integer.parseInt(rid)));
		}
	}
	
	/**
	 * ����һ���û�ӵ�е�����Ȩ��
	 * @param uid
	 * @return
	 */
	public List<UserPower> selectUserPowerByID(int uid){
		List<UserPower> userpower = new ArrayList<>();
		UserPowerDAO upd = new UserPowerDAO();
		userpower = upd.selectOneByID(uid);
		return userpower;
	}
	
}
