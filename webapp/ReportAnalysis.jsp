<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<%if(session.getAttribute("sessionADMINID")==null)    
    response.sendRedirect("adminLogin.jsp"); %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="book.model.Admin" %> 
<%@ page import="book.model.*" %> 
<%@ page import = "java.util.*"%> 
<!DOCTYPE html> 
<html lang="en"> 
<head> 
  <meta charset="UTF-8" /> 
  <title>Report Analysis </title> 
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script> 
  <link rel="stylesheet" href="css/reportAnalysisStyle.css" /> 
  <!-- Font Awesome Cdn Link --> 
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" /> 
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" /> <!-- untuk backbutton -->

<!-- untuk back button -->
<style>

.back-button {
		position: ;
		top: 20px;
		left: 20px;
	}

	.back-button a {
		display: inline-flex;
		align-items: center;
		padding: 10px 15px;
		background-color: #333;
		color: #fff;
		text-decoration: none;
		border-radius: 5px;
	}

	.back-button a i {
		margin-right: 5px;
	}

	.back-button a:hover {
		background-color: #555;
	}
	input:disabled:hover,
  input[readonly]:hover {
    background-image: url('path/to/ban-icon.png');
    background-repeat: no-repeat;
    background-position: right center;
    background-size: 20px 20px;
    padding-right: 30px; /* Adjust padding to make space for the icon */
    cursor: not-allowed;
  }
</style>
   
 
</head> 
<body>  

  <header class="header"> 
    <div class="logo"> 
      <a href="Admin.jsp">UiTM Preloved Book Depository System</a> 
      <div class="search_box"> 
        <input type="text" placeholder="Search book by title" id="btitle" > 
         <button onclick="handleButtonClick()"> 
        <i class="fa-sharp fa-solid fa-magnifying-glass"></i> 
       </button> 
      </div> 
    </div> 

     
     
 <div class="header-icons"> 
  <a href="homepage.jsp" title="Log Out" onclick="return confirmLogout()"><i class="fas fa-sign-out-alt"> Log Out</i></a> 
   <div class="account"> 
   <p style="font-size: 30px;"><a>&#128100;</a></p> 
        <h4>Welcome <c:out value='${sessionScope.sessionADFNAME}'/></h4> 
       <!--<h4>Muhaimin Azam</h4>--> 
      </div> 
    </div> 
  </header> 
  <div class="container"> 
     <!-- untuk back button -->
<div class="back-button">
	<a href="Admin.jsp">
		<i class="fas fa-arrow-left"></i> 
	</a>
</div>
     
<div class="chart"> 
 <h3>Total Book for each Type</h3>
<canvas id="myChart"></canvas> 
    <script> 
        var chartData = { 
            labels: [ 
                <c:forEach items="${chartList}" var="chart" varStatus="loop"> 
                    '<c:out value="${chart.label}" />'${not loop.last ? ',' : ''} 
                </c:forEach> 
            ], 
            datasets: [{ 
                label: '',
                data: [ 
                    <c:forEach items="${chartList}" var="chart" varStatus="loop"> 
                    '<c:out value="${chart.count}" />'${not loop.last ? ',' : ''} 
                    </c:forEach> 
                ], 
                backgroundColor: ['rgba(0, 123, 255, 0.5)',
			                	'rgba(255, 0, 0, 0.5)',
			                	'rgba(0, 255, 0, 0.5)',
			                	'rgba(255, 255, 0, 0.5)',
			                	'rgba(128, 0, 128, 0.5)',
			                	'rgba(255, 105, 180, 0.5)',] 
            }] 
        }; 
 
        var ctx = document.getElementById('myChart').getContext('2d'); 
        var myChart = new Chart(ctx, { 
            type: 'bar', 
            data: { 
                labels: chartData.labels, 
                datasets: chartData.datasets 
            } 
        }); 
    </script> 
    </div>
    
     <div class="bottom"> 
     <h3>Total Order Handle by each Admin</h3>
    <canvas id="oChart"></canvas> 
    <script> 
        var chartData = { 
            labels: [ 
                <c:forEach items="${oChart}" var="chart" varStatus="loop"> 
                    '<c:out value="${chart.oName}" />'${not loop.last ? ',' : ''} 
                </c:forEach> 
            ], 
            datasets: [{ 
                label: 'Book Handle', 
                data: [ 
                    <c:forEach items="${oChart}" var="chart" varStatus="loop"> 
                    '<c:out value="${chart.oCount}" />'${not loop.last ? ',' : ''} 
                    </c:forEach> 
                ], 
                backgroundColor: [ 
                	'rgba(0, 123, 255, 0.5)',
                	'rgba(255, 0, 0, 0.5)',
                	'rgba(0, 255, 0, 0.5)',
                	'rgba(255, 255, 0, 0.5)',
                	'rgba(128, 0, 128, 0.5)',
                	'rgba(255, 105, 180, 0.5)',
                	'rgba(210, 105, 30, 0.5)',
                	'rgba(128, 128, 128, 0.5)',
                    
                    // Add more colors for each label if needed 
                ] 
            }] 
        }; 
 
        var ctx = document.getElementById('oChart').getContext('2d'); 
        var myChart = new Chart(ctx, { 
         type: 'bar', 
            data: { 
                labels: chartData.labels, 
                datasets: chartData.datasets 
            }, 
            options: { 
                plugins: { 
                    legend: { 
                        position: 'bottom', 
                    }, 
                }, 
            } 
        }); 
    </script> 
 
  
 </div> 
<div class="chart">    
<h3>Total Resident/Nonresident Student</h3>
  <canvas id="stChart"></canvas> 
    <script> 
        var chartData = { 
            labels: [ 
                <c:forEach items="${stChart}" var="chart" varStatus="loop"> 
                    '<c:out value="${chart.stLabel}" />'${not loop.last ? ',' : ''} 
                </c:forEach> 
            ], 
            datasets: [{ 
                label: 'Student Count', 
                data: [ 
                    <c:forEach items="${stChart}" var="chart" varStatus="loop"> 
                    '<c:out value="${chart.stNum}" />'${not loop.last ? ',' : ''} 
                    </c:forEach> 
                ], 
                backgroundColor: ['rgba(0, 123, 255, 0.5)',
                				'rgba(255, 0, 0, 0.5)',] // Red background color
                
            }] 
        }; 
 
        var ctx = document.getElementById('stChart').getContext('2d'); 
        var myChart = new Chart(ctx, { 
            type: 'pie', 
            data: { 
                labels: chartData.labels,
                datasets: chartData.datasets 
            }, 
            options: { 
                plugins: { 
                    legend: { 
                        position: 'bottom', 
                    }, 
                }, 
            } 
        }); 
    </script> 
     </div>
     <div class="chart"> 
     <h3>Total Book Handle by each Admin</h3>
    <canvas id="aChart"></canvas> 
    <script> 
        var chartData = { 
            labels: [ 
                <c:forEach items="${aChart}" var="chart" varStatus="loop"> 
                    '<c:out value="${chart.aName}" />'${not loop.last ? ',' : ''} 
                </c:forEach> 
            ], 
            datasets: [{ 
                label: 'Book Handle', 
                data: [ 
                    <c:forEach items="${aChart}" var="chart" varStatus="loop"> 
                    '<c:out value="${chart.aCount}" />'${not loop.last ? ',' : ''} 
                    </c:forEach> 
                ], 
                backgroundColor: [ 
                	'rgba(0, 123, 255, 0.5)',
                	'rgba(255, 0, 0, 0.5)',
                	'rgba(0, 255, 0, 0.5)',
                	'rgba(255, 255, 0, 0.5)',
                	'rgba(128, 0, 128, 0.5)',
                	'rgba(255, 105, 180, 0.5)',
                	'rgba(210, 105, 30, 0.5)',
                	'rgba(128, 128, 128, 0.5)',
                    
                    // Add more colors for each label if needed 
                ] 
            }] 
        }; 
 
        var ctx = document.getElementById('aChart').getContext('2d'); 
        var myChart = new Chart(ctx, { 
         type: 'pie', 
            data: { 
                labels: chartData.labels, 
                datasets: chartData.datasets 
            }, 
            options: { 
                plugins: { 
                    legend: { 
                        position: 'bottom', 
                    }, 
                }, 
            } 
        }); 
    </script> 
 
  
 </div> 
 
 

 
  </div> 
</body> 
</html>