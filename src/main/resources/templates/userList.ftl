<#import "parts/common.ftl" as c>

<@c.page>

    <#list userList as user>
        ${user.getUsername()}
        <td><#list user.roles as role>${role}<#sep>,</#list></td>
        <td><a href="/users/${user.id}">Edit</a></td>
    </#list>
</@c.page>