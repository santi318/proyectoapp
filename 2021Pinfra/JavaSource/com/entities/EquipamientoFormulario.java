package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EQUIPAMIENTO_FORMULARIO database table.
 * 
 */
@Entity
@Table(name="EQUIPAMIENTO_FORMULARIO")
@NamedQuery(name="EquipamientoFormulario.findAll", query="SELECT e FROM EquipamientoFormulario e")
public class EquipamientoFormulario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EquipamientoFormularioPK id;

	//bi-directional many-to-one association to InventarioEquipamiento
	@ManyToOne
	@JoinColumn(name="ID_EQUIPAMIENTO", nullable=false, insertable=false, updatable=false)
	private InventarioEquipamiento inventarioEquipamiento;

	public EquipamientoFormulario() {
	}

	public EquipamientoFormularioPK getId() {
		return this.id;
	}

	public void setId(EquipamientoFormularioPK id) {
		this.id = id;
	}

	public InventarioEquipamiento getInventarioEquipamiento() {
		return this.inventarioEquipamiento;
	}

	public void setInventarioEquipamiento(InventarioEquipamiento inventarioEquipamiento) {
		this.inventarioEquipamiento = inventarioEquipamiento;
	}

}