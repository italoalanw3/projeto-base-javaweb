<%@include file="/WEB-INF/jsp/template/inicio.jsp"%>
<!-- Breadcrumbs Start -->
  <div class="row breadcrumbs">

          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <ul class="breadcrumbs">
              <li><a href="#"><i class="fa fa-home"></i></a></li>
              <li><a href="#">Clientes</a></li>
              <li><a href="#">Novo cliente</a></li>
             </ul>
          </div>

        </div>
  <!-- Breadcrumbs End -->
<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

        <h3>Cliente</h3>

        <div class="row">
          <!-- Example Smart Form Start -->
          <div class="col-lg-6 col-md-6 col-xs-12 col-sm-12">
            <div class="boxed">

              <!-- Title Bar Start -->
              <div class="title-bar">
                <h4>Cadastrar novo cliente</h4>
              </div>
              <!-- Title Bar End -->

              <div class="inner no-radius">

                <form method="post" class="basic-form">

                  <div class="row">
                  <div class="col-md-6">
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username" placeholder="Use alphanumeric characters and limit it to 8!" />
                  </div>

                  <div class="col-md-6">
                    <label for="email">E-Mail:</label>
                    <input type="text" name="email" id="email" placeholder="Please use your valid e-mail!" />
                  </div>
                  </div>

                  <div class="row">
                  <div class="col-md-12">
                    <label for="bio">About you:</label>
                    <textarea name="bio" id="bio" placeholder="Tell us a little about you..."></textarea>
                  </div>
                  </div>

                  <div class="row">
                  <div class="col-md-6">
                    <label for="password">Password:</label>
                    <div class="input-group">
                      <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                      <input type="password" placeholder="Password" class="form-control">
                    </div>
                  </div>

                  <div class="col-md-6">
                    <label for="rep-password">Repeat Password:</label>
                    <div class="input-group">
                      <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                      <input type="password" placeholder="Password" class="form-control">
                    </div>
                  </div>
                  </div>

                  <div class="row">
                  <div class="col-md-4">
                    <label for="country">Country:</label>
                    <select id="dropdown" name="dropdown">
                      <option selected="selected" value="1">United States</option>
                      <option value="2">Germany</option>
                      <option value="3">Croatia</option>
                      <option value="3">England</option>
                      <option value="3">Poland</option>
                      <option value="3">France</option>
                    </select>
                  </div>

                  <div class="col-md-4">
                    <label for="city">City:</label>
                    <input type="text" name="city" id="city" placeholder="Enter your current city..." />
                  </div>

                  <div class="col-md-4">
                    <label for="post-code">Post code:</label>
                    <input type="text" name="post-code" id="post-code" placeholder="Enter your city post code..." />
                  </div>
                  </div>

                  <div class="row">
                  <div class="col-md-4">
                    <label>Payments will be done by:</label>
                    <select id="dropdown" name="dropdown">
                      <option selected="selected" value="1">Credit Card</option>
                      <option value="2">Wire Transfer</option>
                      <option value="2">PayPal</option>
                    </select>
                  </div>
                  </div>

                  <div class="row">
                    <div class="col-md-6">
                      <label class="icheck-label">I accept terms of use by clicking this checkbox</label>
                      <input type="checkbox" class="icheck-blue" value="1" name="icheck-blue-checkbox" />
                    </div>
                    <div class="col-md-6 text-right">
                      <button type="button" class="btn btn-lg btn-success"><i class="fa fa-check"></i> Save</button>
                    </div>
                  </div>

                </form>

              </div>

            </div>
          </div>
          <!-- Example Smart Form End -->

        </div>

    </div>
  </div>
<!-- page-wrapper -->
<%@include file="/WEB-INF/jsp/template/rodape.jsp"%>