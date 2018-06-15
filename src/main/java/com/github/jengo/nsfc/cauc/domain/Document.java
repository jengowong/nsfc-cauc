package com.github.jengo.nsfc.cauc.domain;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * {@link Document} pdf文档内容
 */
public class Document {

    public static final String PROJECT_AUTH_ID = "项目批准号";
    public static final String FUND_CATEGORY = "资助类别";
    public static final String FUND_SUBCLASS = "亚类说明";
    public static final String ANNOTATION = "附注说明";
    public static final String PROJECT_NAME = "项目名称";
    public static final String MANAGER_NAME = "负责人";
    public static final String MANAGER_PHONE = "电话";
    public static final String MANAGER_EMAIL = "电子邮件";
    public static final String MANAGER_GROUP = "依托单位";
    public static final String CONTACTER_NAME = "联系人";
    public static final String CONTACTER_PHONE = "电话";
    public static final String FUND_AMOUNT = "资助金额";
    public static final String YEAR_RANGE = "执行年限";
    public static final String PROJECT_ABSTRACT = "项目摘要";
    public static final String PROJECT_ABSTRACT_KEYWORDS_ZH = "关键词";
    public static final String PROJECT_ABSTRACT_KEYWORDS_EN = "Keywords";
    public static final String CONCLUSION_ABSTRACT = "结题摘要";
    public static final String CONCLUSION_ABSTRACT_KEYWORDS_ZH = "关键词";
    public static final String CONCLUSION_ABSTRACT_KEYWORDS_EN = "Keywords";
    public static final String CONTENT = "报告正文";
    public static final String OUTCOMES = "基金项目研究成果目录";

    public static List<String> basicInfoDescriptions() {
        List<String> result = Lists.newArrayList();
        result.add(PROJECT_AUTH_ID);
        result.add(FUND_CATEGORY);
        result.add(FUND_SUBCLASS);
        result.add(ANNOTATION);
        result.add(PROJECT_NAME);
        result.add(MANAGER_NAME);
        result.add(MANAGER_PHONE);
        result.add(MANAGER_EMAIL);
        result.add(MANAGER_GROUP);
        result.add(CONTACTER_NAME);
        result.add(CONTACTER_PHONE);
        result.add(FUND_AMOUNT);
        result.add(YEAR_RANGE);
        result.add(PROJECT_ABSTRACT);
        result.add(PROJECT_ABSTRACT_KEYWORDS_ZH);
        result.add(PROJECT_ABSTRACT_KEYWORDS_EN);
        result.add(CONCLUSION_ABSTRACT);
        result.add(CONCLUSION_ABSTRACT_KEYWORDS_ZH);
        result.add(CONCLUSION_ABSTRACT_KEYWORDS_EN);
        return result;
    }

    public static List<String> reportBodyDescriptions() {
        List<String> result = Lists.newArrayList();
        result.add(PROJECT_AUTH_ID);
        result.add(CONTENT);
        return result;
    }


    /** 项目批准号 */
    private String projectAuthId = StringUtils.EMPTY;
    /** 资助类别 */
    private String fundCategory = StringUtils.EMPTY;
    /** 亚类说明 */
    private String fundSubclass = StringUtils.EMPTY;
    /** 附注说明 */
    private String annotation = StringUtils.EMPTY;
    /** 项目名称 */
    private String projectName = StringUtils.EMPTY;
    /** 负责人 */
    private String managerName = StringUtils.EMPTY;
    /** 电话 */
    private String managerPhone = StringUtils.EMPTY;
    /** 电子邮件 */
    private String managerEmail = StringUtils.EMPTY;
    /** 依托单位 */
    private String managerGroup = StringUtils.EMPTY;
    /** 联系人 */
    private String contacterName = StringUtils.EMPTY;
    /** 电话 */
    private String contacterPhone = StringUtils.EMPTY;
    /** 直接费用（资助金额或是直接费用） */
    private String fundAmount = StringUtils.EMPTY;
    /** 执行年限 */
    private String yearRange = StringUtils.EMPTY;
    /** 项目摘要 */
    private String projectAbstract = StringUtils.EMPTY;
    /** 项目摘要关键词 */
    private String projectAbstractKeywordsZh = StringUtils.EMPTY;
    /** 项目摘要Keywords */
    private String projectAbstractKeywordsEn = StringUtils.EMPTY;
    /** 结题摘要 */
    private String conclusionAbstract = StringUtils.EMPTY;
    /** 结题摘要关键词 */
    private String conclusionAbstractKeywordsZh = StringUtils.EMPTY;
    /** 结题摘要keywords */
    private String conclusionAbstractKeywordsEn = StringUtils.EMPTY;
    /** 正文 */
    private String content = StringUtils.EMPTY;
    /** 研究成果文献 */
    private List<Outcome> outcomes = Lists.newArrayList();

    public String getProjectAuthId() {
        return projectAuthId;
    }

    public void setProjectAuthId(String projectAuthId) {
        if (StringUtils.isNotBlank(projectAuthId)) {
            this.projectAuthId = projectAuthId;
        }
    }

    public String getFundCategory() {
        return fundCategory;
    }

    public void setFundCategory(String fundCategory) {
        if (StringUtils.isNotBlank(fundCategory)) {
            this.fundCategory = fundCategory;
        }
    }

    public String getFundSubclass() {
        return fundSubclass;
    }

    public void setFundSubclass(String fundSubclass) {
        if (StringUtils.isNotBlank(fundSubclass)) {
            this.fundSubclass = fundSubclass;
        }
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        if (StringUtils.isNotBlank(annotation)) {
            this.annotation = annotation;
        }
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        if (StringUtils.isNotBlank(projectName)) {
            this.projectName = projectName;
        }
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        if (StringUtils.isNotBlank(managerName)) {
            this.managerName = managerName;
        }
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        if (StringUtils.isNotBlank(managerPhone)) {
            this.managerPhone = managerPhone;
        }
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        if (StringUtils.isNotBlank(managerEmail)) {
            this.managerEmail = managerEmail;
        }
    }

    public String getManagerGroup() {
        return managerGroup;
    }

    public void setManagerGroup(String managerGroup) {
        if (StringUtils.isNotBlank(managerGroup)) {
            this.managerGroup = managerGroup;
        }
    }

    public String getContacterName() {
        return contacterName;
    }

    public void setContacterName(String contacterName) {
        if (StringUtils.isNotBlank(contacterName)) {
            this.contacterName = contacterName;
        }
    }

    public String getContacterPhone() {
        return contacterPhone;
    }

    public void setContacterPhone(String contacterPhone) {
        if (StringUtils.isNotBlank(contacterPhone)) {
            this.contacterPhone = contacterPhone;
        }
    }

    public String getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(String fundAmount) {
        if (StringUtils.isNotBlank(fundAmount)) {
            this.fundAmount = fundAmount;
        }
    }

    public String getYearRange() {
        return yearRange;
    }

    public void setYearRange(String yearRange) {
        if (StringUtils.isNotBlank(yearRange)) {
            this.yearRange = yearRange;
        }
    }

    public String getProjectAbstract() {
        return projectAbstract;
    }

    public void setProjectAbstract(String projectAbstract) {
        if (StringUtils.isNotBlank(projectAbstract)) {
            this.projectAbstract = projectAbstract;
        }
    }

    public String getProjectAbstractKeywordsZh() {
        return projectAbstractKeywordsZh;
    }

    public void setProjectAbstractKeywordsZh(String projectAbstractKeywordsZh) {
        if (StringUtils.isNotBlank(projectAbstractKeywordsZh)) {
            this.projectAbstractKeywordsZh = projectAbstractKeywordsZh;
        }
    }

    public String getProjectAbstractKeywordsEn() {
        return projectAbstractKeywordsEn;
    }

    public void setProjectAbstractKeywordsEn(String projectAbstractKeywordsEn) {
        if (StringUtils.isNotBlank(projectAbstractKeywordsEn)) {
            this.projectAbstractKeywordsEn = projectAbstractKeywordsEn;
        }
    }

    public String getConclusionAbstract() {
        return conclusionAbstract;
    }

    public void setConclusionAbstract(String conclusionAbstract) {
        if (StringUtils.isNotBlank(conclusionAbstract)) {
            this.conclusionAbstract = conclusionAbstract;
        }
    }

    public String getConclusionAbstractKeywordsZh() {
        return conclusionAbstractKeywordsZh;
    }

    public void setConclusionAbstractKeywordsZh(String conclusionAbstractKeywordsZh) {
        if (StringUtils.isNotBlank(conclusionAbstractKeywordsZh)) {
            this.conclusionAbstractKeywordsZh = conclusionAbstractKeywordsZh;
        }
    }

    public String getConclusionAbstractKeywordsEn() {
        return conclusionAbstractKeywordsEn;
    }

    public void setConclusionAbstractKeywordsEn(String conclusionAbstractKeywordsEn) {
        if (StringUtils.isNotBlank(conclusionAbstractKeywordsEn)) {
            this.conclusionAbstractKeywordsEn = conclusionAbstractKeywordsEn;
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (StringUtils.isNotBlank(content)) {
            this.content = content;
        }
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        if (CollectionUtils.isNotEmpty(outcomes)) {
            this.outcomes = outcomes;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
