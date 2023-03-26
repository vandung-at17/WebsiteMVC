<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@include file="/common/taglib.jsp" %>
		<!DOCTYPE html>
		<html>
		<head>
			<meta charset="UTF-8" />
			<title>List Cart</title>
		</head>
		<body>
			<!-- 
Body Section 
-->
			<div class="row">
				<div class="span12">
					<ul class="breadcrumb">
						<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
						<li class="active" title="Check Out">Giỏ Hàng</li>
					</ul>
					<div class="well well-small">
						<h1>
							Check Out
							<small class="pull-right"> ${Cart.size()} Items are in the cart </small>
						</h1>
						<hr class="soften" />

						<table class="table table-bordered table-condensed">
							<thead>
								<tr>
									<th>Hình ảnh</th>
									<th>Mô tả</th>
									<th>Màu sắc</th>
									<th>Giá bán</th>
									<th>Số lượng </th>
									<th>Chỉnh sửa </th>
									<th>Xóa </th>
									<th>Tổng tiền</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${ Cart }">
									<tr>
										<td><img width="100" src="<c:url value='/template/user/assets/img/${item.value.product.img}'/>" alt="${item.value.product.img}"/></td>
										<td>${ item.value.product.title }</td>
										<td><span class="shopBtn" style="background-color: ${item.value.product.color};"><span
													class="icon-ok"></span></span> </td>
										<td>
											<fmt:formatNumber type="number" groupingUsed="true" value="${item.value.product.price}" />₫
										</td>
										<td>
											<input type="number" min="0" max="1000" class="span1" style="max-width:34px"
												placeholder="1" id="qanty-cart-${item.key}" size="16" type="text"
												value="${ item.value.quanty }">;
										</td>
										<td>
											<button data-id="${item.key}" class="btn btn-mini btn-danger edit-cart" type="button">
												<span class="icon-remove"></span>
											</button>
										</td>
										<td>
											<a href="<c:url value=" /DeleteCart/${item.key}" />" class="btn btn-mini btn-danger" type="button">
												<span class="icon-remove"></span>
											</a>
										</td>
										<td>
											<fmt:formatNumber type="number" groupingUsed="true"
												value="${item.value.totalPrice}" /> ₫
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table><br />

						<table class="table table-bordered">
							<tbody>
								<tr>
									<td>
										<form class="form-inline">
											<label style="min-width: 159px"> VOUCHERS Code: </label>
											<input type="text" class="input-medium" placeholder="CODE" />
											<button type="submit" class="shopBtn">ADD</button>
										</form>
									</td>
								</tr>
							</tbody>
						</table>
						<table class="table table-bordered">
							<tbody>
								<tr>
									<td>ESTIMATE YOUR SHIPPING & TAXES</td>
								</tr>
								<tr>
									<td>
										<form class="form-horizontal">
											<div class="control-group">
												<label class="span2 control-label" for="inputEmail">Country</label>
												<div class="controls">
													<input type="text" placeholder="Country" />
												</div>
											</div>
											<div class="control-group">
												<label class="span2 control-label" for="inputPassword">Post Code/
													Zipcode</label>
												<div class="controls">
													<input type="password" placeholder="Password" />
												</div>
											</div>
											<div class="control-group">
												<div class="controls">
													<button type="submit" class="shopBtn">
														Click to check the price
													</button>
												</div>
											</div>
										</form>
									</td>
								</tr>
							</tbody>
						</table>
						<a href="products.html" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping
						</a>
						<a href="login.html" class="shopBtn btn-large pull-right">Next <span
								class="icon-arrow-right"></span></a>
					</div>
				</div>
			</div>
			<content tag="script">
			<script>
				$(".edit-cart").on("click", function(){
					var id = $(this).data("id");
					var quanty = $("#qanty-cart-"+id).val();
					window.location = "EditCart/"+id+"/"+quanty;
				});
			</script>
			</content>
		</body>
		</html>