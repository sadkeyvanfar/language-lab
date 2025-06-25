// worker.js
onmessage = function (e) {
  console.log("Worker: received", e.data);

  // Simulate heavy task
  let result = 0;
  for (let i = 0; i < 1e8; i++) {
    result += i;
  }

  // Send the result back to main thread
  postMessage(`Done! Computation result: ${result}`);
};
