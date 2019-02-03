## To run

./kobaltw assemble && java -jar kobaltBuild/libs/kotlin-server-0.1.jar

- Iterating over properties of a class

`https://stackoverflow.com/questions/38688111/kotlin-iterate-over-components-of-object`

#### Controllers

- Job: Receive input, validate input, and call the proper interactor (use case)

#### Server

- Job: Receive requests and call controller

#### Domain

###### Entities

- Application independent business rules
    * In this case data classes for what `Author` and `Todo` look like

###### Gateways

- Interface to describe the operations that can be performed on the entities


#### Resources

http://www.plainionist.net/Implementing-Clean-Architecture-Controller-Presenter/