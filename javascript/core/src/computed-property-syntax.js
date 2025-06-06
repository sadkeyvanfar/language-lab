// [] Computed Property Syntax in JavaScript
// Computed property names allow you to define object properties using expressions.
// This feature is particularly useful when you want to use dynamic keys.
// Example: Using a variable as a key in an object literal

// Variable as Key
const key = "name";
const obj = {
  [key]: "Alice"  // becomes { "name": "Alice" }
};

console.log(obj); // { name: 'Alice' }

// Expression as Key
const suffix = "Id";
const user = {
  ["user" + suffix]: 123
};

console.log(user.userId); // 123

// With Symbols (like Symbol.iterator)
const myIterable = {
  [Symbol.iterator]() {
    return {
      next() {
        return { done: true };
      }
    };
  }
};
