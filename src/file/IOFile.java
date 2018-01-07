package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.SinhVien;

public class IOFile {
	private ObjectOutputStream writeFile;
	private ObjectInputStream readFile;
	private String filename;

	public IOFile(String filename) {
		this.filename = filename;
	}

	public ArrayList<SinhVien> loadFile() {
		ArrayList<SinhVien> listSV = null;
		try {
			File file = new File(this.filename);
			if (!file.exists()) {
				/**
				 * Neu file khong ton tai thi tao file moi return new ArrayList<>()
				 */
				file.createNewFile();
				return new ArrayList<>();
			} else {
				/**
				 * Da co file thi mo luong doc file
				 */
				readFile = new ObjectInputStream(new FileInputStream(file));
				listSV = (ArrayList<SinhVien>) readFile.readObject();
				if (listSV == null) {
					/**
					 * Neu list k co gi thi dong file return new ArrayList<>()
					 */
					readFile.close();
					return new ArrayList<>();
				}
				readFile.close();
				return listSV;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return new ArrayList<>();

	}

	public boolean saveFile(ArrayList<SinhVien> listSV) {
		try {
			writeFile = new ObjectOutputStream(new FileOutputStream(this.filename));
			writeFile.writeObject(listSV);
			writeFile.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}

}
