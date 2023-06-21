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

redis 설치
```kotlin
docker pull redis
docker run --name myredis -d -p 6379:6379 redis

docker exec -it f5af56809d01 redis-cli
flushall
```

setnx cli test
```kotlin
setnx 1 lock
del 1
```
pub-sub cli test
```kotlin
터미널 2개 필요
subscribe ch1
publish ch1 hello
```


```kotlin
Lettuce
구현이 간단하다
spring data redis 를 이용하면 lettuce 가 기본이기때문에 별도의 라이브러리를 사용하지 않아도 된다.
spin lock 방식이기때문에 동시에 많은 스레드가 lock 획득 대기 상태라면 redis 에 부하가 갈 수 있다.

Redisson 
락 획득 재시도를 기본으로 제공한다.
pub-sub 방식으로 구현이 되어있기 때문에 lettuce 와 비교했을 때 redis 에 부하가 덜 간다.
별도의 라이브러리를 사용해야한다.
lock 을 라이브러리 차원에서 제공해주기 떄문에 사용법을 공부해야 한다.


실무에서는 ?
재시도가 필요하지 않은 lock 은 lettuce 활용
재시도가 필요한 경우에는 redisson 를 활용

```

```kotlin
Mysql
이미 Mysql 을 사용하고 있다면 별도의 비용없이 사용가능하다.
어느정도의 트래픽까지는 문제없이 활용이 가능하다.
Redis 보다는 성능이 좋지않다.

Redis
활용중인 Redis 가 없다면 별도의 구축비용과 인프라 관리비용이 발생한다.
Mysql 보다 성능이 좋다.

```