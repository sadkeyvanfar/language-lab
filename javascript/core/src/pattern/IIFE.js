// An Immediately Invoked Function Expression (IIFE) is a function that runs as soon as it is defined.
// It is often used to create a private scope, avoiding polluting the global namespace.
(function () {
  console.log("I ran immediately!"); // inner hidden scope
})();
