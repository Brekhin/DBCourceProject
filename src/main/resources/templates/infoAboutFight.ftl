<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>

    <form>
    <div class="card">
        <#if fight.filename??>
        <div class="text-center">
            <img src="/img/${fight.filename}" alt="Cinque Terre" width="450" height="400" >
        </div>
        </#if>
        <div class="m-1, text-center">
            <#if fight.getDescription()??>
                <p>${fight.getDescription()}</p>
            </#if>

            <#if sportsmanWin??>
                <p>Победу одержал ${sportsmanWin.getFirstName()} ${sportsmanWin.getLastName()}</p>
            </#if>

            <p><a href="/index/${fight.getSportsmans()[0].getId()}">${fight.getSportsmans()[0].getFirstName()}</a> против
               <a href="/index/${fight.getSportsmans()[1].getId()}">${fight.getSportsmans()[1].getFirstName()}</a></p>
        </div>
    </div>
    <#if isAdmin>
    <div>
        <a class="btn btn-info" href="/fights/edit/${fight.fightid}">Edit profile</a>
    </div>
    </#if>
    </form>
</@c.page>