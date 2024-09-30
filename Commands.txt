# Location: 
C:\kafka_2.13-3.5.0\bin\windows

-- OLD WAY
# Zookeeper Server
zookeeper-server-start.bat ../../config/zookeeper.properties

# Kafka Server
> Start
kafka-server-start.bat ../../config/server.properties

- Multiple Servers
kafka-server-start.bat ../../config/server-1.properties
kafka-server-start.bat ../../config/server-2.properties
kafka-server-start.bat ../../config/server-3.properties

> Stop
- To enable manual shutdown [controlled.shutdown.enable=true]
kafka-server-stop.bat

# Create Topic
- It create topic on specific kafka broker server [--bootstrap-server localhost:9092] but u can provide multiple with comma seperated
kafka-topics.bat --create --topic <TOPIC-NAME> --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3

# Alter Topic config
kafka-config.bat --bootstrap-server localhost:9092 --alter --entity-type topics --entity-name <TOPIC NAME> --add-config min.insync.replicas=2 

# List down all available topics
- multiple kafka broker can be provided with comma seperated
kafka-topics.bat --list --bootstrap-server localhost:9092

# Describe topics
kafka-topics.bat --describe --bootstrap-server localhost:9092
kafka-topics.bat --describe --topic <TOPIC-NAME> --bootstrap-server localhost:9092

# Delete topics
- To enable manual delete [delete.topic.enable=true]
kafka-topics.bat --delete --topic <TOPIC-NAME> --bootstrap-server localhost:9092

Note: Delete all the logs in case exception on server startup happens

# Produce a message
kafka-console-producer.bat --broker-list localhost:9092 --topic <TOPIC-NAME>
kafka-console-producer.bat --broker-list localhost:9092 --topic <TOPIC-NAME> --property "parse.key=true" --property "key.separator=:"

# Consume a message
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <TOPIC-NAME>
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <TOPIC-NAME> --from-beginning
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <TOPIC-NAME> --from-beginning --property "key.separator=:" --property "print.key=true"
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <TOPIC-NAME> --from-beginning --property "key.separator=:" --property "print.value=true"





-- NEW WAY [NOT WORKING]
# Kafka Cluster
- It generates id for the kafka cluster
kafka-storage.bat random-uuid
<ID>

- use the id generated above and format it
kafka-storage.bat format -t <ID> -c ../../config/kraft/server.properties

# Kafka Server
kafka-server-start.bat ../../config/kraft/server.properties

-- Multiple servers
kafka-storage.bat random-uuid
<ID>

kafka-storage.bat format -t <ID> -c ../../config/kraft/server-1.properties
kafka-storage.bat format -t <ID> -c ../../config/kraft/server-2.properties

kafka-server-start.bat ../../config/kraft/server-1.properties
kafka-server-start.bat ../../config/kraft/server-2.properties

-- NOT WORKING WITH KRAFT MODE
