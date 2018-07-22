<div class="container" ng-controller="loginCtrl">



 <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
      
      <td> User Email </td>
      
      
      </tr>
    </thead>
    <tbody>
      <tr >
       
       <td style="color:red;font-size:20px"> {{userdetails.userEmail}} {{loginError }} </td>
      
       
       
      </tr>
    </tbody>
  </table>
  </div>






  <h2>Login Credential Page </h2>
  <form ng-submit="validateLogin()">
  
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" ng-model="email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" ng-model="pwd">
    </div>
    
     
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
    
  </form>
</div>


