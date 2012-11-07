/**
 * 
 */
package be.boeboe.scapsync.rest.cwe;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.interfaces.IScapSyncCweConsequence;

/**
 * @author boeboe
 *
 */
public class ScapSyncCweConsequenceRest implements IScapSyncCweConsequence {
  private static String IMPACT = "impact";
  private static String SCOPE = "scope";
  private static String NOTES = "notes";

  private String fImpact;
  private String fScope;
  private String fNotes;

  public ScapSyncCweConsequenceRest(JSONObject scapSyncCweConsequenceRest) {
    super();
    try {
      fImpact = scapSyncCweConsequenceRest.getString(IMPACT);
      fScope = scapSyncCweConsequenceRest.getString(SCOPE);
      fNotes = scapSyncCweConsequenceRest.getString(NOTES);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweConsequence#getImpact()
   */
  @Override
  public String getImpact() {
    return fImpact;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweConsequence#getScope()
   */
  @Override
  public String getScope() {
    return fScope;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweConsequence#getNotes()
   */
  @Override
  public String getNotes() {
    return fNotes;
  }
}
