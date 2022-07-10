<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    
<!DOCTYPE html>
<html lang="en">
<head>
<title>java33savetravels</title>
<meta charset="UTF-8">
<!-- local css -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- local javascript -->
<script type ="text/javascript" src="javascript/app.js"></script>
<!--  Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> 
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>java33savetravels - Create New Book</h1>
	<a href= "/books">Books</a>
	<!-- <a href= "/counter">Site Visit Counter</a> -->
	
	<form action='/processNewBook' method='post'>
	  <div class="form-group">
	    <label for="title">Title</label>
	    <input type="text" class="form-control" id="title" name="title" aria-describedby="titleHelp" placeholder="Enter Title">
	    <small id="titleHelp" class="form-text text-muted">Better be a good title!</small>
	  </div>
	  
	  <div class="form-group">
	    <label for="description">Description</label>
	    <input type="text" class="form-control" id="description" name="description" placeholder="Description here">
	  </div>
	  
	  <div class="form-group">
	    <label for="language">Language</label>
	    <input type="text" class="form-control" id="language" name="language" placeholder="lang here">
	  </div>
	  
	  <div class="form-group">
	    <label for="numberOfPages">Page Count</label>
	    <input type="number" class="form-control" id="numberOfPages" name="numberOfPages" >
	  </div>
	  <!-- <div class="form-check">
	    <input type="checkbox" class="form-check-input" id="exampleCheck1">
	    <label class="form-check-label" for="exampleCheck1">Check me out</label>
	  </div> -->
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
	
</body>
</html>