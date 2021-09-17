package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FORMULARIOS_CASILLAS database table.
 * 
 */
@Embeddable
public class FormularioCasillaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_FORMULARIO", nullable=false, precision=38)
	private long idFormulario;

	@Column(name="ID_CASILLA", insertable=false, updatable=false, nullable=false, precision=38)
	private long idCasilla;

	public FormularioCasillaPK() {
	}
	public long getIdFormulario() {
		return this.idFormulario;
	}
	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}
	public long getIdCasilla() {
		return this.idCasilla;
	}
	public void setIdCasilla(long idCasilla) {
		this.idCasilla = idCasilla;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FormularioCasillaPK)) {
			return false;
		}
		FormularioCasillaPK castOther = (FormularioCasillaPK)other;
		return 
			(this.idFormulario == castOther.idFormulario)
			&& (this.idCasilla == castOther.idCasilla);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idFormulario ^ (this.idFormulario >>> 32)));
		hash = hash * prime + ((int) (this.idCasilla ^ (this.idCasilla >>> 32)));
		
		return hash;
	}
}