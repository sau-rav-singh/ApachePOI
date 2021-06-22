package com.saurav.ApachePOI;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Test {
	public static Logger log = Logger.getLogger(Test.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//PropertyConfigurator.configure(".\\properties\\log4j.properties");
		log.info("This is the information log");
	}

}
