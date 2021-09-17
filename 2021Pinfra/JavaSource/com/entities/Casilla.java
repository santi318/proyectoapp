package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CASILLAS database table.
 * 
 */
@Entity
@Table(name="CASILLAS")
@NamedQuery(name="Casilla.findAll", query="SELECT c FROM Casilla c")
public class Casilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CASILLAS_IDCASILLA_GENERATOR", sequenceName="SEQ_ID_CASILLA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CASILLAS_IDCASILLA_GENERATOR")
	@Column(name="ID_CASILLA", unique=true, nullable=false, precision=38)
	private long idCasilla;

	@Column(nullable=false, length=150)
	private String descripcion;

	@Column(nullable=false, length=100)
	private String parametro;

	//bi-directional many-to-one association to TipoDato
	@ManyToOne
	@JoinColumn(name="ID_TIPO_DATO", nullable=false)
	private TipoDato tiposDato;

	//bi-directional many-to-one association to UnidadMedida
	@ManyToOne
	@JoinColumn(name="ID_UNIDAD_MEDIDA", nullable=false)
	private UnidadMedida unidadesMedida;

	//bi-directional many-to-one association to FormularioCasilla
	@OneToMany(mappedBy="casilla")
	private List<FormularioCasilla> formulariosCasillas;

	public Casilla() {
	}

	public long getIdCasilla() {
		return this.idCasilla;
	}

	public void setIdCasilla(long idCasilla) {
		this.idCasilla = idCasilla;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getParametro() {
		return this.parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public TipoDato getTiposDato() {
		return this.tiposDato;
	}

	public void setTiposDato(TipoDato tiposDato) {
		this.tiposDato = tiposDato;
	}

	

	public UnidadMedida getUnidadesMedida() {
		return this.unidadesMedida;
	}

	public void setUnidadesMedida(UnidadMedida unidadesMedida) {
		this.unidadesMedida = unidadesMedida;
	}

	public List<FormularioCasilla> getFormulariosCasillas() {
		return this.formulariosCasillas;
	}

	public void setFormulariosCasillas(List<FormularioCasilla> formulariosCasillas) {
		this.formulariosCasillas = formulariosCasillas;
	}

	public FormularioCasilla addFormulariosCasilla(FormularioCasilla formulariosCasilla) {
		getFormulariosCasillas().add(formulariosCasilla);
		formulariosCasilla.setCasilla(this);

		return formulariosCasilla;
	}

	public FormularioCasilla removeFormulariosCasilla(FormularioCasilla formulariosCasilla) {
		getFormulariosCasillas().remove(formulariosCasilla);
		formulariosCasilla.setCasilla(null);

		return formulariosCasilla;
	}

	@Override
	public String toString() {
		return "Casilla idCasilla=" + idCasilla + ", descripcion=" + descripcion + ", parametro=" + parametro
				+ ", tiposDato=" + tiposDato + ", unidadesMedida=" + unidadesMedida + ", formulariosCasillas="
				+ formulariosCasillas + " ";
	}

	
}