package garage;
import java.util.Scanner;

public class Vehicle {
	private String modelName;
	private int id;
	private int modelYear;
	private int width;
	private int depth;
	
	public boolean check(int id)
	{
		if(this.id==id)
			return true;
		else
			return false;
	}
	
	public void setName(String name)
	{
		modelName=name;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setDepth(int depth)
	{
		this.depth=depth;
	}
	public void setWidth(int width)
	{
		this.width=width;
	}
	public void setYear(int year)
	{
		modelYear=year;
	}
	public String getName()
	{
		return modelName;
	}
	public int getId()
	{
		return id;
	}
	public int getDepth()
	{
		return depth;
	}
	public int getWidth()
	{
		return width;
	}
	public int getYear()
	{
		return modelYear;
	}	
}
