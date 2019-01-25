package controlador;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.compreseucarroaqui.domain.Cliente;


/**
 * Servlet implementation class Controlador
 */
@WebServlet("/controladorcliente")
public class ControladorCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAApp");
	EntityManager em = emf.createEntityManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorCliente() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	this.doPost(req, resp);
    }	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter(); foi util para controlar meus servelets 
		//criar as variáveis
		int idformulario; //1-clientes; 2-cursos; 3-pagamentos.
		int tipoformulario; //1.1-consulta;...
		String cpfmascara;
		long cpf;
		String nome,email;
	
		
		idformulario = Integer.parseInt(request.getParameter("idformulario"));
		tipoformulario = Integer.parseInt(request.getParameter("tipoformulario"));
		EntityTransaction tx = em.getTransaction();
		HttpSession session = request.getSession();
		if(idformulario == 1) //clientes
		{
			switch(tipoformulario)
			{
				case 11: //Consultar Todos
				{
					TypedQuery<Cliente> query = em.createQuery(""
							+ "Select c from Cliente c",Cliente.class);
					List<Cliente> clientes = query.getResultList();
					session.setAttribute("mensagem", "Total de Cliente(s): "+clientes.size());
					session.setAttribute("clientes",clientes);					
					response.sendRedirect("http://localhost:8085/ProjetoWEB/clientes/consultaTodos.jsp");
					break;
				}
				case 12: //Consultar
				{
					cpfmascara = request.getParameter("cpf");
					cpfmascara = cpfmascara.replaceAll("[.-]","");
					cpf = Long.parseLong(cpfmascara);
					Cliente cliente = em.find(Cliente.class,cpf);
					
					if(cliente != null) //cliente encontrado
					{
						session.setAttribute("mensagem", "Cliente "+cpf+" Encontrado!");
						session.setAttribute("cliente",cliente);
					}
					else //cliente não existe
					{
						session.setAttribute("mensagem", "Cliente "+cpf+" Não Encontrado!");
						session.setAttribute("cliente",null);					
					}
					response.sendRedirect("http://localhost:8085/ProjetoWEB/clientes/resultado.jsp");
					break;						
				}
				case 13: //Cadastrar 
				{
					cpfmascara = request.getParameter("cpf");
					cpfmascara = cpfmascara.replaceAll("[.-]","");
					cpf = Long.parseLong(cpfmascara);
					nome = request.getParameter("nome");
					email = request.getParameter("email");
					
					Cliente cliente = new Cliente(cpf,nome,email);
					
					tx.begin();
					em.persist(cliente);
					tx.commit();
					session.setAttribute("mensagem", "Cliente "+cpf+" Cadastrado!");
					session.setAttribute("cliente",cliente);
					response.sendRedirect("http://localhost:8085/ProjetoWEB/clientes/resultado.jsp");
					break;				
				}
				case 14: //Alterar
				{
					cpfmascara = request.getParameter("cpf");
					cpfmascara = cpfmascara.replaceAll("[.-]","");
					cpf = Long.parseLong(cpfmascara);
					nome = request.getParameter("nome");
					email = request.getParameter("email");
					
					Cliente cliente = em.find(Cliente.class,cpf);
					
					if(cliente != null) //cliente encontrado
					{
						cliente = new Cliente(cpf,nome,email);
						tx.begin();
						em.merge(cliente);
						tx.commit();
						
						session.setAttribute("mensagem", "Cliente "+cpf+" Alterado!");
						session.setAttribute("cliente",cliente);
					}
					else //cliente não existe
					{
						session.setAttribute("mensagem", "Cliente "+cpf+" Não Encontrado. Alteração Cancelada!");
						session.setAttribute("cliente",null);					
					}
					response.sendRedirect("http://localhost:8085/ProjetoWEB/clientes/resultado.jsp");				
					break;
				}
				case 15: //Excluir
				{
					cpfmascara = request.getParameter("cpf");
					cpfmascara = cpfmascara.replaceAll("[.-]","");
					cpf = Long.parseLong(cpfmascara);
					
					Cliente cliente = em.find(Cliente.class,cpf);
					
					if(cliente != null) //cliente encontrado
					{
						tx.begin();
						em.remove(cliente);
						tx.commit();
						session.setAttribute("mensagem", "Cliente "+cpf+" Excluído!");						
					}
					else //cliente não existe
						session.setAttribute("mensagem", "Cliente "+cpf+" Não Encontrado. Exclusão Cancelada!");
					session.setAttribute("cliente",null);					
					response.sendRedirect("http://localhost:8085/ProjetoWEB/clientes/resultado.jsp");
					break;						
				}
			}
		}
	}
}
