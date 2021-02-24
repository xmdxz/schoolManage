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

    public static <T> String getTemplate(HttpServletRequest request, T t, String name) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, NameNullException {
        if (name == null || name == "") {
            throw new NameNullException("文件名不能为空！请检查name属性");
        }
        Class cl = t.getClass();
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
            Row row1 = sheet.createRow(1);
            int num = 0;
            for (String fieldName : set) {
                sheet.setColumnWidth(num, (int) (sheet.getColumnWidth(num) * 1.5));
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setAlignment(HorizontalAlignment.CENTER);
                cellStyle.setBorderTop(BorderStyle.THIN);
                Cell cell = row.createCell(num);
                Cell cell1 = row1.createCell(num);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(fieldName);
                CellStyle cellStyle1 = workbook.createCellStyle();
                cellStyle1.setAlignment(HorizontalAlignment.CENTER);
                cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cellStyle1.setFillForegroundColor(IndexedColors.RED.getIndex());
                cellStyle1.setBorderTop(BorderStyle.THIN);
                Method method1 = cl.getMethod("get" + map.get(fieldName).substring(0, 1).toUpperCase() + map.get(fieldName).substring(1));
                String value = method1.invoke(t, null).toString();
                cell1.setCellStyle(cellStyle1);
                cell1.setCellValue(value);
                num++;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/Template/" + name + ".xlsx";
        }
        return null;
    }

}
