# 2021-Software-Architecture
## 2021 2학기 SA 수업 term project

***

### 프로그램 실행 순서
1. Broker
2. Garage Door
3. Smart Home 

### 통신용 json 프로토콜 구조
```javascript
{
  "id": "보내는쪽 id",
  "receiver": "받는쪽 id",
  "data": "보낼 명령"
}
```
