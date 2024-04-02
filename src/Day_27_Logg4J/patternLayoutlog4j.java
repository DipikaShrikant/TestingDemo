package Day_27_Logg4J;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class patternLayoutlog4j {

static 	Logger log= Logger.getLogger(patternLayoutlog4j.class.getName());
	public static void main(String[] args) {

		Layout l=  new PatternLayout();
		
		Appender ap= new ConsoleAppender(l);
		
		log.addAppender(ap);
		log.debug("this is Debug");
		log.info("This is info");
		log.warn("This is warn");
		log.error("This is Error");
		log.fatal("This is Fatal");//it will print on console
		
	}

}
