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
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweConsequence;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetectionMethod;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweHistory;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweMitigation;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweObservedExample;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweReference;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweTaxonomy;

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
  private static String TAXONOMY_MAPPINGS = "taxonomy_mappings";
  private static String CONSEQUENCES = "consequences";
  private static String HISTORY = "history";
  
  private static String UPSTREAM_MODIFIED = "upstream_modified";
  private static String CWE_ID = "cwe_id";
  private static String CWE_TYPE = "cwe_type";
  private static String AFFECTED_RESOURCES = "affected_resources";
  private static String DESCRIPTION = "description";
  private static String VERSION_COUNT = "version_count";
  private static String SUMMARY = "summary";
  private static String VERSION_URL = "version_url";
  private static String TIME_OF_INTRODUCTION = "time_of_introduction";
  private static String LIKELIHOOD_OF_EXPLOIT = "likelihood_of_exploit";
  
  private IScapSyncCweObservedExample[] fObservedExamples;
  private IScapSyncCweDetectionMethod[] fDetectionMethods;
  private IScapSyncCweAttackPattern[] fAttackPatterns;
  private IScapSyncCweMitigation[] fMitigations;
  private IScapSyncCweReference[] fReferences;
  private IScapSyncCweTaxonomy[] fTaxonomyMappings;
  private IScapSyncCweConsequence[] fConsequences;
  private IScapSyncCweHistory[] fHistrories;
  
  private Date fUpstreamModified;
  private String fCweId;
  private String fCweType;
  private String[] fAffectedResources;
  private String fDescription;
  private int fVersionCount;
  private String fSummary;
  private String fVersionUrl;
  private String[] fTimesOfIntroduction;
  private String fLikelihoodOfExploit;
  
  public ScapSyncCweDetailsRest(JSONObject scapSyncCweDetailsRest) {
    super();
    try {
      fUpstreamModified = ScapSyncUtils.getDate(scapSyncCweDetailsRest.getString(UPSTREAM_MODIFIED));
      fCweId = scapSyncCweDetailsRest.getString(CWE_ID);
      fCweType = scapSyncCweDetailsRest.getString(CWE_TYPE);
      fDescription = scapSyncCweDetailsRest.getString(DESCRIPTION);
      fVersionCount = scapSyncCweDetailsRest.getInt(VERSION_COUNT);
      fSummary = scapSyncCweDetailsRest.getString(SUMMARY);
      fVersionUrl = scapSyncCweDetailsRest.getString(VERSION_URL);
      fLikelihoodOfExploit = scapSyncCweDetailsRest.getString(LIKELIHOOD_OF_EXPLOIT);

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
      
      JSONArray affectedResources = scapSyncCweDetailsRest.getJSONArray(AFFECTED_RESOURCES);
      fAffectedResources = new String[affectedResources.length()];
      for ( int i = 0 ; i < affectedResources.length(); i++) {
        fAffectedResources[i] = affectedResources.getString(i);
      }

      JSONArray timesOfIntroduction = scapSyncCweDetailsRest.getJSONArray(TIME_OF_INTRODUCTION);
      fTimesOfIntroduction = new String[timesOfIntroduction.length()];
      for ( int i = 0 ; i < timesOfIntroduction.length(); i++) {
        fTimesOfIntroduction[i] = timesOfIntroduction.getString(i);
      }

      JSONArray taxonomyMappings = scapSyncCweDetailsRest.getJSONArray(TAXONOMY_MAPPINGS);
      fTaxonomyMappings = new IScapSyncCweTaxonomy[taxonomyMappings.length()];
      for ( int i = 0 ; i < taxonomyMappings.length(); i++) {
        fTaxonomyMappings[i] =
            new ScapSyncCweTaxonomyRest(taxonomyMappings.getJSONObject(i));
      }

      JSONArray consequences = scapSyncCweDetailsRest.getJSONArray(CONSEQUENCES);
      fConsequences = new IScapSyncCweConsequence[consequences.length()];
      for ( int i = 0 ; i < consequences.length(); i++) {
        fConsequences[i] =
            new ScapSyncCweConsequenceRest(consequences.getJSONObject(i));
      }

      JSONArray histories = scapSyncCweDetailsRest.getJSONArray(HISTORY);
      fHistrories = new IScapSyncCweHistory[histories.length()];
      for ( int i = 0 ; i < histories.length(); i++) {
        fHistrories[i] =
            new ScapSyncCweHistoryRest(histories.getJSONObject(i));
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
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getTaxonomyMappings
   */
  @Override
  public IScapSyncCweTaxonomy[] getTaxonomyMappings() {
    return fTaxonomyMappings;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getConsequences
   */
  @Override
  public IScapSyncCweConsequence[] getConsequences() {
    return fConsequences;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getHistory
   */
  @Override
  public IScapSyncCweHistory[] getHistory() {
    return fHistrories;
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

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweType()
   */
  @Override
  public String getCweType() {
    return fCweType;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweAffectedResources()
   */
  @Override
  public String[] getCweAffectedResources() {
    return fAffectedResources;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweDescription()
   */
  @Override
  public String getCweDescription() {
    return fDescription;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweVersionCount()
   */
  @Override
  public int getCweVersionCount() {
    return fVersionCount;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweSummary()
   */
  @Override
  public String getCweSummary() {
    return fSummary;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweVersionUrl()
   */
  @Override
  public String getCweVersionUrl() {
    return fVersionUrl;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweTimesOfIntroduction()
   */
  @Override
  public String[] getCweTimesOfIntroduction() {
    return fTimesOfIntroduction;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweLikelihoodOfExploit()
   */
  @Override
  public String getCweLikelihoodOfExploit() {
    return fLikelihoodOfExploit;
  }
}
