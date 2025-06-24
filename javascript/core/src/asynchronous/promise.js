// Example of a simple Promise in JavaScript
// A Promise is an object that represents the eventual completion (or failure) of an asynchronous operation
// and its resulting value. Promises are used to handle asynchronous operations in a more manageable way
// compared to traditional callback functions. They allow you to write cleaner and more readable code by
// avoiding "callback hell" and providing a way to chain operations together.
function fetchData() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("Data is ready!");
    }, 1000);
      console.log("Fetching data... and is not blocked the thread"); // This will log immediately
  });
}

fetchData().then(result => {
  console.log(result);
});
