<jsp:include page="../util/topo.jsp" />
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="../lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/js/bootstrap.min.js"></script>
    <link href="../lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/padrao.css" rel="stylesheet" type="text/css">
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
            <h3 class="tt_menu">&gt;&gt; PAGAMENTOS - CADASTRAR UM NOVO PAGAMENTO &lt;&lt;</h3>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form" action="http://localhost:8085/ProjetoWEB/controladorpagamento" method="post">
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputCPF" class="control-label">Informar o CPF:</label>
                </div>
                <div class="col-sm-9">
                  <input type="text" name="cpf" class="form-control" id="inputCPF" placeholder="CPF" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" title="Digite um CPF no formato: xxx.xxx.xxx-xx" required>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputCHASSI" class="control-label">Informar o CHASSI:</label>
                </div>
                <div class="col-sm-9">
                  <input type="number" name="chassi" class="form-control" id="inputCHASSI" placeholder="CHASSI" required>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputDATA" class="control-label">Informar a DATA DA SAIDA :</label>
                </div>
                <div class="col-sm-9">
                  <input type="date" name="datadasaida" class="form-control" id="inputDATA" title="Preencha o Data da saida" required>
                </div>
              </div>
                 <input type="hidden" name="idformulario" value="3">
              <input type="hidden" name="tipoformulario" value="33">
              <button type="submit" class="btn btn-danger">Cadastrar</button>
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
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">© Mega Automóveis</div>
          </div>
        </div>
      </div>
    </footer>
  

</body></html>