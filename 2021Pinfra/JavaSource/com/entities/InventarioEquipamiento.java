package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the INVENTARIO_EQUIPAMIENTO database table.
 * 
 */
@Entity
@Table(name="INVENTARIO_EQUIPAMIENTO")
@NamedQuery(name="InventarioEquipamiento.findAll", query="SELECT i FROM InventarioEquipamiento i")
public class InventarioEquipamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INVENTARIO_EQUIPAMIENTO_IDEQUIPAMIENTO_GENERATOR", sequenceName="SEQ_ID_INVENTARIO_EQUIPAMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVENTARIO_EQUIPAMIENTO_IDEQUIPAMIENTO_GENERATOR")
	@Column(name="ID_EQUIPAMIENTO", unique=true, nullable=false, precision=38)
	private long idEquipamiento;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to EquipamientoFormulario
	@OneToMany(mappedBy="inventarioEquipamiento")
	private List<EquipamientoFormulario> equipamientoFormularios;

	public InventarioEquipamiento() {
	}

	public long getIdEquipamiento() {
		return this.idEquipamiento;
	}

	public void setIdEquipamiento(long idEquipamiento) {
		this.idEquipamiento = idEquipamiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<EquipamientoFormulario> getEquipamientoFormularios() {
		return this.equipamientoFormularios;
	}

	public void setEquipamientoFormularios(List<EquipamientoFormulario> equipamientoFormularios) {
		this.equipamientoFormularios = equipamientoFormularios;
	}

	public EquipamientoFormulario addEquipamientoFormulario(EquipamientoFormulario equipamientoFormulario) {
		getEquipamientoFormularios().add(equipamientoFormulario);
		equipamientoFormulario.setInventarioEquipamiento(this);

		return equipamientoFormulario;
	}

	public EquipamientoFormulario removeEquipamientoFormulario(EquipamientoFormulario equipamientoFormulario) {
		getEquipamientoFormularios().remove(equipamientoFormulario);
		equipamientoFormulario.setInventarioEquipamiento(null);

		return equipamientoFormulario;
	}

}