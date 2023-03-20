<%@include file="/common/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Twitter Bootstrap shopping cart</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta name="description" content="">
            <meta name="author" content="">
            <!-- Bootstrap styles assets/css/bootstrap.css -->
            <!-- <link href="assets/css/bootstrap.css" rel="stylesheet"/> -->
			<link href="<c:url value='/template/user/assets/css/bootstrap.css'/>" rel="stylesheet" />
            <!-- Customize styles -->
            <!-- <link href="style.css" rel="stylesheet"/> -->
            <link href="<c:url value='/template/style.css'/>" rel="stylesheet" />
            <!-- font awesome styles -->
            <!-- <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"> -->
            <link href="<c:url value='/template/user/assets/font-awesome/css/font-awesome.css'/>" rel="stylesheet" />
            <!--[if IE 7]>
			<link href="css/font-awesome-ie7.min.css" rel="stylesheet">
		<![endif]-->

            <!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

            <!-- Favicons -->
            <!-- <link rel="shortcut icon" href="assets/ico/favicon.ico"> -->
            <link rel="shortcut icon" href="<c:url value='/template/admin/assets/ico/favicon.ico'/>">
            <dec:head/>
        </head>

        <body>

            <%@include file="/common/user/header.jsp" %>

            <dec:body />

            <%@include file="/common/user/footer.jsp" %>

                    <!-- Placed at the end of the document so the pages load faster -->
                    <!-- <script src="assets/js/jquery.js"></script> -->
                    <script src="<c:url value='template/user/assets/js/jquery.js'/>"></script>
                    <!-- <script src="assets/js/bootstrap.min.js"></script> -->
                    <script src="<c:url value='template/user/assets/js/bootstrap.min.js'/>"></script>
                    <!-- <script src="assets/js/jquery.easing-1.3.min.js"></script> -->
                    <script src="<c:url value='template/user/assets/js/jquery.easing-1.3.min.js'/>"></script>
                    <!-- <script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script> -->
                    <script src="<c:url value='template/user/assets/js/jquery.scrollTo-1.4.3.1-min.js'/>"></script>
                    <!-- <script src="assets/js/shop.js"></script> -->
                    <script src="<c:url value='template/user/assets/js/shop.js'/>"></script>
        </body>

        </html>