package com.github.jengo.nsfc.cauc;

import com.github.jengo.nsfc.cauc.domain.Context;
import com.github.jengo.nsfc.cauc.domain.Document;
import com.github.jengo.nsfc.cauc.domain.Outcome;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * {@link Printer}
 */
public class Printer {
    private static final Logger LOG = LoggerFactory.getLogger(Printer.class);

    private Printer() {
    }

    public static void print(Context context) throws Exception {
        long begMillis = System.currentTimeMillis();
        if (CollectionUtils.isNotEmpty(context.getDocuments())) {
            printBasicInfoExcel(context);
            printReportBodyExcel(context);
            printOutcomeExcel(context);
        }
        LOG.info("打印耗时{}ms", System.currentTimeMillis() - begMillis);
    }

    private static void printBasicInfoExcel(Context context) throws Exception {
        File file = new File(context.getOutDir() + "/" + "基本信息表.xls");
        if (file.exists()) {
            LOG.info("文件{}已存在, 将覆盖此文件", file);
        } else {
            LOG.info("文件{}不存在, 将创建新文件", file);
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("sheet1");
        int rowIdx = 0;
        Row row;
        //写表头
        List<String> headers = Document.basicInfoDescriptions();
        row = sheet.createRow(rowIdx++);
        for (int cellIdx = 0; cellIdx < headers.size(); cellIdx++) {
            row.createCell(cellIdx).setCellValue(headers.get(cellIdx));
        }
        //写表体
        for (Document doc : context.getDocuments()) {
            row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(doc.getProjectAuthId());
            row.createCell(1).setCellValue(doc.getFundCategory());
            row.createCell(2).setCellValue(doc.getFundSubclass());
            row.createCell(3).setCellValue(doc.getAnnotation());
            row.createCell(4).setCellValue(doc.getProjectName());
            row.createCell(5).setCellValue(doc.getManagerName());
            row.createCell(6).setCellValue(doc.getManagerPhone());
            row.createCell(7).setCellValue(doc.getManagerEmail());
            row.createCell(8).setCellValue(doc.getManagerGroup());
            row.createCell(9).setCellValue(doc.getContacterName());
            row.createCell(10).setCellValue(doc.getContacterPhone());
            row.createCell(11).setCellValue(doc.getFundAmount());
            row.createCell(12).setCellValue(doc.getYearRange());
            row.createCell(13).setCellValue(doc.getProjectAbstract());
            row.createCell(14).setCellValue(doc.getProjectAbstractKeywordsZh());
            row.createCell(15).setCellValue(doc.getProjectAbstractKeywordsEn());
            row.createCell(16).setCellValue(doc.getConclusionAbstract());
            row.createCell(17).setCellValue(doc.getConclusionAbstractKeywordsZh());
            row.createCell(18).setCellValue(doc.getConclusionAbstractKeywordsEn());
        }
        wb.write(out);
        LOG.info("写excel文件成功:{}", file);
    }

    private static void printReportBodyExcel(Context context) throws Exception {
        File file = new File(context.getOutDir() + "/" + "报告正文.xls");
        if (file.exists()) {
            LOG.info("文件{}已存在, 将覆盖此文件");
        } else {
            LOG.info("文件{}不存在, 将创建新文件");
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("sheet1");
        int rowIdx = 0;
        Row row;
        //写表头
        List<String> headers = Document.reportBodyDescriptions();
        row = sheet.createRow(rowIdx++);
        for (int cellIdx = 0; cellIdx < headers.size(); cellIdx++) {
            row.createCell(cellIdx).setCellValue(headers.get(cellIdx));
        }
        //写表体
        for (Document doc : context.getDocuments()) {
            row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(doc.getProjectAuthId());
            row.createCell(1).setCellValue(doc.getContent());
        }
        wb.write(out);
        LOG.info("写excel文件成功:{}", file);
    }

    private static void printOutcomeExcel(Context context) throws Exception {
        File file = new File(context.getOutDir() + "/" + "基金项目研究成果目录.xls");
        if (file.exists()) {
            LOG.info("文件{}已存在, 将覆盖此文件");
        } else {
            LOG.info("文件{}不存在, 将创建新文件");
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("sheet1");
        int rowIdx = 0;
        Row row;
        //写表头
        List<String> headers = Outcome.outcomeDescriptions();
        row = sheet.createRow(rowIdx++);
        for (int cellIdx = 0; cellIdx < headers.size(); cellIdx++) {
            row.createCell(cellIdx).setCellValue(headers.get(cellIdx));
        }
        //写表体
        for (Document doc : context.getDocuments()) {
            for (Outcome outcome : doc.getOutcomes()) {
                row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(outcome.getProjectAuthId());
                row.createCell(1).setCellValue(outcome.getAuthor());
                row.createCell(2).setCellValue(outcome.getTitle());
                row.createCell(3).setCellValue(outcome.getPublication());
                row.createCell(4).setCellValue(outcome.getYear());
            }
        }
        wb.write(out);
        LOG.info("写excel文件成功:{}", file);
    }

}
