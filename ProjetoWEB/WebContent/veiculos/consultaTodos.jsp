
<jsp:include page="../util/topo.jsp" />
<html><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://localhost:8085/ProjetoWEB/lib/js/jquery.min.js"></script>
        <script type="text/javascript" src="http://localhost:8085/ProjetoWEB/lib/js/bootstrap.min.js"></script>
        <link href="http://localhost:8085/ProjetoWEB/lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://localhost:8085/ProjetoWEB/lib/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="http://localhost:8085/ProjetoWEB/lib/css/padrao.css" rel="stylesheet" type="text/css">
    </head><body>
    <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h1 class="text-center">Sistema de Mega Automóveis</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <h3 class="tt_menu">&gt;&gt; VEICULOS - CONSULTAR TODOS OS VEICULOS &lt;&lt;</h3>
          </div>
      </div>
      </div>  </div>
    
     <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h1 class="text-center">${mensagem}</h1>
            <table  border="1">
            	<tr>
            		<th>CPF</th>
            		<th>NOME</th>
            		<th>EMAIL</th>
            	</tr>
            	<c:forEach var="row" items="${veiculos}">
            		<tr>
            			<td><c:out value="${row.chassi}" /></td>
            			<td><c:out value="${row.valor}" /></td>
            			<td><c:out value="${row.modelo}" /></td>           	
            		</tr>
            	</c:forEach>
            </table>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
           <a class="btn btn-default" href="javascript:window.history.go(-1)">Voltar</a>
          </div>
        </div>
      </div>
    </div> 
    <footer>
      <div class="navbar navbar-fixed-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">© Mega Automóveis</div>
          </div>
        </div>
      </div>
    </footer>
</body></html>