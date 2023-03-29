<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ajax Test</title>
<script type="module" defer>
	document.querySelector("#button").addEventListener("click", regist);
    
	function regist() {
      let member = {
        id: "bangry",
		password : "1111",
        name: "김기정",
        age: 20
      };

      let option = {
        method: "post",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(member),
      };

      //fetch("/request-json", option)
      fetch("/request-json2", option)
        .then(respose => respose.json())
        .then(result => receiveJson(result))
        .catch(error => console.log(error));
    }

    function receiveJson(member) {
      //alert(result);
		console.log(member.id);
	  document.querySelector("#result").innerHTML = "아이디: "+ member.id + "이름: " + member.name;
    }
  </script>
</head>
<body>
  <h2>회원가입 화면</h2>
  <button id="button">등록</button>
  <h2>회원가입 결과</h2>
  <p id="result"></p>
</body>
</html>





