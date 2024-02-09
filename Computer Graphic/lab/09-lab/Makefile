# Compile and dependency generation rules
# Phony targets: all, clean, run
# Silence the 'clean' target
# Set the default goal to 'all'

CC := g++
SRC_DIR := .
LIB_DIR := Libs
BUILD_DIR := build
BIN_DIR := bin
EXECUTABLE := OpenGLFirstProject.out

SRC := $(wildcard $(SRC_DIR)/*.cpp) $(wildcard $(LIB_DIR)/*.cpp)
OBJ := $(SRC:$(SRC_DIR)/%.cpp=$(BUILD_DIR)/%.o)
DEP := $(OBJ:.o=.d)

# Compiler flags for C/C++ code
# Linker flags for OpenGL and GLFW libraries

# ANSI color codes
GREEN := \033[0;32m
RED := \033[0;31m
NC := \033[0m  # No Color

# Make all target, including cleanup and linking

# Link the executable from object files
	@mkdir -p $(@D)
	@echo "${GREEN}Linking: $^ -> $@${NC}"
	@$(CC) $^ -o $@ $(LDFLAGS)

# Compile each source file into an object file
	@mkdir -p $(@D)
	@echo "${GREEN}Compiling: $< -> $@${NC}"
	@echo "${RED}Dependencies: $(@:.o=.d)${NC}"
	@$(CC) $(CFLAGS) -c $< -o $@

# Clean the build and binary directories
	@echo "${RED}Cleaning...${NC}"
	@rm -rf $(BUILD_DIR) $(BIN_DIR)

# Run the executable
	@echo "${GREEN}Running: ${BIN_DIR}/${EXECUTABLE}${NC}"
	@./$(BIN_DIR)/$(EXECUTABLE)
