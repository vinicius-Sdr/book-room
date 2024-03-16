# Project Directory
PROJECT_DIR = .

# Project Name
PROJECT_NAME = book-room

# Directory where pom.xml is located
DIR = $(PROJECT_DIR)/$(PROJECT_NAME)

# Maven Arguments
MVN_ARGS =


# Docker Version
DOCKER_VERSION_LABEL_IMAGE = 1.0

# DOCKER NAMESPACE
DOCKER_NAMESPACE = book-room

# List of all Maven targets
MAVEN_TARGETS = java_build java_install

DOCKER_TARGETS = docker_build_quarto docker_build_servico_opcionais docker_build_clientes docker_build_reservas

# Check for dependencies
CHECK_MAVEN := $(shell command -v mvn 2> /dev/null)

ifeq ($(CHECK_MAVEN),)
$(error 'mvn' not found. Please install Maven before running this Makefile.)
endif

# Default target to run all targets
all: $(MAVEN_TARGETS)
	@echo "All targets executed successfully."

# Target to build the Java project
java_build:
	@echo "Building, verifying, and packaging the project..."
	cd $(DIR) && ./mvnw $(MVN_ARGS) package -DskipTests=true

# Target to install Maven artifacts
java_install: java_build
	@echo "Installing JAR files..."
	cd $(DIR) && ./mvnw $(MVN_ARGS) install

# Target to clean build artifacts
clean:
	@echo "Cleaning up build artifacts..."
	cd $(DIR) && ./mvnw clean

docker_build_quarto: java_build
	@echo "Running build of the book-room (quarto) docker image..."
	docker build \
		-f $(DIR)/quarto/Dockerfile \
		--build-arg VERSION=$(DOCKER_VERSION_LABEL_IMAGE) \
		--build-arg JAR_FILE=$(DIR)/quarto/target/quarto-1.0-SNAPSHOT.jar \
		-t $(DOCKER_NAMESPACE)/$(PROJECT_NAME)-quarto:$(DOCKER_VERSION_LABEL_IMAGE) \
		-t $(DOCKER_NAMESPACE)/$(PROJECT_NAME)-quarto:latest .

docker_build_servico_opcionais: java_build
	@echo "Running build of the book-room (servico-opcionais) docker image..."
	docker build \
		-f $(DIR)/servico-opcionais/Dockerfile \
		--build-arg VERSION=$(DOCKER_VERSION_LABEL_IMAGE) \
		--build-arg JAR_FILE=$(DIR)/servico-opcionais/target/servico-opcionais-1.0-SNAPSHOT.jar \
		-t $(DOCKER_NAMESPACE)/$(PROJECT_NAME)-servico-opcionais:$(DOCKER_VERSION_LABEL_IMAGE) \
		-t $(DOCKER_NAMESPACE)/$(PROJECT_NAME)-servico-opcionais:latest .

docker_build_clientes: java_build
	@echo "Running build of the book-room (clientes) docker image..."
	docker build \
		-f $(DIR)/clientes/Dockerfile \
		--build-arg VERSION=$(DOCKER_VERSION_LABEL_IMAGE) \
		--build-arg JAR_FILE=$(DIR)/clientes/target/clientes-1.0-SNAPSHOT.jar \
		-t $(DOCKER_NAMESPACE)/$(PROJECT_NAME)-clientes:$(DOCKER_VERSION_LABEL_IMAGE) \
		-t $(DOCKER_NAMESPACE)/$(PROJECT_NAME)-clientes:latest .

docker_build_reservas: java_build
	@echo "Running build of the book-room (reservas) docker image..."
	docker build \
		-f $(DIR)/reservas/Dockerfile \
		--build-arg VERSION=$(DOCKER_VERSION_LABEL_IMAGE) \
		--build-arg JAR_FILE=$(DIR)/reservas/target/reservas-1.0-SNAPSHOT.jar \
		-t $(DOCKER_NAMESPACE)/$(PROJECT_NAME)-reservas:$(DOCKER_VERSION_LABEL_IMAGE) \
		-t $(DOCKER_NAMESPACE)/$(PROJECT_NAME)-reservas:latest .

docker_build_all: $(DOCKER_TARGETS)
	@echo "All docker images built successfully."

# subir container postgres book-room quarto
docker_run_postgres_quarto:
	@echo "Running build of the book-room quarto (postgres) docker image..."
	cd $(DIR)/docker &&  docker-compose -f docker-compose-postgres.yaml -p book-room-quarto-db --env-file env/.env-book-room-quarto-db up -d --force-recreate --remove-orphans

#parar container postgres book-room quarto
docker_stop_postgres_quarto:
	@echo "Running build of the book-room quarto (postgres) docker image..."
	cd $(DIR)/docker &&  docker-compose -f docker-compose-postgres.yaml -p book-room-quarto-db --env-file env/.env-book-room-quarto-db down --remove-orphans --volumes --rmi all