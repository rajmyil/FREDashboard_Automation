package Genericlibrary;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Utility {


    //	common method
    public static  Iterator<Object[]> dp_commonlogic(String sheetname ) throws Exception{

        ExcelRW excelRW = new ExcelRW(System.getProperty("user.dir") + "\\src\\main\\resources\\TestReport-REST API TEST RESULT-Web Services-08-30-2021.xlsx");

        int rowcount = excelRW.rowcount(sheetname);
        int colcount = excelRW.Colcount(sheetname);

//				list create
        List<Object[]> al = new ArrayList<Object[]>();
        for(int i = 1;i<=rowcount;i++){

//            String flag=excelRW.readcellval(sheetname, i, 2);
//            String script=excelRW.readcellval(sheetname, i, 1);
            Map<String, String> hmap = new HashMap<String,String>();
//			object array
                Object[] x=new Object[1];

                for(int j=0;j<colcount;j++){

                    String key = excelRW.readcellval(sheetname, i, 0);
                    String value = excelRW.readcellval(sheetname, i, 1);
                    hmap.put(key,value);

                }

//			add object array
                x[0]=hmap;
                al.add(x);
            }


        return al.iterator();

    }



    //	get the properties value
    public static 	String getval(String key) throws Exception{

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\Config.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(key);
    }
}
