package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dao.FileImpl;
import dao.SinhVienDAO;
import model.DataModel;

public class ServerControl {
	private SinhVienDAO dao;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private DataModel model;
	public ServerControl() {
		
		this.dao = new FileImpl();
		
		try {
			int port = 1234;
			ServerSocket myServer = new ServerSocket(port);
//			System.out.println("Server is listening...");
			Socket socketClient = myServer.accept();
//			System.out.println("Server accepted a client!");
//			
			
			in = new ObjectInputStream(socketClient.getInputStream());
			out = new ObjectOutputStream(socketClient.getOutputStream());
			while(true) {
				model = (DataModel) in.readObject();
				
				Object o = dao.processSV(model);
				out.writeObject(o);
				out.reset();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
