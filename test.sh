#!/bin/bash

function run(){
	echo "========================"
	echo "file: $1"
	file=$1
	java -cp bin:src/java-cup-11a-runtime.jar run.Main $1 > $tmp
	if [ $? -eq 0 ]
	then
		echo "pass"
	else
		cat $tmp
	fi
	echo "========================"
}

if [ $# -eq 1 ]
then
	dir=$1
else
	dir=`pwd`
fi
tmp=`mktemp`
for file in $dir/*.spl
do
	run $file
	echo
done
rm $tmp
