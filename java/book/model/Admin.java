package book.model;

public class Admin {

	private int ADMINID;
	private String ADFNAME;
	private String ADLNAME;
	private String ADCONTACT;
	private String ADGENDER;
	private String ADPASSWORD;
	private boolean valid;
	
	public Admin(){
		
	}
	public Admin(int ADMINID,String ADFNAME,String ADLNAME,String ADCONTACT,String ADGENDER,String ADPASSWORD,boolean valid) {
		this.ADMINID=ADMINID;
		this.ADFNAME=ADFNAME;
		this.ADLNAME=ADLNAME;
		this.ADCONTACT=ADCONTACT;
		this.ADGENDER=ADGENDER;
		this.ADPASSWORD=ADPASSWORD;
		this.valid=valid;
	}

	public int getADMINID() {
		return ADMINID;
	}

	public void setADMINID(int aDMINID) {
		this.ADMINID = aDMINID;
	}

	public String getADFNAME() {
		return ADFNAME;
	}

	public void setADFNAME(String aDFNAME) {
		this.ADFNAME = aDFNAME;
	}

	public String getADLNAME() {
		return ADLNAME;
	}

	public void setADLNAME(String aDLNAME) {
		this.ADLNAME = aDLNAME;
	}

	public String getADCONTACT() {
		return ADCONTACT;
	}

	public void setADCONTACT(String aDCONTACT) {
		this.ADCONTACT = aDCONTACT;
	}

	public String getADGENDER() {
		return ADGENDER;
	}

	public void setADGENDER(String aDGENDER) {
		this.ADGENDER = aDGENDER;
	}

	public String getADPASSWORD() {
		return ADPASSWORD;
	}

	public void setADPASSWORD(String aDPASSWORD) {
		this.ADPASSWORD = aDPASSWORD;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
}
