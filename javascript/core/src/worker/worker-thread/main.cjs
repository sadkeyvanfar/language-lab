// This is the main thread script that creates a worker thread
// and communicates with it using the Node.js worker_threads module.
const { Worker } = require('worker_threads');
const path = require('path');

// Create the worker
const worker = new Worker(path.resolve(__dirname, 'worker.cjs'));

console.log("Main: sending start to worker");
worker.postMessage("start");

// Listen for messages from the worker
worker.on('message', (data) => {
  console.log("Main: received message from worker:", data);
  worker.terminate(); // Clean up after done
});
