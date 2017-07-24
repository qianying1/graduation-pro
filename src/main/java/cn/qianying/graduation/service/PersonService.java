package cn.qianying.graduation.service;

import java.util.List;

import cn.qianying.graduation.domain.Person;

public interface PersonService {
	public List<Person> listAll();
	
	public int addRecord(Person p);
	
	public int saveOrUpdate(Person p);
	
	public Person getDetail(String id);
}
