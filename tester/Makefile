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


all:
	@clear
	python my_signature/display_signature.py
	@echo "$(MAGENTA)Running tests...$(DEF_COLOR)"
	@python -m pytest scenario_tester.py -v
	@echo "$(GREEN)All tests completed successfully!$(DEF_COLOR)"