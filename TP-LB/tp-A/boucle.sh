#!/bin/bash
curl localhost:83?[1-500] > tmp
cat tmp | grep "Hello 1" | wc -l
cat tmp | grep "Hello 2" | wc -l


