package cn.hebei.dao;

import java.util.ArrayList;

import cn.hebei.domain.Person;

public interface PersonDAO {
	public void insertPerson(Person p) throws Exception;
	public void deletePerson(String id)throws Exception;
	public void updatePerson(String alter,String alternum,String idnum)throws Exception;
	public Person selectById(String id)throws Exception;
	public void selectAll()throws Exception;

}
