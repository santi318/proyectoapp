package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Formulario
 *
 */
@Entity

public class Formulario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="FORMULARIOS_IDFORMULARIO_GENERATOR", sequenceName="SEQ_ID_FORMULARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORMULARIOS_IDFORMULARIO_GENERATOR")
	@Column(name="ID_FORMULARIO", unique=true, nullable=false, precision=38)
	private Long id;
	
	@Column(length = 40)
	private String nombre;
	
	@Column(length = 40)
	private String resumen;
	
	@Column(length=1)
	private Long status;
	
	//bi-directional many-to-one association to FormularioCasilla
	@OneToMany(mappedBy="formulario", fetch = FetchType.EAGER)
	private List<FormularioCasilla> formulariosCasillas;
	
	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="formulario")
	private List<Actividad> actividades;
	
	public Formulario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Formulario id=" + id + ", nombre=" + nombre + ", resumen=" + resumen + ", status=" + status;
	}
   
	public List<FormularioCasilla> getFormulariosCasillas(){
		if(this.formulariosCasillas!=null) {
			this.formulariosCasillas.sort(new Comparator<FormularioCasilla>() {
		        @Override
		        public int compare(FormularioCasilla form1, FormularioCasilla form2)
		        {
		            return  Long.compare(form1.getCasilla().getIdCasilla(), form2.getCasilla().getIdCasilla());
		        }
		    });
		}
		return this.formulariosCasillas;
	}
	
	public void getFormulariosCasillas(List<FormularioCasilla> formulariosCasillas){
		this.formulariosCasillas = formulariosCasillas;
	}
	
	public boolean contieneCasilla(Casilla casilla) {
		if(this.formulariosCasillas!=null) {
		    for(FormularioCasilla fc : this.formulariosCasillas) {
		        if(fc != null && fc.getCasilla().getIdCasilla()==casilla.getIdCasilla()) {
		            return true;
		        }
		    }
		}
	    return false;
	}
	
	public void agregarCasilla(Casilla casilla, boolean esObligatorio) {
		FormularioCasilla fCasilla = new FormularioCasilla();
		FormularioCasillaPK FCPK = new FormularioCasillaPK();
		FCPK.setIdCasilla(casilla.getIdCasilla());
		FCPK.setIdFormulario(this.id);
		fCasilla.setId(FCPK);
		fCasilla.setCasilla(casilla);
		fCasilla.setFormulario(this);
		fCasilla.setEsObligatorio(esObligatorio);
		formulariosCasillas.add(fCasilla);
	}
	
	public void quitarFormularioCasilla(FormularioCasilla formularioCasilla) {
		formulariosCasillas.remove(formularioCasilla);
	}
	
	public void quitarTodasLasCasillas() {
		formulariosCasillas = new ArrayList<FormularioCasilla>();
	}
}
