package Scripts;

import Genericlibrary.BaseClass;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.logging.Logger;

import java.sql.Driver;
import java.util.Map;

import Pagefactory.pf_dashboardPage;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import Pagefactory.pf_genericMethods;

    public class script_verify extends BaseClass {

//        Logger loginlog = Logger.getLogger(String.valueOf(script_verify.class));

        @Test(dataProvider = "FREDashboardReport", dataProviderClass = DataProvider.dataProviderClass.class, enabled = true, priority = 2, groups = {"UAT", "Reg"})
        public void invalid_Login(Map hm) {

            ArrayList<String> excelValues = new ArrayList<>();
            String excelRunID = hm.get("Run ID").toString();
            excelValues.add(excelRunID);
            String excelEnvironment = hm.get("Environment").toString();
            excelValues.add(excelEnvironment);
            String excelPhase = hm.get("Phase").toString();
            excelValues.add(excelPhase);
            String excelStartTime = hm.get("Start Time").toString();
            excelValues.add(excelStartTime);
            String excelEndTime = hm.get("End Time").toString();
            excelValues.add(excelEndTime);
            String excelTotalTests = hm.get("Total Test Cases").toString();
            excelValues.add(excelTotalTests);
            String excelTotalPass = hm.get("Total Pass").toString();
            excelValues.add(excelTotalPass);
            String excelTotalFail = hm.get("Total Fail").toString();
            excelValues.add(excelTotalFail);
            String excelTotalSkip = hm.get("Total Skip").toString();
            excelValues.add(excelTotalSkip);
            tcid = hm.get("TC_ID").toString();
            order = hm.get("Order").toString();

            startTest = extentReports.startTest(tcid + "_" + order + "_" + browser_type);

//		object of signin pf
            pf_dashboardPage dashboardPage = new pf_dashboardPage(driver);
            ArrayList<String> dashboardText = dashboardPage.validateFalconDashboard();

            for (int index = 0; index < dashboardText.size(); index++) {
                if (dashboardText.get(index).equals(excelValues.get(index))) {
                    startTest.log(LogStatus.PASS, "Validate Login msg", "Passed");
                    System.out.println(" Pass");
                } else {
                    startTest.log(LogStatus.FAIL, "Validate Login msg", "Failed");
                    System.out.println("Fail");
                }
            }
        }
    }