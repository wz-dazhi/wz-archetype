### 安装脚手架到本地maven仓库
```shell script
mvn clean install
```
### 使用脚手架
```shell script
mvn archetype:generate -DgroupId=com.wz.test -DartifactId=test-archetype-111 -Dversion=0.0.1.RELEASE -Dpackage="com.wz.test" -DarchetypeGroupId=com.wz -DarchetypeArtifactId=api-admin-archetype -DarchetypeVersion=0.0.1.RELEASE -X -DarchetypeCatalog=local
``` 
### 描述
* -DgroupId: 目标组
* -DartifactId: 目标项目名称
* -Dversion: 目标版本
* -Dpackage: 目标包名
* -DarchetypeGroupId: 模板组
* -DarchetypeArtifactId: 模板项目
* -DarchetypeVersion: 模板版本
* -DarchetypeCatalog=local: 本地模式
* -X: debug