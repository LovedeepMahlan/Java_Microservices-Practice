package com.compney.DemoLitner;

import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class DemoListner implements ServletRequestListener {
	public static int count;
	static {
		System.out.println("DemoListner Loading :: DemoListner.class loading");
	}
    public DemoListner() {
       System.out.println("DemoListner.DemoListner() Instantation");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("DemoListner.requestDestroyed() object created at :: "+new Date());
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	count++;
    	System.out.println("DemoListner.requestInitialized() object created at :: "+ new Date());
    	System.out.println("No of object created at our servlet is "+count);
    }
	
}
