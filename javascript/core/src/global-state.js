
// This code demonstrates how to use a global object to maintain state across different parts of an application.
// global object in Node.js is global, in browsers it's window
global.count = 10;
console.log(global.count);

global.increment = function() {
    global.count++;
    console.log("Count incremented to:", global.count);
};

global.increment();

// console.log(window === this); // true in global scope, in browsers
console.log(global === this); // false, because top-level `this` is not `global`
