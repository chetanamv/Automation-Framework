package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of generic methods related to Excel file 
 * @author Chetana M V
 */

public class ExcelFileUtility {
	/**
	 * This method will read data from Excel file and return the value
	 * @param sheetName
	 * @param rowno
	 * @param celno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int rowno, int celno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowno);
		Cell c1 = rw.getCell(celno);
		String value = c1.getStringCellValue();
		return value;
		
		
	}
	

}
