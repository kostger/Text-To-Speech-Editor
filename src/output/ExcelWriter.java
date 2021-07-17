package output;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter implements DocumentWriter {

	private String path;
	
	public ExcelWriter(String path) {
		this.path = path;
	}

	public void write(String text){
		
        try(XSSFWorkbook workbook = new XSSFWorkbook()){
        	XSSFSheet sheet = workbook.createSheet("TTS-Sheet");
        	Object[][] datatypes = newData(text);

        	int rowNum = 0;

        	for (Object[] datatype : datatypes) {
        		Row row = sheet.createRow(rowNum++);
        		int colNum = 0;
        		for (Object field : datatype) {
        			Cell cell = row.createCell(colNum++);
        			if (field instanceof String) {
        				cell.setCellValue((String) field);
        			}else if (field instanceof Integer) {
        				cell.setCellValue((Integer) field);
        			}
        		}
        	}
        
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String[][] newData(String text){
		
		// Separating all by new line
		String str[]=text.split("\n");
		
		// Get the max number of columns 
		int numberOfColumns = 0;
		for(int i=0; i<str.length; i++) {
			int tmp = str[i].split("\t").length;
			if(tmp > numberOfColumns) {
				numberOfColumns = tmp;
			}
		}
		
		//Initialize 2d array
		String datatypes[][] = new String[str.length][numberOfColumns];		
				
		for(int i=0;i<str.length;i++){
			str[i] = str[i].trim();                    
			String newLine[] = str[i].split("\t");		
			         
	        for(int j=0;j<newLine.length;j++){
	             datatypes[i][j]= newLine[j];          
	         }
	     }
		
		return datatypes;
	}
	
}
