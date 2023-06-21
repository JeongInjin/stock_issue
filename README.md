작업환경 세팅

docker 설치
```kotlin
brew install docker
brew link docker
docker version
```



mysql 설치 및 실행
```kotlin
docker pull mysql
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 --name mysql mysql
docker ps
        
docker: no matching manifest for linux/arm64/v8 in the manifest list entries. 오류가 발생하시는분은
docker pull --platform linux/x86_64 mysql
```

my sql 데이터베이스 생성
```kotlin
docker exec -it mysql bash
mysql -u root -p
create database stock_example;
use stock_example;
```

