<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
	<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Home Page</title>
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
				<div class="well well-small">
					<a href="#">
					<!-- <img src="assets/img/paypal.jpg" alt="payment method paypal"> -->
					<img src="<c:url value='/template/user/assets/img/paypal.jpg'/>" alt="payment method paypal">
					</a>
				</div>
				<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
				<br>
				<br>
				<ul class="nav nav-list promowrapper">
					<li>
						<div class="thumbnail">
							<a class="zoomTool" href="product_details.html" title="add to cart"><span
									class="icon-search"></span> QUICK VIEW</a>
							<!-- <img src="assets/img/bootstrap-ecommerce-templates.png" alt="bootstrap ecommerce templates"> -->
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
							<!-- <img src="/assets/img/shopping-cart-template.png" alt="shopping cart template"> -->
							<img src="<c:url value='/template/user/assets/img/shopping-cart-template.PNG'/>" alt="shopping cart template">
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
							<!-- <img src="/assets/img/bootstrap-template.png" alt="bootstrap template"> -->
							<img src="<c:url value='/template/user/assets/img/bootstrap-template.png'/>" alt="bootstrap template">
							<div class="caption">
								<h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span
										class="pull-right">$22.00</span></h4>
							</div>
						</div>
					</li>
				</ul>

			</div>
			<div class="span9">
				<div class="well np">
					<div id="myCarousel" class="carousel slide homCar">
						<div class="carousel-inner">
							<c:forEach var="item" items="${slides}" varStatus="index" >
								<c:if test="${index.first}">
									<div class="item active">
								</c:if>
								<c:if test="${not index.first}">
									<div class="item">
								</c:if>
								<!-- <img style="width:100%" src="assets/img/bootstrap_free-ecommerce.png" alt="bootstrap ecommerce templates"> -->
								<img style="width:100%" src="<c:url value='/template/user/assets/img/${item.img}'/>" alt="bootstrap ecommerce templates">
								<div class="carousel-caption">
									<h4>${item.caption}</h4>
									<p><span>${item.content}</span></p>
								</div>
								</div>
							</c:forEach>
						</div>
						<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
						<a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
					</div>
				</div>
<!--
New Products
-->
				<div class="well well-small">
					<h3>New Products (Sản Phẩm Mới)</h3>
					<hr class="soften" />
					<div class="row-fluid">
						<div id="newProductCar" class="carousel slide">
							<div class="carousel-inner">
								<div class="item active">
									<ul class="thumbnails">
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool" href="product_details.html"
													title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
												<a href="#" class="tag"></a>
												<!-- <a href="product_details.html"><img src="assets/img/bootstrap-ring.png" alt="bootstrap-ring"></a> -->
												<a href="product_details.html"><img src="<c:url value='/template/user/assets/img/bootstrap-ring.png'/>" alt="bootstrap-ring"></a>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool" href="product_details.html"
													title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
												<a href="#" class="tag"></a>
												<!-- <a href="product_details.html"><img src="assets/img/i.jpg" alt=""></a> -->
												<a href="product_details.html"><img src="<c:url value='/template/user/assets/img/i.jpg'/>" alt=""></a>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool" href="product_details.html"
													title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
												<a href="#" class="tag"></a>
												<!-- <a href="product_details.html"><img src="assets/img/g.jpg" alt=""></a> -->
												<a href="product_details.html"><img src="<c:url value='/template/user/assets/img/g.jpg'/>" alt=""></a>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool" href="product_details.html"
													title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
												<!-- <a href="product_details.html"><img src="assets/img/s.png" alt=""></a> -->
												<a href="product_details.html"><img src="<c:url value='/template/user/assets/img/s.png'/>" alt=""></a>
											</div>
										</li>
									</ul>
								</div>
								<div class="item">
									<ul class="thumbnails">
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool" href="product_details.html"
													title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
												<!-- <a href="product_details.html"><img src="assets/img/i.jpg" alt=""></a> -->
												<a href="product_details.html"><img src="<c:url value='/template/user/assets/img/i.jpg'/>" alt=""></a>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool" href="product_details.html"
													title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
												<!-- <a href="product_details.html"><img src="assets/img/f.jpg" alt=""></a> -->
												<a href="product_details.html"><img src="<c:url value='/template/user/assets/img/f.jpg'/>" alt=""></a>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool" href="product_details.html"
													title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
												<!-- <a href="product_details.html"><img src="assets/img/h.jpg" alt=""></a> -->
												<a href="product_details.html"><img src="<c:url value='/template/user/assets/img/h.jpg'/>" alt=""></a>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool" href="product_details.html"
													title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
												<!-- <a href="product_details.html"><img src="assets/img/j.jpg" alt=""></a> -->
												<a href="product_details.html"><img src="<c:url value='/template/user/assets/img/j.jpg'/>" alt=""></a>
											</div>
										</li>
									</ul>
								</div>
							</div>
							<a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a>
							<a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
						</div>
					</div>
					<%-- <div class="row-fluid">
						<ul class="thumbnails">
							<li class="span4">
								<div class="thumbnail">

									<a class="zoomTool" href="product_details.html" title="add to cart"><span
											class="icon-search"></span> QUICK VIEW</a>
									<!-- <a href="product_details.html"><img src="assets/img/b.jpg" alt=""></a> -->
									<a href="product_details.html"><img src="<c:url value='template/user/assets/img/b.jpg'/>" alt=""></a>
									<div class="caption cntr">
										<p>Manicure & Pedicure</p>
										<p><strong> $22.00</strong></p>
										<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>
										<div class="actionList">
											<a class="pull-left" href="#">Add to Wish List </a>
											<a class="pull-left" href="#"> Add to Compare </a>
										</div>
										<br class="clr">
									</div>
								</div>
							</li>
							<li class="span4">
								<div class="thumbnail">
									<a class="zoomTool" href="product_details.html" title="add to cart"><span
											class="icon-search"></span> QUICK VIEW</a>
									<a href="product_details.html"><img src="assets/img/c.jpg" alt=""></a>
									<div class="caption cntr">
										<p>Manicure & Pedicure</p>
										<p><strong> $22.00</strong></p>
										<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>
										<div class="actionList">
											<a class="pull-left" href="#">Add to Wish List </a>
											<a class="pull-left" href="#"> Add to Compare </a>
										</div>
										<br class="clr">
									</div>
								</div>
							</li>
							<li class="span4">
								<div class="thumbnail">
									<a class="zoomTool" href="product_details.html" title="add to cart"><span
											class="icon-search"></span> QUICK VIEW</a>
									<a href="product_details.html"><img src="assets/img/a.jpg" alt=""></a>
									<div class="caption cntr">
										<p>Manicure & Pedicure</p>
										<p><strong> $22.00</strong></p>
										<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>
										<div class="actionList">
											<a class="pull-left" href="#">Add to Wish List </a>
											<a class="pull-left" href="#"> Add to Compare </a>
										</div>
										<br class="clr">
									</div>
								</div>
							</li>
						</ul>
					</div> --%>
				</div>
	<!--
	Featured Products
	-->
				<div class="well well-small">
					<h3><a class="btn btn-mini pull-right" href="products.html" title="View more">VIew More<span
								class="icon-plus"></span></a> Featured Products (Sản Phẩm Nổi Bật)</h3>
					<hr class="soften" />
					<div class="row-fluid">
						<c:if test="${FeaturedProducts.size()>0}">
							<ul class="thumbnails">
							<c:forEach var="item" items="${FeaturedProducts}" varStatus="loop">
								<li class="span4">
									<div class="thumbnail">
										<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
										<a href="chi-tiet-san-pham/${item.id_product}"><img src="<c:url value='/template/user/assets/img/${item.img}'/>" alt=""></a>
										<div class="caption">
											<!-- <h5>Manicure & Pedicure</h5> -->
											<h5>${item.name}</h5>
											<h4>
												<a class="defaultBtn" href="product_details.html"
													title="Click to view"><span class="icon-zoom-in"></span></a>
												<a class="shopBtn" href="<c:url value="/AddCart/${item.id_product}"/>" title="add to cart"><span
														class="icon-plus"></span></a>
												<span class="pull-right"><fmt:formatNumber type="number" groupingUsed="true" value="${item.price}"/>₫</span>
											</h4>
										</div>
									</div>
								</li>
								<c:if test="${(loop.index+1) %3==0||(loop.index+1) == FeaturedProducts.size()}">
									</ul>
									<c:if test="${(loop.index +1) < FeaturedProducts.size()}">
										<ul class="thumbnails">
									</c:if>
								</c:if>
							</c:forEach>
						</c:if>
						<%-- <ul class="thumbnails">
							<li class="span4">
								<div class="thumbnail">
									<a class="zoomTool" href="product_details.html" title="add to cart"><span
											class="icon-search"></span> QUICK VIEW</a>
									<a href="product_details.html"><img src="<c:url value='template/user/assets/img/d.jpg'/>" alt=""></a>
									<div class="caption">
										<h5>Manicure & Pedicure</h5>
										<h4>
											<a class="defaultBtn" href="product_details.html"
												title="Click to view"><span class="icon-zoom-in"></span></a>
											<a class="shopBtn" href="#" title="add to cart"><span
													class="icon-plus"></span></a>
											<span class="pull-right">$22.00</span>
										</h4>
									</div>
								</div>
							</li>
						</ul> --%>
					</div>
				</div>
				<hr>
				<div class="well well-small">
					<a class="btn btn-mini pull-right" href="#">Xem Thêm SP<span class="icon-plus"></span></a>
					Tất Cả Sản Phẩm
				</div>
				<!-- <div class="well well-small">
					<a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
					Popular Products
				</div>
				<hr>
				<div class="well well-small">
					<a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
					Best selling Products
				</div> -->
			</div>
		</div>
	</body>

	</html>