<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/custom.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <style>
    body {
        margin-top: 60px;
    }
    </style>

</head>

<body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Smart Messaging Framework</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="home.jsp">Home</a>
                    </li>
                    <li><a href="templates.jsp">Templates</a>
                    </li>
					<li><a href="home.jsp">FAQ</a>
                    </li>
                    <li><a href="#">Starter Guide</a>
                    </li>
					
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">
  
		<div class="container">
		<div class="row">
	  <h3>Welcome <% out.println(request.getAttribute("user"));  %></h3>
			<h3> Your Primary Key Word is: "<strong>GRIET</strong>" </h3>
	  
    </div>
  </div>
  <hr>
  <div class="row">
    <div class="col-sm-4">
      <div class="tile orange" onclick="location.href='templates.jsp';" style="cursor: pointer;">
        <h3 class="title">Choose from Our Templates</h3>
        <p>Save your time by choosing our preconfigured templates</p>
      </div>
    </div>
	<div class="col-sm-4">
      <div class="tile purple"  onclick="location.href='uploadExcel.jsp';" style="cursor: pointer;">
        <h3 class="title">Upload a New Excel Sheet</h3>
        <p>Please upload excel sheets in .xls or .xlsx format only</p>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="tile red" onclick="location.href='#';" style="cursor: pointer;">

        <h3 class="title">View Uploaded Excel Sheets</h3>
        <p>View/Update/Delete already uploaded excel sheets</p>
      </div>
    </div>
    
  </div> 
  
 <hr>
  <div class="row">
    <div class="col-sm-4">
      <div class="tile green" onclick="location.href='testSMS.jsp';" style="cursor: pointer;">
        <h3 class="title">Test your data</h3>
        <p>Test whether the data you have uploaded can be pulled through SMS accurately</p>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="tile gold">
        <h3 class="title">Reports</h3>
        <p>View logs and know who pulled your data through SMS</p>
      </div>
    </div> 
    <div class="col-sm-4">
      <div class="tile blue">
        <h3 class="title">Account info</h3>
        <p>View/Modify/Edit your account information</p>
      </div>
    </div>
  </div>
</div>

        <!-- https://editor.datatables.net/release/DataTables/extras/Editor/examples/inlineControls.jsp -->


        </div>
	
    </div>
    <!-- /.container -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>


</body>

</html>
