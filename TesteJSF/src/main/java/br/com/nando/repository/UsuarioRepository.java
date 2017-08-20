package br.com.nando.repository;

import java.io.Serializable;

import javax.persistence.Query;

import br.com.nando.model.UsuarioModel;
import br.com.nando.repository.entity.UsuarioEntity;
import br.com.nando.uteis.Uteis;

public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	public UsuarioEntity validaUsuario(UsuarioModel usuarioModel){
		 
		try {
 
			//QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser) 	
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");
 
			//PARÂMETROS DA QUERY
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());
 
			//RETORNA O USUÁRIO SE FOR LOCALIZADO
			return (UsuarioEntity)query.getSingleResult();
 
		} catch (Exception e) {
 
			return null;
		}
 
 
 
	}
}
