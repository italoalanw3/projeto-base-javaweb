<%@ include file="/WEB-INF/jsp/template/inicio.jsp"%>

<!-- Row Start -->
<div class="row">
	<div class="boxed no-padding col-lg-12 col-md-12 col-sm-12 col-xs-12">

		<h3>
			<fmt:message key="fabricante.lista.titulo" />
		</h3>
		<div class="boxed">
			<div class="inner">
				<div class="title-bar white">
					<h4>
						<fmt:message key="fabricante.lista.titulo" />
					</h4>
				</div>
				<c:if test="${!empty mensagemAdicionar}">
						<div class="alert alert-success alert-dismissable">
							<span tabindex="button" class="close" data-dismiss="alert" aria-hidden="true"></span> 
							<fmt:message key="mensagem.adicionado"/>
						</div>
					</c:if>
					<c:if test="${!empty mensagemRemover}">
						<div class="alert alert-success alert-dismissable">
							<span tabindex="button" class="close" data-dismiss="alert" aria-hidden="true"></span> 
							<fmt:message key="mensagem.removido"/>
						</div>
					</c:if>
					<c:if test="${!empty mensagemAlterar}">
						<div class="alert alert-success alert-dismissable">
							<span tabindex="button" class="close" data-dismiss="alert" aria-hidden="true"></span> 
							<fmt:message key="mensagem.alterado"/>
 						</div>
 					</c:if>
				<!-- Table Holder Start -->
				<div class="table-holder">
					<table id="stripe-table" class="stripe-rows">
						<thead>
							<th class="id"><fmt:message key='tabela.coluna.id' /></th>
							<th><fmt:message key='fabricante.lista.tabela.coluna.nome' /></th>
						</thead>
						<tbody>
							<c:forEach items="${fabricantes}" var="fabricante">
								<tr>
									<td class="id">${fabricante.id}</td>
									<td>${fabricante.nome}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
				<!-- Table Holder End -->
			</div>
		</div>
		<!-- Stripe Example End -->
	</div>
</div>
<%@ include file="/WEB-INF/jsp/template/rodape.jsp"%>