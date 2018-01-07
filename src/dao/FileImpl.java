package dao;

import java.util.ArrayList;

import file.IOFile;
import model.DataModel;
import model.SinhVien;

public class FileImpl implements SinhVienDAO {
	private IOFile ioFile;
	private ArrayList<SinhVien> listSV = null;

	public FileImpl() {

		this.ioFile = new IOFile("SinhVien.txt");
		listSV = ioFile.loadFile();
	}

	public Object processSV(DataModel model) {

		try {
			String status = model.getStatus();

			switch (status) {
			case "add":
				int ma = 0;
				SinhVien sv = model.getSv();
				if (listSV.isEmpty()) {
					ma = 1000;
				} else {
					ma = listSV.get(listSV.size() - 1).getMaSV();
				}
				sv.setMaSV(ma + 1);
				listSV.add(sv);
				// System.out.println("Add OK");
				return true;

			case "save":
				return this.ioFile.saveFile(listSV);

			case "view":
				return listSV;

			case "edit":
				for (SinhVien x : listSV) {
					if (x.getMaSV() == model.getSv().getMaSV()) {
						x.setTenSV(model.getSv().getTenSV());
						x.setEmail(model.getSv().getEmail());
						return true;
					}
				}

			case "delete":
				if (listSV.contains(model.getSv())) {
					listSV.remove(model.getSv());
					return true;
				}
				// return false;

			case "exit":
				System.exit(1);
				break;

			}// end switch
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;

	}

}
