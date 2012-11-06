package be.boeboe.scapsync.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.cpe.ScapSyncCpeDetailsRest;
import be.boeboe.scapsync.rest.cve.ScapSyncCveDetailsRest;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCpeDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchPage;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResultType;
import be.boeboe.scapsync.rest.search.ScapSyncSearchRest;

/**
 * ScapSyncSearcher class.
 * @author boeboe
 */
public class ScapSyncSearcher {
  private static URI SCAP_SYNC_BASE_URL = URI.create("http://scapsync.com");
  private static String SEARCH_PATTERN = "search_url";
  
  private final DefaultHttpClient fHttpClient;
  private URI fSearchBaseUri;
  private URI fQueryCceBaseUri;
  private URI fQueryCpeBaseUri;
  private URI fQueryCveBaseUri;
  private URI fQueryCweBaseUri;

  public ScapSyncSearcher() {
    fHttpClient = new DefaultHttpClient();
    
    JSONObject jsonMain = execRestGet(SCAP_SYNC_BASE_URL);
    
    try {
      fSearchBaseUri = URI.create(jsonMain.getString(SEARCH_PATTERN));
      fQueryCceBaseUri = URI.create(fSearchBaseUri + "?solrDocumentType=cce&q=");
      fQueryCpeBaseUri = URI.create(fSearchBaseUri + "?solrDocumentType=cpe&q=");
      fQueryCveBaseUri = URI.create(fSearchBaseUri + "?solrDocumentType=cve&q=");
      fQueryCweBaseUri = URI.create(fSearchBaseUri + "?solrDocumentType=cce&q=");

    } catch (JSONException e) {
      throw new RuntimeException("Problem fetching base url patterns", e);
    }
  }

  public String getfSearchBaseUri() {
    return fSearchBaseUri.toString();
  }

  
  /**
   * Search for CCE's (Common Configuration Enumeration) or misconfigurations.
   * CCE provides unique identifiers to system configuration issues in order
   * to facilitate fast and accurate correlation of configuration data across
   * multiple information sources and tools. For example, CCE Identifiers can
   * be used to associate checks in configuration assessment tools with
   * statements in configuration best-practice.
   * @return
   */
  public IScapSyncSearchResult[] searchCce(String searchItem) {
    return recursiveScapSyncSearchResult(fQueryCceBaseUri, searchItem);
  }

  /**
   * Search for CPE's (Common Platform Enumeration).
   * CPE is a structured naming scheme for information technology systems,
   * software, and packages. Based upon the generic syntax for Uniform
   * Resource Identifiers (URI), CPE includes a formal name format, a method
   * for checking names against a system, and a description format for
   * binding text and tests to a name. 
   * @param searchItem the item to look for
   * @return CPE's containing searchItem
   */
  public IScapSyncSearchResult[] searchCpe(String searchItem) {
    return recursiveScapSyncSearchResult(fQueryCpeBaseUri, searchItem);
  }

  /**
   * Search for CVE's (Common Vulnerabilities and Exposures) or security
   * related software flaws. CVE is a dictionary of publicly known information
   * security vulnerabilities and exposures. CVE’s common identifiers enable
   * data exchange between security products and provide a baseline index point
   * for evaluating coverage of tools and services.
   * @param searchItem the item to look for
   * @return CVE's containing searchItem
   */
  public IScapSyncSearchResult[] searchCve(String searchItem) {
    return recursiveScapSyncSearchResult(fQueryCveBaseUri, searchItem);
  }
  
  /**
   * Search for CWE's (Common Weakness Enumeration). The Common Weakness
   * Enumeration Specification (CWE) provides a common language of discourse
   * for discussing, finding and dealing with the causes of software security
   * vulnerabilities as they are found in code, design, or system architecture.
   * Each individual CWE represents a single vulnerability type.
   * @return
   */
  public IScapSyncSearchResult[] searchCwe(String searchItem) {
    return recursiveScapSyncSearchResult(fQueryCweBaseUri, searchItem);
  }
  
  public IScapSyncCpeDetails getCpeDetails(IScapSyncSearchResult searchResult) {
    if (searchResult.getType() != IScapSyncSearchResultType.TYPE_CPE) {
      return null;
    } else {
      URI detailsUri = URI.create(SCAP_SYNC_BASE_URL + searchResult.getUrl());
      JSONObject jsonDetailsResult = execRestGet(detailsUri);
      return new ScapSyncCpeDetailsRest(jsonDetailsResult);
    }
  }
  
  public IScapSyncCveDetails getCveDetails(IScapSyncSearchResult searchResult) {
    if (searchResult.getType() != IScapSyncSearchResultType.TYPE_CVE) {
      return null;
    } else {
      URI detailsUri = URI.create(SCAP_SYNC_BASE_URL + searchResult.getUrl());
      JSONObject jsonDetailsResult = execRestGet(detailsUri);
      return new ScapSyncCveDetailsRest(jsonDetailsResult);
    }
  }

  private JSONObject execRestGet(URI uri) {
    HttpGet request = new HttpGet(uri);
    request.addHeader("Accept", "application/json");

    try {
      HttpResponse response = fHttpClient.execute(request);
      if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
        throw new RuntimeException("Unexpected server response "
           + response.getStatusLine() + " for " + request.getRequestLine());
      }
      
      InputStream inputStream = response.getEntity().getContent();
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      StringBuilder stringBuilder = new StringBuilder();
      
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line);
      }
      
      String output = stringBuilder.toString();
      JSONObject json = new JSONObject(output);
      return json;
    } catch (IOException e) {
      throw new RuntimeException("Problem reading remote response for " + request.getRequestLine(), e);
    } catch (JSONException e) {
      throw new RuntimeException("Problem JSONParsing remote response for " + request.getRequestLine(), e);
    }
  }

  private IScapSyncSearchResult[] recursiveScapSyncSearchResult(URI baseUri, 
      String searchItem) {
    List<IScapSyncSearchResult> resultList = new ArrayList<IScapSyncSearchResult>();
    
    URI queryUri = URI.create(baseUri + searchItem);
    JSONObject jsonFirstResult = execRestGet(queryUri);
    ScapSyncSearchRest firstResult = new ScapSyncSearchRest(jsonFirstResult);
    
    for (IScapSyncSearchPage page : firstResult.getPages() ) {
      URI pageUri = URI.create(SCAP_SYNC_BASE_URL + page.getUrl());
      JSONObject jsonResult = execRestGet(pageUri);
      ScapSyncSearchRest result = new ScapSyncSearchRest(jsonResult);
      resultList.addAll(Arrays.asList(result.getResults()));
    }
    
    return resultList.toArray(new IScapSyncSearchResult[resultList.size()]);
  }
}
