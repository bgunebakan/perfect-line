/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfectline.admin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.http.HttpHeaders.USER_AGENT;

/**
 *
 * @author gunebakan
 */
public class Client {
    
    String ClientIP;
    String quarkId;
    String Response;
    
    Client(String id){
        
            quarkId = id;
            ClientIP = "192.168.0.201";
            
 
 
        
    }
    
    
    public boolean Channelcommand(String command,String channelName) {

        
        try {
            //String url = "http://127.0.0.1:3000/add-channel/Team1";
           //ClientIP = "192.168.0.13";
            String url = "http://" + ClientIP + ":3000/" + quarkId + "/" + command + "/" + channelName;
            System.out.println(url);
            
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            
            //add reuqest header
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            
            String urlParameters = "Team1";
            
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
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            }
            in.close();
            
            //print result
            Response = response.toString();
            System.out.println(response.toString());
            if (Response.equals("error")){
                return false;
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
	}
    
}
