package Genericlibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
    XSSFWorkbook wb;
    FileInputStream fis;

    //	 Initilize excel
    public ExcelRW(String fpath) throws Exception {
        fis = new FileInputStream(fpath);
//		create a workbook
        wb = new XSSFWorkbook(fis);

    }

    //	get row count
    public int rowcount(String sheetname) {
        XSSFSheet sheet = wb.getSheet(sheetname);
        return sheet.getLastRowNum();

    }

    //	get column count
    public int Colcount(String sheetname) {
        XSSFSheet sheet = wb.getSheet(sheetname);
        return sheet.getRow(0).getLastCellNum();
    }

    //	Reac cell
    public String readcellval(String sheetname, int row, int col) {
        XSSFSheet sheet = wb.getSheet(sheetname);
        XSSFCell cell = sheet.getRow(row).getCell(col);
        String celltext = null;
        if (cell.getCellType() == CellType.STRING) {

            celltext = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            celltext = String.valueOf(cell.getNumericCellValue());

        } else if (cell.getCellType() == CellType.BLANK ) {

            celltext = "";
        }

        return celltext;


    }


    //	write to cell
    public void writecell(String sheetname, int row, int col, String val) {
        XSSFSheet sheet = wb.getSheet(sheetname);
        sheet.getRow(row).getCell(col).setCellValue(val);
    }

    //	Save and close
    public void saveandclose(String fpath) throws Exception {

        FileOutputStream fos = new FileOutputStream(fpath);

//		write and save to excel
        wb.write(fos);

//		Close the streams
        fos.close();
        fis.close();


    }
}
