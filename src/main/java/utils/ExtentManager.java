package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/reports/extent.html";

            // Ensure report directory exists
            new File(System.getProperty("user.dir") + "/reports").mkdirs();

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Nutrilab Automation Report");
            sparkReporter.config().setReportName("Login Test Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

    public static void startTest(String testName) {
        ExtentTest extentTest = getInstance().createTest(testName);
        test.set(extentTest);
    }

    public static void log(String message) {
        test.get().info(message);
    }

    public static void logPass(String message) {
        test.get().pass(message);
    }

    public static void logFail(String message) {
        test.get().fail(message);
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static ExtentTest getTest() {
        return test.get();
    }
}
