package be.boeboe.scapsync.rest;

import be.boeboe.scapsync.rest.interfaces.IScapSyncCpeDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCveReference;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult;

public class JsonPlayGround {

  /**
   * @param args
   */
  public static void main(String[] args) {

    ScapSyncSearcher searcher = new ScapSyncSearcher();

    System.out.println("=== Looking for openssl CPE ===");
    for (IScapSyncSearchResult r : searcher.searchCpe("openssl")) {
      System.out.println("RES: " + r.toString());
      
      IScapSyncCpeDetails det = searcher.getCpeDetails(r);
      System.out.println("DETAILS: " + det.toString());
    }

    System.out.println("\n\n=== Looking for openssl CVE ===");
    for (IScapSyncSearchResult r : searcher.searchCve("nginx")) {
      System.out.println("RES: " + r.toString());
      
      IScapSyncCveDetails det = searcher.getCveDetails(r);
      System.out.println("DETAILS: " + det.toString());
    }

    System.out.println("\n\n=== Looking for openssl CWE ===");
    for (IScapSyncSearchResult r : searcher.searchCwe("openssl")) {
      System.out.println("RES: " + r.toString());
      
      IScapSyncCweDetails det = searcher.getCweDetails(r);
      System.out.println("DETAILS: " + det.toString());
    }

    System.out.println("\n\n=== Looking for nginx CVE ===");
    for (IScapSyncSearchResult r : searcher.searchCve("nginx")) {
      System.out.println("RES: " + r.toString());
      
      IScapSyncCveDetails det = searcher.getCveDetails(r);
      System.out.println("DETAILS: " + det.toString());
      System.out.println("CVSS: " + det.getCvss());
      
      for (IScapSyncCveReference ref : det.getRefences()) {
        System.out.println("REF: " + ref.toString());
      }
    }
  }
}
