
package com.akossap.udemy2.webcrawler;

public class App {

    public static void main(String[] args) {
        
        WebCrawler crawler = new WebCrawler();
        
        String rootUrl = "https://smirgli.com";
        
        crawler.discoverWeb(rootUrl);
        
    }
    
}
