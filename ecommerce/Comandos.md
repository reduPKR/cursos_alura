#### Startar no windows  
.\bin\windows\zookeeper-server-start.bat config\zookeeper.properties  
.\bin\windows\kafka-server-start.bat config\server.properties  
#### Gerar nova partição  
bin\windows\kafka-topics.bat --alter --zookeeper localhost:2181 --topic ECOMMERCE_NEW_ORDER --partitions 3  
#### Exibir dados dos grupos  
bin\windows\kafka-consumer-groups.bat --all-groups --bootstrap-server localhost:9092 --describe  
#### Exibir topicos  
bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092  

