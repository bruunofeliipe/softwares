
<jsp:include page="../util/topo.jsp" />
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://localhost:8085/ProjetoWEB/lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="http://localhost:8085/ProjetoWEB/lib/js/bootstrap.min.js"></script>
    <link href="http://localhost:8085/ProjetoWEB/lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://localhost:8085/ProjetoWEB/lib/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="http://localhost:8085/ProjetoWEB/lib/css/padrao.css" rel="stylesheet" type="text/css">
  	<title>P�gina de Sucesso</title>
  </head><body>
    <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h1 class="text-center">Sistema de Mega Autom�veis</h1>
          </div>
        </div>
      </div>
    </div>
     <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
          
      	
            	<h3 class="text-center">Nome:${cliente.nome}</h3>
            	<h3 class="text-center">CPF:${cliente.cpf}</h3>
            	<h3 class="text-center">EMAIL:${cliente.email}</h3>
        
  <h1 class="text-center">${mensagem}</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
           <a class="btn btn-default" href="index.jsp">Retornar ao Menu Cliente</a>
          </div>
        </div>
      </div>
    </div> 
    <footer>
      <div class="navbar navbar-fixed-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">� Mega Autom�veis</div>
          </div>
        </div>
      </div>
    </footer>
</body></html>