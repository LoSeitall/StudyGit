package com.oracle.sjgl.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 本类为工具类，用于获取sqlsession
 * @author User
 *
 */
public class getSession {
	
	private SqlSession session = null;
	
	public SqlSession getSession(){
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlsessionfactory.openSession(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
	
	public void closeSession(){
		if(session != null){
			session.close();
		}
	}
}
