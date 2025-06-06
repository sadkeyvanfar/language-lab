// Prototype is a fundamental concept in JavaScript that allows objects to inherit properties and methods from other objects.
// Every JavaScript object has a prototype, which is itself an object. When you try to access a property or method on an object, JavaScript first checks if that property exists on the object itself. If it doesn't, it looks up the prototype chain until it finds the property or reaches the end of the chain (null).
// This allows for method sharing and inheritance, enabling a powerful way to create objects and share functionality.

// factory function to create a Person object
function Person(name) {
    this.name = name;
}

// This method goes on the prototype, not on each instance (memory efficient)
// This is the equivalent of a class method in ES6
// good practice to define methods on the prototype
// so that all instances share the same method, rather than each instance having its own copy.
// This is how JavaScript achieves inheritance and method sharing.
Person.prototype.sayHello = function () {
  return `Hello, I'm ${this.name}`;
};


const alice = new Person("Saeid");


console.log(alice.sayHello()); // Hello, I'm Saeid
