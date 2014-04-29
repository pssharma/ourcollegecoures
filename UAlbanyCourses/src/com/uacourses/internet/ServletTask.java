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
	private String review;
	private String professorName;
	private float professorRating;
	private String username;
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public String getProfessorName() {
		return professorName;
	}


	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}


	public float getProfessorRating() {
		return professorRating;
	}


	public void setProfessorRating(float professorRating) {
		this.professorRating = professorRating;
	}


	public String getBlogSpot() {
		return blogSpot;
	}


	public void setBlogSpot(String blogSpot) {
		this.blogSpot = blogSpot;
	}


	@Override
	protected String doInBackground(String... urls) {

		String postInBg = null;
        for (String url : urls) {
        	postInBg = getStatusFromURL(url);
        }
        return postInBg;
        
	}
	
	
	private String getStatusFromURL(String url) {
        String status = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            
            List<NameValuePair> parameterValues = new ArrayList<NameValuePair>();
            
            HttpPost httpPost = new HttpPost(url);
            parameterValues.add(new BasicNameValuePair("blogspot", getBlogSpot()));
            parameterValues.add(new BasicNameValuePair("username", getUsername()));
            
            parameterValues.add(new BasicNameValuePair("review", getReview()));
            parameterValues.add(new BasicNameValuePair("professorName", getProfessorName()));
            parameterValues.add(new BasicNameValuePair("professorRating", String.valueOf(getProfessorRating())));
            
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
