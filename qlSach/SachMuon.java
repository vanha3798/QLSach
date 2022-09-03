package qlSach;

import java.util.Scanner;

public class SachMuon {
	public static final int MAX_SO_LUONG=3;
	private Sach sach;
	private int soLuong;
	private String tinhTrang;
	
	public SachMuon() {}
	
	public Sach getSach() {
		return sach;
	}
	public void setSach(Sach sach) {
		this.sach = sach;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong=soLuong;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	public void themSachMuon(Scanner sc) {
		int count=0;
		System.out.print(" +Sach (nhap id): ");
		int id= sc.nextInt();
		for(int i=0; i<Sach.getListSach().length; i++) {
			if(Sach.getListSach()[i]!=null && Sach.getListSach()[i].getId()==id) {
				this.sach=Sach.getListSach()[i];
				break;
			}
			count++;
		}
		if(count==Sach.getListSach().length) {
			System.err.println("Sach nay khong ton tai!");
			return;
		}
		
		do {
			System.out.print(" + So luong: ");
			int soLuong= sc.nextInt();
			if(soLuong>MAX_SO_LUONG || soLuong<1) {
				System.err.println("Chi duoc muon tu 1 -> 3 quyen!");
			}
			else {
				this.soLuong=soLuong;
			}
		}while(soLuong>MAX_SO_LUONG || soLuong<1);
		
		System.out.print(" + Tinh trang: ");
		String tinhTrang = sc.nextLine();
		this.tinhTrang=tinhTrang;
	}
	public void updateSoLuong(SachMuon sm) {
		Scanner sc = new Scanner(System.in);
		if(this.soLuong + sm.soLuong>MAX_SO_LUONG) {
			int choice=0;
			do {
				System.out.println("Sach " +this.getSach().getTenSach()+ "chi duoc muon them toi da "+(MAX_SO_LUONG-this.soLuong)+" quyen!");
				System.out.println("1. Dong y");
				System.out.println("2. Khong dong y");
				System.out.print("Chon: ");
				choice=sc.nextInt();
				if(choice==1) {
					this.soLuong=MAX_SO_LUONG;
					return;
				}
				else if(choice==2){
					return;
				}
			}while(choice!=1 && choice!=2);
		}
		else {
			this.soLuong=this.soLuong+sm.soLuong;
		}
	}

	public void inSachMuon() {
		System.out.printf("%-7s %-15s %-8s %s\n",this.sach.getId(), this.sach.getTenSach(), this.soLuong, this.tinhTrang);
	}
}
