cmake_minimum_required(VERSION 3.13)  # target/add_link_options доступны с 3.13
project(lib_native)

# Глобально для всех подпроектов/таргетов под Android:
if(CMAKE_SYSTEM_NAME STREQUAL "Android")
    # 16 KB page size
    add_link_options(LINKER:-z,max-page-size=16384)

    # (опционально для очень старых линкеров)
    # add_link_options(LINKER:-z,common-page-size=16384)
endif()

# ДАЛЕЕ — твои существующие настройки
set(OpenCV_DIR "${CMAKE_CURRENT_SOURCE_DIR}/opencv2/sdk/native/jni")

add_subdirectory(armneon2x86sse)
add_subdirectory(eigen)
add_subdirectory(protobuf)
add_subdirectory(caffe)
add_subdirectory(libyuv)
add_subdirectory(crossplatform)

add_library(data SHARED CardRecognizer-jni.cpp)

target_link_libraries(data
        crossplatform
        libyuv
        log
        z
)
