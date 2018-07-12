package com.zipi.enums.bbt;//package com.rmbbox.enums.bbt;
//
//
//import com.google.common.base.Preconditions;
//import com.zipi.base.BaseEnum;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public enum RegisterResourceType implements BaseEnum {
//
//   /* BAIDU("百度推广"),
//    SHOUJI_BAIDU("手机百度"),
//    BAIDU_WANGMENG("百度网盟"),
//    BAIDU_ZHIXIN("百度知心"),
//    NAVI_2345("2345导航"),
//    GUESS_U_2345("2345猜你喜欢"),
//    WEIXIN("微信"),
//    SHIJIJIAYUAN("世纪佳缘"),
//    XICAI("希才"),
//    haosou("360推广"),
//    JIUMENG("9盟"),
//    WANGYI1("网易有道1"),
//    WANGYI2("网易有道2"),
//    WANGYI3("网易有道3"),
//    WANGYI4("网易有道4"),
//    WANGYI5("网易有道5"),
//    WANGYI6("网易有道6"),
//    WANGYI7("网易有道7"),
//    WANGYI8("网易有道8"),
//    WANGYI9("网易有道9"),
//    WANGYI10("网易有道10"),
//    WANGYI11("网易有道11"),
//    WANGYI12("网易有道12"),
//    WANGYI13("网易有道13"),
//    WANGYI14("网易有道14"),
//    WANGYI15("网易有道15"),
//    WANGYI16("网易有道16"),
//    WANGYI17("网易有道17"),
//    WANGYI18("网易有道18"),
//    WANGYI19("网易有道19"),
//    WANGYI20("网易有道20"),
//    FBABA("富爸爸"),
//    TENCENTMINI1("腾讯mini1"),
//    TENCENTMINI2("腾讯mini2"),
//    TENCENTMINI3("腾讯mini3"),
//
//    TENCENTMINI4("腾讯mini4"),
//    TENCENTMINI5("腾讯mini5"),
//    TENCENTMINI6("腾讯mini6"),
//    TENCENTMINI7("腾讯mini7"),
//    TENCENTMINI8("腾讯mini8"),
//    TENCENTMINI9("腾讯mini9"),
//    TENCENTMINI10("腾讯mini10"),
//    TENCENTMINI11("腾讯mini11"),
//    TENCENTMINI12("腾讯mini12"),
//    TENCENTMINI13("腾讯mini13"),
//    TENCENTMINI14("腾讯mini14"),
//    TENCENTMINI15("腾讯mini15"),
//
//    TENCENT1("腾讯1"),
//    TENCENT2("腾讯2"),
//    TENCENT3("腾讯3"),
//    TENCENT4("腾讯4"),
//    TENCENT5("腾讯5"),
//    TENCENT6("腾讯6"),
//    TENCENT7("腾讯7"),
//    TENCENT8("腾讯8"),
//    TENCENT9("腾讯9"),
//    TENCENT10("腾讯10"),
//    TENCENT11("腾讯11"),
//    TENCENT12("腾讯12"),
//    TENCENT13("腾讯13"),
//    TENCENT14("腾讯14"),
//    TENCENT15("腾讯15"),
//    TENCENT16("腾讯16"),
//    TENCENT17("腾讯17"),
//    TENCENT18("腾讯18"),
//    TENCENT19("腾讯19"),
//    TENCENT20("腾讯20"),
//
//    SOHU1("搜狐汇算1"),
//    SOHU2("搜狐汇算2"),
//    SOHU3("搜狐汇算3"),
//    SOHU4("搜狐汇算4"),
//    SOHU5("搜狐汇算5"),
//
//    SOHU6("搜狐汇算6"),
//    SOHU7("搜狐汇算7"),
//    SOHU8("搜狐汇算8"),
//    SOHU9("搜狐汇算9"),
//    SOHU10("搜狐汇算10"),
//    SOHU11("搜狐汇算11"),
//    SOHU12("搜狐汇算12"),
//    SOHU13("搜狐汇算13"),
//    SOHU14("搜狐汇算14"),
//    SOHU15("搜狐汇算15"),
//    SOHU16("搜狐汇算16"),
//    SOHU17("搜狐汇算17"),
//    SOHU18("搜狐汇算18"),
//    SOHU19("搜狐汇算19"),
//    SOHU20("搜狐汇算20"),
//
//    SOHUTOUTIAO1("搜狐头条1"),
//    SOHUTOUTIAO2("搜狐头条2"),
//    SOHUTOUTIAO3("搜狐头条3"),
//    SOHUTOUTIAO4("搜狐头条4"),
//    SOHUTOUTIAO5("搜狐头条5"),
//    SOHUTOUTIAO6("搜狐头条6"),
//    SOHUTOUTIAO7("搜狐头条7"),
//    SOHUTOUTIAO8("搜狐头条8"),
//    SOHUTOUTIAO9("搜狐头条9"),
//    SOHUTOUTIAO10("搜狐头条10"),
//    SOHUTOUTIAO11("搜狐头条11"),
//    SOHUTOUTIAO12("搜狐头条12"),
//    SOHUTOUTIAO13("搜狐头条13"),
//    SOHUTOUTIAO14("搜狐头条14"),
//    SOHUTOUTIAO15("搜狐头条15"),
//    SOHUTOUTIAO16("搜狐头条16"),
//    SOHUTOUTIAO17("搜狐头条17"),
//    SOHUTOUTIAO18("搜狐头条18"),
//    SOHUTOUTIAO19("搜狐头条19"),
//    SOHUTOUTIAO20("搜狐头条20"),
//    SOHULUNTAN("搜狐论坛"),
//    CHENGNUOKEJI("橙诺科技"),
//    GUOANMINSHENG("国安民生"),
//    HENGJILIANYIN("恒基联银"),
//    YITENASITE("伊特纳斯特"),
//
//    SINA1("新浪1"),
//    SINA2("新浪2"),
//    SINA3("新浪3"),
//    SINA4("新浪4"),
//    SINA5("新浪5"),
//    SINA6("新浪6"),
//    SINA7("新浪7"),
//    SINA8("新浪8"),
//    SINA9("新浪9"),
//    SINA10("新浪10"),
//    SINA11("新浪11"),
//    SINA12("新浪12"),
//    SINA13("新浪13"),
//    SINA14("新浪14"),
//    SINA15("新浪15"),
//    SINA16("新浪16"),
//    SINA17("新浪17"),
//    SINA18("新浪18"),
//    SINA19("新浪19"),
//    SINA20("新浪20"),
//    SINA21("新浪21"),
//    SINA22("新浪22"),
//    SINA23("新浪23"),
//    SINA24("新浪24"),
//    SINA25("新浪25"),
//
//    PC_PZ_BAIDU("PC百度品专"),
//    MO_PZ_BAIDU("MO百度品专"),
//    PZ_HAOSOU("360品专"),
//    PC_SOGOU("PC搜狗"),
//    MO_SOGOU("MO搜狗"),
//    PZ_SOGOU("搜狗品专"),
//
//    BACKUP1("备用链接1"),
//    BACKUP2("360移动"),
//    BACKUP3("一塔湖图"),
//    BACKUP4("备用链接4"),
//    BACKUP5("备用链接5"),
//    BACKUP6("备用链接6"),
//    BACKUP7("备用链接7"),
//    BACKUP8("备用链接8"),
//    BACKUP9("备用链接9"),
//    BACKUP10("备用链接10"),
//    BACKUP11("备用链接11"),
//    BACKUP12("备用链接12"),
//    BACKUP13("备用链接13"),
//    BACKUP14("备用链接14"),
//    BACKUP15("备用链接15"),
//    BACKUP16("备用链接16"),
//    BACKUP17("备用链接17"),
//    BACKUP18("备用链接18"),
//    BACKUP19("备用链接19"),
//    BACKUP20("备用链接20"),
//
//
//    UCTT1("UC头条1"),
//    UCTT2("UC头条2"),
//    UCTT3("UC头条3"),
//    UCTT4("UC头条4"),
//    UCTT5("UC头条5"),
//    UCTT6("UC头条6"),
//    UCTT7("UC头条7"),
//    UCTT8("UC头条8"),
//    UCTT9("UC头条9"),
//    UCTT10("UC头条10"),
//    UCTT11("UC头条11"),
//    UCTT12("UC头条12"),
//    UCTT13("UC头条13"),
//    UCTT14("UC头条14"),
//    UCTT15("UC头条15"),
//    UCTT16("UC头条16"),
//    UCTT17("UC头条17"),
//    UCTT18("UC头条18"),
//    UCTT19("UC头条19"),
//    UCTT20("UC头条20"),
//    UCTT21("UC头条21"),
//    UCTT22("UC头条22"),
//    UCTT23("UC头条23"),
//    UCTT24("UC头条24"),
//    UCTT25("UC头条25"),
//    UCTT26("UC头条26"),
//    UCTT27("UC头条27"),
//    UCTT28("UC头条28"),
//    UCTT29("UC头条29"),
//    UCTT30("UC头条30"),
//    UCTT31("UC头条31"),
//    UCTT32("UC头条32"),
//    UCTT33("UC头条33"),
//    UCTT34("UC头条34"),
//    UCTT35("UC头条35"),
//    UCTT36("UC头条36"),
//    UCTT37("UC头条37"),
//    UCTT38("UC头条38"),
//    UCTT39("UC头条39"),
//    UCTT40("UC头条40"),
//
//
//    YIRUITE("易瑞特"),
//    YIGOU("易购"),
//    JUXIAO("聚效"),
//
//    QINGCHUANGSAI("清创赛"),
//
//    WANGDAIZHIJIA("网贷之家"),
//
//    CNXH360("360猜你喜欢"),
//    NVSHENTV("女神TV"),
//    JIAYIXINPIN("加意新品"),
//    JIXIANZAIXIAN("极限在线"),
//
//    EMAIL("邮箱"),
//    TODAY_TOP("今日头条"),
//    MAGIC_APP("魔力APP"),
//    HUBEI_GAMSJY("湖北国安民生救援"),
//
//    WEB("公共网络"),
//    BACK("系统后台"),
//    MOBILE("移动端"),
//    DIDI("滴滴打车"),
//    ACTIVE("公司活动"),
//    GUIMILICAI("闺蜜理财"),
//    UEBAO("优易保"),
//    MENGFQ("孟凡强"),
//    YUYINXINWEN("语音新闻"),
//    SHIBEI("拾贝"),
//    HDSP("腾讯活动视频"),
//    TLWIFI("铁路WiFI"),
//    ZHIXIAO_PC("智效PC"),
//    ZHIXIAO_MO("智效MO"),
//    HAOSOU_MO("360推广MO"),
//    SMSS("神马搜索"),
//    HSPBZ("惠锁屏"),
//    MBANK("流量银行"),
//    WEICHE("微车"),
//    AYIBANG("阿姨帮"),
//    AYIBANGHD("阿姨帮活动"),
//    QUANMAMA("券妈妈"),
//    ZHUCESONGLENYIN("注册送百万冷饮"),
//
//    HUNSHUI1("浑水微信HUNSHUI1"),
//    HUNSHUI2("浑水微信HUNSHUI2"),
//    HUNSHUI3("浑水微信HUNSHUI3"),
//    HUNSHUI4("浑水微信HUNSHUI4"),
//    HUNSHUI5("浑水微信HUNSHUI5"),
//    HUNSHUI6("浑水微信HUNSHUI6"),
//    HUNSHUI7("浑水微信HUNSHUI7"),
//    HUNSHUI8("浑水微信HUNSHUI8"),
//    HUNSHUI9("浑水微信HUNSHUI9"),
//    HUNSHUI10("浑水微信HUNSHUI10"),
//    HUNSHUI11("浑水微信HUNSHUI11"),
//    HUNSHUI12("浑水微信HUNSHUI12"),
//    HUNSHUI13("浑水微信HUNSHUI13"),
//    HUNSHUI14("浑水微信HUNSHUI14"),
//    HUNSHUI15("浑水微信HUNSHUI15"),
//    HUNSHUI16("浑水微信HUNSHUI16"),
//    HUNSHUI17("浑水微信HUNSHUI17"),
//    HUNSHUI18("浑水微信HUNSHUI18"),
//    HUNSHUI19("浑水微信HUNSHUI19"),
//    HUNSHUI20("浑水微信HUNSHUI20"),
//
//    CSAI("希财网"),
//
//    WDXH("网贷协会"),
//
//    RRL("人人利"),
//
//    LINKTECH("领克特"),
//
//    MIDAI("米袋网"),
//
//    LIULIANGBAO("流量宝"),
//
//    //合作伙伴通州书店
//    BOOKSTORE_BJ("通州淘宝书店"),
//
//    /** APP start**/
//    APP_APPSTORE("应用商店"),
//    APP_BAIDU("百度手机助手"),
//    APP_MARKET360("360手机助手"),
//    APP_TENCENT("腾讯应用宝"),
//    APP_MIUI("小米应用商店"),
//    APP_TOUTIAO("今日头条"),
//    APP_WANDOUJIA("豌豆荚"),
//    APP_HUAWEI("华为应用商店");
//    /** APP end**/
//
//    private final String key;
//
//    private RegisterResourceType(String key) {
//        this.key = key;
//    }
//
//    @Override
//    public String getKey() {
//        return key;
//    }
//
//    /**
//     * 获取APP端渠道来源
//     * @return
//     */
//    public static List<String> getAppSourceStr() {
//        List result = new ArrayList();
//        RegisterResourceType[] resourceTypes = RegisterResourceType.values();
//
//        for (RegisterResourceType resourceType : resourceTypes) {
//            if (resourceType.name().contains("APP_")) {
//                result.add(resourceType.name());
//            }
//        }
//
//        return result;
//    }
//
//    public static String getName(String key) {
//        Preconditions.checkNotNull(StringUtils.isNotBlank(key), "key is null");
//        for (RegisterResourceType type : RegisterResourceType.values()) {
//            if (type.getKey().equals(key)) {
//                return type.name();
//            }
//        }
//        return null;
//    }
//
//    public static List<String> getNames(String key) {
//        List<String> names = new ArrayList<>();
//        Preconditions.checkNotNull(StringUtils.isNotBlank(key), "key is null");
//        for (RegisterResourceType type : RegisterResourceType.values()) {
//            if(type.getKey().contains(key)){
//                names.add(type.name());
//            }
//        }
//        return names;
//    }
//
//    public static RegisterResourceType getType(String name) {
//        for (RegisterResourceType type : RegisterResourceType.values()) {
//            if (type.name().equals(name)) {
//                return type;
//            }
//        }
//        return null;
//    }
//
//}
