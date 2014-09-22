import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

public class Downloader {
	public static void main(String[] args) {
		String Name;
		URL Skin;
		URLConnection con;
		DataInputStream dis;
		FileOutputStream fos;
		Name = JOptionPane.showInputDialog("Skin Users name", "Notch");
		if (Name.equalsIgnoreCase("cancel")) {
			JOptionPane.showMessageDialog(null, "You Canceled");
		} else {
		}
		byte[] fileData;
		try {
			Skin = new URL("https://s3.amazonaws.com/MinecraftSkins/" + Name
					+ ".png");
			con = Skin.openConnection();
			dis = new DataInputStream(con.getInputStream());
			fileData = new byte[con.getContentLength()];
			for (int x = 0; x < fileData.length; x++) {
				fileData[x] = dis.readByte();
			}
			dis.close();
			fos = new FileOutputStream(new File(Name + ".png"));
			fos.write(fileData);
			fos.close();
		} catch (MalformedURLException m) {
			System.out.println(m);
		} catch (IOException io) {
			System.out.println(io);
		}
	}
}
