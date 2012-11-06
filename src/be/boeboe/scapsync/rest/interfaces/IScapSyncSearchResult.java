/**
 * 
 */
package be.boeboe.scapsync.rest.interfaces;

import java.util.Date;

/**
 * Interface to represent a ScapSync Result
 * 
 * Example json:
 * {"id":"CVE-2009-2629",
 *      "summary_text":"CWE-119 through 0.5.37, 0.6.x before...",
 *      "title_text":"Buffer underflow in...",
 *      "type":"cve",
 *      "url":"/cve/CVE-2009-2629",
 *      "modified":"2009-12-19T06:56:44Z"}
 * @author boeboe
 */
public interface IScapSyncSearchResult {
  
  /**
   * Get the ID of the Result.
   * @return id the string with the ID of this Result
   */
  public String getId();
  
  /**
   * Get the summary text of the Result.
   * @return text the summary text of the Result
   */
  public String getSummaryText();
  
  /**
   * Get the title text of the Result.
   * @return name the name of the Result
   */
  public String getTitleText();
  
  /**
   * Get the relative URL of the Result.
   * @return url the URL of the Result
   */
  public String getUrl();

  /**
   * Get the type of the Result.
   * @return type the type of the Result
   */
  public IScapSyncSearchResultType getType(); 
  
  /**
   * Get the last modified date of the Result.
   * @return date the last modified Date of the Result
   */
  public Date getModifiedDate(); 
  
}
