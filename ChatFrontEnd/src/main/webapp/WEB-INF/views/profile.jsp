
<div ng-controller="profileupdate">
<h1> Update Profile </h1>

Current User 
{{rootuserdetails.userEmail}}
 <form method="post" action="uploadFiless" enctype="multipart/form-data">
<input type="text" id="userEmail" name="userEmail" ng-model="rootuserdetails.userEmail" > 
<input type="file" id="file1" name="file" multiple     ng-files="getTheFiles($files)"  />

     
    <input type="submit"  value="upload"></button>
</form>




<div class="row">
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/lights.jpg">
        <img src="/w3images/lights.jpg" alt="Lights" style="width:100%">
        <div class="caption">
          <p>Lorem ipsum...</p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/nature.jpg">
        <img src="/w3images/nature.jpg" alt="Nature" style="width:100%">
        <div class="caption">
          <p>Lorem ipsum...</p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/fjords.jpg">
        <img src="/w3images/fjords.jpg" alt="Fjords" style="width:100%">
        <div class="caption">
          <p>Lorem ipsum...</p>
        </div>
      </a>
    </div>
  </div>
</div>
</div>