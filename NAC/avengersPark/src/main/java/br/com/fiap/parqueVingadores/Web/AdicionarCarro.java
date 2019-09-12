package br.com.fiap.parqueVingadores.Web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.parqueVingadores.DAO.CarroDAO;
import br.com.fiap.parqueVingadores.beans.Carro;

@WebServlet(urlPatterns = "/AdicionarCarro")
public class AdicionarCarro extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2869989243332582251L;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CarroDAO cDao = null;
		try {
			
			String placa = req.getParameter("Placa");
			String modelo = req.getParameter("Modelo");
			String marca = req.getParameter("Marca");
			Date d = new Date();
			Carro c = new Carro(placa, modelo, marca, sdf.format(d));
			cDao = new CarroDAO();
			
			int r = cDao.adicionarCarro(c);
			
			if(r > 0) {
				resp.sendRedirect("Selecao.html");
			} else {
				resp.sendRedirect("AdicionarCarro.html?false=" + r);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cDao.encerrar();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
