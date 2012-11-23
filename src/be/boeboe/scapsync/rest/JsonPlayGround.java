package be.boeboe.scapsync.rest;

import be.boeboe.scapsync.rest.interfaces.IScapSyncCceDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCpeDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncFeed;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchOrderFilter;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResultType;

public class JsonPlayGround {
  
  private static int count = 0;

  /**
   * @param args
   */
  /**
   * @param args
   */
  public static void main(String[] args) {

    final ScapSyncHandle scapSyncHandle = new ScapSyncHandle();
    
    for (IScapSyncFeed feed : scapSyncHandle.getDailyFeed().getNewItems()) {
      System.out.println("NEW: " + feed.toString());
    }

    for (IScapSyncFeed feed : scapSyncHandle.getDailyFeed().getChangedItems()) {
      System.out.println("OLD: " + feed.toString());
    }
    
    System.out.println(scapSyncHandle.getStatistics());

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
      
      ScapSyncSearch search = scapSyncHandle.search(target, null, IScapSyncSearchOrderFilter.SORT_RELEVANT);
      
      ScapSyncSearchListener searchListener = new ScapSyncSearchListener() {
        @Override
        public void resultReceived(IScapSyncSearchResult[] results) {
          for (IScapSyncSearchResult res : results) {
            System.out.println("Id(" + count + "): " + res.getId());
            count++;
            if (res.getType() == IScapSyncSearchResultType.TYPE_CCE) {
              IScapSyncCceDetails details = scapSyncHandle.getCceDetails(res.getId());
              System.out.println("Details:" + details.toString());
            } else if (res.getType() == IScapSyncSearchResultType.TYPE_CPE) {
              IScapSyncCpeDetails details = scapSyncHandle.getCpeDetails(res.getId());
              System.out.println("Details:" + details.toString());
            } else if (res.getType() == IScapSyncSearchResultType.TYPE_CVE) {
              IScapSyncCveDetails details = scapSyncHandle.getCveDetails(res.getId());
              System.out.println("Details:" + details.toString());
            } else if (res.getType() == IScapSyncSearchResultType.TYPE_CWE) {
              IScapSyncCweDetails details = scapSyncHandle.getCweDetails(res.getId());
              System.out.println("Details:" + details.toString());
            } 
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
