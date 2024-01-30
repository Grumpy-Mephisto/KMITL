CC := g++
SRC_DIR := .
LIB_DIR := Libs
BUILD_DIR := build
BIN_DIR := bin
EXECUTABLE := OpenGLFirstProject.out

SRC := $(wildcard $(SRC_DIR)/*.cpp) $(wildcard $(LIB_DIR)/*.cpp)
OBJ := $(patsubst $(SRC_DIR)/%.cpp, $(BUILD_DIR)/%.o, $(SRC))

CFLAGS := -Wall -std=c++11
LDFLAGS := -lglfw -lGLEW -lGL

# ANSI color codes
GREEN := \033[0;32m
RED := \033[0;31m
NC := \033[0m  # No Color

.PHONY: all clean

all: clean $(BIN_DIR)/$(EXECUTABLE)
	@echo "${GREEN}Build completed successfully.${NC}"

$(BIN_DIR)/$(EXECUTABLE): $(OBJ)
	@mkdir -p $(@D)
	@echo "${GREEN}Linking: $^ -> $@${NC}"
	@$(CC) $^ -o $@ $(LDFLAGS)

$(BUILD_DIR)/%.o: $(SRC_DIR)/%.cpp
	@mkdir -p $(@D)
	@echo "${GREEN}Compiling: $< -> $@${NC}"
	@$(CC) $(CFLAGS) -c $< -o $@

clean:
	@echo "${RED}Cleaning...${NC}"
	@rm -rf $(BUILD_DIR)
	@rm -rf $(BIN_DIR)

run: all
	@echo "${GREEN}Running: ${BIN_DIR}/${EXECUTABLE}${NC}"
	@./$(BIN_DIR)/$(EXECUTABLE)
