/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfectline.admin;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.apache.http.HttpHeaders.USER_AGENT;

/**
 *
 * @author gunebakan
 */
public class Client {
    
    String ClientIP;
    
    Client(int ClientId){
        
            ClientIP = "192.168.0." + ClientId;
           
 
 
        
    }
    
    
    private void Channelcommand(String command,int quarkId,String channelName) throws Exception {

        
		String url = "http://127.0.0.1:3000/" + command + "/" + channelName;
                //String url = "http://192.168.0." + quarkId + ":3000/" + command + "/" + channelName;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
                /*
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
                */
	}
    
}
