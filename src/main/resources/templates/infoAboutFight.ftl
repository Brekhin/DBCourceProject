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
            <p>${fight.getSportsmans()[0].getFirstName()} против ${fight.getSportsmans()[1].getFirstName()}</p>

            <div class="card-footer text-muted">
                <a href="/index/${fight.getSportsmans()[0].getId()}">Show profile</a>
            </div>
        </div>
    </div>
    </form>
</@c.page>