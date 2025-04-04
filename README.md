## Custom list implementation
In this project an array-based list was developed. Later the list was refactored to implement a doubly linked list<br>
Avaliable methods are:
- `length`: An operation to determine the length of the list
- `append`: An operation to add an element to the end of the list
- `insert`: An operation to insert an element at an arbitrary position in the list
- `delete`: An operation to remove an element from the list at a specified position
- `deleteAll`: An operation to remove elements from the list by value. The method removes all elements from the list that match the specified value
- `get`: An operation to retrieve an element from the list at an arbitrary position
- `clone`: An operation to copy the list
- `reverse`: An operation to reverse the list
- `findFirst`: An operation to search for an element by value starting from the head of the list
- `findLast`: An operation to search for an element by value starting from the tail of the list
- `clear`: An operation to clear the list
- `extend`: An operation to extend the lis

## Variant
`19 mod 4 = 3`
|остача|початкова реалізація списку|друга реалізація списку|
|---|----|---|
|3|список на базі вбудованих масивів/списків|двобічно зв'язаний список|

## To run and test the project 
Clone the repository first:
```
git clone https://github.com/KatePril/lab2-mtsd.git
```
Navigate to project directory:
```
cd lab2-mtsd.git
```
### To run tests 
```
mvn test
```
### To run application
To create project jar run:
```
mvn package
```
Run the created jar file:
```
java -jar target\lab2-1.0-SNAPSHOT.jar
```
## Commit with failed tests
[link to the commit](https://github.com/KatePril/lab2-mtsd/commit/7728eb807d6786251b2ff2f6d4742a147eb09fbf) with resulted in errors while testing as a part of CI pipeline 

## Conclusion
Despite the project being neither big nor complex, the unit tests turned out to be extrimely helpful. Firstly, I managed to find three bugs at the first list implementation with a help of unit tests. Secondly, while refactoring the application, I relied on unit tests so as to ensure the smoth and correct work of the unit tests.

In conclusion, I do not consider writing unit tests to be a waste of time because they can save a lot of time bu indentifing problems in the code on the early stages. This can be helpful not only during refactoring but also during intial implementation.
