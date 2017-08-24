package com.stevin.bigdata.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * Hello world!
 */
public class App {
    public static void Start() {
        CrawlConfig crawlConfig = new CrawlConfig();
        crawlConfig.setCrawlStorageFolder("./storepages/");
        crawlConfig.setMaxDepthOfCrawling(3);
        String seedUrl = "http://finance.qq.com";
        PageFetcher pageFetcher = new PageFetcher(crawlConfig);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        try {
            CrawlController crawlController = new CrawlController(crawlConfig, pageFetcher, robotstxtServer);
            crawlController.addSeed(seedUrl);
            crawlController.start(QQCrawler.class, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
