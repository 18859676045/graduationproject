package com.qxf.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;


/**
 * @Auther: qiuxinfa
 * @Date: 2020/4/23
 * @Description: com.qxf.utils
 */
public class ExcelUtil {

    private final static String xls = "xls";
    private final static String xlsx = "xlsx";

    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param title     标题
     * @param values    内容
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格样式，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明单元格
        HSSFCell cell = null;

        //创建标题
        for (int i = 0; i < title.length; i++) {
            //创建一个单元格
            cell = row.createCell(i);
            //给单元格赋值
            cell.setCellValue(title[i]);
            //给单元格设置样式
            cell.setCellStyle(style);
        }

        //创建内容
        if (values != null && values[0].length > 0) {
            for (int i = 0; i < values.length; i++) {
                //从第二行开始创建数据填充的行，下标为1
                row = sheet.createRow(i + 1);
                for (int j = 0; j < values[i].length; j++) {
                    //将内容按顺序赋给对应的列对象
                    row.createCell(j).setCellValue(values[i][j]);
                }
            }
        }
        return wb;
    }


    /**
     * 读入excel文件，解析后返回
     *
     * @param file
     * @throws IOException
     */
    public static List<String[]> readExcel(MultipartFile file) throws IOException {
        //检查文件
        checkFile(file);
        //获得Workbook工作薄对象
        Workbook workbook = getWorkBook(file);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String[]> list = new ArrayList<String[]>();
        if (workbook != null) {
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                String sheetName = workbook.getSheetName(sheetNum);
                //获得当前sheet工作表
                org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(sheetNum);
                if (sheet == null) {
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if (row == null) {
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    String[] cells = new String[row.getPhysicalNumberOfCells()];
                    //循环当前行
                    for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
                //  workbook.cloneSheet(sheetNum);
            }
//            workbook.close();
        }
        return list;
    }

    public static void checkFile(MultipartFile file) throws IOException {
        //判断文件是否存在
        if (null == file) {
            System.out.println("文件不存在！");
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
            System.out.println(fileName + "不是excel文件");
            throw new IOException(fileName + "不是excel文件");
        }
    }

    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.endsWith(xls)) {
                //2003
                workbook = new HSSFWorkbook(is);
            } else if (fileName.endsWith(xlsx)) {
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return workbook;
    }

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }


    /**
     * 根据模板导出Excel
     *
     * @param values 内容
     * @return
     */
    public static Workbook ModelgetHSSFWorkbook(String[][] values, String fileName, HttpServletResponse response) throws IOException {

        //"excel/coollect.xls"
        Resource resource = new ClassPathResource("excel/coollect.xls");

        String path = resource.getFile().getPath();     //获取文件路径
        /* 数据写入模板文件中 */
        //更改文件名编码
        String gFileName = URLEncoder.encode(fileName, "UTF-8");
        //如进行下载名为：文件（3）.txt，下载时显示名为：文件+（3）.txt --空格变为了+号
        //解决办法如下
        String dFileName = gFileName.replaceAll("\\+", "%20");
        InputStream in = null;
        Workbook exl = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            in = new FileInputStream(path);
            exl = WorkbookFactory.create(in);
            Sheet sheet = exl.getSheetAt(0);
            Row row = sheet.createRow(4);
            //创建内容
            if (values != null && values[0].length > 0) {
                for (int i = 0; i < values.length; i++) {
                    //从第二行开始创建数据填充的行，下标为1
                    row = sheet.createRow(i + 1);
                    for (int j = 0; j < values[i].length; j++) {
                        //将内容按顺序赋给对应的列对象
                        row.createCell(j).setCellValue(values[i][j]);
                    }
                }
            }
            //激活浏览器弹出窗口
            response.setContentType("application/x-msdownload");
            //浏览器弹出窗口显示的文件名
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            exl.write(out);
            //in = new ByteArrayInputStream(out.toByteArray());
            response.getOutputStream().write(out.toByteArray());

            return exl;

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }finally {
            try {
                if (exl != null) {
                    exl.close();
                }
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        return null;
    }

    }
