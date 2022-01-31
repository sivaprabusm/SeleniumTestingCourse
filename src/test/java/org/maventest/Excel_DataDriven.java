package org.maventest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_DataDriven {

	public static void main(String[] args) throws IOException {
		File f = new File("F:\\SIVA testing course\\eclipse-workspace\\MavenProject1\\target\\StudentData.xlsx");
		
		FileInputStream fIn = new FileInputStream(f);
		 Workbook w = new XSSFWorkbook(fIn);
		Sheet s = w.getSheet("Thursday");
		/*Row r = s.getRow(1);
		Cell c = r.getCell(0);
		System.out.println(c);
		System.out.println("Success");
		
		int totalRows = s.getPhysicalNumberOfRows();
		System.out.println("Total number of rows" + totalRows);
		
		int totalCells = r.getPhysicalNumberOfCells();
		System.out.println("Total cells popuplated: " + totalCells);
		System.out.println("\n\nPrinting the entire sheet: \n");
		//Print the entire sheet
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row row = s.getRow(i);
			
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell eachCell = row.getCell(j);
				System.out.println(eachCell);
			}
		}*/
		
		//Resolving format issue of numbers
		//1. Get each row -----> getRow()
		//2. Get each cell ------> getCell()
		//3. Get each cell type () -----> getCellType()
		//4. If cellType is 1 ----> String ----> getStringValue()
		//5. If cellType is 0 ----> Date or int
		//                            if Date ---> DateUtil.getDateCellValue()
		//									  ---> getDateCellValue()
		//							  else ---- it has int value
		//									  ----> getNumericCellValue()
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int cellType = c.getCellType();
				if(cellType == 1) {
					String value = c.getStringCellValue();
					System.out.println(value);
				}
				else if(cellType == 0) {
					if (DateUtil.isCellDateFormatted(c)) {
						Date d = c.getDateCellValue();
						
						SimpleDateFormat sdf = new SimpleDateFormat("dd,MMM,yyy");
						String newDateFormat = sdf.format(d);
						System.out.println(newDateFormat);
					}
					else {
						double d = c.getNumericCellValue();
						long l = (long)d;
						String value = String.valueOf(l);
						System.out.println(value);
					}
				}
			}
		}
	}
}
