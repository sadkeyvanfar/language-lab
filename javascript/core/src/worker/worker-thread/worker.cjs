const { parentPort } = require('worker_threads');

// Mimic browser-style onmessage + postMessage
parentPort.on('message', (e) => {
  console.log("Worker: received", e);

  // Simulate heavy task
  let result = 0;
  for (let i = 0; i < 1e8; i++) {
    result += i;
  }

  // Send the result back to main thread
  parentPort.postMessage(`Done! Computation result: ${result}`);
});
