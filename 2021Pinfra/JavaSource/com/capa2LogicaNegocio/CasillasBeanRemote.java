package com.capa2LogicaNegocio;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Casilla;
import com.entities.TipoDato;
import com.entities.UnidadMedida;

@Remote
public interface CasillasBeanRemote {
	List<Casilla> listarCasillas();
	void altaCasilla(String desc, String param, TipoDato  tipoDato, UnidadMedida unuMedida) throws Exception ;
	TipoDato buscarTipoDatoSele(String nomTipodato);
	UnidadMedida buscarUnidadMedida(String itemSelectUnidad);
	void ModificarCasilla(Long id,String des, String par,UnidadMedida uni, TipoDato tipDato);
	Casilla buscarCasilla(Long idCas);
}
