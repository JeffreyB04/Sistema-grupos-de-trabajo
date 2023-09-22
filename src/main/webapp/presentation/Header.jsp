<%@ page import="com.mycompany.proyecto01prograiv.logic.Estudiante" %>
<% Estudiante estudiante = (Estudiante) session.getAttribute("estudiante"); %>


<header>
    <div class="logo">
        <a href="presentation/Index.jsp"><img class="imglogo" src="images/logo.png"></a>
        <div class="agregar" style="width: 70%;" >
            <ul style="width: 110%;"> 
                <li>
                    <a href="presentation/Index.jsp">Inicio</a>
                </li>
                <% if (usuario!=null){ %>                     
                    <li >
                       
                        <ul>  <!--submenu --> </ul>
                    </li> 

                    <li class="logout" style="display: inline-block;">
                        <a  href="presentation/login/logout" >Logout</a>
                    </li>                
                <% } %>
                
                <% if (estudiante==null){%>
                    <li>
                       
                    </li>
                <% }%>             
            </ul>
        </div>
    </div> 
                   
    <% if (estudiante!=null){ %>       
   
</header>          

