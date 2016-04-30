/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfectline.admin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import static org.apache.http.HttpHeaders.USER_AGENT;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author gunebakan
 */
public class Client {
    
    String ClientIP;
    
    Client(int ClientId){
        
            ClientIP = "192.168.0." + ClientId;
            	
                // create HTTP Client
		HttpClient httpClient = HttpClientBuilder.create().build();
 
		// Create new getRequest with below mentioned URL
		HttpPost postRequest = new HttpPost("http://" + ClientIP );
 
                // Add additional header to getRequest which accepts application/xml data
		postRequest.addHeader("accept", "application/xml");
 
 
        
    }
    
    
    public void Add(){
        
        
        
    }
    
    public void Join(){
        
        
        
    }
    public void Remove(){
        
        
    }
    
    // HTTP POST request
    private void sendPost() throws Exception {

	String url = "http://" + ClientIP;
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	//add reuqest header
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
	
	// Send post request
	con.setDoOutput(true);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.writeBytes(urlParameters);
	wr.flush();
	wr.close();

	int responseCode = con.getResponseCode();
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + urlParameters);
	System.out.println("Response Code : " + responseCode);

	BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuilder response = new StringBuilder();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();
		
	//print result
	System.out.println(response.toString());

    }
    
}
