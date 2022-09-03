package qlSach;

import java.util.Scanner;

public class BanDoc {
	private static BanDoc[] listBanDoc = new BanDoc[100];

	private static int AUTO_ID=-1;
	private int id;
	private String hoTen;
	private String diaChi;
	private int SDT;
	private String loaiBanDoc;
	
	public BanDoc() {
		if(AUTO_ID==-1) {
			AUTO_ID=10000;
			this.id=AUTO_ID;
			return;
		}
		this.id=++AUTO_ID;
	}
	public static BanDoc[] getListBanDoc() {
		return listBanDoc;
	}

	public static void setListBanDoc(BanDoc[] listBanDoc) {
		BanDoc.listBanDoc = listBanDoc;
	}

	public int getId() {
		return id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getSDT() {
		return SDT;
	}

	public void setSDT(int sDT) {
		SDT = sDT;
	}

	public String getLoaiBanDoc() {
		return loaiBanDoc;
	}

	public void setLoaiBanDoc(String loaiBanDoc) {
		this.loaiBanDoc = loaiBanDoc;
	}

	//Nhập một bạn đọc mới
	public void nhapBanDoc(Scanner sc) {
		boolean check=false;
		System.out.print("-Ho ten: ");
		this.hoTen=sc.nextLine();
		System.out.print("-Dia chi: ");
		this.diaChi=sc.nextLine();
		while(!check) {
			System.out.println("-Loai ban doc: ");
			System.out.println("  1. Sinh vien ");
			System.out.println("  2. Hoc vien cao hoc ");
			System.out.println("  3. Giao vien ");
			System.out.print("Lua chon:  ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				this.loaiBanDoc="Sinh vien";
				check=true;
				break;
			case 2:
				this.loaiBanDoc="Hoc vien cao hoc";
				check=true;
				break;
			case 3:
				this.loaiBanDoc="Giao vien";
				check=true;
				break;
			default:
				System.err.println("Chon lai!!!");
				check=false;
			}
		}
		System.out.print("-So dien thoai: ");
		this.SDT=sc.nextInt();

	}
	public void inBanDoc() {
		System.out.printf("%-7d %-15s %-15s %-12d %s", this.id, this.hoTen, this.diaChi, this.SDT, this.loaiBanDoc+"\n");
	}


}
