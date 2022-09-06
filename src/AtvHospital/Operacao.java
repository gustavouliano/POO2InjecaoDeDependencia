package AtvHospital;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Operacao {
	
	private Date inicio;
	private Date fim;
	
	public Operacao() {
		this.inicio = new Date();
	}
	
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Period tempoTotal() {
		LocalDate inicio = this.inicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate fim = this.fim.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return Period.between(inicio, fim);
	}
	
}
