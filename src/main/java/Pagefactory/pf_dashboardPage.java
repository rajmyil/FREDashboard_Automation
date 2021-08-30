package Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class pf_dashboardPage extends pf_genericMethods{

    @FindBy(how = How.XPATH, using = "(//h3[text()[normalize-space()='Dashboard']]/following::h4)[1]") public WebElement reportone;
    @FindBy(how = How.XPATH, using = "//span[@uib-tooltip='Download']/following::small") public WebElement dashboardIcon;
    @FindBy(how = How.XPATH, using = "//small[text()='Dashboard']/preceding::span[2]") public WebElement downloadIcon;
    @FindBy(how = How.XPATH, using = "//span[text()='Test Phase']/preceding::span[text()='Environment']/following-sibling::span") public WebElement environmentValue;
    @FindBy(how = How.XPATH, using = "//span[text()='Start Time']/preceding::span[text()='Test Phase']/following-sibling::span") public WebElement testPhaseValue;
    @FindBy(how = How.XPATH, using = "//span[text()='End Time']/preceding::span[text()='Start Time']/following-sibling::span") public WebElement startTimeValue;
    @FindBy(how = How.XPATH, using = "//p[text()='SKIP']/preceding::span[text()='End Time']/following-sibling::span") public WebElement endTimeValue;
    @FindBy(how = How.XPATH,using = "(//li[@class='list-group-item']//span/following::h4)[1]") public WebElement testRunValue;
    @FindBy(how = How.XPATH,using = "(//li[@class='list-group-item']//span/following::h4)[2]") public WebElement testPassValue;
    @FindBy(how = How.XPATH,using = "(//li[@class='list-group-item']//span/following::h4)[3]") public WebElement testFailValue;
    @FindBy(how = How.XPATH,using = "(//li[@class='list-group-item']//span/following::h4)[4]") public WebElement testSkipValue;

    public pf_dashboardPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public ArrayList<String> validateFalconDashboard(){
        ArrayList<String> dashboardvalues = new ArrayList<>();
        cl_click(reportone);
        cl_click(downloadIcon);
        cl_click(dashboardIcon);
        String environment = environmentValue.getText();
        dashboardvalues.add(environment);
        String testPhase = testPhaseValue.getText();
        dashboardvalues.add(testPhase);
        String startTime = startTimeValue.getText();
        dashboardvalues.add(startTime);
        String endTime = endTimeValue.getText();
        dashboardvalues.add(endTime);
        String testRun = testRunValue.getText();
        dashboardvalues.add(testRun);
        String testPass = testPassValue.getText();
        dashboardvalues.add(testPass);
        String testFail = testFailValue.getText();
        dashboardvalues.add(testFail);
        String testSkip = testSkipValue.getText();
        dashboardvalues.add(testSkip);
        return dashboardvalues;
    }
}
