/**
 * 
 */
package be.boeboe.scapsync.rest.cwe;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.ScapSyncUtils;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweAlternateTerm;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweAttackPattern;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweConsequence;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweDemonstrativeExample;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetectionMethod;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweHistory;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweMitigation;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweObservedExample;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCwePlatforms;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweReference;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweRelationship;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweTaxonomy;

/**
 * Rest Implementation of a ScapSync CWE
 * 
 * Example json:
 * { "observed_examples" : [ { ... } ], "detection_methods" : [ { ... } ],
 *   "attack_patterns" : [ { ... } ], "mitigations" : [ { ... } ],
 *   "upstream_modified" : "2012-05-11T00:00:00Z", "cwe_id" : "CWE-119",
 *   "references" : [ {...} ], "cwe_type" : "Weakness",
 *   "affected_resources" : [ "Memory" ], "description" : "Certain ...",
 *   "version_count" : 1, "summary" : "The software performs ...",
 *   "version_url" : "/versions/cwe/CWE-119",
 *   "time_of_introduction" : [ "Architecture and Design", ... ],
 *   "likelihood_of_exploit" : "High", "history" : [ { ... } ],
 *   "taxonomy_mappings" : [ { ... } ], "consequences" : [ { ... } ],
 *   "relationships" : [ { ...} ], "alternate_terms" : [ { ... } ],
 *   "platforms" : { ... }, "demonstrative_examples" : [ { ... } ] }
 * @author boeboe
 */
public class ScapSyncCweDetailsRest implements IScapSyncCweDetails {
  private static final String OBSERVED_EXAMPLES = "observed_examples";
  private static final String DETECTION_METHODS = "detection_methods";
  private static final String ATTACK_PATTERNS = "attack_patterns";
  private static final String MITIGATIONS = "mitigations";
  private static final String REFERENCES = "references";
  private static final String TAXONOMY_MAPPINGS = "taxonomy_mappings";
  private static final String CONSEQUENCES = "consequences";
  private static final String HISTORY = "history";
  private static final String RELATIONSHIPS = "relationships";
  private static final String ALTERNATE_TERMS = "alternate_terms";
  private static final String PLATFORMS = "platforms";
  private static final String DEMONSTRATIVE_EXAMPLES = "demonstrative_examples";
  
  private static final String UPSTREAM_MODIFIED = "upstream_modified";
  private static final String CWE_ID = "cwe_id";
  private static final String CWE_TYPE = "cwe_type";
  private static final String AFFECTED_RESOURCES = "affected_resources";
  private static final String DESCRIPTION = "description";
  private static final String VERSION_COUNT = "version_count";
  private static final String SUMMARY = "summary";
  private static final String VERSION_URL = "version_url";
  private static final String TIME_OF_INTRODUCTION = "time_of_introduction";
  private static final String LIKELIHOOD_OF_EXPLOIT = "likelihood_of_exploit";
  
  private IScapSyncCweObservedExample[] fObservedExamples;
  private IScapSyncCweDetectionMethod[] fDetectionMethods;
  private IScapSyncCweAttackPattern[] fAttackPatterns;
  private IScapSyncCweMitigation[] fMitigations;
  private IScapSyncCweReference[] fReferences;
  private IScapSyncCweTaxonomy[] fTaxonomyMappings;
  private IScapSyncCweConsequence[] fConsequences;
  private IScapSyncCweHistory[] fHistrories;
  private IScapSyncCweRelationship[] fRelationships;
  private IScapSyncCweDemonstrativeExample[] fDemonstrativeExamples;
  private IScapSyncCweAlternateTerm[] fAlternateTerms;
  
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
  private IScapSyncCwePlatforms fPlatforms;
  
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
      fAffectedResources = ScapSyncUtils.getStringArray(affectedResources);

      JSONArray timesOfIntroduction = scapSyncCweDetailsRest.getJSONArray(TIME_OF_INTRODUCTION);
      fTimesOfIntroduction = ScapSyncUtils.getStringArray(timesOfIntroduction);

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

      JSONArray relationships = scapSyncCweDetailsRest.getJSONArray(RELATIONSHIPS);
      fRelationships = new IScapSyncCweRelationship[relationships.length()];
      for ( int i = 0 ; i < relationships.length(); i++) {
        fRelationships[i] =
            new ScapSyncCweRelationshipRest(relationships.getJSONObject(i));
      }

      JSONArray alternateTerms = scapSyncCweDetailsRest.getJSONArray(ALTERNATE_TERMS);
      fAlternateTerms = new IScapSyncCweAlternateTerm[alternateTerms.length()];
      for ( int i = 0 ; i < alternateTerms.length(); i++) {
        fAlternateTerms[i] =
            new ScapSyncCweAlternateTermRest(alternateTerms.getJSONObject(i));
      }

      JSONObject platforms = scapSyncCweDetailsRest.getJSONObject(PLATFORMS);
      fPlatforms = new ScapSyncCwePlatformsRest(platforms);

      JSONArray demonstrativeExamples = scapSyncCweDetailsRest.getJSONArray(DEMONSTRATIVE_EXAMPLES);
      fDemonstrativeExamples = new IScapSyncCweDemonstrativeExample[demonstrativeExamples.length()];
      for ( int i = 0 ; i < demonstrativeExamples.length(); i++) {
        fDemonstrativeExamples[i] =
            new ScapSyncCweDemonstrativeExampleRest(demonstrativeExamples.getJSONObject(i));
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getObservedExamples()
   */
  @Override
  public IScapSyncCweObservedExample[] getObservedExamples() {
    return fObservedExamples;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getDetectionMethods()
   */
  @Override
  public IScapSyncCweDetectionMethod[] getDetectionMethods() {
    return fDetectionMethods;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getAttackPattern
   */
  @Override
  public IScapSyncCweAttackPattern[] getAttackPatterns() {
    return fAttackPatterns;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getMitigations
   */
  @Override
  public IScapSyncCweMitigation[] getMitigations() {
    return fMitigations;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getReferences
   */
  @Override
  public IScapSyncCweReference[] getReferences() {
    return fReferences;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getTaxonomyMappings
   */
  @Override
  public IScapSyncCweTaxonomy[] getTaxonomyMappings() {
    return fTaxonomyMappings;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getConsequences
   */
  @Override
  public IScapSyncCweConsequence[] getConsequences() {
    return fConsequences;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getHistory
   */
  @Override
  public IScapSyncCweHistory[] getHistory() {
    return fHistrories;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getRelationships
   */
  @Override
  public IScapSyncCweRelationship[] getRelationships() {
    return fRelationships;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getAlternateTerms()
   */
  @Override
  public IScapSyncCweAlternateTerm[] getAlternateTerms() {
    return fAlternateTerms;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getDemonstrativeExamples()
   */
  @Override
  public IScapSyncCweDemonstrativeExample[] getDemonstrativeExamples() {
    return fDemonstrativeExamples;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getUpstreamModified()
   */
  @Override
  public Date getUpstreamModified() {
    return fUpstreamModified;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweId()
   */
  @Override
  public String getCweId() {
    return fCweId;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweType()
   */
  @Override
  public String getCweType() {
    return fCweType;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweAffectedResources()
   */
  @Override
  public String[] getCweAffectedResources() {
    return fAffectedResources;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweDescription()
   */
  @Override
  public String getCweDescription() {
    return fDescription;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweVersionCount()
   */
  @Override
  public int getCweVersionCount() {
    return fVersionCount;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweSummary()
   */
  @Override
  public String getCweSummary() {
    return fSummary;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweVersionUrl()
   */
  @Override
  public String getCweVersionUrl() {
    return fVersionUrl;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweTimesOfIntroduction()
   */
  @Override
  public String[] getCweTimesOfIntroduction() {
    return fTimesOfIntroduction;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getCweLikelihoodOfExploit()
   */
  @Override
  public String getCweLikelihoodOfExploit() {
    return fLikelihoodOfExploit;
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails#getPlatforms()
   */
  @Override
  public IScapSyncCwePlatforms getPlatforms() {
    return fPlatforms;
  }
}
