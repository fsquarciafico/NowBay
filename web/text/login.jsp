<%-- 
    Document   : login
    Created on : 13-giu-2018, 19.09.25
    Author     : Ferdinando
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
        <title>Just Vintage</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link rel="shortcut icon" href="css/images/favicon.gif" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>
<script type="text/javascript">
        
                 function show_prompt(){
                     window.alert('Devi effettuare il login!');
                 }
         
</script>
     <c:choose><c:when test= "${mess!=null}">
             <body onload="alert('${mess}')">
             </c:when>
     <c:otherwise>
    <body>
        </c:otherwise></c:choose>
    <div class="shell">		
        <div id="top-navigation">
			<c:choose><c:when test="${utente.loggato==true}"><a title="I miei acquisti" href="MyAccount">I miei acquisti</a></c:when><c:otherwise> <a title="I miei acquisti" onclick="show_prompt()" href="login.jsp">I miei acquisti</a></c:otherwise></c:choose>
                        <c:choose><c:when test="${utente.loggato==true}"><a class="cart" title="Shopping Cart" href="carrello.jsp">SHOPPING CART</a></c:when><c:otherwise><a class="cart" title="Shopping Cart" onclick="show_prompt()" href="login.jsp">SHOPPING CART</a></c:otherwise></c:choose>
                        <c:choose><c:when test="${utente.loggato==true}"><a class="checkout" title="Logout" href="Logout">LOGOUT</a></c:when><c:otherwise><a></a></c:otherwise></c:choose>
                        <span>${carrello.count} prodotti</span><span class="sep">|</span><span >&euro;${carrello.tot}</span>
		</div>
                <div class="welcome-message">
			<c:choose > <c:when test="${!utente.loggato}">
                    <p>Benvenuto in Just Vintage!</p>
                        </c:when>
                    <c:otherwise> <p>Bentornato ${utente.nome}!</p>
                    </c:otherwise>
                    </c:choose>
		</div>
		<div class="cl"></div>
		<div id="wrapper-top"></div>
		<!-- Wrapper Middle -->
		<div id="wrapper-middle">
			<!-- Header -->
			<div id="header">
				<h1 id="logo"><a title="home" href="home.jsp">Just Vintage</a></h1>				
								
			</div>
			<!-- END Header -->
			<!-- Navigation -->
			<div id="navigation">
				<ul>
					<li class="first"><a title="Home" href="home.jsp">Home<span class="home">&nbsp;</span></a></li>
					<li><a title="Catalogo" href="CatalogoPro">Catalogo</a></li>
                                        <c:choose><c:when test="${utente.loggato==false}"><li><a title="Registrati" href="registrazione.jsp">Registrati</a></li></c:when>
                                            <c:otherwise><li><a title="Registrati" href="#">Registrati</a></li></c:otherwise></c:choose>
					<li><a title="Il Vinile" href="Ilvinile">Il Vinile</a></li>
					<li><a title="Chi Siamo" href="ChiSiamo">Chi Siamo</a></li>
					<c:choose><c:when test="${utente.loggato==false}"><li><a title="Login" href="login.jsp">Login</a></li></c:when>
                                            <c:otherwise><li><a title="Login" href="#">Login</a></li></c:otherwise></c:choose>
					<li><a title="Contatti" href="contatti.jsp">Contatti</a></li>
				</ul>
				<div class="cl"></div>
			</div>
			<!-- END Navigation -->
			<!-- Main -->
			<div id="main">
				<!-- Content -->
				<div id="content">
                                    <div class="products">
					<div class="title">
							<h2>LOGIN</h2>
							<a class="title-link" title="Torna alla Home" href="home.jsp">Torna alla Home</a>
							<img class="bullet" src="css/images/punto.gif" alt="small grey bullet" />
					</div>
							 <form class="registrazione" method="post" action="Login">
                                                        <fieldset>
                                                            <p>
                                                                <label for="email">E-mail</label>
                                                                <input type="email" id="email" name="email" required value="" />
                                                            </p>

                                                            <p>
                                                                <label for="password">Password</label>
                                                                <input type="password" id="password" name="password" required value="" />
                                                            </p>
                                                            <p class="bottone">
                                                                <button class="bottone-invia" type="submit">Invia</button>
                                                            </p>
                                                            

                                                        </fieldset>
                                                    </form>                    
                                                      
						</div>
                                       </div>  
				<!-- END Content -->
				<div class="cl"></div>
			</div>
			<!-- END Main -->
		</div>
		<!-- END Wrapper Middle -->
		<div id="wrapper-bottom"></div>	
		<!-- Footer  -->
		<div id="footer">
                    <span class="author"><a><a title="Thanks to Antonio Ranaudo" href="mailto:antonio.ranaudo@gmail.com">Thanks to Antonio Ranaudo</a></span>
                    <p><a title="Chi Siamo" href="ChiSiamo">Chi Siamo</a><span>&frasl;&frasl;</span><a title="Servizio Clienti" href="mailto:clienti@justvintage.com">Servizio Clienti</a></p>
		</div>
		<!-- END Footer -->
	</div>
</body>
</html>
    


