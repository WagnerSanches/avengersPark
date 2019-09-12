package br.com.fiap.parqueVingadores.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.parqueVingadores.DAO.CarroDAO;
import br.com.fiap.parqueVingadores.DAO.UsuarioDAO;
import br.com.fiap.parqueVingadores.DAO.ValetDAO;
import br.com.fiap.parqueVingadores.beans.Valet;


@WebServlet(urlPatterns = "/pagar")
public class Pagar extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2635685400794643586L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		UsuarioDAO uDao = null;
		out.print("<html><body>");
		
		
		ValetDAO vDAO = null;
		CarroDAO cDAO = null;
		String placa = req.getParameter("placa");
		String entrada = req.getParameter("entrada");
		String saida = req.getParameter("saida");
		String total = req.getParameter("total");
		
		try {
			
			Valet v = new Valet(placa, entrada, saida, Double.parseDouble(total));
			
			if(new ValetDAO().addValet(v) == 1){
				
				if(new CarroDAO().deletCarro(placa) == 1) {
					resp.sendRedirect("Selecao.html");
				}
			} else {
				out.print("<b> ERRO BANCO DE DADOS </b>");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				vDAO.encerrar();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		out.print("</body></html>");
		
	}
}
