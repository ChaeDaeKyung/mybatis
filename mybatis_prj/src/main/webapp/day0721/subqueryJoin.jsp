<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js" integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y" crossorigin="anonymous"></script>    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="http://localhost/mybatis_prj/common/js/bootstrap.min.css"></script>
</head>
<style>
select {
	height: 30px;
}

</style>
<script type="text/javascript">
$(function(){
	$("#carCountry").change(setMaker);
	$("#carMaker").change(setModel);
	$("#carModel").change(setCarData);
//	$("#btn").click(setCarData);
});//ready

function setMaker(){
	if($("#carCountry").val() != "none"){
		$.ajax({
			url:"maker.jsp",
			type:"get",
			data:{ country : $("#carCountry").val() },
			dataType:"JSON",
			error:function( xhr ){
				alert("제조사 검색 중 문제 발생");
				console.log(xhr.status);
			},
			success:function(jsonObj){
				var select = $("#carMaker")[0];
				if(jsonObj.result){
					select.length = 1;
					$("#carModel")[0].length = 1;
					
					$.each(jsonObj.data, function(ind, jsonObjMaker){
						select.options[ind+1] = new Option( jsonObjMaker.maker,jsonObjMaker.maker );
					});
				}// end if
			}
		});//ajax
		
	}// end if
	
}//setMaker

function setModel(){
	if($("#carMaker").val() != "none"){
		$.ajax({
			url:"model.jsp",
			type:"get",
			data:{ maker : $("#carMaker").val() },
			dataType:"JSON",
			error:function( xhr ){
				alert("모델 검색 중 문제 발생");
				console.log(xhr.status);
			},
			success:function(jsonObj){
				var select = $("#carModel")[0];
				if(jsonObj.result){
					select.length = 1;
					$.each(jsonObj.data, function(ind, jsonObjModel){
						select.options[ind+1] = new Option( jsonObjModel.model , jsonObjModel.model );
					});
				}// end if
			}
		});//ajax
	}// end if
		
}//setModer

function setCarData(){
	var carModel = $("#carModel")[0];
	if(carModel.selectedIndex != 0){
		var param={model: $("#carModel").val()};
		$.ajax({
			url:"carData.jsp",
			data: param,
			type:"get",
			dataType:"JSON",
			error:function(xhr){
				alert("모델 조회 중 문제가 발생");
				console.log(xhr.status);
			},
			success:function(jsonObj){
				if(jsonObj.result){
					var tr = "";
					$.each(jsonObj.data, function(ind, jsonObjCar){
						tr += "<tr>";
						tr+=`
							<td>${ind+1}</td>
							<td><img src='../car_img/${jsonObjCar.car_img}' style='width:80px; height:40px;'/></td>
							<td>${jsonObjCar.maker}</td>
							<td>${jsonObjCar.model}</td>
							<td>${jsonObjCar.car_year}</td>
							<td>${jsonObjCar.price}</td>
							<td>${jsonObjCar.cc}</td>
							<td>${jsonObjCar.input_date}</td>
						`;
						tr+="</tr>";
					});//each
					$("#carTab tbody").empty();
					console.log(jsonObj.searchLength);
					if(jsonObj.searchLength == 0){
						tr=`<td colspan='8' style='text-align:center;'>
							검색하신 <strong>${ $("carModel").val() }</strong>는 재고가 없습니다.
						</td>`;
					}
					$("#carTab tbody").append(tr);
				}// end if
			}
		});
	}// end if
	
}//setCarData

</script>

<body>
	<div id="wrap">
		<div id="searchHeader" style="text-align: center; margin-top: 20px;">
			<select id="carCountry">
				<option value="none">--선택--</option>
				<option value="국산">국산</option>
				<option value="수입">수입</option>
			</select>
			<select id="carMaker">
				<option value="none">--선택--</option>
			</select>
			<select id="carModel">
				<option value="none">--선택--</option>
			</select>
			<input type="button" value="검색" class="btn btn-sm btn-primary" id="btn"/>
		</div>
		<div id="searchContent" style="margin-top: 20px;">
			<table class="table table-hover" id="carTab">
				<thead>
					<tr>
						<th>번호</th>
						<th>이미지</th>
						<th>제조사</th>
						<th>모델</th>
						<th>연식</th>
						<th>가격</th>
						<th>배기량</th>
						<th>입력일</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>