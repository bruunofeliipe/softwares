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
            <h1 class="text-center">Sistema de Mega Autom�veis</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <h3 class="tt_menu">&gt;&gt; CARRO - ALTERAR UM CARRO &lt;&lt;</h3>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form" action="http://localhost:8085/ProjetoWEB/controladorveiculo" method="post">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputCHASSI" class="control-label">Informar o CHASSI:</label>
                </div>
                <div class="col-sm-10">
                  <input type="number" name="chassi" class="form-control" id="inputCHASSI" placeholder="Chassi" required>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputNome" class="control-label">Informar o MODELO:</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" name="modelo" class="form-control" id="inputModelo" placeholder="Modelo" required>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputVALOR" class="control-label">Informar o VALOR:</label>
                </div>
                <div class="col-sm-10">
                  <input type="number" name="valor" class="form-control" id="inputVALOR" placeholder="Valor" required>
                </div>
              </div>
             
              <input type="hidden" name="idformulario" value="2">
              <input type="hidden" name="tipoformulario" value="24">
              <button type="submit" class="btn btn-danger">Alterar</button>
              </form>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center corrigir">
            <a class="btn btn-default" href="javascript:window.history.go(-1)">Voltar</a>
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