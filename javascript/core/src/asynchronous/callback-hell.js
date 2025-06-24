function getUser(id, success, failure) {
  setTimeout(() => {
    if (Math.random() < 0.9) {
      success({ id, name: "Alice" });
    } else {
      failure("User not found");
    }
  }, 500);
}

function getPosts(userId, success, failure) {
  setTimeout(() => {
    if (Math.random() < 0.9) {
      success([{ id: 101, title: "First Post" }]);
    } else {
      failure("No posts found for user " + userId);
    }
  }, 500);
}

function getComments(postId, success, failure) {
  setTimeout(() => {
    if (Math.random() < 0.9) {
      success([{ id: 201, text: "Nice post!" }]);
    } else {
      failure("No comments found for post " + postId);
    }
  }, 500);
}

function sendNotification(comments, success, failure) {
  setTimeout(() => {
    if (Math.random() < 0.9) {
      success("Notification sent to " + comments.length + " commenters.");
    } else {
      failure("Notification failed");
    }
  }, 500);
}

// CALLBACK HELL
getUser(1, function(user) {
  console.log("User:", user);
  getPosts(user.id, function(posts) {
    console.log("Posts:", posts);
    getComments(posts[0].id, function(comments) {
      console.log("Comments:", comments);
      sendNotification(comments, function(response) {
        console.log("Notification sent:", response);
      }, function(error) {
        console.error("Failed to send notification:", error);
      });
    }, function(error) {
      console.error("Failed to get comments:", error);
    });
  }, function(error) {
    console.error("Failed to get posts:", error);
  });
}, function(error) {
  console.error("Failed to get user:", error);
});
