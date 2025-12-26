package genericutility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFileUtil {
    /**
     * Reads data from excel file with sheet name, rown number and cell number
     * @param sheetname
     * @param rownum
     * @param cellnum
     * @return
     * @throws IOException
     */
    public String readExcelFile(String sheetname, int rownum, int cellnum) throws IOException {
        FileInputStream fil = new FileInputStream(IPathConstants.excelpath);
        Workbook wb = WorkbookFactory.create(fil);
        String data=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
        wb.close();
        return data;
    }

    /**
     * Gets the last row number
     * @param sheetname
     * @return
     * @throws IOException
     */
    public int getLastRowNumOfExcel(String sheetname) throws IOException {
        FileInputStream fil = new FileInputStream(IPathConstants.excelpath);
        Workbook wb = WorkbookFactory.create(fil);
        int rowcount = wb.getSheet(sheetname).getLastRowNum();
        wb.close();
        return rowcount;
    }

    /**
     * gets the last cell number
     * @param sheet
     * @return
     * @throws IOException
     */
    public int getLastCellNum(String sheet) throws IOException {
        FileInputStream fil = new FileInputStream(IPathConstants.excelpath);
        Workbook wb = WorkbookFactory.create(fil);
        int cellcount=wb.getSheet(sheet).getRow(0).getLastCellNum();
        wb.close();
        return cellcount;
    }

    /**
     * creates a new row and writes data to it
     * @param sheet
     * @param row
     * @param cell
     * @param value
     * @throws IOException
     */
    public void writeToNewRow(String sheet,int row,int cell,String value) throws IOException {
        FileInputStream fil = new FileInputStream(IPathConstants.excelpath);
        Workbook wb = WorkbookFactory.create(fil);
        wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(value);
        FileOutputStream fos=new FileOutputStream(IPathConstants.excelpath);
        wb.write(fos);
        wb.close();
    }

    /**
     * creates a new cell in an existing row and writes data to it
     * @param sheet
     * @param row
     * @param cell
     * @param value
     * @throws IOException
     */
    public void writeToNewCell(String sheet,int row,int cell,String value) throws IOException {
        FileInputStream fil = new FileInputStream(IPathConstants.excelpath);
        Workbook wb = WorkbookFactory.create(fil);
        wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);
        FileOutputStream fos=new FileOutputStream(IPathConstants.excelpath);
        wb.write(fos);
        wb.close();
    }

    /**
     * writes data to an existing cell
     * @param sheet
     * @param row
     * @param cell
     * @param value
     * @throws IOException
     */
    public void writeToCell(String sheet,int row,int cell,String value) throws IOException {
        FileInputStream fil = new FileInputStream(IPathConstants.excelpath);
        Workbook wb = WorkbookFactory.create(fil);
        wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
        FileOutputStream fos=new FileOutputStream(IPathConstants.excelpath);
        wb.write(fos);
        wb.close();
    }

    public Object[][] loginDetails(String sheetname) throws IOException {
        FileInputStream fis=new FileInputStream(IPathConstants.excelpath);
        Workbook wb= WorkbookFactory.create(fis);
        Sheet sh=wb.getSheet(sheetname);
        int rowcount= sh.getLastRowNum();
        Object[][] ob = new Object[rowcount][2];
        for (int i=0; i<rowcount;i++){
            Row row =sh.getRow(i);
            for (int j=0;j<row.getLastCellNum();j++) {
                ob[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
            }
        }
        return ob;
    }
}
