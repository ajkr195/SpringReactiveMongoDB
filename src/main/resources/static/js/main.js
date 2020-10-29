	var evtSource = new EventSource("http://localhost:8080/pets");
	evtSource.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var table = document.getElementById("pets-table");
		var row = table.insertRow(1);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);

		var shelterAddress = data.address1 + '<br/>' + data.city + '<br/> '
				+ data.state;

		
		cell1.innerHTML = '<tr><td>' + data.id + '</td>';
		cell2.innerHTML = '<td>' + data.name + '</td>';
		cell3.innerHTML = '<td>' + data.email + '</td>';
		cell4.innerHTML = '<td>' + shelterAddress + '</td>';
		cell5.innerHTML = '<td> <img class="img-thumbnail" src="' + data.thumbnailImage + '" width="120" height="90"/> </td></tr>';

	}