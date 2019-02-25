package my.javaee.ejb.beans.clientsample;

import my.javaee.ejb.beans.*;

public class ClientSample {

	public static void main(String[] args) {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        PropertyBeanService service1 = new PropertyBeanService();
	        System.out.println("Create Web Service...");
	        PropertyBean port1 = service1.getPropertyBeanPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port1.create(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port1.update(null));
	        //Please input the parameters instead of 'null' for the upper method!
	 
	        System.out.println("Server said: " + port1.read(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port1.list(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port1.delete(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Create Web Service...");
	        PropertyBean port2 = service1.getPropertyBeanPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port2.create(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port2.update(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port2.read(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port2.list(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port2.delete(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("***********************");
	        System.out.println("Call Over!");
	}
}
