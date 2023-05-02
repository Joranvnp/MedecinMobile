package com.example.apmedecinandroid.utilitaire;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


public class AccesHTTP extends AsyncTask<String, Integer, Long> {
	public String ret="";
	//private ArrayList<NameValuePair> parametres;
	private HashMap<String, String> params;

	public String requestType;

	public AccesHTTP(String httpReq){
		this.requestType = httpReq;
		params = new HashMap<String, String>();
		//parametres = new ArrayList<NameValuePair>();
	}

	public void addParam(String nom, String valeur){
		params.put(nom, valeur);
		//parametres.add(new BasicNameValuePair(nom,valeur));
	}

	@Override
	protected Long doInBackground(String... urls) {
		// TODO Auto-generated method stub
		// Récupération des paramètres pour les envoyer dans la requête HTTP
		StringBuilder sbParams = new StringBuilder();
		int i = 0;
		for (String key : params.keySet()) {
			try {
				if (i != 0){
					sbParams.append("&");
				}
				sbParams.append(key).append("=")
						.append(URLEncoder.encode(params.get(key), "UTF-8"));

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			i++;
		}
		HttpURLConnection conn;

		// Création de la connexion HTTP et envoi des données
		try {
			URL urlObj = new URL(urls[0]);
			conn = (HttpURLConnection) urlObj.openConnection();
			conn.setRequestMethod(requestType);
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setReadTimeout(10000);
			conn.setConnectTimeout(15000);

			if (requestType.equals("GET")) {
				conn.setUseCaches(false);
				conn.setAllowUserInteraction(false);
				conn.addRequestProperty("Authorization", "Basic YWRtaW4fYFgjkl5463");
				int responseCode;
				responseCode = conn.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) { // success
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// print result
					this.ret=response.toString();

				} else {
					System.out.println("GET request did not work.");
				}
			} else {
				if (requestType.equals("POST")) {
					conn.setUseCaches(false);
					conn.setAllowUserInteraction(false);
					conn.addRequestProperty("Authorization", "Basic YWRtaW4fYFgjkl5463");
					conn.setDoOutput(true);
					OutputStream os = conn.getOutputStream();
					String paramsString = sbParams.toString();
					os.write(paramsString.getBytes());
					os.flush();
					os.close();
					int responseCode = conn.getResponseCode();
					System.out.println(conn.getResponseCode());
					System.out.println(conn.getResponseMessage());
					if (responseCode == HttpURLConnection.HTTP_OK) { // success
						BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();

						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();

						// print result
						this.ret=response.toString();
					} else {
						System.out.println("GET request did not work.");
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

				/*


			conn.setRequestMethod(requestType);
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setReadTimeout(10000);
			conn.setConnectTimeout(15000);

			conn.connect();

			String paramsString = sbParams.toString();

			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(paramsString);
			wr.flush();
			wr.close();

// traitement du retour de la requête (réponse)
			try {
				int responseCode = conn.getResponseCode();
				Log.d("log", "Response code: " + responseCode);
				conn.setRequestMethod("GET");
				InputStream in = new BufferedInputStream(conn.getInputStream());
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				StringBuilder result = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					result.append(line);
				}

				this.ret = result.toString();
				Log.d("test", "result from server: " + result.toString());

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					conn.disconnect();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}



/*
		HttpClient cnxHttp = new DefaultHttpClient();
		HttpPost paramCnx = new HttpPost(urls[0]);
		Log.d("log","urls[0] : "+urls[0]);
		try {
		    paramCnx.setEntity(new UrlEncodedFormEntity(parametres));
		    Log.d("log","parametres : "+parametres);
		    HttpResponse reponse = cnxHttp.execute(paramCnx);
		    ret = EntityUtils.toString(reponse.getEntity());
		    Log.d("log","ret : "+ret);
		} catch (ClientProtocolException e) {
		    // TODO Auto-generated catch block
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		}
		*/

		return null;
	}


	@Override
	protected void onPostExecute(Long result) {
		// preciser le code dans la classe qui l'appelle en surchargeant la methode
	}

}
