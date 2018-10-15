<#import "parts/common.ftl" as c>

<@c.page>

<div class="card-columns">
<form method="get">
    <div class="card my-3">
        <#if sportsman.filename??>
            <img src="/img/${sportsman.filename}" class="card-img-top">
        </#if>
        <div>
            ${sportsman.firstName}
        </div>
        <div>
            ${sportsman.lastName}
        </div>
        <div>
            ${sportsman.alias}
        </div>
        <div>
            <a class="btn btn-info" href="/edit/${sportsman.id}">Edit profile</a>
        </div>
    </div>
</form>
</div>
</@c.page>