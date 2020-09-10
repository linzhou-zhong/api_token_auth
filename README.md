# Authentication Function

## Refinement requirements

- Combine URL, AppID, password, and timestamp into one string
- Encrypt the string through an encryption algorithm to generate token
- Splice token, AppID, and timestamp into the URL to form a new URL
- Parse the URL to get token, AppID, timestamp and other information
- Take out AppID and corresponding password from storage
- Determine whether the token expires or not according to the timestamp
- Verify that the two tokens match

# SparseArrays

- [Introduction](#Introduction)
- [Context](#Context)
- [Example](#Example)
- [Usage](#Usage)
- [Method](#Method)

## Introduction
This project is based on [Hackerrank's SparseArrays](https://www.hackerrank.com/challenges/sparse-arrays/problem).

## Context
There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings. Return an array of the results.

### Example

```python
# Standard Input
strings = ['ab', 'ab', 'abc']
queries = ['ab', 'abc', 'bc']
```

There are `2` instances of `ab`, `1` of `abc` and `0` of `bc`. For each query, add an element to the return array, `results = [2, 1, 0]`


## Usage

### Python 2.x
```commandline
python -m main abc,ab,ac
```

### Python 3.x

```commandline
python3 -m main abc,ab,ac
```

**Note**: We are allowed to enter at most 20 parameters and each one is separated by `,` without any `space`.

## Method

| Name of method | Time Complexity |
| :------------: | :-------------: |
| count_frequency_brute_force | O (n^2) |
| count_frequency_optimization | O (n) |
