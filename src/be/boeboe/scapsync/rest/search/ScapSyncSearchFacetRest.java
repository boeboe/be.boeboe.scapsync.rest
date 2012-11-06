/**
 * 
 */
package be.boeboe.scapsync.rest.search;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchFacet;

/**
 * @author boeboe
 *
 */
public class ScapSyncSearchFacetRest implements IScapSyncSearchFacet {
  private static String SELECTED = "selected";
  protected static String NAME = "name";
  private static String URL = "url";
  protected static String VALUES = "values";

  private boolean fSelected;
  private String fName;
  private String fUrl;
  public ScapSyncSearchFacetRest(JSONObject scapSyncSearchFacetRest) {
    super();
    try {
      fSelected = Boolean.getBoolean(scapSyncSearchFacetRest.getString(SELECTED));
      fName = scapSyncSearchFacetRest.getString(NAME);
      fUrl = scapSyncSearchFacetRest.getString(URL);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  
  public ScapSyncSearchFacetRest(JSONObject scapSyncSearchFacetRest, String baseName) {
    this(scapSyncSearchFacetRest);
    fName = baseName + " " + fName;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchFacet#getSelected()
   */
  @Override
  public boolean getSelected() {
    return fSelected;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchFacet#getName()
   */
  @Override
  public String getName() {
    return fName;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchFacet#getUrl()
   */
  @Override
  public String getUrl() {
    return fUrl;
  }

  @Override
  public String toString() {
    return "ScapSyncSearchFacetRest [fSelected=" + fSelected + ", fName="
        + fName + ", fUrl=" + fUrl + "]";
  }
}
