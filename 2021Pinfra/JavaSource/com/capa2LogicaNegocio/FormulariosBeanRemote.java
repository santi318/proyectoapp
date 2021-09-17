package com.capa2LogicaNegocio;

import java.util.List;

import javax.ejb.Remote;
import com.entities.*;


@Remote
public interface FormulariosBeanRemote {
	void insertarFormulario(String nombre, String resumen) throws Exception;
	List<Formulario> listarFormularios();
	void eliminarFormulario(Long id);
	Formulario buscarFormulario(Long id);
	void AgregarCasillasFormulario(Formulario formulario);
	void EditarFormulario(Formulario formulario);
}
