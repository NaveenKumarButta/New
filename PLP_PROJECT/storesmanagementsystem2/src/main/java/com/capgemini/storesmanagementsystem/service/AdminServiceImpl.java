package com.capgemini.storesmanagementsystem.service;

import java.util.List;

import com.capgemini.storesmanagementsystem.dao.AdminDaoImpl;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public class AdminServiceImpl implements AdminService{
	 AdminDaoImpl dao =new AdminDaoImpl();

		@Override
		public boolean addManufacturer(UserDetailsInfo user) {
			
			return dao.addManufactur(user);
		}

		@Override
		public boolean updateManufacturer(String userId, UserDetailsInfo user) {
			
			return false;
		}

		@Override
		public boolean deleteManufacturer(String userId) {
			
			return false;
		}

		@Override
		public List<String> viewAllManufacturs() {
			
			return null;
		}

}
