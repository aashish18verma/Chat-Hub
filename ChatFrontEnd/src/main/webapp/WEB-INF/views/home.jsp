<%@page import="java.util.*"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>CHAT HUB</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
  
  -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>



<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/angular.min.js"/>"></script>
<script src="<c:url value="/resources/js/mymain.js"/>"></script>

<!-- Chat Data  -->
<script src="bower_components/rltm/web/rltm.js"></script>
<script src="bower_components/angular-chat/angular-chat.js"></script>


<style>
.container {
	
}

#header {
	height: 60px;
	background-color: #CB3C7B;
}

#content {
	height: 600px;
}

#footer {
	height: 60px;
	color: pink;
}

#leftpane {
	background-color: cyan;
}

#rightpane {
	background-color: white;
}

b:hover {
	color: blue;
	cursor: pointer;
}

.c {
	display: none;
}

.liclass {
	color: green;
}
</style>

</head>
<body ng-app="myApp" ng-controller="homeCtrl">

	<div class="container-fluid">

		<div class="container-fluid">
			<nav class="navbar navbar-inverse" style="background-color: #267BAF">

				<div class="row" id="header">
					<div class="container-fluid text-center"
						ng-show="rootuserdetails.userEmail.length" style="float: center">

						<h1>
							Welcome to CHAT HUB {{rootuserdetails.userEmail}}   <a href="#!login"
								ng-click="logout()"> Logout </a>
						</h1>
					</div>
			</nav>

		</div>

		<div class="container-fluid text-center" id="content">
			<div class="row content">

				<div class="col-sm-2 container-fluid">
					<ul style="font-size: 17px;">
						<div ng-show="!rootuserdetails.userEmail" class="container-fluid">
							<li><a href="#/!"> Home </a></li>
							<li><a href="#!register"> Register </a></li>
							<li><a href="#!login"> Login </a></li>

						</div>
						<div ng-show="rootuserdetails.userEmail" class="container-fluid">
							<li><a href="#!blog"> Blog </a></li>
							<li><a href="#!chat"> Chat </a></li>
							<li><a href="#!profile"> Profile </a></li>
							<li><a href="#!friends"> Friend </a></li>
						</div>
					</ul>
				</div>

				<div class="col-sm-8 text-left container-fluid" id="rightpane">

					<div ng-view></div>
				</div>

				<div class="col-sm-2 sidenav container-fluid">

					<div ng-show="rootuserdetails.userEmail.length"
						style="float: right" class="container-fluid">

						<h1>Online User List</h1>

						<ul>
							<li ng-repeat="user in onlineusers"><b class="liclass"
								ng-click="addChat(user.userEmail,$index)">
									{{user.userEmail}} </b> <br> <a href="#!chat"
								ng-click="currentChat(user.userEmail,$index)">{{user.userEmail}}
							</a></li>


							<div class="c container-fluid">


								<div class="panel panel-default">
									<div class="panel-body">

										From <input type="text" class="form-control from" id="from"
											placeholder="Enter text to send" ng-model="fromUserEmail">
										To <input type="text" class="form-control to" id="to"
											placeholder="Enter text to send" ng-model="toUserEmail">
										<input type="text" class="form-control" id="message"
											placeholder="Enter text to send" ng-model="chatMessage">
										<input type="button" class="form-control" id="sendBtn"
											placeholder="Enter text to send" value="Send"
											ng-click="sendData(toUserEmail,fromUserEmail,chatMessage)">


										<ul>
											<li ng-repeat="chat in chatConversation">
												{{chat.chatMessage}}</li>

										</ul>

										<br>

									</div>
								</div>
							</div>
					</div>





				</div>


			</div>

		</div>



		<div class="container-fluid">
			<footer class="container-fluid text-center">
				<p>Chat Hub By Aashish Verma</p>
			</footer>
		</div>


	</div>
</body>
</html>

<script>
	var threadstopping;

	var app = angular.module("myApp", [ "ngRoute" ]);

	app.config(function($routeProvider) {
		$routeProvider.when("/login", {
			templateUrl : "login.htm"
		}).when("/register", {
			templateUrl : "register.htm"
		}).when("/blog", {
			templateUrl : "blog.htm"
		}).when("/chat", {
			templateUrl : "chat.htm"
		}).when("/profile", {
			templateUrl : "profile.htm"
		}).when("/friends", {
			templateUrl : "friends.htm"
		}).otherwise({
			template : "<h1>None</h1><p>Nothing has been selected</p>"
		});
	});

	app.controller("profileupdate", function($scope, $http, $rootScope,
			$timeout, $element) {

		$scope.uploadFiles = function() {

			alert("  profile update   ");

		}
	});

	app
			.controller(
					"friendctrl",
					function($scope, $http, $rootScope, $timeout, $element) {
						var btnx = 0;

						$scope.freindListData;
						$scope.allcnfFriend = function(userEmail, cnf) {

							if (btnx == 0) {
								$http(
										{
											method : "GET",
											url : "http://localhost:8082/MyMiddleware/allcnfFriend?useremail="
													+ userEmail
													+ "&friendType=" + cnf,
										})
										.then(
												function mySuccess(response) {
													$scope.freindListData = response.data;

												},
												function myError(response) {
													$scope.freindListData = response.statusText;

												});

								btnx = 1;
							} else {
								$scope.freindListData = "";
								btnx = 0;
							}
						}

						// allnoncnfuser(rootuserdetails.userEmail,'noncnf')

						$scope.allnoncnfuserData;
						var btnoncnf = 0;
						$scope.allnoncnfuser = function(userEmail, noncnf) {

							if (btnoncnf == 0) {
								$http(
										{
											method : "GET",
											url : "http://localhost:8082/MyMiddleware/allnoncnfFriend?useremail="
													+ userEmail
													+ "&friendType=" + noncnf
										})
										.then(
												function mySuccess(response) {
													$scope.allnoncnfuserData = response.data;
												},
												function myError(response) {
													$scope.allnoncnfuserData = response.statusText;

												});

								btnoncnf = 1;

							} else {

								$scope.allnoncnfuserData = "";
								btnoncnf = 0;

							}

						}

						// alluser()

						$scope.alluserData;
						var btnz = 0;

						$scope.alluser = function() {

							if (btnz == 0) {

								$http(
										{
											method : "GET",
											url : "http://localhost:8082/MyMiddleware/alluser",
										}).then(function mySuccess(response) {
									$scope.alluserData = response.data;

								}, function myError(response) {
									$scope.alluserData = response.statusText;

								});

								btnz = 1;

							} else {

								$scope.alluserData = "";
								btnz = 0;

							}

						}

						//confirmFriend(rootuserdetails.userEmail,friend.friendUserEmailID,'noncnf')

						$scope.confirmFriend = function(friendID, friendType) {

							console.log("friendID            " + friendID)
							console.log("friendType           " + friendType)

							$http(
									{
										method : "GET",
										url : "http://localhost:8082/MyMiddleware/updatenoncnfFriendList?friendID="
												+ friendID
												+ "&friendType="
												+ friendType,
										data : ""
									}).then(function mySuccess(response) {

							}, function myError(response) {

							});

						}

						//*********************************************************************************

						$scope.sendRequest = function(userEmail,
								friendUserEmail, friendType) {

							console.log(" Friend Request detials ")
							console.log("userEmail " + userEmail)
							console.log("friendUserEmail " + friendUserEmail)
							console.log("friendType " + friendType)

							$http(
									{
										method : "GET",
										url : "http://localhost:8082/MyMiddleware/saveFriendRequest?userEmail="
												+ userEmail
												+ "&friendUserEmail="
												+ friendUserEmail
												+ "&friendType=" + friendType,
										data : ""
									}).then(function mySuccess(response) {

							}, function myError(response) {

							});

						}

					});

	app
			.controller(
					"homeCtrl",
					function($scope, $http, $rootScope, $timeout) {
						$scope.chatdata = ""
						$scope.addChat = function(data1, data2) {

							$(".c").css("display", "block");

							$(".from")
									.val($rootScope.rootuserdetails.userEmail);
							$(".to").val(data1);

							console.log(data2);

							$timeout(
									function() {

										//http://localhost:8082/MyMiddleware/getChat?ToUserEmail=niraj@ibm.com&FromUserEmail=rajeev@niit.com
										$http(
												{
													method : "GET",
													url : "http://localhost:8082/MyMiddleware/getChat?ToUserEmail="
															+ data1
															+ "&FromUserEmail="
															+ $rootScope.rootuserdetails.userEmail
												})
												.then(
														function mySuccess(
																response) {

															$rootScope.chatConversation = response.data;
															console
																	.log($rootScope.chatConversation);

														},
														function myError(
																response) {
															$rootScope.chatConversation = response.statusText;
														});

									}, 1000);

						}

						$scope.sendData = function(toUserEmail, fromUserEmail,
								chatMessage) {
							console
									.log("************CHAT CONTROLLER **************************")
							console.log("toUserEmail      " + toUserEmail);
							console.log("fromUserEmail    " + fromUserEmail);
							console.log("chatMessage      " + chatMessage);
							console
									.log("**************************************")

							//http://localhost:8082/MyMiddleware/addChat?ToUserEmail=niraj@niit.com&FromUserEmail=rajeev@niit.com&ChatMessage=About NIIT

							$http(
									{
										method : "GET",
										url : "http://localhost:8082/MyMiddleware/addChat?ToUserEmail="
												+ toUserEmail
												+ "&FromUserEmail="
												+ fromUserEmail
												+ "&ChatMessage=" + chatMessage,
									}).then(function mySuccess(response) {
								$scope.chatdata = response.data;

							}, function myError(response) {

								$scope.chatdata = response.statusText;

							});

							console.log(" **********  Chat data  "
									+ $scope.chatdata);

						}

						$scope.logout = function() {
							console
									.log("Thread State "
											+ $rootScope.threadstop)

							clearInterval(threadstopping);

							console.log("*************************");
							console.log("*************************");
							console
									.log("Thread State "
											+ $rootScope.threadstop)
							console.log("*************************");
							console.log("*************************");

							$http(
									{
										method : "GET",
										url : "http://localhost:8082/MyMiddleware/logout?emailID="
												+ $rootScope.rootuserdetails.userEmail,
									}).then(function mySuccess(response) {
								$scope.userdetails = response.data;
								$rootScope.loginError = "  ";
								$rootScope.rootuserdetails = {};
								location.reload();

							}, function myError(response) {
								$scope.userdetails = response.statusText;
								$rootScope.loginError = "  ";
								$rootScope.rootuserdetails = {};

							});

						};

					});

	app
			.controller(
					"registerCtrl",
					function($scope, $http) {

						$scope.responsedata = ""

						console.log(" Register Page is Loaded  ");
						$scope.msg = "Register Page";

						$scope.addUser = function() {

							if ($scope.userPassword != $scope.cnfuserPassword) {

								return;
							}
							$scope.addUserData = {
								userEmail : $scope.userEmail,
								userPassword : $scope.userPassword,
								userName : $scope.userName,
								userAddress : $scope.userAddress,
								userContact : $scope.userContact
							};
							$http(
									{
										method : "GET",
										url : "http://localhost:8082/MyMiddleware/addUser?userEmail="
												+ $scope.userEmail
												+ "&userPassword="
												+ $scope.userPassword
												+ "&userName="
												+ $scope.userName
												+ "&userAddress="
												+ $scope.userAddress
												+ "&userContact="
												+ $scope.userContact,
										data : $scope.addUserData
									}).then(function mySuccess(response) {
								$scope.responsedata = response.data;

								console.log(" Resposne Success Data ");
								console.log($scope.responsedata);
							}, function myError(response) {

								$scope.responsedata = response.statusText;
								console.log(" Resposne Error Data ");
								console.log($scope.responsedata);
							});
							console.log("*******************************");

						}

					});

	app
			.controller(
					"loginCtrl",
					function($scope, $http, $rootScope, $interval, $location) {

						$rootScope.currentchatEmail = "";

						$rootScope.threadstop = null;

						$rootScope.onlineusers = {};
						$rootScope.chatConversation = {}
						console.log($rootScope.onlineusers);
						// Get all onlone user

						$rootScope.loginError = "";
						console.log(" Login Page Controller  ");
						$scope.userdetails = {};
						$rootScope.rootuserdetails = $scope.userdetails = {};
						$scope.validateLogin = function() {
							var pass = $scope.pwd;
							$http(
									{
										method : "GET",
										url : "http://localhost:8082/MyMiddleware/getuserbyemail?emailID="
												+ $scope.email
									})
									.then(
											function mySuccess(response) {
												$scope.userdetails = response.data;
												$rootScope.rootuserdetails = $scope.userdetails;

												if ($rootScope.rootuserdetails.userPassword == pass) {

													$rootScope.loggedUser = $scope.username;
													$location.path("/profile");

													$rootScope.loginError = "";
													console
															.log($scope.userdetails);
													console
															.log($rootScope.rootuserdetails);
													$rootScope.rootuserdetails = $scope.userdetails;

													threadstopping = $interval(
															function() {

																//http://localhost:8082/MyMiddleware/getuserbyloginstatus?loginstatus=Y
																$http(
																		{
																			method : "GET",
																			url : "http://localhost:8082/MyMiddleware/getuserbyloginstatus?loginstatus=Y"
																		})
																		.then(
																				function mySuccess(
																						response) {

																					$rootScope.onlineusers = response.data;
																					console
																							.log($rootScope.onlineusers);

																				},
																				function myError(
																						response) {
																					$rootScope.onlineusers = response.statusText;
																				});

															}, 1000);

													console
															.log("*************************");
													console
															.log("*************************");
													console
															.log("Thread State "
																	+ $rootScope.threadstop)
													console
															.log("*************************");
													console
															.log("*************************");

												} else {
													$rootScope.loginError = " Invalid User ";
													$rootScope.rootuserdetails = $scope.userdetails = {};

												}

											},
											function myError(response) {
												$scope.userdetails = response.statusText;
												$rootScope.rootuserdetails = $scope.userdetails;
												$rootScope.loginError = " Invalid User ";

											});

						}

					});

	app.controller("chatCtrl", function($scope, $http, $rootScope) {

		$rootScope.currentUserout = " ";

		$rootScope.currentChat = function(currentUserin, indexdata) {

			$rootScope.currentUserout = currentUserin;

		}

	});

	app
			.controller(
					"blogCtrl",
					function($scope, $http, $rootScope) {

						console
								.log(" http://localhost:8082/MyMiddleware/allblog ");
						$scope.blogdetails = {};

						$scope.showblog = function() {

							$http(
									{
										method : "GET",
										url : "http://localhost:8082/MyMiddleware/allblog"
									}).then(function mySuccess(response) {
								$scope.blogdetails = response.data;
								console.log($scope.blogdetails);

							}, function myError(response) {
								$scope.blogdetails = response.statusText;
							});

						};

						$scope.showblog();

						$scope.addBlog = function() {
							$scope.addBlogData = {};
							console.log("*******************************");
							console.log("addBlog Method of blogCtrl ");

							var blogdata = {
								blogName : $scope.blogName,
								blogComment : $scope.blogComment,
								userEmail : $rootScope.rootuserdetails.userEmail
							};

							console.log(blogdata);

							$http(
									{
										method : "GET",
										url : "http://localhost:8082/MyMiddleware/addblog?blogName="
												+ $scope.blogName
												+ "&blogComment="
												+ $scope.blogComment
												+ "&userEmail="
												+ $rootScope.rootuserdetails.userEmail,
										data : blogdata
									}).then(function mySuccess(response) {

								$scope.addBlogData = response.data;
								$scope.showblog();
								console.log(" Resposne Success Data ");
								console.log($scope.addBlogData);

							}, function myError(response) {
								$scope.showblog();
								$scope.addBlogData = response.statusText;
								console.log(" Resposne Error Data ");
								console.log($scope.addBlogData);

							});

							console.log("*******************************");

						}

						$scope.deleteBlog = function(blogID) {
							console.log(" ******************* DELETE BLOG  "
									+ blogID);
							$scope.blogID = "";
							$http(
									{
										method : "GET",
										url : "http://localhost:8082/MyMiddleware/deleteblog?blogID="
												+ blogID
									}).then(function mySuccess(response) {
								$scope.addBlogData = response.data;
								$scope.showblog();
								console.log(" Resposne Success Data ");

							}, function myError(response) {
								$scope.showblog();
								$scope.addBlogData = response.statusText;
								console.log(" Resposne Error Data ");
								console.log($scope.addBlogData);

							});
							console
									.log("**********Delete Blog Calling *********************");
						};

						$scope.blogID = "";

						$scope.updateBlog = function(blogID, blogName,
								blogComment) {
							$scope.blogName = blogName;
							$scope.blogComment = blogComment;
							$scope.blogID = blogID;
						}

						$scope.updateCommitBlog = function() {

							$scope.addBlogData = {};
							console
									.log("********** Update Blog Begin  *********************");
							var blogdata = {
								blogName : $scope.blogName,
								blogComment : $scope.blogComment,
								blogID : $scope.blogID
							};
							console.log(blogdata);

							$http(
									{
										method : "GET",
										url : "http://localhost:8082/MyMiddleware/updateblog?blogName="
												+ $scope.blogName
												+ "&blogComment="
												+ $scope.blogComment
												+ "&blogID=" + $scope.blogID,
										data : blogdata
									}).then(function mySuccess(response) {

								$scope.addBlogData = response.data;
								$scope.showblog();
								console.log(" Resposne Success Data ");
								console.log($scope.addBlogData);
								$scope.blogID = "";

							}, function myError(response) {
								$scope.showblog();
								$scope.addBlogData = response.statusText;
								console.log(" Resposne Error Data ");
								console.log($scope.addBlogData);
								$scope.blogID = "";

							});

							console.log("*******************************");

						}

					});
</script>

