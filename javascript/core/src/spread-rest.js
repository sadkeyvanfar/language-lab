// ...
// Spread — "Expand values"
// Rest — "Collect values"

// Spread operator expands an iterable into individual elements.
// Spread operator is used in function calls, array literals, and object literals.
// Spread operator is denoted by `...` before the iterable.

// In Arrays
const arr1 = [1, 2, 3];
const arr2 = [...arr1, 4, 5];
console.log(arr2); // [1, 2, 3, 4, 5]

// In Function Calls
function sum(a, b, c) {
  return a + b + c;
}

const nums = [10, 20, 30];
console.log(sum(...nums)); // 60

// With Strings
const word = "Hi!";
const letters = [...word];

console.log(letters); // ['H', 'i', '!']

// In Objects
const user = { name: "Alice", age: 30 };
const updated = { ...user, age: 31 };

console.log(updated); // { name: "Alice", age: 31 }


// Rest operator collects individual elements into an array.
// Rest operator is used in function parameters and destructuring assignments.
// Rest operator is denoted by `...` before the parameter name in function definitions or destructuring assignments.

// In Function Parameters
function logAll(first, ...rest) {
  console.log(first); // 1
  console.log(rest);  // [2, 3, 4]
}

logAll(1, 2, 3, 4);

// In Array Destructuring
const [a, ...restArray] = [10, 20, 30, 40];
console.log(a);     // 10
console.log(restArray);  // [20, 30, 40]

// In Object Destructuring
const userObject = { id: 1, name: "Ali", role: "admin" };
const { id, ...restObject } = userObject;

console.log(id);   // 1
console.log(restObject); // { name: 'Ali', role: 'admin' }
