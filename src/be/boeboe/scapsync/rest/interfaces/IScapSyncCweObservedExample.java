/**
 * 
 */
package be.boeboe.scapsync.rest.interfaces;

/**
 * Interface to represent a ScapSync CWE Observed Example
 * 
 * Example json:
 * { "url" : "/cve/CVE-2009-2550", "description" : "Classic stack-based ...",
 *   "cve_id" : "CVE-2009-2550" }
 * @author boeboe
 */
public interface IScapSyncCweObservedExample {

  /**
   * Get the (relative) URL from this CWE Observed Example.
   * @return url the URL from this CWE Observed Example
   */
  public String getUrl();

  /**
   * Get the Description from this CWE Observed Example.
   * @return description the Description from this CWE Observed Example
   */
  public String getDescription();

  /**
   * Get the CVE ID from this CWE Observed Example.
   * @return cveId the CVE ID from this CWE Observed Example
   */
  public String getCveId();
}
