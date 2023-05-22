/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage;

import java.util.ArrayList;

public class GaragePayment{
    
    public Garage garage = Garage.getInstance();
    
        public VehicleOwner checkId(int id,ArrayList<VehicleOwner> list)
	{
            VehicleOwner user;
		for(int i=0;i<list.size();i++)
		{
			user=list.get(i);
                        if(id==user.getVehicleId())
                        {     
                            if(user.getFees()!=0)
                                 return user;      
                        }
		}
                return null;
	}
        public void confirm(VehicleOwner user)
        {
            
                 garage.increaseTotalIncome(user.getFees());
                 user.emptyFees();
                 user.save(0);
        }
}
