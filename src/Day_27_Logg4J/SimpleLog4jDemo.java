package Day_27_Logg4J;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class SimpleLog4jDemo {
	static Logger log=Logger.getLogger(SimpleLog4jDemo.class.getName());
	
	public static void main(String[] args) throws IOException {
		
		Layout lay= new SimpleLayout();
		
		Appender ap= new FileAppender(lay, "simple.txt");
		
		log.addAppender(ap);
		
		log.debug("DEBUG");
		log.info("INFO");
		log.warn("WARN");
		log.error("ERROR");
		log.fatal("Fatal");//it will print in file
		
		System.out.println("this is demo");//it not get store into the file
		
	}
	

}
