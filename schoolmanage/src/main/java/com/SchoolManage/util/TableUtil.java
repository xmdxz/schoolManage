package com.SchoolManage.util;

import com.SchoolManage.Enum.Eneity;
import com.SchoolManage.exception.FieldNotExistException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
        inputStream.close();
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
        inputStream.close();
    }

    public List<String> GetTableHead() {
        List<String> arrayList = new ArrayList();
        Row row = sheet.getRow(0);
        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null) {
                cell.setCellType(CellType.STRING);
                String field = cell.getStringCellValue();
                if (!("".equals(field))) {
                    field = field.trim();
                    field = field.replaceAll(" ", "");
                    arrayList.add(field);
                }
            } else {
                arrayList.add("");
            }
        }
        return arrayList;
    }

    @Deprecated
    public Map<String, Integer> GetTableMap() {
        List<String> list = GetTableHead();
        Object[] objects = this.eneity.keySet().toArray();
        List<Object> list1 = Arrays.asList(objects);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            Integer integer = list.indexOf(list1.get(i));
            map.put(list1.get(i).toString(), integer);
        }
        return map;
    }


    public List<T> GetTableRowContent(List<T> database) throws IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, FieldNotExistException {
        List<T> Ts = new ArrayList<>();
        Set<String> set = this.eneity.keySet();
        List<String> ls = GetTableHead();
        for (int i = 1; i < GetRows(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                T t = (T) clazz.newInstance();
                for (String s : set) {
                    String field = this.eneity.get(s);
                    Cell cell = row.getCell(ls.indexOf(s));
                    if (cell != null) {
                        String value = getExcleTypeStringValue(cell);
                        Method method = clazz.getMethod("set" + field.substring(0, 1).toUpperCase() + field.substring(1), clazz.getDeclaredField(field).getType());
                        method.invoke(t, getValue(clazz.getDeclaredField(field).getType().getSimpleName(), formatValueForFUlltoHalf(value).trim()));
                    }
                }
                if (!Ts.contains(t) && !getIsNull(t)) {
                    Ts.add(t);
                }
            }
        }
        for (T pojo : database) {
            if (Ts.contains(pojo)) {
                Ts.remove(pojo);
            }
        }
        return Ts;
    }

    public List<T> GetTableRowContent(List<T> database, String comy) throws IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, FieldNotExistException {
        List<T> Ts = new ArrayList<>();
        Set<String> set = this.eneity.keySet();
        List<String> ls = GetTableHead();
        for (int i = 1; i < GetRows(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                T t = (T) clazz.newInstance();
                for (String s : set) {
                    String field = this.eneity.get(s);
                    Cell cell = row.getCell(ls.indexOf(s));
                    if (cell != null) {
                        String value = getExcleTypeStringValue(cell);
                        Method method = clazz.getMethod("set" + field.substring(0, 1).toUpperCase() + field.substring(1), clazz.getDeclaredField(field).getType());
                        method.invoke(t, getValue(clazz.getDeclaredField(field).getType().getSimpleName(), formatValueForFUlltoHalf(value).trim()));
                    }
                }
                clazz.getMethod("setComy", String.class).invoke(t, comy.toString());
                if (!Ts.contains(t) && !getIsNull(t)) {
                    Ts.add(t);
                }
            }
        }
        for (T pojo : database) {
            if (Ts.contains(pojo)) {
                Ts.remove(pojo);
            }
        }
        return Ts;
    }


    public List<T> GetTableRowContent() throws IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, FieldNotExistException {
        List<T> Ts = new ArrayList<>();
        Set<String> set = this.eneity.keySet();
        List<String> ls = GetTableHead();
        for (int i = 1; i < GetRows(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                T t = (T) clazz.newInstance();
                for (String s : set) {
                    String field = this.eneity.get(s);
                    Cell cell = row.getCell(ls.indexOf(s));
                    if (cell != null) {
                        String value = getExcleTypeStringValue(cell);
                        Method method = clazz.getMethod("set" + field.substring(0, 1).toUpperCase() + field.substring(1), clazz.getDeclaredField(field).getType());
                        method.invoke(t, getValue(clazz.getDeclaredField(field).getType().getSimpleName(), formatValueForFUlltoHalf(value).trim()));
                    }
                }
                if (!Ts.contains(t) && !getIsNull(t)) {
                    Ts.add(t);
                }
            }
        }
        return Ts;
    }

    public List<T> GetTableRowContent(String comy) throws IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, FieldNotExistException {
        List<T> Ts = new ArrayList<>();
        Set<String> set = this.eneity.keySet();
        List<String> ls = GetTableHead();
        for (int i = 1; i < GetRows(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                T t = (T) clazz.newInstance();
                for (String s : set) {
                    String field = this.eneity.get(s);
                    Cell cell = row.getCell(ls.indexOf(s));
                    if (cell != null) {
                        String value = getExcleTypeStringValue(cell);
                        Method method = clazz.getMethod("set" + field.substring(0, 1).toUpperCase() + field.substring(1), clazz.getDeclaredField(field).getType());
                        method.invoke(t, getValue(clazz.getDeclaredField(field).getType().getSimpleName(), formatValueForFUlltoHalf(value).trim()));
                    }
                }
                clazz.getMethod("setComy", String.class).invoke(t, comy.toString());
                if (!Ts.contains(t) && !getIsNull(t)) {
                    Ts.add(t);
                }
            }
        }
        return Ts;
    }

    public boolean getIsNull(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Set<String> set = this.eneity.keySet();
        List<Boolean> list = new ArrayList<>();
        for (String s : set) {
            String field = this.eneity.get(s);
            Method method = clazz.getMethod("get" + field.substring(0, 1).toUpperCase() + field.substring(1));
            Object o = method.invoke(t, null);
            if (o == null) {
                list.add(false);
            } else {
                list.add(true);
            }
        }
        if (!list.contains(true)) {
            return true;
        } else {
            return false;
        }
    }

    public Object getValue(String type, String value) {
        if (value == null || "".equals(value)) {
            return null;
        }
        Object value1 = new Object();
        if ("String".equalsIgnoreCase(type)) {
            if (value.substring(value.lastIndexOf(".") + 1).matches("^0*")) {
                value = value.substring(0, value.lastIndexOf("."));
            }
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
        } else if ("date".equalsIgnoreCase(type)) {
            value1 = Date.valueOf(value.replace("/", "-"));
        } else if ("datetime".equalsIgnoreCase(type)) {
            value1 = Timestamp.valueOf(value.replace("/", "-"));
        } else if ("timestamp".equalsIgnoreCase(type)) {
            value1 = Timestamp.valueOf(value);
        }
        return value1;
    }

    public String formatValueForFUlltoHalf(String value) {
        if (value == null || "".equals(value)) {
            return "";
        }
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int unicode = (int) chars[i];
            if (unicode >= 65281 && unicode <= 65374) {
                chars[i] = (char) (unicode - 65248);
            } else if (unicode == 12288) {
                chars[i] = (char) 32;
            } else if (unicode >= 128 && unicode <= 160) {
                chars[i] = (char) 32;
            }
        }
        return new String(chars);
    }

    public String getExcleTypeStringValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    java.util.Date date = cell.getDateCellValue();
                    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                    return dateFormat.format(date).trim();
                } else {
                    DecimalFormat decimalFormat = new DecimalFormat("0");
                    return decimalFormat.format(cell.getNumericCellValue()).trim();
                }
            default:
                return "";
        }
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
