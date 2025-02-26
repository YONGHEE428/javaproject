package day0226;

public class QuizObject {

	static String classname;
	
	String stname2;
	int stage2;
	String stcity2;
	String sthobby2;
	
	private String stname;
	private int stage;
	private String stcity;
	private String sthobby;
	
	public void setName (String name) {
		stname = name;
	}
	public void setAge (int age) {
		stage = age;
	}
	public void setCity (String city) {
		stcity = city;
	}
	public void sethobby (String hobby) {
		sthobby = hobby;
	}
	
	public String getName () 
	{
		return stname;
	}
	public int getAge () 
	{
		return stage;
	}
	public String getCity () 
	{
		return stcity;
	}
	public String getHobby () 
	{
		return sthobby;
	}
}
