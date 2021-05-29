# Auth

Link: http://localhost:8080/api/v1/auth

## POST:

> Generates an access token for authorizing a user.

### Request:

#### Header:

> Content-Type: application/json

#### Body:

```json
{
	"username": "admin",
	"password": "123",
	"accountType": 1
}
```

### Response:

Status code: 200

#### Body:

```json
{
  "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImF1dGgwIn0.f1qc-fvEuI-k_PErFZuLYYXcX8QejY6Cy25a9xdz0QE"
}
```

Status code: 400

#### Body:

```json
"Invalid Sign In Info!"
```

## PUT:

> Updates password for an existing user.

### Request:

#### Header:

> Content-Type: application/json

#### Body:

```json
{
	"username": "admin",
	"oldPassword": "123",
	"newPassword": "1234",
	"accountType": 1
}
```

### Response:

Status code: 200

#### Body:

```text
Password changed!
```

Status code: 400

#### Body:

```text
Invalid info!
```

---

___Note for below APIs:___

> If token is invalid, the status code is 401 (UNAUTHORIZED) and body is: "Invalid token!"

---

# Devices

Link: http://localhost:8080/api/v1/devices

## GET:

> Retrieves information of all the devcies.

### Request:

#### Header:

> Content-Type: application/json
>
> Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImF1dGgwIn0.f1qc-fvEuI-k_PErFZuLYYXcX8QejY6Cy25a9xdz0QE

### Response:

Status code: 200

#### Body:

```json
[
  {
    "id": 1,
    "deviceName": "light",
    "deviceDescription": "Đèn Điện",
    "deviceType": false,
    "dataType": false,
    "bitValue": true,
    "decimalValue": 0.0
  },
  {
    "id": 2,
    "deviceName": "fan",
    "deviceDescription": "Quạt",
    "deviceType": false,
    "dataType": false,
    "bitValue": false,
    "decimalValue": 0.0
  }
]
```

## GET:

Link: http://localhost:8080/api/v1/devices/1

> Retrieves information of a single device instance with the specified ID.

### Request:

#### Header:

> Content-Type: application/json
>
> Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImF1dGgwIn0.f1qc-fvEuI-k_PErFZuLYYXcX8QejY6Cy25a9xdz0QE

### Response:

Status Code: 200

#### Body:

```json
{
  "id": 1,
  "deviceName": "light",
  "deviceDescription": "Đèn Điện",
  "deviceType": false,
  "dataType": false,
  "bitValue": true,
  "decimalValue": 0.0
}
```

## POST:

> Creates devices.

### Request:

#### Header:

> Content-Type: application/json
>
> Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImF1dGgwIn0.f1qc-fvEuI-k_PErFZuLYYXcX8QejY6Cy25a9xdz0QE

#### Body:

```json
{
  "deviceName": "air conditional",
  "deviceDescription": "Máy lạnh",
  "deviceType": false,
  "dataType": false,
  "bitValue": false,
  "decimalValue": 0.0
}
```

### Response:

Status code: 201

```text
Created new device!
```

## PUT:

Link: http://localhost:8080/api/v1/devices/1

> Updates information of an existing device instance.

### Request:

#### Header:

> Content-Type: application/json
>
> Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImF1dGgwIn0.f1qc-fvEuI-k_PErFZuLYYXcX8QejY6Cy25a9xdz0QE

#### Body:

```json
{
  "deviceName": "light",
  "deviceDescription": "Đèn Điện",
  "deviceType": false,
  "dataType": false,
  "bitValue": true,
  "decimalValue": 0.0
}
```

### Response:

Status code: 200

#### Body:

```text
Updated devices!
```

## DELETE:

> Deletes an existing device instance.  

### Request:

#### Header:

> Content-Type: application/json
>
> Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImF1dGgwIn0.f1qc-fvEuI-k_PErFZuLYYXcX8QejY6Cy25a9xdz0QE

### Response:

Status code: 200

```text
Deleted device!
```

---

# Device Logs

Link: http://localhost:8080/api/v1/devices/logs

## GET:

> Retrieves the last 10 logs for a device with the specified ID.

Link: http://localhost:8080/api/v1/devices/logs/1

### Request:

#### Header:

> Content-Type: application/json
>
> Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImF1dGgwIn0.f1qc-fvEuI-k_PErFZuLYYXcX8QejY6Cy25a9xdz0QE

### Response:

Status code: 200

#### Body:

```json
[
  {
    "id": 21,
    "deviceId": 1,
    "bitValue": true,
    "decimalValue": 0.0,
    "dateRecord": "2021-05-18",
    "timeRecord": "17:32:12"
  },
  {
    "id": 20,
    "deviceId": 1,
    "bitValue": true,
    "decimalValue": 0.0,
    "dateRecord": "2021-05-18",
    "timeRecord": "17:31:43"
  },
  {
    "id": 18,
    "deviceId": 1,
    "bitValue": false,
    "decimalValue": 34.6,
    "dateRecord": "2021-05-18",
    "timeRecord": "17:27:23"
  },
  {
    "id": 17,
    "deviceId": 1,
    "bitValue": false,
    "decimalValue": 32.7,
    "dateRecord": "2021-05-18",
    "timeRecord": "17:26:20"
  },
  {
    "id": 16,
    "deviceId": 1,
    "bitValue": false,
    "decimalValue": 38.4,
    "dateRecord": "2021-05-18",
    "timeRecord": "17:26:14"
  },
  {
    "id": 15,
    "deviceId": 1,
    "bitValue": false,
    "decimalValue": 31.5,
    "dateRecord": "2021-05-18",
    "timeRecord": "17:26:09"
  },
  {
    "id": 14,
    "deviceId": 1,
    "bitValue": false,
    "decimalValue": 29.6,
    "dateRecord": "2021-05-18",
    "timeRecord": "17:26:02"
  },
  {
    "id": 13,
    "deviceId": 1,
    "bitValue": false,
    "decimalValue": 5.3,
    "dateRecord": "2021-05-18",
    "timeRecord": "17:25:51"
  },
  {
    "id": 12,
    "deviceId": 1,
    "bitValue": false,
    "decimalValue": 18.0,
    "dateRecord": "2021-05-18",
    "timeRecord": "17:25:45"
  },
  {
    "id": 11,
    "deviceId": 1,
    "bitValue": false,
    "decimalValue": 19.0,
    "dateRecord": "2021-05-18",
    "timeRecord": "17:25:39"
  }
]
```



---

___NOTE:___

#### About Auth

- We have only 2 account:
  - admin (for app)
  - device (for controller - hardware)
- accountType:
  - false: device
  - true: admin

#### About Devices:

- deviceType:
  - false: input (such as: light, fan, ...)
  - true: output (such as: sensor)
- dataType:
  - false: bit (such as light only has 2 status: on and of)
  - true: decimal (such as temperature sensor: 30.5)
- bitValue:
  - true: on
  - false: off
- decimalValue:
  - 29.8
