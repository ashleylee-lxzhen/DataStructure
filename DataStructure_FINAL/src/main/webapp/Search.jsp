<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Topic Listing Bootstrap 5 Template</title>

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
    <body id="top">

        <main>           

            <section class="hero-section d-flex justify-content-center align-items-center" id="section_1">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-8 col-12 mx-auto">
                            <h1 class="text-white text-center">書籍搜尋引擎</h1>

                            <h6 class="text-center">best search engine for books</h6>

                            <form  action='${requestUri}'method="get" class="custom-form mt-4 pt-2 mb-lg-0 mb-5" role="search">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-text bi-search" id="basic-addon1">
                                        
                                    </span>

                                    <input name="keyword" type="search" class="form-control" id="keyword" placeholder="輸入想搜尋的關鍵字..." aria-label="Search">

                                    <button type="button" class="form-control" >搜尋</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>


            <section class="featured-section">
                <div class="container">
                    <div class="row justify-content-center">

                        <div class="col-lg-4 col-12 mb-4 mb-lg-0">
    <div class="custom-block bg-white shadow-lg">
        <div class="d-flex flex-column">
            <h5 class="mb-2">熱搜關鍵字</h5>
            <!-- List of hot keywords -->
            <ol class="list-group list-group-numbered">
                <li class="list-group-item">暖暖包</li>
                <li class="list-group-item">星巴克</li>
                <li class="list-group-item">名偵探柯南</li>
                <li class="list-group-item">葬送的芙莉蓮</li>
                <li class="list-group-item">spy family</li>
            </ol>
        </div>
    </div>
</div>

<div class="col-lg-6 col-12">
    <div class="custom-block custom-block-overlay">
        <h5 class="mb-2" style="margin-left: 15px;color: white; border: black;">暢銷書籍排行</h5>
        <!-- List of best-selling books -->
        <div class="d-flex flex-column h-100">
            <!-- <div class="custom-block bg-white shadow-lg mb-3">
                <div class="d-flex align-items-center p-3">
                    <img src="images/book-1.jpg" class="custom-block-image img-fluid" alt="要有一個人：澈讀22種人生，你的人生有無限可能！">
                    <div class="ms-3">
                        <p class="fw-bold mb-0">要有一個人：澈讀22種人生，你的人生有無限可能！</p>
                    </div>
                </div>
            </div> -->
            <div class="custom-block bg-white shadow-lg mb-3">
                <div class="d-flex align-items-center p-3">
                    <img src="images/book-1.jpg" class="custom-block-image img-fluid" alt="要有一個人：澈讀22種人生，你的人生有無限可能！">
                        <div class="ms-3">
                            <a href="https://www.books.com.tw/products/0010976759?sloc=main" target="_blank">
                            <p class="fw-bold mb-0">要有一個人：澈讀22種人生，你的人生有無限可能！</p>
                            </a>
                        </div>
                </div>
            </div>
            
            <div class="custom-block bg-white shadow-lg mb-3">
                <div class="d-flex align-items-center p-3">
                    <img src="images/book-2.jpg" class="custom-block-image img-fluid" alt="我的日本爸爸">
                    <div class="ms-3">
                        <a href="https://www.books.com.tw/products/0010976755" target="_blank">
                        <p class="fw-bold mb-0">我的日本爸爸</p></a>
                    </div>
                </div>
            </div>
            <div class="custom-block bg-white shadow-lg mb-3">
                <div class="d-flex align-items-center p-3">
                    <img src="images/book-3.jpg" class="custom-block-image img-fluid" alt="林業及自然保育署2024年《奇幻之森》月曆">
                    <div class="ms-3">
                        <a href="https://www.books.com.tw/products/0010970515?sloc=main" target="_blank">
                        <p class="fw-bold mb-0">林業及自然保育署2024年《奇幻之森》月曆</p>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
        

                    </div>
                </div>
            </section>
    </body>
</html>