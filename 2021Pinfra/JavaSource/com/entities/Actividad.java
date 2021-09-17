package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ACTIVIDADES database table.
 * 
 */
@Entity
@Table(name="ACTIVIDADES")
@NamedQuery(name="Actividad.findAll", query="SELECT a FROM Actividad a")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@Id
	@SequenceGenerator(name="ACTIVIDADES_IDACTIVIDAD_GENERATOR", sequenceName="SEQ_ID_ACTIVIDAD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTIVIDADES_IDACTIVIDAD_GENERATOR")
	@Column(name="ID_ACTIVIDAD", unique=true, nullable=false, precision=38)
	private long idActividad;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	@Column(name="GEO_LATITUD", nullable=false, length=50)
	private String geoLatitud;

	@Column(name="GEO_LONGITUD", nullable=false, length=50)
	private String geoLongitud;

	@Column(name="NOMBRE_ACTIVIDAD", nullable=false, length=100)
	private String nombreActividad;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="ID_DEPARTAMENTO", nullable=false)
	private Departamento departamento;

	//bi-directional many-to-one association to EstacionMuestreo
	@ManyToOne
	@JoinColumn(name="ID_ESTACION_MUESTREO", nullable=false)
	private EstacionMuestreo estacionesMuestreo;

	//bi-directional many-to-one association to Localidad
	@ManyToOne
	@JoinColumn(name="ID_LOCALIDAD", nullable=false)
	private Localidad localidade;

	//bi-directional many-to-one association to MetodoMuestreo
	@ManyToOne
	@JoinColumn(name="ID_METODO_MUESTREO", nullable=false)
	private MetodoMuestreo metodosMuestreo;

	//bi-directional many-to-one association to TipoMuestreo
	@ManyToOne
	@JoinColumn(name="ID_TIPO_MUESTREO", nullable=false)
	private TipoMuestreo tiposMuestreo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO_DISENADOR", nullable=false)
	private UsuarioEmpresa usuario;

	//bi-directional many-to-one association to Zona
	@ManyToOne
	@JoinColumn(name="ID_ZONA", nullable=false)
	private Zona zona;
	
	//bi-directional many-to-one association to Formulario
	@ManyToOne
	@JoinColumn(name="ID_FORMULARIO", nullable=false)
	private Formulario formulario;

	public Actividad() {
	}

	public long getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(long idActividad) {
		this.idActividad = idActividad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getGeoLatitud() {
		return this.geoLatitud;
	}

	public void setGeoLatitud(String geoLatitud) {
		this.geoLatitud = geoLatitud;
	}

	public String getGeoLongitud() {
		return this.geoLongitud;
	}

	public void setGeoLongitud(String geoLongitud) {
		this.geoLongitud = geoLongitud;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public EstacionMuestreo getEstacionesMuestreo() {
		return this.estacionesMuestreo;
	}

	public void setEstacionesMuestreo(EstacionMuestreo estacionesMuestreo) {
		this.estacionesMuestreo = estacionesMuestreo;
	}

	public Localidad getLocalidade() {
		return this.localidade;
	}

	public void setLocalidade(Localidad localidade) {
		this.localidade = localidade;
	}

	public MetodoMuestreo getMetodosMuestreo() {
		return this.metodosMuestreo;
	}

	public void setMetodosMuestreo(MetodoMuestreo metodosMuestreo) {
		this.metodosMuestreo = metodosMuestreo;
	}

	public TipoMuestreo getTiposMuestreo() {
		return this.tiposMuestreo;
	}

	public void setTiposMuestreo(TipoMuestreo tiposMuestreo) {
		this.tiposMuestreo = tiposMuestreo;
	}

	public UsuarioEmpresa getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioEmpresa usuario) {
		this.usuario = usuario;
	}

	public Zona getZona() {
		return this.zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	@Override
	public String toString() {
		return "Actividad idActividad=" + idActividad + ", fecha=" + fecha + ", geoLatitud=" + geoLatitud
				+ ", geoLongitud=" + geoLongitud + ", nombreActividad=" + nombreActividad + ", departamento="
				+ departamento + ", estacionesMuestreo=" + estacionesMuestreo + ", localidade=" + localidade
				+ ", metodosMuestreo=" + metodosMuestreo + ", tiposMuestreo=" + tiposMuestreo + ", usuario=" + usuario
				+ ", zona=" + zona + ", formulario=" + formulario + " ";
	}

	
	
	
}