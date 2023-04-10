<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@include file="/common/taglib.jsp" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
		</head>

		<body>
			<!-- 
Body Section 
-->
			<div class="row">
				<div id="sidebar" class="span3">
					<div class="well well-small">
						<ul class="nav nav-list">
							<c:forEach var="item" items="${categorys}">
								<li><a href='<c:url value="/loai-san-pham/${item.id}"/>'><span class="icon-chevron-right"></span>${item.name}</a></li>	
							</c:forEach>
							<li style="border:0"> &nbsp;</li>
							<li> <a class="totalInCart" href="cart.html"><strong title="Tổng Tiền">Total Amount<span
											class="badge badge-warning pull-right"
											style="line-height:18px;"><fmt:formatNumber type="number" groupingUsed="true" value="${TotalPriceCart}"/>₫</span></strong></a></li>
						</ul>
					</div>

					<div class="well well-small alert alert-warning cntr">
						<h2>50% Discount</h2>
						<p>
							only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
						</p>
					</div>
					<div class="well well-small"><a href="#">
						<!-- <img src="assets/img/paypal.jpg" alt="payment method paypal"></a> -->
						<img src="<c:url value='/template/user/assets/img/paypal.jpg'/>" alt="payment method paypal"></a>
					</div>

					<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
					<br>
					<br>
					<ul class="nav nav-list promowrapper">
						<li>
							<div class="thumbnail">
								<a class="zoomTool" href="product_details.html" title="add to cart"><span
										class="icon-search"></span> QUICK VIEW</a>
								<img src="<c:url value='/template/user/assets/img/bootstrap-ecommerce-templates.PNG'/>" alt="bootstrap ecommerce templates">
								<div class="caption">
									<h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span
											class="pull-right">$22.00</span></h4>
								</div>
							</div>
						</li>
						<li style="border:0"> &nbsp;</li>
						<li>
							<div class="thumbnail">
								<a class="zoomTool" href="product_details.html" title="add to cart"><span
										class="icon-search"></span> QUICK VIEW</a>
								<img src="assets/img/shopping-cart-template.png" alt="shopping cart template">
								<div class="caption">
									<h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span
											class="pull-right">$22.00</span></h4>
								</div>
							</div>
						</li>
						<li style="border:0"> &nbsp;</li>
						<li>
							<div class="thumbnail">
								<a class="zoomTool" href="product_details.html" title="add to cart"><span
										class="icon-search"></span> QUICK VIEW</a>
								<img src="assets/img/bootstrap-template.png" alt="bootstrap template">
								<div class="caption">
									<h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span
											class="pull-right">$22.00</span></h4>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="span9">
					<ul class="breadcrumb">
						<li><a href="<c:url value="/trang-chu"/>">Home</a> <span class="divider">/</span></li>
						<li class="active"></li>
					</ul>
					<div class="well well-small">
						<h3 title="Reset PassWord">Cài Lại Mật Khẩu Tài Khoản</h3>
						<hr class="soft" />
						Nhập Mật Khẩu mới cho tài khoản 
						<br /><br />
						<form:form class="form-inline" action="updatepasswordnew" method="POST">
							<label class="control-label" for="inputPassWordNew">Mật Khẩu Mới :</label><br/>
							<input type="password" class="span4" name="passwordNew" placeholder="Pass Word New">
							<br />
							<label class="control-label" for="inputPassWordNew">Xác Nhận Mật Khẩu Mới :</label><br/>
							<input type="password" class="span4" name="passwordNews" placeholder="Pass Word New">
							<br /><br />
							<button type="submit" class="shopBtn block">Update My Password</button>
						</form:form>
					</div>
				</div>
			</div>
		</body>

		</html>