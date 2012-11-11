package be.boeboe.scapsync.rest;

import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResultType;

public class JsonPlayGround {

  /**
   * @param args
   */
  public static void main(String[] args) {

    ScapSyncSearcher searcher = new ScapSyncSearcher();
    //String[] targetArray = { "openssl", "http", "nginx", "outlook" };
    //String[] targetArray = { "windows", "android", "iphone", "explorer" };
    String[] targetArray = { "ftp", "linux", "sip", "firewall" };
    
    for (String target : targetArray) {
      for (IScapSyncSearchResult r : searcher.searchAll("openssl")) {
        if (r.getType().equals(IScapSyncSearchResultType.TYPE_CPE)) {
          System.out.println("\n=== CPE ===[ " + target + " ]=== CPE ===");
          System.out.println("RES: " + r.toString());
          // System.out.println("DETAILS: " + searcher.getCpeDetails(r).toString());
        } else if (r.getType().equals(IScapSyncSearchResultType.TYPE_CVE)) {
          System.out.println("\n=== CVE ===[ " + target + " ]=== CVE ===");
          System.out.println("RES: " + r.toString());
          System.out.println("DETAILS: " + searcher.getCveDetails(r).toString());
        } else if (r.getType().equals(IScapSyncSearchResultType.TYPE_CWE)) {
          System.out.println("\n=== CWE ===[ " + target + " ]=== CWE ===");
          System.out.println("RES: " + r.toString());
          System.out.println("DETAILS: " + searcher.getCweDetails(r).toString());
        }
      }
    }
  }
}
