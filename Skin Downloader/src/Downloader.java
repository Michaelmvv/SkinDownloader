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
		URLConnection connection;
		DataInputStream data_input_stream;
		FileOutputStream file_output_stream;
		Name = JOptionPane.showInputDialog("Skin Users name", "Notch");
		if (Name.equalsIgnoreCase("cancel")) {
			JOptionPane.showMessageDialog(null, "You Canceled");
		} else {
		}
		byte[] fileData;
		try {
			Skin = new URL("https://s3.amazonaws.com/MinecraftSkins/" + Name
					+ ".png");
			connection = Skin.openConnection();
			data_input_stream = new DataInputStream(connection.getInputStream());
			fileData = new byte[connection.getContentLength()];
			for (int x = 0; x < fileData.length; x++) {
				fileData[x] = data_input_stream.readByte();
			}
			data_input_stream.close();
			file_output_stream = new FileOutputStream(new File(Name + ".png"));
			file_output_stream.write(fileData);
			file_output_stream.close();
		} catch (MalformedURLException m) {
			System.out.println(m);
		} catch (IOException io) {
			System.out.println(io);
		}
	}
}
