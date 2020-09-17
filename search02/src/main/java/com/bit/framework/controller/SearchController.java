package com.bit.framework.controller;

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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.framework.model.ChapterDao;

public class SearchController implements Controller{

	ChapterDao chapterDao;

	public void setChapterDao(ChapterDao chapterDao) {
		this.chapterDao = chapterDao;
	}

	
	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
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
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String clientId = "INyNwc8RvDNjUoCD9lHg"; // 애플리케이션 클라이언트 아이디값"
		String clientSecret = "e4hlkduAe3"; // 애플리케이션 클라이언트 시크릿값"
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String text = new String(request.getParameter("search").getBytes("iso-8859-1"), "utf-8");
		System.out.println(text);

		try {
			text = URLEncoder.encode(text, "UTF-8");
			System.out.println(text);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

//		      String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text; // json 결과
		String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text; // json 결과
		System.out.println(apiURL);
		// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
		// // xml 결과

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
