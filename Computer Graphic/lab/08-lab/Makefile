CC := g++
SRC_DIR := .
LIB_DIR := Libs
BUILD_DIR := build
BIN_DIR := bin
EXECUTABLE := OpenGLFirstProject.out

SRC := $(wildcard $(SRC_DIR)/*.cpp) $(wildcard $(LIB_DIR)/*.cpp)
OBJ := $(SRC:$(SRC_DIR)/%.cpp=$(BUILD_DIR)/%.o)
DEP := $(OBJ:.o=.d)

CFLAGS := -Wall -Wextra -std=c++11 -MMD -MP
LDFLAGS := -lglfw -lGLEW -lGL

# ANSI color codes
GREEN := \033[0;32m
RED := \033[0;31m
NC := \033[0m  # No Color

.PHONY: all clean run

all: clean $(BIN_DIR)/$(EXECUTABLE)

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
	@rm -rf $(BUILD_DIR) $(BIN_DIR)

run: all
	@echo "${GREEN}Running: ${BIN_DIR}/${EXECUTABLE}${NC}"
	@./$(BIN_DIR)/$(EXECUTABLE)
