<form method="get" action="/index">
    <#list sportsmans as sportsman>
        ${sportsman.firstName}
        ${sportsman.lastName}
        ${sportsman.alias}
    <#else>
        No sportsman
    </#list>
</form>
