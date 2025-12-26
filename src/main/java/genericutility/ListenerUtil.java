package genericutility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import configuration.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;


public class ListenerUtil extends BaseClass implements ITestListener, ISuiteListener {
    public static ThreadLocal<ExtentTest> testthread = new ThreadLocal<>();
    public ExtentReports report;
    public ExtentSparkReporter spark;

    @Override
    public void onStart(ISuite suite) {
        String time = jlib.getDateTime().replace(" ", "_").replace(":", "_");
        spark = new ExtentSparkReporter("./advancereport/report_" + time + ".html");
        spark.config().setDocumentTitle("Report");
        spark.config().setReportName("VTiger CRM Reports");
        spark.config().setTheme(Theme.DARK);
        report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("os", "windows10");
        report.setSystemInfo("browser", "edge");
        report.setSystemInfo("base_url", "http://localhost:8888/");
        report.setSystemInfo("reporter", "arjun");
    }

    @Override
    public void onFinish(ISuite suite) {
        report.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = report.createTest(result.getTestClass().getName() + "-" + result.getMethod().getMethodName());
        testthread.set(test);
        String testname = result.getTestClass().getName() + "-" + result.getMethod().getMethodName();

        testthread.get().log(Status.INFO, "<i>"+testname+" has Started</i>");
    }



    @Override
    public void onTestSuccess(ITestResult result) {
        String testname = result.getTestClass().getName() + "-" + result.getMethod().getMethodName();
        testthread.get().log(Status.PASS, "<i>"+testname+" Passed</i>");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testname = result.getTestClass().getName() + "-" + result.getMethod().getMethodName();
        String time = jlib.getDateTime().replace(" ", "_").replace(":", "_");
        TakesScreenshot ts = (TakesScreenshot) driverThread.get();
        String file = ts.getScreenshotAs(OutputType.BASE64);
        testthread.get().addScreenCaptureFromBase64String(file, testname + time);
        testthread.get().log(Status.FAIL, "<b>"+testname+" Failed</b>");
        testthread.get().log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testname = result.getTestClass().getName() + "-" + result.getMethod().getMethodName();
        if (result.wasRetried()) {
            testthread.get().log(Status.WARNING, "<b>"+testname+" has failed, but Retrying... (Attempt " +
                    ((RetryImpUtil)result.getMethod().getRetryAnalyzer(result)).count + ")</b>");
        } else {
            testthread.get().log(Status.SKIP, "<i>"+testname+" has been Skipped</i>");
        }    }
}
