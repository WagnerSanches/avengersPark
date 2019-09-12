package br.com.fiap.parqueVingadores.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.parqueVingadores.DAO.UsuarioDAO;
import br.com.fiap.parqueVingadores.beans.Valet;

@WebServlet(urlPatterns = "/calculo")
public class Calculo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6782378140620551258L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Date entrada = null;
		double total = 0;
		Date saida = null;
		try {
			entrada =  sdf.parse(req.getParameter("entrada"));
			saida = sdf.parse(sdf.format(new Date()));
			total = new Valet().calcularPagamento(entrada, saida);
		} catch(Exception e) {
			e.printStackTrace();
		};
		
		req.setAttribute("placa", req.getParameter("placa"));
		req.setAttribute("modelo", req.getParameter("modelo"));
		req.setAttribute("marca", req.getParameter("marca"));
		req.setAttribute("entrada", sdf.format(entrada));
		req.setAttribute("saida", sdf.format(saida));
		req.setAttribute("total", total);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("valet.jsp");
		
		dispatcher.forward(req, resp);
		
	}
	
	
}

