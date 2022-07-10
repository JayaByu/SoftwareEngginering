package Model;

public class Overtime extends Root{

	private Integer JamPulang;
	private Integer PelanggaranOVT;
	

	
	public Overtime(String nama, String jabatan, Integer jamPulang, Integer pelanggaranOVT) {
		super(nama, jabatan);
		JamPulang = jamPulang;
		PelanggaranOVT = pelanggaranOVT;
	}



	public Integer getJamPulang() {
		return JamPulang;
	}



	public void setJamPulang(Integer jamPulang) {
		JamPulang = jamPulang;
	}



	public Integer getPelanggaranOVT() {
		return PelanggaranOVT;
	}



	public void setPelanggaranOVT(Integer pelanggaranOVT) {
		PelanggaranOVT = pelanggaranOVT;
	}


	

}
