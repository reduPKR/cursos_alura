<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/nova-empresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de cadastro da nova empresa</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="post">

		Nome: <input type="text" name="nome"/><br>
		Data de abertura: <input type="text" name="data"/>
		<input type = "submit"/>
	</form>

</body>
</html>