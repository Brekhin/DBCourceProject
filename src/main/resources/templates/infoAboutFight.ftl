<#import "parts/common.ftl" as c>

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
            <p><a href="/index/${fight.getSportsmans()[0].getId()}">${fight.getSportsmans()[0].getFirstName()}</a> против
               <a href="/index/${fight.getSportsmans()[1].getId()}">${fight.getSportsmans()[1].getFirstName()}</a></p>
        </div>
    </div>
    </form>
</@c.page>