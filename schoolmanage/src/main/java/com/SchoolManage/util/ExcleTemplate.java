package com.SchoolManage.util;

import com.SchoolManage.Enum.Eneity;
import com.SchoolManage.exception.NameNullException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ExcleTemplate {

    public static String getTemplate(HttpServletRequest request, Class cl, String name) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, NameNullException {
        if (name == null || name == "") {
            throw new NameNullException("文件名不能为空！请检查name属性");
        }
        String path = request.getServletContext().getRealPath("/") + "Template/";
        Map<String, String> map = new LinkedHashMap<>();
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        path = path + name + ".xlsx";
        Class clazz = Eneity.class;
        Field[] fields = clazz.getFields();
        Method method = clazz.getMethod("getPojo");
        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(cl.getSimpleName().toUpperCase())) {
                map = (Map<String, String>) method.invoke((Eneity) field.get(field), null);
                break;
            }
        }
        if (map != null) {
            Set<String> set = map.keySet();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(name);
            Row row = sheet.createRow(0);
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            int num = 0;
            for (String fieldName : set) {
                Cell cell = row.createCell(num);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(fieldName);
                num++;
            }
            workbook.write(new FileOutputStream(path));
            return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/Template/" + name + ".xlsx";
        }
        return null;
    }

}
