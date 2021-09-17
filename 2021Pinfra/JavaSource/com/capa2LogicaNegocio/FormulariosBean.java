package com.capa2LogicaNegocio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dao.DAOFormulario;
import com.dao.DAOFormularioCasilla;
import com.entities.Formulario;
import com.entities.FormularioCasilla;

/**
 * Session Bean implementation class FormulariosBean
 */
@Stateless
public class FormulariosBean implements FormulariosBeanRemote {

	@PersistenceContext
	private EntityManager em;

	public FormulariosBean() {

	}

	@Override
	public  void insertarFormulario(String nombre, String resumen) throws Exception {

		 DAOFormulario.insertarFormulario(nombre,resumen, em);
		 return;
		
	}

	@Override
	public List<Formulario> listarFormularios() {
		
		return DAOFormulario.listarFormularios(em);
	}

	@Override
	public void eliminarFormulario(Long id) {
		
		DAOFormulario.eliminarFormulario(id, em);
		return;
		
	}

	@Override
	public Formulario buscarFormulario(Long id)  {
		
		
			try {
				return DAOFormulario.find(id, em);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	}
	
	
	@Override
	public void AgregarCasillasFormulario(Formulario form) {
		try {
			//TODO: todo esto se evita si las clases estuvieran bien hechas --> VER
			Formulario formActual = DAOFormulario.find(form.getId(), em);
			List<FormularioCasilla> formulariosCasilla = new ArrayList(formActual.getFormulariosCasillas());
			for (FormularioCasilla formularioCasilla : formulariosCasilla) {
				if(!form.contieneCasilla(formularioCasilla.getCasilla()))
					DAOFormularioCasilla.quitarFormularioCasilla(formularioCasilla, em);
			}
			for (FormularioCasilla formularioCasilla : form.getFormulariosCasillas()) {
				//si no existe lo insertamos
				if(formularioCasilla.getId()==null || 
						DAOFormularioCasilla.find(formularioCasilla.getId().getIdFormulario(), formularioCasilla.getId().getIdCasilla(), em)==null) 
					DAOFormularioCasilla.insertarFormularioCasilla(formularioCasilla, em);	
				//si existe editamos la obligatoriedad
				else
					DAOFormularioCasilla.editarFormularioCasilla(formularioCasilla, em);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void EditarFormulario(Formulario formulario) {
		DAOFormulario.EditarFormulario(formulario, em);
	}

	
	
}
