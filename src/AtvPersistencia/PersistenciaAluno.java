package AtvPersistencia;

public class PersistenciaAluno {
	private Alvo alvoPersistencia;
	
	public PersistenciaAluno(Alvo persistencia){
		this.alvoPersistencia = persistencia;
	}
		
	
	public boolean save(Aluno aluno) {
		return this.alvoPersistencia.save(aluno);
	}
}
