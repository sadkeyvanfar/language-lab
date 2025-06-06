// This code demonstrates various ways to define objects in JavaScript,
// including object literals, constructor functions, factory functions, and ES6 classes.

// Object Literal
const person = {
  name: "John",
  age: 30,
  greet() {
    return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
  }
};
console.log(person.greet()); // Hello, my name is John and I am 30 years old.

// Object.create()
// This allows you to create an object with a specified prototype object and properties.
const dog = Object.create(person);
dog.age = 23;
dog.speak = function () {
  return "Hi!";
};

console.log(dog.greet()); // generic sound (inherited from person)

// Factory Function (with closures or direct return): it's a function that returns a new object.
function createPersonWithClosure(name) {
  return {
    name,
    greet() {
      return `Hi, I'm ${name}`;
    }
  };
}

const alice = createPersonWithClosure("Alice");
console.log(alice.greet()); // Hi, I'm Alice

// Constructors and Prototypes.
function PersonConstructor(name) {
  this.name = name;
}

const personConstructor = new PersonConstructor("Charlie");
console.log(personConstructor.name); // Charlie

// class Syntax (ES6)
class Person {
  constructor(name) {
    this.name = name;
  }

  greet() {
    return `Hi, I'm ${this.name}`;
  }
}

const bob = new Person("Bob");
console.log(bob.greet()); // Hi, I'm Bob
