package com.wipro.weather.dao;


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import com.wipro.weather.bean.WeatherBean;
import com.wipro.weather.util.DBUtil;

public class WeatherDAO {
	Connection con=DBUtil.getDBConnection();
	public String createForecast(WeatherBean weatherBean)
	{
		
		String location=weatherBean.getLocation();
		Date date =new java.sql.Date( weatherBean.getDate().getTime());
		int humidity =weatherBean.getHumidity();
		int temperature =weatherBean.getTemperature();
		String wind=weatherBean.getWind();
		String forecast=weatherBean.getForecast();

		//weatherBean.setReportId(generateReportID(location, date));
		String id=weatherBean.getReportId();
		System.out.println(id);
		
		
		try
		{
			System.out.println("sjdh hgfh");
			String query = "insert into WEATHER_TB values(?,?,?,?,?,?,?) ";
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1,id);
			stmt.setString(2,location);
			
			stmt.setDate(3,date);
			
			stmt.setLong(4,temperature);
			
			stmt.setLong(5,humidity );
			
			stmt.setString(6,wind);
			
			stmt.setString(7,forecast);
			System.out.println("sjdh");
			
			stmt.execute();
			
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return "Fail";
		}
		return id;
		
		
	}
	public WeatherBean fetchForecast(String location, java.util.Date  date)
	{
		DBUtil db=new DBUtil();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String newdate = sdf.format(date);
		System.out.println(newdate);
		WeatherBean wb=new WeatherBean();
		try {
			String query1 = "select * from WEATHER_TB where LOCATION=? and R_DATE=?";
			
			PreparedStatement st = con.prepareStatement(query1);
			st.setString(1, location);
			st.setString(2, newdate);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
			wb.setReportId(rs.getString(1));
			wb.setLocation(rs.getString(2));
			wb.setDate(rs.getDate(3));
			wb.setHumidity(rs.getInt(4));
			wb.setTemperature(rs.getInt(5));
			wb.setWind(rs.getString(6));
			wb.setForecast(rs.getString(7));
			}
			else
			{
				return null;
			}
			
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		return wb;
		
	}
	public String generateReportID(String location,java.util.Date date)
	{
		DBUtil db=new DBUtil();
		
		
		String query2="12";
		DateFormat format=new SimpleDateFormat("yyyyMMdd");
		String temp=format.format(date);
		String loc=location.substring(0,2);
		loc.toUpperCase();
		String id=temp+loc+query2;
	
		
		
		return id;
		
		
	}

	public boolean reportExists(String location,java.util.Date date)
	{
		//DBUtil db=new DBUtil();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String newdate = sdf.format(date);
		
		try
		{
			String query3 = "select * from WEATHER_TB where LOCATION=? and R_DATE=?";
			PreparedStatement st = con.prepareStatement(query3);
			st.setString(1, location);
			st.setString(2, newdate);
			ResultSet rs=st.executeQuery();
			rs.next();
			if(rs.getString(1).equals(location) && rs.getDate(2).equals(date))
			{
				
				return true;
			}
			else
			{
				
				return false;
			}
		}
			
			catch(SQLException e)
			{
				return false;
			}
			
		}
		
	}



