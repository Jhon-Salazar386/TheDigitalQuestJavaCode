package model;

public class EventoIndividual extends EventoDeportivo {

	private String nivel;
	private int maxParticipantes;
	public static int contadorEventosIndividuales;

	public EventoIndividual() {
		super();
		contadorEventosIndividuales++;
	}

	// Constructor usado para metodos de consulta
	public EventoIndividual(int id, String tipoEvento, String descripcion, int edadReq, String requisitos, String nivel,
			int maxParticipantes) {
		super(id, tipoEvento, "Individual", descripcion, edadReq, requisitos);
		setNivel(nivel);
		setMaxParticipantes(maxParticipantes);
	}

	// Constructor usado para metodos de insercion
	public EventoIndividual(String tipoEvento, String descripcion, int edadReq, String requisitos, String nivel,
			int maxParticipantes) {
		super(tipoEvento, "Individual", descripcion, edadReq, requisitos);
		setNivel(nivel);
		setMaxParticipantes(maxParticipantes);
		contadorEventosIndividuales++;
	}
	
	@Override
	public String iniciarEvento() {
		return "El evento individual esta por comenzar en breve";
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		
	    if (nivel == null || nivel.isBlank()) {
	        throw new IllegalArgumentException("El nivel no puede estar vacío");
	    }
		
		this.nivel = nivel;
	}

	public int getMaxParticipantes() {
		return maxParticipantes;
	}

	public void setMaxParticipantes(int maxParticipantes) {
		
	    if (maxParticipantes <= 0) {
	        throw new IllegalArgumentException("Debe haber al menos un participante");
	    }
		
		this.maxParticipantes = maxParticipantes;
	}

	@Override
	public String toString() {
		return "EventoIndividual: " + super.toString() +
				"\n Nivel: " + nivel +
				"\n Max Participantes: " + maxParticipantes;
	}

}
