<%@page import="br.com.fiap.parqueVingadores.beans.Carro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" type="text/css" href="TelaGerenciar.css">
        <title>Avenger's Park - Gerenciar</title>
        <link rel="shortcut icon" href="img/logo.png" type="image/x-icon">
    </head>
    <style>
    	#tabela {
                  width: 100%;
              border-collapse: collapse;
              color: white;
              text-align:center;
            }
              #linhaTb{
            border-bottom: #464646 1px solid; 
    }
      button{
        display: block;
        float: right;
        padding: 5px 15px;
        font-size: 19px;
        margin: 5px;
        cursor: pointer;
    }
    #fundo {
        position: absolute;
        background: #464646a2;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        width: 100%;
        top: 0px;
        left: 0px;
    }
    #tela {
        background: white;
        width: 500px;
        height: 230px;
    }
    #frm_f {
        padding: 30px;
    }
    #frm_f > input{
        margin: 10px 0px;
        font-size: 16px;
        display: block;   
        width: 60%;
        outline: none;

    }
    #frm_f > input[type="submit"]{
        float: right;
        border: 1px solid black;
        background: #464646;
        color: aliceblue;
        cursor: pointer;
        width: 100px;
        padding: 5px;
    }

    
    </style>
    <body>
            <p id="cima"><img src="img/logo2.png" alt="Avengers" height="80px" width="70px" class="imagem"></p>
            <fieldset>
            
                    <div id="texto">
                        <h3>GERENCIAMENTO DE VEICULOS</h3>
                    
                        <div>
                        	
                        		<button id="btn_f">ESCOLHER</button>
                        	
                        		<table id="tabela">
                                <tr id="linhaTb">
                                    <th>PLACA</th>
                                    <th>MODELO</th>
                                    <th>MARCA</th>
                                    <th>ENTRADA</th>
                                    <th>FINALIZAR</th>
                                </tr>
                                
                                <%
                                
                                	List<Carro> lista = (List<Carro>)request.getAttribute("carros");
                                	for(Carro c: lista) {
                                		out.print("<tr>");
                                		out.print("<td>" + c.getPlaca() + "</td>");
                                		out.print("<td>" + c.getModelo() + "</td>");
                                		out.print("<td>" + c.getMarca() + "</td>");
                                		out.print("<td>" + c.getEntrada() + "</td>");
                                		out.print("<td> <input type='radio' name='veiculo' value='carroLinha' required id='slct'> </td>");
                                		out.print("</tr>");
                                	}
                                
                                %>
                                                               
                           	 	</table>
                        
                            
                        
                        </div>
                </fieldset>

                <div id="fundo" style="display: none"> 

                        <div id="tela">
                            <button id="btn_close">FECHAR</button>
                            <form action="calculo" method="post" id="frm_f">

                                <input type="text" name="placa" readonly="true">

                                <input type="text" name="modelo" readonly="true">

                                <input type="text" name="marca" readonly="true">
                                
                                <input type="text" name="entrada" readonly="true">

                                <input type="submit" value="FINALIZAR">
                            </form>

                        </div>

                    </div>
            <footer>
                    <h5>Desenvolvido por S.H.I.E.L.D.&copy; 2019</h5>
            </footer>
    </body>


    <script>
    var carro = document.querySelectorAll("#slct");
        var placa = ""; var modelo ="";var marca = "";var entrada = "";
        for(var i = 0; i < carro.length;i++) {
            carro[i].addEventListener("click", function() {
                placa = this.parentElement.parentElement.children[0].textContent;
                modelo = this.parentElement.parentElement.children[1].textContent;
                marca = this.parentElement.parentElement.children[2].textContent;
                entrada = this.parentElement.parentElement.children[3].textContent;
            })
        }

        var fundo = document.querySelector("#fundo");
        document.querySelector("#btn_f").addEventListener("click", function() {
            document.querySelector("#fundo").style.display = "flex";
            document.querySelector("#frm_f").placa.value = placa;
            document.querySelector("#frm_f").modelo.value = modelo;
            document.querySelector("#frm_f").marca.value = marca;
            document.querySelector("#frm_f").entrada.value = entrada;
        });

        document.querySelector("#btn_close").addEventListener("click", function(){

            fundo.style.display = "none";
        })

    
    </script>
</html>