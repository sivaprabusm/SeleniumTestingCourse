package org.maventest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_WriteIntoFile {

	public static void main(String[] args) throws IOException {
		//1. new File object
		File f = new File("F:\\SIVA testing course\\eclipse-workspace\\MavenProject1\\target\\Thursday.xlsx");
		//2. create excel file
		f.createNewFile();
		//3. type of workbook
		Workbook w = new XSSFWorkbook();
		//4. create the sheet
		Sheet s = w.createSheet("FirstSheet");
		//5. create a row
		Row r = s.createRow(0);
		//6. create a cell
		Cell c = r.createCell(0);
		//7. set value in the cell
		c.setCellValue("Login");
		r.createCell(1).setCellValue("Password");
		
		Row r1 = s.createRow(1);
		r1.createCell(0).setCellValue("Oracle");
		r1.createCell(1).setCellValue("oracle@123");
		
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
		System.out.println("SUCCESS");
		
		
	}
	
}
