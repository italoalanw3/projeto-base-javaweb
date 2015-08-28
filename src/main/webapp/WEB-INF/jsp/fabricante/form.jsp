<%@ include file="/WEB-INF/jsp/template/inicio.jsp"%>
<!-- Row Start -->
<div class="row">
	<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
		<h3><fmt:message key="fabricante.cadastro.titulo" /></h3>
		<div class="boxed">		
			<%@ include file="/WEB-INF/jsp/template/mensagens/mensagem-aviso.jsp"%>
			<div class="inner">
			
				<form method="post" class="basic-form no-padding" action="<c:url value="/fabricante/" />">
					<input type="hidden" name="fabricante.id" value="${fabricante.id}" /> 
					<label for="input-def">
						<fmt:message key="fabricante.nome" />
					</label> 
					<input type="text" name="fabricante.nome" placeholder='<fmt:message key="fabricante.nome.placeholder" />' value="${fabricante.nome}" />					
					
					<button type="submit" class="btn btn-lg btn-success">
						<i class="fa fa-check"></i><fmt:message key="botao.salvar" /></button>
				</form>
				
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/template/rodape.jsp"%>