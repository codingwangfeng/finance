package com.stevin.bigdata.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by stevin on 2017/8/18.
 */
public class QQSiteUrl {
    private final static String financeSiteName = "http://finance.qq.com";
    private final static Pattern htmlPagesPattern = Pattern.compile(".*(\\.(htm|html))$");

    public static boolean IsFinance(String url) {
        url = url.toLowerCase();
        return htmlPagesPattern.matcher(url).find() && url.startsWith(financeSiteName);
    }
}
