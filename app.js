var stompClient = null;

function connect() {
    var socket = new SockJS('http://localhost:8080/websocket', null, {sessionId: 128});
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/test-topic', function (message) {
			$("#greetings").append("<tr><td>" + message.body + "</td></tr>");
        });
        // stompClient.send("/topic/test-topic", {}, 'a');
    });
}

function send() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}
