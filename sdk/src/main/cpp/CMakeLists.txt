cmake_minimum_required(VERSION 3.4.1)

# Стандарт C++
set(CMAKE_CXX_STANDARD 14)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Глобально для всех SHARED библиотек
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -Wl,-z,max-page-size=16384")

# OpenCV
set(OpenCV_DIR "${CMAKE_CURRENT_SOURCE_DIR}/opencv2/sdk/native/jni")
# find_package(OpenCV REQUIRED)

# Подмодули
add_subdirectory(armneon2x86sse)
add_subdirectory(eigen)
add_subdirectory(protobuf)
add_subdirectory(caffe)
add_subdirectory(libyuv)
add_subdirectory(crossplatform)

# JNI библиотека
add_library(data SHARED CardRecognizer-jni.cpp)

target_link_libraries(data
        crossplatform
        libyuv
        log
        z
        # ${OpenCV_LIBS}
)
