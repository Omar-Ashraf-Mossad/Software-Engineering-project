/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage;

import java.util.ArrayList;

public class GarageData{
    public Garage garage = Garage.getInstance();
    
    public boolean check_can_change_slots()
    {
        return garage.chek_all_is_free();
    }
    public void addSlots(ArrayList<Slot> list)
	{
            garage.setSlotsList(list);
	}
	public double getSum()
	{
		return garage.getTotalIncome();
	}
	public int getVehicleNo()
	{
		return garage.getVehicleNo();
	}
	public ArrayList<Slot>  getSlots()
	{
		return garage.getSlotList();
	}
        
        public Slot getSlot(int n)
        {
                return garage.getSlot(n);
        }
}
