package es.oper;

public class User {
	
	private long m_id;
	private String m_name;
	private int m_age;
	
	public void setId(long id)
	{
		m_id = id;
	}
	
	public void setName(String name)
	{
		m_name = name;
	}
	
	public void setAge(int age)
	{
		m_age = age;
	}
	
	public long getId()
	{
		return  m_id;
	}
	
	public String getName()
	{
		return  m_name;
	}
	
	public int getAge()
	{
		return  m_age;
	}


}
