package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	Workbook wb;
	Sheet sheet;
	DataFormatter df;
	
	public ReadExcel(String fileName) throws IOException {
		URL url = getClass().getResource(fileName);
		File file = new File(url.getPath());
		FileInputStream inp = new FileInputStream(file);
		wb = new XSSFWorkbook(inp);
		sheet = wb.getSheetAt(0);
		df = new DataFormatter();
	}
	
	
	public String getCell(int _row, int _cell) {
		Row row = sheet.getRow(_row);
		Cell cell = row.getCell(_cell);
		return df.formatCellValue(cell);
	}
}
