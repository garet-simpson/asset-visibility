package com.itemtracer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.itemtracer.beans.AuthorityTypeBean;
import com.itemtracer.beans.ItemMovementBean;
import com.itemtracer.beans.ProjectBean;
import com.itemtracer.beans.ProjectUserSummaryBean;
import com.itemtracer.beans.ItemMovementBean;

import com.itemtracer.beans.UserBean;

public class ApplicationDao {
	
	private static List<ItemMovementBean> loadItemMovementBean(ResultSet set) throws SQLException{
		
		ItemMovementBean itemMovementBean = null;
		List<ItemMovementBean> itemMovementBeans = new ArrayList<>();
		
		while (set.next()) {
			
			itemMovementBean = new ItemMovementBean();
			itemMovementBean.setTimeStamp(set.getDate("time_Stamp"));
			itemMovementBean.setProjectName(set.getString("projectName"));
			itemMovementBean.setMovementType(set.getString("movementType"));
			itemMovementBean.setPartDescription(set.getString("partDescription"));
			itemMovementBean.setPartInstanceId(set.getString("partInstanceId"));
			itemMovementBean.setPartNumber(set.getString("partNumber"));
			itemMovementBean.setSerialNumber(set.getString("serialNumber"));
			itemMovementBean.setQuantityAssigned(set.getString("quantityAssigned"));
			itemMovementBean.setParentPartNumber(set.getString("parentPartNumber"));
			itemMovementBean.setParentSerialNumber(set.getString("parentSerialNumber"));
			itemMovementBean.setOriginLocationName(set.getString("originLocationName"));
			itemMovementBean.setDestinationLocationName(set.getString("destinationLocationName"));
			itemMovementBean.setStatusType(set.getString("statusType"));
			itemMovementBean.setOwnerName(set.getString("ownerName"));
			itemMovementBean.setNote(set.getString("note"));
			itemMovementBean.setAttachment(set.getString("attachment"));
			itemMovementBean.setAuthorUser(set.getString("authorUser"));
			itemMovementBeans.add(itemMovementBean);
		}
		
		return itemMovementBeans;
	}
	
	
	public List<ItemMovementBean> getUniquePartNumbers(String projectName, Connection connection){
		ItemMovementBean itemMovementBean = null;
		List<ItemMovementBean> itemMovementBeans = new ArrayList<>();
		
		try {
			String sql = "SELECT DISTINCT partDescription "+
						 "FROM all_movement "+
						 "WHERE projectName = ? "+
						 "ORDER BY partDescription ASC";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, projectName);
			
			//System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				itemMovementBean = new ItemMovementBean();
				itemMovementBean.setPartDescription(set.getString("partDescription"));
				
				itemMovementBeans.add(itemMovementBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return itemMovementBeans;
	}

	public List<ItemMovementBean> getSerialNumbersForPartNumber(String projectName,String partDescription, Connection connection){
		
		ItemMovementBean itemMovementBean =null;
		List<ItemMovementBean> itemMovementBeans = new ArrayList<>();
		
		try {
			String sql = "SELECT DISTINCT serialNumber "+
						 "FROM all_movement "+
					     "WHERE projectName = ? "+
						 "AND partDescription = ? "+
					     "ORDER BY serialNumber ASC";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, projectName);
			statement.setString(2, partDescription);
			
			//System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				itemMovementBean = new ItemMovementBean();
				itemMovementBean.setSerialNumber(set.getString("serialNumber"));
				itemMovementBeans.add(itemMovementBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return itemMovementBeans;
	}
	
	public List<ItemMovementBean> getMovementsFromPartNumberAndSerialNumber(String projectName,String partDescription,String serialNumber, Connection connection){
		
		ItemMovementBean itemMovementBean = null;
		List<ItemMovementBean> itemMovementBeans = new ArrayList<>();
		
		try {
			String sql = "SELECT * "+
						 "FROM all_movement "+
					     "WHERE projectName = ? "+
						 "AND partDescription = ? "+
						 "AND serialNumber = ? "+
						 "ORDER BY time_Stamp ASC";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, projectName);
			statement.setString(2, partDescription);
			statement.setString(3, serialNumber);
			
			//System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();

			itemMovementBeans = loadItemMovementBean(set);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return itemMovementBeans;
	}
	

	public List<ItemMovementBean> getUniqueLocations(String projectName, Connection connection){
		ItemMovementBean itemMovementBean =null;
		List<ItemMovementBean> itemMovementBeans = new ArrayList<>();
		
		try {
	
			 String sql = "SELECT DISTINCT destinationLocationName "+
						 "FROM all_movement "+
						 "WHERE projectName = ? " +
						 "AND destinationLocationName IS NOT NULL " +
						 "ORDER BY destinationLocationName ASC";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, projectName);
			//System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				itemMovementBean = new ItemMovementBean();
				itemMovementBean.setDestinationLocationName(set.getString("destinationLocationName"));
				
				itemMovementBeans.add(itemMovementBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return itemMovementBeans;
	}
	
	public List<ItemMovementBean> getMovementsFromLocation(String projectName,String location, Connection connection){
		
		ItemMovementBean itemMovementBean =null;
		List<ItemMovementBean> itemMovementBeans = new ArrayList<>();
		
		try {
	
			String sql = "SELECT * "+
						 "FROM last_movement "+
					     "WHERE projectName = ? "+
						 "AND destinationLocationName = ? "+
						 "ORDER BY partDescription ASC, serialNumber ASC" ;
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, projectName);
			statement.setString(2, location);
			
			//System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();

			itemMovementBeans = loadItemMovementBean(set);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return itemMovementBeans;
	}
	
public List<ItemMovementBean> getMovementFromPartDescriptionAndLocation(String projectName,String partDescription,String location, Connection connection){
		
		ItemMovementBean itemMovementBean =null;
		List<ItemMovementBean> itemMovementBeans = new ArrayList<>();
		
		try {
				
			String sql = "SELECT * "+
						 "FROM last_movement "+
						 "WHERE projectName = ? "+
						 "AND partDescription = ? "+
						 "AND destinationLocationName = ?" +
						 "ORDER BY serialNumber ASC";
						 
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, projectName);
			statement.setString(2, partDescription);
			statement.setString(3, location);
			
			//System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();

			itemMovementBeans = loadItemMovementBean(set);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return itemMovementBeans;
	}


public HashMap <String,Integer> getQuantityByPartDescription(String projectName, Connection connection){
	
	HashMap <String,Integer> partDescriptionCounter = new HashMap<>();
	
	try {


		String sql = "SELECT partDescription, Count(serialNumber) as totalQuantity "+
					 "FROM last_movement "+
				     "WHERE projectName = ? "+
					 "GROUP BY partDescription " +
					 "ORDER BY partDescription ASC";
					 
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, projectName);
	
		//System.out.println(statement.toString());
		ResultSet set = statement.executeQuery();

		while (set.next()) {
			partDescriptionCounter.put(set.getString("partDescription"), set.getInt("totalQuantity"));

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return partDescriptionCounter;
}

public HashMap <ItemMovementBean,Integer> getQuantityByPartNumber(String projectName, Connection connection){
	
	HashMap <ItemMovementBean,Integer> partNumberCounter = new HashMap<>();
	ItemMovementBean itemMovementBean =null;
	List<ItemMovementBean> itemMovementBeans = new ArrayList<>();
	
	try {
		
		String sql = "SELECT partDescription, partNumber, count(serialNumber) as totalQuantity "+
					 "FROM last_movement "+
				     "WHERE projectName = ? "+
					 "GROUP BY partNumber "+
				     "ORDER BY partDescription ASC, partNumber ASC";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, projectName);
	
		//System.out.println(statement.toString());
		ResultSet set = statement.executeQuery();

		while (set.next()) {
			itemMovementBean = new ItemMovementBean();
			itemMovementBean.setPartDescription(set.getString("partDescription"));
			itemMovementBean.setPartNumber(set.getString("partNumber"));
			partNumberCounter.put(itemMovementBean, set.getInt("totalQuantity"));

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return partNumberCounter;
}
	
	public int registerUser(UserBean user, Connection connection) {
		int rowsAffected = 0;
		int userId = 0;
		int projectId = 1;
		int projectAuthorityId = 2;
		
		try {
		
			connection.setAutoCommit(false);
			// write the insert query
			String insertQuery = "INSERT INTO user_info (user_name, password, first_name, last_name, email, author_user_id) " +
										"VALUES(?,?,?,?,?,?)";

			// set parameters with PreparedStatement
			PreparedStatement statement = connection.prepareStatement(insertQuery, 
											Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getEmail());
			statement.setInt(6, user.getAuthorUserId());
			//System.out.println(statement.toString());
			// execute the statement
			rowsAffected = statement.executeUpdate();
			
			try(ResultSet generatedKeys = statement.getGeneratedKeys()){
				if(generatedKeys.next()) {
					userId = generatedKeys.getInt(1);
				}
			} catch(Exception exception) {
				exception.printStackTrace();
			}
			

			insertQuery = "INSERT INTO project_user (user_id, project_id, project_authority_id, author_user_id)" +
					"values(?,?,?,?)";
			statement = connection.prepareStatement(insertQuery);
			statement.setInt(1, userId);
			statement.setInt(2, projectId);
			statement.setInt(3, projectAuthorityId);
			statement.setInt(4, user.getAuthorUserId());
			
			rowsAffected = statement.executeUpdate();
			//System.out.println(statement.toString());
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException exception) {
			
			try {
		        //rollback the transaction in case of a problem
				exception.printStackTrace();
				connection.rollback();
				connection.setAutoCommit(true);
		      } catch (SQLException sqle) {
		    	  
		      }
		}
		return rowsAffected;
	}

	public UserBean validateUser(String username, String password, Connection connection) {
		UserBean user = null;
		try {

			// write the select query
			String sql = "SELECT * FROM user_info where user_name=? and password=?";

			// set parameters with PreparedStatement
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);

			// execute the statement and check whether user exists

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				user = new UserBean();
				user.setUserId(set.getInt("id"));
				user.setUsername(set.getString("user_name"));
				user.setFirstName(set.getString("first_name"));
				user.setLastName(set.getString("last_name"));
				user.setEmail(set.getString("email"));
				user.setTimeStamp(set.getDate("time_stamp"));
					
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return user;
	}

	public UserBean getProfileDetails(String username, Connection connection) {
		UserBean user = null;
		try {

			// write select query to get profile details
			String sql = "SELECT * FROM user_info WHERE user_name=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);

			// execute query, get resultset and return User info
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				user = new UserBean();
				user.setUsername(set.getString("user_name"));
				user.setFirstName(set.getString("first_name"));
				user.setLastName(set.getString("last_name"));
				user.setEmail(set.getString("email"));
				user.setTimeStamp(set.getDate("time_stamp"));
			}

		}

		catch (SQLException exception) {
			exception.printStackTrace();
		}
		return user;
	}
	
	
	public UserBean getUserBean(String username, Connection connection) {
		UserBean user = null;
		try {

			// write select query to get profile details
			String sql = "SELECT * FROM user_info WHERE user_name=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);

			// execute query, get resultset and return User info
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				user = new UserBean();
				user.setUserId(set.getInt("id"));
				user.setUsername(set.getString("user_name"));
				user.setFirstName(set.getString("first_name"));
				user.setLastName(set.getString("last_name"));
				user.setEmail(set.getString("email"));
				user.setTimeStamp(set.getDate("time_stamp"));
			}

		}

		catch (SQLException exception) {
			exception.printStackTrace();
		}
		return user;
	}

	public List<String> getUniqueProjects(Connection connection){
	
		List<String> projectNames = new ArrayList<>();

		
		try {
	
			 String sql = "SELECT * "+
						 "FROM project "+
						 "ORDER BY project_name ASC";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			//System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();
			
			while (set.next()) {
				
				projectNames.add(set.getString("project_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return projectNames;
	}
	
	public List<String> getUserNamesNonAdmin(String userName, Connection connection){
		
		List<String> userNames = new ArrayList<>();

		
		try {
	
			 String sql = "SELECT user_name "+
						 "FROM user_info "+ 
						 "WHERE user_name NOT IN (?, ?) "+
						 "ORDER BY user_name ASC";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "admin");
			statement.setString(2, userName);
			//System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();
			
			while (set.next()) {
				
				userNames.add(set.getString("user_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return userNames;
	}
	
	
	public List<String> getUserProjects(String userName, Connection connection){
		
		List<String> projectNames = new ArrayList<>();

		
		try {
	
			 String sql = "SELECT * "+
						 "FROM project_user_summary "+
						 "WHERE userName = ? "+
						 "ORDER BY projectName ASC";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			//System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();
			
			while (set.next()) {
				
				projectNames.add(set.getString("projectName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return projectNames;
	}
	
	public List<ProjectUserSummaryBean> getProjectUserSummaryBean(String projectName, Connection connection){
		
		ProjectUserSummaryBean projectUserSummaryBean = null;
		List<ProjectUserSummaryBean> projectUserSummaryBeans = new ArrayList<>();
		
		try {
	
			 String sql = "SELECT * "+
						 "FROM project_user_summary "+
						 "WHERE projectName = ? " +
						 "ORDER BY projectName ASC";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, projectName);
			System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();
			
			while (set.next()) {
				projectUserSummaryBean = new ProjectUserSummaryBean();
				projectUserSummaryBean.setUserName(set.getString("userName"));
				projectUserSummaryBean.setFirstName(set.getString("firstName"));
				projectUserSummaryBean.setLastName(set.getString("lastName"));
				projectUserSummaryBean.setProjectName(set.getString("projectName"));
				projectUserSummaryBean.setProjectDescription(set.getString("projectDescription"));
				projectUserSummaryBean.setProjectAuthority(set.getString("projectAuthority"));
				projectUserSummaryBean.setAuthorityDescription(set.getString("authorityDescription"));
				projectUserSummaryBeans.add(projectUserSummaryBean);
			}
			
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return projectUserSummaryBeans;
		
	}
	
public ProjectUserSummaryBean getProjectUserSummaryBeanForUserProject(String projectName,String userName, Connection connection){
		
		ProjectUserSummaryBean projectUserSummaryBean = null;
		
		try {
	
			 String sql = "SELECT * "+
						 "FROM project_user_summary "+
						 "WHERE projectName = ? " +
						 "AND userName = ? " +
						 "ORDER BY projectName ASC";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, projectName);
			statement.setString(2, userName);
			System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();
			
			while (set.next()) {
				projectUserSummaryBean = new ProjectUserSummaryBean();
				projectUserSummaryBean.setUserName(set.getString("userName"));
				projectUserSummaryBean.setFirstName(set.getString("firstName"));
				projectUserSummaryBean.setLastName(set.getString("lastName"));
				projectUserSummaryBean.setProjectName(set.getString("projectName"));
				projectUserSummaryBean.setProjectDescription(set.getString("projectDescription"));
				projectUserSummaryBean.setProjectAuthority(set.getString("projectAuthority"));
				projectUserSummaryBean.setAuthorityDescription(set.getString("authorityDescription"));
			}
			
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return projectUserSummaryBean;
		
	}
	
public String getUserProjectAuthority(String projectName, String userName, Connection connection){
		
		String userProjectAuthority  = null;
		
		try {
	
			 String sql = "SELECT * "+
						 "FROM project_user_summary "+
						 "WHERE projectName = ? " +
						 "AND userName = ? " +
						 "ORDER BY projectName ASC";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, projectName);
			statement.setString(2, userName);
			System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();
			
			while (set.next()) {
				userProjectAuthority = set.getString("projectAuthority");
			}
			
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return userProjectAuthority;
		
	}

public AuthorityTypeBean getAuthorityTypeBean(String userProjectAuthority, Connection connection){
		
	AuthorityTypeBean authorityTypeBean = new AuthorityTypeBean();
	try {

		 String sql = "SELECT * "+
					 "FROM project_user_authority_type "+
					 "WHERE authority_type = ? ";

		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userProjectAuthority);

		System.out.println(statement.toString());
		ResultSet set = statement.executeQuery();
		
		while (set.next()) {
			authorityTypeBean.setAuthorityTypeId(set.getInt("id"));
			authorityTypeBean.setAuthorityType(set.getString("authority_type"));
			authorityTypeBean.setAuthorityDescription(set.getString("authority_description"));
			authorityTypeBean.setTimeStamp(set.getDate("time_stamp"));
			authorityTypeBean.setAuthorUser(set.getInt("author_user_id"));
		}
		


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return authorityTypeBean;
	
}

public int updateUserProjectAuthority(int projectId, int userId,  int projectAuthorityId, int authorUserId, Connection connection){
	
	int rowsAffected = 0;
	
	try {

		String sql = "UPDATE project_user "+
					 "SET project_authority_id = ?, author_user_id = ?  "+
					 "WHERE user_id = ? " +
					 "AND project_id = ? ";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, projectAuthorityId);
		statement.setInt(2, authorUserId);
		statement.setInt(3, userId);
		statement.setInt(4, projectId);
		System.out.println(statement.toString());
		rowsAffected = statement.executeUpdate();
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return rowsAffected;
	
}


public int addUserProjectAuthority(int projectId, int userId,  int projectAuthorityId, int authorUserId, Connection connection){
	
	int rowsAffected = 0;
	
	try {

		String sql = "INSERT INTO project_user "+
					 "(user_id, project_id, project_authority_id, author_user_id) "+
					 "VALUES (?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		statement.setInt(2, projectId);
		statement.setInt(3, projectAuthorityId);
		statement.setInt(4, authorUserId);
		System.out.println(statement.toString());
		rowsAffected = statement.executeUpdate();
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return rowsAffected;
	
}


public int removeUserProjectAuthority(int projectId, int userId, Connection connection){
	
	int rowsAffected = 0;
	
	try {

		String sql = "DELETE FROM project_user "+
					 "WHERE user_id = ? " +
					 "AND project_id = ? ";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		statement.setInt(2, projectId);
		System.out.println(statement.toString());
		rowsAffected = statement.executeUpdate();
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return rowsAffected;
	
}

public List<String> getAuthorityTypes(Connection connection){
	
	List<String> authorityTypes = new ArrayList<>();
	
	try {

		 String sql = "SELECT authority_type "+
					 "FROM project_user_authority_type " +
					 "ORDER BY id ASC";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		System.out.println(statement.toString());
		ResultSet set = statement.executeQuery();
		
		while (set.next()) {
			authorityTypes.add(set.getString("authority_type"));
		}
		


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return authorityTypes;
	
}
		
	public ProjectBean getProjectBean(String projectName, Connection connection){
			
		ProjectBean projectBean = null;
		
		try {
	
			 String sql = "SELECT * "+
						 "FROM project "+
						 "WHERE project_name = ? " +
						 "ORDER BY project_name ASC";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, projectName);
			System.out.println(statement.toString());
			ResultSet set = statement.executeQuery();
			
			while (set.next()) {
				projectBean = new ProjectBean();
				projectBean.setProjectId(set.getInt("id"));
				projectBean.setProjectName(set.getString("project_name"));
				projectBean.setProjectDescription(set.getString("project_description"));
				projectBean.setTimeStamp(set.getDate("time_stamp"));
				projectBean.setAuthorUserId(set.getInt("author_user_id"));
			}
				
		

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		return projectBean;
		
	}
	
	
	public int addProject(ProjectBean project, UserBean user, Connection connection){
		
		int rowsAffected = 0;
		int projectId = 0;
		int projectAuthorityId = 1;
		
		try {
			
			connection.setAutoCommit(false);
			// write the insert query
			String insertQuery = "INSERT INTO project (project_name, project_description, author_user_id) " +
										"VALUES(?,?,?)";

			// set parameters with PreparedStatement
			PreparedStatement statement = connection.prepareStatement(insertQuery, 
											Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, project.getProjectName());
			statement.setString(2, project.getProjectDescription());
			statement.setInt(3, project.getAuthorUserId());
			
			//System.out.println(statement.toString());
			// execute the statement
			rowsAffected = statement.executeUpdate();
			
			try(ResultSet generatedKeys = statement.getGeneratedKeys()){
				if(generatedKeys.next()) {
					projectId = generatedKeys.getInt(1);
				}
			} catch(Exception exception) {
				exception.printStackTrace();
			}
			
			
		
			insertQuery = "INSERT INTO project_user (user_id, project_id, project_authority_id, author_user_id) " +
					"VALUES(?,?,?,?)";

			// set parameters with PreparedStatement
			statement = connection.prepareStatement(insertQuery, 
									Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, user.getUserId());
			statement.setInt(2, projectId);
			statement.setInt(3, projectAuthorityId);
			statement.setInt(4, project.getAuthorUserId());
			
			//System.out.println(statement.toString());
			// execute the statement
			rowsAffected = statement.executeUpdate();
			
			if(!user.getUserName().equals("admin")) {
				
				insertQuery = "INSERT INTO project_user (user_id, project_id, project_authority_id, author_user_id) " +
						"VALUES(?,?,?,?)";

				// set parameters with PreparedStatement
				statement = connection.prepareStatement(insertQuery, 
										Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, 1);
				statement.setInt(2, projectId);
				statement.setInt(3, projectAuthorityId);
				statement.setInt(4, project.getAuthorUserId());
				
				//System.out.println(statement.toString());
				// execute the statement
				rowsAffected = statement.executeUpdate();
			
			}
						
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException exception) {
			
			try {
		        //rollback the transaction in case of a problem
				exception.printStackTrace();
				connection.rollback();
				connection.setAutoCommit(true);
		      } catch (SQLException sqle) {
		    	  
		      }
		
		
		}
		return rowsAffected;
		
		
	}
	
}

