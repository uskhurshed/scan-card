cmake_minimum_required(VERSION 3.13) # target_link_options для INTERFACE — с 3.13
add_library(eigen INTERFACE)

target_include_directories(eigen INTERFACE
        ${CMAKE_CURRENT_SOURCE_DIR}
        ${CMAKE_CURRENT_SOURCE_DIR}/Eigen
)

target_link_options(eigen INTERFACE
        $<$<PLATFORM_ID:Android>:LINKER:-z,max-page-size=16384>
)
