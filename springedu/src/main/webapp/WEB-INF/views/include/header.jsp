<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${contextPath }/webjars/owl.carousel/2.3.4/dist/assets/owl.carousel.css">
<link rel="stylesheet" href="${contextPath }/webjars/owl.carousel/2.3.4/dist/assets/owl.theme.default.css">
<%-- <script src="${contextPath }/webjars/jquery/3.5.1/jquery.js"></script> --%>
<script src="${contextPath }/webjars/owl.carousel/2.3.4/dist/owl.carousel.js"></script>
<script>
  $(document).ready(function () {
	  $(".owl-carousel").css('background-color', 'black');
	  
    $(".owl-carousel").owlCarousel(
      {
        items: 3, //화면에 표시할 항목 수
        loop:true, //무한 반복
        margin:20,
        dots: true,
        nav: true,
        navText:["이전", "다음"],
        autoplay: true,   //자동 스크롤
        autoplayTimeout: 3000, //자동 스크롤 시 시간 간격
        autoplayHoverPause: true, //마우스 호버 시 멈춤
        responsive:{
          0:{
              items:1
          },
          600:{
              items:3
          },
          1000:{
              items:5
          },
        },
      });
    });
</script>   
<header>
	<div class="container container-h">	
	  <div class="owl-carousel owl-theme">
	    <div class="item"><img src="https://cdn.pixabay.com/photo/2019/12/01/21/29/walk-4666509__340.jpg" alt=""></div>
	    <div class="item"><img src="https://cdn.pixabay.com/photo/2020/07/22/08/39/waterfall-5428467__340.jpg" alt=""></div>
	    <div class="item"><img src="https://cdn.pixabay.com/photo/2020/06/14/10/50/prague-5297386__340.jpg" alt=""></div>
	    <div class="item"><img src="https://cdn.pixabay.com/photo/2020/01/16/17/21/pantheon-4771206__340.jpg" alt=""></div>
	    <div class="item"><img src="https://cdn.pixabay.com/photo/2020/08/07/09/23/flower-5470156__340.jpg" alt=""></div>
	    <div class="item"><img src="https://cdn.pixabay.com/photo/2020/07/12/16/49/poppy-5397906__340.jpg" alt=""></div>
	    <div class="item"><img src="https://cdn.pixabay.com/photo/2020/07/23/07/10/market-5430564__340.jpg" alt=""></div>
  	</div>
	</div>
</header>

