package book.dao;

	import java.security.*;
	import java.sql.*;
	import java.util.*;
	import book.connection.ConnectionManager;
	import book.model.Admin;
	
public class AdminDAO{	
		private static Connection con = null;
		private static ResultSet rs = null; 
		private static PreparedStatement ps=null;
		private static Statement stmt=null;
		private static String ADFNAME,ADLNAME,ADCONTACT,ADGENDER,ADPASSWORD,sql;
		private static boolean valid;
		private static int ADMINID;


	
		//login
		public static Admin login(Admin bean)throws NoSuchAlgorithmException{
			//get student id and password
			ADMINID=bean.getADMINID();
			ADPASSWORD=bean.getADPASSWORD();
			
			//convert the password to MD5
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(ADPASSWORD.getBytes());
			
			byte byteData[] = md.digest();
			
			//convert the byte to hex format
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < byteData.length; i++) {
						sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
					}

					try {
						//call getConnection() method 
						con = ConnectionManager.getConnection();
						
						//3. create statement
						sql="SELECT * FROM admin WHERE adminID='" + ADMINID + "'AND adpassword='" + ADPASSWORD + "'";
						stmt=con.createStatement();
						
						//4. execute query
						rs=stmt.executeQuery(sql);
						
						//if user exists set the isValid variable to true
						if(rs.next()) {
							bean.setADMINID(rs.getInt("ADMINID"));
							bean.setADPASSWORD(rs.getString("ADPASSWORD"));
							bean.setADFNAME(rs.getString("ADFNAME"));
							bean.setValid(true);
						}
						//if user does not exist set the isValid variable to false
						else {
							bean.setValid(false);
						}
						
						//5.close connection
						con.close();
					}catch(Exception e) {
						
						e.printStackTrace();
					}
					
					return bean;		
		}
		
		public static Admin getUser(Admin bean) { 
			
			ADMINID=bean.getADMINID();
			
					try {
				//call getConnection() method
				con = ConnectionManager.getConnection();

				//create statement
				ps = con.prepareStatement("SELECT * FROM admin WHERE adminID=?");
				ps.setInt(1, ADMINID);
				
				//execute query
				rs = ps.executeQuery();
				
				if(rs.next()) {
					bean.setADMINID(rs.getInt("ADMINID"));
					bean.setADPASSWORD(rs.getString("ADPASSWORD"));
					bean.setValid(true);
				}
				else {
					bean.setValid(false);
				}
				//close connection
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return bean; 
		} 
		
		
		public static Admin getadminByADMINID(int ADMINID) {
			Admin admin = new Admin();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				
				//3. create statement  
				sql = "SELECT * FROM admin WHERE adminID='" + ADMINID + "'";
				stmt = con.createStatement();
				
				//execute statement
				rs = stmt.executeQuery(sql);

				if (rs.next()) {	
					admin.setADMINID(ADMINID);
					admin.setADPASSWORD(ADPASSWORD);
	                admin.setADMINID(rs.getInt("ADMINID"));
	                admin.setADFNAME(rs.getString("ADFNAME"));
	                admin.setADLNAME(rs.getString("ADLNAME"));
	                admin.setADCONTACT(rs.getString("ADCONTACT"));
	                admin.setADGENDER(rs.getString("ADGENDER"));
	                admin.setADPASSWORD(rs.getString("ADPASSWORD"));
					
				}
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return admin;
		}
		
		public static List<Admin> getAllAdmins() {
	        List<Admin> admins = new ArrayList<>();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	            con = ConnectionManager.getConnection();
	            ps = con.prepareStatement("SELECT * FROM admin");
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                Admin ad = new Admin();
	                ad.setADMINID(rs.getInt("ADMINID"));
	                ad.setADFNAME(rs.getString("ADFNAME"));
	                ad.setADLNAME(rs.getString("ADLNAME"));
	                ad.setADCONTACT(rs.getString("ADCONTACT"));
	                ad.setADGENDER(rs.getString("ADGENDER"));
	                ad.setADPASSWORD(rs.getString("ADPASSWORD"));

	                admins.add(ad);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (ps != null) {
	                    ps.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    return admins;

	        
	    }
		//register Admin
	    public void addAdmin(Admin bean)throws NoSuchAlgorithmException  {
	      ADMINID=bean.getADMINID();
	      ADFNAME=bean.getADFNAME();
	      ADLNAME=bean.getADLNAME();
	      ADCONTACT=bean.getADCONTACT();
	      ADGENDER=bean.getADGENDER();
	      ADPASSWORD=bean.getADPASSWORD();
	      
	      MessageDigest md = MessageDigest.getInstance("MD5");
	      md.update(ADPASSWORD.getBytes());
	      byte byteData[] = md.digest();

	      //convert the byte to hex format
	      StringBuffer sb = new StringBuffer();
	      for (int i = 0; i < byteData.length; i++) {
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	      }
	      
	      try {
	        
	        con=ConnectionManager.getConnection();
	        
	        sql="INSERT INTO admin(adminID,adfname,adlname,adcontact,adgender,adpassword)VALUES(?,?,?,?,?,?)";
	        PreparedStatement adminStatement=con.prepareStatement(sql);
	        adminStatement.setInt(1, ADMINID);
	        adminStatement.setString(2, ADFNAME);
	        adminStatement.setString(3, ADLNAME);
	        adminStatement.setString(4, ADCONTACT);
	        adminStatement.setString(5, ADGENDER);
	        adminStatement.setString(6, ADPASSWORD);
	        
	        adminStatement.executeUpdate();
	        System.out.println("Susccesfully inserted Admin Data");
	        con.close();
	      }catch(Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error inserting admin data", e);
	      }
	    }
	    
	    
	    public void updateAdmin(Admin bean)throws NoSuchAlgorithmException  {
		      ADMINID=bean.getADMINID();
		      ADFNAME=bean.getADFNAME();
		      ADLNAME=bean.getADLNAME();
		      ADCONTACT=bean.getADCONTACT();
		      ADGENDER=bean.getADGENDER();
		      ADPASSWORD=bean.getADPASSWORD();
		      
		      MessageDigest md = MessageDigest.getInstance("MD5");
		      md.update(ADPASSWORD.getBytes());
		      byte byteData[] = md.digest();

		      //convert the byte to hex format
		      StringBuffer sb = new StringBuffer();
		      for (int i = 0; i < byteData.length; i++) {
		        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		      }
		      
		      try {
		        
		        con=ConnectionManager.getConnection();
		        
		        sql="UPDATE admin SET adfname=?,adlname=?,adcontact=?,adgender=?,adpassword=? WHERE adminID=?";
		        PreparedStatement adminStatement=con.prepareStatement(sql);
		        
		        adminStatement.setString(1, ADFNAME);
		        adminStatement.setString(2, ADLNAME);
		        adminStatement.setString(3, ADCONTACT);
		        adminStatement.setString(4, ADGENDER);
		        adminStatement.setString(5, ADPASSWORD);
		        adminStatement.setInt(6, ADMINID);
		        
		        adminStatement.executeUpdate();
		        System.out.println("Susccesfully updated Admin Data");
		        con.close();
		      }catch(Exception e) {
		        e.printStackTrace();
		      }
		    }
		
}
