package com.wipro.weather.service;

import java.util.Date;
import java.sql.*;
import com.wipro.weather.bean.WeatherBean;

import com.wipro.weather.dao.WeatherDAO;

public class Administrator {
	WeatherDAO ob =new WeatherDAO();
	public String addForecast(WeatherBean weatherBean)
	{
		try
		{
			if(weatherBean==null || weatherBean.getLocation()==null || weatherBean.getDate()==null)
				throw new InvalidInputException();
			if(weatherBean.getLocation().length()<2)
				return "INVALID INPUT";
			boolean check=ob.reportExists(weatherBean.getLocation(), weatherBean.getDate());
			if(check)
				return "ALREADY EXISTS";
			Date date=new Date();
			if(weatherBean.getDate().compareTo(date)<=0)
				
			{
				return "INVALID INPUT";
			}
			
			
			String out=ob.generateReportID(weatherBean.getLocation(),weatherBean.getDate());
			weatherBean.setReportId(out);
			return ob.createForecast(weatherBean);
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public WeatherBean viewForecast(String location,Date date)
	{
		return ob.fetchForecast(location,date);
		
	}
}
