package sdetProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.*;

public class ReadExcelData {

	public static void main(String[] args) throws IOException 
	{
		String excelfilepath="C:\\Users\\padia\\OneDrive\\Desktop\\MyWorksheet.xlsx";
		
		FileInputStream inputstream=new FileInputStream(excelfilepath);         //Convert file into read mode
		
		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		// Two ways to read excel data 1. using for loop  2. using iterator
		/*//1. using for loop
		
		int row=sheet.getLastRowNum();                                           //gives total rows
		int col=sheet.getRow(1).getLastCellNum();                                //gives total column
		for(int r=0;r<row;r++)
		{
			XSSFRow rownum=sheet.getRow(r);
			for(int c=0;c<col;c++)
			{
				XSSFCell cell=rownum.getCell(c);
				switch(cell.getCellType())
				{
				case STRING:System.out.print(cell.getStringCellValue()); break;
				case NUMERIC:System.out.print(cell.getNumericCellValue()); break;
				case BOOLEAN:System.out.print(cell.getBooleanCellValue()); break;
				} 
				System.out.print("  |  ");
			}
			System.out.println();
		}
*/
		
		//2.using iterator
		
		Iterator iterator=sheet.iterator();
		while(iterator.hasNext());
		{
			XSSFRow row=(XSSFRow) iterator.next();
			Iterator celliterator= row.cellIterator();
			while(celliterator.hasNext())
			{
				XSSFCell cell=(XSSFCell) celliterator.next();
				switch(cell.getCellType())
				{
				case STRING:System.out.print(cell.getStringCellValue()); break;
				case NUMERIC:System.out.print(cell.getNumericCellValue()); break;
				case BOOLEAN:System.out.print(cell.getBooleanCellValue()); break;
				}
				System.out.print("  |  ");
			}
			System.out.println();
		}
		
	}
}
	


