package common;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHelper {
	private String filePath;
	private String sheetName;
	
	public DataHelper(String filePath, String sheetName) {
		this.filePath = filePath;
		this.sheetName = sheetName;
	}
	
	public List<HashMap<String, String>> data() {
		List<HashMap<String, String>> mydata = new ArrayList<>();
		try {
			FileInputStream fs = new FileInputStream(this.filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(this.sheetName);
			Row HeaderRow = sheet.getRow(0);
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);
					switch (currentCell.getCellType()) {
					case STRING:
						System.out.print(currentCell.getStringCellValue() + "\t");
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;
					}
				}
				mydata.add(currentHash);
			}
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mydata;
	}
	
	public void update(String field, int rowIndex, String value)
	{
		int fieldIndex=0;
		try {
			FileInputStream fs = new FileInputStream(this.filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(this.sheetName);
			Row HeaderRow = sheet.getRow(0);
			for (int j = 0; j < HeaderRow.getPhysicalNumberOfCells(); j++) {
				Cell currentCell = HeaderRow.getCell(j);
				if(currentCell.getStringCellValue().equals(field))
				{
					fieldIndex= j;
				}
			}
			Cell updateCell = sheet.getRow(rowIndex).getCell(fieldIndex);
			updateCell.setCellValue(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
