package com.github.jengo.nsfc.cauc;

import com.github.jengo.nsfc.cauc.domain.Context;
import com.github.jengo.nsfc.cauc.domain.Document;
import com.github.jengo.nsfc.cauc.domain.Separators;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.List;

/**
 * {@link Extracter}
 */
public class Extracter {
    private static final Logger LOG = LoggerFactory.getLogger(Extracter.class);

    private Extracter() {
    }

    public static void extract(final Context context) throws Exception {
        long begMillis = System.currentTimeMillis();
        File inDir = new File(context.getInDir());
        if (inDir.exists() && inDir.isDirectory()) {
            //过滤文件
            List<String> fileNames = Lists.newArrayList(
                    inDir.list(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.endsWith(context.getInSuffix());
                        }
                    }));
            if (CollectionUtils.isNotEmpty(fileNames)) {
                //文件排序
                Collections.sort(fileNames);
                //分别抽取文件
                for (String fileName : fileNames) {
                    String absFilePath = context.getInDir() + "/" + fileName;
                    LOG.info("抽取数据文件: {}", absFilePath);
                    //加载pdf文档
                    PDDocument document = PDDocument.load(new File(absFilePath));
                    //获取页码
                    int pages = document.getNumberOfPages();
                    //读文本内容
                    PDFTextStripper pts = new PDFTextStripper();
                    //设置按顺序输出
                    pts.setSortByPosition(true);
                    pts.setStartPage(1);
                    pts.setEndPage(pages);
                    String content = pts.getText(document);
                    Document doc = parseDocument(content);
                    if (null != doc) {
                        context.addDocument(doc);
                    }
                    document.close();
                    return;
                }
            }
        } else {
            LOG.info("输入目录不存在: {}", context.getInDir());
        }
        LOG.info("抽取耗时: {}ms", System.currentTimeMillis() - begMillis);
    }

    private static Document parseDocument(String contentInLine) {
        Document document = null;
        if (StringUtils.isNotBlank(contentInLine)) {
            document = new Document();
            String[] lines = StringUtils.split(contentInLine, Separators.LINE_FEED);
            for (int i = 0; i < lines.length; ) {
                String line = lines[i];
                String[] splits;
                if (StringUtils.isNotBlank(line)) {
                    if (StringUtils.contains(line, Document.PROJECT_AUTH_ID)) {
                        //TODO 此处需要特殊处理，有找不到的情况
                        document.setProjectAuthId(line);
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.FUND_CATEGORY)) {
                        splits = StringUtils.split(line, Separators.SPACE);
                        document.setFundCategory(splits[1]);
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.FUND_SUBCLASS)) {
                        splits = StringUtils.split(line, Separators.SPACE);
                        document.setFundSubclass(splits[1]);
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.ANNOTATION)) {
                        splits = StringUtils.split(line, Separators.SPACE);
                        document.setAnnotation(splits[1]);
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.PROJECT_NAME)) {
                        //TODO 此处需要有一个算法处理
                        document.setProjectName(line);
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.MANAGER_NAME)) {
                        document.setManagerName(line);
                        ++i;
                        //TODO 解析电话、电子邮件、依托单位
                        continue;
                    }
                    if (StringUtils.contains(line, Document.CONTACTER_NAME)) {
                        splits = StringUtils.split(line, Separators.SPACE);
                        document.setContacterName(splits[1]);
                        //TODO 解析电话
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.FUND_AMOUNT)) {
                        splits = StringUtils.split(line, Separators.SPACE);
                        document.setFundAmount(splits[1]);
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.YEAR_RANGE)) {
                        splits = StringUtils.split(line, Separators.SPACE);
                        document.setYearRange(splits[1]);
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.PROJECT_ABSTRACT)) {
                        //TODO 此处需要有一个算法处理：把后边读到的内容作为摘要
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.PROJECT_ABSTRACT_KEYWORDS_ZH)) {
                        //TODO 此处需要有一个算法处理
                        document.setProjectAbstractKeywordsZh(line);
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.PROJECT_ABSTRACT_KEYWORDS_EN)) {
                        //TODO 此处需要有一个算法处理
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.CONCLUSION_ABSTRACT)) {
                        //TODO 此处需要有一个算法处理
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.CONCLUSION_ABSTRACT_KEYWORDS_ZH)) {
                        //TODO 此处需要有一个算法处理
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.CONCLUSION_ABSTRACT_KEYWORDS_EN)) {
                        //TODO 此处需要有一个算法处理
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.CONTENT)) {
                        //TODO 此处需要有一个算法处理
                        ++i;
                        continue;
                    }
                    if (StringUtils.contains(line, Document.OUTCOMES)) {
                        //TODO 此处需要有一个算法处理
                        ++i;
                        continue;
                    }
                }
                i++;
            }
        }
        return document;
    }

}
