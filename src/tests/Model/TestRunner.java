package tests.Model;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(JUnitTestSuite.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      if(result.wasSuccessful()){
	    	  System.out.println("\n\n\n\nTesting the model was awesomely successful");
	      }else{
	    	  System.out.println("\n\n\n\nSomething failed. See Above");
	      }
	}
	
}
