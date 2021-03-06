<#import "parts/common.ftl" as c>
<@c.page>
<form method="post"  >
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div class="form-group-row">
            <label class="col-sm-2 col-form-label">geoPosition</label>
            <div class="col-sm-6">
                <input type="text" name="geoPosition" class="form-control"
                       placeholder="input geoPosition"/>
            </div>
    </div>
    <div class="form-group-row">
        <label class="col-sm-2 col-form-label">name</label>
        <div class="col-sm-6">
            <input type="text" name="name" class="form-control"
                   placeholder="input name"/>
        </div>
    </div>
    <div class="form-group-row">
        <label class="col-sm-2 col-form-label">description</label>
        <div class="col-sm-6">
            <input type="text" name="description" class="form-control"
                   placeholder="input description"/>
            </div>
    </div>

    <div class="form-group-row">
        <label class="col-sm-2 col-form-label">Дата события</label>
        <div class="col-sm-6">
            <input type="date" class="form-control" id="date" name="date" placeholder="Дата" required>
        </div>
    </div>

    <div class="card-columns">
        <#list listFights as fight>
        <#if fight??>
            <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="present" name="present" value="${fight.getFightid()}">
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
             </div>
        <#else>
            No fight
    </div>
            </#if>
         </#list>
        </div>
<button class="btn btn-primary" type="submit">Add</button>
</form>
</@c.page>