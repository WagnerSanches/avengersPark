<%@page import="br.com.fiap.parqueVingadores.beans.Valet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<style>
body {
    background-image: url("img/logo4.png");
    background-size: 90px 100px;
    background-color: #464646;
    height: 100vh;
    position: relative;
    margin: 0px;
}
#cima{
    background: #2b2b2b;
    margin: 0px;
    text-align: center;
} #cima > img {
    height: 90%;
}
footer{
    color: white;
    margin:0px;
    text-align: center;
    width: 100%;
    position: absolute;
    bottom: 0px;
    padding: 10px 0px;
    background-color: #2b2b2b;
}
#tela {
    width: 80%;
    margin: 10px auto;
    margin-top: 50px;
    background: #2b2b2b;
    padding: 30px 0px;
    overflow-y: scroll;
} #tela > h3 {
    text-align: center;
    color: white;
}
#tabela {
    color: white;
    border-collapse: collapse;
    width: 100%;
    text-align: center;
}


</style>

<body>
    <p id="cima"><img src="img/logo2.png" alt="Avengers" height="80px" width="70px" class="imagem"></p>

    
            
                <div id="tela">
                       
                    <h3>RELATORIO</h3>
          
                    <table id="tabela">
                    <tr id="linhaTb">
                        <th>ENTRADA</th>
                        <th>SAIDA</th>
                        <th>PRECO</th>
                        <th>VEICULO</th>
                    </tr>
                  	<%
               
                        List<Valet> lista = (List<Valet>)request.getAttribute("valets");
                  	
                        for(Valet v: lista) {
                            out.print("<tr>");
                            out.print("<td>" + v.getEntrada() + "</td>");
                            out.print("<td>" + v.getSaida() + "</td>");
                            out.print("<td>" + v.getPreco() + "</td>");
                            out.print("<td>" + v.getVeiculo() + "</td>");
                            out.print("</tr>");
                        }
                    
                    %>
                    
                                                    
                    </table>

                </div>
    <footer>
            <h5>Desenvolvido por S.H.I.E.L.D.&copy; 2019</h5>
        </footer>
</body>
</html>