package AtvPersistencia;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class AlvoXML extends Alvo {
	
	private XStream xml = new XStream(new DomDriver());

	@Override
	public boolean save(Aluno aluno) {
		try {
			FileWriter writer = new FileWriter("xml/alunos.xml");
			writer.append(xml.toXML(aluno));
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

}
