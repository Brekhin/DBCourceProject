<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
 <#if isAdmin>
<div class="card-footer text-muted">
    <a href="/newsportsman">Добавить бойца</a>
</div>
</#if>
<form method="get" action="/index">
<div class="card-columns">
    <#list sportsmans as sportsman>
      <div class="card my-3 .text-secondary">
        <#if sportsman.filename??>
                <img src="/img/${sportsman.filename}" class="card-img-top">
        </#if>
        <div class="m-2">
            <p>Имя: ${sportsman.firstName}</p>
            <p>Фамилия: ${sportsman.lastName}</p>
            <p>Псевдоним: <b>${sportsman.alias}</b></p>
        </div>
        <div class="card-footer text-muted">
            <a href="/index/${sportsman.id}">Show profile</a>
        </div>
      </div>
    <#else>
        No sportsman
    </#list>
</div>
</form>
</@c.page>
