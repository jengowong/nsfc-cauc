package com.github.jengo.nsfc.cauc.domain;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * {@link Context}
 */
public class Context {
    private static final Logger LOG = LoggerFactory.getLogger(Context.class);


    /** 输入绝对路径 */
    private String inDir;
    /** 输入文件后缀 */
    private String inSuffix;
    /** 输出绝对路径 */
    private String outDir;
    /** 文档 */
    private List<Document> documents = Lists.newArrayList();

    public Context(String inDir, String inSuffix, String outDir) {
        this.inDir = inDir;
        this.inSuffix = inSuffix;
        this.outDir = outDir;
    }

    public String getInDir() {
        return inDir;
    }

    public String getInSuffix() {
        return inSuffix;
    }

    public String getOutDir() {
        return outDir;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void addDocument(Document document) {
        if (null != document) {
            this.documents.add(document);
            LOG.info("documents.size={}", this.documents.size());
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
