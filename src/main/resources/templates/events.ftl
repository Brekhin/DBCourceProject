<#import "parts/common.ftl" as c>
<@c.page>

<form method="get" action="/events">
<#list allEvent as event>
    <#if event??>
    <div class="card-columns">
        ${event.getGeoPosition()}
        <#if event.getDate()??>
            ${event.getDate()}
        </#if>
    </div>
    </#if>
</#list>
</form>

</@c.page>