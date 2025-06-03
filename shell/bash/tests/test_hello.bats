#!/usr/bin/env bats

load '../lib/helpers.sh'

@test "greet returns expected output" {
  result="$(greet 'Tester')"
  [ "$result" = "Hello Tester!" ]
}
