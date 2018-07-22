<div ng-controller="friendctrl">
<button type="button" class="btn btn-info" ng-click="allcnfFriend(rootuserdetails.userEmail,'cnf')" data-toggle="button">Friend List</button>

<div class="container">
  <h2>Friend List</h2>
  {{freindListData}}
  <table class="table">
   <tbody>
      <tr ng-repeat="friend in freindListData ">
      
        <td><img src=" aa.png"> </img></td>
        <td nf-id="freindType.cnf">{{friend.friendUserEmailID}} </td>
        <td> <button> UnFriend </button>
        
      </tr>      
          </tbody>
  </table>
</div>

<button type="button" class="btn btn-info" ng-click = "allnoncnfuser(rootuserdetails.userEmail,'noncnf')">NON Confirmed Friend List</button>


<div class="container">
  <h2> Confirm the Friend List </h2>
  {{allnoncnfuserData}}
  <table class="table">
   <tbody>
      <tr ng-repeat="friend in allnoncnfuserData">
       
       <td> {{friend.friendID}}  
        <td>    Current User  {{rootuserdetails.userEmail}} </td>
        <td>     <img src="aa.png"> </img></td>
        <td>     user email {{friend.user.userEmail}}  </td>
        <td>     <button ng-click = "confirmFriend(friend.friendID,'cnf')">   Confirm   </button>
        
      </tr>      
          </tbody>
  </table>
</div>





<button type="button" class="btn btn-info"  ng-click = "alluser()" > Send Friend Request </button>

<div class="container">
  <h2> Friend Request List </h2>
  <table class="table">
   <tbody>
      <tr ng-repeat="user in alluserData">
         
        <td>    Current User  {{rootuserdetails.userEmail}} </td>
        <td>     <img src="aa.png"> </img></td>
        <td>     {{user.userEmail}}  </td>
        <td>     <button ng-click="sendRequest(rootuserdetails.userEmail,user.userEmail,'noncnf')">   Send  Request  </button>
        
      </tr>      
          </tbody>
  </table>
</div>


</div>