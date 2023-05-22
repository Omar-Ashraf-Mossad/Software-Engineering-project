/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage;

import java.time.LocalTime;

public class GarageParking{
    
        private Parkin strategy= new firstComeParkIn();
	public Garage garage = Garage.getInstance();
        
	public void garageParkinStrategy(Parkin s)
	{
            strategy = s;
	}
        
        public int garageParkIn(VehicleOwner user)
	{
		if(user.getSlot()>0)
		{
			return -3;
		}
               if(user.getSlot()==-9)
                {
                            return -4;
                }
                int i = strategy.parkIn(user.getVehicleWidth(), user.getVehicleDepth(), garage.getSlotList());
            
		if(i>0)
		{
			user.save(i);
                        garage.increaseNoOfVehicle();
		}
		return i;
	}
        public double garageParkOut(VehicleOwner user)
        {
           int slotNo = user.getSlot();
            Slot slot = garage.getSlot(slotNo);
            
            
            LocalTime leave = LocalTime.now(); 
            slot.setLeaveTime(leave);
            
            double duration = slot.getDuration();
            
            user.setFees(duration*5);
            user.save(-9);
            slot.freeSlot();
            return duration;
        }
}
