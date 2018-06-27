package com.oracle.sjgl.service;

import java.util.List;

import com.oracle.sjgl.dao.EmpMapper;
import com.oracle.sjgl.dao.SalaryMapper;
import com.oracle.sjgl.po.Emp;
import com.oracle.sjgl.po.Salary;
import com.oracle.sjgl.util.DateFormat;
import com.oracle.sjgl.util.LimitNum;
import com.oracle.sjgl.util.PageUtil;
import com.oracle.sjgl.util.getSession;

public class EmpService {
	
	private static getSession gs = new getSession();
	
	//����������ָ��eid�ش���ӦԱ��������Ϣ
	public List<Salary> selectSalaryByEid(String eid){
		
		int id = Integer.parseInt(eid);
		
		List<Salary> sa = gs.getSession().getMapper(SalaryMapper.class).selectByEid(id);
		
		for (Salary salary : sa) {
			salary.setStime(DateFormat.changeDate(salary.getTime()));
		}
		
		gs.closeSession();
		
		return sa;
		
	}

	//��ѯ��Ա������
	public static int EmpCount(){
		
		List<Emp> emplist = gs.getSession().getMapper(EmpMapper.class).EmpCount();
		
		return emplist.size();
	}

	//��ѯ����Ա������(������ѯ��)
	public static int EmpCountCondition(Emp emp){
		
		List<Emp> emplist = gs.getSession().getMapper(EmpMapper.class).EmpCountCondition(emp);
		
		return emplist.size();
	}

	//��ѯ����Ա����Ϣ�б�(������ѯ��)
	public PageUtil selectAllByCondition(int pageno,int size,Emp emp){
		
		PageUtil pu = new PageUtil();
		
		emp.setSize(size);
		
		emp.setLimitnum((pageno-1)*size);
		
		List<Emp> emplist = null;
		
		emplist = gs.getSession().getMapper(EmpMapper.class).selectAllByCondition(emp);
		
		for (Emp e : emplist) {
			e.setSbirthday(DateFormat.changeDate(e.getBirthday()));
			e.setShireday(DateFormat.changeDate(e.getHireday()));
		}
		
		pu.setList(emplist);
		
		pu.init(pageno, EmpCountCondition(emp), size,"SelectEmpListByConditionServlet");
		
		System.out.println(emplist.size());
		
		gs.closeSession();
		
		return pu;
	}

	//��ѯ������Ա����Ϣ�б�
	public PageUtil selectAllEmp(int pageno,int size){
		
		PageUtil pu = new PageUtil();
		
		LimitNum ln = new LimitNum();
		
		ln.setSize(size);
		
		ln.setLimitnum((pageno-1)*size);
		
		List<Emp> emplist = null;
		
		emplist = gs.getSession().getMapper(EmpMapper.class).selectAll(ln);
		
		for (Emp emp : emplist) {
			emp.setSbirthday(DateFormat.changeDate(emp.getBirthday()));
			emp.setShireday(DateFormat.changeDate(emp.getHireday()));
		}
		
		pu.setList(emplist);
		
		pu.init(pageno, EmpCount(), size,"SelectEmpListServlet");
		
		gs.closeSession();
		
		return pu;
	}

	//ͨ��������ѯĳ��Ա����Ϣ
	public Emp selectByPrimaryKeyEmp(String eid){
		
		int id = Integer.parseInt(eid);
		
		Emp emp = gs.getSession().getMapper(EmpMapper.class).selectByPrimaryKey(id);
		
		emp.setSbirthday(DateFormat.changeDate(emp.getBirthday()));
		
		emp.setShireday(DateFormat.changeDate(emp.getHireday()));
		
		gs.closeSession();
		
		return emp;
	}

	//����һ��Ա����Ϣ(��ȱʡ����)
	public void insertSelective(Emp emp){
		
		System.out.println(emp);
		
		gs.getSession().getMapper(EmpMapper.class).insertSelective(emp);

		gs.closeSession();
		
	}

	//ɾ��ĳ��Ա����Ϣ(��ɾ��)
	public void deleteByPrimaryKey(Emp emp){
		
		gs.getSession().getMapper(EmpMapper.class).updateByPrimaryKey(emp);
		
		gs.closeSession();
	
	}

	//ͨ����������ָ��һ��Ա������Ϣ
	public void updateByPrimaryKey(Emp emp){
		
		gs.getSession().getMapper(EmpMapper.class).updateByPrimaryKey(emp);
		
		gs.closeSession();
	
	}

	//��������Ա����Ϣ�б�
	public List<Salary> selectAllSalary(){
		
		List<Salary> salarylist = gs.getSession().getMapper(SalaryMapper.class).selectAll();
		
		gs.closeSession();
		
		return salarylist;
	}

	//����ĳ��Ա���Ĺ�����Ϣ
	public Salary selectByPrimaryKeySalary(String said){
		
		int id = Integer.parseInt(said);
		
		Salary salary = gs.getSession().getMapper(SalaryMapper.class).selectByPrimaryKey(id);
		
		gs.closeSession();
		
		return salary;
	}

	//ɾ��ĳ��Ա��������Ϣ(��ɾ��)
	public void deleteByPrimaryKet(Salary salary){
		
		gs.getSession().getMapper(SalaryMapper.class).updateByPrimaryKey(salary);
		
		gs.closeSession();
		
	}

	//����ĳ��Ա��������Ϣ
	public void updateByPrimaryKet(Salary salary){
		
		gs.getSession().getMapper(SalaryMapper.class).updateByPrimaryKey(salary);
		
		gs.closeSession();
		
	}

	//����һ��Ա��������Ϣ
	public void insert(Salary salary){
		
		gs.getSession().getMapper(SalaryMapper.class).insert(salary);
		
		gs.closeSession();
		
	}

    //����һ��Ա��������Ϣ(��ȱʡ����)
	public void insertSelective(Salary salary){
		
		gs.getSession().getMapper(SalaryMapper.class).insertSelective(salary);
		
		gs.closeSession();
		
	}
	
}

