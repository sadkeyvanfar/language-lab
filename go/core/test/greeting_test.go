package greeting_test

import (
    "testing"

    "language-lab/go/core/internal/greeting"
)

func TestHello(t *testing.T) {
    got := greeting.Hello("World")
    want := "Hello, World!"

    if got != want {
        t.Errorf("Hello() = %q, want %q", got, want)
    }
}
