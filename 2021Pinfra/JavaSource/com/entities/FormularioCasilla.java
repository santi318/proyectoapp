package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FORMULARIOS_CASILLAS database table.
 * 
 */
@Entity
@Table(name="FORMULARIOS_CASILLAS")
//@NamedQuery(name="FormularioCasilla.findAll", query="SELECT f FROM FormularioCasilla f")
public class FormularioCasilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FormularioCasillaPK id;

	@Column(name="ES_OBLIGATORIO", nullable=false, precision=38)
	private boolean esObligatorio;
	
	//bi-directional many-to-one association to Formulario
	@ManyToOne
	@JoinColumn(name="ID_Formulario", nullable=false, insertable=false, updatable=false)
	private Formulario formulario;

	//bi-directional many-to-one association to Casilla
	@ManyToOne
	@JoinColumn(name="ID_CASILLA", nullable=false, insertable=false, updatable=false)
	private Casilla casilla;

	public FormularioCasilla() {
	}

	public FormularioCasillaPK getId() {
		return this.id;
	}

	public void setId(FormularioCasillaPK id) {
		this.id = id;
	}

	public boolean getEsObligatorio() {
		return this.esObligatorio;
	}

	public void setEsObligatorio(boolean esObligatorio) {
		this.esObligatorio = esObligatorio;
	}

	public Casilla getCasilla() {
		return this.casilla;
	}

	public void setCasilla(Casilla casilla) {
		this.casilla = casilla;
	}
	
	public Formulario getFormulario() {
		return this.formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

}