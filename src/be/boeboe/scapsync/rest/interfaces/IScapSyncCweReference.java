/**
 * 
 */
package be.boeboe.scapsync.rest.interfaces;

import java.net.URI;
import java.util.Date;

/**
 * Interface to represent a ScapSync CWE Reference
 * 
 * Example json:
 * { "edition" : "2nd Edition", 
 *   "section" : "Chapter 5, ...",
 *   "title" : "Writing Secure Code",
 *   "publication_date" : "2002-01-01T00:00:00Z",
 *   "author" : [ "M. Howard", "D. LeBlanc" ] }
 * { "url" : "http://msdn.microsoft.com/en-us/library/ms647466.aspx",
 *   "title" : "Using the Strsafe.h Functions",
 *   "author" : [ "Microsoft" ] }
 * { "date" : "2010-03-09T00:00:00Z",
 *   "url" : "http://blogs.sans.org/appsecstreetfighter/...",
 *   "title" : "Top 25 Series - Rank 7 - Path Traversal",
 *   "author" : [ "Johannes Ullrich" ] }
 * @author boeboe
 */
public interface IScapSyncCweReference {

  /**
   * Get the URL from this CWE Reference.
   * @return url the URL from this CWE Reference
   */
  public URI getUrl();
  
  /**
   * Get the Title from this CWE Reference.
   * @return title the Title from this CWE Reference
   */
  public String getTitle();
  
  /**
   * Get the Edition from this CWE Reference.
   * @return edition the Edition from this CWE Reference
   */
  public String getEdition();
  
  /**
   * Get the Section from this CWE Reference.
   * @return section the Section from this CWE Reference
   */
  public String getSection();

  /**
   * Get the Date from this CWE Reference.
   * @return date the Date from this CWE Reference
   */
  public Date getDate();

  /**
   * Get the PublicationDate from this CWE Reference.
   * @return publicationDate the PublicationDate from this CWE Reference
   */
  public Date getPublicationDate();

  /**
   * Get the Authors from this CWE Reference.
   * @return stringArray the Authors from this CWE Reference
   */
  public String[] getAuthors();
}
