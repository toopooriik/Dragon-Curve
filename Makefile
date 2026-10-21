SRC_DIR = src
OUT_DIR = out
MAIN_CLASS = vector.Main
SOURCES = $(shell find $(SRC_DIR) -name "*.java")
ARGS ?=
.PHONY: run clean compile

compile:
	mkdir -p $(OUT_DIR)
	javac -d $(OUT_DIR) -sourcepath $(SRC_DIR) $(SOURCES)

run: compile
	java -cp $(OUT_DIR) $(MAIN_CLASS) $(ARGS)

clean:
	rm -rf $(OUT_DIR)

