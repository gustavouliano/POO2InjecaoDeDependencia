package AtvHospital;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		
		MainAcao mainAcao = new MainAcao(new IdiomaIngles());
		mainAcao.inicia();
		
		
		// Médico
//		System.out.println("Cadastrar médico: ");
//		Medico medico = cadastraMedico();
		
		// Atendimento
//		ListaAtendimento listaAtendimento = cadastraAtendimento(medico);
//		listaAtendimento.mostrarLista();
	}
	
	public static Paciente cadastraPaciente() {
		Scanner input = new Scanner(System.in);
		Calendar calendario = Calendar.getInstance();
		System.out.print("Nome: ");
		String nome = input.nextLine();
		System.out.println("Data da nascimento: ");
		System.out.print("Dia: ");
		int dia = input.nextInt();
		System.out.print("Mês: ");
		int mes = input.nextInt();
		System.out.print("Ano: ");
		int ano = input.nextInt();
		calendario.set(Calendar.DAY_OF_MONTH, dia);
		calendario.set(Calendar.MONTH, mes--);
		calendario.set(Calendar.YEAR, ano);
		Date dataNascimento = calendario.getTime();
		Paciente paciente = new Paciente(nome, dataNascimento);
		System.out.println("Idade: " + paciente.calcularIdade());
		return paciente;
		
	}
	
	public static Medico cadastraMedico() {
		Scanner input = new Scanner(System.in);
		Calendar calendario = Calendar.getInstance();
		System.out.print("Nome: ");
		String nome = input.nextLine();
		System.out.println("Data da nascimento: ");
		System.out.print("Dia: ");
		int dia = input.nextInt();
		System.out.print("Mês: ");
		int mes = input.nextInt();
		System.out.print("Ano: ");
		int ano = input.nextInt();
		calendario.set(Calendar.DAY_OF_MONTH, dia);
		calendario.set(Calendar.MONTH, mes--);
		calendario.set(Calendar.YEAR, ano);
		Date dataNascimento = calendario.getTime();
		Medico medico = new Medico(nome, dataNascimento);
		System.out.println("Idade: "  + medico.calcularIdade());
		
		System.out.println("Digite 0 para sair.");
		boolean flag = true;
		do {
			System.out.print("Especialidade: ");
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

	public static ListaAtendimento cadastraAtendimento(Medico medico) {
		Scanner input = new Scanner(System.in);		
		Calendar calendario = Calendar.getInstance();
		ListaAtendimento listaAtendimento = new ListaAtendimento();
		
		while(true){
			System.out.print("Novo atendimento? ");
			String res = input.nextLine().toLowerCase();
			if (res.equals("n") || res.equals("não") || res.equals("nao")) {
				break;
			}
			System.out.print("Nome do paciente: ");
			String nome = input.nextLine();
			System.out.println("Data da nascimento: ");
			System.out.print("Dia: ");
			int dia = input.nextInt();
			System.out.print("Mês: ");
			int mes = input.nextInt();
			System.out.print("Ano: ");
			int ano = input.nextInt();
			calendario.set(Calendar.DAY_OF_MONTH, dia);
			calendario.set(Calendar.MONTH, mes--);
			calendario.set(Calendar.YEAR, ano);
			Date dataNascimento = calendario.getTime();
			Paciente paciente = new Paciente(nome, dataNascimento);
			
			boolean[] respostas = new boolean[3];
			
			System.out.println("Responda com sim [s] ou não [n]");
			for (int i = 0; i < 3; i++) {
				System.out.print("Pergunta " + (i+1) + "...? ");
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




