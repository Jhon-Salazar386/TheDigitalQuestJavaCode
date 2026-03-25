package model;

public class EventoGrupal extends EventoDeportivo {

	private String nombreEquipo;
	private int numeroParticipantes;
	public static int contadorEventosGrupales;

	public EventoGrupal() {
		super();
		contadorEventosGrupales++;

	}

	// Constructor usado para metodos de consulta
	public EventoGrupal(int id, String tipoEvento, String descripcion, int edadReq, String requisitos,
			String nombreEquipo, int numeroParticipantes) {
		super(id, tipoEvento, "Grupal", descripcion, edadReq, requisitos);
		setNombreEquipo(nombreEquipo);
		setNumeroParticipantes(numeroParticipantes);
	}

	// Constructor usado para metodos de insercion
	public EventoGrupal(String tipoEvento, String descripcion, int edadReq, String requisitos, String nombreEquipo,
			int numeroParticipantes) {
		super(tipoEvento, "Grupal", descripcion, edadReq, requisitos);
		setNombreEquipo(nombreEquipo);
		setNumeroParticipantes(numeroParticipantes);
		contadorEventosGrupales++;
	}

	@Override
	public String iniciarEvento() {
		return "El evento grupal esta por comenzar";
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		
	    if (nombreEquipo == null || nombreEquipo.isBlank()) {
	        throw new IllegalArgumentException("El nombre del equipo no puede estar vacío");
	    }
		
		this.nombreEquipo = nombreEquipo;
	}

	public int getNumeroParticipantes() {
		return numeroParticipantes;
	}

	public void setNumeroParticipantes(int numeroParticipantes) {
		
	    if (numeroParticipantes <= 0) {
	        throw new IllegalArgumentException("Debe haber al menos un participante");
	    }
		
		this.numeroParticipantes = numeroParticipantes;
	}

	@Override
	public String toString() {
		return "EventoGrupal: " + super.toString() +
				"\n Nombre de equipo: " + nombreEquipo +
				"\n numero de Participantes: " + numeroParticipantes;
	}

}