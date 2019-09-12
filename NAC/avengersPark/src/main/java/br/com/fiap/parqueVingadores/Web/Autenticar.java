package br.com.fiap.parqueVingadores.Web;
import br.com.fiap.parqueVingadores.DAO.UsuarioDAO;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.parqueVingadores.beans.Usuario;

@WebServlet(urlPatterns = "/autenticar")
public class Autenticar extends HttpServlet{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 6681918802970159585L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		UsuarioDAO uDao = null;
		out.print("<html><body>");
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario u = new Usuario(nome, email, senha);
		
		try {
			uDao = new UsuarioDAO();	
			boolean r = uDao.verificarUsuario(u);
			
			if(r){
				resp.sendRedirect("Selecao.html");
				
			} else {
				resp.sendRedirect("index.html?erro=email?"+r);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				uDao.encerrar();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		out.print("</body></html>");
		out.flush();
		out.close();
	
	}
	
	
}
