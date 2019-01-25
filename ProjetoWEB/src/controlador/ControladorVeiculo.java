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

import br.com.compreseucarroaqui.domain.Veiculo;


/**
 * Servlet implementation class Controlador
 */
@WebServlet("/controladorveiculo")
public class ControladorVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAApp");
	EntityManager em = emf.createEntityManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorVeiculo() {
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
	//	PrintWriter out = response.getWriter(); teste
		//criar as variáveis
		int idformulario; //1-clientes; 2-veiculos; 3-pagamentos.
		int tipoformulario; //1.1-consulta;...
		String chassi,modelo,valor;
		
		
		
		
		
		idformulario = Integer.parseInt(request.getParameter("idformulario"));
		tipoformulario = Integer.parseInt(request.getParameter("tipoformulario"));
		EntityTransaction tx = em.getTransaction();
		HttpSession session = request.getSession();
		if(idformulario == 2) //veiculo
			{
				switch(tipoformulario)
				{
					case 21: //Consultar Todos
					{
						TypedQuery<Veiculo> query = em.createQuery(""
								+ "Select c from Veiculo c",Veiculo.class);
						List<Veiculo> veiculos = query.getResultList();
						session.setAttribute("mensagem", "Total de Veiculo(s): "+veiculos.size());
						session.setAttribute("veiculos",veiculos);					
						response.sendRedirect("http://localhost:8085/ProjetoWEB/veiculos/consultaTodos.jsp");
						break;
					}
					case 22: //Consultar
					{
						chassi = request.getParameter("chassi");
						Veiculo veiculo = em.find(Veiculo.class,chassi);
						
						if(veiculo != null) //veiculo encontrado
						{
							session.setAttribute("mensagem", "Veiculo "+chassi+" Encontrado!");
							session.setAttribute("veiculo",veiculo);
						}
						else //veiculo não existe
						{
							session.setAttribute("mensagem", "Veiculo "+chassi+" Não Encontrado!");
							session.setAttribute("veiculo",null);					
						}
						response.sendRedirect("veiculos/resultado.jsp");
						break;						
					}
					case 23: //Cadastrar 
					{
						
						chassi = request.getParameter("chassi");
						modelo = request.getParameter("modelo");
						valor = request.getParameter("valor");
			
						
						Veiculo veiculo = new Veiculo(modelo, chassi, valor);
						tx.begin();
						em.persist(veiculo);
						tx.commit();
						session.setAttribute("mensagem", "veiculo "+chassi+" Cadastrado!");
						session.setAttribute("veiculo",veiculo);
						response.sendRedirect("veiculos/resultado.jsp");
						break;					
					}
					case 24: //Alterar
					{

						modelo = request.getParameter("modelo");
						chassi = request.getParameter("chassi");
						valor = request.getParameter("valor");
					
						
						Veiculo veiculo = em.find(Veiculo.class,chassi);
						
						if(veiculo != null) //veiculo encontrado
						{
							veiculo = new Veiculo(modelo, chassi, valor);
							tx.begin();
							em.merge(veiculo);
							tx.commit();
							
							session.setAttribute("mensagem", "veiculo "+chassi+" Alterado!");
							session.setAttribute("veiculo",veiculo);
						}
						else //veiculo não existe
						{
							session.setAttribute("mensagem", "veiculo "+chassi+" Não Encontrado. Alteração Cancelada!");
							session.setAttribute("veiculo",null);					
						}
						response.sendRedirect("veiculos/resultado.jsp");	
						break;
					}
					case 25: //Excluir
					{
						chassi = request.getParameter("chassi");
						
						Veiculo veiculo = em.find(Veiculo.class,chassi);
						if(veiculo != null) //veiculo encontrado
						{
							tx.begin();
							em.remove(veiculo);
							tx.commit();
							session.setAttribute("mensagem", "veiculo "+chassi+" Excluído!");						
						}
						else //cliente não existe
							session.setAttribute("mensagem", "veiculo "+chassi+" Não Encontrado. Exclusão Cancelada!");
						session.setAttribute("veiculo",null);					
						response.sendRedirect("veiculos/resultado.jsp");
					
						break;						
					}
				}
			}
	}
}