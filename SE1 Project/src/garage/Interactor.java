package garage;
import java.util.ArrayList;
import java.util.Scanner;

public class Interactor {
        private static GarageAccounts system1 = new GarageAccounts();
        private static GarageParking system2 = new GarageParking();
        private static GarageData system3 = new GarageData();
        private static GaragePayment system4 = new GaragePayment();
        

	public static void main(String[] args) 
	{
		Scanner c= new Scanner(System.in);

		while(true)
		{
			System.out.println("For admins and staff use Login directly.");
			System.out.println("For Customers use Register or Login if you are previously registered.");

			System.out.println("--------------------------------------------------- ");
			System.out.println("1-Register ");
			System.out.println("2-Login");
			System.out.println("--------------------------------------------------- ");
			System.out.print("> ");
			
			String choice = c.nextLine();
			switch(choice)
			{
			case("1"): register();
				break;
			case("2"): login();
				break;
			default: break;
                       }
                }
	}
	public static void register()
	{
                String name;
		String password;
                //Create a new vehicl owner to save information in
		VehicleOwner user =new VehicleOwner();
		Scanner input=new Scanner(System.in) ;
                
                //ask for information 
		System.out.print("please provide a username: ");
		name= input.nextLine();

		System.out.print("please provide a password: ");
		password=input.nextLine();
                
                //Make sure new customers don't use Admin and staff names
                while(name.equals("staff")||name.equals("admin"))
		{
			System.out.println("Can't use this username please try again");
			System.out.print("please provide a username: ");
			name= input.nextLine();

			System.out.print("please provide a password: ");
			password=input.nextLine();

			
		}
                //Save information 
                user.save(name, password);
                
                //Put the new Customer in the List in system object
		system1.register(user);
                Vehicle v = user.getVehicle();
                 //Get vehicle data
                     Scanner myInput = new Scanner(System.in);
                     
                    System.out.print("please enter Your vehicle model name: ");
                    String  modelName= myInput.nextLine();
                      
                    System.out.print("please enter Your vehicle model id: ");
                    String num = myInput.nextLine();
                    int id = validate_number(num,"please enter Your vehicle model id: ");
                    
                    //validate Id
                    
                     while(id<=0)
                     {
                        System.out.println("This number is invalid");
                         System.out.print("please enter Your vehicle model id: ");
                           num = myInput.nextLine();
                          id = validate_number(num,"please enter Your vehicle model id: ");
                     }
                     
                     
                    System.out.print("please enter Your car vehicle Model year: ");
                     num = myInput.nextLine();
                    int modelYear = validate_number(num,"please enter Your car vehicle Model year: ");
                    
                    

                    System.out.print("please enter Your vehicle width: ");
                     num = myInput.nextLine();
                    int width = validate_number(num,"please enter Your vehicle width: ");
                    
                    
                //Validate the width value
                while(width<=0)
                {
                        System.out.println("This number is invalid");
                        System.out.print("please enter Your vehicle width: ");
                         num = myInput.nextLine();
                        width = validate_number(num,"please enter Your vehicle width: ");
                }
                
                
                //Get the Depth of the vehicle 
                
		System.out.print("please enter Your vehicle depth: ");
                 num = myInput.nextLine();
                 int depth = validate_number(num,"please enter Your vehicle depth: ");
                
                //Validate depth number number
                 while(depth<=0)
                {
                        System.out.println("This number is invalid");
                        System.out.print("please enter Your vehicle depth: ");
                        num = myInput.nextLine();
                        depth = validate_number(num,"please enter Your vehicle depth: ");
                }
                 
                 
                 //Assign data to the vehicle
                 v.setDepth(depth);
                 v.setWidth(width);
                 v.setId(id);
                 v.setName(modelName);
                 v.setYear(modelYear);
                 
                System.out.println("Regesteration Completed!");
	}
	static void  login()
	{
                System.out.println("if you are admin then your username= admin and password = admin");
                System.out.println("if you are staff then your username= staff and password = staff");
		System.out.println("if you are a customer use your username and password");
		System.out.println("-------------------------------------------------");
		Scanner input=new Scanner(System.in) ;
                
                //Get the data
		System.out.print("please enter your username: ");
		String name= input.nextLine();

		System.out.print("please enter your password: ");
		String password=input.nextLine();
                
                //Check the data and return result
		int r=system1.login(name,password);
                
                //if login using an admin account
		if(r==1)
			displayAdminFunctions();
                
                //if login using Staff account
                else if (r==2)
                    displayStaffFunctions();
                
		//if login using Vehicle owner account
		else if(r==3)
		{
			displayVehicleOwnerFunctions();
		}
		else
		{
			System.out.println("Sorry Worng data");
		}
	}

	static void  displayAdminFunctions()
	{
		while(true)
		{
			Scanner c= new Scanner(System.in);
			System.out.println("Please enter the number of the operation you want ");
			System.out.println("--------------------------------------------------- ");
			System.out.println("1-set garage slots ");
			System.out.println("2-display total income");
			System.out.println("3-display total number of vehicles");
			System.out.println("4-display Available slots");
			System.out.println("5-choose park-in configuration");
			System.out.println("6-logout");	
                        System.out.println("7-End program");
			System.out.println("--------------------------------------------------- ");
			System.out.print("> ");
			String choice = c.nextLine();
			switch(choice)
			{
			case("1"):        if(!system3.check_can_change_slots())
                                          {
                                                  System.out.print("You Can't change The slots untill all customers park out from their slots");
                                                  break;
                                          }
                                        System.out.println("Please Enter the number of slots in the garage:");
                                         String num = c.nextLine();
                                         int s = validate_number(num,"Please Enter the number of slots in the garage:");
                                         assignSlots(s);
                                         break;
                                        //Get the total income stored in the garage 
			case("2"):        System.out.println("Total income is "+ system3.getSum());
					break;
                                        
                                        //Get the total Number of cars who parked in the garage
			case("3"):        System.out.println("Total number of vehicls that used the system is "+system3.getVehicleNo()+" Vehicle");
					break;
                                        
                                        
                                       //Get all slots that are free in the garage 
			case("4"):       displayAvailableSlots();
                                       break;
                                       
                                       //determine how do you want customers to park in
			case("5"):        setParkinConfiguration();
					break;
			case("6"): break;
                        
                        case("7"): System.exit(0);
                        
			default: System.out.println("wrong input");
					break;
                         }
			if(choice.equals("6"))
			{
				break;
			}

		}
				
	}
        static void assignSlots(int size)
        {
            //Create a list to store the slots 
            ArrayList<Slot> s = new ArrayList<Slot>();
          
            //get slots data 
            for(int i=1;i<=size;i++)
            {
			Scanner scanner = new Scanner(System.in);
                        
			System.out.println("Enter Slot number "+i+" width = ");
                        String num = scanner.nextLine();
                        int w = validate_number(num,"Enter Slot number "+i+" width = ");
                        
			System.out.println("Enter Slot number "+i+" depth = ");
                        num = scanner.nextLine();
                        int d = validate_number(num,"Enter Slot number "+i+" depth = ");
                        //Validate Slot dimensions
                        while(true)
                        {
                            //Validate the width of the slot not being 0 or less
                            if(w<=0)
                            {
                                System.out.print("Can't accept negative numbers");
                                System.out.println("Enter Slot number "+i+" width = ");
                                 num = scanner.nextLine();
                                 w = validate_number(num,"Enter Slot number "+i+" width = ");
                            }
                            //Validate the width of the slot not being 0 or less
                            else if(d<=0)
                            {
                                System.out.print("Can't accept negative numbers");
                                System.out.println("Enter Slot number "+i+" depth = ");
                                num = scanner.nextLine();
                                d = validate_number(num,"Enter Slot number "+i+" depth = ");
                            }
                            else
                                break;
                        }
                        //Create the slot and assign its depth,width and id
			Slot slot = new Slot(w,d,i);
                        //add the slot to the list
			s.add(slot);
             }
            //save the list in the garage
            system3.addSlots(s);
        }
        
        static void displayAvailableSlots()
        {
            //Get the list of the slots in the garage
            ArrayList<Slot> list = system3.getSlots();
            
            System.out.print("Available slots are : ");
            //display the number of free slots
            for (int i = 0; i < list.size() ; i++) 
            {
                if(list.get(i).checkIsFree()==true)
                System.out.print(list.get(i).getId() + " ");
            }
            
            System.out.print(System.lineSeparator());
        }
        
        static void setParkinConfiguration()
        {
            Scanner c = new Scanner(System.in);
            System.out.println("Please enter 1 for first come first served configuration or 2 for best-fit configuration: ");
            String config = c.nextLine();
            while(config.equals("1")&&config.equals("2"))
            {			
		System.out.println("Please Enter 1 or 2");
		config = c.nextLine();
            }
            if(config.equals("1"))
            {
                system2.garageParkinStrategy(new firstComeParkIn());

            }
            if(config.equals("2"))
             {
                    system2.garageParkinStrategy(new BestfitParkIn());

             }
        }
        static void displayStaffFunctions()
	{
            //This functions appear when you log in with a staff account
			while(true)
			{
				Scanner c= new Scanner(System.in);
				System.out.println("Please enter the number of the operation you want ");
				System.out.println("--------------------------------------------------- ");
				System.out.println("1-Confirm Payment for a customer");
				System.out.println("2-logout");
				System.out.println("--------------------------------------------------- ");
				System.out.print("> ");
				String choice = c.nextLine();
				switch(choice)
				{
					case("1"): confirmPaymentForCustomer();
						 break;
					case("2"): break;
                                 
					default: System.out.println("Wrong input");
							break;
				}
				if(choice.equals("2"))
				{
					break;
				}
			}
	}
        static void confirmPaymentForCustomer()
        {
            Scanner c = new Scanner(System.in);
            //Get the customer id to get the fees on him
            System.out.print("Enter vehicle id: ");
            String num = c.nextLine();
            int id = validate_number(num,"Enter vehicle id: ");
            VehicleOwner user =system4.checkId(id,system1.getList());
            //if user is null it means that there is no Vehicle with this id
            if(user==null)
            System.out.println("This Customer doesnot exist or does not have any fees");
            else
            {
               //display the fees
               System.out.println("Username:"+user.getName());
               System.out.println("Fees: "+user.getFees());
               system4.confirm(user);
               System.out.println("Payment completed successfly");
           }
        }
	static void displayVehicleOwnerFunctions()
	{
            //This Functions is displayed only when login using a customer account
			while(true)
			{
				Scanner c= new Scanner(System.in);
				System.out.println("Please enter the number of the operation you want ");
				System.out.println("--------------------------------------------------- ");
				System.out.println("1-Park-in ");
                                System.out.println("2-Park-Out ");
				System.out.println("3-logout");
				System.out.println("--------------------------------------------------- ");
				System.out.print("> ");
				String choice = c.nextLine();
				switch(choice)
				{
					case("1"): displayParkIn();
                                                 break;
					case("2"): displayParkOut();
                                                 break;
                                        case("3"): break;
					default: System.out.println("Wrong input");
						 break;
				}
				if(choice.equals("3"))
				{
                                    break;
				}
			}
	}
	static void  displayParkIn()
	{
		Scanner c = new Scanner(System.in);	
		VehicleOwner user= system1.getUser();
                Vehicle v = user.getVehicle();
                //Vehicle info
                System.out.println("Your vehicle info:");
		System.out.println("--------------------------");
		System.out.println("Model Name: "+ v.getName());
		System.out.println("Width: "+v.getWidth());
		System.out.println("Depth: "+v.getDepth());
		System.out.println("Model id: "+v.getId());
		System.out.println("Model year: "+v.getYear());
		System.out.println("-------------------------");
                
                
		System.out.println("----------------------------------");
                        //Check if the vehicle owner can park or not and if he can book a slot and if he can't display why he can't
			int slot = system2.garageParkIn(user);
			if(slot==-1)
			{
				System.out.println("Sorry there is no available slot at the current time");
			}
			else if(slot==-2)
			{
				System.out.println("Sorry no available slot can hold your vehicle:");
			}
			else if(slot==-3)
			{
				System.out.println("You have parked already before in a Slot ");
			}
                        else if (slot==-4)
                        {
                            System.out.println("You have to pay your fees before parking in a new Slot ");
                        }
			else
			{
				System.out.println("You have parked in Slot : "+ slot);
			}
		
	}
        
        static void displayParkOut()
        {
            
            Scanner c = new Scanner(System.in);	
            //get the object of Vehicle owner saved in the system
            VehicleOwner user= system1.getUser();
            
            //check if the user parked in a slot or not by checking the slont number
            if(user.getSlot()<=0)
            {
                System.out.println("You Haven't parked in any slot");
                return ;
            }
            //Get indormation
            System.out.println("You Have parked in Slot: "+user.getSlot());
            Slot slot = system3.getSlot(user.getSlot());
            System.out.println("----------------------------------");
            System.out.println("Arrival Time: "+slot.getArrivalTime());
            
                    //Perform park out
                    double duration =system2.garageParkOut(user);
                  
                    System.out.println("Leave Time: "+slot.getLeaveTime());
                    System.out.println("You have parked for "+duration+" hours");
                    System.out.println("You have to Pay fees = "+user.getFees()+" LE");
                    if(user.getFees()!=0)
                    {
                         System.out.println("Please go to the staff to confirm payment and use your vehicle id:  "+user.getVehicleId());
                    }
                    else
                    {
                          System.out.println("Since Your fees is 0 you don't have to pay anything and you can parkin again anytime");
                           user.emptyFees();
                           user.save(0);
                    }
        }
        
        static int validate_number(String num,String message)
        {
            Scanner c = new Scanner(System.in);
            while(true)
            {
                if (num.matches("[0-9]+")) {
                   break;
                }
                else
                {
                    System.out.println("Wrong Input");
                    System.out.print(message);
                    num = c.nextLine();
                    
                }
            }
            return Integer.parseInt(num);
            
        }
        

            
}

