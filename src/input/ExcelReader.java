package input;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader implements DocumentReader {
	
	String docText= "";
	String path;
	
	public ExcelReader(String path) {
		this.path = path;
	}
	
	public String read(){ 
		
		
		StringBuilder stringBuilder = new StringBuilder();
		int counter = 0;
		
        try(Workbook workbook = new XSSFWorkbook(path)){
        	Sheet datatypeSheet = workbook.getSheetAt(0);
        	Iterator<Row> iterator = datatypeSheet.iterator();

        	while (iterator.hasNext()) {

        		Row currentRow = iterator.next();
        		Iterator<Cell> cellIterator = currentRow.iterator();
        		if(counter>0) { stringBuilder.append("\n");}   //new line after each row except the first one
        		counter++;
            
        		while (cellIterator.hasNext()) {

        			Cell currentCell = cellIterator.next();
                
        			if (currentCell.getCellType() == CellType.STRING) {
        				stringBuilder.append(currentCell.getStringCellValue() + "\t");
        			} else if (currentCell.getCellType() == CellType.NUMERIC) {
        				stringBuilder.append(currentCell.getNumericCellValue() + "\t");
                	
                //Doesn't work for blank cells because we use cell iterator (MAYBE FIX)!!!
        			}/*else if (currentCell.getCellType() == CellType.BLANK) {  
        				stringBuilder.append("\t\t");
        				System.out.println("found blank");
        			}*/
        		}
        	}
        
        	docText = stringBuilder.toString();
        	workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return docText;
	}

}
