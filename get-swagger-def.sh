#!/usr/bin/env bash
set -euo pipefail

token="${1:-${CLASH_ROYALE_TOKEN:-}}"
output="${2:-src/main/resources/api.yaml}"
if [[ -z "$token" ]]; then
  printf 'Usage: %s <bearer-token> [output-file]\nOr set CLASH_ROYALE_TOKEN.\n' "$0" >&2
  exit 1
fi

curl --fail-with-body --silent --show-error \
  --header "Authorization: Bearer ${token}" \
  --output "$output" \
  'https://api.clashroyale.com/v1/'
