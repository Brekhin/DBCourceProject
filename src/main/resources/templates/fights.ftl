<#import "parts/common.ftl" as c>
<@c.page>

<form method="get" action="/fights">
    <#list fights as fight>
    <#if fight.filename??>
                    <img src="/img/${fight.filename}" class="card-img-top">
            </#if>
    <#if fight??>
        <div class="card my-3 .text-secondary">
        <#list fight.getSportsmans() as b>

                ${b.getAlias()}

        </#list>
        <div>
        </div>
        <div class="card-footer text-muted">
                    <a href="/fights/${fight.getId()}">Show profile</a>
        </div>
    </div>
    </#if>
    <#else>
        No fight

    </#list>
</form>

</@c.page>