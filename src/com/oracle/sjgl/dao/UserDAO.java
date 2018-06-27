package com.oracle.sjgl.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oracle.sjgl.po.User;
import com.oracle.sjgl.util.getSession;

public class UserDAO {
	
	/**
	 * ���������ڱ����û��б�
	 * @return userlist
	 * @throws IOException
	 */
	public List<User> selectAll() throws IOException{
		getSession gs = new getSession();
		SqlSession session = gs.getSession();
		List<User> userlist = new ArrayList<>();
		userlist = session.selectList("selectAllUser");
		return userlist;
	}
	
	
}
