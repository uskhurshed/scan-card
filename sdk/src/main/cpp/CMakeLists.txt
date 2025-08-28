# было: cmake_minimum_required(VERSION 3.4.1)
cmake_minimum_required(VERSION 3.13)  # нужно для add_link_options
project(scan_card LANGUAGES C CXX)

set(OpenCV_DIR "${CMAKE_CURRENT_SOURCE_DIR}/opencv2/sdk/native/jni")

# ✅ Глобально для всех таргетов в этом CMake и во всех add_subdirectory()
# (альтернатива ниже для старых версий)
add_link_options(-Wl,-z,max-page-size=16384)
# или ещё точнее:
# add_link_options(LINKER:-z,max-page-size=16384)

add_subdirectory(armneon2x86sse)
add_subdirectory(eigen)
add_subdirectory(protobuf)
add_subdirectory(caffe)
add_subdirectory(libyuv)
add_subdirectory(crossplatform)

add_library(data SHARED CardRecognizer-jni.cpp)

# ❌ УДАЛИ это: target_link_options(native PRIVATE "-Wl,-z,max-page-size=16384")
# потому что таргета 'native' нет

target_link_libraries(data
        PRIVATE
        crossplatform
        libyuv
        log
        z
)
