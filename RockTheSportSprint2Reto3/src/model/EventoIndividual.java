package model;

public class EventoIndividual extends EventoDeportivo{
	
	private String nivel;
	private int maxParticipantes;
	private static int contadorEventosIndividuales;

	public EventoIndividual() {
		super();
	}

	public EventoIndividual(int id, String tipoEvento, String descripcion, int edadReq, String requisitos, String nivel, int maxParticipantes) {
		super(id, tipoEvento, "Individual", descripcion, edadReq,requisitos);
		setNivel(nivel);
		setMaxParticipantes(maxParticipantes);
	}
	
	public EventoIndividual(String tipoEvento, String descripcion, int edadReq, String requisitos, String nivel, int maxParticipantes) {
		super(tipoEvento, "Individual", descripcion, edadReq,requisitos);
		setNivel(nivel);
		setMaxParticipantes(maxParticipantes);
		contadorEventosIndividuales++;
	}

	public int getContadorEventosIndividuales() {
		return contadorEventosIndividuales;
	}
	
	public String iniciarEvento() {
		return "El evento individual esta por comenzar en breve";
	}
	
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public int getMaxParticipantes() {
		return maxParticipantes;
	}

	public void setMaxParticipantes(int maxParticipantes) {
		this.maxParticipantes = maxParticipantes;
	}

	@Override
	public String toString() {
		return "EventoIndividual: " +
				super.toString() +
				"\n Nivel: " + nivel;
	}

}
