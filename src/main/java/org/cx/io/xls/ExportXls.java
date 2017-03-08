package org.cx.io.xls;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportXls {

	public static void main(String[] args) throws IOException {
		String outputFile = "/Users/grass/Desktop/aa.xls";
		
		// 创建excel
		HSSFWorkbook wb = new HSSFWorkbook();

		// 创建sheet
		HSSFSheet sheet = wb.createSheet("Sheet1");
		HSSFSheet sheet2 = wb.createSheet("Sheet2");
		
		HSSFRow row = sheet.createRow(0);
		
		
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("aaaaa");
		
		cell = row.createCell(1);
		cell.setCellValue("bbb");
		
		
		HSSFRow r2 = sheet2.createRow(0);
		HSSFCell c2 = r2.createCell(0);
		c2.setCellValue("cccc");
		
		FileOutputStream fout = new FileOutputStream(outputFile);
		wb.write(fout);
		fout.close();
		wb.close();
		
	}

	

}
