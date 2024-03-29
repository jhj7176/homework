package com.bitjeju.teacher.dr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lmsteacherdownload.bit")
public class DrDownloadController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName=request.getParameter("fileName");
		System.out.println("fileName:"+fileName);
		if(fileName!=null){
			String directory=this.getServletContext().getRealPath("/upload");
			File file=new File(directory+"/"+fileName);
			
			String mimeType=getServletContext().getMimeType(file.toString());
			if(mimeType==null) {
				response.setContentType("application/octet-stream");
			}
			
			String downloadName=null;
			downloadName=URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");
			
			response.setHeader("Content-Disposition", "attachment;filename=\""+downloadName+"\";");
			
			FileInputStream fileInputStream=new FileInputStream(file);
			ServletOutputStream servletOutputStream=response.getOutputStream();
			
			byte b[]=new byte[1024];
			int data=0;
			while((data=(fileInputStream.read(b,0,b.length)))!=-1) {
				servletOutputStream.write(b,0,data);
			}
			
			servletOutputStream.flush();
			servletOutputStream.close();
			fileInputStream.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
