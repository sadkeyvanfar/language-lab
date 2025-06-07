// scope is determined in compile time, not runtime
// This code demonstrates the concept of scope in JavaScript, including function scope, block scope, and the use of eval and with statements.

// Function Scope: variables declared with 'var' are function-scoped, meaning they are accessible within the function they are declared in, but not outside of it.
function greet() {
  var message = "Hello!";
  console.log(message); // "Hello!"
}
// console.log(message); // ReferenceError

if (true) {
  var a = 5;
}
console.log(a); // 5 — leaked out of the block!

// Block Scope: variables declared with 'let' or 'const' are block-scoped, meaning they are only accessible within the block they are defined in
if (true) {
  let b = 10;
  const c = 20;
}
// console.log(b); // ReferenceError: b is not defined
// console.log(c); // ReferenceError: c is not defined



// two exceptions: eval and with
/* eval: allows you to execute a string of JavaScript code in the current scope. due to its dynamic nature, it can lead to security issues and performance problems, so it's generally discouraged in modern JavaScript.
   with: allows you to extend the scope chain for a block of code, but it's generally discouraged due to performance and readability issues */

let x = 10;
eval("x = x + 5");
console.log(x); // 15

// eval("let y = 20; console.log(y);"); // This will throw an error because 'let' is block-scoped and not accessible here
eval("var z = 30; console.log(z);"); // This will work because 'var' is function-scoped and accessible here
console.log(z); // 30

// eval("const a = 40; console.log(a);"); // This will throw an error because 'const' is block-scoped and not accessible here
eval("function test() { return 'Hello from eval'; } console.log(test());"); // This will work and log the message

const person = { name: "Alice", age: 30 };

with (person) {
  console.log(name); // "Alice"
  console.log(age);  // 30
}
