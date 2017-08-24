package com.stevin.bigdata.pattern;

import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by stevin on 2017/8/18.
 */
public class QQSiteUrlTest {
    @org.junit.Test
    public void isFinance() throws Exception {
        Assert.assertTrue(QQSiteUrl.IsFinance("http://finance.qq.com/jrsc.htm"));
        Assert.assertFalse(QQSiteUrl.IsFinance("http://xfinance.qq.com/jrsc.htm"));
        Assert.assertFalse(QQSiteUrl.IsFinance("xhttp://xfinance.qq.com/jrsc.htm"));
    }

}