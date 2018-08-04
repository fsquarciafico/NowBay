<%-- 
    Document   : carrello
    Created on : 13-giu-2018, 16.50.52
    Author     : Ferdinando
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
	<title>Just Vintage</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link rel="shortcut icon" href="css/images/favicon.gif" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>
<script type="text/javascript">
        
                 function show_prompt(){
                     var name=prompt('Inserisci il tuo IBAN: ','IBAN');
                     if(name!=null && name!=""){
                         
                         window.location="GestCarrello?acquista=${true}&IBAN="+name;
                     }
                 }
         
</script>          
    <div class="shell">		
		<div id="top-navigation">
			<c:choose><c:when test="${utente.loggato==true}"><a title="I miei acquisti" href="MyAccount">I miei acquisti</a></c:when><c:otherwise> <a title="I miei acquisti" href="login.jsp">I miei acquisti</a></c:otherwise></c:choose>
                        <c:choose><c:when test="${utente.loggato==true}"><a class="cart" title="Shopping Cart" href="carrello.jsp">SHOPPING CART</a></c:when><c:otherwise><a class="cart" title="Shopping Cart" href="login.jsp">SHOPPING CART</a></c:otherwise></c:choose>
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
				<!-- Slider -->
				
				<!-- END Slider -->
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
							<h2>Carrello</h2>
							<a class="title-link" title="Catalogo" href="CatalogoPro">torna al catalogo</a>
							<img class="bullet" src="css/images/punto.gif" alt="small grey bullet" />
						</div>
                                            <div class="row">
                                               
                                                                                         
                                                         <table style="text-align:left; width: 650px">
                                                        <tr style ="font-family:  Lucida Sans Unicode, Lucida Grande, sans-serif;font-weight: bold;font-size: 13px;color: white;text-shadow: 0 3px #3c3c3c ;line-height: 36px;">
                                                            <td>prodotto</td>
                                                            <td>descrizione</td>
                                                            <td>prezzo</td>
                                                            <td>elimina</td> 
                                                        </tr>
                                                     <c:forEach  items="${carrello.carrello}" var="item" >
                                                        
                                                        <tr>
                                                           <td>${item.tipo_prod} </td>
                                                           <td style="inline-box-align: initial">${item.descrizione}</td>
                                                           <td><p class="price"><span >&euro;</span>${item.prezzo}</p></td>
                                                           <td><a title="rimuovi" href="GestCarrello?cod_prod=${item.cod_prod}"><img src="css/images/shopcartexclude.ico" alt="rimuovi dal carrello" style="height:30px;width:30px"/></a></td>
                                                        </tr>
                                                        
                                                       </c:forEach>
                                                    
                                                    <tr>
                                                        <td></td>
                                                        <td></td>
                                                     <td  style ="font-family:  Arial, helvetica, sans-serif;font-weight: bold;font-size: 13px;color: whitesmoke;line-height: 36px;">TOTALE</td>
                                                     <td  style ="font-family:  Arial, helvetica, sans-serif;font-weight: bold;font-size: 13px;color: whitesmoke;line-height: 36px;">ACQUISTA</td>
                                                    </tr>
                                                    <tr>
                                                        <td></td>
                                                        <td></td>
                                                      <td ><p class="price"><span >&euro;</span>${carrello.tot}</p></td> 
                                                      <td ><a title="acquista" <c:choose > <c:when test="${utente.loggato!=false}"> onclick="show_prompt()"></c:when><c:otherwise></c:otherwise></c:choose><img src="css/images/shopcartapply.ico" alt="acquista" style="height:30px;width:30px"/></a></td>  
                                                    </tr>
                                                    </table>
                                             
                                             
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
                    <span class="author"><a><a title="Thanks to Ferdinando Squarciafico" href="mailto:f.squarciafico@gmail.com">Thanks to Ferdinando Squarciafico</a></span>
                    <p><a title="Chi Siamo" href="ChiSiamo">Chi Siamo</a><span>&frasl;&frasl;</span><a title="Servizio Clienti" href="mailto:clienti@justvintage.com">Servizio Clienti</a></p>
		</div>
		<!-- END Footer -->
	</div>
</body>
</html>
