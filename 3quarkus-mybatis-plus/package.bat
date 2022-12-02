@echo offecho "设置临时环境变量"
set JAVA_HOME=D:\Programs\Java\jdk-17.0.4
set MAVEN_HOME=D:\Programs\Apache\apache-maven-3.6.2
set CLASSPATH=.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar
set Path=%JAVA_HOME%\bin;%JAVA_HOME%\jar\bin;%MAVEN_HOME%\bin
mvn clean package -Pnative --settings D:\Programs\Apache\apache-maven-3.5.4\conf\settings.xml -DskipTests=true