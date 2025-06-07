// A callback in JavaScript is: A function passed as an argument to another function,
// and called later—either synchronously or asynchronously.
// This allows for flexible and reusable code, enabling functions to be executed after certain operations are completed.// Example of a callback in JavaScript
// A callback is a function that is passed as an argument to another function.

// Simple Synchronous Callback
function greet(name, callback) {
  console.log("Hello, " + name);
  callback();
}

function sayGoodbye() {
  console.log("Goodbye!");
}

greet("Alice", sayGoodbye);

// Asynchronous Callback (e.g., with setTimeout)
function fetchData(callback) {
  setTimeout(() => {
    console.log("Data fetched");
    callback();
  }, 1000);
}

fetchData(() => {
  console.log("Processing data...");
});

// callback hell
// Callback hell is a situation where multiple nested callbacks make code hard to read and maintain.
// Hard to read and maintain — this is why Promises and async/await were introduced.
getUser(userId, function (user) {
  getPosts(user.id, function (posts) {
    getComments(posts[0].id, function (comments) {
      // ...
    });
  });
});
