package troque.me;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Novas_Funcionalidades {

	public ArrayList<String> realizarLeituraDaQuestao(InputStream file) throws FileNotFoundException, IOException {
		ArrayList<String> ar = new ArrayList<String>();
		try {
			//File file = (file)
			//FileInputStream fis = new FileInputStream("teste.txt");
			Charset cs = Charset.forName("UTF-8");
			InputStreamReader isr = new InputStreamReader(file, cs);
			int ch;
			String text = "";
			while ((ch = isr.read()) != -1) {
				if (ch != 10 && ch != 13) {
					text += String.valueOf((char) ch);
				} else {				
					if(text.equals("")){
						text = " ";
					}
					ar.add(text);
					text = "";
					isr.skip(1);
				}
			}
			file.close();
			isr.close();

		} catch (Exception ex) {

			// JOptionPane.showMessageDialog(null, ex.toString());
		}
		
		return ar;
	}
}
