<#import "parts/common.ftl" as c>

<@c.page>

    <table class="table">
      <thead>
        <tr>

          <th scope="col">Name</th>
          <th scope="col">Roles</th>
          <th scope="col"></th>
           </tr>
       </thead>
       <tbody>
         <#list userList as user>
         <tr>
        <td>
        ${user.getUsername()}
        </td>
            <td><#list user.roles as role>${role}<#sep>,</#list></td>
            <td><a href="/users/${user.id}">Edit</a></td>
        </tr>
        </#list>
        </tbody>
</@c.page>