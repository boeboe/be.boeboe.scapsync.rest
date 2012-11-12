/**
 * 
 */
package be.boeboe.scapsync.rest.interfaces;

import java.util.Map;

/**
 * Interface to represent ScapSync Statistics
 * @author vanbosb
 *
 */
public interface IScapSyncStats {
  
  /**
   * Get total amount of Configuration Issues (CCE) known about.
   * @return int the total amount of Configuration Issues (CCE)
   */  
  public int getAmountConfigurations();

  /**
   * Get total amount of Products (CPE) known about.
   * @return int the total amount of Products (CPE)
   */  
  public int getAmountProducts();

  /**
   * Get total amount of Vulnerabilities (CVE) known about.
   * @return int the total amount of Vulnerabilities (CVE)
   */  
  public int getAmountVulnerabilities();

  /**
   * Get total amount of Weaknesses (CWE) known about.
   * @return int the total amount of Weaknesses (CWE)
   */  
  public int getAmountWeaknesses();

  /**
   * Get all statistics available.
   * @return hashMap Containing the statistics in key value pairs
   */  
  public Map<String, Integer> getStatistics();

}
