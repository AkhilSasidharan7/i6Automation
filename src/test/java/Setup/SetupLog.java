package Setup;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import Pages.Home;

//configure Logs
public class SetupLog {
	  public static Logger log;
	    public static Logger setUp() {
	        BasicConfigurator.configure();
	        log = Logger.getLogger(Home.class);
	        log.info("Log set up is done");
	        return log;
	    }
}