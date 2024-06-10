package book.dao;

import java.security.*;
import java.sql.*;
import java.util.*;
import book.connection.ConnectionManager;
import book.model.NonResidentStudent;
import book.model.ResidentStudent;
import book.model.Student;




public class StudentDAO {

	private static Connection con = null;
	private static ResultSet rs = null; 
	private static PreparedStatement ps=null;
	private static Statement stmt=null;
	private static String spassword,sql,sfname,slname,sgroup,scoursecode,sfaculty,scontact,sgender,stype,room,block,address,postcode;
	private static int studentID;

	
	//login
	public static Student login(Student bean)throws NoSuchAlgorithmException{
		//get student id and password
		studentID=bean.getStudentID();
		spassword=bean.getSpassword();
		
		//convert the password to MD5
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(spassword.getBytes());
		
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
					sql="SELECT * FROM student WHERE STUDENTID='" + studentID + "'AND spassword='" + spassword + "'";
					stmt=con.createStatement();
					
					//4. execute query
					rs=stmt.executeQuery(sql);
					
					//if user exists set the isValid variable to true
					if(rs.next()) {
						bean.setStudentID(rs.getInt("studentID"));
						bean.setSpassword(rs.getString("spassword"));
						bean.setStype(rs.getString("stype"));
						bean.setSfname(rs.getString("sfname"));
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
	
	//add new user(register)
	//complete addstudent()method
	public void addResidentStudent (ResidentStudent bean) throws NoSuchAlgorithmException {
		//get studentid
		studentID=bean.getStudentID();
		sfname=bean.getSfname();
		slname=bean.getSlname();
		sgroup=bean.getSgroup();
		scoursecode=bean.getScoursecode();
		sfaculty=bean.getSfaculty();
		scontact=bean.getScontact();
		sgender=bean.getSgender();
		spassword=bean.getSpassword();
		stype=bean.getStype();
		room=bean.getRoom();
		block=bean.getBlock();
		
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(spassword.getBytes());
		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			// Insert data into the 'student' table
	        String studentQuery = "INSERT INTO student (studentID, sfname, slname, sgroup, scoursecode, sfaculty, scontact, sgender, spassword,stype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	        PreparedStatement studentStatement = con.prepareStatement(studentQuery);
	        studentStatement.setInt(1,studentID);
	        studentStatement.setString(2,sfname);
	        studentStatement.setString(3,slname);
	        studentStatement.setString(4,sgroup);
	        studentStatement.setString(5,scoursecode);
	        studentStatement.setString(6,sfaculty);
	        studentStatement.setString(7,scontact);
	        studentStatement.setString(8,sgender);
	        studentStatement.setString(9,spassword);
	        studentStatement.setString(10,stype);

	        studentStatement.executeUpdate();
	        
	     // Insert data into the 'nonresidentstudent' table
	        String ResidentQuery = "INSERT INTO residentstudent (studentID, roomnum, block) VALUES (?, ?, ?)";
	        PreparedStatement ResidentStatement = con.prepareStatement(ResidentQuery);
	        ResidentStatement.setInt(1, studentID);
	        ResidentStatement.setString(2, room);
	        ResidentStatement.setString(3, block);
	        
	        ResidentStatement.executeUpdate();
	        
			//execute statement
			ps.executeUpdate();
			System.out.println("Susccesfully inserted");

			
			//close connection
			con.close();	
			
		}catch(Exception e) {
			e.printStackTrace();	
			throw new RuntimeException("Error inserting student data", e);
		}
	}
	public void updateResidentStudent(ResidentStudent bean) throws NoSuchAlgorithmException {
	    // Get the student attributes
	    studentID = bean.getStudentID();
	    sfname = bean.getSfname();
	    slname = bean.getSlname();
	    sgroup = bean.getSgroup();
	    scoursecode = bean.getScoursecode();
	    sfaculty = bean.getSfaculty();
	    scontact = bean.getScontact();
	    sgender = bean.getSgender();
	    spassword = bean.getSpassword();
	    stype = bean.getStype();
	    room = bean.getRoom();
	    block = bean.getBlock();

	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(spassword.getBytes());
	    byte byteData[] = md.digest();

	    // Convert the byte to hex format
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < byteData.length; i++) {
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	    }

	    try {
	        // Call getConnection() method
	        con = ConnectionManager.getConnection();

	        // Update data in the 'student' table
	        String studentQuery = "UPDATE student SET sfname=?, slname=?, sgroup=?, scoursecode=?, sfaculty=?, scontact=?, sgender=?, spassword=?, stype=? WHERE studentID=?";
	        PreparedStatement studentStatement = con.prepareStatement(studentQuery);
	        studentStatement.setString(1, sfname);
	        studentStatement.setString(2, slname);
	        studentStatement.setString(3, sgroup);
	        studentStatement.setString(4, scoursecode);
	        studentStatement.setString(5, sfaculty);
	        studentStatement.setString(6, scontact);
	        studentStatement.setString(7, sgender);
	        studentStatement.setString(8, spassword);
	        studentStatement.setString(9, stype);
	        studentStatement.setInt(10, studentID);

	        studentStatement.executeUpdate();

	        // Update data in the 'residentstudent' table
	        String residentQuery = "UPDATE residentstudent SET roomnum=?, block=? WHERE studentID=?";
	        PreparedStatement residentStatement = con.prepareStatement(residentQuery);
	        residentStatement.setString(1, room);
	        residentStatement.setString(2, block);
	        residentStatement.setInt(3, studentID);

	        residentStatement.executeUpdate();

	        // Close the statements and connection
	        studentStatement.close();
	        residentStatement.close();
	        con.close();

	        System.out.println("Successfully Updated");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void addNonResidentStudent (NonResidentStudent bean) throws NoSuchAlgorithmException {
		//get studentid
		studentID=bean.getStudentID();
		sfname=bean.getSfname();
		slname=bean.getSlname();
		sgroup=bean.getSgroup();
		scoursecode=bean.getScoursecode();
		sfaculty=bean.getSfaculty();
		scontact=bean.getScontact();
		sgender=bean.getSgender();
		spassword=bean.getSpassword();
		stype=bean.getStype();
		address=bean.getAddress();
		postcode=bean.getPostcode();
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(spassword.getBytes());
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
			// Insert data into the 'student' table
	        String studentQuery = "INSERT INTO student (studentID, sfname, slname, sgroup, scoursecode, sfaculty, scontact, sgender, spassword,stype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement studentStatement = con.prepareStatement(studentQuery);
	        studentStatement.setInt(1,studentID);
	        studentStatement.setString(2,sfname);
	        studentStatement.setString(3,slname);
	        studentStatement.setString(4,sgroup);
	        studentStatement.setString(5,scoursecode);
	        studentStatement.setString(6,sfaculty);
	        studentStatement.setString(7,scontact);
	        studentStatement.setString(8,sgender);
	        studentStatement.setString(9,spassword);
	        studentStatement.setString(10,stype);
	        
	        studentStatement.executeUpdate();
	        
	        // Insert data into the 'nonresidentstudent' table
	        String nonResidentQuery = "INSERT INTO nonresidentstudent (studentID, address, postcode) VALUES (?, ?, ?)";
	        PreparedStatement nonResidentStatement = con.prepareStatement(nonResidentQuery);
	        nonResidentStatement.setInt(1, studentID);
	        nonResidentStatement.setString(2, address);
	        nonResidentStatement.setString(3, postcode);
	        
	        nonResidentStatement.executeUpdate();
	        
	        con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error inserting student data", e);
		}
	}
	public void updateNonResidentStudent (NonResidentStudent bean) throws NoSuchAlgorithmException {
		//get studentid
		studentID=bean.getStudentID();
		sfname=bean.getSfname();
		slname=bean.getSlname();
		sgroup=bean.getSgroup();
		scoursecode=bean.getScoursecode();
		sfaculty=bean.getSfaculty();
		scontact=bean.getScontact();
		sgender=bean.getSgender();
		spassword=bean.getSpassword();
		stype=bean.getStype();
		address=bean.getAddress();
		postcode=bean.getPostcode();
		
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(spassword.getBytes());
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
			// Insert data into the 'student' table
	        String studentQuery = "UPDATE student SET sfname=?, slname=?, sgroup=?, scoursecode=?, sfaculty=?, scontact=?, sgender=?, spassword=? stype=? WHERE studentID=?";
	        PreparedStatement studentStatement = con.prepareStatement(studentQuery);
	        studentStatement.setString(1,sfname);
	        studentStatement.setString(2,slname);
	        studentStatement.setString(3,sgroup);
	        studentStatement.setString(4,scoursecode);
	        studentStatement.setString(5,sfaculty);
	        studentStatement.setString(6,scontact);
	        studentStatement.setString(7,sgender);
	        studentStatement.setString(8,spassword);
	        studentStatement.setString(9, stype);
	        studentStatement.setInt(10,studentID);

	        
	        studentStatement.executeUpdate();
	        
	        // Insert data into the 'nonresidentstudent' table
	        String nonResidentQuery = "UPDATE nonresidentstudent SET address=?, postcode=? WHERE studentID=?";
	        PreparedStatement nonResidentStatement = con.prepareStatement(nonResidentQuery);
	        nonResidentStatement.setString(1, address);
	        nonResidentStatement.setString(2, postcode);
	        nonResidentStatement.setInt(3, studentID);

	        
	        nonResidentStatement.executeUpdate();
	        
	        con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
	public static Student getStudentById(int studentID) {
	    Student student = null;

	    try {
	        con = ConnectionManager.getConnection();

	        // Create the query to retrieve the student details from the student table
	        String query = "SELECT studentID, sfname, slname, sgroup, scoursecode, sfaculty, scontact, sgender, spassword, stype FROM student WHERE studentID=?";
	        PreparedStatement statement = con.prepareStatement(query);
	        statement.setInt(1, studentID);

	        ResultSet rs = statement.executeQuery();

	        if (rs.next()) {
	            String studentType = rs.getString("stype");

	            if (studentType.equals("resident")) {
	                // Fetch additional data specific to ResidentStudent from the resident table
	                String residentQuery = "SELECT roomnum, block FROM residentstudent WHERE studentID=?";
	                PreparedStatement residentStatement = con.prepareStatement(residentQuery);
	                residentStatement.setInt(1, studentID);
	                ResultSet residentRs = residentStatement.executeQuery();

	                if (residentRs.next()) {
	                    // Create and populate a ResidentStudent object
	                    ResidentStudent residentStudent = new ResidentStudent();
	                    residentStudent.setStudentID(rs.getInt("studentID"));
	                    residentStudent.setSfname(rs.getString("sfname"));
	                    residentStudent.setSlname(rs.getString("slname"));
	                    residentStudent.setSgroup(rs.getString("sgroup"));
	                    residentStudent.setScoursecode(rs.getString("scoursecode"));
	                    residentStudent.setSfaculty(rs.getString("sfaculty"));
	                    residentStudent.setScontact(rs.getString("scontact"));
	                    residentStudent.setSgender(rs.getString("sgender"));
	                    residentStudent.setSpassword(rs.getString("spassword"));
	                    residentStudent.setRoom(residentRs.getString("roomnum"));
	                    residentStudent.setBlock(residentRs.getString("block"));

	                    student = residentStudent;
	                }
	                residentRs.close();
	                residentStatement.close();
	            } 
	            
	            else if (studentType.equals("nonresident")){
	                // Fetch additional data specific to NonResidentStudent from the nonresident table
	                String nonResidentQuery = "SELECT address, postcode FROM nonresidentstudent WHERE studentID=?";
	                PreparedStatement nonResidentStatement = con.prepareStatement(nonResidentQuery);
	                nonResidentStatement.setInt(1, studentID);
	                ResultSet nonResidentRs = nonResidentStatement.executeQuery();

	                if (nonResidentRs.next()) {
	                    // Create and populate a NonResidentStudent object
	                    NonResidentStudent nonResidentStudent = new NonResidentStudent();
	                    nonResidentStudent.setStudentID(rs.getInt("studentID"));
	                    nonResidentStudent.setSfname(rs.getString("sfname"));
	                    nonResidentStudent.setSlname(rs.getString("slname"));
	                    nonResidentStudent.setSgroup(rs.getString("sgroup"));
	                    nonResidentStudent.setScoursecode(rs.getString("scoursecode"));
	                    nonResidentStudent.setSfaculty(rs.getString("sfaculty"));
	                    nonResidentStudent.setScontact(rs.getString("scontact"));
	                    nonResidentStudent.setSgender(rs.getString("sgender"));
	                    nonResidentStudent.setSpassword(rs.getString("spassword"));
	                    nonResidentStudent.setAddress(nonResidentRs.getString("address"));
	                    nonResidentStudent.setPostcode(nonResidentRs.getString("postcode"));

	                    student = nonResidentStudent;
	                }
	                nonResidentRs.close();
	                nonResidentStatement.close();
	            }
	        }

	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return student;
	}

	
	public static Student getStudent(Student bean)  {   
		//get email
		studentID = bean.getStudentID();
		
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			sql = "SELECT * FROM user WHERE studentID='" + studentID + "'";
			stmt = con.createStatement();
			
			//execute statement
			rs = stmt.executeQuery(sql);

			// if user exists set the isValid variable to true
			if (rs.next()) {
				bean.setStudentID(rs.getInt("studentID"));
				bean.setSpassword(rs.getString("spassword"));
				bean.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else{
				bean.setValid(false);
			}
			//5. close connection
			con.close();	
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return bean;
	}
	public static List<Student> getAllStudent() {
	    List<Student> students = new ArrayList<>();

	    try {
	        con = ConnectionManager.getConnection();
	        // Create the SQL query to fetch all student records
	        sql = "SELECT * FROM student";

	        stmt = con.createStatement();
	        rs = stmt.executeQuery(sql);

	        while (rs.next()) {
	            int studentID = rs.getInt("studentID");
	            String sfname = rs.getString("sfname");
	            String slname = rs.getString("slname");
	            String sgroup = rs.getString("sgroup");
	            String scoursecode = rs.getString("scoursecode");
	            String sfaculty = rs.getString("sfaculty");
	            String scontact = rs.getString("scontact");
	            String sgender = rs.getString("sgender");
	            String spassword = rs.getString("spassword");
	            String studentType = rs.getString("stype");

	            if ("resident".equalsIgnoreCase(studentType)) {
	                String room = rs.getString("roomnum");
	                String block = rs.getString("block");
	                ResidentStudent residentStudent = new ResidentStudent(studentID, sfname, slname, sgroup,scoursecode, sfaculty, scontact, sgender, spassword,stype,room, block);
	                students.add(residentStudent);
	            } else if ("nonresident".equalsIgnoreCase(studentType)) {
	                String address = rs.getString("address");
	                String postcode = rs.getString("postcode");
	                NonResidentStudent nonResidentStudent = new NonResidentStudent(studentID, sfname, slname, sgroup,
	                        scoursecode, sfaculty, scontact, sgender, spassword,stype, address, postcode);
	                students.add(nonResidentStudent);
	            } else {
	                // For other student types, create a regular Student object
	                Student student = new Student(studentID, sfname, slname, sgroup, scoursecode, sfaculty, scontact,
	                        sgender,spassword,stype);
	                students.add(student);
	            }
	        }

	        // Close the resources
	        rs.close();
	        stmt.close();
	        con.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return students;
	}



}

