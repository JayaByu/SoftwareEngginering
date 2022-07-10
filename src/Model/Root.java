package Model;

public abstract class Root {

	private String Nama;
	private String Jabatan;
	
	public Root(String nama, String jabatan) {
		super();
		Nama = nama;
		Jabatan = jabatan;
	}
	public String getNama() {
		return Nama;
	}
	public void setNama(String nama) {
		Nama = nama;
	}
	public String getJabatan() {
		return Jabatan;
	}
	public void setJabatan(String jabatan) {
		Jabatan = jabatan;
	}



	
	
}
