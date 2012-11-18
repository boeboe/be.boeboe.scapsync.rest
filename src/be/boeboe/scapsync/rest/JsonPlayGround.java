package be.boeboe.scapsync.rest;

import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult;

public class JsonPlayGround {
  
  private static int count = 0;

  /**
   * @param args
   */
  public static void main(String[] args) {

    ScapSyncSearcher searcher = new ScapSyncSearcher();
    //System.out.println(searcher.getStatistics());

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
      
      ScapSyncSearch search = searcher.searchAll(target);
      
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
