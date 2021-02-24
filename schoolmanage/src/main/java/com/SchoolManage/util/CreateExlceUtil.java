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
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateExlceUtil<T> {

    private Sheet sheet;

    private Map<String, String> eneity;

    private String path;

    private String dowloadPath;

    public CreateExlceUtil(HttpServletRequest request, Class cl, String name) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NameNullException {
        if (name == null || name == "") {
            throw new NameNullException("文件名不能为空！请检查name属性");
        }
        this.path = request.getServletContext().getRealPath("/") + "Excle/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.path = this.path + name + ".xlsx";
        System.out.println(path);
        this.dowloadPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/Excle/" + name + ".xlsx";
        System.out.println(this.dowloadPath);
        Class clazz = Eneity.class;
        Field[] fields = clazz.getFields();
        Method method = clazz.getMethod("getPojo");
        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(cl.getSimpleName().toUpperCase())) {
                this.eneity = (Map<String, String>) method.invoke((Eneity) field.get(field), null);
                break;
            }
        }
        Workbook workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet(name);
    }

    public String createExcle(List<T> list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        Row row0 = sheet.createRow(0);
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        Set<String> set = eneity.keySet();
        int num = 0;
        for (String str : set) {
            Cell cell = row0.createCell(num);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(str);
            num++;
        }
        for (int i = 1; i <= list.size(); i++) {
            Row row = sheet.createRow(i);
            T t = list.get(i - 1);
            num = 0;
            for (String field : set) {
                Cell cell = row.createCell(num);
                String getName = "get" + eneity.get(field).substring(0, 1).toUpperCase() + eneity.get(field).substring(1);
                Method method = t.getClass().getMethod(getName);
                Object o = method.invoke(t, null);
                if (o != null) {
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue(o.toString());
                }
                num++;
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        sheet.getWorkbook().write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return this.dowloadPath;
    }


}
