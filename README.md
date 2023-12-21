# Devple

## 소개

 - 구조 : `MSA`
 - 언어 : `Java`, `TypeScript`
 - 프레임워크 : `Spring-Boot`, `ReactJS`
 - IDEA : `Intelli J`

## 환경

 - `docker` 멀티 컨테이너

## 구동

  - `.env` 파일을 생성해 필수 값을 설정합니다.
    - `ROOT_PASSWORD` : 데이터베이스 루트 계정 패스워드
    - `COMMON_NAME` : Db 스키마
    - `COMMON_SECRET` : Database 스키마 패스워드, Config 패스워드
    - `CONFIG_REPO` : 설정을 저장할 깃헙 레파지토리 URL
    - 실행 명령어 : `$ docker-compose up`
       