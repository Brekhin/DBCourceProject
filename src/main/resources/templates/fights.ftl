<#import "parts/common.ftl" as c>
<@c.page>
<form method="get" action="/fights">
    <#list fights as fight>
        <#list fight.getSportsmans() as b>
            ${b.getFirstName()}
        </#list>
    <#else>
        No fight
    </#list>
</form>
</@c.page>