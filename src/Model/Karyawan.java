package Model;

public class Karyawan extends Root{
	
	private String NoHp;
	private String Email;

	public Karyawan(String nama, String jabatan, String noHp, String email) {
		super(nama, jabatan);
		NoHp = noHp;
		Email = email;
	}

	public String getNoHp() {
		return NoHp;
	}
	public void setNoHp(String noHp) {
		NoHp = noHp;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	

}
