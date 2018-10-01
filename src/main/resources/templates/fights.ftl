<form method="get" action="/fights">
    <#list fights as fight>
        ${fight}
    <#else>
        No fight
    </#list>
</form>