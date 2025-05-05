# Location:
> Windows
- C:\kafka_2.13-3.5.0\bin\windows

-- OLD WAY
# Zookeeper Server
> Start
- zookeeper-server-start.bat ../../config/zookeeper.properties

# Kafka Server
> Start
- kafka-server-start.bat ../../config/server.properties

> Run Multiple Servers
- kafka-server-start.bat ../../config/server-1.properties
- kafka-server-start.bat ../../config/server-2.properties
- kafka-server-start.bat ../../config/server-3.properties

> Stop
- To enable manual shutdown [controlled.shutdown.enable=true]
- kafka-server-stop.bat

# Create Topic
- It create topic on specific kafka broker server [--bootstrap-server localhost:9092] but u can provide multiple with comma seperated.

> Create
- kafka-topics.bat --create --topic <TOPIC-NAME> --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3

# Alter Topic config
> Update
- kafka-config.bat --bootstrap-server localhost:9092 --alter --entity-type topics --entity-name <TOPIC NAME> --add-config min.insync.replicas=2 

# List down all available topics
- multiple kafka broker can be provided with comma seperated

> List
- kafka-topics.bat --list --bootstrap-server localhost:9092

# Describe topics
> Describe
- kafka-topics.bat --describe --bootstrap-server localhost:9092
- kafka-topics.bat --describe --topic <TOPIC-NAME> --bootstrap-server localhost:9092

# Delete topics
- To enable manual delete [delete.topic.enable=true]
> Delete
- kafka-topics.bat --delete --topic <TOPIC-NAME> --bootstrap-server localhost:9092

Note: Delete all the logs in case exception on server startup happens

# Produce a message
> Produce Simple Message
- kafka-console-producer.bat --broker-list localhost:9092 --topic <TOPIC-NAME>

> Produce Key/Value Pair Message
- kafka-console-producer.bat --broker-list localhost:9092 --topic <TOPIC-NAME> --property "parse.key=true" --property "key.separator=:"

# Consume a message
> Consume Simple Message
- kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <TOPIC-NAME>

> Consume Simple Message From Beginning
- kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <TOPIC-NAME> --from-beginning

> Consume Key/Value pair Message
- kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <TOPIC-NAME> --from-beginning --property "key.separator=:" --property "print.key=true"

> Consume Key/Value pair Message From Beginning
- kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <TOPIC-NAME> --from-beginning --property "key.separator=:" --property "print.value=true"


-- NEW WAY [NOT WORKING]
# Kafka Cluster
- It generates id for the kafka cluster & use the id generated id in server creation

> Random Id
- kafka-storage.bat random-uuid
<ID>

> Server Unique Id
- kafka-storage.bat format -t <ID> -c ../../config/kraft/server.properties

# Kafka Server
> Kraft Mode
- kafka-server-start.bat ../../config/kraft/server.properties

> Random Id for Multiple servers
- kafka-storage.bat random-uuid
<ID>

> Multiple servers config
- kafka-storage.bat format -t <ID> -c ../../config/kraft/server-1.properties
- kafka-storage.bat format -t <ID> -c ../../config/kraft/server-2.properties

> Start Multiple servers
- kafka-server-start.bat ../../config/kraft/server-1.properties
- kafka-server-start.bat ../../config/kraft/server-2.properties

-- NOT WORKING WITH KRAFT MODE
