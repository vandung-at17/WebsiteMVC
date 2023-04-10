<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@include file="/common/taglib.jsp" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Đăng Ký Tài Khoản</title>
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
					<div class="well well-small"><a href="#"><img src="assets/img/paypal.jpg"
								alt="payment method paypal"></a></div>

					<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
					<br>
					<br>
					<ul class="nav nav-list promowrapper"> 
						<li>
							<div class="thumbnail">
								<a class="zoomTool" href="product_details.html" title="add to cart"><span
										class="icon-search"></span> QUICK VIEW</a>
								<img src="assets/img/bootstrap-ecommerce-templates.png"
									alt="bootstrap ecommerce templates">
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
						<li><a href="index.html" title="Home">Trang Chủ</a> <span class="divider">/</span></li>
						<li class="active" title="Registration">Đăng Ký</li>
					</ul>
					<h3 title="Registration">Đăng Ký</h3>
					<hr class="soft" />
					<div class="well">
						<form:form action="dang-ky" modelAttribute="user" method="POST" class="form-horizontal">  
							<h3 title="Your Personal Details">Thông Tin Cá Nhân Của Bạn</h3>
							<!-- <div class="control-group">
								<label class="control-label">Title <sup>*</sup></label>
								<div class="controls">
									<select class="span1" name="days">
										<option value="">-</option>
										<option value="1">Mr.</option>
										<option value="2">Mrs</option>
										<option value="3">Miss</option>
									</select>
								</div>
							</div> -->
							<div class="control-group">
								<label class="control-label" for="inputFname">First name <sup>*</sup></label>
								<div class="controls" accept-charset="UTF-8">
									<!-- <input type="text" id="inputFname" placeholder="First Name"> -->
									<form:input type="text"  path="firstName" id="inputFname" placeholder="First Name"/> 
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputLname">Last name <sup>*</sup></label>
								<div class="controls" accept-charset="UTF-8">
									<!-- <input type="text" id="inputLname" placeholder="Last Name"> -->
									<form:input type="text" path="lastName" id="inputLname" placeholder="Last Name"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Email<sup>*</sup></label>
								<div class="controls" accept-charset="UTF-8">
									<form:input type="email" path="email" placeholder="Email"/>  
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Password<sup>*</sup></label>
								<div class="controls">
									<form:input type="password" path="password" placeholder="Password"/> 
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Địa Chỉ<sup>*</sup></label>
								<div class="controls" accept-charset="UTF-8">
									<form:textarea type="text" path="address" placeholder="Mời Nhập Địa Chỉ"/> 
								</div>
							</div>
							<!-- <div class="control-group">
								<label class="control-label">Date of Birth <sup>*</sup></label>
								<div class="controls">
									<select class="span1" name="days">
										<option value="">-</option>
										<option value="1">1&nbsp;&nbsp;</option>
										<option value="2">2&nbsp;&nbsp;</option>
										<option value="3">3&nbsp;&nbsp;</option>
										<option value="4">4&nbsp;&nbsp;</option>
										<option value="5">5&nbsp;&nbsp;</option>
										<option value="6">6&nbsp;&nbsp;</option>
										<option value="7">7&nbsp;&nbsp;</option>
									</select>
									<select class="span1" name="days">
										<option value="">-</option>
										<option value="1">1&nbsp;&nbsp;</option>
										<option value="2">2&nbsp;&nbsp;</option>
										<option value="3">3&nbsp;&nbsp;</option>
										<option value="4">4&nbsp;&nbsp;</option>
										<option value="5">5&nbsp;&nbsp;</option>
										<option value="6">6&nbsp;&nbsp;</option>
										<option value="7">7&nbsp;&nbsp;</option>
									</select>
									<select class="span1" name="days">
										<option value="">-</option>
										<option value="1">1&nbsp;&nbsp;</option>
										<option value="2">2&nbsp;&nbsp;</option>
										<option value="3">3&nbsp;&nbsp;</option>
										<option value="4">4&nbsp;&nbsp;</option>
										<option value="5">5&nbsp;&nbsp;</option>
										<option value="6">6&nbsp;&nbsp;</option>
										<option value="7">7&nbsp;&nbsp;</option>
									</select>
								</div>
							</div> -->
							<div class="control-group">
								<div class="controls">
									<input type="submit" name="submitAccount" value="Đăng Ký" title="Register"
										class="exclusive shopBtn">
								</div>
							</div>
						</form:form>
					</div>

					<div class="well">
						<form class="form-horizontal">
							<h3>Your Account Details</h3>
							<div class="control-group">
								<label class="control-label">Fiels label <sup>*</sup></label>
								<div class="controls">
									<input type="text" placeholder=" Field name">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fiels label <sup>*</sup></label>
								<div class="controls">
									<input type="text" placeholder=" Field name">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fiels label <sup>*</sup></label>
								<div class="controls">
									<input type="text" placeholder=" Field name">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fiels label <sup>*</sup></label>
								<div class="controls">
									<input type="text" placeholder=" Field name">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fiels label <sup>*</sup></label>
								<div class="controls">
									<input type="text" placeholder=" Field name">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fiels label <sup>*</sup></label>
								<div class="controls">
									<input type="text" placeholder=" Field name">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fiels label <sup>*</sup></label>
								<div class="controls">
									<input type="text" placeholder=" Field name">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fiels label <sup>*</sup></label>
								<div class="controls">
									<input type="text" placeholder=" Field name">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fiels label <sup>*</sup></label>
								<div class="controls">
									<input type="text" placeholder=" Field name">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fiels label <sup>*</sup></label>
								<div class="controls">
									<input type="text" placeholder=" Field name">
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="submit" name="submitAccount" value="Register"
										class="exclusive shopBtn">
								</div>
							</div>
						</form>
					</div>


				</div>
			</div>
		</body>

		</html>