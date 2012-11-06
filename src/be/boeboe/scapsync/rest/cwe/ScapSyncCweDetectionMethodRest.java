/**
 * 
 */
package be.boeboe.scapsync.rest.cwe;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetectionMethod;

/**
 * @author boeboe
 *
 */
public class ScapSyncCweDetectionMethodRest implements
    IScapSyncCweDetectionMethod {
  private static String NOTES = "notes";
  private static String EFFECTIVENESS = "effectiveness";
  private static String NAME = "name";
  private static String DESCRIPTION = "description";
  
  private String fNotes;
  private String fEffectiveness;
  private String fName;
  private String fDescription;
  
  public ScapSyncCweDetectionMethodRest(JSONObject scapSyncCweDetectionMethodRest) {
    super();
    try {
      fNotes = scapSyncCweDetectionMethodRest.getString(NOTES);
      fEffectiveness = scapSyncCweDetectionMethodRest.getString(EFFECTIVENESS);
      fName = scapSyncCweDetectionMethodRest.getString(NAME);
      fDescription = scapSyncCweDetectionMethodRest.getString(DESCRIPTION);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  
  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetectionMethod#getNotes()
   */
  @Override
  public String getNotes() {
    return fNotes;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetectionMethod#getEffectiveness()
   */
  @Override
  public String getEffectiveness() {
    return fEffectiveness;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetectionMethod#getName()
   */
  @Override
  public String getName() {
    return fName;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetectionMethod#getDescription()
   */
  @Override
  public String getDescription() {
    return fDescription;
  }
}
