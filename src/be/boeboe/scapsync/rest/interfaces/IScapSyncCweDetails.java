/**
 * 
 */
package be.boeboe.scapsync.rest.interfaces;

import java.util.Date;

/**
 * Interface to represent a ScapSync CWE
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
  "relationships" : [ {
    "url" : "/cwe/CWE-118",
    "target_form" : "Weakness",
    "target_id" : "CWE-118",
    "nature" : "is a child of",
    "views" : [ {
      "url" : "/cwe/CWE-1000",
      "id" : "CWE-1000"
    }, {
      "url" : "/cwe/CWE-699",
      "id" : "CWE-699"
    } ]
  }, ... ]
  } ],
  "alternate_terms" : [ {
    "name" : "Memory Corruption",
    "description" : "The generic term ..."
  } ],
  "platforms" : {
    "languages" : [ "Languages without memory management support", "C (Often)", "C++ (Often)", "Assembly" ],
    "notes" : "It is possible ..."
  },
  "demonstrative_examples" : [ {
    "body" : "Code example ...",
    "intro" : "This example takes an IP address ..."
  }, ...]
}
 * @author boeboe
 */
public interface IScapSyncCweDetails {

  /**
   * Get an array of Observed Examples from this CWE.
   * @return array of IScapSyncObservedCweExample's for this CWE
   */
  public IScapSyncCweObservedExample[] getObservedExamples();

  /**
   * Get an array of Detection Methods from this CWE.
   * @return array of IScapSyncCweDetectionMethod's for this CWE
   */
  public IScapSyncCweDetectionMethod[] getDetectionMethods();

  /**
   * Get an array of Attack Patterns from this CWE.
   * @return array of IScapSyncCweAttackPattern's for this CWE
   */
  public IScapSyncCweAttackPattern[] getAttackPatterns();

  /**
   * Get an array of Mitigations from this CWE.
   * @return array of IScapSyncCweMitigations's for this CWE
   */
  public IScapSyncCweMitigation[] getMitigations();

  /**
   * Get an array of References from this CWE.
   * @return array of IScapSyncCweReference's for this CWE
   */
  public IScapSyncCweReference[] getReferences();

  /**
   * Get an array of Taxonomy Mappings from this CWE.
   * @return array of IScapSyncCweTaxonomy's for this CWE
   */
  public IScapSyncCweTaxonomy[] getTaxonomyMappings();

  /**
   * Get an array of Consequences from this CWE.
   * @return array of IScapSyncCweConsequence's for this CWE
   */
  public IScapSyncCweConsequence[] getConsequences();

  /**
   * Get an array of History from this CWE.
   * @return array of IScapSyncCweHistory's for this CWE
   */
  public IScapSyncCweHistory[] getHistory();
  
  /**
   * Get the Upstream Modified Date from this CWE.
   * @return date the Upstream Modified Date from this CWE
   */
  public Date getUpstreamModified();

  /**
   * Get the CWE ID from this CWE.
   * @return notes the CWE ID from this CWE
   */
  public String getCweId();

  /**
   * Get the CWE Type from this CWE.
   * @return type the CWE Type from this CWE
   */
  public String getCweType();

  /**
   * Get the CWE Affected Resources from this CWE.
   * @return stringArray the CWE Affected Resources from this CWE
   */
  public String[] getCweAffectedResources();

  /**
   * Get the CWE Description from this CWE.
   * @return description the CWE Description from this CWE
   */
  public String getCweDescription();

  /**
   * Get the CWE VersionCount from this CWE.
   * @return int the CWE VersionCount from this CWE
   */
  public int getCweVersionCount();

  /**
   * Get the CWE Summary from this CWE.
   * @return summary the CWE Summary from this CWE
   */
  public String getCweSummary();

  /**
   * Get the CWE (relative) Version Url from this CWE.
   * @return url the CWE Version Url from this CWE
   */
  public String getCweVersionUrl();

  /**
   * Get the CWE Times Of Introduction from this CWE.
   * @return stringArray an array containing the Times Of Introduction from
   * this CWE
   */
  public String[] getCweTimesOfIntroduction();

  /**
   * Get the CWE Likelihood Of Exploit from this CWE.
   * @return likelihood the Likelihood Of Exploit from this CWE
   */
  public String getCweLikelihoodOfExploit();

}
