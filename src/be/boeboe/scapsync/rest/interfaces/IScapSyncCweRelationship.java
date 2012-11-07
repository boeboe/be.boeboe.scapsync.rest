/**
 * 
 */
package be.boeboe.scapsync.rest.interfaces;

/**
 * Interface to represent a ScapSync CWE Relationship
 * @author boeboe
 */
public interface IScapSyncCweRelationship {

  /**
   * Get the (relative) URL from this CWE Relationship.
   * @return url the URL from this CWE Relationship
   */
  public String getUrl();

  /**
   * Get the Target Form from this CWE Relationship.
   * @return targeForm the Target Form from this CWE Relationship
   */
  public String getTargetForm();

  /**
   * Get the Nature from this CWE Relationship.
   * @return nature the Nature from this CWE Relationship
   */
  public String getNature();

  /**
   * Get the Target Id from this CWE Relationship.
   * @return targetId the Target Id from this CWE Relationship
   */
  public String getTargetId();
  
  /**
   * Get the Views from this CWE Relationship.
   * @return array an array of IScapSyncCweRelationshipViews from this CWE
   * Relationship
   */
  public IScapSyncCweRelationshipView[] getViews();

  /**
   * Interface to represent a ScapSync CWE Relationship View
   * 
   * @author boeboe
   */
  public interface IScapSyncCweRelationshipView {

    /**
     * Get the (relative) URL from this CWE Relationship View.
     * @return url the URL from this CWE Relationship View
     */
    public String getUrl();
    
    /**
     * Get the Id from this CWE Relationship View.
     * @return id the Id from this CWE Relationship View
     */
    public String getId();  
  }
}
