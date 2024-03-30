package com.tutorialninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(extentReportFile);
		
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("TutorialsNinja Test Automation Results Report");
		sparkReport.config().setDocumentTitle("TN Automation Report");
		sparkReport.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReport);
		
		Properties propConfig = new Properties();
		File propFileConfig = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\config\\Config.properties");
		try {
			FileInputStream fisConfig = new FileInputStream(propFileConfig);
			propConfig.load(fisConfig);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL", propConfig.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", propConfig.getProperty("browser"));
		extentReport.setSystemInfo("Email used", propConfig.getProperty("validEmail"));
		extentReport.setSystemInfo("Password used", propConfig.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReport;
	}

}
