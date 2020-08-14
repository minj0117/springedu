<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	main .container .content section {
 		display:grid;
 		grid-template-columns: repeat(3,1fr);
 		grid-auto-rows: minmax(200px, auto);
  	grid-gap: 10px;
 	}
 	main .container .content section article {
 		/* outline: 1px dotted red; */
 		display:flex;
 		justify-content: center;
 		align-items: center;
/*  		padding: 30px; */
 	}
 	main .container .content section article:nth-child(1){
 	
 	}
 	main .container .content section article:nth-child(2){

 	}
 	main .container .content section article:nth-child(3){

 	}
 	main .container .content section article:nth-child(4){

 	}
 	main .container .content section article:nth-child(5){
		background: #eeff41;
 	}
 	main .container .content section article:nth-child(6){
 		background: #90caf9;
 	}
 	main .container .content section article:nth-child(7){

 	}
 	main .container .content section article:nth-child(8){
 		background: #9fa8da;
 	}
 	main .container .content section article:nth-child(9){
 		background: #f48fb1;
 	} 	
</style>    
    
	<main>
		<div class="container">
			<div class="content">
				<section>
					<article>
					<div class="card" style="width: 18rem;">
					  <img src="https://cdn.pixabay.com/photo/2019/10/21/14/54/oranges-4566275__340.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
					  </div>
	  			  <div class="card-footer">
  					<small class="text-muted">Last updated 3 mins ago</small>
					</div>
					</article>
					<article>
						<div class="card" style="width: 18rem;">
					  <img src="https://cdn.pixabay.com/photo/2019/10/21/14/54/oranges-4566275__340.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
					  </div>
	  			  <div class="card-footer">
  					<small class="text-muted">Last updated 3 mins ago</small>
					</article>
					<article>
						<div class="card" style="width: 18rem;">
					  <img src="https://cdn.pixabay.com/photo/2019/10/21/14/54/oranges-4566275__340.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
					  </div>
	  			  <div class="card-footer">
  					<small class="text-muted">Last updated 3 mins ago</small>
					</article>
					<article>
						<div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
						  <div class="card-header">Header</div>
						  <div class="card-body">
						    <h5 class="card-title">Primary card title</h5>
						    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
						  </div>
						</div>
					</article>
					<article>5</article>
					<article>6</article>
					<article>
						<div class="card border-danger mb-3" style="max-width: 18rem;">
						  <div class="card-header">Header</div>
						  <div class="card-body text-danger">
						    <h5 class="card-title">Danger card title</h5>
						    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
						  </div>
						</div>					
					</article>
					<article>8</article>
					<article>9</article>
				</section>			
			</div>
		</div>
	</main>