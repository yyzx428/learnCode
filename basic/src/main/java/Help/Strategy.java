package Help;

import org.apache.poi.xssf.streaming.SXSSFSheet;

import java.lang.reflect.Field;

public interface Strategy {
    void writeData(SXSSFSheet sheet, Field[] fields);
}
