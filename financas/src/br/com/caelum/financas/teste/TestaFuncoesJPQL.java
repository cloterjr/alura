package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaFuncoesJPQL {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(2);
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta";
		
		Query query = em.createQuery(jpql);
		
		query.setParameter("pConta", conta);
		
		BigDecimal valor = (BigDecimal)query.getSingleResult();
		System.out.println("Valor: "  + valor);
//		List<Conta> contas = query.getResultList();
//		
//		for (Conta c : contas) {
//			for (Movimentacao m : c.getMovimentacoes()) {
//				System.out.println("Valor: " + m.getValor());
//			}
//		}
		
		em.getTransaction().commit();
		
		em.close();
	}
}
