package com.wipro.weather.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.weather.bean.WeatherBean;
import com.wipro.weather.service.Administrator;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command=request.getParameter("command");
		
		switch(command)
		{
		case "addforecast":
			if(addForecast(request).equals("Fail")||addForecast(request).equals("INVALID INPUT")||addForecast(request).equals("ALREADY EXISTS"))
			{
				RequestDispatcher val=request.getRequestDispatcher("error.html");
			val.forward(request, response);
			}
			else {
				RequestDispatcher val=request.getRequestDispatcher("success.html");
				val.forward(request, response);
			}
				break;
		case "viewforecast":
		{
			
		WeatherBean	result=viewForecast(request);
		System.out.println(result);
			if(result==null)
			{
				HttpSession session=request.getSession();
				session.setAttribute("name", "fail");
				RequestDispatcher val=request.getRequestDispatcher("displayForecast.jsp");
				val.forward(request, response);
				
				
			}
			else {
				WeatherBean obj=viewForecast(request);
				HttpSession session=request.getSession();
				session.setAttribute("name", obj);
				RequestDispatcher val=request.getRequestDispatcher("displayForecast.jsp");
				val.forward(request, response);
				
			}
			break;
		}
		}
		
	}
	
	public String addForecast(HttpServletRequest request)
	{
		WeatherBean weatherbean=new WeatherBean();
		weatherbean.setLocation(request.getParameter("location"));
		weatherbean.setDate(new java.util.Date((request.getParameter("date"))));
		weatherbean.setTemperature(Integer.parseInt((request.getParameter("temperature"))));
		weatherbean.setHumidity(Integer.parseInt((request.getParameter("humidity"))));
		weatherbean.setWind(request.getParameter("wind"));
		weatherbean.setWind(request.getParameter("forecast"));
		Administrator ob1=new Administrator();
		String out=ob1.addForecast(weatherbean);
		System.out.print(out);
		return out;
	}
	
	public WeatherBean viewForecast(HttpServletRequest request)
	{
		Administrator ob1=new Administrator();
		WeatherBean wwb=new WeatherBean();
		wwb=ob1.viewForecast(request.getParameter("location"), new java.util.Date(request.getParameter("date")));
		return wwb;
	}

}
