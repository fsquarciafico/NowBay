<%-- 
    Document   : chisiamo
    Created on : 13-giu-2018, 17.54.10
    Author     : Ferdinando
--%>

%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    <body>
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
				<!-- Sidebar -->
				<div id="sidebar">
					<div class="box">
						<div class="title">
							<h2>Categorie</h2>
							<img class="bullet" src="css/images/punto.gif" alt="small grey bullet" />
						</div>
						<ul>
							<li><a title="Italiani" href="CatalogoPro?tipo=italiani">Italiani</a></li>
							<li><a title="Stranieri" href="CatalogoPro?tipo=stranieri">Stranieri</a></li>							
						</ul>
					</div>
					<div class="box">
						<div class="title">
							<h2>Follow Us</h2>
							<img class="bullet" src="css/images/punto.gif" alt="small grey bullet" />
						</div>	
						<ul class="socials">
							<li><a title="Facebook" href="http://facebook.com/RockAlloStatoBrado"><img src="css/images/fb.gif" alt="facebook icon" />facebook</a></li>
							
						</ul>
					</div>
				</div>
				<!-- END Sidebar -->
				<!-- Content -->
				<div id="content">
					<!-- Products -->
					<div class="products">
						<div class="title">
							<h2>Chi siamo</h2>
							<a class="title-link" title="More" href="home.jsp">Torna alla Home</a>
							<img class="bullet" src="css/images/punto.gif" alt="small grey bullet" />
						</div>
						<div class="row">
                                                    <div class="product-holvinile">	
                                                        <div class="productvinile">
                                                            <h3 style=" font-size: 120%;text-align:left ;float:left;width:310px"> ${file}</h3>
                                                            <img style="float:right" src="css/images/enzoranaudo.jpg"  />
                                                            <h1 style=" color:whitesmoke; font-size: 120%;text-align:left ;width:310px">Enzo Ranaudo</h1>
                                                            
                                                         </div>
                                                    </div> 
                                                </div>
						<div class="cl"></div>
					</div>
					<!-- END Products -->
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