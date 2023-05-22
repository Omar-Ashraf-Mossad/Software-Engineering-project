/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage;

import java.util.*;
import java.time.*; 

public class BestfitParkIn implements Parkin {
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
			LocalTime arrivalTime; 
		    	int minDepth=0;
		    	int minWidth=0;
		    	for(int i=0;i<s.size();i++)
			{
                            if(s.get(i).checkIsFree())
                             {
				if(s.get(i).getDepth()>=depth&&s.get(i).getWidth()>=width)
				{
                                    if(minDepth==0)
                                    {
					minDepth=s.get(i).getDepth();
					minWidth=s.get(i).getWidth();
					index=i;			 
                                    }
                                    else if((s.get(i).getDepth()+s.get(i).getWidth())<(minDepth+minWidth))
                                    {
					minDepth=s.get(i).getDepth();
					minWidth=s.get(i).getWidth();
					index=i;
                                    }
                                }
                            }
			}
                        if(index!=-2)
                          {
                              arrivalTime = LocalTime.now(); 
                              s.get(index).setIsFree(false);
                              s.get(index).setArrivalTime(arrivalTime);
                              return index+1;		
                          }
                }
                return index;
    }
}