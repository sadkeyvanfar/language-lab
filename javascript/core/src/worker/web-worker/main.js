// This is the main thread script that creates a Web Worker and communicates with it.
// A Web Worker is a way to run JavaScript in the browser on a background thread,
// separate from the main UI thread. Communication happens via postMessage() and onmessage
// (message passing, no shared memory by default).
// Workers run concurrently
// No access to DOM
// Useful for CPU-heavy tasks (e.g., image processing, JSON parsing)

// Create the worker
const worker = new Worker('worker.js');

document.getElementById('start').addEventListener('click', () => {
  console.log("Main: sending start to worker");
  worker.postMessage("start");
});

// Listen for messages from the worker
worker.onmessage = function (e) {
  console.log("Main: received message from worker:", e.data);
  document.getElementById("output").textContent = e.data;
};
