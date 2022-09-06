package AtvHospital;
import java.util.ArrayList;
import java.util.Collections;

public class ListaAtendimento {
	private ArrayList<Atendimento> lista;
	
	public ListaAtendimento() {
		this.lista = new ArrayList<Atendimento>();
	}

	public ArrayList<Atendimento> getLista() {
		return lista;
	}

	public void setAtendimento(ArrayList<Atendimento> lista) {
		this.lista = lista;
	}
	
	public void addLista(Atendimento atendimento) {
		lista.add(atendimento);
	}
	
	public void mostrarLista(){
		//Mostrar lista...
		Collections.sort(this.lista);
		for (Atendimento atendimento : this.lista) {
			System.out.println(atendimento.toString());
		}
	}
}
