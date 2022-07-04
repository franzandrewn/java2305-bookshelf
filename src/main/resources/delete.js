function sendDelete() {
	var path = window.location.pathname.split('/');
	var id = path[path.length - 1]
	fetch('localhost:8081/book/' + id, {
		method: 'DELETE'
	})
}