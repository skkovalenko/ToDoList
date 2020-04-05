# Short description - ToDoList
REST API using Spring. Interaction database. Implementation CRUD (POST, GET, PUT, DELETE). Work with requestes and responses on the frontend side.

<a href="https://github.com/skkovalenko/ToDoList/blob/master/pom.xml">Build maven</a>

<a href="https://github.com/skkovalenko/ToDoList/blob/master/src/main/java/main/model/Todo.java">Todo Entity</a><br>
<ul>
<li>Connecting database</li> setting <a href="https://github.com/skkovalenko/ToDoList/blob/master/src/main/resources/application.properties">application.properties</a>
</ul>

<a href="https://github.com/skkovalenko/ToDoList/tree/master/src/main/java/main/controller">Two controllers</a><br>
<ul>
<li><a href="https://github.com/skkovalenko/ToDoList/blob/master/src/main/java/main/controller/DefaultController.java">Default controller</a></li> 
requests MyHost/   path and returns the <a href="https://github.com/skkovalenko/ToDoList/blob/master/src/main/resources/templates/index.html">index page</a> using spring-boot-starter-thymeleaf connected to maven
<li><a href="https://github.com/skkovalenko/ToDoList/blob/master/src/main/java/main/controller/TodoController.java">Todo controller</a></li> 
works with requests POST, GET, PUT, DELETE and interactions with database using <a href="">Todo repository</a> extends org.springframework.data.repository.CrudRepository'<'Todo, Integer'>'
using spring-boot-starter-data-jpa connected to maven 
</ul>

<a href="">Front-end interaction</a>
<ul>
<li><a href="https://github.com/skkovalenko/ToDoList/blob/master/src/main/resources/templates/index.html">Index page</a></li>
<li><a href="https://github.com/skkovalenko/ToDoList/tree/master/src/main/resources/static/js">JavaScript</a></li>
Connected <a href="https://github.com/skkovalenko/ToDoList/blob/master/src/main/resources/static/js/jquery-3.4.0.min.js">jQuery</a> to the project, 
work with requests and responses on the <a href="https://github.com/skkovalenko/ToDoList/blob/master/src/main/resources/static/js/main.js">js</a>
<li><a href="https://github.com/skkovalenko/ToDoList/blob/master/src/main/resources/static/css/styles.css">Styles</a></li>
</ul>
