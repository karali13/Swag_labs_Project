package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization {
	public static String getExcelData(int row,int cell, String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\shimp\\OneDrive\\Desktop\\Automation-tool\\new_workspace_for_Project\\Swab_labs\\src\\test\\resources\\Testdata\\TestDataForSwagLab.xlsx");
		String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
}
