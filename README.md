# Kotlin pagination

### `/message/listing`

* **limit** - maximum number of messages. Number. Required
* **offset** - offset from first message in results. Number. Required
* since_id - message id. UUID. Optional
* till_id - message id. UUID. Optional

Possible cases:

 - `limit / offset - top` messages with positive offset & limitations
 - `limit / offset / since` - messages since id, in descending order with limit
 - `limit / offset / till` - messages till id, in descending order with limit
 - `limit / offset / since / till` - messages in range (since, till)
 
### `/message/create`

* **author** - author of message. String. Required
* **text** - message text. String. Required
