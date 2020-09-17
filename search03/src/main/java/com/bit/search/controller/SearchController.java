package com.bit.search.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.search.model.ChapterDao;

import lombok.Setter;


@Controller
public class SearchController{
	
	@Autowired
	ChapterDao chapterDao;
	
	
	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // ?ï¿½ï¿½?ï¿½ï¿½ ?ï¿½ï¿½ï¿??
				return readBody(con.getInputStream());
			} else { // ?ï¿½ï¿½?ï¿½ï¿½ ë°œìƒ
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API ?ï¿½ï¿½ï¿??ï¿?? ?ï¿½ï¿½?ï¿½ï¿½ ?ï¿½ï¿½?ï¿½ï¿½", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL?ï¿½ï¿½ ?ï¿½ï¿½ëª»ë˜?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("?ï¿½ï¿½ê²°ì´ ?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) throws UnsupportedEncodingException {
		InputStreamReader streamReader = new InputStreamReader(body, "utf-8");

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}
			String tmp = new String(responseBody.toString());
			System.out.println("tmp = " + tmp);
			return tmp;
		} catch (IOException e) {
			throw new RuntimeException("API ?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½ ?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½ ?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½.", e);
		}
	}
	
	
	@RequestMapping("/goSearch.bit")
	public String goSerach() {
		return "goSearch";
	}
		
	@RequestMapping("/search.bit")
	public ModelAndView searchBooks(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String clientId = "INyNwc8RvDNjUoCD9lHg";
		String clientSecret = "e4hlkduAe3"; 
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String text = request.getParameter("search");//Á¤º¸Ã³¸®
		String start = "&start="+request.getParameter("start");//°Ë»ö°á°ú ¹®¼­µé ÀĞ´Â ½ÃÀÛ¼ø¼­.
		System.out.println(text+start);

		try {
			text = URLEncoder.encode(text, "UTF-8");
			System.out.println(text);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("encoding error", e);
		}

//		      String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text; // json
		
		String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text+start; // json 
		System.out.println(apiURL);
		// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
		// // xml ê²°ê³¼

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);

		System.out.println(responseBody);

		PrintWriter out = response.getWriter();
		out.print(responseBody);
		out.close();
		return null;
	}
}
