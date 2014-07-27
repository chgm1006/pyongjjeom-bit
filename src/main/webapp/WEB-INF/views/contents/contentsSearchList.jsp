<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp"%>


<!---- CSS  ---->
<link href="${pageContext.request.contextPath}/resources/css/contentsList.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/modalWindow.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jRating.jquery.css"
  media="screen" />


<article>
  <!-- ########################################### -->
  <!-- #################  Top으로 이동  ################# -->
  <!-- ########################################### -->
  <a id="quick" href="article" data-scroll> <img class="quickImg" src="">
  </a>

  <div class="contentsList">
    <div class="title3">검색 결과</div>
    <c:choose>
      <c:when test="${category =='movie'}">
        <c:forEach var="movie" items="${resultList }" varStatus="status">
          <div class="listWrap">
            <div class="imgWrap" id="imgWrapMovie">
              <a class="btnDetail" href="#"> <img class="listImg" src="${movie.image}">
                <p class="statusIndex">${status.index}</p>
              </a>
            </div>
            <div class="listTable">
              <table>
                <tr>
                  <td class="tableTitle" colspan="2"><a class="tableTitleLink" id="tableTitleLinkMovie" href="#">${movie.title }
                      <p class="statusIndex">${status.index}</p>
                  </a></td>
                </tr>
                <tr>
                  <td class="tableTitle2">부제</td>
                  <td class="tableCont">${movie.subtitle }</td>
                </tr>
                <tr>
                  <td class="tableTitle2">감독</td>
                  <td class="tableCont">${movie.director }</td>
                </tr>
                <tr>
                  <td class="tableTitle2">출연</td>
                  <td class="tableCont">${movie.actor }</td>
                </tr>
                <tr>
                  <td class="tableTitle2">개봉년도</td>
                  <td class="tableCont">${movie.pubDate }</td>
                </tr>
              </table>
              <div class="listButtonWrap">
                <a class="listButton" href="${movie.link }" target="_blank">네이버 상세</a> <a class="listButton" href="#">예고편보기</a>
                <a class="listButton" href="#">포토보기</a>
              </div>
            </div>
          </div>
        </c:forEach>
      </c:when>

      <c:when test="${category =='book'}">
        <c:forEach var="book" items="${resultList }" varStatus="status">
          <div class="listWrap">
            <div class="imgWrap" id="imgWrapBook">
              <a class="btnDetail" href="#"> <img class="listImg" src="${book.image}">
                <p class="statusIndex">${status.index}</p>
              </a>
            </div>

            <div class="listTable">
              <table>
                <tr>
                  <td class="tableTitle" colspan="2"><a class="tableTitleLink" id="tableTitleLinkBook" href="#">${book.title }
                      <p class="statusIndex">${status.index}</p>
                  </a></td>
                </tr>
                <tr>
                  <td class="tableTitle2">저자</td>
                  <td class="tableCont">${book.author }</td>
                </tr>
                <tr>
                  <td class="tableTitle2">출판사</td>
                  <td class="tableCont">${book.publisher }</td>
                </tr>
                <tr>
                  <td class="tableTitle2">출간일</td>
                  <td class="tableCont">${book.pubdate }</td>
                </tr>
                <tr>
                  <td class="tableTitle2">책내용</td>
                  <td class="tableCont">${book.description }</td>
                </tr>
              </table>
              <div class="listButtonWrap">
                <a class="listButton" href="${book.link }" target="_blank">네이버 상세</a> <a class="listButton"
                  href="www.kyobobook.co.kr">사러가기</a>
              </div>
            </div>
          </div>
        </c:forEach>

      </c:when>
    </c:choose>


    <!------------------- 더보기 버튼 -------------------->
    <a href="#" class="listMore">더보기</a>
  </div>

  <!-- ################################################# -->
  <!-- #################    모달윈도우 : 영화상세    ################# -->
  <!-- ################################################# -->

  <!-- /// 모달윈도우 영화 INCLUDE /// -->
  <%@ include file="../common/modalContentsSearchList.jsp"%>


  <!-- /// 모달윈도우 도서 INCLUDE /// -->
  <%@ include file="../common/modalBookIndex.jsp"%>



</article>



<!-- ########################################### -->
<!-- #################    FOOTER    ################# -->
<!-- ########################################### -->

<!-- /// <footer> INCLUDE /// -->
<%@ include file="../common/footer.jsp"%>



<script type="text/javascript" language="javascript"
  src="${pageContext.request.contextPath}/resources/js/smooth-scroll.js"></script>
<script type="text/javascript" language="javascript"
  src="${pageContext.request.contextPath}/resources/js/jqueryContentsSearchList.js"></script>

<script type="text/javascript" language="javascript"
  src="${pageContext.request.contextPath}/resources/js/jqueryContentsSearchListBook.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scrollBanner2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jRating.jquery.js"></script>





</body>
</html>
