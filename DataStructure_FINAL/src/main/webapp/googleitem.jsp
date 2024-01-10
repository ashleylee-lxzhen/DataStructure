<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Topic Listing Page</title>

        <!-- CSS FILES -->        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500;600;700&family=Open+Sans&display=swap" rel="stylesheet">
                        
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link href="css/templatemo-topic-listing.css" rel="stylesheet">
<!--

TemplateMo 590 topic listing

https://templatemo.com/tm-590-topic-listing

-->
</head>
 <body class="topics-listing-page" id="top">

        <main>
            <header class="site-header d-flex flex-column justify-content-center align-items-center">
                <div class="container">
                    <div class="row align-items-center">

                        <div class="col-lg-5 col-12">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item active" aria-current="page" style="font-size: xx-large;">Search Result</li>
                                </ol>
                            </nav>

                            <h2 class="text-white">搜尋結果</h2>
                            <!-- <button onclick='location.href=("index.html")' style="background: var(--custom-btn-bg-color);
border: none;
border-radius: var(--border-radius-large);
color: var(--white-color);
font-family: var(--title-font-family);
font-size: var(--p-font-size);
font-weight: var(--font-weight-semibold);
transition: all 0.3s;
margin-bottom: 0;">上一頁</button> -->
  
                        </div>
                        <form action='${requestUri}' method="get" class="custom-form mt-4 pt-2 mb-lg-0 mb-5" role="search">
                            <div class="input-group input-group-lg">
                                <span class="input-group-text bi-search" id="basic-addon1" style="margin-bottom: 24px;">
                                    
                                </span>
                                <input name="keyword" type="search" class="form-control" id="keyword" placeholder="輸入想搜尋的關鍵字..." aria-label="Search" style="margin-bottom: 24px;">
                                <button type="button" class="form-control"  style="margin-bottom: 24px;">搜尋</button>
                            </div>
                        </form>
                    </div>
                    
                </div>
                
            </header>

            
            <section class="section-padding">
                <div class="container">
                    <div class="row">

            </div>
                </div>
            </section>
<script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function() {
    var booksContainer = document.querySelector('.row');

    var i = 1;
        var blockDiv = document.createElement('div');
        blockDiv.className = 'custom-block custom-block-topics-listing bg-white shadow-lg mb-5';
        blockDiv.innerHTML = `
            <div class="d-flex">
                <div class="custom-block-topics-listing-info d-flex">
                    <div>
                    <%
                    String[][] orderList = (String[][]) request.getAttribute("query");
                    for (int i = 0; i < orderList.length; i++) {
                        String s=orderList[i][1];
                    %>
                    
                    <a href='<%=s%>'><%=orderList[i][0]%> </a> <br><br>
                    <br>
                    <%
            }
            %>
                  
                    </div>
                </div>
            </div>
        `;
        booksContainer.appendChild(blockDiv);
    
});

</script>
    </body>
</html>