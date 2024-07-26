<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼 양식 요청 처리</title>
</head>
<body>
	<form action="/registerUserId" method="post">
		userId: <input type="text" name="userId" /><br> <input
			type="submit" value="registerUserId">
	</form>
	<form action="/registerMemberUserId" method="post">
		userId: <input type="text" name="userId" /><br> <input
			type="submit" value="registerMemberUserId">
	</form>
	<form action="/registerPassword" method="post">
		password: <input type="password" name="password" /><br> <input
			type="submit" value="registerPassword">
	</form>
	<form action="/registerRadio" method="post">
		gender: <br> <input type="radio" name="gender" value="male"
			checked>Male<br> <input type="radio" name="gender"
			value="female"> Female<br> <input type="radio"
			name="gender" value="other"> Other<br> <input
			type="submit" value="registerRadio">
	</form>
	<form action="/registerSelect" method="Post">
		nationality: <select name="nationality">
			<option value="Korea" selected>대한민국</option>
			<option value="Germany">독일</option>
			<option value="Australia">호주</option>
			<option value="Canada">캐나다</option>
		</select></br> <input type="submit" value="registerSelect">
	</form>
	<form action="/registerMultipleSelect01" method="post">
		cars: <select name="cars" multiple>
			<option value="volvo">Volvo</option>
			<option value="saab">Saab</option>
			<option value="opel">Opel</option>
			<option value="audi">Audi</option>
		</select><br> <input type="submit" value="registerMultipleSelect01">
	</form>
	<form action="/registerMultipleSelect02" method="post">
		carArray: <select name="carArray" multiple>
			<option value="volvo">Volvo</option>
			<option value="saab">Saab</option>
			<option value="opel">Opel</option>
			<option value="audi">Audi</option>
		</select><br> <input type="submit" value="registerMultipleSelect02">
	</form>
	<form action="/registerMultipleSelect03" method="post">
		carList: <select name="carList" multiple>
			<option value="volvo">Volvo</option>
			<option value="saab">Saab</option>
			<option value="opel">Opel</option>
			<option value="audi">Audi</option>
		</select><br> <input type="submit" value="registerMultipleSelect03">
	</form>
	<form action="/registerCheckbox01" method="post">
		hobby: <br> <input type="checkbox" name="hobby" value="Sports">
		Sports<br> <input type="checkbox" name="hobby" value="Music">
		Music<br> <input type="checkbox" name="hobby" value="Movie">
		Movie<br> <input type="submit" value="registerCheckbox01">
	</form>
	<form action="/registerCheckbox02" method="post">
		hobbyList: <br> <input type="checkbox" name="hobbyArray"
			value="Sports">Sports<br> <input type="checkbox"
			name="hobbyArray" value="Music">Music<br> <input
			type="checkbox" name="hobbyArray" value="Movie">Movie<br>
		<input type="submit" name="registerCheckbox02">
	</form>
	<form action="/registerCheckbox03" method="post">
		developer: <input type="checkbox" name="developer" value="Y"><br>
		<input type="submit" value="registerCheckbox03">
	</form>
	<form action="/registerCheckbox04" method="post">
		foreigner: <input type="checkbox" name="foreigner" value="false"><br>
		<input type="submit" value="registerCheckbox04">
	</form>
	<form action="/registerAddress" method="post">
		postCode: <input type="text" name="postCode" /><br> location: <input
			type="text" name="location" /><br> <input type="submit"
			value="registerAddress">
	</form>
	<form action="/registerUserAddress" method="post">
		address.postCode: <input type="text" name="address.postCode" /><br>
		address.location: <input type="text" name="address.location" /><br>
		<input type="submit" value="registerUserAddress">
	</form>
	<form action="/registerUserCardList" method="post">
		카드1 - 번호 : <input type="text" name="cardList[0].no" /><br>
		카드1 - 유효년월 : <input type="text" name="cardList[0].validMonth" /> <br><br>
		카드2 - 번호 : <input type="text" name="cardList[1].no" /><br>
		카드2 - 유효년월 : <input type="text" name="cardList[1].validMonth" /> <br><br>
		<input type="submit" value="registerUserCardList">
	</form>
	<form action="/registerTextArea" method="post">
		introduction: <br>
		<textarea name="introduction" rows="6" cols="50"></textarea>
		<br> <input type="submit" value="registerTextArea">
	</form>
	<form action="/registerDate01" method="post">
		dateOfBirth: <input type="text" name="dateOfBirth" /><br> <input
			type="submit" value="registerDate01">
	</form>
</body>
</html>