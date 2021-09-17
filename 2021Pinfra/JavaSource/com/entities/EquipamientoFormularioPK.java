package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EQUIPAMIENTO_FORMULARIO database table.
 * 
 */
@Embeddable
public class EquipamientoFormularioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_FORMULARIO", unique=true, nullable=false, precision=38)
	private long idFormulario;

	@Column(name="ID_EQUIPAMIENTO", insertable=false, updatable=false, unique=true, nullable=false, precision=38)
	private long idEquipamiento;

	public EquipamientoFormularioPK() {
	}
	public long getIdFormulario() {
		return this.idFormulario;
	}
	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}
	public long getIdEquipamiento() {
		return this.idEquipamiento;
	}
	public void setIdEquipamiento(long idEquipamiento) {
		this.idEquipamiento = idEquipamiento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EquipamientoFormularioPK)) {
			return false;
		}
		EquipamientoFormularioPK castOther = (EquipamientoFormularioPK)other;
		return 
			(this.idFormulario == castOther.idFormulario)
			&& (this.idEquipamiento == castOther.idEquipamiento);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idFormulario ^ (this.idFormulario >>> 32)));
		hash = hash * prime + ((int) (this.idEquipamiento ^ (this.idEquipamiento >>> 32)));
		
		return hash;
	}
}