<!DOCTYPE html>
<html>
    <head>
        <title>Spring Boot Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <form method="get" action="/index">
        <#list sportsmans as sportsman>
            ${sportsman.firstName}
        <#else>
            No sportsman
        </#list>
    </form>
</body>
</html>