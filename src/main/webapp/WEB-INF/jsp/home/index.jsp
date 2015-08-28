<%@ include file="/WEB-INF/jsp/template/inicio.jsp"%>

<!-- Breadcrumbs start -->
<div class="row breadcrumbs">
	<div class="col-xs12 col-sm-12 col-md-12 col-lg-12">
		<ul class="breadcrumbs">
			<li><a href="#"><i class="fa fa-home"></i></a></li>
		</ul>
	</div>
</div>
<!-- Breadcrumbs -->


<!-- Row start -->
<div class="row">
	<!-- Coluna start -->
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<h3>Aqui será listado as vendas realizadas de cada vendedor ou os produtos.</h3>

		<!-- Row start -->
		<div class="row">
			<!-- Listagem dos produtos ou vendas realizadas start-->
			<div class="boxed no-padding col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<!-- inner start -->
				<div class="inner">
					<!-- Tituto da caixa start -->
					<div class="title-bar white">
						<h4>Vendas realizadas (vendedores, totais de vendas, etc) ou produtos em estoque (preços, quantidades, etc)</h4>
					</div>
					<!-- Tituto da caixa end -->
					
					<!-- Table holder start -->
					<div class="table-holder">
						<table id="datatables-table" class="datatables">
							<thead>
								<th class="id">#</th>
								<th>Produto</th>
								<th>Descrição</th>
								<th>Fabricante</th>
								<th>Marca</th>
								<th>Quantidade em estoque</th>
								<th>Preço em R$</th>
							</thead>
							<tbody>
								<tr>
									<td class="id">1</td>
									<td>Calça jeans</td>
									<td>Calça jeans azul com listas pretas</td>
									<td>Riachuelo</td>
									<td>Polo</td>
									<td>22</td>
									<td>R$ 75,00</td>
								</tr>								
							</tbody>
						</table>			
					</div>
					<!-- Table holder end -->
				</div>
				<!-- inner end -->
			</div>
			<!-- Listagem dos produtos ou vendas realizadas end -->					 
		</div>
		<!-- Row end -->
	</div>
	<!-- Coluna end -->
</div>
<!-- Row end -->
<%@ include file="/WEB-INF/jsp/template/rodape.jsp"%>