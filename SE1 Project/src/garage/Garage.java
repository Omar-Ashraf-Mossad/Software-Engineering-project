package garage;
import java.util.*;
import java.time.*; 

public class Garage
{
	private String name;
	private int maxSize;
	private int vehicleNo=0;
	private double totalIncome=0;
	private ArrayList<Slot> s = new ArrayList<Slot>();
        private static  Garage garage= null;
	
        private Garage()
        {
            //Add a default number of slots to the garage
            Slot slot = new Slot(15,10,1);
            s.add(slot);
            
            slot = new Slot(4,4,2);
            s.add(slot);
            
            slot = new Slot(25,30,3);
            s.add(slot);
         
            slot = new Slot(1,2,4);
            s.add(slot);
            
        }
        
        public static Garage getInstance()
        {
            if(garage==null)
                garage = new Garage();
            return garage;
        }
	public void setMaxSize(int size){maxSize = size;}
	public void setName(String Name){name=Name;}
	
		
	
	public int getMaxSize(){return maxSize;}
	public int getVehicleNo(){return vehicleNo;}
	public String getName(){return name;}

	public double getTotalIncome(){return totalIncome;}
	public boolean increaseNoOfVehicle(){vehicleNo++; return true;}
        public  void increaseTotalIncome(double fees){totalIncome+= fees;}
	
        public boolean chek_all_is_free()
        {
            Slot slot;
            if(s.size()>0)
		{
                    for(int i=0;i<s.size();i++)
                    {
                        slot = s.get(i);
                        if(!slot.checkIsFree())
                        {
                             return false;       
                        }
                    }
		}
            return true;
        }
	public void setSlotsList(ArrayList<Slot> list)
	{
		if(s.size()>0)
		{
                    s.clear();
		}
		
		s=list;
	}
	public boolean assign(int slotNo,int width,int depth)
	{
		Slot slot= new Slot(width,depth,slotNo);
		s.add(slot);
		return true;
	}

        public ArrayList<Slot> getSlotList()
        {
            return s;
        }
        
        public Slot getSlot(int n)
        {
            return s.get(n-1);
        }
        
      
}



