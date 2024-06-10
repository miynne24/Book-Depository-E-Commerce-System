package book.model;

public class ResidentStudent extends Student {
    private String room;
    private String block;
    
    public ResidentStudent() {
    	
    }
	public ResidentStudent(int studentID, String sfname, String slname, String sgroup, String scoursecode, String sfaculty,
            String scontact, String sgender, String spassword, String stype, String room, String block) {
		super(studentID, sfname, slname, sgroup, scoursecode, sfaculty, scontact, sgender, spassword, stype);
		this.room = room;
		this.block = block;
	}
	@Override
	public void setStudentID(int studentID) {
		// TODO Auto-generated method stub
		super.setStudentID(studentID);
	}
	@Override
	public void setSfname(String sfname) {
		// TODO Auto-generated method stub
		super.setSfname(sfname);
	}
	@Override
	public void setSlname(String slname) {
		// TODO Auto-generated method stub
		super.setSlname(slname);
	}
	@Override
	public void setSgroup(String sgroup) {
		// TODO Auto-generated method stub
		super.setSgroup(sgroup);
	}
	@Override
	public void setScoursecode(String scoursecode) {
		// TODO Auto-generated method stub
		super.setScoursecode(scoursecode);
	}
	@Override
	public void setSfaculty(String sfaculty) {
		// TODO Auto-generated method stub
		super.setSfaculty(sfaculty);
	}
	@Override
	public void setScontact(String scontact) {
		// TODO Auto-generated method stub
		super.setScontact(scontact);
	}
	@Override
	public void setSgender(String sgender) {
		// TODO Auto-generated method stub
		super.setSgender(sgender);
	}
	@Override
	public void setSpassword(String spassword) {
		// TODO Auto-generated method stub
		super.setSpassword(spassword);
	}
	@Override
	public int getStudentID() {
		// TODO Auto-generated method stub
		return super.getStudentID();
	}
	@Override
	public String getSfname() {
		// TODO Auto-generated method stub
		return super.getSfname();
	}
	@Override
	public String getSlname() {
		// TODO Auto-generated method stub
		return super.getSlname();
	}
	@Override
	public String getSgroup() {
		// TODO Auto-generated method stub
		return super.getSgroup();
	}
	@Override
	public String getScoursecode() {
		// TODO Auto-generated method stub
		return super.getScoursecode();
	}
	@Override
	public String getSfaculty() {
		// TODO Auto-generated method stub
		return super.getSfaculty();
	}
	@Override
	public String getScontact() {
		// TODO Auto-generated method stub
		return super.getScontact();
	}
	@Override
	public String getSgender() {
		// TODO Auto-generated method stub
		return super.getSgender();
	}
	@Override
	public String getSpassword() {
		// TODO Auto-generated method stub
		return super.getSpassword();
	}
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return super.isValid();
	}
	@Override
	public void setValid(boolean valid) {
		// TODO Auto-generated method stub
		super.setValid(valid);
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
    
}
