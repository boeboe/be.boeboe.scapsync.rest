/**
 * 
 */
package be.boeboe.scapsync.rest.cwe;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.ScapSyncUtils;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweAttackPattern;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetectionMethod;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweMitigation;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweObservedExample;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweReference;

/**
 * @author boeboe
 *
 */
public class ScapSyncCweDetailsRest implements IScapSyncCweDetails {
  private static String OBSERVED_EXAMPLES = "observed_examples";
  private static String DETECTION_METHODS = "detection_methods";
  private static String ATTACK_PATTERNS = "attack_patterns";
  private static String MITIGATIONS = "mitigations";
  private static String REFERENCES = "references";
  private static String UPSTREAM_MODIFIED = "upstream_modified";
  private static String CWE_ID = "cwe_id";
  
  private IScapSyncCweObservedExample[] fObservedExamples;
  private IScapSyncCweDetectionMethod[] fDetectionMethods;
  private IScapSyncCweAttackPattern[] fAttackPatterns;
  private IScapSyncCweMitigation[] fMitigations;
  private IScapSyncCweReference[] fReferences;
  private Date fUpstreamModified;
  private String fCweId;
  
  public ScapSyncCweDetailsRest(JSONObject scapSyncCweDetailsRest) {
    super();
    try {
      fUpstreamModified = ScapSyncUtils.getDate(scapSyncCweDetailsRest.getString(UPSTREAM_MODIFIED));
      fCweId = scapSyncCweDetailsRest.getString(CWE_ID);

      JSONArray observedExamples = scapSyncCweDetailsRest.getJSONArray(OBSERVED_EXAMPLES);
      fObservedExamples = new IScapSyncCweObservedExample[observedExamples.length()];
      for ( int i = 0 ; i < observedExamples.length(); i++) {
        fObservedExamples[i] =
            new ScapSyncCweObservedExampleRest(observedExamples.getJSONObject(i));
      }

      JSONArray detectionMethods = scapSyncCweDetailsRest.getJSONArray(DETECTION_METHODS);
      fDetectionMethods = new IScapSyncCweDetectionMethod[detectionMethods.length()];
      for ( int i = 0 ; i < detectionMethods.length(); i++) {
        fDetectionMethods[i] =
            new ScapSyncCweDetectionMethodRest(detectionMethods.getJSONObject(i));
      }

      JSONArray attackPatterns = scapSyncCweDetailsRest.getJSONArray(ATTACK_PATTERNS);
      fAttackPatterns = new IScapSyncCweAttackPattern[attackPatterns.length()];
      for ( int i = 0 ; i < attackPatterns.length(); i++) {
        fAttackPatterns[i] =
            new ScapSyncCweAttackPatternRest(attackPatterns.getJSONObject(i));
      }

      JSONArray mitigations = scapSyncCweDetailsRest.getJSONArray(MITIGATIONS);
      fMitigations = new IScapSyncCweMitigation[mitigations.length()];
      for ( int i = 0 ; i < mitigations.length(); i++) {
        fMitigations[i] =
            new ScapSyncCweMitigationRest(mitigations.getJSONObject(i));
      }

      JSONArray references = scapSyncCweDetailsRest.getJSONArray(REFERENCES);
      fReferences = new IScapSyncCweReference[references.length()];
      for ( int i = 0 ; i < mitigations.length(); i++) {
        fReferences[i] =
            new ScapSyncCweReferenceRest(references.getJSONObject(i));
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  
  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getObservedExamples()
   */
  @Override
  public IScapSyncCweObservedExample[] getObservedExamples() {
    return fObservedExamples;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getDetectionMethods()
   */
  @Override
  public IScapSyncCweDetectionMethod[] getDetectionMethods() {
    return fDetectionMethods;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getAttackPattern
   */
  @Override
  public IScapSyncCweAttackPattern[] getAttackPatterns() {
    return fAttackPatterns;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getMitigations
   */
  @Override
  public IScapSyncCweMitigation[] getMitigations() {
    return fMitigations;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getReferences
   */
  @Override
  public IScapSyncCweReference[] getReferences() {
    return fReferences;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getUpstreamModified()
   */
  @Override
  public Date getUpstreamModified() {
    return fUpstreamModified;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweId()
   */
  @Override
  public String getCweId() {
    return fCweId;
  }


}
