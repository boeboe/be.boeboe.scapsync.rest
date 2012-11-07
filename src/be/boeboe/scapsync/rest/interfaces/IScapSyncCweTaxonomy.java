/**
 * 
 */
package be.boeboe.scapsync.rest.interfaces;

/**
 * Interface to represent a ScapSync CWE Taxonomy
 * 
 * Example json:
 * { "taxonomy" : "PLOVER", "name" : "Path Traversal" }
 * { "taxonomy" : "OWASP Top Ten 2007",
 *   "name" : "Insecure Direct Object Reference",
 *   "fit" : "CWE_More_Specific", "id" : "A4" }
 * @author boeboe
 */
public interface IScapSyncCweTaxonomy {

  /**
   * Get the Taxonomy from this CWE Taxonomy.
   * @return taxonomy the Taxonomy from this CWE Taxonomy
   */
  public String getTaxonomy();

  /**
   * Get the Name from this CWE Taxonomy.
   * @return name the Name from this CWE Taxonomy
   */
  public String getName();

  /**
   * Get the Fit from this CWE.
   * @return fit the Fit from this CWE Taxonomy
   */
  public String getFit();

  /**
   * Get the ID from this CWE Taxonomy.
   * @return notes the ID from this CWE Taxonomy
   */
  public String getId();
}
