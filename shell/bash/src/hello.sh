#!/usr/bin/env bash

# Source config
source "$(dirname "$0")/../config/bash.conf"

log_msg "Script started"

# Source helper functions
source "$(dirname "$0")/../lib/helpers.sh"

# Call the greet function
greet "World"
