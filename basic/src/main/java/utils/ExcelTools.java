package utils;

import Annotation.ExcelColumnName;
import Help.Strategy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class ExcelTools {

    private Strategy strategy;

    public ExcelTools(Strategy strategy) {
        this.strategy = strategy;
    }

    public void write(Field[] fields) throws IOException {
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        SXSSFSheet sheet = workbook.createSheet("sheet1");
        SXSSFRow row = sheet.createRow(0);
        int i = 0;
        for (Field field : fields) {
            Cell cell = row.createCell(i++);
            cell.setCellValue(field.getAnnotation(ExcelColumnName.class).name());
        }

        strategy.writeData(sheet, fields);

        FileOutputStream fo = null;
        try {
            File file = new File("F:/temp/1.xlsx");
            if (!file.exists()) {
                file.createNewFile();
            }
            fo = new FileOutputStream(file);
            workbook.write(fo);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fo.flush();
        }
    }
}
