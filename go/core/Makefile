.PHONY: build run clean deps-check test

build:
	go build -o bin/app ./cmd

run:
	go run ./cmd

test:
	go test ./...

deps-check:
	go mod tidy
	go mod verify

clean:
	rm -rf bin/
