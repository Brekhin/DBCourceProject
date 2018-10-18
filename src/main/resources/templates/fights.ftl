<#import "parts/common.ftl" as c>
<@c.page>

<form method="get" action="/fights">
<div class="card-columns">
    <#list fights as fight>
                    <div class="card my-3 .text-secondary">
                        <#if fight.filename??>
                            <img src="/img/${fight.filename}" class="card-img-top">
                        </#if>
                        <#if fight.getDescription()??>
                            <p class="lead">${fight.getDescription()}</p>
                        </#if>
                        <div class="m-2, text-center">
                            <#list fight.getSportsmans() as b>
                                ${b.getAlias()}
                            </#list>
                        </div>
                        <div class="card-footer text-muted">
                            <a href="/fights/${fight.getId()}">Show profile</a>
                        </div>
                    </div>
                <#else>
                    No fight
                </#list>
</div>
</form>

</@c.page>