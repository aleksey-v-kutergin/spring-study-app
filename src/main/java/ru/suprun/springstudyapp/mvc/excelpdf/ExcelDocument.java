package ru.suprun.springstudyapp.mvc.excelpdf;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 *   Представление экселевского документа.
 */
public class ExcelDocument extends AbstractExcelView
{

    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook hssfWorkbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception
    {
        // New Excel Sheet
        HSSFSheet excelSheet = hssfWorkbook.createSheet("Simple excel example");

        // Set excel file name
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=excelDocument.xls");

        Font font = hssfWorkbook.createFont();
        font.setFontName("Arial");
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);

        // Create cell style for header
        CellStyle styleHeader = hssfWorkbook.createCellStyle();
        styleHeader.setFillForegroundColor(HSSFColor.BLUE.index);
        styleHeader.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styleHeader.setFont(font);

        // Get data from model
        List<Cat> cats = (List<Cat>) map.get("modelObject");
        int rowCount = 1;
        for(Cat cat : cats)
        {
            HSSFRow row = excelSheet.createRow(rowCount++);
            row.createCell(0).setCellValue(cat.getName());
            row.createCell(1).setCellValue(cat.getColor());
            row.createCell(2).setCellValue(cat.getWeight());
        }
    }

    public void setExcelHeader(HSSFSheet excelSheet, CellStyle styleHeader)
    {
        // Set excel header names
        HSSFRow header = excelSheet.createRow(0);

        header.createCell(0).setCellValue("Name");
        header.getCell(0).setCellStyle(styleHeader);

        header.createCell(1).setCellValue("Wieght");
        header.getCell(1).setCellStyle(styleHeader);

        header.createCell(2).setCellValue("Color");
        header.getCell(2).setCellStyle(styleHeader);
    }
}
