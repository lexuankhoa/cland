# Cland - Spring Boot

Ứng dụng quản lý bất động sản dùng Spring Boot 2.7, Spring MVC, Spring Security, JSP/Tiles và H2 Database.

## Yêu cầu

- Java 8 trở lên (đã kiểm thử với Java 17).
- Maven đã có sẵn trong thư mục .tools.
- Maven cache được lưu tại D:\cland\.m2, không tải dependency vào ổ C.

## Build

~~~powershell
cd D:\cland
$env:JAVA_HOME = 'C:\Program Files\Java\jdk-17'
.\.tools\apache-maven-3.9.9\bin\mvn.cmd clean package
~~~

## Chạy Spring Boot

~~~powershell
cd D:\cland
& 'C:\Program Files\Java\jdk-17\bin\java.exe' -jar target\cland.war
~~~

Mở http://localhost:8080/index

Trang quản trị: http://localhost:8080/auth/login

- Username: admin
- Password: 1

H2 tự tạo schema và dữ liệu mẫu UTF-8 khi khởi động. Database nằm tại D:\cland\data.