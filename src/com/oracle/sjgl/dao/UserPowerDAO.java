package com.oracle.sjgl.dao;


import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.oracle.sjgl.po.UserPower;
import com.oracle.sjgl.util.getSession;

public class UserPowerDAO extends getSession{
	private SqlSession session = null;
	
	public void insertUP(UserPower up){
		try {
			session = getSession();
			session.insert("addUserPower",up);
			session.commit();
		}finally{
			closeSession();
		}
	}
	
	public void updateUP(UserPower up){
		try {
			session = getSession();
			session.update("updateUserPower", up);
			session.commit();
		}finally{
			closeSession();
		}
	}
	
	public void deleteUP(UserPower up){
		try {
			session = getSession();
			session.delete("updateUserPower", up);
			session.commit();
		}finally{
			closeSession();
		}
	}
	
	public List<UserPower> selectOneByID(int uid){
		List<UserPower> userpower= new ArrayList<>();
		try {
			session = getSession();
			userpower = (List)session.selectList("selectUserPowerById", uid);
			return userpower;
		}finally{
			closeSession();
		}
	}
}
