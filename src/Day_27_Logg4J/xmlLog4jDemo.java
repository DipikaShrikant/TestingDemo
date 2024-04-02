package Day_27_Logg4J;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.XMLLayout;

public class xmlLog4jDemo {
static Logger log= Logger.getLogger(xmlLog4jDemo.class.getName());
	public static void main(String[] args) {

		Layout l= new XMLLayout();
		
		Appender ap= new ConsoleAppender(l);
		log.addAppender(ap);
		
		log.debug("DEBUG");
		log.info("INFO");
		log.warn("WARN");
		log.error("ERROR");
		log.fatal("FATAL");//in xml format on console
		
		
	}

}
