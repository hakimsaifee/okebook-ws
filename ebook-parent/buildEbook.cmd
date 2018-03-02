echo "Are you sure you want to build Ebook?"
pause
call ./mvnw.cmd install -DskipTests
pause