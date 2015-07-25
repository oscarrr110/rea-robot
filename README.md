# Preparation #
* Java7
* Maven
* Junit
* Mockito

# Compile #
* mvn package

# Run #
* java -jar target/toyrobot-1.0-SNAPSHOT.jar

# Example #

```
Toy Robot Simulator
Enter a command:
 EX: PLACE X,Y,NORTH|SOUTH|EAST|WEST
 EX: MOVE|LEFT|RIGHT|REPORT
 Type QUIT to EXIT
Toy Robot>PLACE 0,0,NORTH
Toy Robot>REPORT
0,0,NORTH
Toy Robot>MOVE
Toy Robot>REPORT
0,1,NORTH
Toy Robot>RIGHT
Toy Robot>MOVE
Toy Robot>REPORT
1,1,EAST

```
