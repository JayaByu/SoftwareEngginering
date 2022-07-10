package Model;

public class Attendance extends Root {

	private Integer JamKedatangan;
	private Integer PelanggaranATT;
	
	public Attendance(String nama, String jabatan, Integer jamKedatangan, Integer pelanggaranATT) {
		super(nama, jabatan);
		JamKedatangan = jamKedatangan;
		PelanggaranATT = pelanggaranATT;
	}

	public Integer getJamKedatangan() {
		return JamKedatangan;
	}

	public void setJamKedatangan(Integer jamKedatangan) {
		JamKedatangan = jamKedatangan;
	}

	public Integer getPelanggaranATT() {
		return PelanggaranATT;
	}

	public void setPelanggaranATT(Integer pelanggaranATT) {
		PelanggaranATT = pelanggaranATT;
	}
	
	

}
