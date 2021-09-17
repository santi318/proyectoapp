package com.capa2LogicaNegocio;

import java.util.List;
import javax.ejb.Remote;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Localidad;
import com.entities.MetodoMuestreo;
import com.entities.TipoDato;
import com.entities.TipoMuestreo;
import com.entities.UnidadMedida;
import com.entities.Zona;

@Remote
public interface GeneralBeanRemote {
	List<MetodoMuestreo> obtenerMetodosMuestreo();
	List<EstacionMuestreo> obtenerEstacionMuestreo();
	List<Departamento> obtenerDepartamentos();
	List<Zona> listarZonas();
	List<TipoMuestreo> listarTipoMuestros();
	List<Localidad> listarLocalidades();
	List<TipoDato> listarTipoDatos();
	List<UnidadMedida> listarUniMed();
}
