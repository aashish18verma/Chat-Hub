
<div class="container-fluid" ng-controller="blogCtrl" >
  <h2> Blog Details </h2>
  
  <div class="container-fluid">     
  <table class="table">
    <thead>
      <tr>
        <th> BlogName      </th>
        <th> Blog Comment  </th>
      </tr>
    </thead>
    <tbody>
      <tr >
        <td>
        	<input type="text" class="form-control" id="blogName" name="blogName" ng-model="blogName" /> 			
        </td>
        <td> 
         	<input type="text" class="form-control" id="blogComment" name="blogComment" ng-model="blogComment" />
        </td>
      </tr>
    </tbody>
  </table>
  <div ng-show="blogID" class="container-fluid">
      <button type="submit" class="btn btn-default" ng-click="updateCommitBlog()">Update</button>
  </div>
  
  <button type="submit" class="btn btn-default" ng-click="addBlog()">Add Blog</button>
  
  <hr>
  
                                                                                        
  <div class="container-fluid">          
  <table class="table">
    <thead>
      <tr>
        <th>#					</th>
        <th>BlogName			</th>
        <th>Blog Comment 		</th>
        <th>Blog Created Date	</th>
        <th>Blog Status			</th>
        <th>Blog Likes			</th>
        <th>Blog Posted By 		</th>
        <th>Action 1  			</th>
        <th>Action 2  			</th>
      </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="blog in blogdetails">
        <td> {{blog.blogID}}			</td>
        <td> {{blog.blogName}}			</td>
        <td> {{blog.blogComment}}		</td>
        <td> {{blog.blogCreatedDate}}	</td>
        <td> {{blog.blogStatus}}		</td>
        <td> {{blog.blogLikes}} 		</td>
        <td> {{blog.user.userEmail}} 				</td>
        <td> <button  class="btn btn-info btn-lg"   ng-click = "updateBlog(blog.blogID,blog.blogName,blog.blogComment)"> <span class="glyphicon glyphicon-edit" >  </span> Edit     </button>  </td>
        <td> <button  class="btn btn-info btn-lg "  ng-click="deleteBlog(blog.blogID)"> <span class="glyphicon glyphicon-trash"> </span> Trash    </button>  </td>
        
      </tr>
    </tbody>
  </table>
  </div>
</div>
