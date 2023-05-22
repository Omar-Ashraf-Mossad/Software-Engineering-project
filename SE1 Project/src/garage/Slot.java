package garage;

import java.util.*;
import java.time.*;  
import java.time.temporal.*;


public class Slot{
    private int width;
    private int depth;
    private int id;
    private boolean isFree ;
    LocalTime arrivalTime;
    LocalTime leaveTime;
		
        public Slot(int w,int d,int Id)
        {
            width=w;
            depth=d;
            id=Id;
            isFree=true;
        }            
        public void freeSlot()
        {
            isFree=true;
        }	
        public double getDuration()
        {
            double duration = Duration.between(arrivalTime,leaveTime).toMinutes();
            duration = duration/60;
            return duration;
        }
	public void setWidth(int Width){width=Width;}
	public void setDepth(int Depth){depth=Depth;}
	public void setIsFree(boolean free){isFree=free;}	
	public int getWidth(){return width;}
	public int getDepth(){return depth;}
	public void setId(int Id){id=Id;}	
	public int getId(){return id;}
	public boolean checkIsFree(){return isFree;}
	public void setArrivalTime(LocalTime time)
	{
            arrivalTime=time;
	}
	public void setLeaveTime(LocalTime time)
	{
            leaveTime=time;
	}    
        public LocalTime getArrivalTime()
	{
            return arrivalTime;
	}
	public LocalTime getLeaveTime()
	{
            return leaveTime;
        }
		
		

}
