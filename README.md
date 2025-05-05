# Kafka Consumer

- Consumer needs following things to consume the message

  > Topic
    - The topic on which message will be produced [It can be stored in **constants**] <br><br>
      
  > Bootstrap-Server
    - Server on which kafka messages are send [It can be defined in **application properties**] <br><br>

  > Message
    - **simple message**
      - value deserializer [It can be defined in **application properties**] <br>
        Property: "spring.kafka.consumer.value-deserializer" <br>
     
    - **key/value pair message** [RECOMMENDED]:
      - key & value deserializer [It can be defined in **application properties**] <br>
        Property: "spring.kafka.consumer.key-deserializer" <br>
        Property: "spring.kafka.consumer.value-deserializer" <br><br>

  > **Consumer Group**
     - list of consumers group together in order to work with messages
       Property: "spring.kafka.consumer.group-id" <br><br>

  > Idempotent Consumer
    - It is useful in consuming duplicate messages which happens generally due to exceptions or failures
      Property: "spring.kafka.consumer.??" <br>

  > Transactions
    -  scenarios where events are very critical like banking systems. send duplicate messages is nightmare. To avoid this transactions are introduced <br>
    - It can be enable with the below property. It accepts READ_UNCOMMITTED [**Default**], READ_COMMITTED **RECOMMENDED**], <br>
      Property: "spring.kafka.consumer.isolation-level" <br>
