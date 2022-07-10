import java.util.Scanner;
import java.util.Vector;

import javax.jws.WebParam.Mode;

import Model.Attendance;
import Model.Karyawan;
import Model.Overtime;
import Model.Root;



public class Main {
	
	Scanner scan = new Scanner(System.in);
	Vector<Root> Root = new Vector<>();
	int rm;
	
	public void TABLE() {
		System.out.println("--------------------------");
		System.out.println("1. Add Karyawan");
		System.out.println("2. Attendance");
		System.out.println("3. Overitime");
		System.out.print("Choose : ");
	}

	public void VIEW() {
//		for (int j = 0; j< Root.size(); j++) {
//			System.out.println("|   "+ j+1 +"   | " +Root.get(j).getJabatan()+"\t\t|\t\t"+Root.get(j).getNama()+"\t\t|\t\t"+Root.get(j).g);
			for (Root r : Root) {
				if (r instanceof Root) {		
					System.out.println("|\t"+((Karyawan)r).getNama()+"\t\t|\t\t"+((Karyawan)r).getJabatan()+"\t\t|\t"+((Karyawan)r).getNoHp()+"\t\t|\t"+((Karyawan)r).getEmail()+"\t\t|");
				}
			}
//		}
	}
	
	public void CREATE() {
		String tmpName;
		String tmpHp;
		String tmpJabatan;
		String tmpEmail;

		System.out.println("\tInput Data Karyawan");
		System.out.println("====================================");
		scan.nextLine();
		do {
			System.out.print("Masukan Nama Karyawan : ");
			tmpName = scan.nextLine();
		} while (!tmpName.matches("^[a-z][a-z ]*[a-z]?$"));
		do {
			System.out.print("Masukan Jabatan Anda [admin],[officer],[supervisor] : ");
			tmpJabatan = scan.nextLine();
		} while (!tmpJabatan.equals("Admin")&&!tmpJabatan.equals("Officer")&&!tmpJabatan.equals("Supervisor")&&!tmpJabatan.equals("admin")&&!tmpJabatan.equals("officer")&&!tmpJabatan.equals("supervisor"));
		do {
			System.out.print("Masukan Telepon [12 digit ] : ");
			tmpHp = scan.nextLine();
		} while (tmpHp.length()<12);
		do {
			System.out.print("Masukan Email Yang Anda Gunakan : ");
			tmpEmail = scan.nextLine();
		} while (tmpEmail.length()<1);
		Root.add(new Karyawan(tmpJabatan, tmpName, tmpHp, tmpEmail));
	}
	
	public void ATTENDANCE() {
		String tmpNama;
		Integer tmpJamKedatangan;
		Integer Pelanggaran = 0;

		
		System.out.println("\n\n\n\tAttendance Karyawan ");
		System.out.println("====================================");
		System.out.print("Masukan Nama : ");
		
		do {
			tmpNama = scan.nextLine();
		} while (!tmpNama.matches("^[a-z][a-z ]*[a-z]?$"));
		
		for (int i = 0; i < Root.size(); i++) {
			if (tmpNama.equals(Root.get(i).getJabatan())) {
				do {
					System.out.print("Jam Kedatangan : ");
					tmpJamKedatangan = scan.nextInt();
					if (tmpJamKedatangan>800) {
						if (Root.get(i).getNama().equals("Admin")&&Root.get(i).getNama().equals("admin")) {
							Pelanggaran = ((tmpJamKedatangan-800)/100)*25000;
							
						}else if (Root.get(i).getNama().equals("Officer")&&Root.get(i).getNama().equals("officer")) {
							Pelanggaran = ((tmpJamKedatangan-800)/100)*50000;
							
						}else if (Root.get(i).getNama().equals("Supervisor")&&Root.get(i).getNama().equals("supervisor")) {
							Pelanggaran = ((tmpJamKedatangan-800)/100)*75000;
							
						}
						System.out.println("Jabatan : "+Root.get(i).getNama());
						System.out.println("Keterlambatan(Penalty) : ["+(tmpJamKedatangan-800)/100+"/jam"+"(Rp."+Pelanggaran+",-)]");
					}else {
						System.out.println("Jabatan : "+Root.get(i).getNama());
						System.out.println("Tepat Waktu : ["+tmpJamKedatangan+"(Rp."+Pelanggaran+",-)]");
					}
				} while (tmpJamKedatangan>1200);
			}
		}
	}

	public void OVERTIME() {
		String tmpNama;
		Integer tmpJamPulang;
		Integer Pelanggaran = 0;
//		String Jabatan;
		
		System.out.println("\n\n\n\tOvertime Karyawan ");
		System.out.println("====================================");
		System.out.print("Masukan Nama : ");
		do {
			tmpNama = scan.nextLine();
		} while (!tmpNama.matches("^[a-z][a-z ]*[a-z]?$"));
		
		for (int i = 0; i < Root.size(); i++) {
			if (tmpNama.equals(Root.get(i).getJabatan())) {
			do {
				System.out.print("Jam Pulang : ");
				try {
					tmpJamPulang = scan.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					tmpJamPulang = -1;
				}
				if (tmpJamPulang>1700) {
					if (Root.get(i).getNama().equals("Admin")&&Root.get(i).getNama().equals("admin")) {
						Pelanggaran = ((tmpJamPulang-1700)/100)*75000;
						
					}else if (Root.get(i).getNama().equals("Officer")&&Root.get(i).getNama().equals("officer")) {
						Pelanggaran = ((tmpJamPulang-1700)/100)*50000;
						
					}else if (Root.get(i).getNama().equals("Supervisor")&&Root.get(i).getNama().equals("supervisor")) {
						Pelanggaran = ((tmpJamPulang-1700)/100)*25000;
					}
					System.out.println("Jabatan : "+Root.get(i).getNama());
					System.out.println("Keterlambatan(OvertimePay) : ["+(tmpJamPulang-1700)/100+"/jam"+"(Rp."+Pelanggaran+",-)]");
				}else {
					System.out.println("Jabatan : "+Root.get(i).getNama());
					System.out.println("Tepat Waktu : ["+tmpJamPulang+"(Rp."+Pelanggaran+",-)]");
				}
				Root.remove(i);
			} while (tmpJamPulang>2100);
		  }
		}
		
	}
	
	public Main() {
		// TODO Auto-generated constructor stub
		do {
			System.out.println("\t\t\t\t\t\t- Data Karyawan -");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| \tJabatan\t\t | \t\tNama Karyawan\t\t | \tNo Telephone\t | \t\tEmail\t\t |\n\n");
			if (Root.isEmpty()) {
				System.out.println(" \t\t\t\t\t\tMohon untuk isi data terlebih dahulu\t\t\t\t\t\t \n\n");
			}else {
				VIEW();
			}
			TABLE();
			int chose = scan.nextInt();
			switch (chose) {
			case 1:
				CREATE();
				break;
			case 2: 
				ATTENDANCE();
				break;
			case 3: 
				OVERTIME();
				break;
			}
		} while (true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}

//Nama : Jayawardhana Bayu Krisnatama EkaPutra
//NIM  : 2440100632
