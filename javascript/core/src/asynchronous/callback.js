// Example of a callback function in JavaScript
// A callback function is a function that is passed as an argument to another function and is executed
// after some operation is completed. Callbacks are commonly used in asynchronous programming to handle
// operations that take time, such as fetching data from a server or reading files.
// javascript is single-threaded, meaning it can only execute one operation(Task) at a time.
// However, it can handle asynchronous operations using callbacks, promises, or async/await.
// This allows JavaScript to perform non-blocking operations, enabling it to continue executing other code
// while waiting for the asynchronous operation to complete. without blocking the main thread.

// the is only one thread in JavaScript, which is the main thread. and runs both in this example for both tasks.
// if task in includes os level task like reading a file or making a network request, it will be offloaded to the OS
// or environment (like Node.js) to handle it asynchronously.


function fetchData(callback) {
    // Simulating an asynchronous operation using setTimeout
  setTimeout(() => {
    callback("Data is ready!"); // this also tun by the main thread
  }, 1000); // When the timeout expires, the callback is queued, and the event loop runs it.
  console.log("Fetching data... and is not blocked the thread"); // This will log immediately
}

fetchData(result => {
  console.log(result); // prints after 1 sec
});

// Single callback
// This function simulates an asynchronous operation that can either succeed or fail.
// It takes a single callback function that handles both success and error cases.
// The callback function receives two arguments: an error (if any) and the data (if successful).
function fetchDataWithErrorHandling(callback) {
  const shouldFail = Math.random() < 0.5;

  setTimeout(() => {
    if (shouldFail) {
      callback(new Error("Failed to fetch data."), null);
    } else {
      callback(null, "Here's your data!");
    }
  }, 1000);
}



// Use the function
// Single callback handles both success and error
fetchDataWithErrorHandling((err, data) => {
  if (err) {
    console.error("Error:", err.message);
  } else {
    console.log("Success:", data);
  }
});
