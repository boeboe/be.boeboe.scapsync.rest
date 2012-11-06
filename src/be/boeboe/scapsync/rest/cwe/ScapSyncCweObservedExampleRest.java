/**
 * 
 */
package be.boeboe.scapsync.rest.cwe;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.interfaces.IScapSyncCweObservedExample;

/**
 * @author boeboe
 *
 */
public class ScapSyncCweObservedExampleRest implements
    IScapSyncCweObservedExample {
  private static String URL = "url";
  private static String DESCRIPTION = "description";
  private static String CVE_ID = "cve_id";
  
  private String furl;
  private String fDescription;
  private String fCveId;
  
  public ScapSyncCweObservedExampleRest(JSONObject scapSyncObservedCweExampleRest) {
    super();
    try {
      furl = scapSyncObservedCweExampleRest.getString(URL);
      fDescription = scapSyncObservedCweExampleRest.getString(DESCRIPTION);
      fCveId = scapSyncObservedCweExampleRest.getString(CVE_ID);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweObservedExample#getUrl()
   */
  @Override
  public String getUrl() {
    return furl;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweObservedExample#getDescription()
   */
  @Override
  public String getDescription() {
    return fDescription;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweObservedExample#getCveId()
   */
  @Override
  public String getCveId() {
    return fCveId;
  }
}
