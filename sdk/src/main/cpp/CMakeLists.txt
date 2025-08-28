cmake_minimum_required(VERSION 3.13)

project(lib_native LANGUAGES C CXX)

set(OpenCV_DIR "${CMAKE_CURRENT_SOURCE_DIR}/opencv2/sdk/native/jni")

if(CMAKE_SYSTEM_NAME STREQUAL "Android")
    add_link_options(LINKER:-z,max-page-size=16384)
endif()

if(CMAKE_SYSTEM_NAME STREQUAL "Android")
    if(ANDROID_ABI STREQUAL "arm64-v8a" OR ANDROID_ABI STREQUAL "x86_64")
        foreach(var CMAKE_C_FLAGS CMAKE_CXX_FLAGS)
            string(REPLACE "-marm" "" ${var} "${${var}}")
            string(REPLACE "-mno-thumb" "" ${var} "${${var}}")
            set(${var} "${${var}}" CACHE STRING "" FORCE)
        endforeach()
    endif()
endif()

add_subdirectory(armneon2x86sse)
add_subdirectory(eigen)
add_subdirectory(protobuf)
add_subdirectory(caffe)
add_subdirectory(libyuv)
add_subdirectory(crossplatform)

add_library(data SHARED CardRecognizer-jni.cpp)

target_link_libraries(data
        PRIVATE
        crossplatform
        libyuv
        log
        z
)
