package br.com.fiap.parqueVingadores.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.parqueVingadores.DAO.CarroDAO;
import br.com.fiap.parqueVingadores.DAO.ValetDAO;
import br.com.fiap.parqueVingadores.beans.Carro;
import br.com.fiap.parqueVingadores.beans.Valet;


@WebServlet(urlPatterns = "/relatorio")
public class relatorio extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4054916495523941351L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ValetDAO dao = null;
		try {
			List<Valet> valets = new ValetDAO().getValets();
			
			req.setAttribute("valets", valets);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("relatorio.jsp");
			
			dispatcher.forward(req, resp);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dao.encerrar();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	}
}
