package Genericlibrary;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.reporters.Files;

public class BaseClass {

    public WebDriver driver;
    public static ExtentReports extentReports;
    public ExtentTest startTest;
    public String tcid;
    public String order;
    public String browser_type;
    private Files FileUtils;


    @BeforeSuite(groups={"Smk","UAT","Reg"})
    public void create_Report(){

//        extentReports = new ExtentReports(System.getProperty("user.dir") +"\\Reports\\FREDashboard"+get_datetimestamp() +".html",false);

    }

    @Parameters({"browser"})
    @BeforeMethod(groups={"Smk","UAT","Reg"})
    public void launchApp(String btype) throws Exception{
        browser_type=btype;
        if(btype.equals("ff")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(btype.equals("ch")){

//            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver",".\\src\\main\\resources\\chromedriver32.exe");
            driver = new ChromeDriver();
        }else if(btype.equals("ie")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();

        }
//		fd= new FirefoxDriver();
        driver.get(Utility.getval(Utility.getval("env")));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

    }


    @AfterMethod(groups={"Smk","UAT","Reg"})
    public void closeApp(){

        driver.close();

        extentReports.endTest(startTest);
        extentReports.flush();

    }

    public String get_datetimestamp(){
        Date date = new Date();
//		format date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
//
        String format = dateFormat.format(date);
        return format;
    }

    //	capture snapshot
    public String getScreenshot() throws Exception{

        TakesScreenshot screensht=(TakesScreenshot)driver;
        File screenshotAs = screensht.getScreenshotAs(OutputType.FILE);

        String fpath = Utility.getval("Screenshot_path") + tcid + "_" + order + "_" + get_datetimestamp() +".png";
        org.apache.commons.io.FileUtils.copyFile(screenshotAs, new File(fpath));
        return fpath;

    }



}










