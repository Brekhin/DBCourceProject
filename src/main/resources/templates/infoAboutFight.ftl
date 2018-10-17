<#import "parts/common.ftl" as c>

<@c.page>
<div class="row h-100 justify-content-center align-items-center">
    <form>
    <div class="card my-2">
            <#if fight.getSportsmans()[0].filename??>
                        <img src="/img/${fight.filename}" class="card-img-top">
                    </#if>
                    <div class="m-2">
            <p>${fight.getSportsmans()[0].getFirstName()} против ${fight.getSportsmans()[1].getFirstName()} <p>

            <div class="card-footer text-muted">
                        <a href="/index/${fight.getSportsmans()[0].getId()}">Show profile</a>
            </div>
            </div>

    </div>
    </form>
</div>
</@c.page>