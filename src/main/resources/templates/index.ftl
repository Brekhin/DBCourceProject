<#import "parts/common.ftl" as c>
<@c.page>
<form method="get" action="/index">
    <#list sportsmans as sportsman>
    <div class="row">
       <div class="card-columns">
                    <div class="card my-3">
                        <#if sportsman.filename??>
                            <img src="/img/${sportsman.filename}" class="card-img-top">
                        </#if>
                        ${sportsman.firstName}
                        ${sportsman.lastName}
                        ${sportsman.alias}
            <div>
            <a class="btn btn-info" href="/index/${sportsman.id}">Show profile</a>
        <div>
    </div>
    <#else>
        No sportsman
    </#list>
</form>
</@c.page>
