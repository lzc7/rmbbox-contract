package com.zipi.enums.bbt;

import com.zipi.base.BaseEnum;

/**
 * Created by Tony on 2015/6/8.
 */
public enum  ArticleCategory implements BaseEnum{
    HOMEPAGE("首页大图", false),
    IMAGE("其他图片", false),
    INTRODUCTION("公司简介", true),
    REPORT("业绩报表", true),
    RESPONSIBILTY("社会责任", false),
    COOPERATION("合作伙伴", true),
    COVERAGE("媒体报道", false),
    NEWS("行业新闻", false),
    COMPANYNEWS("公司动态", true),
    RECRUITER("工作机会", true),
    LINK("友情链接", true),
    CONTACT("联系方式", true),
    DECLARATION("服务声明", true),
    PUBLICATION("最新公告", false),
    PROJECT("项目公告", false),
    HELP("帮助中心", false),
    SAFETY("安全保障", true),
    MOBILEBANNER("客户端Banner", true),
    YOUXUANBANNER("优选Banner", true),
    HOMEPAGEBANNER("网站首页Banner",true),
    PUBLICSERVICEACTIVITIES("公益活动",true),
    BBTEVENTS("大事记",true),
    COMPANYACTIVITY("活动花絮",true),
    HOMEICON("首页ICON",true),
    OPERATIONREPORT("运营报告",true),
    MAJORMATTERS("重大事项",true),
    P2PKNOWLEDGE ("网贷知识",true),
    P2PRULE("监管法规",true),
    OTHER("其他", false);

    private final String key;

    private final boolean single;

    private ArticleCategory(String key, boolean single) {
        this.key = key;
        this.single = single;
    }

    @Override
    public String getKey() {
        return key;
    }

    public boolean isSingle() {
        return single;
    }
}
