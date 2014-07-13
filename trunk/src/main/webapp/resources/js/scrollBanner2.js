var xPosition = 0;  // 가로 위치 값
var yPosition = 0;   // 세로 위치 값
var yStartPosition = 400;  // 퀵메뉴 시작 위치
var Ygravity = 0.05;  // B타입인 경우 움직임 속도
var scrollPosition = 0;   // 현재 스크롤의 세로 위치값
var Y_B = 0;
var Y_A = 0;
var quickmenu;      // 퀵메뉴 엘리먼트
var quickType = "b";  // 퀵메뉴 타입 (A:귀여운타입, B:일반)
var quickmenuTop = 0;   // 퀵메뉴 엘리먼트의 TOP 위치 
 
function quickMenu() {
 quickmenu = $("#quick"); //퀵메뉴의 id
 scrollPosition = $(window).scrollTop();
    Y_B = parseInt(yStartPosition + scrollPosition);
    quickmenuTop = quickmenu.offset().top;

    // ---[A TYPE]--------------------------------------------------------------
    if (quickType == "A") {
        if (parseInt(quickmenu.offset().top) < Y_B - 1){
            yPosition += 2;
        } else if (parseInt(quickmenu.offset().top) > Y_B + 1){
            yPosition -= 2;
		}
        yPosition *= Ygravity;
        quickmenu.css("top", (parseInt(quickmenuTop + yPosition)) + "px");
        // ---[B TYPE]--------------------------------------------------------------  
    } else {
        Y_A = parseInt(quickmenuTop, 10);
        if (Y_A != Y_B) {
            yOffset = Math.ceil(Math.abs(Y_B - Y_A) / 30);
            if (Y_B < Y_A)
                yOffset = -yOffset;
            quickmenu.css("top", (parseInt(quickmenuTop, 10) + yOffset) + "px");
        }
    }
    // -------------------------------------------------------------------------
}
$(document).ready(function(e) {
	window.setInterval("quickMenu()", 1); 
});
