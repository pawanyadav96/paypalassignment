# paypalassignment
It is a task planner application,where different tasks are added with there sprint ,and tasks also assigned to users.
There is a controller having add sprint,add user,assign task to user according to sprints.

##CONTROLLER
-/api/create/user                                  :Endpoint to create user 
-/api/create/sprint                                :Endpoint to create sprint
-/api/assignTask/{sprintId}/{userId}               :Endpoint tpo assign ask to particular sprint and to particular user
-/api/taskBySprint/{sprintId}                      :To vies all the task assigned to user
-/api/changestatus/{taskId}/{status}               :To change the status of task (done,not donr,or in progress)
-/api/changeassignee/{taskId}/{userId}             :To change the user in the task 

##Tech-Stack
-java core
-MySql:-As database
-Spring boot:- To create endpoints
-Javascript :-For frontend
-Hibernate:- As an ORM
-Swagger :-To see endpoints
-Lombok
