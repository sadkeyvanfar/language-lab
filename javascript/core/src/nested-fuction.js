// Example of a nested function in JavaScript
// Inner function can "remember" values from the outer function's scope. (Closure)

function outer() {
  console.log("I'm the outer function");

  function inner() {
    console.log("I'm the inner function");
  }

  inner(); // Call inner from outer
}

outer();
