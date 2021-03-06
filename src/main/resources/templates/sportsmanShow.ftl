<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<div class="row h-100 justify-content-center align-items-center">
    <form>
    <div class="card my-3">
        <#if sportsman.filename??>
            <img src="/img/${sportsman.filename}" class="card-img-top">
        </#if>
        <div class="text-center">
            <p>Имя: ${sportsman.firstName}

            <p>Фамилия: ${sportsman.lastName}

            <p>Псевдоним: <b>${sportsman.alias}</b></p>
            <p>Рост: ${sportsman.growth}</p>
            <p>Вес: ${sportsman.weight}</p>
            <p>Длина рук: ${sportsman.lengthOfHands}</p>
            <p>Количество поражений: ${sportsman.countOfLose}</p>
            <p>Количество побед: ${sportsman.countOfWin}</p>
            <p>Количество ничьих: ${sportsman.countOfDraw}</p>
        <#if isAdmin>
        <div>
            <a class="btn btn-info" href="/edit/${sportsman.id}">Edit profile</a>
        </div>
        </#if>
        </div>
    </div>
    </form>
</div>
</@c.page>