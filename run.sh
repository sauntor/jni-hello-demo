#!/bin/bash
mkdir include > /dev/null 2>&1
mkdir -p dist/classes > /dev/null 2>&1
mkdir -p dist/lib64 > /dev/null 2>&1
javac -verbose -d ./dist/classes -h ./include java/src/*/*.java
cd ./cpp
cmake -DCMAKE_VERBOSE_MAKEFILE=ON .
make clean
make install
cd - > /dev/null 2>&1;
jar cvfm ./dist/hello.jar ./java/Manifest.txt -C dist/classes .
echo -e "\n\n\n\n====================[[JNI测试: 开始]]===========\n\n"
cd dist
java -cp hello.jar lc.Launcher
cd - > /dev/null 2>&1
echo -e "\n\n====================[[JNI测试: 结束]]===========\n\n"
