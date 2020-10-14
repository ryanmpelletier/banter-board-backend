# Banter Board
Banter made easy. Effectively banter with friends at scale. 

https://github.com/ryanp102694/banter-board-backend.git

# Setup

## Installing MongoDB on Mac with Homebrew
1. brew update
2. brew tap mongodb/brew
3. brew install mongodb-community@4.2
4. echo 'export PATH="/usr/local/opt/mongodb-community@4.2/bin:$PATH"' >> ~/.zshrc

To Run
* mongod --config /usr/local/etc/mongod.conf

Or have it start as a service
* brew services start mongodb/brew/mongodb-community@4.2

## Building and running the Spring Boot .jar
1. ./gradlew clean build
2. java -jar build/libs/banter-board-backend-0.0.1-SNAPSHOT.jar