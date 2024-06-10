package book.model;

public class Student {
	private int studentID;
	private String sfname;
	private String slname;
	private String sgroup;
	private String scoursecode;
	private String sfaculty;
	private String scontact;
	private String sgender;
	private String spassword;
	private String stype;
	private boolean valid;
	
	// Default Constructor
    public Student() {
    }

    // Normal Constructor
    public Student(int studentID, String sfname, String slname, String sgroup, String scoursecode, String sfaculty,
            String scontact, String sgender, String spassword, String stype) {
        this.studentID = studentID;
        this.sfname = sfname;
        this.slname = slname;
        this.sgroup = sgroup;
        this.scoursecode = scoursecode;
        this.sfaculty = sfaculty;
        this.scontact = scontact;
        this.sgender = sgender;
        this.spassword = spassword;
        this.stype= stype;
        
    }

    // Setter methods
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setSfname(String sfname) {
        this.sfname = sfname;
    }

    public void setSlname(String slname) {
        this.slname = slname;
    }

    public void setSgroup(String sgroup) {
        this.sgroup = sgroup;
    }

    public void setScoursecode(String scoursecode) {
        this.scoursecode = scoursecode;
    }

    public void setSfaculty(String sfaculty) {
        this.sfaculty = sfaculty;
    }

    public void setScontact(String scontact) {
        this.scontact = scontact;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    // Getter methods
    public int getStudentID() {
        return studentID;
    }

    public String getSfname() {
        return sfname;
    }

    public String getSlname() {
        return slname;
    }

    public String getSgroup() {
        return sgroup;
    }

    public String getScoursecode() {
        return scoursecode;
    }

    public String getSfaculty() {
        return sfaculty;
    }

    public String getScontact() {
        return scontact;
    }

    public String getSgender() {
        return sgender;
    }

    public String getSpassword() {
        return spassword;
    }
    
    public boolean isValid() {
		return valid;
	}
    
	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
