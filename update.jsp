<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% MemberDTO member = (MemberDTO) session.getAttribute("member"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<ui>
			<li><h1>ȸ�� ���� ���� ������</h1></li>
			<form action = "UpdateCon" method = "post">
				<li>������ id : <%= member.getId() %> </li>
				<li><input type="text" name="pw" placeholder="PW�� �Է��ϼ���"></li>
				<li><input type="text" name="nick" placeholder="�г����� �Է��ϼ���"></li>
				<li><input type="text" name="phone" placeholder="��ȭ��ȣ�� �Է��ϼ���"></li>
				<li><input type="submit" value="UPDATE" class="button fit"></li>
			</form>
		</ui>
	</div>
</body>
</html>