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
            <h3 class="tt_menu">&gt;&gt; VEICULOS &lt;&lt;</h3>
            <div class="col-md-12  btn-group btn-group-lg btn-group-vertical">
              <a href="http://localhost:8085/ProjetoWEB/controladorveiculo?idformulario=2&tipoformulario=21" class="btn btn-default">Consultar Todos os Veiculos</a>
              <a href="consulta.jsp" class="btn btn-default">Consultar um Veiculo Específico</a>
              <a href="cadastro.jsp" class="btn btn-default">Cadastrar um Novo Veiculo</a>
              <a href="alteracao.jsp" class="btn btn-default">Alterar um Veiculo</a>
              <a href="exclusao.jsp" class="btn btn-default">Excluir um Veiculo</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center corrigir">
            <a class="btn btn-default" href="../index.jsp">Voltar</a>
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