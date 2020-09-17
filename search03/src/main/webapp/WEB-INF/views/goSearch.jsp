<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/resources/template/head.jspf"%>
<!--  
rss   -   디버그를 쉽게 하고 RSS 리더기만으로 이용할 수 있게 하기 위해 만든 RSS 포맷의 컨테이너이며 그 외의 특별한 의미는 없다.
channel   -   색 결과를 포함하는 컨테이너이다. 이 안에 있는 title, link, description 등의 항목은 참고용으로 무시해도 무방하다.
lastBuildDate   datetime   검색 결과를 생성한 시간이다.
postdate   datetime   블로그 포스트를 작성한 날짜이다.
total   integer   검색 결과 문서의 총 개수를 의미한다.
start   integer   검색 결과 문서 중, 문서의 시작점을 의미한다.
display   integer   검색된 검색 결과의 개수이다.
item/items   -   XML 포멧에서는 item 태그로, JSON 포멧에서는 items 속성으로 표현된다. 개별 검색 결과이며 title, link, description, bloggername, bloggerlink을 포함한다.
title   string   검색 결과 문서의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
link   string   검색 결과 문서의 하이퍼텍스트 link를 나타낸다.
description   string   검색 결과 문서의 내용을 요약한 패시지 정보이다. 문서 전체의 내용은 link를 따라가면 읽을 수 있다. 패시지에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
bloggername   string   검색 결과 블로그 포스트를 작성한 블로거의 이름이다.
bloggerlink   string   검색 결과 블로그 포스트를 작성한 블로거의 하이퍼텍스트 link이다.



rss	-	디버그를 쉽게 하고 RSS 리더기만으로 이용할 수 있게 하기 위해 만든 RSS 포맷의 컨테이너이며 그 외의 특별한 의미는 없다.
channel	-	검색 결과를 포함하는 컨테이너이다. 이 안에 있는 title, link, description 등의 항목은 참고용으로 무시해도 무방하다.
lastBuildDate	datetime	검색 결과를 생성한 시간이다.
total	integer	검색 결과 문서의 총 개수를 의미한다.
start	integer	검색 결과 문서 중, 문서의 시작점을 의미한다.
display	integer	검색된 검색 결과의 개수이다.
item/items	-	XML 포멧에서는 item 태그로, JSON 포멧에서는 items 속성으로 표현된다. 개별 검색 결과이며 title, link, description을 포함한다.
title	string	검색 결과 문서의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
link	string	검색 결과 문서의 하이퍼텍스트 link를 나타낸다.
image	string	썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타납난다.
author	string	저자 정보이다.
price	integer	정가 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
discount	integer	할인 가격 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
publisher	string	출판사 정보이다.
isbn	integer	ISBN 넘버이다.
description	string	검색 결과 문서의 내용을 요약한 패시지 정보이다. 문서 전체의 내용은 link를 따라가면 읽을 수 있다. 패시지에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
pubdate	datetime	출간일 정보이다.


책정보에 책 제목 찾기
$('#result>h2').text()

책정보에 총 페이지 수 찾기
var book_info_page = $('.book_info_inner div:contains("페이지")').text()
$('.book_info_inner div:contains("페이지")').text().substring( $('.book_info_inner div:contains("페이지")').text().indexOf('지')+1, $('.book_info_inner div:contains("페이지")').text().indexOf('|')).trim()

-->
<script type="text/javascript">
	var result;
	var startResult = 1;
	var scrollMove_cnt;
	
	function bookDetail(){
		/***********	책 이미지 눌렀을 때 bid를 이용해 서버에서 해당 책정보 받아오기	**********/
		$('.bid').each(function(){
			$(this).on('click',function(event){
				//event.preventDefault();
				//console.log($(this).prop('href'));
				$('#moreResult').hide();//더 보기 버튼 비활성화
				$('#moveTop').hide();//탑 버튼 비활성화
				var idxBid=$(this).prop('href').indexOf('bid');
				//console.log('book_id = '+$(this).prop('href').substring(idxBid+4));
				var bid = $(this).prop('href').substring(idxBid+4);
				book_id=bid; //전역변수 book_id에 bid를 저장. 검색된 책중 하나를 눌렀을 때 저장되는 값.
				
				/************* 데이터 초기화. 이전기록 남아있을 경우 대비 **************/
				
				location.href="find/book.bit?bid="+bid;
		 	
				
			
 			return false;//a tag 이동방지
			});
		});//each 검색된 책 bid로 상세정보 받아오기
		
	}//bookDetail function
	

	function bookSearch(start) {
		
		if($('#search').val().trim()==''){ 
			swal("검색 실패", "검색어를 입력해주세요.", "error");
			$('#cntOfTotal').text('책 제목을 입력하세요.');
			$('#moreResult').hide();//더 보기 버튼 비활성화
			$('#moveTop').hide();//탑 버튼 비활성화
			$('#putChapters').hide();//책 내서재담기 비활성화
			return;
		}else{
			$('#moreResult').show();//더 보기 버튼 활성화
			$('#moveTop').show();//탑 버튼 비활성화
		}
		$.ajax('search.bit', {
			'method' : 'get',
			'data' : 'search=' + $('#search').val()+'&start='+start,
			'dataType' : 'json',
			'success' : function(data) {
				result = data.items;
				//console.log(result);
				//console.log('total = ',data.total);
				$('#cntOfTotal').text(data.total+'건의 책이 검색되었습니다.');
				if(data.total==0||data.total<=10){ 
					$('#moreResult').hide();//더 보기 버튼 비활성화
					$('#moveTop').hide();//탑 버튼 비활성화
					return;
				}
				/************	검색된 책들 화면에 불러오기	*************/
				for (var i = 0; i < result.length; i++) {
					var content = '';
					var idxBid=result[i].link.indexOf('bid');
				//	console.log(result[i].link.substring(idxBid+4));
					var bid = result[i].link.substring(idxBid+4);
					scrollMove_cnt++;
					
					/* 
     				data-aos="fade-down"
     				data-aos="zoom-out-down"
    				data-aos="flip-down"
    				data-aos="flip-up"
					*/
					
					content += '<div id="scrollMove'+scrollMove_cnt+'" class="media" data-aos="fade-up"><div class="media-left media-middle">'
					content += '<a class="bid"  href="' + result[i].link + '">'  
					content += '<img class="media-object" src="' + result[i].image + '" alt="loading fail">'    
					content += '</a></div>'   
					content += '<div class="media-body">' 
					content += '<h4 class="media-heading">' + result[i].title + '</h4>' 
					content += '<p>' + result[i].author + '</p>';
					content += '<p>' + result[i].isbn + '</p>';
					content += '<p>' + result[i].image + '</p>';
					content += '</div>'  
					content += '</div><br/>'
					$('#result').append(content);
				}
				/***********	책 이미지 눌렀을 때 bid를 이용해 서버에서 해당 책정보 받아오기	**********/
				 bookDetail();
			}//success

		});//ajax
	}//booksearch function
	
	/*********************** Document Ready ***********************/
	$(function() {
		$('#moreResult').on('click',function(){ //더보기 버튼, 검색결과 10개씩 더 불러온다.
			startResult+=10;
			bookSearch(startResult);
			$('<a href="#scrollMove'+startResult+'"/>').wrap($('#aMove')).get(0).click();
		});//moreResult 버튼 클릭
		
		
		$('#moveTop').on('click',function(){ //탑 버튼, 문서 제일 위로 이동
			$(document).scrollTop(0);
		});//탑 버튼 클릭
		
			
		$('.search-form').submit(function() { //검색 form 전송 
			$('#result').html('');
			startResult=1; //검색결과들 중 읽어올 문서의 순서. ex:start=2 라면 10개 검색됐으면 2번째부터 출력
			scrollMove_cnt=1; //더보기 눌렀을 때 스크롤 이동시키기 위한 id값,검색버튼 누를때마다 초기화.
			bookSearch(startResult);
			return false
		});//submit
		
		
		if (!window.Cypress) {//aos 적용.
	        const scrollCounter = document.querySelector('.js-scroll-counter');

	        AOS.init({
	          mirror: true
	        });

	        document.addEventListener('aos:in', function(e) {
	          console.log('in!', e.detail);
	        });
	      }
		
		$('#putChapters,#moreResult,#moveTop').hide();//더보기, 내서재담기 버튼 숨기기
		
	});//ready
</script>
<style type="text/css">
/**** 크롬 자동포커스 아웃라인, 자동 배경색 채우기 해제 ****/
input,button{
	outline-style: none;
}
input:-webkit-autofill,
   input:-webkit-autofill:hover,
   input:-webkit-autofill:focus,
   input:-webkit-autofill:active {
 transition: background-color 5000s ease-in-out 0s;
 -webkit-transition: background-color 9999s ease-out;
    -webkit-box-shadow: 0 0 0px 1000px white inset !important;
    -webkit-text-fill-color: black !important;
  }
/******************************크롬****************************/

.search-form{
	/* width:400px; */
}
.input-search {
	line-height: 20px;
/* border:1px solid; */
	border-bottom:1px solid #e4e4e4;
	width:100%;

}


#search{
display: block;
  width: 100%;
  height: 34px;
  padding: 6px 12px;
  font-size: 14px;
  line-height: 1.42857143;
  border:0px;
 
}


#search-btn{
	border:0px;
}
#search-btn:hover{
	background-color: white;
}
#input_group_btn{
	width:30px;
}
</style>
<title>Insert title here</title>
<%@ include file="/resources/template/header.jspf"%>
<!-- ************************************ ↑ nav-bar **************************************** -->

		<div class="container-fluid">
			<div class="row" id="search_bar">
				<div class="col-md-12  col-sm-10">
					<div class="page-header">
						<h3>
							<span class="glyphicon glyphicon-book" aria-hidden="true"></span> 책 찾기 <br/><small id="cntOfTotal">책 제목을 입력하세요.</small>
						</h3>
					</div>
			</div>
				</div>
				</div>
			<div class="container-fluid">
			<div class="row">
			<div class="col-lg-6">
					<form action="#" class="search-form form-inline">
						<div class="input-search input-group">
							<input type="text" class="" placeholder="Search" name="search" id="search"/>
							<span class="input-group-btn" id="input_group_btn">
								<button type="submit" id="search-btn" class="btn btn-default btn-md">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
								</button>
							</span>
						</div>
						<br/>
						<a id="inputBook" class="text-success" href="#">+직접 입력하기</a>
						
						
						<a id="putChapters" class="btn btn-default" role="button"
							href="put.bit">내 서재에 담기</a>
					</form>
			</div>
			</div>
		<div class="row" id="contents">
				<!-- <input type="file" name="camara" id="camera" accept="image/*" capture="camera"/> -->
			<br/>
			<div class="col-md-12 col-sm-10" id="result"></div>
		</div>
		
		<div class="row">
			<button id="moreResult" class="btn btn-default"> 더 보기 </button>
			<button id="moveTop" class="btn btn-default"> Top </button>
			<span id="aMove"></span>
		</div>
			</div>
		
		
		

</div>
<%@ include file="/resources/template/footer.jspf"%>	
</body>
</html>