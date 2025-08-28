cmake_minimum_required(VERSION 3.4.1)
project(scan_card LANGUAGES C CXX)
add_link_options(LINKER:-z,max-page-size=16384)
