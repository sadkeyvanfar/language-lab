// This function simulates an asynchronous operation that can either succeed or fail.
// It takes two callback functions as arguments: one for success and one for error handling.
// The function uses `setTimeout` to simulate a delay, and randomly decides whether to call
// the success or error callback after 1 second.
// This pattern is often used in JavaScript to handle asynchronous operations without blocking the main thread.
// This code demonstrates how to split a callback function into separate success and error handlers.
// This approach is useful for handling asynchronous operations where you want to manage success and error cases separately
function fetchData(onSuccess, onError) {
  const shouldFail = Math.random() < 0.5;

  setTimeout(() => {
    if (shouldFail) {
      onError(new Error("Failed to fetch data."));
    } else {
      onSuccess("Here's your data!");
    }
  }, 1000);
}

// Define the success handler
function handleSuccess(data) {
  console.log("Success:", data);
}

// Define the error handler
function handleError(err) {
  console.error("Error:", err.message);
}

// Use the function
fetchData(handleSuccess, handleError);




// Single callback
// This function simulates an asynchronous operation that can either succeed or fail.
// It takes a single callback function that handles both success and error cases.
// The callback function receives two arguments: an error (if any) and the data (if successful).
function fetchDataOneCallBack(callback) {
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
fetchDataOneCallBack((err, data) => {
  if (err) {
    console.error("Error:", err.message);
  } else {
    console.log("Success:", data);
  }
});
