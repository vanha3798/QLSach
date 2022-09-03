package qlSach;

import java.util.Scanner;

public class Sach {
	private static Sach[] listSach = new Sach[100];

	private static int AUTO_ID=-1;
	private int id;
	private String tenSach;
	private String tacGia;
	private String chuyenNganh;
	private int namXuatBan;
	
	public Sach() {
		if(AUTO_ID==-1) {
			AUTO_ID=10000;
			this.id=AUTO_ID;
			return;
		}
		this.id=++AUTO_ID;
	}

	public static Sach[] getListSach() {
		return listSach;
	}

	public static void setListSach(Sach[] listSach) {
		Sach.listSach = listSach;
	}
	
	public int getId() {
		return id;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	
	public void nhapSach(Scanner sc) {
		boolean check=false;
		System.out.print("-Ten sach: ");
		this.tenSach=sc.nextLine();
		System.out.print("-Tac gia: ");
		this.tacGia=sc.nextLine();
		while(!check) {
			System.out.println("- Chuyen nganh: ");
			System.out.println("  1. Khoa hoc tu nhien ");
			System.out.println("  2. Van hoc - Nghe thuat ");
			System.out.println("  3. Dien tu vien thong ");
			System.out.println("  4. Cong nghe thong tin ");
			System.out.print("Lua chon:  ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				this.chuyenNganh="Khoa hoc tu nhien";
				check=true;
				break;
			case 2:
				this.chuyenNganh="Van hoc - Nghe thuat";
				check=true;
				break;
			case 3:
				this.chuyenNganh="Dien tu vien thong";
				check=true;
				break;
			case 4:
				this.chuyenNganh="Cong nghe thong tin";
				check=true;
				break;
			default:
				System.err.println("Chon lai!!!");
				check=false;
			}
			
		}
		System.out.print("-Nam xuat ban: ");
		this.namXuatBan=sc.nextInt();

	}

	public void inSach() {
		System.out.printf("%-7d %-15s %-15s %-25s %d", this.id, this.tenSach, this.tacGia, this.chuyenNganh, this.namXuatBan+"\n");
	}
}
