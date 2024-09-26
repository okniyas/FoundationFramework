import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadingDataFromExcel {
    public static void main(String[] args) throws IOException {
        //content path
        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/data/credentials.xlsx");
        XSSFSheet sheet = workbook.getSheet("PositiveData");
        int noOfRow = sheet.getLastRowNum();

        for(int i=0;i<=noOfRow;i++){
            XSSFRow row = sheet.getRow(i);

            for(int j=0;j<row.getLastCellNum();j++){
                XSSFCell cell = row.getCell(j);
                System.out.print(getCellData(cell)+"  ");
            }
            System.out.println();

        }
    }

    public static String getCellData(Cell cell){
        CellType cellType = cell.getCellType();

        if(cell == null){
            return "";
        }

        switch (cellType){
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BLANK:
                return "";
        }
        return null;
    }
}
