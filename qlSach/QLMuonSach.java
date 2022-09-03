package qlSach;

import java.util.Scanner;

public class QLMuonSach {
	private static final int MAX_DAU_SACH=5;
	private SachMuon[] listSachMuon = new SachMuon[MAX_DAU_SACH] ;//danh sách các đầu sách mỗi bạn đọc mượn
	private BanDoc banDoc;
	
	public SachMuon[] getListSachMuon() {
		return listSachMuon;
	}
	public void setListSachMuon(SachMuon[] listSachMuon) {
		this.listSachMuon = listSachMuon;
	}
	public BanDoc getBandoc() {
		return banDoc;
	}
	public void setBandoc(BanDoc bandoc) {
		this.banDoc = bandoc;
	}
	public void themListSachMuon(Scanner sc) {
		while(true) {
			SachMuon sm= new SachMuon();
			sm.themSachMuon(sc);
			for(int i=0; i<listSachMuon.length; i++) {
				if( listSachMuon[i]!=null && listSachMuon[i].getSach().equals(sm.getSach())==true) {
					listSachMuon[i].updateSoLuong(sm);
					break;
				}
				else if(listSachMuon[listSachMuon.length-1]!=null ){
					System.out.println("Chi duoc phep muon toi da 5 dau sach khac nhau");
					return;
				}
				else {
					listSachMuon[i]=sm;
					break;
				}
			}
			int choice;
			do {
				System.out.println("Muon them sach khac?");
				System.out.println("1. Co");
				System.out.println("2. Khong");
				System.out.print("Chon: ");
				choice = sc.nextInt();
				if(choice==2) {
					return;
				}
			}while(choice!=1 && choice!=2);
		}
		
	}
	
	public void updateListSachMuon(QLMuonSach qlms) {
		int check=0;
		int count=0;
		SachMuon[] listTemp=new SachMuon[MAX_DAU_SACH];
		for(int i=0; i<this.listSachMuon.length; i++) {
			if(this.listSachMuon[i]!=null && i==this.listSachMuon.length-1) {
				if(count==0) {
					System.err.println("Ban khong duoc phep muon them sach!");
					return;
				}
				else {
					System.err.println("Ban duoc muon "+count+" quyen sach!");
					return;
				}
			}
			if(this.listSachMuon[i]!=null){
				for(int j=0; j<qlms.getListSachMuon().length; j++) {
					if(qlms.getListSachMuon()[j]!=null && qlms.getListSachMuon()[j].getSach()==this.listSachMuon[i].getSach()) {
						this.listSachMuon[i].updateSoLuong(qlms.getListSachMuon()[j]);
						listTemp[count]=this.listSachMuon[i];
						count++;
						break;
					}
				}
			}
			else{
				for(int j=0; j<qlms.getListSachMuon().length; j++) {
					for(int k=0; k<listTemp.length; k++) {
						if(qlms.getListSachMuon()[j]!=null && listTemp[k]!=null ) {
							if(qlms.getListSachMuon()[j].getSach()!=listTemp[k].getSach()) {
								check++;
							}
						}
					}
					if(check==count) {
						this.listSachMuon[i]=qlms.getListSachMuon()[j];
						listTemp[count]=qlms.getListSachMuon()[j];
						count++;
					}
					break;
				}
			}
		}
	}
	
	public void themQLMuonSach(Scanner sc) {
		int count=0;
		System.out.print("- Ban doc (nhap id): ");
		int id= sc.nextInt();
		for(int i=0; i<BanDoc.getListBanDoc().length; i++) {
			if(BanDoc.getListBanDoc()[i]!=null && BanDoc.getListBanDoc()[i].getId()==id) {
				this.banDoc=BanDoc.getListBanDoc()[i];
				break;
			}
			count++;
		}
		if(count==BanDoc.getListBanDoc().length) {
			System.out.println("Nguoi nay khong ton tai!");
			return;
		}
		System.out.println("- Sach muon:");
		this.themListSachMuon(sc);
	}
	public void inListSachMuon() {
		System.out.printf("%-7s %-15s %-8s %s\n","ID", "Ten sach", "So luong", "Tinh trang");
		for(int i=0; i<listSachMuon.length; i++) {
			if(this.listSachMuon[i]!=null) {
				this.listSachMuon[i].inSachMuon();
			}
		}
	}
	
	public int countSachMuon() {
		int count=0;
		for(int i=0; i<listSachMuon.length; i++) {
			if(listSachMuon[i]!=null) {
				count++;
			}
		}
		return count;
	}
}
