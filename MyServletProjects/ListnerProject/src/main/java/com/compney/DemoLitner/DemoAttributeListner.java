package com.compney.DemoLitner;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DemoAttributeListner implements ServletRequestAttributeListener {
	static {
		System.out.println("DemoAttributeListner Loading :: DemoAtttributeListner.class is loading()");
	}
    public DemoAttributeListner() {

    System.out.println("DemoAttributeListner Instantation :: DemoAttributeListner()");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         System.out.println("DemoAttributeListner.attributeisRemoved ::"+srae.getClass());
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         System.out.println("DemoAttributeListner.attributeAdded :: "+srae.getClass());
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         System.out.println("DemoAttributeListner.attributeReplaced :: "+srae.getClass());
    }
	
}
