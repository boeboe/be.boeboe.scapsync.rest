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
 *   "references" : [ {...} ],
  "time_of_introduction" : [ "Architecture and Design", "Implementation", "Operation" ],
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
  "cwe_type" : "Weakness",
  "affected_resources" : [ "Memory" ],
  "description" : "Certain languages ...",
  "version_count" : 1,
  "alternate_terms" : [ {
    "name" : "Memory Corruption",
    "description" : "The generic term ..."
  } ],
  "likelihood_of_exploit" : "High",
  "taxonomy_mappings" : [ {
    "taxonomy" : "OWASP Top Ten 2004",
    "name" : "Buffer Overflows",
    "fit" : "Exact",
    "id" : "A5"
  }, {
    "taxonomy" : "CERT C Secure Coding",
    "name" : "Understand how arrays work",
    "id" : "ARR00-C"
  }, ...],
  "consequences" : [ {
    "impact" : "Execute unauthorized ...",
    "scope" : "Integrity, Confidentiality, Availability",
    "notes" : "If the memory accessible by the attacker ..."
  }, ...],
  "platforms" : {
    "languages" : [ "Languages without memory management support", "C (Often)", "C++ (Often)", "Assembly" ],
    "notes" : "It is possible ..."
  },
  "summary" : "The software performs ...",
  "version_url" : "/versions/cwe/CWE-119",
  "history" : [ {
    "date" : "2008-07-01T00:00:00Z",
    "organization" : "Cigital",
    "modifier" : "Eric Dalci",
    "comment" : "updated Time_of_Introduction"
  }, {
    "date" : "2008-08-15T00:00:00Z",
    "organization" : "Veracode",
    "comment" : "Suggested OWASP Top Ten 2004\n                        mapping"
  }, ...],
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
   * Get the Upstream Modified Date from this CWE.
   * @return date the Upstream Modified Date from this CWE
   */
  public Date getUpstreamModified();

  /**
   * Get the CWE ID from this CWE.
   * @return notes the CWE ID from this CWE
   */
  public String getCweId();
}
