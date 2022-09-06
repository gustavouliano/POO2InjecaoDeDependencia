package AtvPersistencia;

public class main {

	public static void main(String[] args) {
		
		Aluno aluno1 = new Aluno("0009", "Gustavo", "1242421", "07/12/2002", "gustavo@gmail.com");
		PersistenciaAluno persistencia = new PersistenciaAluno(new AlvoJSON());
		System.out.println(persistencia.save(aluno1));
	}

}
