#!/bin/bash

function run(){
	echo "-------------------------"
	echo "file: $1"
	file=$1
	java -cp bin:lib/java-cup-11a-runtime.jar:lib/commons-cli-1.2.jar run.Main $1 > $tmp
	rtval=$?
	echo "return value = $rtval"
	if [ $rtval -eq 0 ]
	then
		echo "pass"
		cat $tmp
	else
		cat $tmp
	fi
	echo "_________________________"
}

if [ $# -ge 1 ]
then
	target=$1
else
	target=`pwd`
fi
tmp=`mktemp`
if [ -d $target ]
then
	for file in $target/*.spl
	do
		run $file
		echo
	done
elif [ -f $target ]
then
	run $target
fi
rm $tmp
