package AtvHospital;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MainAcao {
	
	InterfaceIdioma idioma;

	public MainAcao(InterfaceIdioma idioma) {
		this.idioma = idioma;
	}
	
	public MainAcao() {
		this.idioma = new IdiomaPortugues();
	}
	
	public void inicia() {
		// Médico
		System.out.println(idioma.cadastrarMedico() + ": ");
		Medico medico = this.cadastraMedico();
		
		ListaAtendimento listaAtendimento = cadastraAtendimento(medico);
		listaAtendimento.mostrarLista();
	}
	
	public Medico cadastraMedico() {
		Scanner input = new Scanner(System.in);
		Calendar calendario = Calendar.getInstance();
		System.out.print(idioma.nome() + ": ");
		String nome = input.nextLine();
		System.out.println(idioma.dataDeNascimento() + ": ");
		System.out.print(idioma.dia() + ": ");
		int dia = input.nextInt();
		System.out.print(idioma.mes() + ": ");
		int mes = input.nextInt();
		System.out.print(idioma.ano() + ": ");
		int ano = input.nextInt();
		calendario.set(Calendar.DAY_OF_MONTH, dia);
		calendario.set(Calendar.MONTH, mes--);
		calendario.set(Calendar.YEAR, ano);
		Date dataNascimento = calendario.getTime();
		Medico medico = new Medico(nome, dataNascimento);
		System.out.println(idioma.idade() +  ": "  + medico.calcularIdade());
		
		System.out.println(idioma.digite0ParaSair() + ".");
		boolean flag = true;
		do {
			System.out.print(idioma.especialidade() + ": ");
			String descEspecialidade = input.next();
			if (descEspecialidade.equals("0")) {
				flag = false;
			}
			else{
				Especialidade especialidade = new Especialidade(descEspecialidade);
				medico.addEspecialidade(especialidade);
			}
		}while (flag);
		
		return medico;
	}
	
	public ListaAtendimento cadastraAtendimento(Medico medico) {
		Scanner input = new Scanner(System.in);		
		Calendar calendario = Calendar.getInstance();
		ListaAtendimento listaAtendimento = new ListaAtendimento();
		
		while(true){
			System.out.print(idioma.novoAtendimento() + " ");
			String res = input.nextLine().toLowerCase();
			if (res.equals("n") || res.equals("não") || res.equals("nao")) {
				break;
			}
			System.out.print(idioma.nomeDoPaciente() + ": ");
			String nome = input.nextLine();
			System.out.println(idioma.dataDeNascimento() + ": ");
			System.out.print(idioma.dia() + ": ");
			int dia = input.nextInt();
			System.out.print(idioma.mes() + ": ");
			int mes = input.nextInt();
			System.out.print(idioma.ano() + ": ");
			int ano = input.nextInt();
			calendario.set(Calendar.DAY_OF_MONTH, dia);
			calendario.set(Calendar.MONTH, mes--);
			calendario.set(Calendar.YEAR, ano);
			Date dataNascimento = calendario.getTime();
			Paciente paciente = new Paciente(nome, dataNascimento);
			
			boolean[] respostas = new boolean[3];
			
			System.out.println(idioma.respondaComSimOuNao());
			for (int i = 0; i < 3; i++) {
				System.out.print(idioma.pergunta() + " " + (i+1) + "...? ");
				String resposta = input.next().toLowerCase();
				if (resposta.equals("n") || resposta.equals("não") || resposta.equals("nao")) {
					respostas[i] = false;
				}
				else {
					respostas[i] = true;
				}
			}
			input.nextLine();
			
			Atendimento atendimento = new Atendimento(medico, paciente);
			atendimento.calculaPrioridade(respostas);
			listaAtendimento.addLista(atendimento);			
		}
		
		return listaAtendimento;
	}

	
}
