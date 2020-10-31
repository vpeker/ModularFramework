package commonLibs.utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportUtils {
    ExtentReports extentReports;
    ExtentTest extentTest;
    ExtentHtmlReporter htmlReport;

    public ReportUtils(String htmlReportFilename){
        htmlReportFilename=htmlReportFilename.trim();

        htmlReport=new ExtentHtmlReporter(htmlReportFilename);
        extentReports=new ExtentReports();
        extentReports.attachReporter(htmlReport);

    }
    public void createATestCase(String testcaseName){
        extentTest=extentReports.createTest(testcaseName);

    }
    public void addTestLog(Status status, String comment){
        extentTest.log(status,comment);

    }
    public void attachScreeshotToReport(String  filename)throws Exception{
        extentTest.addScreenCaptureFromPath(filename);
    }
    public void flushReport(){
        extentReports.flush();
    }


}
