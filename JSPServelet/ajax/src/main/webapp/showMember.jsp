<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
</head>
<body>
<h1> 회원정보 </h1> 
<button id="btn"> 가져오기!</button>

<h1> 회원정보 보여주기 </h1>
<table id="showMember" border=1>
	<tr> 
		<td> email </td>
		<td> pw </td>
		<td> tel </td>
		<td> address </td>
	</tr>
</table>

<script>

$('#btn').on('click', function(){
	 	$.ajax({
	 		/* 어디로 보낼건지? */
	 		url : "ShowMember", 
			/* 어떤 데이터를 보낼 것인지? */
			/* data : {
				email : email
			}, */
			/* 데이터를 어떤 형태로 받아올 것인지 */
			dataType : "json", 
			/* 성공 시 */
			success : function(result){ 
				if(result==null){
					alert("result null")
				}else{
					alert("result 값 존재")
					console.log(result[0])
					makeTable(result)
				}
			},
			/* 실패 시 */
			error:function(e){
				alert('실패');
				console.log(e);
			}
			
		}) 
});

// 결과조회 성공 시 화면에 보여줄 makeTable메소드
function makeTable(result){
	for(var i=0; i<result.length; i++){
		$("#showMember").append("<tr> </tr>");
 	 	$("tr").last().append("<td>"+result[i].email+"</td>");
		$("tr").last().append("<td>"+result[i].pw+"</td>");
		$("tr").last().append("<td>"+result[i].tel+"</td>");
		$("tr").last().append("<td>"+result[i].address+"</td>"); 
	}
}
</script>

</body>
</html>