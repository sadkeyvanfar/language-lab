# Shell Language Samples

This directory contains sample programs written in different Shells.

## Prerequisites

- Bash, Zsh, Fish, Dash shells installed (depending on what you want to run/test)
- [Bats](https://github.com/bats-core/bats-core) installed for running tests

## Running scripts

Navigate to the specific shell folder and run your script:
```bash
bash bin/my-script.sh
# or
zsh bin/my-script.zsh
```

#Running tests

Run all tests using Bats:
```bash
bats tests/
```

## Configuration

Configuration files for scripts are located in the config/ directory. For example, config/bash.conf contains settings for Bash scripts.
