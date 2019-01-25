package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import br.com.compreseucarroaqui.domain.Pagamento;
import br.com.compreseucarroaqui.domain.PagamentoId;


/**
 * Servlet implementation class Controlador
 */
@WebServlet("/controladorpagamento")
public class ControladorPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAApp");
	EntityManager em = emf.createEntityManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorPagamento() {
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
		long cpf,chassi;
		String datadasaida;
	
		
		idformulario = Integer.parseInt(request.getParameter("idformulario"));
		tipoformulario = Integer.parseInt(request.getParameter("tipoformulario"));
		EntityTransaction tx = em.getTransaction();
		HttpSession session = request.getSession();
		if(idformulario == 3) //pagamentos
			{
				switch(tipoformulario)
				{
					case 31: //Consultar Todos
					{
						TypedQuery<Pagamento> query = em.createQuery(""
								+ "Select p from Pagamento p",Pagamento.class);
						List<Pagamento> pagamentos = query.getResultList();
						session.setAttribute("mensagem", "Total de Pagamento(s): "+pagamentos.size());
						session.setAttribute("pagamentos",pagamentos);					
						response.sendRedirect("pagamentos/consultaTodos.jsp");
						break;
					}
					case 32: //Consultar
					{
						cpfmascara = request.getParameter("cpf");
						cpfmascara = cpfmascara.replaceAll("[.-]","");
						cpf = Long.parseLong(cpfmascara);
						chassi = Long.parseLong(request.getParameter("chassi"));
						//out.println("<h2> Pagamentos => Consultar =>"+cpf+"-"+chassi);	
						
						PagamentoId pgtoid = new PagamentoId (chassi, cpf);
						Pagamento pagamento = em.find(Pagamento.class,pgtoid);
						
						if(pagamento != null) //curso encontrado
						{
							session.setAttribute("mensagem", "Pagamento "+cpf+" "+chassi+" Encontrado!");
							session.setAttribute("pagamento",pagamento);
						}
						else //curso não existe
						{
							session.setAttribute("mensagem", "Pagamento "+cpf+" "+chassi+" Não Encontrado!");
							session.setAttribute("pagamento",null);					
						}
						response.sendRedirect("pagamentos/resultado.jsp");					
						break;						
					}
					case 33: //Cadastrar 
					{
						cpfmascara = request.getParameter("cpf");
						cpfmascara = cpfmascara.replaceAll("[.-]","");
						cpf = Long.parseLong(cpfmascara);
						chassi = Long.parseLong(request.getParameter("chassi"));
						datadasaida = request.getParameter("datadasaida");
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate date = LocalDate.parse(datadasaida,formatter);
						DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						
						PagamentoId pgtoid = new PagamentoId (chassi, cpf);
						Pagamento pagamento = new Pagamento(pgtoid,fmt.format(date));
						tx.begin();
						em.persist(pagamento);
						tx.commit();
						session.setAttribute("mensagem", "Pagamento "+cpf+" "+chassi+" Cadastrado!");
						session.setAttribute("pagamento",pagamento);
						response.sendRedirect("pagamentos/resultado.jsp");					
						break;					
					}
					case 34: //Alterar
					{
						cpfmascara = request.getParameter("cpf");
						cpfmascara = cpfmascara.replaceAll("[.-]","");
						cpf = Long.parseLong(cpfmascara);
						chassi = Long.parseLong(request.getParameter("chassi"));
						datadasaida = request.getParameter("datadasaida");
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate date = LocalDate.parse(datadasaida,formatter);
						DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						
						PagamentoId pgtoid = new PagamentoId (chassi, cpf);
						Pagamento pagamento = new Pagamento(pgtoid,datadasaida);
						pagamento = em.find(Pagamento.class,pgtoid);
						
						if(pagamento != null) //pagamento encontrado
						{
							pagamento = new Pagamento(pgtoid,fmt.format(date));
							tx.begin();
							em.merge(pagamento);
							tx.commit();
							
							session.setAttribute("mensagem", "Pagamento "+cpf+" "+chassi+" Alterado!");
							session.setAttribute("pagamento",pagamento);
						}
						else //curso não existe
						{
							session.setAttribute("mensagem", "Pagamento "+cpf+" "+chassi+" Não Encontrado. Alteração Cancelada!");
							session.setAttribute("pagamento",null);					
						}
						response.sendRedirect("pagamentos/resultado.jsp");	
						break;
					}
					case 35: //Excluir
					{
						cpfmascara = request.getParameter("cpf");
						cpfmascara = cpfmascara.replaceAll("[.-]","");
						cpf = Long.parseLong(cpfmascara);
						chassi = Long.parseLong(request.getParameter("chassi"));
						
						PagamentoId pgtoid = new PagamentoId (chassi, cpf);
						Pagamento pagamento = em.find(Pagamento.class,pgtoid);
						
						if(pagamento != null) //pagamento encontrado
						{
							tx.begin();
							em.remove(pagamento);
							tx.commit();
							session.setAttribute("mensagem", "Pagamento "+cpf+" "+chassi+" Excluído!");						
						}
						else //cliente não existe
							session.setAttribute("mensagem", "Pagamento "+cpf+" "+chassi+" Não Encontrado. Exclusão Cancelada!");
						session.setAttribute("pagamento",null);					
						response.sendRedirect("pagamentos/resultado.jsp");						
						break;						
					}
				}
			}
			
		}
	
	}
