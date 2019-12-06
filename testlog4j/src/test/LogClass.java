package test;

import org.apache.log4j.Logger;

public class LogClass {
	private static final Logger log = Logger.getLogger(LogClass.class);
	   
	   public static void main(String[] args) {

		   for(int i =0; i < 1000; i++ ) {
			   log.trace("Trace Message!" + i);
			   log.debug("Debug Message!" + i);
			   log.info("Info Message!" + i);
			   log.warn("Warn Message!" + i);
		       log.error("Error Message!" + i);
		   	   log.fatal("Fatal Message!" + i);
		   }
	   }
}
