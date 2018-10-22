<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl">
<@c.page>
 <#if isAdmin>
<div class="card-footer text-muted">
    <a href="/newevent">Добавить событие</a>
</div>
</#if>
<form method="get">
    <div class="card-columns">
        <#list allEvent as event>
            <#if event??>
                <div class="card my-3 .text-secondary">
                    <h1 class="display-4">${event.getName()}</h1>

                    <h1 class="display-6">${event.getGeoPosition()}</h1>
                    <#if event.getDate()??>
                        <h1 class="display-6">${event.getDate()?string("yyyy-MM-dd")}</h1>
                    </#if>
                    <p class="lead">
                        ${event.getDescription()}
                    </p>
                    <div class="card-footer text-muted">
                        <a href="/events/${event.id}">More info</a>
                    </div>
                </div>
            </#if>
        </#list>
    </div>
</form>

</@c.page>