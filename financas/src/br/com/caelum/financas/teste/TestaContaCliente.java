package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Conta conta = em.find(Conta.class, 2);
			Cliente cliente1 = new Cliente("José Simão","Pedreiro","Rua das Tulipas, 263",conta);
//			Cliente cliente2 = new Cliente("Cloter","Analista","Rua Rodrigo Soares de Oliveira, 263",conta);
			
			em.persist(cliente1);
//			em.persist(cliente2);
		
			em.getTransaction().commit();	
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		
	}
}
