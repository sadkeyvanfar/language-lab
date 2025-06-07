// This code demonstrates how to create a namespace in JavaScript
// A namespace is a container that allows you to group related variables and functions together,
// preventing naming conflicts and organizing code better.
const MyNamespace = {
  someValue: 42,
  sayHello() {
    console.log("Hello from MyNamespace");
  },
  utils: {
    sum(a, b) {
      return a + b;
    },
  },
};

// Usage:
MyNamespace.sayHello(); // Hello from MyNamespace
console.log(MyNamespace.someValue); // 42
console.log(MyNamespace.utils.sum(5, 7)); // 12
