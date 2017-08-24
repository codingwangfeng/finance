package com.stevin.bigdata.utils;

import edu.uci.ics.crawler4j.crawler.Page;
import org.json.JSONObject;

public class Page2Json {
    public static String toJson(Page page) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", page.getWebURL().getURL());
        jsonObject.put("charset", page.getContentCharset());
        jsonObject.put("data", new String(page.getContentData()));
        jsonObject.put("type", page.getContentType());
        jsonObject.put("status", page.getStatusCode());
        jsonObject.put("redirect", page.getRedirectedToUrl());
        return jsonObject.toString();
    }
}
