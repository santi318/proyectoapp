package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIPOS_DATOS database table.
 * 
 */
@Entity
@Table(name="TIPOS_DATOS")
@NamedQuery(name="TipoDato.findAll", query="SELECT t FROM TipoDato t")
public class TipoDato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOS_DATOS_IDTIPODATO_GENERATOR", sequenceName="SEQ_ID_TIPO_DATO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOS_DATOS_IDTIPODATO_GENERATOR")
	@Column(name="ID_TIPO_DATO", unique=true, nullable=false, precision=38)
	private long idTipoDato;

	@Column(name="TIPO_DATO", nullable=false, length=50 , unique=true)
	private String tipoDato;

	//bi-directional many-to-one association to Casilla
	@OneToMany(mappedBy="tiposDato")
	private List<Casilla> casillas;

	public TipoDato() {
	}

	public long getIdTipoDato() {
		return this.idTipoDato;
	}

	public void setIdTipoDato(long idTipoDato) {
		this.idTipoDato = idTipoDato;
	}

	public String getTipoDato() {
		return this.tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public List<Casilla> getCasillas() {
		return this.casillas;
	}

	public void setCasillas(List<Casilla> casillas) {
		this.casillas = casillas;
	}

	public Casilla addCasilla(Casilla casilla) {
		getCasillas().add(casilla);
		casilla.setTiposDato(this);

		return casilla;
	}

	public Casilla removeCasilla(Casilla casilla) {
		getCasillas().remove(casilla);
		casilla.setTiposDato(null);

		return casilla;
	}

	@Override
	public String toString() {
		return "TipoDato idTipoDato=" + idTipoDato + ", tipoDato=" + tipoDato + ", casillas=" + casillas + " ";
	}
	
	

}