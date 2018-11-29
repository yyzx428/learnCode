package Help;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import utils.DBTools;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DbStrategy implements Strategy {
    @Override
    public void writeData(SXSSFSheet sheet, Field[] fields) {
       /* int i;
        SqlSession session = DBTools.getSession();
        AtomicInteger l= new AtomicInteger();
        BankInfoDAO mapper = session.getMapper(BankInfoDAO.class);
        try {
            int count = mapper.getCount();
            AtomicInteger j = new AtomicInteger(1);
            for (i = 0; i < count; i += 10000) {
                List<BankInfo> user = mapper.getAll(i, 10000);
                user.forEach(x -> {
                    System.out.println(l.getAndIncrement());
                    SXSSFRow row1 = sheet.createRow(j.getAndIncrement());
                    int k = 0;
                    for (Field field : fields) {
                        String fieldName = field.getName();
                        String firstLetter = fieldName.substring(0, 1).toUpperCase();
                        String getter = "get" + firstLetter + fieldName.substring(1);
                        Method method;
                        Object value = null;
                        try {
                            method = x.getClass().getMethod(getter);
                            value = method.invoke(x);
                        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        Cell cell1 = row1.createCell(k++);
                        cell1.setCellValue(String.valueOf(value));
                    }
                });
            }
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }*/
    }
}
