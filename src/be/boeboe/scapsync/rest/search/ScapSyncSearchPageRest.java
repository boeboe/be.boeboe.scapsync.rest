/**
 * 
 */
package be.boeboe.scapsync.rest.search;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchPage;

/**
 * @author boeboe
 *
 */
public class ScapSyncSearchPageRest implements IScapSyncSearchPage {
  private static String NAME = "name";
  private static String URL = "url";

  private int fName;
  private String fUrl;
  
  public ScapSyncSearchPageRest(JSONObject scapSyncSearchPageRest) {
    super();
    try {
      fName = scapSyncSearchPageRest.getInt(NAME);
      fUrl = scapSyncSearchPageRest.getString(URL);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchPage#getName()
   */
  @Override
  public int getName() {
    return fName;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchPage#getUrl()
   */
  @Override
  public String getUrl() {
    return fUrl;
  }
}
