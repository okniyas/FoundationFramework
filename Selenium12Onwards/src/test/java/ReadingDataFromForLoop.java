import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadingDataFromForLoop {
    public static void main(String[] args) throws IOException {
        //content path
        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/data/credentials.xlsx");
        XSSFSheet sheet = workbook.getSheet("PositiveData");

        for(Row row : sheet){
            for(Cell cell : row){
                System.out.print(cell+" ");
            }
            System.out.println();
        }
    }
}
