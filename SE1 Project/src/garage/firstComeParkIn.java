/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage;

import java.util.*;
import java.time.*; 

/**
 *
 * @author عمر
 */
public class firstComeParkIn implements Parkin {
    public int parkIn(int width,int depth,ArrayList<Slot> s)
    {
        int ctr = 0;
        int index=-2;
	boolean check = false;
	for(int i=0;i<s.size();i++)
	{
	    check = s.get(i).checkIsFree();
            if(check)
		ctr++;
	}
	if(ctr==0)
	{
		return -1;
	}
        else
        {
	    LocalTime arrivalTime = LocalTime.now(); 
		
            for(int i=0;i<s.size();i++)
            {
		if(s.get(i).checkIsFree())
		{
                     if(s.get(i).getDepth()>=depth&&s.get(i).getWidth()>=width)
                    {
			s.get(i).setIsFree(false);
			s.get(i).setArrivalTime(arrivalTime);
			return i+1;
		    }
						 
		}
            }
		
        }
        return index;
    }
}
