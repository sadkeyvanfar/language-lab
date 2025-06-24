// A Promise is an object that represents the eventual completion (or failure) of an asynchronous operation
// and its resulting value. Promises are used to handle asynchronous operations in a more manageable way
// compared to traditional callback functions. They allow you to write cleaner and more readable code by
// avoiding "callback hell" and providing a way to chain operations together.
// Promises still use callbacks under the hood — just in a more structured, predictable, and composable way.
function fetchData() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("Data is ready!");
    }, 1000);
      console.log("Fetching data... and is not blocked the thread"); // This will log immediately
  });
}

// instead of sending callbacks, we return a Promise and use resolve and reject to handle success and failure cases.
// so not inversion of control, we are in control of the flow of the code.
fetchData().then(result => {
  console.log(result);
}).catch(err => {
  console.error("Error:", err);
});


// | Traditional Callback                 | Promise-Based Function                    |
// | ------------------------------------ | ----------------------------------------- |
// | You **send** a callback in           | You **receive** a Promise back            |
// | Function decides how/when to call it | You decide how to handle it (via `.then`) |
// | Can be called multiple times (bug!)  | Runs once, guaranteed                     |
// | Hard to chain                        | Easy to chain (`.then().then()`)          |
// | Error handling is messy              | Centralized with `.catch()`               |
// | Inversion of control                 | You keep control                          |
