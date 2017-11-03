package com.test.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.test.dom.DOMParserDemo;


public class SAXParserDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
	    SAXParser parser = parserFactor.newSAXParser();
	    SAXHandler handler = new SAXHandler();
	    parser.parse(SAXParserDemo.class.getClassLoader()
				.getResourceAsStream("resources/employee.xml"), 
	                 handler);
	     
	    //Printing the list of employees obtained from XML
	    for ( Employee emp : handler.empList){
	      System.out.println(emp);
	    }
	}
}
	
	class SAXHandler extends DefaultHandler
	{
		List<Employee> empList = new ArrayList<Employee>();
		
		Employee emp = null;
		String content = null;
		
		@Override
		public void startElement(String uri,String localName,String qName,Attributes attributes)
		{
			System.out.print("uri:: "+uri+"  localName::: "+localName+ "   qName:::"+qName);
			System.out.println();
			switch(qName){
		      //Create a new Employee object when the start tag is found
			
		      case "employee":
		        emp = new Employee();
		        emp.id = attributes.getValue("id");
		        break;
		    }
		}
		
		@Override
		public void endElement(String uri,String localName,String qName)
		{
			switch(qName){
		     //Add the employee to list once end tag is found
		     case "employee":
		       empList.add(emp);       
		       break;
		     //For all other end tags the employee has to be updated.
		     case "firstName":
		       emp.firstName = content;
		       break;
		     case "lastName":
		       emp.lastName = content;
		       break;
		     case "location":
		       emp.location = content;
		       break;
		   }
		}
		
		@Override
		  public void characters(char[] ch, int start, int length) 
		          throws SAXException {
		    content = String.copyValueOf(ch, start, length).trim();
		  }
	}


