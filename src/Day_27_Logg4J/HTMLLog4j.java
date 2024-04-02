package Day_27_Logg4J;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;

public class HTMLLog4j {
static Logger log= Logger.getLogger(HTMLLog4j.class.getName());
	public static void main(String[] args) throws IOException {

		Layout l= new HTMLLayout();
		
		Appender ap= new FileAppender(l, "HTML.txt");
		
		log.addAppender(ap);
		
		log.debug("DEBUG");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");//it will print in html format in file
		
		
	}

}
