package qlSach;

import java.util.Scanner;

public class MainRun {
	private static QLMuonSach[] listQLMuonSach = new QLMuonSach[100];
	public static void main(String[] args) {
		mainMenu();
	}

	public static void mainMenu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("---QUAN LY MUON SACH---");
			System.out.println(" 1. Nhap, in dau sach");
			System.out.println(" 2. Nhap, in ban doc");
			System.out.println(" 3. Quan ly muon sach");
			System.out.println(" 4. Sap xep danh sach muon sach");
			System.out.println(" 5. Tim kiem theo ten ban doc");
			System.out.println(" 6. Thoat");
			System.out.print(" Moi chon: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				dauSachMenu(sc);
				break;
			case 2:
				banDocMenu(sc);
				break;
			case 3:
				qlMuonSachMenu(sc);
				break;
			case 4:
				sortMenu(sc);
				break;
			case 5:
				timKiem(sc);
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("chon lai!");
			}
		}
	}
	public static void dauSachMenu(Scanner sc) {
		while(true) {
			System.out.println("-----DAU SACH-----");
			System.out.println(" 1. Nhap dau sach moi");
			System.out.println(" 2. Danh sach cac dau sach");
			System.out.println(" 3. Quay lai");
			System.out.print(" Moi chon: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				nhapDauSach(sc);
				break;
			case 2:
				inDauSach();
				break;
			case 3:
				mainMenu();
				break;
			default:
				System.out.println("chon lai!");
			}
		}

	}
	
	public static void nhapDauSach(Scanner sc) {
		int choice;
		for(int i=0; i<Sach.getListSach().length; i++){
			if(Sach.getListSach()[i]!=null && i==Sach.getListSach().length-1) {
				System.err.println("Tran bo nho!");
				return;
			}
			else if(Sach.getListSach()[i]==null) {
				Sach.getListSach()[i]=new Sach();
				Sach.getListSach()[i].nhapSach(sc);
				do {
					System.out.println("Them sach khac?");
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
	}
	
	public static void inDauSach() {
		System.err.printf("%-7s %-15s %-15s %-25s %s","ID", "Ten Sach", "Tac gia", "Chuyen nganh", "Nam xuat ban\n");
		for(int i=0; i<Sach.getListSach().length-1; i++) {
			if(Sach.getListSach()[i]!=null) {
				Sach.getListSach()[i].inSach();
			}
		}
	}

	public static void banDocMenu(Scanner sc) {
		while(true) {
			System.out.println("-----BAN DOC-----");
			System.out.println(" 1. Nhap ban doc moi");
			System.out.println(" 2. Danh sach ban doc");
			System.out.println(" 3. Quay lai");
			System.out.print(" Moi chon: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				nhapBandoc(sc);
				break;
			case 2:
				inBanDoc();
				break;
			case 3:
				mainMenu();
				break;
			default:
				System.out.println("chon lai!");
			}
		}
	}
	
	public static void nhapBandoc(Scanner sc) {
		int choice;
		for(int i=0; i<BanDoc.getListBanDoc().length; i++){
			if(BanDoc.getListBanDoc()[i]!=null && i==BanDoc.getListBanDoc().length-1) {
				System.err.println("Tran bo nho!");
				return;
			}
			else if(BanDoc.getListBanDoc()[i]==null) {
				BanDoc.getListBanDoc()[i]=new BanDoc();
				BanDoc.getListBanDoc()[i].nhapBanDoc(sc);
				do {
					System.out.println("Them ban doc khac?");
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
	}
	
	public static void inBanDoc() {
		System.err.printf("%-7s %-15s %-15s %-12s %s","ID","Ho & Ten","Dia chi","SDT","Loai ban doc\n");
		for(int i=0; i<BanDoc.getListBanDoc().length-1; i++) {
			if(BanDoc.getListBanDoc()[i]!=null) {
				BanDoc.getListBanDoc()[i].inBanDoc();
			}
		}
	}
	
	public static void qlMuonSachMenu(Scanner sc) {
		while(true) {
			System.out.println("-----QUAN LY MUON SACH-----");
			System.out.println(" 1. Muon sach");
			System.out.println(" 2. Danh sach nguoi muon");
			System.out.println(" 3. Quay lai");
			System.out.print(" Moi chon: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				themListQLMuonSach(sc);
				break;
			case 2:
				showListQLMuonSach();
				break;
			case 3:
				mainMenu();
				break;
			default:
				System.out.println("chon lai!");
			}
		}
	}
	
	public static void themListQLMuonSach(Scanner sc) {
		int choice;
		boolean check=false;
		for(int i=0; i<listQLMuonSach.length; i++){
			if(listQLMuonSach[i]!=null && i==listQLMuonSach.length-1) {
				System.err.println("Khong the nhap them!");
				return;
			}
			if(listQLMuonSach[i]==null) {
				QLMuonSach qlms = new QLMuonSach();
				qlms.themQLMuonSach(sc);
				for(int j=0; j<listQLMuonSach.length; j++) {
					if(listQLMuonSach[j]!=null && listQLMuonSach[j].getBandoc()==qlms.getBandoc()) {
						listQLMuonSach[j].updateListSachMuon(qlms);
						check=true;
						break;
					}
				}
				if(check==false) {
					listQLMuonSach[i]=qlms;
				}else {
					check=false;
					i--;
				}
				do {
					System.out.println("Them nguoi muon khac?");
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
	}
	
	public static void showListQLMuonSach() {
		int count=0;
		for(int i=0; i<listQLMuonSach.length; i++){
			if(listQLMuonSach[i]!=null && listQLMuonSach[i].getBandoc()!=null) {
				System.out.println("Ten ban doc: "+listQLMuonSach[i].getBandoc().getHoTen());
				listQLMuonSach[i].inListSachMuon();
				count++;
			}
		}
		if(count==0) {
			System.err.println("Danh sach trong");
		}
	}
	
	public static void sortMenu(Scanner sc) {
		while(true) {
			System.out.println("-----SAP XEP DANH SACH MUON SACH-----");
			System.out.println(" 1. Theo ten ban doc");
			System.out.println(" 2. Theo so luong cuon sach duoc muon (giam dan)");
			System.out.println(" 3. Quay lai");
			System.out.print(" Moi chon: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				sortName();
				break;
			case 2:
				sortSoLuong();
				break;
			case 3:
				mainMenu();
				break;
			default:
				System.out.println("chon lai!");
			}
		}
	}
	
	public static void sortName() {
		for(int i=0; i<listQLMuonSach.length; i++) {
			for(int j=i+1; j<listQLMuonSach.length; j++) {
				if(listQLMuonSach[i]!=null && listQLMuonSach[j]!=null) {
					if(listQLMuonSach[i].getBandoc().getHoTen().compareTo(listQLMuonSach[j].getBandoc().getHoTen())>0) {
						QLMuonSach temp = new QLMuonSach();
						temp=listQLMuonSach[i];
						listQLMuonSach[i]=listQLMuonSach[j];
						listQLMuonSach[j]=temp;
					}
				}
			}
		}
		
		showListQLMuonSach();
	}
	
	public static void sortSoLuong() {
		for(int i=0; i<listQLMuonSach.length; i++) {
			for(int j=0; j<listQLMuonSach.length; j++) {
				if(listQLMuonSach[i]!=null && listQLMuonSach[j]!=null) {
					if(listQLMuonSach[i].countSachMuon()>listQLMuonSach[j].countSachMuon()) {
						QLMuonSach temp = new QLMuonSach();
						temp=listQLMuonSach[i];
						listQLMuonSach[i]=listQLMuonSach[j];
						listQLMuonSach[j]=temp;
					}
				}
			}
		}
		showListQLMuonSach();
	}
	
	public static void timKiem(Scanner sc) {
		System.out.println("-----TIM KIEM-----");
		System.out.print("Nhap ten ban doc: ");
		String ten= sc.nextLine();
		boolean check=false;
		System.out.println("Ket qua: ");
		for(int i=0; i<listQLMuonSach.length; i++) {
			if(listQLMuonSach[i]!=null && listQLMuonSach[i].getBandoc().getHoTen()==ten) {
				System.out.println("Ten ban doc: "+listQLMuonSach[i].getBandoc().getHoTen());
				listQLMuonSach[i].inListSachMuon();
				check=true;
				break;
			}
		}
		if(check==true) {
			System.out.println("Khong tim thay!!");
		}
	}
}
