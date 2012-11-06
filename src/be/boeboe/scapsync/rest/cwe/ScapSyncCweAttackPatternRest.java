/**
 * 
 */
package be.boeboe.scapsync.rest.cwe;

import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.interfaces.IScapSyncCweAttackPattern;

/**
 * @author boeboe
 *
 */
public class ScapSyncCweAttackPatternRest implements IScapSyncCweAttackPattern {
  private static String URL = "url";
  private static String ID = "id";

  private URI fUrl;
  private String fId;
  
  public ScapSyncCweAttackPatternRest(JSONObject scapSyncCweAttackPatternRest) {
    super();
    try {
      fUrl = URI.create(scapSyncCweAttackPatternRest.getString(URL));
      fId = scapSyncCweAttackPatternRest.getString(ID);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  
  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweAttackPattern#getUrl()
   */
  @Override
  public URI getUrl() {
    return fUrl;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweAttackPattern#getId()
   */
  @Override
  public String getId() {
    return fId;
  }
}
