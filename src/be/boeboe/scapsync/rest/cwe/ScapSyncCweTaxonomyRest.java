/**
 * 
 */
package be.boeboe.scapsync.rest.cwe;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.interfaces.IScapSyncCweTaxonomy;

/**
 * @author boeboe
 *
 */
public class ScapSyncCweTaxonomyRest implements IScapSyncCweTaxonomy {
  private static String TAXONOMY = "taxonomy";
  private static String NAME = "name";
  private static String FIT = "fit";
  private static String ID = "id";

  private String fTaxonomy;
  private String fName;
  private String fFit;
  private String fId;

  public ScapSyncCweTaxonomyRest(JSONObject scapSyncCweTaxonomyRest) {
    super();
    try {
      fTaxonomy = scapSyncCweTaxonomyRest.getString(TAXONOMY);
      fName = scapSyncCweTaxonomyRest.getString(NAME);
      fFit = scapSyncCweTaxonomyRest.getString(FIT);
      fId = scapSyncCweTaxonomyRest.getString(ID);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  
  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweTaxonomy#getTaxonomy()
   */
  @Override
  public String getTaxonomy() {
    return fTaxonomy;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweTaxonomy#getName()
   */
  @Override
  public String getName() {
    return fName;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweTaxonomy#getFit()
   */
  @Override
  public String getFit() {
    return fFit;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweTaxonomy#getId()
   */
  @Override
  public String getId() {
    return fId;
  }
}
