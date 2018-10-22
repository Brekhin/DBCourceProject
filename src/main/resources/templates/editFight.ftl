<#import "parts/common.ftl" as c>

<@c.page>

    <form action="/fights/edit/${fight.fightid}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
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

            <div>
                <input type="checkbox" class="form-check-input" id="present" name="present" value="1">1</input>
                <input type="checkbox" class="form-check-input" id="present" name="present" value="2">2</input>
                <input type="checkbox" class="form-check-input" id="present" name="present" value="3">3</input>
            </div>

            <p><a href="/index/${fight.getSportsmans()[0].getId()}">${fight.getSportsmans()[0].getFirstName()}</a> против
               <a href="/index/${fight.getSportsmans()[1].getId()}">${fight.getSportsmans()[1].getFirstName()}</a></p>
        </div>
    </div>
    <button type="submit">Save</button>
    </form>
</@c.page>