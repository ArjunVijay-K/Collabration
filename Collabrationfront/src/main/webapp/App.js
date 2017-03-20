(function () { 
    'use strict';    
   angular 
         .module('myApp', ['ngRoute', 'ngCookies']) 
         .config(config) 
         .run(run); 

   config.$inject = ['$routeProvider', '$locationProvider']; 
        function config($routeProvider, $locationProvider) { 
            $routeProvider 
            .when('/',{ 
        		templateUrl : 'index.html', 
        		/*controller : 'UserController' 
*/        		 }) 
        		 
        		/* .when('/chat',{ 
             		templateUrl : 'Chat/chat.html', 
             		 
             		 }) */
             		 
             		.when('/register',{ 
                		templateUrl : 'User/registration.html', 
                		/*controller : 'UserController' ,
                			controllerAs: 'ctrl'*/
                		 })
                		 
                		 .when('/loginpage',{ 
                		templateUrl : 'User/login.html', 
                		/*controller : 'UserController' ,
                			controllerAs: 'vm'*/
                		 })
             		 
                		 .when('/logout',{ 
                		templateUrl : 'User/login.html', 
                		controller : 'UserController', 
                			controllerAs: 'vm',
                				template: 'Your Are Successfully Logged out'
                		 })
                		 
                		 .when('/blog',{ 
                		templateUrl : 'Blog/blog.html', 
                		controller : 'BlogController', 
                			controllerAs: 'blog'
                		 })
                		 
                		 .when('/forum',{ 
                		templateUrl : 'Forum/forum.html', 
                		controller : 'ForumController', 
                			controllerAs: 'forum'
                		 })
                		 
                		 .when('/jobs',{ 
                		templateUrl : 'Jorum/jobs.html', 
                		controller : 'JobController' ,
                			controllerAs: 'job'
                		 })
                		 
                		 .when('/createBlog', { 
                			      	templateUrl : 'c_blog/createBlog.html', 
                			      	controller : 'BlogController', 
                			      	controllerAs: 'bc' 
                			      	}) 
                			      	
                			      	.when('/viewBlog', { 
                    			      	templateUrl : 'c_blog/viewBlog.html', 
                    			      	controller : 'BlogController', 
                    			      	
                    			      	}) 
                    			      	
                    			      	.when('/createForum', { 
                        			      	templateUrl : 'Forum/createForum.html', 
                        			      	controller : 'ForumController', 
                        			      	controllerAs: 'fc' 
                        			      	}) 
                        			      	
                        			      	.when('/viewForum', { 
                            			      	templateUrl : 'Forum/viewForum.html', 
                            			      	controller : 'ForumController', 
                            			      	controllerAs: 'fc' 
                            			      	}) 
                        			      	
                            			      	.when('/createJob', { 
                                			      	templateUrl : 'Jobs/createJobs.html', 
                                			      	controller : 'JobController', 
                                			      	controllerAs: 'jc' 
                                			      	}) 
                                			      	
                                			      	.otherwise( { 
                                			      		     		templateUrl : 'Home/home.html', 
                                			      		     		/*controller : 'mainController'*/ 
                                			      		     	}); 

                            			      	
                         }
        
       run.$inject = ['$rootScope', '$location', '$cookieStore', '$http']; 
             function run($rootScope, $location, $cookieStore, $http) { 
                 // keep user logged in after page refresh 
                 $rootScope.globals = $cookieStore.get('globals') || {}; 
                 if ($rootScope.globals.currentUser) { 
                     $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line 
               }

                /* $rootScope.$on('$locationChangeStart', function (event, next, current) { 
                	              // redirect to login page if not logged in and trying to access a restricted page 
                	              var restrictedPage = $.inArray($location.path(), ['/login', '/register','/blog','/forum','/jobs','/viewevents','/']) === -1; 
                	              var loggedIn = $rootScope.globals.currentUser; 
                	             var loggedOut = false; 
                	              if (restrictedPage && !loggedIn) { 
                	                  $location.path('/login'); 
                	              } 


             }); */
     
             }
 })(); 
