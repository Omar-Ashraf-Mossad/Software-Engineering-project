/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage;

import java.util.ArrayList;

public class GarageAccounts{
    	public static ArrayList<VehicleOwner> list = new ArrayList<VehicleOwner>();
	public Persons admin;
	public Persons staff;
        public VehicleOwner user = new VehicleOwner();
        public Garage garage = Garage.getInstance();
        
                
        public GarageAccounts()
        {
            admin = new Persons("admin","admin");
            staff = new Persons("staff","staff");
        }
	public void register(VehicleOwner user)
	{
            list.add(user);
	}
	public int login(String name,String password)
	{
		if(admin.authenticate(name,password))
		{
			return 1;
		}
		if(staff.authenticate(name,password))
		{
			return 2;
		}
		for(int i=0;i<list.size();i++)
		{
			user=list.get(i);
			if(user.authenticate(name,password))
			{
                            return 3;
			}
		}
		return 0;
	}
	public VehicleOwner getUser()
	{
		return user;
	}
        public ArrayList<VehicleOwner> getList()
	{
		return list;
	}

}

