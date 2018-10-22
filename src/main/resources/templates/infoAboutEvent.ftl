<#import "parts/common.ftl" as c>

<@c.page>
    <form>
    <div class="card my-3 .text-secondary">
            <h1 class="display-4">${singleEvent.getName()}</h1>

            <h1 class="display-6">${singleEvent.getGeoPosition()}</h1>
            <#if singleEvent.getDate()??>
                <h1 class="display-6">${singleEvent.getDate()?string("yyyy-MM-dd")}</h1>
            </#if>
            <p class="lead">
                ${singleEvent.getDescription()}
            </p>
        </div>

        <div class="card-columns">
            <#list singleEvent.getFights() as fight>
                            <div class="card my-3 .text-secondary">
                                <#if fight.filename??>
                                    <img src="/img/${fight.filename}" class="card-img-top">
                                </#if>
                                <#if fight.getDescription()??>
                                    <p class="lead">${fight.getDescription()}</p>
                                </#if>
                                <div class="m-2, text-center">
                                    <#list fight.getSportsmans() as b>
                                        ${b.getAlias()}
                                    </#list>
                                </div>
                                <div class="card-footer text-muted">
                                    <a href="/fights/${fight.getId()}">Show profile</a>
                                </div>
                            </div>
                        <#else>
                            No fight
                        </#list>
        </div>
        <div class="card-footer text-muted">
            <a href="/events/edit/${singleEvent.getId()}">Edit</a>
        </div>
    </form>
</@c.page>