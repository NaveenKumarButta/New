package com.capgemini.storesmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.dto.OrderDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.StockDetailsInfo;

public class DealerImpl implements DealerDao{
	static Logger log=LogManager.getLogger("Dealer");
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	@Override
	public boolean loginDealer(OrderDetailsInfo info) {
		
			try {

				Class.forName("com.mysql.jdbc.Driver").newInstance();
				String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
				con = DriverManager.getConnection(dburl, "root", "hr");
				String query = "select userId,password from orderdetailsinfo where userId=?";

				ps = con.prepareStatement(query);
				ps.setInt(1,info.getUserId());
				ps.setString(2, info.getPassword());

				int count = ps.executeUpdate();
				log.info("no of rows affected: " + count);

			} catch (Exception e) {
				log.info("Exception in login records");
			} finally {
				try {
					if (con != null) {
						con.close();
					}
					if (ps != null) {
						ps.close();
					}

				} catch (SQLException e) {
					log.info("Exception in login records 1");
				}
			}
			return false;

		
		}
		
	

	@Override
	public boolean makeOrder(OrderDetailsInfo info1) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "insert into orderdetailsinfo values(?,?,?,?,?,?)";

			ps = con.prepareStatement(query);
			ps.setString(1, info1.getUserName());
			ps.setInt(2, info1.getOrderId());
			ps.setInt(3,info1.getProductId());
			ps.setInt(4,info1.getQuantity());
			ps.setString(5, info1.getAddress());
			ps.setInt(6, info1.getUserId());


			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);

		} catch (Exception e) {
			log.info("Exception in login records");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				log.info("Exception in login records 1");
			}
		}
		return false;

		
	}

		
	

	@Override
	public boolean deleteOrder(OrderDetailsInfo info2) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "delete from userDetailsInfo where userName=?";

			ps = con.prepareStatement(query);

			ps.setString(1, info2.getUserName());


			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);

		} catch (Exception e) {
			log.info("Exception 1");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				log.info("Hello Exception");
			}
		}
		return false;

		
	}

		
	

	@Override
	public boolean viewMyOrder(OrderDetailsInfo info3) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "select * from orderdetailsinfo";

			ps = con.prepareStatement(query);
			ps.setString(1, info3.getUserName());
			ps.setInt(2,info3.getOrderId());
			ps.setInt(3,info3.getProductId());
			ps.setInt(4, info3.getQuantity());
			ps.setString(5, info3.getAddress());
			ps.setInt(6,info3.getUserId());
			
			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);

		} catch (Exception e) {
			log.info("Exception in login records");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				log.info("Exception in login records 1");
			}
		}
		return false;
	
		
	}

	@Override
	public boolean viewMyStore(StockDetailsInfo info4) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "select * from stocksDetailsinfo";

			ps = con.prepareStatement(query);
			ps.setInt(1,info4.getProductId());
			ps.setString(2,info4.getProductName());
			ps.setInt(3,info4.getNumOfItems());
	
			
			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);

		} catch (Exception e) {
			log.info("Exception in login records");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				log.info("Exception in login records 1");
			}
		}
		return false;
	
		
	}

}
