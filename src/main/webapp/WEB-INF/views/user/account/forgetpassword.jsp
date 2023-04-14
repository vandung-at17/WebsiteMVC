<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên Mật Khẩu</title>
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
					only valid for online order. <br> <br> <a
						class="defaultBtn" href="#">Click here </a>
				</p>
			</div>
			<div class="well well-small">
				<a href="#"><img src="assets/img/paypal.jpg"
					alt="payment method paypal"></a>
			</div>

			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br> <br>
			<ul class="nav nav-list promowrapper">
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
							src="<c:url value='/template/user/assets/img/bootstrap-ecommerce-templates.PNG'/>"
							alt="bootstrap ecommerce templates">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK VIEW</a> 
							<img
							src="<c:url value='/template/user/assets/img/shopping-cart-template.PNG'/>"
							alt="shopping cart template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a>
							<img
							src="<c:url value='/template/user/assets/img/bootstrap-template.png'/>"
							alt="bootstrap template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
			</ul>

		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="<c:url value="/trang-chu"/>">Trang Chủ</a> <span class="divider">/</span></li>
				<li class="active">Forget Password</li>
			</ul>
			<h3>Khôi Phục Mật Khẩu</h3>
			<hr class="soft" />
			<div class="row">
				<div class="span4" id "sendEmail">
					<div class="well">
						<h5>Xác Thực Tài Khoản Của Bạn</h5>
						<br />Nhập địa chỉ e-mail của bạn để nhận mã khôi phục tài khoản<br /> <br />
						<br />
						<form:form action="forgetpassword" method="POST">
							<div class="control-group">
								<label class="control-label" for="inputEmail" title="E-mail address">
								Địa Chỉ Email
								</label>
								<div class="controls">
									<input class="span3" type="email" name="email" placeholder="Email">
								</div>
							</div>
							<div class="controls">
								<button type="submit" class="btn block">
								Gửi Mã Xác Thực Tài Khoản
								</button>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
				<c:if test="${random >0}">
				<div class="span4">
					<div class="well">
						<h5>Nhập Mã Xác Thực</h5>
						<br />Nhập mã xác thực đã được gửi trong địa chỉ e-mail của bạn để nhận mã khôi phục tài khoản<br />
						<form:form action="forgetpassword" method="POST">
							<div class="control-group">
								<label class="control-label" for="inputEmail" title="E-mail address">
								Mã Xác Thực Account
								</label>
								<div class="controls">
									<input class="span3" type="text" placeholder="Mã Code" name ="code">
								</div>
							</div>
							<div class="controls">
								<button type="submit" class="btn block">
								Xác Nhận Xác Thực
								</button>
							</div>
						</form:form>
					</div>
				</div>
				</c:if>	
			</div>

		</div>
	</div>
	<content tag="script">
		<script>
			$(".btn block").on("click", function(){
				var tbody = $("#sendEmail");
				tbody.empty();
			});
		</script>
	</content>
</body>
</html>