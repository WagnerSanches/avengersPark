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
import br.com.fiap.parqueVingadores.beans.Carro;


@WebServlet(urlPatterns = "/ListaCarros")
public class FazerLista extends HttpServlet{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1929675667973509814L;

	@Override

	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CarroDAO dao = null;
		try {
			List<Carro> carros = new CarroDAO().getCarros();
			
			req.setAttribute("carros", carros);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("GerenciarCarros.jsp");
			
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
