/**
 * 
 */
package be.boeboe.scapsync.rest.cwe;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.interfaces.IScapSyncCweMitigation;

/**
 * @author boeboe
 *
 */
public class ScapSyncCweMitigationRest implements IScapSyncCweMitigation {
  private static String PHASE = "phase";
  private static String EFFECTIVENESS = "effectiveness";
  private static String NOTES = "notes";
  private static String DESCRIPTION = "description";
  private static String STRATEGY = "strategy";

  private String fPhase;
  private String fEffectiveness;
  private String fNotes;
  private String fDescription;
  private String fStrategy;

  public ScapSyncCweMitigationRest(JSONObject scapSyncCweMitigationRest) {
    super();
    try {
      fPhase = scapSyncCweMitigationRest.getString(PHASE);
      fEffectiveness = scapSyncCweMitigationRest.getString(EFFECTIVENESS);
      fNotes = scapSyncCweMitigationRest.getString(NOTES);
      fDescription = scapSyncCweMitigationRest.getString(DESCRIPTION);
      fStrategy = scapSyncCweMitigationRest.getString(STRATEGY);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  
  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweMitigation#getPhase()
   */
  @Override
  public String getPhase() {
    return fPhase;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweMitigation#getEffectiveness()
   */
  @Override
  public String getEffectiveness() {
    return fEffectiveness;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweMitigation#getNotes()
   */
  @Override
  public String getNotes() {
    return fNotes;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweMitigation#getDescription()
   */
  @Override
  public String getDescription() {
    return fDescription;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweMitigation#getStrategy()
   */
  @Override
  public String getStrategy() {
    return fStrategy;
  }

}
