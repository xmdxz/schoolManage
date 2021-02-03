package com.SchoolManage.util;

import com.SchoolManage.Enum.Eneity;
import com.SchoolManage.exception.FieldNotExistException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TableUtil<T> {

    private Sheet sheet;

    private Class clazz;

    private Map<String, String> eneity;

    public TableUtil(String path, Class clazz) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String extString = path.substring(path.lastIndexOf("."));
        InputStream inputStream = new FileInputStream(path);
        Field[] fields = Eneity.class.getFields();
        Method method = Eneity.class.getMethod("getPojo");
        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(clazz.getSimpleName().toUpperCase())) {
                this.eneity = (Map<String, String>) method.invoke((Eneity) field.get(field), null);
                break;
            }
        }
        this.clazz = clazz;
        if (".xls".equals(extString)) {
            sheet = new HSSFWorkbook(inputStream).getSheetAt(0);
        } else if (".xlsx".equals(extString)) {
            sheet = new XSSFWorkbook(inputStream).getSheetAt(0);
        }
    }

    public TableUtil(File file, Class clazz) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String path = file.getName();
        String extString = path.substring(path.lastIndexOf("."));
        Field[] fields = Eneity.class.getFields();
        Method method = Eneity.class.getMethod("getPojo");
        InputStream inputStream = new FileInputStream(file);
        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(clazz.getSimpleName().toUpperCase())) {
                this.eneity = (Map<String, String>) method.invoke((Eneity) field.get(field), null);
                break;
            }
        }
        this.clazz = clazz;
        if (".xls".equals(extString)) {
            sheet = new HSSFWorkbook(inputStream).getSheetAt(0);
        } else if (".xlsx".equals(extString)) {
            sheet = new XSSFWorkbook(inputStream).getSheetAt(0);
        }
    }

    public List<String> GetTableHead() {
        List<String> arrayList = new ArrayList();
        Row row = sheet.getRow(0);
        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null) {
                cell.setCellType(CellType.STRING);
                if (!("".equals(cell.getStringCellValue()))) {
                    arrayList.add(cell.getStringCellValue());
                }
            }
        }
        return arrayList;
    }

    public List<T> GetTableRowContent() throws IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, FieldNotExistException {
        List<T> Ts = new ArrayList<>();
        for (int i = 1; i < GetRows(); i++){
            Row row = sheet.getRow(i);
            T t = (T) clazz.newInstance();
            List<String> list = GetTableHead();
            for (int index = 0, num = 0; index < list.size(); index++, num++) {
                String field = this.eneity.get(list.get(index));
                if (field == null) {
                    throw new FieldNotExistException("实体类中没有与表格中表头:" + list.get(index) + "对应的属性");
                }
                Cell cell = row.getCell(num);
                while (cell == null) {
                    cell = row.getCell(++num);
                }
                cell.setCellType(CellType.STRING);
                Method method = clazz.getMethod("set" + field.substring(0, 1).toUpperCase() + field.substring(1), clazz.getDeclaredField(field).getType());
                method.invoke(t, getValue(clazz.getDeclaredField(field).getType().getSimpleName(), cell.getStringCellValue()));
            }
            Ts.add(t);
        }
        return Ts;
    }

    public Object getValue(String type, String value) {
        Object value1 = new Object();
        if ("String".equalsIgnoreCase(type)) {
            value1 = value.toString();
        } else if ("int".equalsIgnoreCase(type) || "Integer".equalsIgnoreCase(type)) {
            value1 = Integer.parseInt(value);
        } else if ("Long".equalsIgnoreCase(type)) {
            value1 = Long.parseLong(value);
        } else if ("float".equalsIgnoreCase(type)) {
            value1 = Double.parseDouble(value);
        } else if ("double".equalsIgnoreCase(type)) {
            value1 = Double.parseDouble(value);
        } else if ("boolean".equalsIgnoreCase(type)) {
            value1 = Boolean.parseBoolean(value);
        }
        return value1;
    }

    /**
     * 获取真实列数，为了防止表格中无表头但有内容，管理员应该尽可能防止这种情况发生，否则会造成数据丢失
     */
    public int GetColumn() {
        return GetTableHead().size();
    }

    /**
     * 获取行数,由于poi是由0为基，所以他返回的结果为真实-1.所以这里加了1
     *
     * @return
     */
    public int GetRows() {
        return sheet.getLastRowNum() + 1;
    }


}
