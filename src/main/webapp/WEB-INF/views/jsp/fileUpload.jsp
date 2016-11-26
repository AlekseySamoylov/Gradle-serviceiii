<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Upload Multiple File Request Page</title>
</head>
<body>
<spring:url value="/files/uploadMultipleFile" var="uploadUrl"/>
<form method="POST" action="${uploadUrl}" enctype="multipart/form-data">

    <input type="file" name="file"/>


    <input type="submit" value="Upload"> Press here to upload the file!
</form>
</body>
</html>