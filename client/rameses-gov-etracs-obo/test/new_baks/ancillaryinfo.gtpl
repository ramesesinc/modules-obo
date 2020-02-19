<html>
<head>
    <script src="classpath://res/jquery.min.js" type="text/javascript"></script>
    <script src="classpath://res/jquery-ui.min.js" type="text/javascript"></script>
    <script src="classpath://res/rameses-ext-lib.js" type="text/javascript"></script>
    <script src="classpath://res/rameses-ui.js" type="text/javascript"></script>
</head>

<body>
    <script>
    \$put("test", new function() {
        this.mode = "initial";
        this.entity = {}
        this.save = function() {
            this.mode = "view";
        }
        this.back = function() {
            this.mode = "initial";
        }
    });
    </script>

    <h1>Record</h1>

    <div r:context="test" r:visibleWhen="#{mode == 'initial' }">
        <div>
            Last Name : <input type="text" r:context="test" r:name="entity.lastname"> 
        </div>
        <div>
            First Name : <input type="text" r:context="test" r:name="entity.firstname"> 
        </div>
        <div>
            Birth Date : <input type="text" r:context="test" r:name="entity.birthdate" r:datatype="date">
        </div>
        <input type="submit" r:context="test" r:name="save" value="Save"></input>
    </div>
    
    <div r:context="test" r:visibleWhen="#{mode == 'view' }">
        You saved <label r:context="test">#{entity.lastname}, #{entity.firstname} #{entity.birthdate}</label>
        <br>
        <input type="submit" r:context="test" r:name="back" value="Back"></input> 
    </div>
</body>

</html>