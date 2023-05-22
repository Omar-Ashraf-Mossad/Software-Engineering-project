package garage;
import java.util.Scanner;

public class VehicleOwner implements authenticate{
	private String name;
	private String password;
	private int slotNo=0;
	private double fee=0;
	private Vehicle myVehicle;
        
	public boolean authenticate(String name,String pass)
	{
		if(pass.equals(password)&&name.equals(this.name))
			return true;
		else
			return false;
	}
	public int getSlot()
	{
		return slotNo;
	}
	public double getFees()
	{
		return fee;
	}
        public String getName()
	{
		return name;
	}
	public void setFees(double fee)
	{
		this.fee=fee;
	}
	public boolean check(int id)
	{
		return myVehicle.check(id);
	}
	public void emptyFees()
	{
		fee=0;
	}
	public void emptySlot()
	{
		slotNo=0;
	}
	public void save(int slotNo)
	{
		this.slotNo=slotNo;
	}
	public void save(String name,String pass)
	{
		this.name=name;
		this.password=pass;	
		this.myVehicle=new Vehicle();
	}
	public int getVehicleWidth()
	{
		return myVehicle.getWidth();
	}
	public int getVehicleDepth()
	{
		return myVehicle.getDepth();
	}
	public int getVehicleId()
	{
		return myVehicle.getId();
	}
        public Vehicle getVehicle()
	{
		return myVehicle;
	}    
}
