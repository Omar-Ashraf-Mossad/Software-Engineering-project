/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage;

public class Persons implements authenticate {
    private String name;
    private String password;
	
        public Persons(String name,String pass)
        {
                this.name=name;
		this.password=pass;	
        }
       public boolean authenticate(String name, String pass) {
       if(this.name.equals(name)&&this.password.equals(pass))
			return true;
		else
			return false;
    }  
        

    
        
}
