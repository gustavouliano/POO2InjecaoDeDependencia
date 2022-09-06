package AtvHospital;
import java.util.ArrayList;
import java.util.Date;

public class Medico extends Pessoa {
	
	private ArrayList<Especialidade> especialidade;
	
	public Medico(String nome, Date dataNascimento) {
		super(nome, dataNascimento);
		this.especialidade = new ArrayList<Especialidade>();
	}

	public ArrayList<Especialidade> getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(ArrayList<Especialidade> especialidade) {
		this.especialidade = especialidade;
	}
	
	public void addEspecialidade(Especialidade especialidade) {
		if (especialidade == null) {
			return;
		}
		this.especialidade.add(especialidade);
	}
	
}
