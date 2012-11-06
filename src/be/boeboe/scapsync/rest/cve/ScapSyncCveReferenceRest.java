/**
 * 
 */
package be.boeboe.scapsync.rest.cve;

import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.interfaces.IScapSyncCveReference;

/**
 * @author boeboe
 *
 */
public class ScapSyncCveReferenceRest implements IScapSyncCveReference {
  private static String URL = "url";
  private static String SOURCE = "source";
  private static String ID = "id";
  
  private URI furl;
  private String fSource;
  private String fId;
  
  public ScapSyncCveReferenceRest(JSONObject scapSyncReferenceRest) {
    super();
    try {
      furl = URI.create(scapSyncReferenceRest.getString(URL));
      fSource = scapSyncReferenceRest.getString(SOURCE);
      fId = scapSyncReferenceRest.getString(ID);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  
  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveReference#getId()
   */
  @Override
  public String getId() {
    return fId;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveReference#getSource()
   */
  @Override
  public String getSource() {
    return fSource;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveReference#getUrl()
   */
  @Override
  public URI getUrl() {
    return furl;
  }

  @Override
  public String toString() {
    return "ScapSyncReferenceRest [furl=" + furl + ", fSource=" + fSource
        + ", fId=" + fId + "]";
  } 
}
