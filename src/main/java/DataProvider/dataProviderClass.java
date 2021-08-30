package DataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import Genericlibrary.ExcelRW;
import Genericlibrary.Utility;

public class dataProviderClass {


    @DataProvider(name = "FREDashboardReport")
    public static Iterator<Object[]> dp_invalidLogin() throws Exception {

        return Utility.dp_commonlogic("Test Report");

    }

}