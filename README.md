# Authentication Function

## Refinement requirements

- Combine URL, AppID, password, and timestamp into one string
- Encrypt the string through an encryption algorithm to generate token
- Splice token, AppID, and timestamp into the URL to form a new URL
- Parse the URL to get token, AppID, timestamp and other information
- Take out AppID and corresponding password from storage
- Determine whether the token expires or not according to the timestamp
- Verify that the two tokens match
