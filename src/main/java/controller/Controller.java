package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DTO;
import model.ServiceModel;
@WebServlet(urlPatterns = {"/movielink","/link"})
public class Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path=req.getServletPath();
		switch(path)
		{
		case "/link":movieDetails(req, resp);
			break;
		
		case "/movielink":bookTicket(req, resp);
			break;
		}
	}
	private void bookTicket(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String movieName=req.getParameter("moviename");
		String movieTheater =req.getParameter("movietheater");
		int ticket=Integer.parseInt(req.getParameter("ticket"));
		
		DTO d1=new DTO();
		d1.setMovieName(movieName);
		d1.setMovieTheater(movieTheater);
		d1.setTicket(ticket);
		
		ServiceModel m1=new ServiceModel();
		int found=m1.checkTicket(d1);
		double tPrice=m1.price(d1);
		
		if(found==1){	
			    double bill = m1.bookticket(d1);
				RequestDispatcher rd= req.getRequestDispatcher("displayBill.jsp");
				req.setAttribute("Price", tPrice );
				req.setAttribute("result", bill);	
				req.setAttribute("found", true);
				rd.forward(req, resp);
		}else if(found==2){
			RequestDispatcher rd= req.getRequestDispatcher("displayBill.jsp");
			req.setAttribute("result", "Tikects Not Availble, limit exced");
			req.setAttribute("found", false);
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd= req.getRequestDispatcher("displayBill.jsp");
			req.setAttribute("result", "Movie Not released  In This Theater plz Choose another	");
			req.setAttribute("found", false);
			rd.forward(req, resp);
		}
		
	}

	private void movieDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServiceModel m1=new ServiceModel();
		List<DTO> data= m1.record();
		
		req.setAttribute("result", data);
		RequestDispatcher rd= req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
		
	}
}
