// This code demonstrates the use of async/await in JavaScript to handle asynchronous operations.
// Async/await is a syntactic sugar built on top of Promises, making it easier
// to write and read asynchronous code. It allows you to write asynchronous code that looks synchronous,
// improving readability and maintainability.
// The `async` keyword is used to define an asynchronous function, and the `await` keyword is used to pause the execution of the function until a Promise is resolved or rejected.
async function fetchData() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("Data is ready!");
    }, 1000);
  });
}

async function main() {
  try {
    const result = await fetchData();
    console.log(result);
  } catch (err) {
    console.error("Error:", err.message);
  }
}

main();
