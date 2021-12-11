package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	
	public static ExtentReports getReporterObject() {
		//Two classes ExtentReports and ExtentSparkReport are to be configured.
	    //First the object of ExtentSpartkReporter and the path of the html report file
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Results");
				reporter.config().setDocumentTitle("Test Result");
				//Then Object of the ExtentReports
				extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester name", "White Jhonson");
				return extent;
		
	}

}
