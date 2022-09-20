package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex02_review")
public class Ex02_review extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String client_id = request.getRemoteHost();
		System.out.println("들어온 사람:  " + client_id);
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String[] team_id = {"222.102.104.208", "119.200.31.122", "218.149.140.50", "61.80.80.187", "121.147.52.180", "0:0:0:0:0:0:0:1"};
		
		for(int i=0; i<=team_id.length; i++) {
			if(client_id.equals(team_id[i])){
				out.print("중걸팀!!!");
				break;
//				out.print("<img src = 'img/img.jfif>");
			}else {
				out.print("땡!!");
				break;
			}
		}
		
		
			
	}

}
