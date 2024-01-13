package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceModel {
	
	static Connection con=null;
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja10?user=root&password=sql123");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<DTO> record(){
		List<DTO> data = new ArrayList<>();
		Statement stm=null;
		ResultSet rs= null;
		String query="select * from movie_db";
		try {
			stm=con.createStatement();
			rs=stm.executeQuery(query);
			while(rs.next())
			{
				DTO d1=new DTO();
				d1.setMovieName(rs.getString("movie_name"));
				d1.setMovieTheater(rs.getString("movie_theater"));
				d1.setPrice(rs.getDouble("price_per_ticket"));
				data.add(d1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	  }
	
	
   public int checkTicket(DTO d1) {
		
		//String query="select * from Exam";
		String query1="select no_of_ticket from movie_db where movie_name='"+d1.getMovieName()+"' and movie_theater='"+d1.getMovieTheater()+"' ";
		Statement stm = null;
		ResultSet rs= null;
		
		try {
			stm=con.createStatement();
			rs=stm.executeQuery(query1);
			
			while(rs.next()){ 
			        //user Enter Ticket--Fetch No_Of_Ticke
					if(d1.getTicket()<=rs.getInt("no_of_ticket"))
					{
						return 1;
					}
					else if(d1.getTicket()> rs.getInt("no_of_ticket"))
					{
						return 2;
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public double bookticket(DTO d1) {
		String query="select * from movie_db";
		String query1="update movie_db set no_of_ticket=? where movie_id=?";
		Statement stm = null;
		ResultSet rs= null;
		PreparedStatement pmt =null;
		double price=0.0;
		try {
			stm=con.createStatement();
			rs=stm.executeQuery(query);
			while(rs.next())
			{	
				if(d1.getMovieName().equalsIgnoreCase(rs.getString("movie_name"))&&d1.getMovieTheater().equalsIgnoreCase(rs.getString("movie_theater")))
				{
					int id=rs.getInt("movie_id");
					//System.out.println(rs.getInt(4));
					if(d1.getTicket()<=rs.getInt("no_of_ticket"))
					{
						price=d1.getTicket()*rs.getDouble("price_per_ticket");
						price= price +(price*0.18);
						int ticket = rs.getInt("no_of_ticket");
						if(0<d1.getTicket())
						{
							int update = ticket-d1.getTicket();
							pmt=con.prepareStatement(query1);
							pmt.setInt(1, update);
							pmt.setInt(2, id);
							pmt.executeUpdate();	
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}
 public	double price(DTO d1) {
		String query1="select price_per_ticket from movie_db where movie_name='"+d1.getMovieName()+"' and movie_theater='"+d1.getMovieTheater()+"' ";
		Statement stm = null;
		ResultSet rs= null;
		double price=0.0;
		
		try {
			stm=con.createStatement();
			rs=stm.executeQuery(query1);
			while(rs.next()) {
				price=rs.getDouble("price_per_ticket");
			  //d1.getPrice=rs.getDouble("price_per_ticket");
			  //price=d1.getPrice;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}
}

