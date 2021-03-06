package br.com.caelum;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import br.com.caelum.model.Categoria;
import br.com.caelum.model.Loja;
import br.com.caelum.model.Produto;

@Component
public class CriadorDeProdutos {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private JpaTransactionManager transactionManager;
	
	@PostConstruct
	public void init() {
		TransactionTemplate template = new TransactionTemplate(transactionManager);
		template.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
						
				Loja casaDoCodigo = em.find(Loja.class, 1);
				
				if(casaDoCodigo == null)
				{
					casaDoCodigo = new Loja();
					casaDoCodigo.setNome("Casa do Código");
					em.persist(casaDoCodigo);
				}
							
				Loja musicalAlegre = em.find(Loja.class, 2);
				
				if(musicalAlegre == null)
				{
					musicalAlegre = new Loja();
					musicalAlegre.setNome("Musical Alegre");
					em.persist(musicalAlegre);
				}
							
				Categoria tecnologia = em.find(Categoria.class, 1);
				
				if(tecnologia == null)
				{
					tecnologia = new Categoria("Tecnologia");
					em.persist(tecnologia);
				}
				
				Categoria musica = em.find(Categoria.class, 2);
				
				if(musica == null)
				{
					musica = new Categoria("Música");
					em.persist(musica);
				}
				
				Produto cursoDeViolao = em.find(Produto.class, 1);
				
				if(cursoDeViolao == null)
				{
					cursoDeViolao = new Produto();
					cursoDeViolao.setNome("Curso de Violão");
					cursoDeViolao.setLoja(musicalAlegre);
					cursoDeViolao.setPreco(49.0);
					cursoDeViolao.setDescricao("Estude com os melhores professores e aprenda no seu ritmo, sem sair de casa.");
					List<Categoria> categorias1 = new ArrayList<Categoria>();
					categorias1.add(tecnologia);
					categorias1.add(musica);
					cursoDeViolao.adicionarCategorias(categorias1);
					cursoDeViolao.setLinkDaFoto("https://pbs.twimg.com/profile_images/378800000825434860/12136ee913ed4f44860914d44650144e.png");
					
					em.persist(cursoDeViolao);	
				}
				
				Produto livroDeArquitetura = em.find(Produto.class, 2);
				
				if(livroDeArquitetura == null)
				{
					livroDeArquitetura = new Produto();
					livroDeArquitetura.setNome("Introduçao a Arquitetura Java e Design de projetos com Java");
					livroDeArquitetura.setLoja(casaDoCodigo);
					livroDeArquitetura.setPreco(30.0);
					List<Categoria> categorias2 = new ArrayList<Categoria>();
					categorias2.add(tecnologia);
					categorias2.add(musica);
					livroDeArquitetura.adicionarCategorias(categorias2);
					livroDeArquitetura.setDescricao("Neste livro, os autores, conhecidos especialistas da "
												   + " área, apresentam muitos tópicos que aparecem com frequência"
												   + " na plataforma Java, incluindo desde modelagem e design das "
												   + "classes, até detalhes importantes das tecnologias mais utilizadas."
												   + "  Sempre com uma visão técnica e prática capaz de elucidar muitas "
												   + "questões enfrentadas tanto pelo profissional iniciante quanto por "
												   + "aquele que está adquirindo mais experiência na plataforma.");
					
					livroDeArquitetura.setLinkDaFoto("http://www.arquiteturajava.com.br/img/capa-livro.png");
					
					em.persist(livroDeArquitetura);	
				}
				
				
				Produto livroDeSpring = em.find(Produto.class, 3);
				
				if(livroDeSpring == null)
				{
					livroDeSpring = new Produto();
					livroDeSpring.setNome("Vire o jogo com Spring Framework");
					livroDeSpring.setLoja(casaDoCodigo);
					livroDeSpring.setPreco(30.0);
					List<Categoria> categorias3 = new ArrayList<Categoria>();
					categorias3.add(tecnologia);
					livroDeSpring.adicionarCategorias(categorias3);
					livroDeSpring.setDescricao("Criado para simplificar o desenvolvimento de aplicações Java, "
							+ "o Spring se tornou um dos frameworks de mais destaque dentro desse grande ambiente.  "
							+ "Aprenda muito mais que o básico do Spring, desde o tradicional Container de Inversão "
							+ "de Controle e Injeção de Dependências, passando pelos robustos módulos de segurança, "
							+ "transações, programação orientada a aspectos e também o fantástico módulo MVC, o SpringMVC.");
					
					livroDeSpring.setLinkDaFoto("http://cdn.shopify.com/s/files/1/0155/7645/products/spring-framework-featured_large.png?v=1411567960");
					
					em.persist(livroDeSpring);	
				}
				
				Produto violao = em.find(Produto.class, 4);
				
				if(violao == null)
				{
					violao = new Produto();
					violao.setNome("Violão");
					violao.setLoja(musicalAlegre);
					violao.setDescricao("Excelente violão");
					violao.setPreco(500.0);
					List<Categoria> categorias4 = new ArrayList<Categoria>();
					categorias4.add(musica);
					violao.adicionarCategorias(categorias4);
					violao.setLinkDaFoto("http://www.marillac.g12.br/imgs/atividade%20complementar/violao.jpg");
					
					em.persist(violao);	
				}
				
				Produto flauta = em.find(Produto.class, 5);
				
				if(flauta == null)
				{
					flauta = new Produto();
					flauta.setNome("Flauta Doce");
					flauta.setLoja(musicalAlegre);
					flauta.setDescricao("Flauta doce");
					flauta.setPreco(300.0);
					List<Categoria> categorias5 = new ArrayList<Categoria>();
					categorias5.add(musica);
					flauta.adicionarCategorias(categorias5);
					flauta.setLinkDaFoto("http://i.mlcdn.com.br/1500x1500/flauta-doce-germanicayamaha-yrs-23g-204013000.jpg");
					
					em.persist(flauta);	
				}
				
			}
		});		
	}
	
}
