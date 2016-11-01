<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<form action="<c:out value="${pageContext.request.contextPath}"/>/welcome">
	
		<h1>This is 222 <c:out value="${requestScope.servername}"/></h1>
		<%-- <h1>This is <%=request.getAttribute("servername") %></h1> --%>
		
		input：<input type="text" name="userName" /><input type="submit"
			value="submit" /> <br />
	</form>
	
<div class="header_top">
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse"
					 data-target="#bs-example-navbar-collapse-1"> 
					 <span class="sr-only">Toggle navigation</span>
					 <span class="icon-bar"></span>
					 <span class="icon-bar"></span>
					 <span class="icon-bar"></span>
					 </button> 
					 <div class="logo">
						<a href="index.html"><img 
						src="<c:out value="${pageContext.request.contextPath}"/>/pages/images/cp_logo_small.jpg" alt=""></a>
					</div>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control"
								value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
						</div> <button type="submit" class="btn btn-default">Submit</button>
					</form>
					
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span> Register</a></li> 
						<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> 
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">English<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="#">English</a>
								</li>
								<li>
									 <a href="#">Chinese (Simplified)</a>
								</li>
								<li>
									 <a href="#">Chinese (Traditional)</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">Current: English</a>
								</li>
							</ul>
						</li>
					</ul>
					
					
				</div>
			</nav>
		</div>
	</div>
</div>
</div>


<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form">
				<div class="form-group">
					 <label for="exampleInputEmail1">Email address</label><input type="email" class="form-control" id="exampleInputEmail1" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="exampleInputPassword1" />
				</div>
				<div class="checkbox">
					 <label><input type="checkbox" />Check me out</label>
				</div> <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
</div>
