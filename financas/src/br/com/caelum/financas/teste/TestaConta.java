package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConta {

	public static void main(String[] args) {
		Conta conta1 = new Conta();
		conta1.setAgencia("001");
		conta1.setBanco("Banco do Brasil");
		conta1.setNumero("12345");
		conta1.setTitular("José Simão");
		
		Conta conta2 = new Conta();
		conta2.setAgencia("003");
		conta2.setBanco("Itau");
		conta2.setNumero("4366");
		conta2.setTitular("Cloter");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(conta1);
		em.persist(conta2);
		
		em.getTransaction().commit();
		
		em.close();
	}
}
