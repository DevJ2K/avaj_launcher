COMPIL_FILE = sources.txt
SCENARIO = scenario.txt

########################################
########## COLORS
DEF_COLOR = \033[0;39m
GRAY = \033[1;90m
RED = \033[1;91m
GREEN = \033[1;92m
YELLOW = \033[1;93m
BLUE = \033[1;94m
MAGENTA = \033[1;95m
CYAN = \033[1;96m
WHITE = \033[1;97m


all: compil run

compil:
	@find * -name "*.java" > $(COMPIL_FILE)
	@echo "$(YELLOW)Compiling all java files from '$(COMPIL_FILE)'...$(DEF_COLOR)"
	@javac @$(COMPIL_FILE) -d target
	@echo "$(GREEN)Compilation finished successfully!$(DEF_COLOR)"
	@echo "$(GRAY)You can now run the simulator with 'make run' or specify a scenario file with 'make run SCENARIO=<your_scenario_file>'$(DEF_COLOR)"


run:
	java -cp target com.devj2k.avaj.launcher.Simulator $(SCENARIO)
# cat simulation.txt

test:
	@echo "$(MAGENTA)Running tests...$(DEF_COLOR)"
	@make -C tester
	@echo "$(GREEN)All tests completed successfully!$(DEF_COLOR)"

clean:
	rm -f $(COMPIL_FILE)
	rm -rf target
	rm -rf simulation.txt
