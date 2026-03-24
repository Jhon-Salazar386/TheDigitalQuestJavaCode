package model;

public class EventoGrupal extends EventoDeportivo{
	
	private String nombreEquipo;
	private int numeroParticipantes;
	private static int contadorEventosGrupales;
	
	public EventoGrupal() {
		super();

	}
	
	public EventoGrupal(int id, String tipoEvento, String descripcion, int edadReq, String requisitos, String nombreEquipo, int numeroParticipantes) {
		super(id, tipoEvento, "Grupal", descripcion, edadReq, requisitos);
		setNombreEquipo(nombreEquipo);
		setNumeroParticipantes(numeroParticipantes);
	}
	
	public EventoGrupal(String tipoEvento, String descripcion, int edadReq, String requisitos, String nombreEquipo, int numeroParticipantes) {
		super(tipoEvento, "Grupal", descripcion, edadReq, requisitos);
		setNombreEquipo(nombreEquipo);
		setNumeroParticipantes(numeroParticipantes);
		contadorEventosGrupales++;
	}
	
	public int getContadorEventosGrupales() {
		return contadorEventosGrupales;
	}
	
	public String iniciarEvento() {
		return "El evento grupal esta por comenzar";
	}
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
	public int getNumeroParticipantes() {
		return numeroParticipantes;
	}
	
	public void setNumeroParticipantes(int numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}
	
	@Override
	public String toString() {
		return "EventoGrupal: " + 
				super.toString() +
				"\n Nombre de equipo: " + nombreEquipo +
				"\n numero de Participantes: " + numeroParticipantes;
	}
	
}