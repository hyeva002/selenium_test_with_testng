package com.test.keywordparse;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelParse {
	public static HSSFSheet ExcelSheet;
	public static HSSFWorkbook ExcelBook;
	public static HSSFRow Row;
	public static HSSFCell Cell;
	public static MissingCellPolicy policy;

	public static void setExcelFile(String Path, String SheetName)
			throws Exception {
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelBook = new HSSFWorkbook(ExcelFile);
		ExcelSheet = ExcelBook.getSheet(SheetName);
	}
	public static void setCellData(String Result, int RowNum, int ColNum,
			String Path) throws Exception {
		
		Row = ExcelSheet.getRow(RowNum);
		Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (Cell == null) {
			Cell = Row.createCell(ColNum);
			Cell.setCellValue(Result);
		} else {
			Cell.setCellValue(Result);
		}
		FileOutputStream fileOut = new FileOutputStream(Path);
		ExcelBook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

	public static String getCellDate(int RowNum, int CloNum) {
		Cell = ExcelSheet.getRow(RowNum).getCell(CloNum);
		String cellData = Cell.getStringCellValue();
		return cellData;
	}
}

//读取Excel元素的方法
/* 
ExcelUtils.setExcelFile("D:\\data\\TestData.xls", "steps");
		                 ActionKeyWords actionKeyWords= new ActionKeyWords();
		                 String Keywords=null;
		                 for(int RowNum=1;RowNum<=ExcelUtils.getLastRowNums();RowNum++){
		                     Keywords=ExcelUtils.getCellDate(RowNum, 3);
		                     if(Keywords.trim().equals("Open_Browser")){
		                         actionKeyWords.OpenBrowser();
		                    }else if(Keywords.trim().equals("Navigate")){
		                        actionKeyWords.Navigate();
		                    }
		                }
		             }
 * */
