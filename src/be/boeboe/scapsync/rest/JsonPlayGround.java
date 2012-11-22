package be.boeboe.scapsync.rest;

import be.boeboe.scapsync.rest.interfaces.IScapSyncFeed;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchOrderFilter;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult;

public class JsonPlayGround {
  
  private static int count = 0;

  /**
   * @param args
   */
  public static void main(String[] args) {

    ScapSyncHandle searcher = new ScapSyncHandle();
    
    for (IScapSyncFeed feed : searcher.getDailyFeed().getNewItems()) {
      System.out.println("NEW: " + feed.toString());
    }

    for (IScapSyncFeed feed : searcher.getDailyFeed().getChangedItems()) {
      System.out.println("OLD: " + feed.toString());
    }
    
    System.out.println(searcher.getStatistics());

//    String[] targetArray = { "openssl", "http", "nginx", "outlook",
//                             "windows", "android", "iphone", "explorer",
//                             "ftp", "linux", "sip", "firewall",
//                             "apple", "cwmp", "dhcp", "dns" ,
//                             "cisco", "openwrt", "huawei", "sagem",
//                             "unix", "uhttpd", "torrent", "microsoft",
//                             "sql", "mysql", "oracle", "vpn", 
//                             "root", "guest", "admin", "overflow" };

    String[] targetArray = { "explorer" };

    for (String target : targetArray) {
      
      ScapSyncSearch search = searcher.search(target, null, IScapSyncSearchOrderFilter.SORT_RELEVANT);
      
      ScapSyncSearchListener searchListener = new ScapSyncSearchListener() {
        @Override
        public void resultReceived(IScapSyncSearchResult[] results) {
          for (IScapSyncSearchResult res : results) {
            System.out.println("Id(" + count + "): " + res.getId());
            count++;
             // System.out.println("Desc: " + res.getTitleText());
          }
        }
      };
      
      search.addSearchListener(searchListener);
      
      long startTime = System.currentTimeMillis();
      search.run();
      
      long estimatedTime = System.currentTimeMillis() - startTime;
      long estimatedTimeSeconds = estimatedTime / 1000;
      System.out.println("JsonPlayGround.main(duration): " + estimatedTimeSeconds + " seconds.");
    }
  }
}
