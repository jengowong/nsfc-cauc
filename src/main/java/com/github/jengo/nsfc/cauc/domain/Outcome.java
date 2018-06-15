package com.github.jengo.nsfc.cauc.domain;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * {@link Outcome} 研究成果
 */
public class Outcome {

    private static final String PROJECT_AUTH_ID = "项目批准号";
    private static final String AUTHOR = "作者";
    private static final String TITLE = "论文名";
    private static final String PUBLICATION = "出版物";
    private static final String YEAR = "发表年";

    public static List<String> outcomeDescriptions() {
        List<String> result = Lists.newArrayList();
        result.add(PROJECT_AUTH_ID);
        result.add(AUTHOR);
        result.add(TITLE);
        result.add(PUBLICATION);
        result.add(YEAR);
        return result;
    }


    /** 项目批准号 */
    private String projectAuthId = StringUtils.EMPTY;
    /** 作者 */
    private String author = StringUtils.EMPTY;
    /** 论文名 */
    private String title = StringUtils.EMPTY;
    /** 出版物 */
    private String publication = StringUtils.EMPTY;
    /** 发表年 */
    private String year = StringUtils.EMPTY;

    public String getProjectAuthId() {
        return projectAuthId;
    }

    public void setProjectAuthId(String projectAuthId) {
        if (StringUtils.isNotBlank(projectAuthId)) {
            this.projectAuthId = projectAuthId;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (StringUtils.isNotBlank(author)) {
            this.author = author;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (StringUtils.isNotBlank(title)) {
            this.title = title;
        }
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        if (StringUtils.isNotBlank(publication)) {
            this.publication = publication;
        }
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        if (StringUtils.isNotBlank(year)) {
            this.year = year;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
