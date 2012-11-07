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
import be.boeboe.scapsync.rest.cwe.ScapSyncCweDetailsRest;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCpeDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchPage;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResultType;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearcher;
import be.boeboe.scapsync.rest.search.ScapSyncSearchRest;

/**
 * Rest Implementation of a ScapSyncSearcher.
 * @author boeboe
 */
public class ScapSyncSearcher implements IScapSyncSearcher {
  private static final URI SCAP_SYNC_BASE_URL = URI.create("http://scapsync.com");
  private static final String SEARCH_PATTERN = "search_url";
  
  private final DefaultHttpClient fHttpClient;
  private URI fSearchBaseUri;
  private URI fQueryAllBaseUri;
  private URI fQueryCceBaseUri;
  private URI fQueryCpeBaseUri;
  private URI fQueryCveBaseUri;
  private URI fQueryCweBaseUri;

  public ScapSyncSearcher() {
    fHttpClient = new DefaultHttpClient();
    
    JSONObject jsonMain = execRestGet(SCAP_SYNC_BASE_URL);
    
    try {
      fSearchBaseUri = URI.create(jsonMain.getString(SEARCH_PATTERN));
      fQueryAllBaseUri = URI.create(fSearchBaseUri + "?q=");
      fQueryCceBaseUri = URI.create(fSearchBaseUri + "?solrDocumentType=cce&q=");
      fQueryCpeBaseUri = URI.create(fSearchBaseUri + "?solrDocumentType=cpe&q=");
      fQueryCveBaseUri = URI.create(fSearchBaseUri + "?solrDocumentType=cve&q=");
      fQueryCweBaseUri = URI.create(fSearchBaseUri + "?solrDocumentType=cwe&q=");

    } catch (JSONException e) {
      throw new RuntimeException("Problem fetching base url patterns", e);
    }
  }

  public String getfSearchBaseUri() {
    return fSearchBaseUri.toString();
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearcher#searchAll(java.lang.String)
   */
  public IScapSyncSearchResult[] searchAll(String searchItem) {
    return recursiveScapSyncSearchResult(fQueryAllBaseUri, searchItem);
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearcher#searchCce(java.lang.String)
   */
  public IScapSyncSearchResult[] searchCce(String searchItem) {
    return recursiveScapSyncSearchResult(fQueryCceBaseUri, searchItem);
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearcher#searchCpe(java.lang.String)
   */
  public IScapSyncSearchResult[] searchCpe(String searchItem) {
    return recursiveScapSyncSearchResult(fQueryCpeBaseUri, searchItem);
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearcher#searchCve(java.lang.String)
   */
  public IScapSyncSearchResult[] searchCve(String searchItem) {
    return recursiveScapSyncSearchResult(fQueryCveBaseUri, searchItem);
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearcher#searchCwe(java.lang.String)
   */
  public IScapSyncSearchResult[] searchCwe(String searchItem) {
    return recursiveScapSyncSearchResult(fQueryCweBaseUri, searchItem);
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearcher#getCpeDetails(
   *          be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult)
   */
  public IScapSyncCpeDetails getCpeDetails(IScapSyncSearchResult searchResult) {
    if (searchResult.getType() != IScapSyncSearchResultType.TYPE_CPE) {
      return null;
    } else {
      URI detailsUri = URI.create(SCAP_SYNC_BASE_URL + searchResult.getUrl());
      JSONObject jsonDetailsResult = execRestGet(detailsUri);
      return new ScapSyncCpeDetailsRest(jsonDetailsResult);
    }
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearcher#getCveDetails(
   *          be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult)
   */
  public IScapSyncCveDetails getCveDetails(IScapSyncSearchResult searchResult) {
    if (searchResult.getType() != IScapSyncSearchResultType.TYPE_CVE) {
      return null;
    } else {
      URI detailsUri = URI.create(SCAP_SYNC_BASE_URL + searchResult.getUrl());
      JSONObject jsonDetailsResult = execRestGet(detailsUri);
      return new ScapSyncCveDetailsRest(jsonDetailsResult);
    }
  }

  /**
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearcher#getCweDetails(
   *        be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult)
   */
  public IScapSyncCweDetails getCweDetails(IScapSyncSearchResult searchResult) {
    if (searchResult.getType() != IScapSyncSearchResultType.TYPE_CWE) {
      return null;
    } else {
      URI detailsUri = URI.create(SCAP_SYNC_BASE_URL + searchResult.getUrl());
      JSONObject jsonDetailsResult = execRestGet(detailsUri);
      return new ScapSyncCweDetailsRest(jsonDetailsResult);
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
