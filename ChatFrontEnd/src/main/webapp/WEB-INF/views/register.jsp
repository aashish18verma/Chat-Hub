<form class="form-horizontal" action="#" ng-controller="registerCtrl">
   <div class="form-group">
 	  <div class="container">
  		<h2>Registration Form </h2>
    	<div class="table-responsive">          
  		<table class="table">
    	<tbody>
      		<tr>
               <td>
               <div class="input-group">
    			<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    			<input id="email" type="text" class="form-control" name="email" placeholder="Email" ng-model="userEmail">
  				</div>
  			  </td>
         </tr>
         <tr>
            <td>
            	<div class="input-group">
    				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    				<input id="password" type="password" class="form-control" name="password" placeholder="Password" ng-model="userPassword">
  			   </div>
  		</td>
      </tr>
      <tr>
      <td>
           <div class="input-group">
    	     <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    	     <input id="cnfpassword" type="password" class="form-control" name="cnfpassword" placeholder="Confirm Password" ng-model="cnfuserPassword">
  		  </div>
      </td>
      </tr>
      
      <tr>
      	<td> 
      	<div class="input-group">
    		<span class="input-group-addon">User Name </span>
    		<input id="userName" type="text" class="form-control" name="userName" placeholder="Additional Info" ng-model="userName">
  		</div>
      	</td>
      </tr>
      
      <tr>
      	<td> 
      	<div class="input-group">
    		<span class="input-group-addon">User Contact </span>
    		<input id="userContact" type="text" class="form-control" name="userContact" placeholder="Additional Info" ng-model="userContact">
  		</div>
      	</td>
      </tr>
      
      
      <tr>
      	<td> 
      	<div class="input-group">
    		<span class="input-group-addon">User Address </span>
    		<input id="userAddress" type="text" class="form-control" name="userAddress" placeholder="Additional Info" ng-model="userAddress">
  		</div>
      	</td>
      </tr>
      
      <tr>
      	<td> 
      	<div class="input-group">
    		
    		<input id="addUser" type="button" class="form-control" name="addUser" value="Add User" ng-click="addUser()">
  		</div>
      	</td>
      </tr>
      
      
      
      
      
    </tbody>
  </table>
  </div>
</div>
    
    
  </div>
{{responsedata}}
 
</form>

