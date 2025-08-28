cmake_minimum_required(VERSION 3.13)
project(scan_card LANGUAGES C CXX)
add_link_options(LINKER:-z,max-page-size=16384)
set(OpenCV_DIR "${CMAKE_CURRENT_SOURCE_DIR}/opencv2/sdk/native/jni")
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
