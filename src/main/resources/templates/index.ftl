<#import "parts/common.ftl" as c>
<@c.page>
<form method="get" action="/index">
    <#list sportsmans as sportsman>
    <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-body">
        ${sportsman.firstName}
        ${sportsman.lastName}
        ${sportsman.alias}
    </div>
    <div>
        <a class="btn btn-info" href="/index/${sportsman.id}">Show profile</a>
    <div>
    </div>
    </div>
    </div>
    <#else>
        No sportsman
    </#list>
</form>
</@c.page>
