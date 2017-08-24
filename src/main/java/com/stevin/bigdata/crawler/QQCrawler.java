package com.stevin.bigdata.crawler;

import com.stevin.bigdata.pattern.QQSiteUrl;
import com.stevin.bigdata.utils.Page2Json;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;
import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;

public class QQCrawler extends WebCrawler{
    private JSONArray pagesJsonArray = new JSONArray();
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        return QQSiteUrl.IsFinance(url.getURL());
    }

    @Override
    public void visit(Page page) {
        long processedPages = this.getMyController().getFrontier().getNumberOfProcessedPages();
        if(processedPages % 20 == 0) {
            System.out.println(processedPages + " visited");
            try {
                this.dumpPages(processedPages);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        pagesJsonArray.put(Page2Json.toJson(page));

    }

    private void dumpPages(long blockId) throws IOException{
        if( pagesJsonArray == null || pagesJsonArray.length() == 0) {
            return;
        }
        String fileName = "block-" + blockId + ".json";
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(pagesJsonArray.toString());
        fileWriter.flush();
        fileWriter.close();
        pagesJsonArray = new JSONArray();
    }
}
