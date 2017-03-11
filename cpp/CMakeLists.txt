cmake_minimum_required(VERSION 3.1)
set(CMAKE_VERBOSE_MAKEFILE ON)
set(CMAKE_BUILD_TYPE Debug)

project(demo VERSION 1.0.0 LANGUAGES CXX)

set(CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_STANDARD 11)

include_directories("${CMAKE_SOURCE_DIR}/../include")
include_directories("/usr/lib64/jvm/java/include")

add_library(hello SHARED hello.cpp)
#target_link_libraries(hello)
install(TARGETS hello DESTINATION "${CMAKE_BINARY_DIR}/../dist/lib64/")

