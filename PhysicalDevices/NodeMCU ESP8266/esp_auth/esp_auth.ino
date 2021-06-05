#include <ArduinoJson.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>


String host = "http://192.168.172.5:8080/smarthome";//sửa host!
String mytoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImF1dGgwIn0.f1qc-fvEuI-k_PErFZuLYYXcX8QejY6Cy25a9xdz0QE";
// my token;

void setup () {

  Serial.begin(115200);
  WiFi.begin("Cafe 415.1", "JetBrain@LR300"); //sửa wifi!
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(4, OUTPUT);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting...");
  } 
}

void loop() {
  if (WiFi.status() == WL_CONNECTED) { 
    HTTPClient http; 
//---------------------------------------------------- led1      
    http.begin(host + "/api/v1/devices/1");  
    http.addHeader("Authorization", "Bearer " + mytoken);
    int httpCode = http.GET();                                  
    String payload;
    if (httpCode > 0) {  
     payload = http.getString();   
     Serial.println(payload);
    }

    http.begin(host + "/api/v1/devices/2");  
    http.addHeader("Authorization", "Bearer " + mytoken);
    int httpCode2 = http.GET();                                  
    String payload2;
    if (httpCode2 > 0) {  
     payload2 = http.getString();   
     Serial.println(payload2);
    }

   DynamicJsonDocument doc(1024), doc2(1024);
   deserializeJson(doc, payload);
   deserializeJson(doc2, payload2);
   bool bitValue = doc["bitValue"];
   bool bitValue2 = doc2["bitValue"];
   Serial.println(bitValue);
   if(bitValue == true) {
      digitalWrite(LED_BUILTIN, LOW);
      digitalWrite(5, HIGH);
   } else {
      digitalWrite(LED_BUILTIN, HIGH);
      digitalWrite(5, LOW);
   }

   if(bitValue2 == true) {
      digitalWrite(4, HIGH);
   } else {
      digitalWrite(4, LOW);
   }
  }
//  delay(200);/
}
//---------------------------------------------------- led2
//DynamicJsonDocument gui(1024);
// gui["id"]= 2;
// gui["deviceName"] = "nhietdo3";
// gui["deviceDescription"] = "led 2";
// gui["deviceType"] = true;
// gui["dataType"] = true;
// gui["bitValue"] = true;
// gui["decimalValue"] = 30;
// 
//  String s;
//  serializeJson(gui, s);
//  http.begin(host + "/glucose/api/v1/devices/2");  
//    http.addHeader("Authorization", "Bearer " + mytoken);  
//    http.addHeader("Content-Type", "application/json");         
//   int httpResponseCode = http.PUT(s); 
//   if(httpResponseCode>0){
//    String response = http.getString();    
//    //Serial.println(httpResponseCode);
//    Serial.println(response);          
//   }else{
//    Serial.print("Error on sending PUT Request: ");
//    Serial.println(httpResponseCode);
//   }    
//
//   http.begin(host + "/glucose/api/v1/devices/2");  
//    http.addHeader("Authorization", "Bearer " + mytoken);
//   httpCode = http.GET();                                  
//
//    if (httpCode > 0) {  
//     payload = http.getString();   
//     Serial.println(payload);      
//    }
//  }
//
//    delay(3000);
///}
