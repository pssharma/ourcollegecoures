/**
 * 
 */
package com.uacourses.internet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

/**
 * @author Nilangshu
 *
 */
public class ServletTask extends AsyncTask<String, Void, String>{
	
	private String blogSpot;
	
	public String getBlogSpot() {
		return blogSpot;
	}


	public void setBlogSpot(String blogSpot) {
		this.blogSpot = blogSpot;
	}


	@Override
	protected String doInBackground(String... urls) {

		String postBlogInBg = null;
        for (String url : urls) {
        	postBlogInBg = getStatusFromURL(url);
        }
        return postBlogInBg;
        
	}
	
	
	private String getStatusFromURL(String url) {
        String status = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            
            List<NameValuePair> parameterValues = new ArrayList<NameValuePair>();
            
            HttpPost httpPost = new HttpPost(url);
            parameterValues.add(new BasicNameValuePair("blogspot", getBlogSpot()));
            
            httpPost.setEntity(new UrlEncodedFormEntity(parameterValues,HTTP.UTF_8));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            status = EntityUtils.toString(httpEntity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }

}
