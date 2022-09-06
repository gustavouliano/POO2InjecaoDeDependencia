package AtvPersistencia;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class AlvoJSON extends Alvo {
	
	private Gson gson;
	
	public AlvoJSON() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		this.gson = gsonBuilder.create();
	}

	@Override
	public boolean save(Aluno aluno) {
		try {
			FileWriter writer = new FileWriter("json/alunos.json");
			writer.append(gson.toJson(aluno));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean save(List<Aluno> aluno) {
		try {
			FileWriter writer = new FileWriter("json/alunos.json");
			writer.append(gson.toJson(aluno));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
